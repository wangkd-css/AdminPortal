function uploadImage() {
            const formData = new FormData();
            const imageFile = document.getElementById('imageFile').files[0];
            formData.append('imageFile', imageFile);

            fetch('/upload', {
                method: 'POST',
                body: formData
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('Image uploaded successfully!');
                } else {
                    alert('Image upload failed.');
                }
            })
            .catch(error => console.error('Error:', error));
        }