package com.abysshal.wow.calendar.http;

import java.io.IOException;

import com.abysshal.minaserver.http.HttpServer;

public class WowHttpServer {

	public static HttpServer httpServer;
	public static int port = 8080;

	public static boolean start(String[] args) {

		for (String str : args) {
			if (str.startsWith("-p") && str.length() >= 3) {
				String tmp = str.substring(2);
				try {
					port = Integer.valueOf(tmp);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		System.out.println("Get http port:" + port);

		System.out.println("Start http server");
		httpServer = new HttpServer();
		httpServer.setEncoding("UTF-8");
		httpServer.setHttpHandler(new WowHttpServerHandler());

		try {
			httpServer.run(port);
			System.out.println("Started");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean stop() {
		if (httpServer != null) {
			httpServer.stop();
		}
		return true;
	}
}
