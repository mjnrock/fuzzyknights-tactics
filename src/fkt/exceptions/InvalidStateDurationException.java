package fkt.exceptions;

import java.text.MessageFormat;

public class InvalidStateDurationException extends Exception {
	private static final long serialVersionUID = -4899375532510176762L;

	public InvalidStateDurationException() {
		super("Expiration must be: -1 OR between (0, 3,600,000]");
	}
	public InvalidStateDurationException(long expiration) {
		super(MessageFormat.format("Expiration must be [x = -1] OR [0 < x <= 3,600,000], but you entered {0}", expiration));
	}
}