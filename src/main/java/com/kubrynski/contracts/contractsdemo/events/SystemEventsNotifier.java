package com.kubrynski.contracts.contractsdemo.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface SystemEventsNotifier {

	@Output("systemEvents_out")
	MessageChannel systemEventsChannel();

	@Input("systemEvents_in")
	SubscribableChannel subscribeToSystemEvents();

}
