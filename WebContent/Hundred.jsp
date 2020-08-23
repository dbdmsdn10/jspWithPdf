<% 
	int sum=0;
	for(int i=0;i<10;i++){
		sum+=i;
	}
	request.setAttribute("result", sum);
	//RequestDispatcher dispatcher=request.getRequestDispatcher("HundredResult.jsp");
	//dispatcher.forward(request, response);
%>
<jsp:forward page="HundredResult.jsp"/>