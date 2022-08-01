package com.cts.spring.boot.webmvc.demo.exception;

public class OperationFailedException extends Exception {

	public OperationFailedException() {
		super();
	}

	public OperationFailedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OperationFailedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OperationFailedException(String arg0) {
		super(arg0);
	}

	public OperationFailedException(Throwable arg0) {
		super(arg0);
	}

}
