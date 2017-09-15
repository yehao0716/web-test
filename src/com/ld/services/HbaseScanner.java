package com.ld.services;

import java.util.ArrayList;
import java.util.List;

import com.ld.services.hbase.ScanSample;

public class HbaseScanner {
	
	public List<String> searchServerIp(){
		List<String> list = new ArrayList<String>();

		ScanSample scan = new ScanSample();
		list = scan.process("send_rate_anlyse_ip", "ip_server");
		
		return list;
	}
	
	public List<String> searchCidList(){
		List<String> list = new ArrayList<String>();

		ScanSample scan = new ScanSample();
		list = scan.process("send_rate_anlyse_cid", "cid");
		
		return list;
		
	}
	

	public List<String> searchRoomList(){
		List<String> list = new ArrayList<String>();

		ScanSample scan = new ScanSample();
		list = scan.process("send_rate_anlyse_room", "room");
		
		return list;
		
	}
	

	public List<String> searchIspList(){
		List<String> list = new ArrayList<String>();

		ScanSample scan = new ScanSample();
		list = scan.process("send_rate_anlyse_isp", "isp");
		
		return list;
		
	}
	
	public static void main(String[] args) {

		ScanSample scan = new ScanSample();
		for (String str : scan.process("send_rate_anlyse_cid", "cid")) {
			System.out.println(str);
		} 
	}
}
