package com.objectmapper;

public class Candidate {
	
	private int candidateID;
	private Form form;

	public int getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(int candidateID) {
		this.candidateID = candidateID;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return "Candidate [candidateID=" + candidateID + ", form=" + form + "]";
	}
	
	
   
}   
