package com.prudent.office.file.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Configuration
@Component("com.prudent.office.file.service")
@ImportResource("classpath:/spring/integration-context.xml")
public class FileServiceApplication {

}
