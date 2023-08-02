var KeyWordID;

function addKeyWord() {
	var AutomataID = $('#AutomataID').val();
	var KeyWordID = $('#KeyWordID').val();
	var KeyWord = $('#KeyWord').val();
	if (AutomataID.length <= 0) {
		alert("オートマタ番号を入力してください!")
		return;
	}
	if (KeyWordID.length <= 0) {
		alert("キーワード番号を入力してください!")
		return;
	}
	if (KeyWord.length <= 0) {
		alert("キーワードを入力してください!")
		return;
	}

	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/KeyWord/addKeyWord/",
		data:{'automataId':AutomataID,'keywordId':KeyWordID,'keyword':KeyWord},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnKeyWordList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

function KeyWord() {
	var url = "http://localhost:8099/KeyWord/KeyWordList";
	$.get(url, function(data) {
		if (data.code == 1) {
			var html = template('KeyWordlist', data.data);
			document.getElementById('KeyWordcontent').innerHTML = html;
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

function deleteKeyWord() {
	$('#deleteKeyWord').modal('hide');
	if (keywordId.length <= 0) {
		alert("キーワード番号を確認ください。")
		return;
	}
	var url = "http://localhost:8099/KeyWord/deleteKeyWord?keywordId="
		+ keywordId;
	$.get(url, function(data) {
		if (data.code == 1) {
			KeyWord();
		} else {
			alert(data.msg);
		}
	});

}

function showDeleteKeyWordDialog(id) {
	keywordId = id;
	$('#deleteKeyWord').modal('show');
}


function showUpdateKeyWord(id) {
	var url = "http://localhost:8099/KeyWord/getKeyWord?keywordId=" + id;
	$.get(url, function(data) {
		if (data.code == 1) {
			$('#automataId').val(data.data[0].automataId);
			$('#keywordId').val(data.data[0].keywordId);
			$('#keyword').val(data.data[0].keyword);
			$('#updateKeyWord').modal('show');
		} else {
			alert(data.msg)
		}
	});
}

function updateKeyWord() {
	var automataId = $('#automataId').val();
	var keywordId = $('#keywordId').val();
	var keyword = $('#keyword').val();
	if (automataId.length <= 0) {
		alert("オートマタ番号を入力してください!")
		return;
	}
	if (keywordId.length <= 0) {
		alert("キーワード番号を入力してください!")
		return;
	}
	if (keyword <= 0) {
		alert("キーワードを入力してください!")
		return;
	}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: "http://localhost:8099/KeyWord/updateKeyWord/",
		data:{'automataId':automataId,'keywordId':keywordId,'keyword':keyword},
        success: function (data) {
            if (data.code == 0) {
                alert(data.msg);
            }
            else{
            	window.location.href = "returnKeyWordList";
            }
        },
        error : function() {
            alert("異常!");
        }
    });
}

