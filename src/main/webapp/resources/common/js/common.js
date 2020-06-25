

// 向调用此js文件的html输出必要的js文件
// Begin-------------------------------------------------------------------------------------//


document.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>');
document.write('<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>');
document.write('<script src="/resources/plugins/jquery.cookie.min.js"></script>');
// document.write('<script language="Javascript"
// src="/resources/plugins/jquery.min.js"></script>');
// document.write('<script language="Javascript"
// src="/resources/plugins/bootstrap.min.js"></script>');
// document.write('<script language="Javascript"
// src="/resources/plugins/jqthumb.min.js"></script>');



/**
 * 缩略图功能,保持图片统一
 * 
 * @param imgLabelId
 *            图片标签ID
 * @param imgHeight
 *            图片高度
 * @returns
 */
function DrawImage(imgLabelId,imgHeight)
{
	$(imgLabelId).jqthumb({
	classname : 'jqthumb',
	width : '100%',// 宽度
	height : imgHeight,// 高度
	position : {
	y : '0%',
	x : '0%'
	},// 从图片的中间开始产生缩略图
	zoom : '1',// 缩放比例
	method : 'auto',// 提交方法，用于不同的浏览器环境，默认为‘auto’
	});
}

function DateFormat(){
 Date.prototype.Format = function(fmt)   
 { 
   var o = {   
     "M+" : this.getMonth()+1,                 // 月份   
     "d+" : this.getDate(),                    // 日
     "h+" : this.getHours(),                   // 小时   
     "m+" : this.getMinutes(),                 // 分   
     "s+" : this.getSeconds(),                 // 秒   
     "q+" : Math.floor((this.getMonth()+3)/3), // 季度   
     "S"  : this.getMilliseconds()             // 毫秒   
   };   
   if(/(y+)/.test(fmt))   
     fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 -
 RegExp.$1.length));   
   for(var k in o)   
     if(new RegExp("("+ k +")").test(fmt))   
   fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+
 o[k]).substr((""+ o[k]).length)));   
   return fmt;   
 };
};


function nightTheme()
{
	var backColor = $.cookie('backColor');
	if (backColor == 0)
	{
		day_1();
	}
	if (backColor == 1)
	{
		night_1();
	}
};

function night_1()
{
	$("body").addClass("black1");
	$("div").addClass("black1");
	$("p").addClass("black1");
	$("a").addClass("black1");
	$("#topNav").addClass("navbar-inverse");

};
function day_1()
{
	$("body").removeClass("black1");
	$("div").removeClass("black1");
	$("p").removeClass("black1");
	$("a").removeClass("black1");
	$("#topNav").removeClass("navbar-inverse");
};