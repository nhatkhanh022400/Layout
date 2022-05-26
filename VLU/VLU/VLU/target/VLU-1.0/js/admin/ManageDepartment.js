var app = angular.module("myapp", []);

function ManageDepartmentAPI(urlServlet, ApiJson) {
    app.controller("viewCril", function ($scope) {
        $scope.test = {};
        $scope.index = -1;

        // add
        $scope.save = function () {
            $.ajax({
                url: urlServlet,
                type: "post",
                data: {
                    AddDepartmentName: angular.copy($scope.test.departmentName)
                },
                success: function () {
                    location.reload();
                }
            });
        };

        // edit
        $scope.edit = function (index) {
            $scope.index = index;
            $scope.test = angular.copy($scope.listDepartments[index]);
        };

        $scope.update = function () {
            $.ajax({
                url: urlServlet,
                type: "post",
                data: {
                    UpdateDepartmentID: angular.copy($scope.test.departmentID),
                    UpdateDepartmentName: angular.copy($scope.test.departmentName)
                },
                success: function () {
                    location.reload();
                }
            });
        };

        // delete
        $scope.delete = function (id) {
            if (confirm("Bạn có chắc chắn bạn muốn xóa?"))
            {
                $.ajax({
                    url: urlServlet,
                    type: "post",
                    data: {
                        DeleteDepartmentID: id
                    },
                    success: function () {
                        location.reload();
                    }
                });
            }
        };

        // Hủy
        $scope.cancel = function () {
            $scope.test = {};
        };

        $scope.listDepartments = ApiJson;

    });
}
;

function openForm() {
    document.getElementById("add-edit").style.display = "inline";
    document.getElementById("update").style.display = "none";
    document.getElementById("add").style.display = "inline";
}

function openFormDemo() {
    document.getElementById("add-edit").style.display = "inline";
    document.getElementById("add").style.display = "none";
    document.getElementById("update").style.display = "inline";
}

function closeForm() {
    document.getElementById("add-edit").style.display = "none";
}