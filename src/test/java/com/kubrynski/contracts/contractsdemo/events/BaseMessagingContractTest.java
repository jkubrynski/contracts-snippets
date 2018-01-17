package com.kubrynski.contracts.contractsdemo.events;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMessageVerifier
public abstract class BaseMessagingContractTest {

	@Autowired
	SystemEventsNotifier systemEventsNotifier;

	protected void triggerLeaderElectedMessage() {
		Map<String, String> message = new HashMap<>();
		message.put("eventType", "LEADER_ELECTED");
		message.put("content", "elected_host=prod-demo-1");
		systemEventsNotifier.systemEventsChannel().send(MessageBuilder.withPayload(message).build());
	}
}