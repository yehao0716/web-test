<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.ld.services.been.SendRateInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>detail</title>
</head>
<body>
<%
	List<SendRateInfo> list = (ArrayList<SendRateInfo>) request.getAttribute("list");

%>
<table border="3px" bordercolor="000000">
<tr>
	<th>设备id</th>
	<th>设备ip</th>
	<th>省份</th>
	<th>城市</th>
	<th>运营商</th>
	<th>总时间</th>
	<th>发送时间</th>
	<th>发送比</th>
	<th>转发ip</th>
	<th>机房</th>
</tr>
<%
	for(SendRateInfo info : list){
%>

<tr>
	<td><%=info.getPeer_id() %></td>
	<td><%=info.getIp() %></td>
	<td><%=info.getPublic_ip_prov() %></td>
	<td><%=info.getPublic_ip_city() %></td>
	<td><%=info.getPublic_ip_isp() %></td>
	<td><%=info.getTime_toal() %></td>
	<td><%=info.getSend_time() %></td>
	<td><%=info.getSend_rate() %></td>
	<td><%=info.getRelay_ip() %></td>
	<td><%=info.getServer_machine_room() %></td>
</tr>
<%		
	}
%>
</table>

</body>
</html>