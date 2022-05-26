var app = angular.module("myapp", []);
var b64;

function ManageCourseAPI(urlServlet, ApiTeacher, ApiJson) {
    app.controller("viewCril", function (Excel, Excel1, $timeout, $scope, $filter) {
        $scope.test = {};
        $scope.index = -1;

        // add
        $scope.save = function () {
            $.ajax({
                url: urlServlet,
                type: "post",
                data: {
                    CourseName: angular.copy($scope.test.courseName),
                    Status: angular.copy($scope.test.status),
                    StartDate: $filter('date')(angular.copy($scope.test.startDate), "yyyy-MM-dd"),
                    EndDate: $filter('date')(angular.copy($scope.test.endDate), "yyyy-MM-dd"),
                    MentorID: angular.copy($scope.test.mentorName),
                    Description: angular.copy($scope.test.courseDetailDescription),
                    ImageCourse: b64
                },
                success: function () {
                    location.reload();
                }
            });
        };

        $scope.edit = function (index) {
            $scope.index = index;
            $scope.test = angular.copy($scope.listCourses[index]);
        };

        $scope.update = function () {
            $.ajax({
                url: urlServlet,
                type: "post",
                data: {
                    UpdateCourseID: angular.copy($scope.test.courseID),
                    UpdateCourseName: angular.copy($scope.test.courseName),
                    UpdateStatus: angular.copy($scope.test.status),
                    UpdateStartDate: $filter('date')(angular.copy($scope.test.startDate), "yyyy-MM-dd"),
                    UpdateEndDate: $filter('date')(angular.copy($scope.test.endDate), "yyyy-MM-dd"),
                    UpdateMentorName: angular.copy($scope.test.mentorName),
                    UpdateDescription: angular.copy($scope.test.courseDetailDescription),
                    UpdateImageCourse: b64
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
                        DeleteCourseID: id
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

        $scope.teacherList = ApiTeacher;

        //Xuất Excel nguyên bảng
        $scope.exportToExcel = function (tableId) { // ex: '#my-table'
            var exportHref = Excel.tableToExcel(tableId, 'Danh sách khóa học');
            $timeout(function () {
                location.href = exportHref;
            }, 100); // trigger download
        };

        $scope.exportToLearner = function (tableId) { // ex: '#my-table'
            var exportHref = Excel1.tableToLearner(tableId, 'WireWorkbenchDataExport');
            $timeout(function () {
                location.href = exportHref;
            }, 100); // trigger download
        };
    });
}

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


app.factory('Excel1', function ($window) {
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
        tableToLearner: function (tableId, worksheetName) {
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

function openShow() {
    document.getElementById("showmore").style.display = "block";
}

function closeShow() {
    document.getElementById("showmore").style.display = "none";
}

// mã hóa hình ảnh thành base64
var input = document.querySelector('input[type=file]');
input.onchange = function () {
    var file = input.files[0],
            reader = new FileReader();

    reader.onloadend = function () {
        b64 = reader.result;
    };

    reader.readAsDataURL(file);
};

$(document).ready(function () {

    var readURL = function (input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    };

    $(".file-upload").on('change', function () {
        readURL(this);
    });

    $(".upload-button").on('click', function () {
        $(".file-upload").click();
    });
});