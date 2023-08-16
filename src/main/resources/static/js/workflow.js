var userID;
/*var status;*/

function addWorkflow() {
	var userID = $('#userID').val();
	var gender = $('#gender').val();
	var employeeNum = $('#employeeNum').val();
	var mailbox = $('#mailbox').val();
	if (userID.length <= 0) {
		alert("请输入用户名！")
		return;
	}
	if (gender.length <= 0) {
		alert("请输入性别！")
		return;
	}
	if (employeeNum.length <= 0) {
		alert("请输入员工号！")
		return;
	}
	if (mailbox.length <= 0) {
		alert("请输入邮箱！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "workflow/addWorkflow/",
		data:{'userID':userID,'gender':gender,'employeeNum':employeeNum,'mailbox':mailbox},
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
	if (userID.length <= 0) {
		alert("请确认用户名。")
		return;
	}
/*	var url = URL + "workflow/deleteWorkflow?jobID=" + jobID + "&status=" + status;*/
	var url = URL + "workflow/deleteWorkflow?userID=" + userID;
	$.get(url, function(data) {
		if (data.code == 1) {
			workflowList();
		} else {
			alert(data.msg);
		}
	});

}

/*function showDeleteWorkflow(id,sta) {*/
function showDeleteWorkflow(id) {
	userID = id;
/*	status = sta*/
	$('#deleteWorkflow').modal('show');
}


/*function showUpdateWorkflow(id,sta) {
	var url = URL + "workflow/getWorkflow?jobID=" + id + "&status=" + sta;*/
function showUpdateWorkflow(id) {
	var url = URL + "workflow/getWorkflow?userID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#userID').val(data.data[0].userID);
			$('#gender').val(data.data[0].gender);
			$('#employeeNum').val(data.data[0].employeeNum);
			$('#mailbox').val(data.data[0].mailbox);
			$('#updateWorkflow').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateWorkflow() {
	var userID = $('#userID').val();
	var gender = $('#gender').val();
	var employeeNum = $('#employeeNum').val();
	var mailbox = $('#mailbox').val();
	if (userID.length <= 0) {
		alert("请输入用户名！")
		return;
	}
	if (gender.length <= 0) {
		alert("请输入性别！")
		return;
	}
	if (employeeNum.length <= 0) {
		alert("请输入员工号！")
		return;
	}
	if (mailbox.length <= 0) {
		alert("请输入邮箱！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "workflow/updateWorkflow/",
		data:{'userID':userID,'gender':gender,'employeeNum':employeeNum,'mailbox':mailbox},
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

