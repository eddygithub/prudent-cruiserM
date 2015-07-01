package com.prudent.data.customerData.es;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;

public class ESClientFactory {
//TODO delete after playing with the client.  These code won't stay
	public Client nodeClient(){
		Client client = nodeBuilder().node().client();
		return client;
	}
	
	public static Client nodeClient(String clusterName, boolean isDataNode, boolean isLocal){
		Client client = nodeBuilder().clusterName(clusterName).client(isDataNode).local(isLocal).node().client();
		return client;
	}
	
	public void indexDoc(Client client, String index, String type, String id, String source){
		IndexRequestBuilder indexRequestBuilder = client.prepareIndex(index, type, id);
		indexRequestBuilder.setSource(source);
		IndexResponse response = indexRequestBuilder.execute().actionGet();
	}
}
