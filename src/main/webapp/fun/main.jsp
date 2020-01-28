<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>网站管理系统</title>
<link rel="icon" href="Source/ico/brics-logo.ico" type="image/x-icon" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!-- easyui标准引用 -->
<link rel="stylesheet" type="text/css" href="Source/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="Source/easyui/themes/theme-icon.css">
<script type="text/javascript" src="Source/easyui/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="Source/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="Source/easyui/locale/easyui-lang-zh_CN.js"></script>

 <link rel="stylesheet" type="text/css" href="Source/css/main.css">
<link rel="stylesheet" type="text/css" href="Source/css/icon.css">
<script type="text/javascript" src="Source/js/main.js"></script>
</head>

<body class="easyui-layout">
	<!-- begin of header -->
	<div class="menu-header" data-options="region:'north',border:false" >
		<div class="menu-header-left" >
		 <img src="Source/img/index/logo.png" style="height:40px;"/>
		</div>
		<div style="padding-left: 45%;color:#fff; " ><h2 id="dpdata">2019年4月25日 10:56:43</h2></div>
		<div class="menu-header-right">
			<p><strong>${user}</strong>，欢迎您！</p>
			<div id="role_id" style="display:none">${role}</div>
			<p><a href="javascript:void(0);"  onclick="getLogout()">注销登录</a>|<a
					href="javascript:void(0);" onclick="openAbout()">关于</a></p>
		</div>
	</div>
	<!-- end of header -->
	<!-- begin of sidebar -->
	<div class="menu-sidebar"
		data-options="region:'west',split:false,border:false,title:''">

		<div id="xyz-accordion" class="easyui-accordion" style="background: #2f333e;border-width: 1px;border-color: #2f333e"
			data-options="border:false,fit:true"></div>
	</div>
	<!-- end of sidebar -->
	<!-- begin of main -->
	<div class="menu-main" data-options="region:'center'" >
		<div id="xyz-tabs" class="easyui-tabs"  data-options="border:false,fit:true" >
			 <div title="欢迎" data-options="href:'',closable:false,iconCls:'icon-tip',cls:'pd3'" >
				<div id="frameindex" >
					<!-- <h1>智能运维 | AIOPS</h1> -->
					<h2 style="font-family: pingFang-SC-Regular,Microsoft Yahei,Arial;">欢迎进入网站管理系统！</h2>
				</div>
			</div> 
		</div>
	</div>
	<!-- end of main -->
	<!-- begin of footer -
	<div class="menu-footer" data-options="region:'south',border:true"></div>->
	<!-- end of footer -->
	<script type="text/javascript">
	     var role_id=$("#role_id").text();
	     menuLoading("menuinfo/getObjectListByRole?T=T&role="+role_id);
	</script>
</body>
</html>
