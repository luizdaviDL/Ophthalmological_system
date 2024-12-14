package com.system.ophtalmological.System.components;

public class BusinessExceptio extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	public BusinessExceptio(String mensage) {
		super(mensage);
	}
}
