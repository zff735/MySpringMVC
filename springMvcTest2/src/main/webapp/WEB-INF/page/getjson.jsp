<%--
  Created by IntelliJ IDEA.
  User: 钟非凡
  Date: 2022/3/15
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function(){
            var user={};
            user.id=1001;
            user.name='zhangsan';
            $('#btn').click(function(){
                $.ajax({
                    type:'post',
                    url:'http://localhost:8080/getJson',
                    data:JSON.stringify(user),
                    // data:{
                    //     'id':user.id,
                    //     'name':user.name
                    // },
                    dataType:"json",
                    contentType : 'application/json;charset=utf-8',
                    success:function(data){
                        $('#json').text(data.name);
                    }
                })

            })
        })
    </script>
</head>
<body>
    <button type="button" id="btn">获取json数据</button>
    <div id="json"></div>
    <br/>
    <br/>
    <br/>
    <br/>
    <form method="post" action="/getJson">
        编号:<input type="text" value="1001" name="id"/><br/>
        姓名:<input type="text" value="zhangsan" name="name"/><br/>
        <button>提交</button>
    </form>
</body>
</html>
