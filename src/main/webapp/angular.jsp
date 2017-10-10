<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Angular</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="./assets/js/angular.min.js"></script>
        <script src="./assets/js/jquery.min.js"></script>
        <script src="./assets/js/ungdungjs.js"></script>
        <script src="./assets/js/controller.js"></script>
    </head>

    <body ng-app="ungdungjs">
        <h2>Angular</h2>
        
        <div  ng-controller="excontroller" >
            <h3>Ứng dụng đầu tiên với {{xinchao.tieude}} tại ITSOL!</h3>
        </div>

        <div ng-init="cacquocgia = [{locale: 'vi-VN', ten: 'Viet Nam'}, {locale: 'en-GB', ten: 'Vuong Quoc Anh'}, {locale: 'fr-FR', ten: 'Cong Hoa Phap'}, {locale: 'en-US', ten: 'Hoa Ky'}]">
            <p>Nhập tên của bạn: <input type="text" ng-model="ten" /></p>
            <p>Xin chào <span ng-bind="ten"></span> !</p>
            <p>Danh sach cac quoc gia va locale tuong ung:</p>
            <ol>
                <li ng-repeat="quocgia in cacquocgia">
                    {{'Quoc Gia: ' + quocgia.ten + ', Locale: ' + quocgia.locale}}
                </li>
            </ol>
        </div>

        <div ng-init="soluong=5; gia=100000; sinhvien={ho: 'Nguyen The', ten: 'Tuan', mssv: '2017'}; diemthi=[7,6,9,8,7,8,7]">
            <p>Xin chao sinh vien: {{sinhvien.ho + ' ' + sinhvien.ten}} !</p>
            <p>MSSV: {{sinhvien.mssv}}</p>
            <p>Chi phi muon sach: {{soluong*gia}} VND</p>
            <p>Diem thi (Mon Toan): {{diemthi[4]}}</p>
        </div>

        <div ng-controller="svcontroller">
            Nhap ho: <input type="text" ng-model="sinhvien2.ho2"><br><br>
            Nhap ten: <input type="text" ng-model="sinhvien2.ten2"><br>
            <br>
            Ban dang nhap: {{sinhvien2.hoten2()}} !
        </div>

        <div ng-controller="nhapcontroller">
            <table border="1">
                <tr>
                    <td>Nhap Ho: </td>
                    <td><input type="text" ng-model="sinhvien3.ho3" /></td>
                </tr>
                <tr>
                    <td>Nhap Ten: </td>
                    <td><input type="text" ng-model="sinhvien3.ten3" /></td>
                </tr>
                <tr>
                    <td>Nhap Hoc Phi: </td>
                    <td><input type="text" ng-model="sinhvien3.hocphi3" /></td>
                </tr>
                <tr>
                    <td>Nhap Ten Mon Hoc: </td>
                    <td><input type="text" ng-model="tenMonHoc3" /></td>
                </tr>
            </table>

            <br />

            <table border="1">
                <tr>
                    <td>Ten Chu Hoa</td>
                    <td>{{sinhvien3.hoten3() | uppercase}}</td>
                </tr>
                <tr>
                    <td>Ten Chu Thuong</td>
                    <td>{{sinhvien3.hoten3() | lowercase}}</td>
                </tr>
                <tr>
                    <td>Hoc Phi</td>
                    <td>{{sinhvien3.hocphi3 | currency}}</td>
                </tr>
                <tr>
                    <td>Mon Hoc</td>
                    <td>
                        <ul>
                            <li ng-repeat="monhoc in  sinhvien3.tenMonHoc3 | filter: tenMonHoc3 | orderBy: 'diemthi3'">
                                {{monhoc.ten3 + ', Diem Thi: ' + monhoc.diemthi3}}
                            </li>
                        </ul>
                    </td>
                </tr>
            </table>
        </div>

        <br />

        <div ng-controller="taobang">
            <table border="1">
                <tr>
                    <td>Nhap Ho</td>
                    <td><input ng-model="sinhvien4.ho4" /></td>
                </tr>
                <tr>
                    <td>Nhap Ten</td>
                    <td><input ng-model="sinhvien4.ten4" /></td>
                </tr>
                <tr>
                    <td>Ho va ten</td>
                    <td>{{sinhvien4.hoten4()}}</td>
                </tr>
                <tr>
                    <td>Mon Hoc</td>
                    <td>
                        <table border="1">
                            <tr>
                                <th>Ten Mon Hoc</th>
                                <th>Diem Thi</th>
                            </tr>
                            <tr ng-repeat="monhoc in sinhvien4.tenMonHoc4">
                                <td>{{monhoc.ten4}}</td>
                                <td>{{monhoc.diemthi4}}</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>

        <br />
        
        <div ng-controller="xlform">
            <form ten="sinhvienForm" novalidate>
                <table border="1">
                    <tr>
                        <td>Nhap Ho: </td>
                        <td>
                            <input type="text" ten="ho" ng-model="Ho5" required />
                            <span ng-show="sinhvienForm.ho.$drity && sinhvienForm.ho.$invalid">
                                <span ng-show="sinhvienForm.ho.$error.required">Ho la bat buoc.</span>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>Nhap Ten: </td>
                        <td>
                            <input type="text" ten="ten" ng-model="Ten5" required />
                            <span ng-show="sinhvienForm.ten.$drity && sinhvienForm.ten.$invalid">
                                <span ng-show="sinhvienForm.ten.$error.required">Ten la bat buoc.</span>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>Nhap Email: </td>
                        <td>
                            <input type="email" ten="email" ng-model="Email5" required />
                            <span ng-show="sinhvienForm.email.$drity && sinhvienForm.email.$invalid">
                                <span ng-show="sinhvienForm.ten.$error.required">Email la bat buoc.</span>
                                <span ng-show="sinhvienForm.ten.$error.email">Email khong hop le.</span>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button ng-click="reset5()">Reset</button>
                        </td>
                        <td>
                            <button ng-disabled="sinhvienForm.ho$dirty && sinhvienForm.ho.$invalid || sinhvienForm.ten.$drity && sinhvienForm.ten.$invalid || sinhvienForm.email.$drity && sinhvienForm.email.$invalid" ng-click="submit()" >Submit</button>
                        </td>
                    </tr>
                </table>                
            </form>
        </div>

        <br />
        
        <div ng-controller="xlinclude">
            <div ng-include="'tieude.jsp'"></div>
            <div ng-include="'tenmonhoc.jsp'"></div>
        </div>
		
		<h3>Xu ly Ajax</h3>
		
		<div ng-controller=xlajax>
			<p>The ID is {{greeting.id}}</p>
			<p>The content is {{greeting.content}}</p>
		</div>

    </body>
</html>
