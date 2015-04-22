package com.prudent.office.file.service;

import org.springframework.messaging.Message;

public interface FileService {

	void process(Message<?> msg);
}