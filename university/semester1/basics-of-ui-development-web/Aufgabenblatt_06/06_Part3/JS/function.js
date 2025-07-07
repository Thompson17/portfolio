function rollTheDice() {
  console.log('rollTheDice')

  var w1, w2, temp;
  w1 = Math.floor(6 * Math.random() + 1);
  w2 = Math.floor(6 * Math.random() + 1);

  if (w2 > w1) {
    temp = w1;
    w1 = w2;
    w2 = temp;
  }

  if (w1 === 2 && w2 === 1) {
    document.getElementById('meier').innerHTML = '<b>MEIER</b>';
  } else {
    document.getElementById('meier').innerHTML = '';
  }

  switch (w1) {
    case 1:
      document.getElementById('dice1').src = './IMG/w1.png';
      document.getElementById('dice1text').innerHTML = w1;
      break;
    case 2:
      document.getElementById('dice1').src = './IMG/w2.png';
      document.getElementById('dice1text').innerHTML = w1;
      break;
    case 3:
      document.getElementById('dice1').src = './IMG/w3.png';
      document.getElementById('dice1text').innerHTML = w1;
      break;
    case 4:
      document.getElementById('dice1').src = './IMG/w4.png';
      document.getElementById('dice1text').innerHTML = w1;
      break;
    case 5:
      document.getElementById('dice1').src = './IMG/w5.png';
      document.getElementById('dice1text').innerHTML = w1;
      break;
    case 6:
      document.getElementById('dice1').src = './IMG/w6.png';
      document.getElementById('dice1text').innerHTML = w1;
      break;
  }
  
  switch (w2) {
    case 1:
      document.getElementById('dice2').src = './IMG/w1.png';
      document.getElementById('dice2text').innerHTML = w2;
      break;
    case 2:
      document.getElementById('dice2').src = './IMG/w2.png';
      document.getElementById('dice2text').innerHTML = w2;
      break;
    case 3:
      document.getElementById('dice2').src = './IMG/w3.png';
      document.getElementById('dice2text').innerHTML = w2;
      break;
    case 4:
      document.getElementById('dice2').src = './IMG/w4.png';
      document.getElementById('dice2text').innerHTML = w2;
      break;
    case 5:
      document.getElementById('dice2').src = './IMG/w5.png';
      document.getElementById('dice2text').innerHTML = w2;
      break;
    case 6:
      document.getElementById('dice2').src = './IMG/w6.png';
      document.getElementById('dice2text').innerHTML = w2;
      break;
  }

}
