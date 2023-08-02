var ServerID;

function addServer() {
	var ServerID = $('#serverID').val();
	var serverIP = $('#serverIP').val();
	var customerID = $('#customerID').val();
	var ServerName = $('#serverName').val();
	var UserName = $('#userName').val();
	var PassWord = $('#passWord').val();
	var ServerDriver = $('#serverDriver').val();
	var ServerUrl = $('#serverUrl').val();
		if (ServerID.length <= 0) {
		alert("サーバ番号を入力してください!")
		return;
	}
	if (serverIP.length <= 0) {
		alert("IP番号を入力してください!")
		return;
	}
	if (ServerName.length <= 0) {
		alert("サーバ名を入力してください!")
		return;
	}
	if (customerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (UserName.length <= 0) {
		alert("ユーザー名を入力してください!")
		return;
	}
	if (PassWord.length <= 0) {
		alert("パスワードを入力してください!")
		return;
	}
	if (ServerDriver.length <= 0) {
		alert("サーバ種類を入力してください!")
		return;
	}
	if (ServerUrl.length <= 0) {
		alert("サーバリンクを入力してください!")
		return;
	}
	

	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Server/addServer/",
		data:{'serverID':ServerID,'serverIP':serverIP,'customerID':customerID,'serverName':ServerName,'userName':UserName,'passWord':PassWord,'serverDriver':ServerDriver,'serverUrl':ServerUrl},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnServerList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function Server() {
	var url = "http://localhost:8099/Server/ServerList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('Serverlist', data.data);
			document.getElementById('Servercontent').innerHTML = html;
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

function deleteServer() {
	$('#deleteServer').modal('hide');
	if (serverID.length <= 0) {
		alert("サーバ番号を確認ください。")
		return;
	}
	var url = "http://localhost:8099/Server/deleteServer?serverID="
		+ serverID;
	$.get(url, function(data) {
		if (data.code == 1) {
			Server();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteServerDialog(id) {
	serverID = id;
	$('#deleteServer').modal('show');
}


function showUpdateServer(id) {
	var url = "http://localhost:8099/Server/getServer?serverID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#serverID').val(data.data[0].serverID);
			$('#serverIP').val(data.data[0].serverIP);
			$('#customerID').val(data.data[0].customerID);
			$('#serverName').val(data.data[0].serverName);
			$('#userName').val(data.data[0].userName);
			$('#passWord').val(data.data[0].passWord);
			$('#serverDriver').val(data.data[0].serverDriver);
			$('#serverUrl').val(data.data[0].serverUrl);
			$('#updateServer').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateServer() {
	var ServerID = $('#serverID').val();
	var serverIP = $('#serverIP').val();
	var customerID = $('#customerID').val();
	var ServerName = $('#serverName').val();
	var UserName = $('#userName').val();
	var PassWord = $('#passWord').val();
	var ServerDriver = $('#serverDriver').val();
	var ServerUrl = $('#serverUrl').val();
	if (ServerID.length <= 0) {
		alert("サーバ番号を入力してください!")
		return;
	}
	if (serverIP.length <= 0) {
		alert("IP番号を入力してください!")
		return;
	}
	if (ServerName.length <= 0) {
		alert("サーバ名を入力してください!")
		return;
	}
	if (customerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (UserName.length <= 0) {
		alert("ユーザー名を入力してください!")
		return;
	}
	if (PassWord.length <= 0) {
		alert("パスワードを入力してください!")
		return;
	}
	if (ServerDriver.length <= 0) {
		alert("サーバ種類を入力してください!")
		return;
	}
	if (ServerUrl.length <= 0) {
		alert("サーバリンクを入力してください!")
		return;
	}
	
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Server/updateServer/",
		data:{'serverID':ServerID,'serverIP':serverIP,'customerID':customerID,'serverName':ServerName,'userName':UserName,'passWord':PassWord,'serverDriver':ServerDriver,'serverUrl':ServerUrl},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnServerList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

