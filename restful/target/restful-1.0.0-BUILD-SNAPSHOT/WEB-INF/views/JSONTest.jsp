<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON TEST</title>
    <script>
        $(function() {
            $("#checkJson").click(function() {
                // 회원 정보를 json으로 생성
                var member = {
                    id:"kim",
                    name:"김연아",
                    pwd:"1234",
                    email:"kim@test.com" };
                $.ajax({
                    type:"post",
                    // /test/info로 요청하기
                    url:"${contextPath}/test/info",
                    contentType: "application/json",
                    // 회원 정보를 json 문자열로 변환
                    data :JSON.stringify(member),
                    success:function (data,textStatus) {
                    },
                    error:function(data,textStatus) {
                        alert("에러가 발생했습니다.");
                    },
                    complete:function(data,textStatus) {
                    }
                }); // end ajax
            });
        });
    </script>
</head>
<body>
    <input type="button" id="checkJson" value="회원 정보 보내기" /> <br><br>
    <div id="output"></div>

</body>
</html>
