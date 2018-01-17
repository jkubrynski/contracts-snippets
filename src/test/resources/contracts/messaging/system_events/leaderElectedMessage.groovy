package contracts.messaging.system_events

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	label 'leaderElectedMessage'
	input {
		triggeredBy('triggerLeaderElectedMessage()')
	}
	outputMessage {
		sentTo('systemEvents')
		body('''{ "eventType":"LEADER_ELECTED","content":"elected_host=prod-demo-1" }''')
		headers {
			messagingContentType(applicationJson())
		}
	}
}