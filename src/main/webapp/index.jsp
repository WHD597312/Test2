<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    session.setAttribute("base", path);
    session.setAttribute("base",path);
    System.out.println("base-->"+path);
%>
<html>
<head>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
</head>
<body>
    <script>
        layui.use(['layer','form'],function () {
            var layer=layui.layer
            form=layui.form;
            layer.msg('Hello World!');
        })
    </script>
</body>
</html>
