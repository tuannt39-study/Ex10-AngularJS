<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="ex10">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ex10</title>
<script src="./assets/js/angular.min.js"></script>
<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/ungdungjs.js"></script>
<script src="./assets/js/controller.js"></script>
</head>
<body">
	<h2>Ex10 Example</h2>
    <div ng-controller="xlex10">
        <table border="1">
            <tr>
               <th>MaBV</th>
				<th>Tieu De</th>
				<th>Danh Muc</th>
				<th>Chi Tiet</th>
				<th>Lich Dang</th>
				<th>Trang Thai</th>
				<th>Nhan</th>
            </tr>
            <tr ng-repeat="baiviet in baiviets">
               <td>{{ baiviet.maBV }}</td>
               <td>{{ baiviet.tieuDe }}</td>
               <td>{{ baiviet.danhMuc }}</td>
               <td>{{ baiviet.chiTiet }}</td>
               <td>{{ baiviet.lichDang }}</td>
               <td>{{ baiviet.trangThai }}</td>
               <td>{{ baiviet.nhan }}</td>
            </tr>
         </table>
    </div>
    <p>
		<a href="ex10-form.jsp">Them Moi</a>
	</p>
</body>
</html>
