package wait.play.socket;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import wait.play.utils.LogUtils;
import wait.play.utils.StreamTool;

public class SocketTask implements Runnable {

	private Socket socket;

	private String uploadPath;

	public SocketTask(Socket socket, String uploadPath) {
		this.socket = socket;
		this.uploadPath = uploadPath;
	}

	@Override
	public void run() {
		try {
			LogUtils.debug("accepted connenction from " + socket.getInetAddress() + " @ " + socket.getPort());
			PushbackInputStream inStream = new PushbackInputStream(socket.getInputStream());

			String head = StreamTool.readLine(inStream);
			LogUtils.debug(head);
			if (head != null) {

				String[] items = head.split(";");
				String filelength = items[0].substring(items[0].indexOf("=") + 1);
				String filename = items[1].substring(items[1].indexOf("=") + 1);
				Long id = System.currentTimeMillis();
				File file = null;
				int position = 0;
				String path = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date());
				File dir = new File(uploadPath + path);
				if (!dir.exists())
					dir.mkdirs();
				file = new File(dir, filename);
				if (file.exists()) {
					filename = filename.substring(0, filename.indexOf(".") - 1) + dir.listFiles().length
							+ filename.substring(filename.indexOf("."));
					file = new File(dir, filename);
				}

				OutputStream outStream = socket.getOutputStream();
				String response = "sourceid=" + id + ";position=" + position + "\r\n";

				outStream.write(response.getBytes());

				RandomAccessFile fileOutStream = new RandomAccessFile(file, "rwd");
				if (position == 0)
					fileOutStream.setLength(Integer.valueOf(filelength));
				fileOutStream.seek(position);
				byte[] buffer = new byte[1024];
				int len = -1;
				while ((len = inStream.read(buffer)) != -1) {
					fileOutStream.write(buffer, 0, len);
				}
				fileOutStream.close();
				inStream.close();
				outStream.close();
				file = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
			}
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

}
