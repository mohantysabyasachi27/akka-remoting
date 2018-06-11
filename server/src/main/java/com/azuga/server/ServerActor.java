package com.azuga.server;

import com.azuga.common.Message;

import akka.actor.UntypedAbstractActor;

public class ServerActor extends UntypedAbstractActor {
	@Override
	public void onReceive(Object message) {

		if (message instanceof Message) {
			Message recMsg = (Message) message;
			System.out.println("Received Message: " + recMsg.toString());
		} else {
			System.out.println("UnHandled Message Received");
			unhandled(message);
		}
	}
}
