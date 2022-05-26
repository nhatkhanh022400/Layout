google.load('visualization', '1.0', {'packages': ['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(drawChart1);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart1() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Topping');
    data.addColumn('number', 'Tỉ Lệ');
    data.addRows([
        ['Dừng Việc Học', 1],
        ['Đang Học', 1],
        ['Đã Hoàn Thành', 1]

    ]);

    // Set chart options
    var options = {'title': 'Biểu Đồ'};

    // Instantiate and draw our chart, passing in some options.
    var pieChart = new google.visualization.PieChart(document.getElementById('pie_chart_div'));
    pieChart.draw(data, options);

    var barChart = new google.visualization.BarChart(document.getElementById('bar_chart_div'));
    barChart.draw(data, options);
}

/* Gauage 
 --------------------------------------------------*/
var areaData;
var areaOptions;
var areaChart;

google.load("visualization", "1", {packages: ["corechart"]});
google.setOnLoadCallback(drawChart);

$(document).ready(function () {
    if ($.browser.mozilla) {
        //refresh page on browser resize
        // http://www.sitepoint.com/jquery-refresh-page-browser-resize/
        $(window).bind('resize', function (e) {
            if (window.RT)
                clearTimeout(window.RT);
            window.RT = setTimeout(function () {
                this.location.reload(false); /* false to get page from cache */
            }, 200);
        });
    } else {
        $(window).resize(function () {
            drawCharts();
            drawChart1();
        });
    }
});

/* Timeline
 --------------------------------------------------*/

/* Area Chart 
 --------------------------------------------------*/
function drawChart() {
    areaData = google.visualization.arrayToDataTable([
        ['Tháng', 'Đã Hoàn Thành', 'Đang Học', 'Dừng Việc Học'],
        ['Tháng 1', 100, 400, 550],
        ['Tháng 2', 1030, 500, 600],
        ['Tháng 3', 900, 450, 345],
        ['Tháng 4', 600, 670, 654],
        ['Tháng 5', 550, 800, 874],
        ['Tháng 6', 200, 300, 823],
        ['Tháng 7', 700, 789, 167],
        ['Tháng 8', 750, 90, 765],
        ['Tháng 9', 100, 470, 801],
        ['Tháng 10', 1170, 460, 391],
        ['Tháng 11', 660, 1120, 21],
        ['Tháng 12', 1030, 540, 51]
    ]);

    areaOptions = {
        title: 'Số Lượng',
        hAxis: {title: 'Tháng', titleTextStyle: {color: '#333'}},
        vAxis: {minValue: 0}
    };

    areaChart = new google.visualization.AreaChart(document.getElementById('area_chart_div'));
    areaChart.draw(areaData, areaOptions);
}
// End function drawChart

function drawCharts() {
    areaChart.draw(areaData, areaOptions);
}