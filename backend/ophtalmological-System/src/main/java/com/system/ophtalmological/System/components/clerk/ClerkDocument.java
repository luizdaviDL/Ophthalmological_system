package com.system.ophtalmological.System.components.clerk;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClerkDocument {
	private String document;

	public ClerkDocument() {
		super();
	}

	public ClerkDocument(String document) {
		super();
		this.document = document;
	}
	
	
}
