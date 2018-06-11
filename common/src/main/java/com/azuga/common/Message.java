package com.azuga.common;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	public Message(String data) {
		this.data = data;
	}

	private final String data;

	@Override
	public String toString() {
		return "Message [data=" + data + "]";
	}

}
