javascript:
var dom = $('[data-label=hotWord]').get(0);
var myChart = echarts.init(dom);
    option = {
        title:{
            text:'近年热词'
        },
        legend: {},
        tooltip: {
            trigger: 'axis',
            showContent: false
        },
        dataset: {
            source: [
                ['product', '2012', '2013', '2014', '2015', '2016', '2017'],
                ['hotWord1', 56.5, 82.1, 88.7, 70.1, 53.4, 85.1],
                ['hotWord2', 51.1, 51.4, 55.1, 53.3, 73.8, 68.7],
                ['hotWord3', 40.1, 62.2, 69.5, 36.4, 45.2, 32.5],
                ['hotWord4', 25.2, 37.1, 41.2, 18, 33.9, 49.1],
                ['hotWord5', 53.5, 42.1, 48.7, 67.1, 63.4, 55.1],
                ['hotWord6', 61.1, 55.4, 35.1, 43.3, 63.8, 38.7],
                ['hotWord7', 50.1, 32.2, 49.5, 76.4, 85.2, 92.5],
                ['hotWord8', 35.2, 47.1, 51.2, 38, 23.9, 89.1]
            ]
        },
        xAxis: {type: 'category'},
        yAxis: {gridIndex: 0},
        grid: {top: '55%'},
        series: [
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {type: 'line', smooth: true, seriesLayoutBy: 'row', emphasis: {focus: 'series'}},
            {
                type: 'pie',
                id: 'pie',
                radius: '30%',
                center: ['50%', '25%'],
                emphasis: {focus: 'data'},
                label: {
                        formatter: function(p){
                            var index=p.dataIndex;
                            var encode = p.encode;
                            var res = '';
                            res+=p.name+': ';
                            res+=p.value[encode.value[0]];
                            res+="("+p.percent+"%)";
                            res+='\n来源:'+meet[Math.floor((encode.value[0])/2)];
                            return res;
                        }
                },
                encode: {
                    itemName: 'product',
                    value: '2012',
                    tooltip: '2012'
                }
            }
        ]
    };
	var meet=['meet1','meet2','meet3','meet4'];
    myChart.on('updateAxisPointer', function (event) {
        var xAxisInfo = event.axesInfo[0];
        if (xAxisInfo) {
            var dimension = xAxisInfo.value + 1;
            myChart.setOption({
                series: {
                    id: 'pie',
                    label: {
                        formatter: function(p){
                            var index=p.dataIndex;
                            var encode = p.encode;
                            var res = '';
                            res+=p.name+': ';
                            res+=p.value[encode.value[0]];
                            res+="("+p.percent+"%)";
                            res+='\n来源:'+meet[Math.floor((encode.value[0])/2)];
                            return res;
                        }
                    },
                    encode: {
                        value: dimension,
                        tooltip: dimension
                    }
                }
            });
        }
    });
    myChart.setOption(option);
