function getGjJhRdOption(){
	
	//app.title = '近一周内的告警项目出现次数热力图';

	var exps = ['01', '02', '03', '04', '05', '06', '07',
	    '08', '09', '10', '11', '12', '13', '14',
	    '15', '16', '17', '18', '19', '20', '21',
	    '22', '23', '24'
	];
	var date = ['04/28', '04/27', '04/26', '04/25', '04/24', '04/23', '04/22'];

	var data = [
	    ['04/28', 0, 75],
	    ['04/28', 1, 60],
	    ['04/28', 2, 0],
	    ['04/28', 3, 0],
	    ['04/28', 4, 20],
	    ['04/28', 5, 0],
	    ['04/28', 6, 0],
	    ['04/28', 7, 0],
	    ['04/28', 8, 0],
	    ['04/28', 9, 0],
	    ['04/28', 10, 0],
	    ['04/28', 11, 20],
	    ['04/28', 12, 40],
	    ['04/28', 13, 10],
	    ['04/28', 14, 65],
	    ['04/28', 15, 30],
	    ['04/28', 16, 40],
	    ['04/28', 17, 60],
	    ['04/28', 18, 40],
	    ['04/28', 19, 45],
	    ['04/28', 20, 30],
	    ['04/28', 21, 30],
	    ['04/28', 22, 20],
	    ['04/28', 23, 50],
	    [1, 0, 70],
	    [1, 1, 0],
	    [1, 2, 0],
	    [1, 3, 0],
	    [1, 4, 0],
	    [1, 5, 0],
	    [1, 6, 0],
	    [1, 7, 0],
	    [1, 8, 0],
	    [1, 9, 0],
	    [1, 10, 50],
	    [1, 11, 20],
	    [1, 12, 25],
	    [1, 13, 60],
	    [1, 14, 90],
	    [1, 15, 100],
	    [1, 16, 65],
	    [1, 17, 75],
	    [1, 18, 80],
	    [1, 19, 95],
	    [1, 20, 5],
	    [1, 21, 5],
	    [1, 22, 70],
	    [1, 23, 2],
	    [2, 0, 1],
	    [2, 1, 1],
	    [2, 2, 0],
	    [2, 3, 0],
	    [2, 4, 0],
	    [2, 5, 0],
	    [2, 6, 0],
	    [2, 7, 0],
	    [2, 8, 0],
	    [2, 9, 0],
	    [2, 10, 3],
	    [2, 11, 2],
	    [2, 12, 1],
	    [2, 13, 9],
	    [2, 14, 8],
	    [2, 15, 10],
	    [2, 16, 6],
	    [2, 17, 5],
	    [2, 18, 5],
	    [2, 19, 5],
	    [2, 20, 7],
	    [2, 21, 4],
	    [2, 22, 2],
	    [2, 23, 4],
	    [3, 0, 7],
	    [3, 1, 3],
	    [3, 2, 0],
	    [3, 3, 0],
	    [3, 4, 0],
	    [3, 5, 0],
	    [3, 6, 0],
	    [3, 7, 0],
	    [3, 8, 1],
	    [3, 9, 0],
	    [3, 10, 5],
	    [3, 11, 4],
	    [3, 12, 7],
	    [3, 13, 14],
	    [3, 14, 13],
	    [3, 15, 12],
	    [3, 16, 9],
	    [3, 17, 5],
	    [3, 18, 5],
	    [3, 19, 10],
	    [3, 20, 6],
	    [3, 21, 4],
	    [3, 22, 4],
	    [3, 23, 1],
	    [4, 0, 1],
	    [4, 1, 3],
	    [4, 2, 0],
	    [4, 3, 0],
	    [4, 4, 0],
	    [4, 5, 1],
	    [4, 6, 0],
	    [4, 7, 0],
	    [4, 8, 0],
	    [4, 9, 2],
	    [4, 10, 4],
	    [4, 11, 4],
	    [4, 12, 2],
	    [4, 13, 4],
	    [4, 14, 4],
	    [4, 15, 14],
	    [4, 16, 12],
	    [4, 17, 1],
	    [4, 18, 8],
	    [4, 19, 5],
	    [4, 20, 3],
	    [4, 21, 7],
	    [4, 22, 3],
	    [4, 23, 0],
	    [5, 0, 2],
	    [5, 1, 1],
	    [5, 2, 0],
	    [5, 3, 3],
	    [5, 4, 0],
	    [5, 5, 0],
	    [5, 6, 0],
	    [5, 7, 0],
	    [5, 8, 2],
	    [5, 9, 0],
	    [5, 10, 4],
	    [5, 11, 1],
	    [5, 12, 5],
	    [5, 13, 10],
	    [5, 14, 5],
	    [5, 15, 7],
	    [5, 16, 11],
	    [5, 17, 6],
	    [5, 18, 0],
	    [5, 19, 5],
	    [5, 20, 3],
	    [5, 21, 4],
	    [5, 22, 2],
	    [5, 23, 0],
	    [6, 0, 1],
	    [6, 1, 0],
	    [6, 2, 0],
	    [6, 3, 0],
	    [6, 4, 0],
	    [6, 5, 0],
	    [6, 6, 0],
	    [6, 7, 0],
	    [6, 8, 0],
	    [6, 9, 0],
	    [6, 10, 1],
	    [6, 11, 0],
	    [6, 12, 2],
	    [6, 13, 1],
	    [6, 14, 3],
	    [6, 15, 4],
	    [6, 16, 0],
	    [6, 17, 0],
	    [6, 18, 0],
	    [6, 19, 0],
	    [6, 20, 1],
	    [6, 21, 2],
	    [6, 22, 2],
	    [6, 23, 6]
	];

	data = data.map(function(item) {
	    return [item[1], item[0], item[2] || '-'];
	});

	option = {
	    title: {
					text: '近一周内的告警项目出现次数热力图',
					left: 'center',
					y: 5,
					
				},
	    tooltip: {
	        position: 'top'
	    },
	    animation: false,
	    grid: {
	        top:'20%',
	       
	    },
	    xAxis: {
	        type: 'category',
	        data: exps,
	        splitArea: {
	            show: true
	        }
	    },
	    yAxis: {
	        type: 'category',
	        data: date,
	        splitArea: {
	            show: true
	        }
	    },
	    visualMap: {
	        min: 0,
	        max: 100,
	        calculable: true,
	        bottom: '50%',
	        left: 'right'
	    },
	    series: [{
	        name: '告警项目出现次数',
	        type: 'heatmap',
	        data: data,
	        label: {
	            normal: {
	                show: true
	            }
	        },
	        itemStyle: {
	            emphasis: {
	                shadowBlur: 10,
	                shadowColor: 'rgba(0, 0, 0, 0.5)'
	            }
	        }
	    }]
	};
	
	
	return option;
}