package com.azuga.client;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.azuga.common.Message;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import scala.concurrent.duration.Duration;

public class App {

	public static void main(String[] args) {
		final ActorSystem system = ActorSystem.create("client", ConfigFactory.load().getConfig("ClientConfig"));
		final ActorSelection selection = system
				.actorSelection("akka.tcp://ServerApplication@127.0.0.1:5150/user/ServerActor");
		System.out.println("Started the Client");
		system.scheduler().schedule(Duration.create(1, SECONDS), Duration.create(1, SECONDS), new Runnable() {
			public void run() {
				selection.tell(new Message("sunny"), ActorRef.noSender());
			}
		}, system.dispatcher());
	}
}
