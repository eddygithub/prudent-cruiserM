package com.prudent.data.customerData.datafeed;

import java.io.File;
import java.nio.file.Paths;

import org.apache.tika.Tika;

public class JsonFileCrawler {

	public static void main(String[] args) throws Exception{
		Tika tika = new Tika();
		
			String content = tika.parseToString(new File("/Users/zhue2/Desktop/Test.docx"));
			System.out.println(content);
	}
}
