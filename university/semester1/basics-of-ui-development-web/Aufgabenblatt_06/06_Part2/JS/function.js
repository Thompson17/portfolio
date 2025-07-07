//Quelle: https://www.w3schools.com/howto/howto_js_countdown.asp

var countDownDate = new Date("Nov 30, 2020 23:59:59").getTime();

var x = setInterval(function() {

    var now = new Date().getTime();

    var distance = countDownDate - now;

    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

    if(hours < 10){
        hours = '0' + hours;
    }
    if(minutes < 10){
        minutes = '0' + minutes;
    }
    if(seconds <10){
        seconds = '0' + seconds;
    }
    if(days > 1 || days < 1){
        document.getElementById("tage").innerHTML = days + "  Tage";
    }
    if(days == 1){
        document.getElementById("tage").innerHTML = days + " Tag";
    }
    if(distance >= 0){
        document.getElementById("zeit").innerHTML = hours + ":" + minutes + ":" + seconds;
    }
    if(days < 1){
        document.querySelector("body").style.backgroundColor = 'red';
    }
    if(days < 1 && minutes < 5){
        document.querySelector("body").style.backgroundColor = 'red';
        document.getElementById("audio").play();
        document.getElementById("audio").volume = 100;
    }

    if (distance < 0) {
        clearInterval(x);
        document.getElementById("tage").innerHTML = "Zu";
        document.getElementById('tage').style.color = 'black';
        document.getElementById("zeit").innerHTML = "Spät!";
        document.getElementById('zeit').style.color = 'black';
        document.querySelector("body").style.backgroundColor = 'white';
    }
}, 1000);