package com.ld.services;

import java.util.List;

import com.ld.services.been.SendRateInfo;
import com.ld.services.hbase.Phoenix;

public class PhoenixSearcher {

	public List<SendRateInfo> searchByCid(String cid){
		Phoenix ph = new Phoenix();
		return ph.search(Phoenix.SQL+" and \"peer_id\"='"+cid+"'");
	}
	
	public List<SendRateInfo> searchByIsp(String ispFull){
		Phoenix ph = new Phoenix();
		String isp = ispFull.split("-")[0];
		String prov = ispFull.split("-")[1];
		String city = ispFull.split("-")[2];
		
		return ph.search(Phoenix.SQL+" and \"public_ip_prov\"='"+prov+"' and \"public_ip_city\" = '" + city + "' and \"public_ip_isp\" = '" + isp + "'");
	}
	

	public List<SendRateInfo> searchByServerIp(String serverIp){
		Phoenix ph = new Phoenix();
		return ph.search(Phoenix.SQL+" and \"relay_ip\"='"+serverIp+"'");
	}
	
	public List<SendRateInfo> searchByRoom(String room){
		Phoenix ph = new Phoenix();
		return ph.search(Phoenix.SQL+" and \"server_machine_room\" = '"+room+"'");
	}
	 
	public static void main(String[] args) {
		

		new PhoenixSearcher().searchByRoom("机房2");
		
//		new PhoenixSearcher().searchByServerIp("123.1.1.1");
		
//		new PhoenixSearcher().searchByIsp("联通-山西-太原");
		
//		new PhoenixSearcher().searchByCid("1003471");
	}
}
