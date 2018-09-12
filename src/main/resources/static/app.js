var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#logs").show();
    }
    else {
        $("#logs").hide();
    }
    $("#events").html("");
}

function connect() {
    var socket = new SockJS('/midoffice-event-socket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/events', function (event) {
            //showEvent(JSON.parse(event.body).content); if the message is JSON
        	showEvent(event.body);
        	
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


function showEvent(message) {
    $("#events").append("<tr><td>" + message + "</td></tr>");
}

