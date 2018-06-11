package com.azuga.server;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

public class ServerApplication {
	private ActorSystem system;

	public ServerApplication() {
		system = ActorSystem.create("ServerApplication", ConfigFactory.load().getConfig("ServerConfig"));
		@SuppressWarnings("unused")
		ActorRef actor = system.actorOf(Props.create(ServerActor.class), "ServerActor");
	}
}
