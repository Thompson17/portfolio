var fingersOnScreen = 0;
var cx1 = 0;
var cx2 = 0;
const halfWidth = window.innerWidth / 2;
var seconds = 4;
var orakelIntervall;
var countdownIntervall;

document.getElementById('submit').onclick = function (e){
    console.log('Entscheide geklickt');
    zeigeSpiel();
}

document.ontouchstart = function(e){
    if(fingersOnScreen == 0){
        cx1 = Math.floor(e.touches[0].pageX);
    }
    if(fingersOnScreen == 1){
        cx2 = Math.floor(e.touches[1].pageX);
    }
    fingersOnScreen++;
}

document.ontouchend = function (){
    fingersOnScreen--;
    if(fingersOnScreen < 1){
        cx1 = 0;
        cx2 = 0;
    }else if(fingersOnScreen < 2){
        cx2 = 0;
    }
}

function zeigeSpiel(){
    console.log('zeige Spiel');
    var eingabe1 = document.getElementById('gericht1').value;
    var eingabe2 = document.getElementById('gericht2').value;
    console.log("Gericht 1: " + eingabe1);
    console.log("Gericht 2: " + eingabe2);
    document.getElementById('gerichtLinks').innerHTML = eingabe1;
    document.getElementById('gerichtRechts').innerHTML = eingabe2;
    document.getElementById('startseite').style.display = "none";
    document.getElementById('spielSeite').style.display = "block";
    orakelIntervall = setInterval(checkTapped, 1000);
}

function checkTapped(){
    if((cx1 < halfWidth && cx2 >= halfWidth) || (cx1 >= halfWidth && cx2 < halfWidth)){
        orakel();
        clearInterval(orakelIntervall);
    }
}

function orakel(){
    console.log('Orakel startet');
    var counter = document.getElementById('textMitte');
    counter.style.backgroundColor = "#d3d3d3";
    counter.innerHTML = seconds + 's';
    countdownIntervall = setInterval(countdown, 1000);
}

function countdown(){
    console.log('countdown ' + seconds);
    if(seconds > 0){
        console.log('if');
        seconds--;
        document.getElementById('textMitte').innerHTML = seconds + 's';
    }else{
        clearInterval(countdownIntervall);
        console.log('stopped countdown');
        ergebnis();
    }
}

function ergebnis(){
    var entscheidung =  Math.floor(Math.random() * 2);
    document.getElementById('mitte').style.visibility = 'hidden';
    if(entscheidung < 1){
        document.getElementById('links').style.backgroundColor = '#ff0000';
    }else{
        document.getElementById('rechts').style.backgroundColor = '#ff0000';
    }
}