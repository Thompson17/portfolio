document.getElementById('tap-me').ontouchstart = function (){
    randomButtonColor();
}

function randomButtonColor(){
    let red = getRandomNumber(0,255);
    let green = getRandomNumber(0,255);
    let blue = getRandomNumber(0,255);

    let tapMe = document.getElementById("tap-me");
    let bgColor = "rgb(" + red + "," + green + "," + blue + ")";
    console.log(bgColor);

    tapMe.style.background = bgColor;
}

function getRandomNumber(min, max) {

    return Math.floor(Math.random() * (max + 1 - min) + min);
}