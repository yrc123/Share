javascript:
var dom = $('[data-label=top10]').get(0);
var myChart = echarts.init(dom);
var x=new Array();
for(i=1;i<=10;i++)x.push("热词"+i);
option = {
	title: {
		text: 'Top10热词'
	},
	tooltip: {
		trigger: 'axis',
		enterable: true,
		alwaysShowContent: true,
		formatter: function (params, ticket, callback) {
			var res='';
			res+="热词："+params[0].name+"<br/>";
			res+="频次："+params[0].value+"<br/>";
			res+="相关论文<br/>";
			for(i=1;i<=10;i++){
				res+="<a href='#'>论文"+i+"</a><br/>"
			}
			return res;
		},
		position:function(point){
			return {
				left:point[0],
				top:0,
			}
		}
	},
	toolbox: {
		show: true,
		feature: {
			dataView: {
				readOnly: false
			},
			magicType: {
				type: ["line", "bar"]
			},
			restore: {},
			saveAsImage: {}
		}
	},
	legend: {
		data: ['热词']
	},
	xAxis: {
		type: 'category',
		data: x,
	},
	yAxis: {
		type: 'value'
	},
	dataZoom: [
		{
			type: 'slider',
			show: true,
			xAxisIndex: [0],
			start: 1,
			end: 100
		},
		{
			type: 'slider',
			show: true,
			yAxisIndex: [0],
			left: '93%',
			start: 1,
			end: 100
		},
		{
			type: 'inside',
			xAxisIndex: [0],
			start: 1,
			end: 100
		},
		{
			type: 'inside',
			yAxisIndex: [0],
			start: 1,
			end: 1
		}
	],
	series: [{
		color:"#409eff",
		name: '热词',
		data: [150,130,80,70,60,50,40,38,35,30],
		type: 'bar'
	}]
};
myChart.setOption(option, true);