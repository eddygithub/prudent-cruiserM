package com.prudent.data.customerData.es;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="com.prudent.office.data.store.es.repository")
public class ElasticSearchConfig {

	/**
	 * Set up embedded Elasticsearch server
	 * @return
	 */
	@Bean
	public ElasticsearchOperations establElasticsearchTemplate(){
		return new ElasticsearchTemplate(NodeBuilder.nodeBuilder().local(true).node().client());
	}
}
