
ungdungjs.controller("excontroller", function($scope) {
    $scope.xinchao = {};
    $scope.xinchao.tieude = "Angular";
});

ungdungjs.controller('svcontroller', function($scope){
    $scope.sinhvien2 = {
        ho2: "Nguyen The",
        ten2: "Tuan",
        hoten2: function(){
            var doituongsv;
            doituongsv = $scope.sinhvien2;
            return doituongsv.ho2 + " " + doituongsv.ten2;
        }
    };
});

ungdungjs.controller('nhapcontroller', function($scope){
    $scope.sinhvien3 = {
        ho3: "Nguyen The ",
        ten3: "Tuan",
        hocphi3: 200,
        tenMonHoc3: [
            {ten3: 'Vat Ly', diemthi3: 7.5},
            {ten3: 'Toan', diemthi3: 9.0},
            {ten3: 'Hoa Hoc', diemthi3: 8.5}
        ],
        hoten3: function(){
            var doituongsv2;
            doituongsv2 = $scope.sinhvien3;
            return doituongsv2.ho3 + doituongsv2.ten3;
        }
    };
});

ungdungjs.controller('taobang', function($scope){
    $scope.sinhvien4 = {
        ho4: "Nguyen The ",
        ten4: "Tuan",
        hocphi4: 500,
    tenMonHoc4: [
        {ten4: 'Toan', diemthi4: 8.0},
        {ten4: 'Ly', diemthi4: 8.0},
        {ten4: 'Anh', diemthi4: 8.0},
        {ten4: 'Hoa', diemthi4: 8.0},
        {ten4: 'Van', diemthi4: 8.0}
    ],
    hoten4: function(){
        var doituongsv4;
        doituongsv4 = $scope.sinhvien4;
        return doituongsv4.ho4 + doituongsv4.ten4;
    }
    };
});

ungdungjs.controller('xlform', function($scope){
    $scope.reset5 = function(){
        $scope.Ho5 = "Nguyen The ";
        $scope.Ten5 = "Tuan";
        $scope.Email5 = "tuannt39@gmail.com";
    }
    $scope.reset5();
});

ungdungjs.controller('xlinclude', function($scope){
    $scope.sinhvien6 = {
        ho6: "Nguyen The ",
        ten6: "Tuan",
        hocphi6: 500,
    tenMonHoc6: [
        {ten6: 'Toan', diemthi6: 9.0},
        {ten6: 'Ly', diemthi6: 8.0},
        {ten6: 'Anh', diemthi6: 7.0},
        {ten6: 'Hoa', diemthi6: 6.0},
        {ten6: 'Van', diemthi6: 10.0}
    ],
    hoten6: function(){
        var doituongsv6;
        doituongsv6 = $scope.sinhvien6;
        return doituongsv6.ho6 + doituongsv6.ten6;
    }
    };
});

ungdungjs.controller('xlajax', function($scope, $http){
    $http.get('http://rest-service.guides.spring.io/greeting').
    then(function(response) {
        $scope.greeting = response.data;
    });
});

ex10.controller('xlex10', function($scope, $http){
    $http.get('http://localhost:8080/Ex10/webresources/baiviet/all').
    then(function(response) {
        $scope.baiviets = response.data;
    });
});

ex10.controller('bvCRUD', ['$scope','bvCRUDService', function ($scope,bvCRUDService) {
	  
    $scope.updateBV = function () {
        bvCRUDService.updateBV($scope.baiviet.MaBV,$scope.baiviet.TieuDe,$scope.baiviet.DanhMuc,$scope.baiviet.ChiTiet,$scope.baiviet.LichDang,$scope.baiviet.TrangThai,$scope.baiviet.Nhan)
          .then(function success(response){
              $scope.message = 'User data updated!';
              $scope.errorMessage = '';
          },
          function error(response){
              $scope.errorMessage = 'Error updating user!';
              $scope.message = '';
          });
    }
    
    $scope.getBVById = function () {
        var MaBV = $scope.baiviet.MaBV;
        bvCRUDService.getBVById($scope.baiviet.MaBV)
          .then(function success(response){
              $scope.baiviet = response.data;
              $scope.baiviet.MaBV = MaBV;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message = '';
              if (response.status === 404){
                  $scope.errorMessage = 'User not found!';
              }
              else {
                  $scope.errorMessage = "Error getting user!";
              }
          });
    }
    
    $scope.createBV = function () {
        if ($scope.baiviet != null && $scope.baiviet.TieuDe) {
            bvCRUDService.createBV($scope.baiviet.TieuDe,$scope.baiviet.DanhMuc,$scope.baiviet.ChiTiet,$scope.baiviet.LichDang,$scope.baiviet.TrangThai,$scope.baiviet.Nhan)
              .then (function success(response){
                  $scope.message = 'User added!';
                  $scope.errorMessage = '';
              },
              function error(response){
                  $scope.errorMessage = 'Error adding user!';
                  $scope.message = '';
            });
        }
        else {
            $scope.errorMessage = 'Please enter a name!';
            $scope.message = '';
        }
    }
    
    $scope.deleteBV = function () {
        bvCRUDService.deleteBV($scope.baiviet.MaBV)
          .then (function success(response){
              $scope.message = 'User deleted!';
              $scope.baiviet = null;
              $scope.errorMessage='';
          },
          function error(response){
              $scope.errorMessage = 'Error deleting user!';
              $scope.message='';
          })
    }
    
    $scope.getAllBV = function () {
        bvCRUDService.getAllBV()
          .then(function success(response){
              $scope.baiviets = response.data._embedded.baiviets;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response ){
              $scope.message='';
              $scope.errorMessage = 'Error getting users!';
          });
    }

}]);

ex10.service('bvCRUDService',['$http', function ($http) {
	
    this.getBVById = function getBVById(MaBV){
        return $http({
          method: 'GET',
          url: 'webresources/baiviet/mabv/'+MaBV
        });
	}
	
    this.createBV = function createBV(TieuDe, DanhMuc, ChiTiet, LichDang, TrangThai, Nhan){
        return $http({
          method: 'POST',
          url: 'webresources/baiviet/create',
          data: {TieuDe:TieuDe, DanhMuc:DanhMuc, ChiTiet:ChiTiet, LichDang:LichDang, TrangThai:TrangThai, Nhan:Nhan}
        });
    }
	
    this.deleteBV = function deleteBV(MaBV){
        return $http({
          method: 'DELETE',
          url: 'webresources/baiviet/delete/'+MaBV
        })
    }
	
    this.updateBV = function updateBV(MaBV, TieuDe, DanhMuc, ChiTiet, LichDang, TrangThai, Nhan){
        return $http({
          method: 'PATCH',
          url: 'webresources/baiviet/update/'+MaBV,
          data: {TieuDe:TieuDe, DanhMuc:DanhMuc, ChiTiet:ChiTiet, LichDang:LichDang, TrangThai:TrangThai, Nhan:Nhan}
        })
    }
	
    this.getAllBV = function getAllBV(){
        return $http({
          method: 'GET',
          url: 'webresources/baiviet/all'
        });
    }

}]);
