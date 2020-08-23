<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="mall.PersonalInfo" id="pinfo" scope="request"/>
<jsp:setProperty name="pinfo" property="name" value="김현수"/>
<jsp:setProperty name="pinfo" property="gender" value="남"/>
<jsp:setProperty name="pinfo" property="age" value="23"/>
<jsp:forward page="CustomerViewer.jsp"/>