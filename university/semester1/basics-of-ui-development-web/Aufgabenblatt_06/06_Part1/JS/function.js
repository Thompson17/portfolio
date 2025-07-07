var headline = document.getElementById('hl');

function currentTime() {
    var zeit = new Date();
    var h = zeit.getHours();
    if (h < 10) {
        h = '0' + h
    }
    var m = zeit.getMinutes();
    if (m < 10) {
        m = '0' + m
    }
    var s = zeit.getSeconds();
    if (s < 10) {
        s = '0' + s
    }
    var ms = zeit.getMilliseconds();
    if (ms < 100 && ms >= 10) {
        ms = '0' + ms
    }
    if(ms < 10){
        ms = '00' + ms
    }
    headline.innerHTML = h + ":" + m + ":" + s + "." + ms;
}

setInterval(currentTime, 1);
