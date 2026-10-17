package org.com.core;

import org.com.consumer.ConsuemrI;
import org.com.enums.Topics;
import org.com.repo.Registry;

import java.util.List;

public class PubSubSystem {


private Registry registry;


public PubSubSystem () {
	this.registry = new Registry ();
}


public boolean unsubsribe (ConsuemrI consuemr, Topics topic) {
	
	return registry.unSubscribe (topic, consuemr);
}

public boolean subsribe (ConsuemrI consuemr, Topics topic) {
	
	return registry.subscribe (topic, consuemr);
}

public void produce (Topics topics, String message) {
	
	
	try {
		
		
		List< ConsuemrI > consumers = registry.getAllConsumerOfTopic (topics);
		
		for ( ConsuemrI c : consumers ) {
			c.consume (topics, message);
		}
		
	} catch ( Exception e ) {
		
		System.out.println ("BROKER::No consumer is Registerted form the topic " + topics);
	
		
		
	}
	
	
}

}
