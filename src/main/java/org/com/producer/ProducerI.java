package org.com.producer;

import org.com.core.PubSubSystem;
import org.com.enums.Topics;

public interface ProducerI {
  
  void sendMessage(PubSubSystem system);
}
