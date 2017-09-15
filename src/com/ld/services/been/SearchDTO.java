package com.ld.services.been;

public class SearchDTO {
	private String cid;
	private String prov;
	private String city;
	private String isp;
	private String machineRoom;
	private String serverId;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public String getMachineRoom() {
		return machineRoom;
	}
	public void setMachineRoom(String machineRoom) {
		this.machineRoom = machineRoom;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
}
