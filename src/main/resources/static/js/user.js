var userId;

function addUser() {
	var userId = $('#userId').val();
	var password = $('#password').val();
	var permission = $('#permission').val();
	if (userId.length <= 0) {
		alert("请输入用户名！")
		return;
	}
	if (password.length <= 0) {
		alert("请输入密码！")
		return;
	}
	if (permission.length <= 0) {
		alert("请输入权限！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "user/addUser/",
		data:{'userId':userId,'password':password,'permission':permission},
        success: function (data) {
            console.log(data);
            if (data.code == 1) {
            	window.location.href = "returnUserList";
            }
            else{
            	alert(data.msg);
            }
        },
        error : function() {
            alert("异常！");
        }
    });

}

function userList() {
	var url = URL + "user/userList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('user_list', data.data);
			document.getElementById('user__content').innerHTML = html;
			
		} else {
			alert(data.msg)
		}
	});
}

function deleteUser() {
	$('#deleteUser').modal('hide');
	if (userId.length <= 0) {
		alert("请确认用户名！")
		return;
	}
	var url = URL + "user/deleteUser?userId="
		+ userId;
	$.get(url, function(data) {
		if (data.code == 1) {
			userList();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteUserDialog(id) {
	userId = id;
	$('#deleteUser').modal('show');
}

function showUpdateUser(id) {
	var url = URL + "user/getUser?userId=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#userId').val(data.data.userId);
			$('#permission').val(data.data.permission);
			$('#updateUser').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateUser() {
	var userId = $('#userId').val();
	var permission = $('#permission').val();
	if (userId.length <= 0) {
		alert("请输入用户名！")
		return;
	}
	if (permission <= 0) {
		alert("请输入权限！")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "user/updateUser/",
		data:{'userId':userId,'permission':permission},
        success: function (data) {
            console.log(data);
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnUserList";
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}

function showResetUser(id) {
	userId = id;
	$('#resetUser').modal('show');
}

function resetUser() {
	$('#resetUser').modal('hide');
	if (userId.length <= 0) {
		alert("请确认用户名。")
		return;
	}
	var url = URL + "user/resetUser?userId="
		+ userId;
	$.get(url, function(data) {
		if (data.code == 1) {
			userList();
		} else {
			alert(data.msg);
		}
	});

}

function permission(){
	url = URL + "whoim";
	$.get(url, function(data) {
		if(data.authorities[0].authority == 'admin'){
			$(".userManager").css("display","inline-block")
		}
		else{
			$(".userManager").css("display","none")
		}
	});
}

function showChangePass(){
	$('#changePassword').modal('show');
	url = URL + "whoim";
	$.get(url, function(data) {
		userId = data.username;
		
	});
}

function changePassword(){
 	var password = $('#password').val(); 
 	var passwordConfirm = $('#passwordConfirm').val();
 	if (password.length <= 0) {
		alert("请输入密码！")
		return;
	}
	if (passwordConfirm <= 0) {
		alert("请再次输入密码！")
		return;
	}
	if(password != passwordConfirm){
		alert("请确认密码。")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "user/changePassword/",
		data:{'userId':userId,'password':password},
        success: function (data) {
            console.log(data);
            if (data.code == 1) {
            	window.location.href = "/";
            }
            else{
            	alert(data.msg);
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}