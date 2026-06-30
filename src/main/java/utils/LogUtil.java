package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class LogUtil {

	private static PrintStream printStream;

	static {

		try {

			File logFolder = new File("logs");

			if (!logFolder.exists()) {
				logFolder.mkdir();
			}

			String fileName = "logs/API_Log_" + System.currentTimeMillis() + ".log";

			printStream = new PrintStream(new FileOutputStream(fileName));

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static PrintStream getPrintStream() {

		return printStream;
	}
}
