package com.prudent.data.customerData.es;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
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
	public ElasticsearchOperations elasticsearchTemplate(
			TransportClient transportClient) {
		Client client = transportClient
				.addTransportAddress(new InetSocketTransportAddress(
						"localhost", 9300));
		return new ElasticsearchTemplate(client);
	}

	@Bean
	public Settings settings() {
		ImmutableSettings.Builder builder = ImmutableSettings.settingsBuilder();
		Map<String, String> buildSettings = new HashMap<String, String>();
		buildSettings.put("cluster.name", "eddy-es-cluster1");
		buildSettings.put("client.transport.sniff", "true");

		Settings settings = builder.put(buildSettings).build();
		return settings;
	}

	@Bean
	public TransportClient transportClient(Settings settings) {
		TransportClient transportClient = new TransportClient(settings);
		return transportClient;
	}
}
