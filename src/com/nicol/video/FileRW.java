package com.nicol.video;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.util.EncodingUtils;

import android.webkit.WebView.FindListener;

public class FileRW {

	// 读文件
	public static String readSDFile(String fileName) {
		String res = "";
		try {
			File file = new File(fileName);

			FileInputStream fis = new FileInputStream(file);

			int length = fis.available();

			byte[] buffer = new byte[length];
			fis.read(buffer);

			res = EncodingUtils.getString(buffer, "UTF-8");

			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return res;
	}

	// 写文件
	public static void writeSDFile(String fileName, String write_str) {
		try {
			File file = new File(fileName);
			if(!file.exists())
				file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			byte[] bytes = write_str.getBytes();
			fos.write(bytes);
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
