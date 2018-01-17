package com.kubrynski.contracts.contractsdemo.events;

import java.lang.invoke.MethodHandles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "com.kubrynski.contracts:contracts-demo:+:stubs", workOffline = true)
public class SystemEventHandlerTest {

	private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	StubFinder stubFinder;

	@Autowired
	SystemEventsNotifier systemEventsNotifier;

	Message receivedMessage;

	@Test
	public void name() {
		// given
		systemEventsNotifier.subscribeToSystemEvents().subscribe(getMessageHandler());

		// when
		stubFinder.trigger("leaderElectedMessage");

		// then
		assertThat(receivedMessage.getPayload()).isNotInstanceOf(String.class);
	}

	private MessageHandler getMessageHandler() {
		return message -> {
			LOG.info("Received message: {}", message);
			receivedMessage = message;
		};
	}
}
