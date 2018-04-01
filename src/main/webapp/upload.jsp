<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 18/3/18
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js" integrity="sha384-feJI7QwhOS+hwpX2zkaeJQjeiwlhOP+SdQDqhgvvo1DsjtiSQByFdThsxO669S2D" crossorigin="anonymous"></script>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <title>$Title$</title>
    <script type="text/javascript">
        $(document).ready(function(){
            $(function(){
                $('#upload_btn').click(upload);
            });

            function upload(){
                var file = $('input[name="upload_file"]').get(0).files[0];

                var formData = new FormData();
                formData.append('file', file);

                $.ajax({
                    url: '${pageContext.request.contextPath}/rest/upload/file',
                    type: 'POST',
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function(data){
                        alert('file upload complete'+JSON.stringify(data));
                    },
                    error: function(response){
                        var error = "error";
                        if (response.status === 409){
                            error = response.responseText;
                        }
                        alert(JSON.stringify(response));
                    },
                    xhr: function() {
                        var myXhr = $.ajaxSettings.xhr();
                        if (myXhr.upload) {
                            myXhr.upload.addEventListener('progress', progress, false);
                        } else {
                            console.log('Upload progress is not supported.');
                        }
                        return myXhr;
                    }
                });
            }

            function progress(e) {
                if (e.lengthComputable) {
                    //$('#progress_percent').css(Math.floor((e.loaded * 100) / e.total));
                    $('.progress-bar').width(((e.loaded*100)/e.total)+'%');

                }
            }
        });








    </script>
</head>
<body>
    <div class="progress">

        <h1>Upload a File</h1>

        <div class="progress-bar" style="width: 0%"></div>
    </div>
    <span id="progress_percent">0</span>%

    <p>Choose : <input type="file" name="upload_file" /></p>
    <button id="upload_btn">Start Uploading</button>

</body>
</html>
