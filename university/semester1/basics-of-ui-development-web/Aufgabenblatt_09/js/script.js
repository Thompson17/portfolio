function hover(number){
    if(number === 1){
        hidePresent(1);
    }else if(number === 24){
        if(isHidden(23)){
            hidePresent(24);
            var text = document.getElementById("winText");
            text.style.visibility = "visible";
        }
    }else{
        if(isHidden(number - 1)){
            hidePresent(number);
        }
    }
}

function hidePresent(number){
    var present = document.getElementById("present" + number);
    present.classList.add('hovered');
}

function isHidden(number){
    var present = document.getElementById("present" + number);
    return present.classList.contains("hovered");
}




// from http://jsfiddle.net/tiffhockin/fesvq8u0/
// collect all the divs
var divs = document.getElementsByClassName("present-div");

// get window width and height
var winWidth = window.innerWidth;
var winHeight = window.innerHeight;

// adjust size of placement field, so presents don't extend the screen
var fieldMargin = 0.1;
var fieldHeight = winHeight - fieldMargin * winHeight;
var fieldWidth = winWidth - fieldMargin * winWidth;

// place the divs randomly
for ( var i=0; i < divs.length; i++ ) {

    // the current div in the list
    var thisDiv = divs[i];

    // get random numbers for each element
    randomTop = getRandomNumber(0, fieldHeight);
    randomLeft = getRandomNumber(0, fieldWidth);

    // update top and left position
    thisDiv.style.top = randomTop +"px";
    thisDiv.style.left = randomLeft +"px";
}

// function that returns a random number between a min and max
function getRandomNumber(min, max) {

    return Math.random() * (max - min) + min;
}





// From: https://codepen.io/pinglu/pen/mYaMJM
//on mouseEvent Properties
function getMouseCoords(e) {
    var e = e || window.event;
}

var followCursor = (
    function() {
        var s = document.getElementById('santa');
        return {
            init: function() {
                document.body.appendChild(s);
            },
            run: function(e) {
                var e = e || window.event;
                s.style.left = (e.clientX - 5) - 380 + 'px';
                s.style.top = (e.clientY - 5) - 15 + 'px';
                getMouseCoords(e);
            }
        };
    }());

window.onload = function() {
    followCursor.init();
    document.body.onmousemove = followCursor.run;

}

// From: http://jsfiddle.net/2TUA7/
var direction = "",
    oldx = 0,
    mousemovemethod = function (e) {
        if (e.pageX < oldx) {
            direction = "left"
        } else if (e.pageX > oldx) {
            direction = "right"
        }
        if(direction === "left"){
            var santa = document.getElementById("santa");
            santa.style.transform = "scaleX(-1) translate(-385px,0px)";
        }else{
            var santa = document.getElementById("santa");
            santa.style.transform = "scaleX(1)";
        }
        oldx = e.pageX;
    }
document.addEventListener('mousemove', mousemovemethod);