<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>
    <script src="../js/jquery.min.js?v=2.1.4"></script>
    <style type="text/css">
        body {font-size: 20px;
            padding-bottom: 40px;
            background-color:#e9e7ef;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
</head>
<body>

<form class="form-inline definewidth m20" action="list" method="get">
     <font color="#777777"><strong>用户名：</strong></font>
    <input type="text" name="name" id="uname" class="abc input-default " placeholder="请填写用户名" value="${name}">&nbsp;&nbsp;
    <input type="submit" class="btn btn-primary queryBtn" value="查询"/>
</form>

<table id="usertable" class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>Email</th>
        <th>注册日期</th>
        <th>用户状态</th>
        <th>冻结账户</th>
     </tr>
    </thead>
   <tbody id="tbody">
       <%--填写用户列表数据--%>
       <c:forEach items="${pageInfo.list}" var="user">
           <tr>
               <td><a href="user_detail.jsp">${user.uname}</a></td>
               <td>${user.truename}</td>
               <td>${user.email}</td>
               <td><fmt:formatDate value="${user.utime}" pattern="yyyy-MM-dd"/></td>
               <td>
                   <c:choose>
                       <c:when test="${user.ustatus == 1}">正常状态</c:when>
                       <c:when test="${user.ustatus == 2}">注销状态</c:when>
                       <c:otherwise>其他</c:otherwise>
                   </c:choose>
               </td>
               <td><button onclick="cancelBtn(${user.uid},2)">注销</button></td>
           </tr>
       </c:forEach>
   </tbody>
   <tfoot>
        <tr>
            <td colspan="6" style="text-align: center;">
                <a href="list?currentPage=1&name=${name}">首页</a>
                <a href="list?currentPage=${pageInfo.prePage}&name=${name}">上一页</a>
                [
                <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                    <a href="list?currentPage=${num}&name=${name}">${num}</a>&nbsp;
                </c:forEach>
                ]
                <a href="list?currentPage=${pageInfo.nextPage}&name=${name}">下一页</a>
                <a href="list?currentPage=${pageInfo.pages}&name=${name}">尾页</a>
            </td>
        </tr>
   </tfoot>
</table>
<script type="text/javascript">
    function cancelBtn(id,status) {
        //前端判断
        if(confirm("是否要冻结此用户")){
            location.href = "cancel?uid="+id+"&ustatus="+status;
        }else{
            alert("取消了冻结操作");
        }
    }
</script>
</body>
</html>