var app = angular.module("myapp", []);
app.controller("viewCril", function ($scope) {
    $scope.test = {};
    $scope.index = -1;

    // add
    $scope.save = function () {
        $scope.listCourses.push(angular.copy($scope.test))
    };
    // edit
    $scope.edit = function (index) {
        $scope.index = index;
        $scope.test = angular.copy($scope.listCourses[index]);
    }
    $scope.update = function () {
        $scope.listCourses[$scope.index] = angular.copy($scope.test)
    }
    // delete
    $scope.delete = function () {
        $scope.listCourses.splice($scope.index, 1);
        $scope.cancel();
    }
    $scope.cancel = function () {
        $scope.test = {};
    }
    $scope.listCourses = [
        {
            name: "Jayce",
            phone: "012345678",
            email: "abc@gmail.com",
            department: "Khoa CNTT",
        }
    ]

    //Xuất file Excel

    $scope.exportToExcel = function (tableId) { // ex: '#my-table'
        var exportHref = Excel.tableToExcel(tableId, 'WireWorkbenchDataExport');
        $timeout(function () { location.href = exportHref; }, 100); // trigger download
    }
})


app.factory('Excel', function ($window) {
    var uri = 'data:application/vnd.ms-excel;base64,',
        template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
        base64 = function (s) { return $window.btoa(unescape(encodeURIComponent(s))); },
        format = function (s, c) { return s.replace(/{(\w+)}/g, function (m, p) { return c[p]; }) };
    return {
        tableToExcel: function (tableId, worksheetName) {
            var table = $(tableId),
                ctx = { worksheet: worksheetName, table: table.html() },
                href = uri + base64(format(template, ctx));
            return href;
        }
    };
})

