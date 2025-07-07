function buttonTapped(id){
    resetButtons();

    let red = getRandomNumber(0,255);
    let green = getRandomNumber(0,255);
    let blue = getRandomNumber(0,255);

    let btn = document.getElementById(id);
    btn.style.background = "rgb(" + red + "," + green + "," + blue + ")";
    btn.innerHTML = "Tapped";
}


function buttonClicked(id){
    resetButtons();
    let btn = document.getElementById(id);
    btn.style.background = "rgb(255,0,0)";
    btn.innerHTML = "Clicked";
}

document.getElementById("btn1").onmousedown = function(e){buttonClicked('btn1');e.preventDefault();}
document.getElementById("btn2").onmousedown = function(e){buttonClicked('btn2');e.preventDefault();}
document.getElementById("btn3").onmousedown = function(e){buttonClicked('btn3');e.preventDefault();}

document.getElementById("btn1").ontouchstart = function(e){buttonTapped('btn1');e.preventDefault();}
document.getElementById("btn2").ontouchstart = function(e){buttonTapped('btn2');e.preventDefault();}
document.getElementById("btn3").ontouchstart = function(e){buttonTapped('btn3');e.preventDefault();}

function getRandomNumber(min, max) {

    return Math.floor(Math.random() * (max + 1 - min) + min);
}


function resetButtons(){
    var resetBtn = document.getElementsByClassName("button");
    for(var i = 0; i < resetBtn.length; i++){
        resetBtn[i].style.removeProperty('background');
        resetBtn[i].innerHTML = "Tap or Click me";
    }
}