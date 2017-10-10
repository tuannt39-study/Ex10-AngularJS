<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<p>Mon Hoc</p>
<table border="1">
    <tr>
        <th>Ten</th>
        <th>Diem Thi</th>
    </tr>
    <tr ng-repeat="monhoc in sinhvien6.tenMonHoc6">
        <td>{{monhoc.ten6}}</td>
        <td>{{monhoc.diemthi6}}</td>
    </tr>
</table>
