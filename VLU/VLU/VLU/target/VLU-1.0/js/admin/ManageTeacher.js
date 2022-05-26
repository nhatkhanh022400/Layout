var app = angular.module("myapp", []);

function ManageTeacherAPI(urlServlet, ApiJson) {
    app.controller("viewCril", function (Excel, $timeout, $scope) {
        $scope.test = {};
        $scope.index = -1;

        // add
        $scope.save = function () {
            $.ajax({
                url: urlServlet,
                type: "post",
                data: {
                    MentorName: angular.copy($scope.test.mentorName),
                    MentorPhone: angular.copy($scope.test.mentorPhone),
                    MentorEmail: angular.copy($scope.test.mentorEmail)
                },
                success: function () {
                    location.reload();
                }
            });
        };

        // edit
        $scope.edit = function (index) {
            $scope.index = index;
            $scope.test = angular.copy($scope.listCourses[index]);
        };

        $scope.update = function () {
            $.ajax({
                url: urlServlet,
                type: "post",
                data: {
                    UpdateMentorID: angular.copy($scope.test.mentorID),
                    UpdateMentorName: angular.copy($scope.test.mentorName),
                    UpdateMentorPhone: angular.copy($scope.test.mentorPhone),
                    UpdateMentorEmail: angular.copy($scope.test.mentorEmail)
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
                        MentorID: id
                    },
                    success: function () {
                        location.reload();
                    }
                });
            }
        };

        $scope.cancel = function () {
            $scope.test = {};
        };

        $scope.listCourses = ApiJson;

        //Xuất file Excel
        $scope.exportToExcel = function (tableId) {
            var exportHref = Excel.tableToExcel(tableId, 'WireWorkbenchDataExport');
            $timeout(function () {
                location.href = exportHref;
            }, 100);
        };
    });
}
;

app.factory('Excel', function ($window) {
    var uri = 'data:application/vnd.ms-excel;base64,',
            template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
            base64 = function (s) {
                return $window.btoa(unescape(encodeURIComponent(s)));
            },
            format = function (s, c) {
                return s.replace(/{(\w+)}/g, function (m, p) {
                    return c[p];
                });
            };
    return {
        tableToExcel: function (tableId, worksheetName) {
            var table = $(tableId),
                    ctx = {worksheet: worksheetName, table: table.html()},
                    href = uri + base64(format(template, ctx));
            return href;
        }
    };
});

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