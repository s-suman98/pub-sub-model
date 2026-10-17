package org.com.consumer;

import org.com.core.PubSubSystem;
import org.com.enums.Topics;

public interface ConsuemrI {
	
	void  consume(Topics topic,String message);
	
	boolean subscribe(Topics topic, PubSubSystem system);

    boolean unSubscribe(Topics topic, PubSubSystem system);
}
