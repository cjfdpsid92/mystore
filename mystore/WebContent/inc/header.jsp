<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>코딩계의 알파고 지파고 지예!</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/pavi.png" type="image/x-icon"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 		 <!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>

* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

.hj_navbar {
  overflow: hidden;
  background-color: #333;
  font-family: Arial, Helvetica, sans-serif;
}

.hj_navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.hj_dropdown {
  float: left;
  overflow: hidden;
}

.hj_dropdown .dropbtn {
   position:relative;
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font: inherit;
  margin: 0;
}

.hj_navbar a:hover, .hj_dropdown:hover .dropbtn {
  background-color: red;
  transition:all 1s;
}

.hj_dropdown-content {
  display: none; 
  position: absolute;
  background-color: #f9f9f9;
  width: 100%; 
  
  z-index: 1;
}

.hj_dropdown-content .header {
  background: red;
  padding: 16px;
  color: white;
}

.hj_dropdown:hover .hj_dropdown-content {
  display: block;
}

 .column {
  float: left;
  width: 33.33%;
  padding: 10px;
  background-color: #ccc;
  height: 250px;
}

.column a {
  float: none;
  color: black;
  padding: 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.column a:hover {
  background-color: #ddd;
}

 .row:after {
  content: "";
  display: table;
  clear: both;
}

@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    height: auto;
  }
} 

 
/*					*/
/*					*/
div#header {  }
/*					*/
/*					*/
/*					*/
.logo{     color: white;  font-weight: bold; font-size: 20px; margin-top: 25px; }
.hj_navbar { overflow: hidrden; background-color:transparent; }
.hj_navbar a { float: left; font-size: 16px; color: #333; }
.hj_dropdown .dropbtn { color: #333; }
.fa-caret-down:before { content: "\f0d7"; }
.hj_navbar a:hover, .hj_dropdown:hover .dropbtn { background-color: white ; color: #333;     }
.fa-caret-down:before { content: ""; }
/*					*/
/*					*/  
.hj_dropdown-content{   width: 28%; 
    border: 1px solid #ccc;
  background-color: #f9f9f9; border-top:0 none;  }
.hj_dropdown-content .column { padding-top:10px;
    position: relative; float: none; width: 20%;   height:auto; background-color:  white;
    border-right: 1px solid #ddd; }
.hj_dropdown-content .column a { float: none; color: black;   text-decoration: none; display: block; text-align: left; }
.hj_dropdown-content .column a:hover {  text-decoration: underline; color: #333;}
.hj_dropdown-content .column h3 a{color:  #333;    color: #333;}

.hj_dropdown-content .column a {  padding:0; font-size:12px; color: #999;}
.nav>li>a:focus, .nav>li>a:hover { text-decoration: underline; background-color: transparent; }

.hj_dropdown .dropbtn {     }
.hj_dropdown-content  .container {  width:auto; }
.lnb {  padding-top:28px }
.lnb a{color:white;  font-size:12px;    }
.submenu {
    position: absolute;
    left: 154px;
    width: 100%;
    top: 13px;
    padding-left: 10px;
}
.hj_dropdown a {
    float: left;
    font-size: 14px;
    color: white;
    padding: 0;
    padding-top: 14px;
    padding-left: 10px;
    padding-right: 10px;
}
.hj_navbar a:hover, .hj_dropdown:hover .dropbtn {
    background-color: transparent;
    color: white;
    text-decoration: underline;
}
.hj_dropdown.total:hover .dropbtn{
	background-color:white; color:#d50527; font-weight:bold;  text-decoration:none; 
	
}

/*				*/ 
.footer{ background-color: #F5F5F5; font-size:12px;   padding-top:20px;  border-top:1px solid #ddd;  padding-bottom:20px }
.footer li{  list-style-type:none;   display:inline-block;  margin:5px; }
.footer a{  color:#666;   }
.footer i{  font-style:normal; }

/*	social */
.fa {
  padding: 20px;
  font-size: 20px;
  width: 30px;
  height: 30px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
  border-radius: 50%;
  border:1px solid #ddd;
    line-height: 0px;
    text-indent: -8px;
}

.fa:hover {
    opacity: 0.7;
}
footer {  padding:10 0; }

nav.navbar.lnb { margin: 0; padding: 0; }
.lnb .navbar-nav>li>a { color: #333; padding: 2px 8px; margin: 0; }


nav.navbar.search  form{  width:50%;      margin-top: 2%;
    margin-left: 5%; }

.logo a.navbar-brand{  color:#85755c;      font-size: 42px; letter-spacing: -2px; }
  .form-group.myform { border: 1px solid #85755c;   padding:1%;     width: 100%; width: 93%;  position: relative;}
  input#header_search { border: 0 none;  box-shadow: none;  width: 92%;   }
  button.header_form_go { border: 0 none; background-color: #85755c;    color: white; padding: 13px; position: absolute; right: 0;   top: 0;}

.gnb {
    border-top: 1px solid #85755c;
    border-bottom: 1px solid #85755c;
}
.hj_dropdown.total .dropbtn , .hj_dropdown .dropbtn{ color:#85755c;   font-weight:bold; 
    font-size: 17px;   }
.hj_dropdown.total:hover .dropbtn , .hj_dropdown:hover .dropbtn{ color:#85755c;   font-weight:bold;   }
 	/* #85755c;
    #a48b6d;
 	 */
</style> 
</head>
<body>



<div id="header" >
<nav class="navbar  lnb">
  <div class="container">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#">로그인</a></li>
      <li><a href="#">회원가입</a></li>
      <li><a href="#">나의서재</a></li>
      <li><a href="#">고객센터</a></li>
    </ul>
  </div>
</nav>

<nav class="navbar  search">
  <div class="container">
  <div class="container-fluid">
    <div class="navbar-header logo">
    <!-- <a class="navbar-brand" href="#"  >GIPAGO LONIS</a> -->
    <a class="navbar-brand" href="#"  ><img src="${pageContext.request.contextPath}/img/logo.png" alt="logo"/></a>
    </div>
    <form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/search.do" method="get">
      <div class="form-group  myform">
        <input type="text"  title="'수필'을 입력해보세요"  id="header_search"   class="form-control" placeholder="검색어를 입력해 보세요">
        <button type="submit"  class="header_form_go"><span class="	glyphicon glyphicon-search"></span></button>
      </div>
    </form>
    
    <div class="nav navbar-nav navbar-right">
      <a href=""><img src="inc/banner20210305110151.jpg" alt=""/></a>
    </div>
  </div>
  </div>
</nav>

<!-- 						 -->
<!-- 						 -->
<!-- 		 				 -->
<div class="gnb">
<div class="container"  >  
<div class="hj_navbar">
  <div class="hj_dropdown total">
    <button class="dropbtn"> <span class="	glyphicon glyphicon-menu-hamburger"></span>전체 </button>
    <div class="hj_dropdown-content">  
        <div class="column">
          <h3> <a href="#">도서</a></h3>
          <div  class="submenu">
          <a href="#">Link 1-1</a>
          <a href="#">Link 2-1</a>
          <a href="#">Link 3-1</a>
          </div>
        </div>
        <div class="column">
          <h3> <a href="#">음반</a></h3>
          <div  class="submenu">
          <a href="#">Link 1-2</a>
          <a href="#">Link 2-2</a>
          <a href="#">Link 3-2</a>
          </div>
        </div>    
        <div class="column">
          <h3> <a href="#">GIFT</a></h3>
          <div  class="submenu">
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
          <a href="#">Link 3</a>
          </div>
        </div>  
    </div>
  </div><!-- menu --> <!-- menu --> <!-- menu --> 
  <div class="hj_dropdown">
    <button class="dropbtn">도서 </button>
   <div class="hj_dropdown-content">  
        <div class="column">
          <h3> <a href="#">도서</a></h3>
          <div  class="submenu">
          <a href="#">Link 1-1</a>
          <a href="#">Link 2-1</a>
          <a href="#">Link 3-1</a>
          </div>
        </div>
        <div class="column">
          <h3> <a href="#">음반</a></h3>
          <div  class="submenu">
          <a href="#">Link 1-2</a>
          <a href="#">Link 2-2</a>
          <a href="#">Link 3-2</a>
          </div>
        </div>    
        <div class="column">
          <h3> <a href="#">GIFT</a></h3>
          <div  class="submenu">
          <a href="#">Link 1</a>
          <a href="#">Link 2</a>
          <a href="#">Link 3</a>
          </div>
        </div>  
    </div>    
  </div><!-- menu --> <!-- menu --> <!-- menu -->   
  <div class="hj_dropdown">
  	
    <button class="dropbtn">E-BOOK </button> 
  </div><!-- menu --> <!-- menu --> <!-- menu --> 
   <div class="hj_dropdown">
    <button class="dropbtn">음반 </button>  
  </div><!-- menu --> <!-- menu --> <!-- menu --> 
   <div class="hj_dropdown">
    <button class="dropbtn">GIFT </button>  
  </div><!-- menu --> <!-- menu --> <!-- menu --> 
   <div class="hj_dropdown">
    <button class="dropbtn">오피스문구 </button>   
  </div><!-- menu --> <!-- menu --> <!-- menu --> 
</div>
 

</div> <!--  end container -->
</div> <!-- end gnb -->
<!-- 						 -->
<!-- 						 -->
<!-- 						 -->

</div>  
 
 
 <!-- https://www.w3schools.com/howto/howto_css_subnav.asp -->