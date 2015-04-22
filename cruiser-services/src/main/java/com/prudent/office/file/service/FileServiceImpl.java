package com.prudent.office.file.service;

import org.springframework.messaging.Message;

public class FileServiceImpl implements FileService {

	@Override
	public void process(Message<?> msg) {
		msg.getPayload().toString();
		System.out.println("Got file");
	}

}
