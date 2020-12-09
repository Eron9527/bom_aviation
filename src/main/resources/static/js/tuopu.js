var nodes = null;
var edges = null;
var network = null;

var DIR = "images/";
var EDGE_LENGTH_MAIN = 150;
var EDGE_LENGTH_SUB = 120;

// Called when the Visualization API is loaded.
function draw() {
  // Create a data table with nodes.
  nodes = [];

  // Create a data table with links.
  edges = [];

  nodes.push({
    id: 1,
    label: "交换机",
    image: DIR + "交换机.png",
    shape: "image",
  });
  nodes.push({
    id: 2,
    label: "交换机",
    image: DIR + "交换机.png",
    shape: "image",
  });
  nodes.push({
    id: 3,
    label: "交换机",
    image: DIR + "交换机.png",
    shape: "image",
  });
  
  edges.push({ 
	from: 1,
	to: 2,
	length: EDGE_LENGTH_MAIN 
  });
  
  edges.push({ 

	label: '11',
    from: 1, 
	to: 3, 
	length: EDGE_LENGTH_MAIN 
  });

  for (var i = 4; i <= 7; i++) {
    nodes.push({
      id: i,
      label: "192.68.100."+i,
      image: DIR + "服务器.png",
      shape: "image",
    });
    edges.push({ 
	  label: '15 MB/s',
	  from: 2, 
	  to: i, 
	  color: '',
	  length: EDGE_LENGTH_SUB 
	});
  }

  nodes.push({
    id: 101,
    label: "192.68.100.8",
    image: DIR + "服务器.png",
    shape: "image",
  });
  edges.push({ 
	label: '4 MB/s',
	from: 2, 
	to: 101, 
	length: EDGE_LENGTH_SUB 
  });

  nodes.push({
    id: 102,
    label: "192.68.100.8",
    image: DIR + "服务器.png",
    shape: "image",
    shapeProperties: {
      useImageSize: true,
      useBorderWithImage: false,
      interpolation: false,
    },
  });
  edges.push({ 
	  label: '20 MB/s',
	  from: 3, 
	  to: 102, 
	  length: EDGE_LENGTH_SUB 
  });

  nodes.push({
    id: 103,
    label: "192.68.100.9",
    image: DIR + "服务器.png",
    shape: "image",
  });
  edges.push({ 
	  label: '30 MB/s',
	  from: 1, 
	  to: 103, 
	  length: EDGE_LENGTH_SUB 
  });

  nodes.push({
    id: 104,
    label: "192.68.100.10",
    image: DIR + "服务器.png",
    shape: "image",
  });
  edges.push({ 
	  label: '10 MB/s',
	  from: 1, 
	  to: 104, 
	  length: EDGE_LENGTH_SUB 
  });

  for (var i = 200; i <= 201; i++) {
    nodes.push({
      id: i,
      label: "192.68.100.11",
      image: DIR + "服务器.png",
      shape: "image",
      shapeProperties: {
        useImageSize: true,
        useBorderWithImage: false,
        interpolation: false,
      },
    });
    edges.push({ 
		color:'red',
		from: 3, 
		to: i, 
		length: EDGE_LENGTH_SUB 
	});
  }

  // create a network
  var container = document.getElementById("tuopu");
  var data = {
    nodes: nodes,
    edges: edges,
  };
  
  var options = {
    nodes: {
      size: 30,
	  font: {
			 color:'#ffffff',
			 size: 10, // px
			 background: 'none',
			 strokeColor: 'none',
		 },
      shapeProperties: {
        useImageSize: true,
        useBorderWithImage: false,

      },
    },
	edges: {
		width:2,
		 font: {
			 color:'yellow',
			 size: 10, // px
			 background: 'none',
			 strokeColor: 'none',
		 },
		 color: {
		  color:'#36ab28',
		  highlight:'#36ab28',
		  hover: 'none',
		  inherit: 'from',
		  opacity:1.0
		},
	},


	layout: {
		randomSeed: 1,
		improvedLayout: true,
		clusterThreshold: 150,
		hierarchical: {
		  enabled: false,
		  levelSeparation: 150,
		  nodeSpacing: 100,
		  treeSpacing: 200,
		  blockShifting: true,
		  edgeMinimization: true,
		  parentCentralization: true,
		  direction: 'LR',        // UD, DU, LR, RL
		  sortMethod: 'hubsize',  // hubsize, directed
		  shakeTowards: 'leaves'  // roots, leaves
		}
	  },
 
	autoResize: true,
	interaction: {
		dragNodes:true,//是否能拖动节点
		dragView:false,//是否能拖动画布
		hideEdgesOnDrag:false,//拖动画布时是否隐藏连接线
		hideNodesOnDrag:false,//拖动画布时是否隐藏节点
		hover: true,//鼠标移过后加粗该节点和连接线
		keyboard:false,//
		multiselect:false,//按 ctrl 多选
		navigationButtons:false,//是否显示控制按钮
		selectable:false,//是否可以点击选择
		selectConnectedEdges:true,//选择节点后是否显示连接线
		hoverConnectedEdges:false,//鼠标滑动节点后是否显示连接线
		zoomView:false//是否能缩放画布
	},
	
	
  };
  
  network = new vis.Network(container, data, options);

	
}

window.addEventListener("load", () => {
 
  draw();
});


