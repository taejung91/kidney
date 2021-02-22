<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://www.gstatic.com/charts/loader.js"></script>
 <script>
 google.charts.load('current', {packages: ['corechart']});
 google.charts.setOnLoadCallback(drawChart);

 function drawChart() {
	 var test = graph.test.value;
	 var rs = Number(test);
	 
     var data = google.visualization.arrayToDataTable([
       ['종류', '섭취량', { role: 'style' } ],
       ['칼로리', rs, 'color: gray'],
       ['나트륨', 64, 'color: #76A7FA'],
       ['단백질', 56, 'opacity: 0.2'],
       ['칼륨', 62, 'color: #76A7FA'],
       ['인', 150, 'color: #76A7FA'],
       ['칼슘', 20, 'color: #76A7FA']
     ]);

     var view = new google.visualization.DataView(data);
     view.setColumns([0, 1,
                      { calc: "stringify",
                        sourceColumn: 1,
                        type: "string",
                        role: "annotation" },
                      2]);
     
     
     var options = {
       title: '식단 계산기',
       width:'100%',
       height:300,
       chartArea: {width: '40%' },
       hAxis: {
         title: '섭취량',
         minValue: 0,
         viewWindow:{max:100}
       },
       vAxis: {
         title: ''
       },
       bar: { groupWidth: "70%" },
       animation:{ startup:true, duration:1000, easing:'linear'},
       
     };

     var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

     chart.draw(view, options);
     
     window.addEventListener('resize', function() { chart.draw(view, options); }, false);

   }
 google.charts.setOnLoadCallback(drawChart);


 
 </script>
</head>
<style type="text/css">

</style>
<body>

 <div id="chart_div"></div></td>

      <form name="graph" method="post">
      <input type="hidden" id="test" value="50">
      </form>
</body>
</html>