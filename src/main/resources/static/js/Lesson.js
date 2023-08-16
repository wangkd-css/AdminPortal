var LessonID;

/*function addLesson() {
	var CustomerID = $('#customerID').val();
	var LessonID = $('#lessonID').val();
	var lessonName = $('#lessonName').val();
	var lessonType = $('#lessonType').val();

	
	if (CustomerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}
	if (LessonID.length <= 0) {
		alert("業務番号を入力してください!")
		return;
	}
	if (lessonName.length <= 0) {
		alert("業務名を入力してください!")
		return;
	}
	if (lessonType.length <= 0) {
		alert("業務種類を入力してください!")
		return;
	}
	

	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/Lesson/addLesson/",
		data:{'CustomerID':CustomerID,'LessonID':LessonID,'lessonName':lessonName,'lessonType':lessonType},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnLessonList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}*/

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

function Lesson() {
	var url = URL + "Lesson/LessonList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('Lessonlist', data.data);
			document.getElementById('Lessoncontent').innerHTML = html;
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

/*function deleteLesson() {
	$('#deleteLesson').modal('hide');
	if (LessonID.length <= 0) {
		alert("業務番号を確認ください。")
		return;
	}
	
	// TODO
	var url = "http://localhost:8099/Lesson/deleteLesson?LessonID="
		+ LessonID;
	$.get(url, function(data) {
		if (data.code == 1) {
			Lesson();
		} else {
			alert(data.msg);
		}
	});

}*/

/*function showDeleteLessonDialog(id) {
	LessonID = id;
	$('#deleteLesson').modal('show');
}*/


function showUpdateLesson(id) {
	var url = URL + "Lesson/getLesson?LessonID=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
/*			$('#customerID').val(data.data[0].customerID);*/
			$('#lessonID').val(data.data[0].lessonID);
			$('#lessonName').val(data.data[0].lessonName);
			$('#lessonType').val(data.data[0].lessonType);
			$('#lessonStatus').val(data.data[0].lessonStatus);
            $('#updateLesson').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateLesson() {
/*	var CustomerID = $('#customerID').val();*/
	var LessonID = $('#lessonID').val();
	var lessonName = $('#lessonName').val();
	var lessonType = $('#lessonType').val();
	var lessonStatus = $('#lessonStatus').val();

/*	if (CustomerID.length <= 0) {
		alert("お客様番号を入力してください!")
		return;
	}*/
	if (LessonID.length <= 0) {
		alert("输入课程番号!")
		return;
	}
	if (lessonName.length <= 0) {
		alert("输入课程名!")
		return;
	}
	if (lessonType.length <= 0) {
		alert("输入课程种类!")
		return;
	}
	if (lessonStatus.length <= 0) {
		alert("输入课程完成状态!")
		return;
	}
	
	$.ajax({
        type: "POST",
        dataType: "json",
        url: URL + "Lesson/updateLesson/",
		data:{'lessonID':LessonID,'lessonName':lessonName,'lessonType':lessonType,'lessonStatus':lessonStatus},
/*		data:{'customerID':CustomerID,'lessonID':LessonID,'lessonName':lessonName,'lessonType':lessonType},*/
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnLessonList";
            }
        },
        error : function() {
            alert("异常!");
        }
    });
}
