var automataID;

function addAuto() {
	var automataID = $('#automataID').val();
	var automataName = $('#automataName').val();
	var automataType = $('#automataType').val();
	var status = $('#status').val();
	var maxTime = $('#maxTime').val();
	if (automataID.length <= 0) {
		alert("请输入课程番号！")
		return;
	}
	if (automataName.length <= 0) {
		alert("请输入课程名！")
		return;
	}
	if (automataType <= 0) {
		alert("请输入课程种类！")
		return;
	}
	if (status.length <= 0) {
		alert("请输入完成状态！")
		return;
	}
	if (maxTime <= 0) {
		alert("请输入完成期限！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "auto/addAuto/",
		data:{'automataID':automataID,'automataName':automataName,'automataType':automataType,'status':status,'maxTime':maxTime},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnAutoList";
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

function autoList() {
	var url = URL + "auto/autoList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('automata_list', data.data);
			document.getElementById('automata__content').innerHTML = html;
			url = URL + "whoim";
			$.get(url, function(data) {
				if(data.authorities[0].authority == 'admin'){
					$(".deleteButton").css("display","block")
				}
				else{
					$(".deleteButton").css("display","none")
				}
			});
		} else {
			alert(data.msg)
		}
	});
}

function deleteAuto() {
	$('#deleteAuto').modal('hide');
	if (automataID.length <= 0) {
		alert("请确认课程番号。")
		return;
	}
	var url = URL + "auto/deleteAuto?automataID="
		+ automataID;
	$.get(url, function(data) {
		if (data.code == 1) {
			autoList();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteAutoDialog(id) {
	automataID = id;
	$('#deleteAuto').modal('show');
}


function showUpdateAuto(id) {
	var url = URL + "auto/getAuto?automataID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#automataID').val(data.data[0].automataID);
			$('#automataName').val(data.data[0].automataName);
			$('#automataType').val(data.data[0].automataType);
			$('#status').val(data.data[0].status);
			$('#maxTime').val(data.data[0].maxTime);
			$('#updateAuto').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateAuto() {
	var automataID = $('#automataID').val();
	var automataName = $('#automataName').val();
	var automataType = $('#automataType').val();
	var status = $('#status').val();
	var maxTime = $('#maxTime').val();
	if (automataName.length <= 0) {
		alert("请输入课程名！")
		return;
	}
	if (automataType <= 0) {
		alert("请输入课程种类！")
		return;
	}
	if (status.length <= 0) {
		alert("请输入完成状态！")
		return;
	}
	if (maxTime <= 0) {
		alert("请输入完成期限！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "auto/updateAuto/",
		data:{'automataID':automataID,'automataName':automataName,'automataType':automataType,'status':status,'maxTime':maxTime},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnAutoList";
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

