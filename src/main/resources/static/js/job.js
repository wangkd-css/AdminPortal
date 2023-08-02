var jobID;

function addJob() {
	var jobID = $('#jobID').val();
	var serverID = $('#serverID').val();
	var automataID = $('#automataID').val();
	var refresh = $('#refresh').val();
	var param = $('#param').val();
	var waitTime = $('#waitTime').val();
	var resourceID = $('#resourceID').val();
	if (jobID.length <= 0) {
		alert("ジョブ番号を入力してください!")
		return;
	}
	if (serverID.length <= 0) {
		alert("サーバー番号を入力してください!")
		return;
	}
	if (automataID <= 0) {
		alert("オートマタ番号を入力してください!")
		return;
	}
	if (refresh <= 0) {
		alert("リフレッシュを入力してください!")
		return;
	}
	if (param <= 0) {
		alert("パラメータを入力してください!")
		return;
	}
	if (waitTime <= 0) {
		alert("最大待機時間を入力してください!")
		return;
	}
	if (resourceID <= 0) {
		alert("リソース番号を入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "job/addJob/",
		data:{'jobID':jobID,'serverID':serverID,'automataID':automataID,'refresh':refresh,'param':param,'waitTime':waitTime,'resourceID':resourceID},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnJobList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function jobList() {
	var url = URL + "job/jobList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('job_list', data.data);
			document.getElementById('job__content').innerHTML = html;
			url = "http://localhost:8080/whoim";
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

function deleteJob() {
	$('#deleteJob').modal('hide');
	if (jobID.length <= 0) {
		alert("ジョブ番号を確認ください。")
		return;
	}
	var url = URL + "job/deleteJob?jobID="
		+ jobID;
	$.get(url, function(data) {
		if (data.code == 1) {
			jobList();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteJobDialog(id) {
	jobID = id;
	$('#deleteJob').modal('show');
}


function showUpdateJob(id) {
	var url = URL + "job/getJob?jobID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#jobID').val(data.data[0].jobID);
			$('#serverID').val(data.data[0].serverID);
			$('#automataID').val(data.data[0].automataID);
			$('#refresh').val(data.data[0].refresh);
			$('#param').val(data.data[0].param);
			$('#waitTime').val(data.data[0].waitTime);
			$('#resourceID').val(data.data[0].resourceID);
			$('#updateJob').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateJob() {
	var jobID = $('#jobID').val();
	var serverID = $('#serverID').val();
	var automataID = $('#automataID').val();
	var refresh = $('#refresh').val();
	var param = $('#param').val();
	var waitTime = $('#waitTime').val();
	var resourceID = $('#resourceID').val();
	if (jobID.length <= 0) {
		alert("ジョブ番号を入力してください!")
		return;
	}
	if (serverID.length <= 0) {
		alert("サーバー番号を入力してください!")
		return;
	}
	if (automataID <= 0) {
		alert("オートマタ番号を入力してください!")
		return;
	}
	if (refresh <= 0) {
		alert("リフレッシュを入力してください!")
		return;
	}
	if (param <= 0) {
		alert("パラメータを入力してください!")
		return;
	}
	if (waitTime <= 0) {
		alert("最大待機時間を入力してください!")
		return;
	}
	if (resourceID <= 0) {
		alert("リソース番号を入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "job/updateJob/",
		data:{'jobID':jobID,'serverID':serverID,'automataID':automataID,'refresh':refresh,'param':param,'waitTime':waitTime,'resourceID':resourceID},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnJobList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

