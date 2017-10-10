<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h2>Tieu De Include</h2>
<table border="1">
    <tr>
        <td>Nhap Ho: </td>
        <td><input type="text" ng-model="sinhvien6.ho6" /></td>
    </tr>
    <tr>
        <td>Nhap Ten: </td>
        <td><input type="text" ng-model="sinhvien6.ten6" /></td>
    </tr>
    <tr>
        <td>Ho va Ten: </td>
        <td>{{sinhvien6.hoten6()}}</td>
    </tr>
</table>
    