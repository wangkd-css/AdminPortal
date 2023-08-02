var resourceID;

function addResource() {
	var ServerID = $('#serverID').val();
	var resourceID = $('#resourceID').val();
	var Resource = $('#resourceName').val();
	if (ServerID.length <= 0) {
		alert("サーバ番号を入力してください!")
		return;
	}
	if (resourceID.length <= 0) {
		alert("リソース番号を入力してください!")
		return;
	}
	if (Resource.length <= 0) {
		alert("リソースを入力してください!")
		return;
	}

	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Resource/addResource/",
		data:{'serverID':ServerID,'resourceID':resourceID,'resourceName':Resource},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnResourceList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function Resource() {
	var url = "http://localhost:8099/Resource/ResourceList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('Resourcelist', data.data);
			document.getElementById('Resourcecontent').innerHTML = html;
			url = "http://localhost:8099/whoim";
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

function deleteResource() {
	$('#deleteResource').modal('hide');
	if (resourceID.length <= 0) {
		alert("リソース番号を確認ください。")
		return;
	}
	var url = "http://localhost:8099/Resource/deleteResource?resourceID="
		+ resourceID;
	$.get(url, function(data) {
		if (data.code == 1) {
			Resource();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteResourceDialog(id) {
	resourceID = id;
	$('#deleteResource').modal('show');
}


function showUpdateResource(id) {
	var url = "http://localhost:8099/Resource/getResource?resourceID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#serverID').val(data.data[0].serverID);
			$('#resourceID').val(data.data[0].resourceID);
			$('#resourceName').val(data.data[0].resourceName);
			$('#updateResource').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateResource() {
	var serverID = $('#serverID').val();
	var resourceID = $('#resourceID').val();
	var Resource = $('#resourceName').val();
	if (serverID.length <= 0) {
		alert("サーバ番号を入力してください!")
		return;
	}
	if (resourceID.length <= 0) {
		alert("リソース番号を入力してください!")
		return;
	}
	if (Resource <= 0) {
		alert("リソースを入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Resource/updateResource/",
		data:{'serverID':serverID,'resourceID':resourceID,'resourceName':Resource},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnResourceList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

