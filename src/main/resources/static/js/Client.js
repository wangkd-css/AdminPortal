var CustomerID;

function addClient() {
	var customerID = $('#customerID').val();
	var customerName = $('#customerName').val();
	if (customerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (customerName.length <= 0) {
		alert("お客様名を入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Client/addClient/",
		data:{'customerID':customerID,'customerName':customerName},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnClientList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function Client() {
	var url = "http://localhost:8099/Client/ClientList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('Clientlist', data.data);
			document.getElementById('Clientcontent').innerHTML = html;
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

function deleteClient() {
	$('#deleteClient').modal('hide');
	if (CustomerID.length <= 0) {
		alert("お客様番号を確認ください。")
		return;
	}
	var url = "http://localhost:8099/Client/deleteClient?CustomerID="
		+ CustomerID;
	$.get(url, function(data) {
		if (data.code == 1) {
			Client();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteClientDialog(id) {
	CustomerID = id;
	$('#deleteClient').modal('show');
}


function showUpdateClient(id) {
	var url = "http://localhost:8099/Client/getClient?CustomerID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#customerID').val(data.data[0].customerID);
			$('#customerName').val(data.data[0].customerName);
			$('#updateClient').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateClient() {
	var CustomerID = $('#customerID').val();
	var customerName = $('#customerName').val();
	if (CustomerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (customerName.length <= 0) {
		alert("お客様名を入力してください!")
		return;
	}

	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Client/updateClient/",
		data:{'customerID':CustomerID,'customerName':customerName},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnClientList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}