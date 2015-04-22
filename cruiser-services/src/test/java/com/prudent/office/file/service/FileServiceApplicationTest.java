package com.prudent.office.file.service;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=FileServiceApplication.class)
public class FileServiceApplicationTest {
	@Autowired
	@Qualifier("files")
	private DirectChannel files;
	
	@Autowired
	@Qualifier("output")
	private DirectChannel output;
	
	@Test
	public void gotFile() {
		Assert.assertTrue(files.send(createTextMessage()));
	}

	
	Message<?> createTextMessage(){
		return MessageBuilder.withPayload("/tmp/si/test1.txt").build();
	}
}
