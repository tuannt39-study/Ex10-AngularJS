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
	<div ng-controller="bvCRUD">
		<table>
			<tr>
				<td>Ma BV:</td>
				<td><input type="text" id="MaBV" ng-model="baiviet.MaBV" /></td>
			</tr>
			<tr>
				<td>Tieu De:</td>
				<td><input type="text" id="TieuDe" ng-model="baiviet.TieuDe" /></td>
			</tr>
			<tr>
				<td>Danh Muc:</td>
				<td><input type="text" id="DanhMuc" ng-model="baiviet.DanhMuc" /></td>
			</tr>
			<tr>
				<td>Chi Tiet:</td>
				<td><input type="text" id="ChiTiet" ng-model="baiviet.ChiTiet" /></td>
			</tr>
			<tr>
				<td>Lich Dang:</td>
				<td><input type="text" id="LichDang" ng-model="baiviet.LichDang" /></td>
			</tr>
			<tr>
				<td>Trang Thai:</td>
				<td><input type="text" id="TrangThai" ng-model="baiviet.TrangThai" /></td>
			</tr>
			<tr>
				<td>Nhan:</td>
				<td><input type="text" id="Nhan" ng-model="baiviet.Nhan" /></td>
			</tr>
		</table>
		<br /> <br /> 
		<button ng-click="getBVById(baiviet.MaBV)">Get Bai Viet</button> 
		<button ng-click="updateBV(baiviet.MaBV,baiviet.TieuDe,baiviet.DanhMuc,baiviet.ChiTiet,baiviet.LichDang,baiviet.TrangThai,baiviet.Nhan)">Update Bai Viet</button> 
		<button ng-click="createBV(baiviet.TieuDe,baiviet.DanhMuc,baiviet.ChiTiet,baiviet.LichDang,baiviet.TrangThai,baiviet.Nhan)">Add Bai Viet</button> 
		<button ng-click="deleteBV(baiviet.MaBV)">Delete Bai Viet</button>
		<br /> <br />
		<p style="color: green">{{message}}</p>
		<p style="color: red">{{errorMessage}}</p>

		<br />
		<br /> 
		<button ng-click="getAllBV()">Get all Bai Viet</button><br /> 
		<br /> <br />
		<div ng-repeat="baiv in baiviets">
			{{baiv.MaBV}} {{baiv.TieuDe}} {{baiv.DanhMuc}} {{baiv.ChiTiet}} {{baiv.LichDang}} {{baiv.TrangThai}} {{baiv.Nhan}}
		</div>
	</div>
</body>
</html>
