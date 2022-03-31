var app = angular.module("myapp", []);
app.controller("viewCril", function($scope){
    $scope.test = {};
    $scope.index = -1;
    // add
    $scope.save = function(){
        $scope.listCourses.push(angular.copy($scope.test))
    };
    // edit
    $scope.edit = function (index) {
        $scope.index = index;
        $scope.test = angular.copy($scope.listCourses[index]);
    }
    $scope.update = function(){
        $scope.listCourses[$scope.index] = angular.copy($scope.test)
    }
    // delete
    $scope.delete = function(){
        $scope.listCourses.splice($scope.index, 1);
        $scope.cancel();
    }
    $scope.cancel = function() {
        $scope.test = {};
    }
    $scope.listCourses = [
        {
            stt:"1",
            nameCourse: "Angular",
            statusCourse: "Done",
            startDay: "30/03/2022",
            endDay: "30/03/2024",
            teach: "Nguyễn Đăng Nhân",
            decription:"Nhanh Gọn Lẹ",
            image:"",
            edit: "Sửa",
            delete: "Xóa"
        }
    ]
})