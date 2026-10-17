package org.com.repo;

import org.com.consumer.ConsuemrI;
import org.com.enums.Topics;
import org.com.exception.PubSubException;
import org.com.producer.ProducerI;

import java.util.*;

public class Registry {

private final Map< Topics, Set< ConsuemrI > > registry;


public Registry () {
	this.registry = new HashMap<> ();
}

public boolean subscribe (Topics topics, ConsuemrI consumer) {
	
	registry.computeIfAbsent (topics, (topic) -> new HashSet<> ()).add (consumer);
	
	return true;
	
	
}


public boolean unSubscribe (Topics topics, ConsuemrI consumer) {
	
	Set< ConsuemrI > consumers = registry.get (topics);
	
	if ( consumers == null ) {
		throw new PubSubException (
				"This topic doesn't exist: " + topics
		);
	}
	
	if ( !consumers.remove (consumer) ) {
		throw new PubSubException (
				"Consumer " +consumer.getClass ().getName ()
						+ " is not subscribed to topic " + topics
		);
	}
	
	return true;
}

public List< ConsuemrI > getAllConsumerOfTopic(Topics topic){
	
	return new ArrayList<> (registry.get (topic).stream().toList ());
}


}
