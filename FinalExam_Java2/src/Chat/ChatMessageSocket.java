package Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextPane;

public class ChatMessageSocket {
	private Socket socket;
	private JTextPane txtMessageBoard;
	private PrintWriter out;
	private BufferedReader reader;
	
	public ChatMessageSocket(Socket socket, JTextPane txtMessageBoard) throws IOException {
		super();
		this.socket = socket;
		this.txtMessageBoard = txtMessageBoard;
		
		out = new PrintWriter(socket.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		receiver();
	}
	
	public void receiver() {
		Thread th = new Thread() {
			public void run() {
				while(true) {
					try {
						String line = reader.readLine();
						if(line != null) {
							txtMessageBoard.setText(txtMessageBoard.getText() +"\n"+ line);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		th.start();
	}
	
	public void send(String message) {
		txtMessageBoard.setText(txtMessageBoard.getText() + "\nMe: "+ message);
		out.println(message);
		out.flush();
	}
	
	public void close() {
		out.close();
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
