<%@ page import="java.util.*,entity.book.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    
    <meta charset="utf-8">
    
    <title>도서 검색</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link href="dashboard.css" rel="stylesheet">
  </head>

  <body>
  	<%
  		ArrayList<BookEntity> list = (ArrayList<BookEntity>)request.getAttribute("theList");
  	%>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form acion="list" class="navbar-form navbar-right" method="post">
            <input type="text" class="form-control" placeholder="도서검색" name="keyword">
            <input type="submit" value="도서검색">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">도서 목록</a></li>
            <li><a href="#">도서 검색</a></li>
            <li><a href="#">도서 입력</a></li>
            <li><a href="#">도서 삭제</a></li>
            <li><a href="#">장바구니 확인</a></li>
          </ul>
        </div>
        <form action = "addCart" method = "post">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Section title</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                	<th>선택</th>
                  <th>책 이미지</th>
                  <th>책 제목</th>
                  <th>책 저자</th>
                  <th>책 ISBN</th>
                  <th>책 가격</th>
                </tr>
              </thead>
              <tbody>
              <%
              	for(int i = 0; i< list.size();i++)
              	{
              		BookEntity temp = list.get(i);
              %>
                <tr>
                <td>
                	<input type="checkbox" name="checkBook" value="<%= temp.getBisbn() %>">
                </td>
                  <td><img src="<%= temp.getBimgurl() %>"></td>
                  <td><%= temp.getBtitle() %></td>
                  <td><%= temp.getBauthor() %></td>
                  <td><%= temp.getBisbn() %></td>
                  <td><%= temp.getBpage() %></td>
                </tr>
              <%
              	}
              %>
              </tbody>
            </table>
            <input type = "submit" value = "장바구니에 담기">
          </div>
          </form>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>