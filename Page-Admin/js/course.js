var app = angular.module("myapp", []);
app.controller("viewCril", function (Excel, $timeout, $scope) {
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
        $scope.listCourses.splice($scope.test);
    }
    $scope.cancel = function () {
        $scope.test = {};
    }

    // $scope.teachers = [
    //     {
    //         id: "1",
    //         name: "Jayce"
    //     },
    //     {
    //         id: "2",
    //         name: "ABC"
    //     },
    // ];

    $scope.listCourses = [
        {
            nameCourse: "Angular",
            statusCourse: "Done",
            startDay: "30/03/2022",
            endDay: "30/03/2022",
            // teach: teachers.name,
            listLearner: "fsdhfjdshfhdskfjhdsjhfjkdshfkdjshfkjdhsjfhhfjdshfkjsdhfkjhdskjfhdjsfjkdshfkjsdhfkjhsdkjfhkjdshfkjdshfjkhdsjkfhdsfjhkdjshfkjds",
            decription: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            sdt: "012345678",
            email: "abc@gmail.com",
            list: "nguyễn văn a-187it2345",
            image: "../images/logo-01.png"

        }

    ];



    //Xuất Excel
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


function openForm() {
    document.getElementById("add-edit").style.display = "inline";
    document.getElementById("update").style.display = "none";
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
   
    var b64 = reader.result.replace(/^data:.+;base64,/, '');
    console.log(b64); 
  };

  reader.readAsDataURL(file);
};

