$(document).ready(function() {
	var url = decodeURI(window.location.search) ;
	var userId="";
	if (url.indexOf("?") != -1) {    //判断是否有参数
		userId = url.substr(1); //从第一个字符开始 因为第0个是?号 获取所有除问号的所有符串
		/*str=decode(str);
		var strs = str.split("=");   //用等号进行分隔 （因为知道只有一个参数 所以直接用等号进分隔 如果有多个参数 要用&号分隔 再用等号进行分隔）
		userId=strs[1]; */         //直接弹出第一个参数 （如果有多个参数 还要进行循环的）
		
	}
	$("#userId").val(userId);
	
	$("#sub").click(function() {
		var  check= checkData();
		if(!check){
			return;
		}
		var userID = $("#userId").val();
		insertSupplierInfo(userID);
	});
	
	

	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
		var r = url.substr(1).match(reg); // 匹配目标参数
		if (r != null)
			return unescape(r[2]);
		return null; // 返回参数值
	}	

})


function decode(s) {
	return unescape(s.replace(/\\(u[0-9a-fA-F]{4})/gm, '%$1'));
}


function insertSupplierInfo(userID){
	var clientProvince = $("#clientProvince").val();
	var clientCity = $("#clientCity").val();
	var clientOperator = $("#clientOperator").val();
	var projectLeader = $("#projectLeader").val();
	var clientDepartment = $("#clientDepartment").val();
	var clientPhone = $("#clientPhone").val();
	var businessType = $("#businessType").val();
	var stage = $("#stage").val();
	var itemAmount = $("#itemAmount").val();
	var accessToInfo = $("#accessToInfo").val();
	var projectDesc = $("#projectDesc").val();
	$.ajax({
		type : "POST",
		url : "supplier/insertSupplierInfo",
		async: false, 
		data : {
			userId:userID,
			clientProvince : clientProvince,
			clientCity : clientCity,
			clientOperator : clientOperator,
			projectLeader : projectLeader,
			clientDepartment : clientDepartment,
			clientPhone : clientPhone,
			businessType : businessType,
			stage : stage,
			itemAmount : itemAmount,
			accessToInfo : accessToInfo,
			projectDesc : projectDesc
		},
		success : function(data) {
			 $("#userId").val(userID);
			 $("#userSite").val(userSite);
			 $("#userPostion").val(userPostion);
			 $("#userPhone").val(userPhone);
			 $("#userEmail").val(userEmail);
			 $("#clientProvince").val(clientProvince);
			 $("#clientCity").val(clientCity);
			 $("#clientOperator").val(clientOperator);
			 $("#projectLeader").val(projectLeader);
			 $("#clientDepartment").val(clientDepartment);
			 $("#clientPhone").val(clientPhone);
			 $("#businessType").val(businessType);
			 $("#stage").val(stage);
			 $("#itemAmount").val(itemAmount);
			 $("#accessToInfo").val(accessToInfo);
			 $("#projectDesc").val(projectDesc);
			 $("#sub").attr("disabled","disabled");
			 toastr.success('提交数据成功');
		},
		 error: function(request) {
			 toastr.error('提交失败')
         }
		
	});
		
}
function checkData() {
	var clientProvince = $.trim($("#clientProvince").val());
	var clientCity = $.trim($("#clientCity").val());
	var clientOperator = $.trim($("#clientOperator").val());
	var projectLeader = $.trim($("#projectLeader").val());
	var clientDepartment = $.trim($("#clientDepartment").val());
	var clientPhone = $.trim($("#clientPhone").val());
	var businessType = $.trim($("#businessType").val());
	var stage = $.trim($("#stage").val());
	var itemAmount = $.trim($("#itemAmount").val());
	var accessToInfo = $.trim($("#accessToInfo").val());
	var projectDesc = $.trim($("#projectDesc").val());
	if(clientProvince == "" ||  clientProvince.length >20){
		return false;
	}
	if(clientCity==""|| clientCity.length >20){
		return false;
	} 
	if(clientOperator==""||clientOperator.length >20){
		return false;
	} 
	if(projectLeader==""||projectLeader.length >20){
		return false;
	} 
	if(clientDepartment==""|| clientDepartment.length >50){
		return false;
	} 
	if(clientPhone==""||clientPhone.length >20){
		return false;
	} 
	if(businessType==""||businessType.length >10){
		return false;
	} 
	if(stage==""||stage.length >10){
		return false;
	} 
	if(itemAmount==""){
		return false;
	}else{
		var reg = /^(0|[1-9]\d{0,6})(\.\d{1,2})?$/;          
        if(!reg.test(itemAmount)){
        	return false;
        }
	}
	if(accessToInfo==""||clientProvince.length >100){
		return false;
	} 
	if(projectDesc==""||clientProvince.length >200){
		return false;
	} 
	return true;
}
