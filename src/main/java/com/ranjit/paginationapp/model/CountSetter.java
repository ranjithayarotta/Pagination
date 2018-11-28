package com.ranjit.paginationapp.model;

import org.springframework.stereotype.Service;

@Service
public class CountSetter {

	private int start=0;
	private int end;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
