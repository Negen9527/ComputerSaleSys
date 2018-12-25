<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->


    <title> - 主页示例</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="html/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="html/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="html/css/animate.css" rel="stylesheet">
    <link href="html/css/style.css?v=4.1.0" rel="stylesheet">
<title></title>
</head>
<body>
<div class="col-md-5 col-md-offset-3" style="border:1px solid;border-left:none;border-bottom:none;border-right:none;">
	<div style="text-align:center"><h3>电脑详情</h3></div>
                    <div class="ibox-content">

                        <table class="table table-striped" style="text-align: center;">
                            <tbody id="tbody">
 								<tr>
									<td>电脑品牌</td>
									<td>${name}</td>
								</tr>
 								<tr>
									<td>电脑型号</td>
									<td>${typeId}</td>
								</tr>
 								<tr>
									<td>电脑进价</td>
									<td>${inPrice}</td>
								</tr>
 								<tr>
									<td>库存</td>
									<td>${amount}</td>
								</tr>
 								<tr>
									<td>入库日期</td>
									<td>${inTime}</td>
								</tr>
 								<tr>
									<td>供应商</td>
									<td>${supplier}</td>
								</tr>
 								<tr>
									<td>屏幕大小</td>
									<td>${screenSize}</td>
								</tr>
 								<tr>
									<td>重量</td>
									<td>${weight}</td>
								</tr>
 								<tr>
									<td>cpu型号</td>
									<td>${cpu}</td>
								</tr>
 								<tr>
									<td>显卡型号</td>
									<td>${videCard}</td>
								</tr>
 								<tr>
									<td>运行内存</td>
									<td>${ram}</td>
								</tr>
 								<tr>
									<td>硬盘型号</td>
									<td>${hardPan}</td>
								</tr>
                            </tbody>
                        </table>
                    </div>
</div>

</body>

    <!-- 全局js -->
    <script src="html/js/jquery.min.js?v=2.1.4"></script>
    <script src="html/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="html/js/plugins/layer/layer.min.js"></script>
    <!-- Flot -->
    <script src="html/js/plugins/flot/jquery.flot.js"></script>
    <script src="html/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="html/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="html/js/plugins/flot/jquery.flot.pie.js"></script>
    <!-- 自定义js -->
    <script src="html/js/content.js"></script>
    <!--flotdemo-->
</html>