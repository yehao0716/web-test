package com.ld.services.hbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ld.services.been.SendRateInfo;

public class Phoenix {
	
	public final static String SQL = "select \"peer_id\",\"ip\", \"relay_ip\", \"public_ip_prov\", \"public_ip_city\", \"public_ip_isp\", \"send_rate\", \"send_time\", \"time_toal\", \"server_machine_room\", \"server_ip_prov\", \"server_ip_city\", \"server_ip_isp\" from \"send_rate_anlyse\" where \"send_rate\" > '0.5' ";

	// 用于初始化连接
	public Connection getConnection() {
		
		try {
	        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
			return DriverManager.getConnection("jdbc:phoenix:node243,node242,node241:24002");
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {
            System.out.println("org.apache.phoenix.jdbc.PhoenixDriver未找到");
        }
		return null;
	}
	
	public List<SendRateInfo> search(String sql) {
		Connection conn = getConnection();
		Statement sm = null;
		List<SendRateInfo> list = new ArrayList<SendRateInfo>();
		
		try{
			sm = conn.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			
			while (rs.next()) {
				SendRateInfo info = new SendRateInfo();
				System.out.println(rs.getString("peer_id"));
				System.out.println(rs.getString("ip"));
				System.out.println(rs.getString("relay_ip"));
				System.out.println(rs.getString("public_ip_prov"));
				System.out.println(rs.getString("public_ip_city"));
				System.out.println(rs.getString("public_ip_isp"));
				System.out.println(rs.getString("send_rate"));
				System.out.println(rs.getString("send_time"));
				System.out.println(rs.getString("time_toal"));
				System.out.println(rs.getString("server_machine_room"));
				System.out.println(rs.getString("server_ip_prov"));
				System.out.println(rs.getString("server_ip_city"));
				System.out.println(rs.getString("server_ip_isp"));
				System.out.println("=====================================");
				info.setPeer_id(rs.getString("peer_id"));
				info.setIp(rs.getString("ip"));
				info.setRelay_ip(rs.getString("relay_ip"));
				info.setPublic_ip_prov(rs.getString("public_ip_prov"));
				info.setPublic_ip_city(rs.getString("public_ip_city"));
				info.setPublic_ip_isp(rs.getString("public_ip_isp"));
				info.setSend_rate(rs.getString("send_rate"));
				info.setSend_time(rs.getString("send_time"));
				info.setTime_toal(rs.getString("time_toal"));
				info.setServer_machine_room(rs.getString("server_machine_room"));
				info.setServer_ip_prov(rs.getString("server_ip_prov"));
				info.setServer_ip_city(rs.getString("server_ip_city"));
				info.setServer_ip_isp(rs.getString("server_ip_isp"));
				list.add(info);
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				sm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
