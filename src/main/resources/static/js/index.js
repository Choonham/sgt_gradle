$(document).ready(function () {
    $(document).on("keydown", function(e) {
        let keyCode = e.keyCode;
        let inputIp = "";

        $.getJSON("https://api.ipify.org/?format=json", function(data) {
            inputIp = data.ip
        });
        $.ajax({
            url: "/apiInput/insertInput.do" , //컨트롤러 URL
            data: {
                inputCode: keyCode,
                inputIp: inputIp
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

    });
});