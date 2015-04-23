package com.prudent.office.file.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=FileServiceApplication.class)
public class FileServiceApplicationTest {
	@Autowired
	@Qualifier("filesFiles")
	private MessageChannel files;
	
	@Autowired
	@Qualifier("stamped")
	private PollableChannel output;
	
	@Value("#{ systemProperties['user.name'] }")
	private String systemUserName;
	
	String fileName = "/tmp/si/test1.txt";
	@Test
	public void gotFile() {
		files.send(createTextMessage());
		Message<?> out = output.receive();
		assertThat(out.getHeaders().get("sender"), is(systemUserName));
		assertThat(out.getPayload(), is(fileName));
	}

	Message<?> createTextMessage(){
		return MessageBuilder.withPayload(fileName).build();
	}
}
