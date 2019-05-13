<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>

<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="/Test2/layui/css/layui.css">
    <script src="/Test2/layui/layui.js"></script>
</head>
<body class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md9">
            你的内容9/12
        </div>
        <div class="layui-col-md3">
            你的内容3/12
        </div>
    </div>
<script>
    layui.use(['layer','form'],function () {
        var layer=layui.layer
        form=layui.form;
        layer.msg('Hello World!');
    })
</script>
</body>
</html>
