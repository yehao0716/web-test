<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<script type="text/javascript">
window.onload=function(){
	if(document.getElementById("alink")){
		document.getElementById("alink").click();
	}
	
	setTimeout("self.location.reload();",30000);
	
}
</script>
<body>

<h2>服务器异常：</h2>
<%  
	if(request.getAttribute("serverIpList") != null){
		List<String> serverIpList = (ArrayList<String>) request.getAttribute("serverIpList");
		for(String str : serverIpList){
	%>
	<%=str %> <a href="DetailServlet?searchType=serverIp&serverIp=<%=str %>" target="_blank">详情</a> <br/>
	<%		
		}
	}
%>

<h2>机房异常：</h2>
<%  
	if(request.getAttribute("roomList") != null){
		List<String> roomList = (ArrayList<String>) request.getAttribute("roomList");
		for(String str : roomList){
	%>
	<%=str %> <a href="DetailServlet?searchType=room&room=<%=str %>" target="_blank">详情</a> <br/>
	<%		
		}
	}
%>

<h2>运营商异常：</h2>
<%  
	if(request.getAttribute("ispList") != null){
		List<String> ispList = (ArrayList<String>) request.getAttribute("ispList");
		for(String str : ispList){
	%>
	<%=str %> <a href="DetailServlet?searchType=isp&isp=<%=str %>" target="_blank">详情</a> <br/>
	<%		
		}
	}
%>

<h2>设备异常：</h2>
<%
	if(request.getAttribute("cidList") != null){
		List<String> cidList = (ArrayList<String>) request.getAttribute("cidList");
		for(String str : cidList){
%>
	<%=str %> <a href="DetailServlet?searchType=cid&cid=<%=str %>" target="_blank">详情</a> <br/>
<%		
		}
	}else{
%>
<a id="alink" href="IndexServlet"></a>
<%		
	} 
%>



</body>
</html>
