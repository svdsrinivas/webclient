package com.example.websocketclient;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

@SpringBootTest
class WebsocketclientApplicationTests {

	@Test
	void contextLoads() {
		WebSocketClient client = new ReactorNettyWebSocketClient();
		client.execute(URI.create("ws://localhost:8080/messages"),
						session -> session.send(
										Mono.just(session.textMessage("message")))
								.thenMany(session.receive()
										.map(WebSocketMessage::getPayloadAsText)
										.log())
								.then())
				.block(Duration.ofSeconds(20L));
	}

}
