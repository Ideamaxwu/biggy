package com.helpal.datar.rbiggy.clients.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

public class WebServer {
	protected int serverPort = 9092;

	public WebServer(int port) {
		this.serverPort = port;
	}

	public void start() throws IOException {
		HttpServerProvider provider = HttpServerProvider.provider();
		HttpServer httpserver = provider.createHttpServer(new InetSocketAddress(9092), 100);
		httpserver.createContext("/getInfo", new WebServer(this.serverPort).new GetInfoResponseHandler());
		httpserver.setExecutor(null);
		httpserver.start();
		System.out.println("Web Server started.");
	}

	public class GetInfoResponseHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			//receive request
			URI url = httpExchange.getRequestURI();
			System.out.println("Recived from client: " + url);
			String requestMethod = httpExchange.getRequestMethod();
			System.out.println("requestMethod: " + requestMethod);
			
			if(requestMethod.equalsIgnoreCase("OPTIONS")){
				System.out.println("NO received data for OPTIONS!");
			}
			if(requestMethod.equalsIgnoreCase("POST")){
				InputStream requestBody = httpExchange.getRequestBody();
				String result = new BufferedReader(new InputStreamReader(requestBody)).lines()
						.collect(Collectors.joining(System.lineSeparator()));
				System.out.println("Received data: " + result);
			}
			
			//send response
			String response = "{\"status\":\"success\",\"info\":\"this is info from server.\"}";
			Headers responseHeaders = httpExchange.getResponseHeaders();
			responseHeaders.set("Content-Type", "text/html;charset=utf-8");
			responseHeaders.set("Access-Control-Allow-Origin", "*");
			responseHeaders.set("Access-Control-Allow-Headers", "Content-Type");
			responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
			httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes("UTF-8").length);
			OutputStream responseBody = httpExchange.getResponseBody();
			OutputStreamWriter writer = new OutputStreamWriter(responseBody, "UTF-8");
			writer.write(response);
			writer.close();
			responseBody.close();

		}
	}
}