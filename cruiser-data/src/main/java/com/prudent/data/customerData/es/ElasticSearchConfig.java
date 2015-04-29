package com.prudent.data.customerData.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.prudent.data.customerData.es.repository")
public class ElasticSearchConfig {

	/**
	 * Set up embedded Elasticsearch server
	 * 
	 * @return
	 */
	@Bean
	public ElasticsearchOperations elasticsearchTemplate() {
		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", "eddy-es-cluster1")
				.put("client.transport.sniff", "true").build();

		TransportClient transportClient = new TransportClient(settings);
		Client client =transportClient.addTransportAddress(new InetSocketTransportAddress("localhost", 9300));

		return new ElasticsearchTemplate(client);
	}
}
