package wait.play.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import wait.play.socket.FileSocketServer;
import wait.play.utils.LogUtils;

@Service
public class FileSocketService {

	private final int PORT = 9887;
	private FileSocketServer fileSocketServer;
	private String uploadPath;

	public void start() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
		fixedThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				fileSocketServer = new FileSocketServer(PORT, uploadPath);
				try {
					fileSocketServer.start();
				} catch (Exception e) {
					e.printStackTrace();
					LogUtils.error("File Server Start Error! \t" + e.getMessage());
				}
			}

		});
	}

	public void stop() {
		if (null != fileSocketServer) {
			fileSocketServer.quit();
		}
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

}
