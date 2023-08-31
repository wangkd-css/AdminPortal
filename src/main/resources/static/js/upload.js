function uploadFile() {
	
    var fileInput = document.getElementById("file");
    var file = fileInput.files[0];
/*    var folderName = folderInput.value;*/
	var automataID = $('#automataID').val();
    var formData = new FormData();
    formData.append("file", file);
    formData.append("folderName", automataID);
    fetch('/upload', {
        method: 'POST',
        body: formData
    })
    .then(response => response.text())
    .then(data => {
        // 处理上传结果，可以在页面上显示信息或跳转到相应页面
        alert(data);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}