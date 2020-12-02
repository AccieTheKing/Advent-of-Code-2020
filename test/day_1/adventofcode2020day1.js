const numbersArray = require('./data.json');

// part one
for (let i = 0; i < numbersArray.length; i++) {
  for (let j = 0; j < numbersArray.length; j++) {
    if (numbersArray[i] + numbersArray[j] === 2020) {
      console.log(numbersArray[i], numbersArray[j]); // these numbers plus eachother are 2020
      console.log(numbersArray[i] * numbersArray[j]);
    }
  }
}

// part two
for (let i = 0; i < numbersArray.length; i++) {
  for (let j = 0; j < numbersArray.length; j++) {
    for (let k = 0; k < numbersArray.length; k++) {
      if (numbersArray[i] + numbersArray[j] + numbersArray[k] === 2020) {
        // console.log(numbersArray[i], numbersArray[j], numbersArray[k]); 1306 324 390
        console.log(numbersArray[i] * numbersArray[j] * numbersArray[k]);
      }
    }
  }
}
