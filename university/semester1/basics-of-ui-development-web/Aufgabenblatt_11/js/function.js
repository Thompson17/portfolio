function showInput(){
    alert(
        "Formular Inhalt" +
        "\nVorname: " + document.getElementById('vorname').value +
        "\nNachname: " + document.getElementById('nachname').value +
        "\nStraße: " + document.getElementById('strasse').value +
        "\nPLZ: " + document.getElementById('postleitzahl').value +
        "\nOrt: " + document.getElementById('ort').value +
        "\nGeschlecht: " + getRadioValue() +
        "\nNote: " + document.getElementById('note').value +
        "\nAbschluss: " + getEingabe('abschluss') +
        "\nE-Mail: " + getEingabe('email') +
        "\nHandy-Nr: " + getEingabe('handy') +
        "\nBemerkungen: " + getEingabe('bemerkungen')
    );
}

function getRadioValue(){
    var elements = document.getElementsByName('geschlecht');
    for(var i = 0; i < elements.length; i++){
        if(elements[i].checked){
            return elements[i].value;
        }
    }
}

function getEingabe(id){
    var eingabe = document.getElementById(id).value;
    if(eingabe == null || eingabe == ""){
        console.log('Eingabe von ' + id + ' war leer');
        return '-';
    }
    return eingabe;
}