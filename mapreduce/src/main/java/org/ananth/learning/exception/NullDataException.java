package org.ananth.learning.exception;

public class NullDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public NullDataException(String s, Throwable throwable) {
		super(s,throwable);
	}
	
	
	public NullDataException(String s) {
		super(String.format("The %s is null", s));
	}
	
	

}
