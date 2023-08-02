var jobID;
var runRate;

function addSchedule() {
	var jobID = $('#jobID').val();
	var runRate = $('#runRate').val();
	var timeMeasurement = $('#timeMeasurement').val();
	var timeZone = $('#timeZone').val();
	var startTime = $('#startTime').val();
	var endTime = $('#endTime').val();
	var refresh = $('#refresh').val();
	var inActiveFlg = $('#inActiveFlg').val();
	if (jobID.length <= 0) {
		alert("ジョブ番号を入力してください!")
		return;
	}
	if (runRate.length <= 0) {
		alert("頻度を入力してください!")
		return;
	}
	if (timeMeasurement.length <= 0) {
		alert("メトリックを入力してください!")
		return;
	}
	if (timeZone.length <= 0) {
		alert("タイムゾーンを入力してください!")
		return;
	}
	if (startTime.length <= 0) {
		alert("開始時間を入力してください!")
		return;
	}
	if (endTime.length <= 0) {
		alert("終了時間を入力してください!")
		return;
	}
	if (refresh.length <= 0) {
		alert("リフレッシュを入力してください!")
		return;
	}
	if (inActiveFlg.length <= 0) {
		alert("Activeを入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "schedule/addSchedule/",
		data:{'jobID':jobID,'runRate':runRate,'timeMeasurement':timeMeasurement,'timeZone':timeZone,'startTime':startTime,'endTime':endTime,'refresh':refresh,'inActiveFlg':inActiveFlg},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnScheduleList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function scheduleList() {
	var url = URL + "schedule/scheduleList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('schedule_list', data.data);
			document.getElementById('schedule__content').innerHTML = html;
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

function deleteSchedule() {
	$('#deleteSchedule').modal('hide');
	if (jobID.length <= 0) {
		alert("ジョブIDを確認ください。")
		return;
	}
	var url = URL + "schedule/deleteSchedule?jobID=" + jobID + "&runRate=" + runRate;
	$.get(url, function(data) {
		if (data.code == 1) {
			scheduleList();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteSchedule(id,run) {
	jobID = id;
	runRate = run
	$('#deleteSchedule').modal('show');
}


function showUpdateSchedule(id,run) {
	var url = URL + "schedule/getSchedule?jobID=" + id + "&runRate=" + run;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#jobID').val(data.data[0].jobID);
			$('#runRate').val(data.data[0].runRate);
			$('#timeMeasurement').val(data.data[0].timeMeasurement);
			$('#timeZone').val(data.data[0].timeZone);
			$('#startTime').val(data.data[0].startTime);
			$('#endTime').val(data.data[0].endTime);
			$('#refresh').val(data.data[0].refresh);
			$('#inActiveFlg').val(data.data[0].inActiveFlg);
			$('#updateSchedule').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateSchedule() {
	var jobID = $('#jobID').val();
	var runRate = $('#runRate').val();
	var timeMeasurement = $('#timeMeasurement').val();
	var timeZone = $('#timeZone').val();
	var startTime = $('#startTime').val();
	var endTime = $('#endTime').val();
	var refresh = $('#refresh').val();
	var inActiveFlg = $('#inActiveFlg').val();
	if (jobID.length <= 0) {
		alert("ジョブ番号を入力してください!")
		return;
	}
	if (runRate.length <= 0) {
		alert("頻度を入力してください!")
		return;
	}
	if (timeMeasurement.length <= 0) {
		alert("メトリックを入力してください!")
		return;
	}
	if (timeZone.length <= 0) {
		alert("タイムゾーンを入力してください!")
		return;
	}
	if (startTime.length <= 0) {
		alert("開始時間を入力してください!")
		return;
	}
	if (endTime.length <= 0) {
		alert("終了時間を入力してください!")
		return;
	}
	if (refresh.length <= 0) {
		alert("リフレッシュを入力してください!")
		return;
	}
	if (inActiveFlg.length <= 0) {
		alert("Activeを入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "schedule/updateSchedule/",
		data:{'jobID':jobID,'runRate':runRate,'timeMeasurement':timeMeasurement,'timeZone':timeZone,'startTime':startTime,'endTime':endTime,'refresh':refresh,'inActiveFlg':inActiveFlg},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnScheduleList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

