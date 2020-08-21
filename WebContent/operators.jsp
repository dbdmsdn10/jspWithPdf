<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
x=${param.num1}, y=${param.num2}<br><br>
x+y=${param.num1+param.num2}<br>
x-y=${param.num1-param.num2}<br>
x*y=${param.num1*param.num2}<br>
x/y=${param.num1/param.num2}<br>
x가 더 큽니까? ${param.num1 - param.num2 > 0}<br><br>
 y가 더 큽니까? ${param.num2 - param.num1 > 0}<br><br>
 x와 y가 모두 양수입니까? ${(param.num1 > 0) && (param.num2 > 0)}<br><br>
 x와 y가 같습니까? ${param.num1 == param.num2 ? "예" : "아니오"}<br><br><br><br>
 ${param.num1}을 ${param.num2}로 나눈 몫은? ${param.num1 div param.num2}<br>
 나머지는? ${param.num1 mod param.num2}<br><br>
 둘 다 양수입니까? ${(param.num1 gt 0) and (param.num2 gt 0)}<br>
 둘 다 음수입니까? ${(param.num1 lt 0) and (param.num2 lt 0)}<br><br><br><br><br>
 
 입력 문자열: ${param.str1}, ${param.str2}<br><br>
 두 문자열이 같습니까? ${param.str1 == param.str2}<br>
 어느 문자열이 먼저입니까? ${param.str1 < param.str2 ? param.str1 : param.str2}
 <br><br><br><br>
 안녕하세요, ${empty param.ID ? "guest" : param.ID}님
</body>
</html>