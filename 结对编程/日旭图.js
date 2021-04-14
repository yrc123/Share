var chartDom = document.getElementById('main');
var myChart = echarts.init(chartDom);
var option;

var data = [{
    name: 'CVPR',
    children: [{
        name: '2018',
        children: [{
            name: '热词1',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 4
            },{
                name: '论文3',
                value: 3
            },{
                name: '论文4',
                value: 3
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词3',
            children: [{
                name: '论文1',
                value: 4
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词4',
            children: [{
                name: '论文1',
                value: 5
            }
            ]
        }, {
            name: '热词5',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }
        ]
    }, {
        name: '2017',
        children: [  {
            name: '热词1',
            children: [{
                name: '论文1',
                value: 4
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 5
            }
            ]
        }, {
            name: '热词3',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }]
    }, {
        name: '2016',
        children: [  {
            name: '热词1',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }]
    }]
}, {
    name: 'ICCV',
    children: [{
        name: '2018',
        children: [{
            name: '热词1',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 4
            },{
                name: '论文3',
                value: 3
            },{
                name: '论文4',
                value: 3
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词3',
            children: [{
                name: '论文1',
                value: 4
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词4',
            children: [{
                name: '论文1',
                value: 5
            }
            ]
        }, {
            name: '热词5',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }
        ]
    }, {
        name: '2017',
        children: [  {
            name: '热词1',
            children: [{
                name: '论文1',
                value: 4
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 5
            }
            ]
        }, {
            name: '热词3',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }]
    }, {
        name: '2016',
        children: [  {
            name: '热词1',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }]
    }]
}, {
    name: 'ECCV',
    children: [{
        name: '2018',
        children: [{
            name: '热词1',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 4
            },{
                name: '论文3',
                value: 3
            },{
                name: '论文4',
                value: 3
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词3',
            children: [{
                name: '论文1',
                value: 4
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词4',
            children: [{
                name: '论文1',
                value: 5
            }
            ]
        }, {
            name: '热词5',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }
        ]
    }, {
        name: '2017',
        children: [  {
            name: '热词1',
            children: [{
                name: '论文1',
                value: 4
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 5
            }
            ]
        }, {
            name: '热词3',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }]
    }, {
        name: '2016',
        children: [  {
            name: '热词1',
            children: [{
                name: '论文1',
                value: 5
            },{
                name: '论文2',
                value: 2
            }
            ]
        }, {
            name: '热词2',
            children: [{
                name: '论文1',
                value: 2
            }
            ]
        }]
    }]
}];

option = {
    visualMap: {
        type: 'continuous',
        min: 0,
        max: 20,
        inRange: {
            color: ['#2F93C8', '#AEC48F', '#FFDB5C', '#F98862']
        }
    },
    series: {
        type: 'sunburst',
        data: data,
        radius: [0, '90%'],
        label: {
            rotate: 'radial'
        }
    }
};

option && myChart.setOption(option);
