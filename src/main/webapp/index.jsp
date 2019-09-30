<%--
  Created by IntelliJ IDEA.
  User: macintoshhd
  Date: 2019-09-29
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>




<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <script type="text/javascript">

        $(function () {

            $.ajax({
                url:"${pageContext.request.contextPath}/user/login2",
                data:{"name":"李白","sex":"男"},
                type:"post",
                dataType:"json",
                success:function(data){
                   console.log(data)
                },
                error:function (error) {
                    alert(error)
                }
            });


        });

    </script>
</head>
<body>



</body>
</html>
