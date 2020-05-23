package com.mobileapp.mobile.model;



public class Sim {
	private int simNo;
	private String network;
	public Sim() {
		super();
	}

	public Sim(int simNo, String network) {
		super();
		this.simNo = simNo;
		this.network = network;
	}

	public int getSimNo() {
		return simNo;
	}
	public void setSimNo(int simNo) {
		this.simNo = simNo;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	@Override
	public String toString() {
		return "Sim [simNo=" + simNo + ", network=" + network + "]";
	}
	

}
