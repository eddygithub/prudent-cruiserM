package com.prudent.data.customerDB.gf.repository;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.CacheFactory;

public class GFMain {

	public static void main(String[] args) {
		Cache cache = new CacheFactory()
			.set("locators", "localhost[55221]")
			.set("mcast-port", "0")
			.set("log-level", "error")
			.create();
		System.out.println();
	}

}
