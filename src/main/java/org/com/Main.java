package org.com;

import org.com.consumer.ConcreteConsumer;
import org.com.consumer.ConsuemrI;
import org.com.core.PubSubSystem;
import org.com.enums.Topics;
import org.com.producer.MessageProducer;
import org.com.producer.ProducerI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
public static void main (String[] args) {
	
	
	PubSubSystem system=new PubSubSystem ();
	
	ConsuemrI consumer1=new ConcreteConsumer ("CONSUMER 1");
	
	system.subsribe (consumer1,Topics.SPORTS);
	system.subsribe (consumer1,Topics.MOVIES);
	
	ConsuemrI consumer2=new ConcreteConsumer ("CONSUMER 2");
	
	system.subsribe (consumer2,Topics.SPORTS);
	
	
	
	
	
	MessageProducer producer=new MessageProducer ();
	
	producer.start (system);
	
	System.out.println ("***********************");
	
	
	system.unsubsribe (consumer1,Topics.SPORTS);
	system.unsubsribe (consumer1,Topics.MOVIES);
	
	producer.start (system);
	
	
}
}