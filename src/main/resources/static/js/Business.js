var BusinessID;

function addBusiness() {
	var CustomerID = $('#customerID').val();
	var BusinessID = $('#businessID').val();
	var businessName = $('#businessName').val();
	var businessType = $('#businessType').val();

	
	if (CustomerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (BusinessID.length <= 0) {
		alert("業務番号を入力してください!")
		return;
	}
	if (businessName.length <= 0) {
		alert("業務名を入力してください!")
		return;
	}
	if (businessType.length <= 0) {
		alert("業務種類を入力してください!")
		return;
	}
	

	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Business/addBusiness/",
		data:{'CustomerID':CustomerID,'BusinessID':BusinessID,'businessName':businessName,'businessType':businessType},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnBusinessList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function Business() {
	var url = "http://localhost:8099/Business/BusinessList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('Businesslist', data.data);
			document.getElementById('Businesscontent').innerHTML = html;
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

function deleteBusiness() {
	$('#deleteBusiness').modal('hide');
	if (BusinessID.length <= 0) {
		alert("業務番号を確認ください。")
		return;
	}
	
	// TODO
	var url = "http://localhost:8099/Business/deleteBusiness?BusinessID="
		+ BusinessID;
	$.get(url, function(data) {
		if (data.code == 1) {
			Business();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteBusinessDialog(id) {
	BusinessID = id;
	$('#deleteBusiness').modal('show');
}


function showUpdateBusiness(id) {
	var url = "http://localhost:8099/Business/getBusiness?BusinessID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#customerID').val(data.data[0].customerID);
			$('#businessID').val(data.data[0].businessID);
			$('#businessName').val(data.data[0].businessName);
			$('#businessType').val(data.data[0].businessType);
            $('#updateBusiness').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateBusiness() {
	var CustomerID = $('#customerID').val();
	var BusinessID = $('#businessID').val();
	var businessName = $('#businessName').val();
	var businessType = $('#businessType').val();

	if (CustomerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (BusinessID.length <= 0) {
		alert("業務番号を入力してください!")
		return;
	}
	if (businessName.length <= 0) {
		alert("業務名を入力してください!")
		return;
	}
	if (businessType.length <= 0) {
		alert("業務種類を入力してください!")
		return;
	}
	
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Business/updateBusiness/",
		data:{'customerID':CustomerID,'businessID':BusinessID,'businessName':businessName,'businessType':businessType},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnBusinessList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

