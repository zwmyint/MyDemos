package wait.play.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocket.READYSTATE;
import org.java_websocket.WebSocketImpl;
import org.springframework.stereotype.Service;

import wait.play.socket.ChatServer;
import wait.play.utils.LogUtils;

@Service
public class WebsocketService {
	private final int PORT = 8887;
	private ChatServer chartServer = null;

	public void start() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
		fixedThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				startWebSocket();
			}
		});
	}

	public void stop() {
		if (chartServer != null) {
			try {
				chartServer.stop();
				LogUtils.debug("Websocket Server Stop!");
			} catch (Exception e) {
				LogUtils.error(e.getMessage());
			}
		}
	}

	public void send(String message) {
		WebSocket connectToClient = chartServer.getClientSocket();
		if (null != connectToClient && connectToClient.getReadyState() == READYSTATE.OPEN) {
			connectToClient.send(message);
			LogUtils.debug("Send Message @: " + connectToClient.getRemoteSocketAddress().getAddress()
					+ " : " + message);
		}

	}

	private void startWebSocket() {
		WebSocketImpl.DEBUG = false;
		try {
			chartServer = new ChatServer(PORT);
			LogUtils.debug("ChatServer started on port: " + chartServer.getPort());
			chartServer.start();
			while (true) {

			}
		} catch (Exception ex) {
			LogUtils.error(ex.getMessage());
		}
	}

}
