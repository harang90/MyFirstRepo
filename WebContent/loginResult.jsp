<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">

    <title>로그인 결과</title>
    
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link href="css/cover.css" rel="stylesheet">
	
  </head>

  <body>
  	<%
  		String msg = (String)request.getAttribute("msg");
  		boolean result = (Boolean)request.getAttribute("flag");
  	%>
  
    <div class="site-wrapper">
      <div class="site-wrapper-inner">
        <div class="cover-container">
          <div class="masthead clearfix">
          </div>
          <div class="inner cover">
            <h1 class="cover-heading"><%= session.getAttribute("USERID")%></h1>
            <p class="lead">
            <% 
            	if(result){
            %>
              <a href="list.html" class="btn btn-lg btn-default">책 목록보기</a>
            <%
            	} else { 
            %>
            	<a href="#" class="btn btn-lg btn-default">로그인 실패</a>
            <%
            	}
            %>
            </p>
          </div>
          <div class="mastfoot">
            <div class="inner">
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>