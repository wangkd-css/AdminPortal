var jobID;
var status;

function addWorkflow() {
	var jobID = $('#jobID').val();
	var status = $('#status').val();
	var nextJob = $('#nextJob').val();
	var waitTime = $('#waitTime').val();
	if (jobID.length <= 0) {
		alert("请输入用户名！")
		return;
	}
	if (status.length <= 0) {
		alert("请输入性别！")
		return;
	}
	if (nextJob <= 0) {
		alert("请输入员工号！")
		return;
	}
	if (waitTime <= 0) {
		alert("请输入邮箱！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "workflow/addWorkflow/",
		data:{'jobID':jobID,'status':status,'nextJob':nextJob,'waitTime':waitTime},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnWorkflowList";
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

function workflowList() {
	var url = URL + "workflow/workflowList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('workflow_list', data.data);
			document.getElementById('workflow__content').innerHTML = html;
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

function deleteWorkflow() {
	$('#deleteWorkflow').modal('hide');
	if (jobID.length <= 0) {
		alert("请确认用户名。")
		return;
	}
	var url = URL + "workflow/deleteWorkflow?jobID=" + jobID + "&status=" + status;
	$.get(url, function(data) {
		if (data.code == 1) {
			workflowList();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteWorkflow(id,sta) {
	jobID = id;
	status = sta
	$('#deleteWorkflow').modal('show');
}


function showUpdateWorkflow(id,sta) {
	var url = URL + "workflow/getWorkflow?jobID=" + id + "&status=" + sta;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#jobID').val(data.data[0].jobID);
			$('#status').val(data.data[0].status);
			$('#nextJob').val(data.data[0].nextJob);
			$('#waitTime').val(data.data[0].waitTime);
			$('#updateWorkflow').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateWorkflow() {
	var jobID = $('#jobID').val();
	var status = $('#status').val();
	var nextJob = $('#nextJob').val();
	var waitTime = $('#waitTime').val();
	if (jobID.length <= 0) {
		alert("请输入用户名！")
		return;
	}
	if (status.length <= 0) {
		alert("请输入性别！")
		return;
	}
	if (nextJob <= 0) {
		alert("请输入员工号！")
		return;
	}
	if (waitTime <= 0) {
		alert("请输入邮箱！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "workflow/updateWorkflow/",
		data:{'jobID':jobID,'status':status,'nextJob':nextJob,'waitTime':waitTime},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnWorkflowList";
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

