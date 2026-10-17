package org.com.consumer;

import lombok.Data;
import org.com.core.PubSubSystem;
import org.com.enums.Topics;


@Data
public class ConcreteConsumer implements ConsuemrI {

private String name;

public  ConcreteConsumer(String name){
	this.name=name;
	
}

@Override
public void consume (Topics topic, String message) {
	
	System.out.println ("CONSUMED ::: By"+this.name+":Message on " + topic + "|||" + message);
	
	
}

@Override
public boolean subscribe (Topics topic, PubSubSystem system) {
	return system.subsribe (this,topic);
}

@Override
public boolean unSubscribe (Topics topic, PubSubSystem system) {
	return system.unsubsribe (this,topic);
}
}
