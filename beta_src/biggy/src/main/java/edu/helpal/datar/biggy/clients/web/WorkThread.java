package edu.helpal.datar.biggy.clients.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WorkThread implements Runnable {

	protected Socket clientSocket = null;
    protected String serverText = null;

    public WorkThread(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText = serverText;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            outputStream.write(("HTTP/1.1 200 OK\n\n" +
                    this.serverText).getBytes());
            inputStream.close();
            outputStream.flush();
            System.out.println("Recieving Request... - " + time);
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
