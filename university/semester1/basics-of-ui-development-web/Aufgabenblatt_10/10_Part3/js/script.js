document.ontouchstart = function (e){
    e.preventDefault();
    currentFingers(1);
    incrementTotalGestures();
    gesture('Tap');
    setCoordinates(e.touches[0].pageX, e.touches[0].pageY);
}

document.ontouchend = function (e){
    e.preventDefault();
    currentFingers(-1);
    if(numberOfFingers == 0){
        gesture('Nothing');
        setCoordinates(0, 0);
    }else{
        gesture('Tap');
    }
}

document.ontouchmove = function (e){
    e.preventDefault();
    if(document.getElementById('gesture').innerText != 'Swipe'){
        incrementTotalGestures();
    }
    gesture('Swipe');
    setCoordinates(e.touches[0].pageX, e.touches[0].pageY);

}

var numberOfFingers = 0;
var totalGestures = 0;

function gesture(type){
    document.getElementById('gesture').innerHTML = type;
}

function currentFingers(change){
    numberOfFingers += change;
    document.getElementById('fingers').innerHTML = numberOfFingers;
}

function incrementTotalGestures(){
    totalGestures++;
    document.getElementById('totalNumber').innerHTML = totalGestures;
}

function setCoordinates(x, y){
    document.getElementById('cX').innerHTML = Math.floor(x);
    document.getElementById('cY').innerHTML = Math.floor(y);
}

