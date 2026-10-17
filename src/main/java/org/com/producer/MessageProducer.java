package org.com.producer;

import org.com.core.PubSubSystem;
import org.com.enums.Topics;

public class MessageProducer implements  ProducerI{

@Override
public void sendMessage (PubSubSystem system) {
	
	system.produce(Topics.SPORTS, "1 Sachin scored 100");
	system.produce(Topics.SPORTS, "2 Kohli scored 100");
	system.produce(Topics.SPORTS, "3 Dhoni scored 50");
	system.produce(Topics.SPORTS, "4 Rohit scored 150");
	system.produce(Topics.SPORTS, "5 Bumrah took 5 wickets");
	
	system.produce(Topics.MOVIES, "1 Sachin scored 100");
	system.produce(Topics.TECH, "1 Kohli scored 100");
	system.produce(Topics.SPORTS, "6 Dhoni scored 50");
	system.produce(Topics.SPORTS, "7 Rohit scored 150");
	system.produce(Topics.SPORTS, "8 Bumrah took 5 wickets");
	
	

}

public  void start(PubSubSystem system){
	
	this.sendMessage (system);
}


}
