<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="./index.js"></script>
</head>
<body>
    <div>
        <h1 id="ip">Your IP : </h1>
        <h2 id="mode">mode: </h2>
        <div id="input_frame" style="width: 1100px; word-break: break-all"></div>
    </div>
</body>
<script>
    getIp();
    $(document).ready(function () {
        let mode = "command";
        let inputIp = $("#ip").data("ip");

        $(document).on("keydown", function(e) {
            let keyCode = e.keyCode;
            let inputIp = $("#ip").data("ip");
            let inputID = $("#cur").data('id');
            switch (mode) {
                case "command" :
                    mode = changeMode(keyCode, mode);
                    break;
                case "insert":
                    if(keyCode == 27) {
                        mode = changeMode(keyCode, mode);
                        break;
                    }
                    insertInput(inputIp, keyCode);
                    break;
                case "update":
                    if(keyCode == 27) {
                        mode = changeMode(keyCode, mode);
                        break;
                    }
                    updateInput(inputIp, keyCode, inputID);
                    break;
                case "delete":
                    if(keyCode == 27) {
                        mode = changeMode(keyCode, mode);
                        break;
                    }
                    deleteInput(inputID);
                    break;
                default:
                    break;
            }

            getInputList(inputIp);

        });
    });

    function getInputList(inputIp) {
        $("#input_frame").empty();
        $.ajax({
            url: "/apiInput/getInputList.do" , //컨트롤러 URL
            data: {
                inputIp: inputIp
            },
            beforeSend: function(xhr) {
                xhr.setRequestHeader("X-CSRF-TOKEN", $('#_csrf').val());
            },
            async: false,
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                let array = JSON.parse(data.result);

                for(let i=0; i<array.length; i++) {
                    let tempSpan=""
                    if(i == array.length-1) {
                        tempSpan += "<span id='cur' data-id = '"+ array[i].inputID +"'>" + array[i].keyName + "</span>";
                    }
                    tempSpan += "<span data-id = '"+ array[i].inputID +"'>" + array[i].keyName + "</span>";
                    $("#input_frame").append(tempSpan);
                }

            },
            error: function (jqXHR) {
                console.log(jqXHR);
            }
        });
    }

    function insertInput(inputIp, keyCode) {
        $.ajax({
            url: "/apiInput/insertInput.do" , //컨트롤러 URL
            data: {
                inputIp: inputIp,
                inputCode: keyCode
            },
            beforeSend: function(xhr) {
                xhr.setRequestHeader("X-CSRF-TOKEN", $('#_csrf').val());
            },
            async: false,
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                console.log(data);
            },
            error: function (jqXHR) {
                console.log(jqXHR);
            }
        });
    }

    function updateInput(inputIp, keyCode, inputID) {
        $.ajax({
            url: "/apiInput/updateInput.do" , //컨트롤러 URL
            data: {
                inputCode: keyCode,
                inputIp: inputIp,
                inputID: inputID
            },
            beforeSend: function(xhr) {
                xhr.setRequestHeader("X-CSRF-TOKEN", $('#_csrf').val());
            },
            async: false,
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                console.log(data);
            },
            error: function (jqXHR) {
                console.log(jqXHR);
            }
        });
    }

    function deleteInput(inputID) {
        $.ajax({
            url: "/apiInput/deleteInput.do" , //컨트롤러 URL
            data: {
                inputID: inputID
            },
            beforeSend: function(xhr) {
                xhr.setRequestHeader("X-CSRF-TOKEN", $('#_csrf').val());
            },
            async: false,
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                console.log(data);
            },
            error: function (jqXHR) {
                console.log(jqXHR);
            }
        });
    }

    function getIp() {

        let temp = jQuery.when(
            $.getJSON("https://api.ipify.org/?format=json", function (data) {
            })
        ).done(function(json) {
            $("#ip").append(json.ip);
            $("#ip").attr("data-ip", json.ip);
            getInputList($("#ip").data('ip'));
        });
    }

    function changeMode(keyCode, mode) {
        let tempMode = mode;
        if(keyCode == 73) {
            tempMode = "insert";
            console.log(tempMode);
        } else if(keyCode == 27) {
            tempMode = "command";
            console.log(tempMode);
        } else if(keyCode == 85) {
            tempMode = "update";
            console.log(tempMode);
        } else if(keyCode == 68) {
            tempMode = "delete"
            console.log(tempMode);
        }
        $("#mode").text(tempMode);
        return tempMode;
    }
</script>
</html>
