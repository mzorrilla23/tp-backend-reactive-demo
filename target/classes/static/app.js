var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#userinfo").html("");
}

function connect() {
	var token = prompt("causa el token es obligatorio");
	var idConductor = prompt("causa el id de conductor a suscribirse es obligatorio");
	var idUsuario = prompt("causa el id de usario a suscribirse es obligatorio");

    var socket = new SockJS('/tp-logistic/websocket-example');
    var topicoConductor= '/topic/conductor/'+idConductor; 
    var topicoUsuario= '/topic/usuario/'+idConductor;

    stompClient = Stomp.over(socket);
    stompClient.connect({"X-Authorization": "Bearer "+token  }, function (frame) {

        setConnected(true);
        console.log('Connected: ' + frame);
        
        document.getElementById("txtTituloConductor").innerText="el topico: "+topicoConductor
        document.getElementById("txtTituloUsuario").innerText="el topico: "+topicoUsuario

        stompClient.subscribe(topicoConductor, function (greeting) {
            showGreeting( '#userinfoConductor',greeting.body );
        });
        
        stompClient.subscribe(topicoUsuario, function (greeting) {
            showGreeting( '#userinfoUsuario',greeting.body );
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

/*function sendName() {
    stompClient.send("/app/user/1", {}, JSON.stringify({'name': $("#name").val()}));
}*/

function showGreeting(id,message) {
    $(id).append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});