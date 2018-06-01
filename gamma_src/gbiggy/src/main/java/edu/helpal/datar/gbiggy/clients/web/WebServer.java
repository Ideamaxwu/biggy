package edu.helpal.datar.gbiggy.clients.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer implements Runnable{
    protected int          serverPort   = 9090;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public WebServer(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(!this.isStopped){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new Thread(
                    new WorkThread(
                            clientSocket, "biggy, build your own BDMS.")
            ).start();
        }
    }
    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
            System.out.println("biggy Web Server starting...");
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 9090", e);
        }
    }
}