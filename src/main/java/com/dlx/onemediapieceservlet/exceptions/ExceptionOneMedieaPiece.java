package com.dlx.onemediapieceservlet.exceptions;

public class ExceptionOneMedieaPiece extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	

	public ExceptionOneMedieaPiece(String message) {
		super();
		this.message = message;
	}



	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
