<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RESTful 웹 서비스</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    var obj = {"name" : "kim",  "age" : 30};
    function test(){
        $.ajax({
            url : "<c:url value="/test"/>",
            type : "post",
            data : JSON.stringify(obj),
            dataType : "json",
            contentType : "application/json",

            success : function(data){
                alert("성공" );
            },
            error:function(errorThrown){

                alert("실패");
            }

        });
    }

</script>
<body>
<h3>RESTful 웹 서비스</h3>
<button onclick="test()" type="button">실행하기</button>

</body>
<html>
