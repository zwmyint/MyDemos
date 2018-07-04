package wait.play.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import wait.play.utils.LogUtils;

public class FileSocketServer {
	private String uploadPath;
	private ExecutorService executorService;
	private ServerSocket ss = null;
	private int port;

	public FileSocketServer(int port, String uploadPath) {
		this.port = port;
		this.uploadPath = uploadPath;
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 50);
	}

	public void start() throws Exception {
		ss = new ServerSocket(port);
		LogUtils.debug("File Socket Server Start!");
		try {
			while (true) {
				if (!ss.isClosed()) {
					Socket socket = ss.accept();
					System.out.println("########\t"+ socket.getInetAddress().getHostAddress() + " Connected");
					executorService.execute(new SocketTask(socket, uploadPath));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
			LogUtils.debug("File Server isClosed:" + ss.isClosed());
		}
	}

	public void quit() {
		try {
			ss.close();
			LogUtils.debug("File Socket Server Stop.");
		} catch (IOException e) {
			e.printStackTrace();
			LogUtils.error("File Socket Server Stop Error.\t" + e.getMessage());
		}
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public ServerSocket getSs() {
		return ss;
	}

	public void setSs(ServerSocket ss) {
		this.ss = ss;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
