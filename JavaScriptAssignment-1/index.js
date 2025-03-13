let scores = [0, 0]; // Array to store scores for both players
let currentScore = 0;
let curPlayer = 0;
let dice = document.getElementById("dice");
let rotation = 0;
let players = document.querySelectorAll('.player-box');
players[curPlayer].classList.add('active-player');
let target = parseInt(document.getElementById('target').value);
console.log(target);
let hasAnyWinner = false; //hasAnyWinner used to terminate the game if the winner is declared
let dots = document.getElementsByClassName("dot");
let gameStarted = false; // in order to refuse the names to be edited if game started



function rollDice() {
  if(!gameStarted){
    gameStarted = true;
    refuseToChangeNames();
  }

  if(!hasAnyWinner) {
    for (let i = 0; i < dots.length; i++) {
      dots[i].style.visibility = "hidden";
    }

    console.log('working'
    );
    

    rotation += 720;

    let randomNumber = Math.floor(Math.random() * 6) + 1;
    // console.log(randomNumber);

    let dotPosition = {                //using this to create a face of dice 
      1: ["5"],
      2: ["1", "9"],
      3: ["1", "5", "9"],
      4: ["1", "3", "7", "9"],
      5: ["1", "3", "5", "7", "9"],
      6: ["1", "4", "7", "3", "6", "9"],
    };

    // console.log(dotPosition[randomNumber]);

    // dice.style.transform = `rotateX(${rotation}deg) rotateY(${rotation}deg) rotateZ(${rotation}deg)`;
    dice.style.transform = `rotateZ(${rotation}deg)  `;

    setTimeout(() => {
      dotPosition[randomNumber].forEach((element) => {
        document.getElementById(`d${element}`).style.visibility = "visible";
      });

      if (randomNumber === 1) {
        currentScore = 0;
        setTimeout(changingPlayer,1500);
      } else {
        currentScore += randomNumber;
      }
      document.getElementById("cur-score").innerText = currentScore;
    }, 800);}
}

function saveScore() {
  if (currentScore !== 0 && hasAnyWinner==false) {   //using the condition so that if a person clicks save btn, it will not generate any bug.
    scores[curPlayer] += currentScore; // Update the score for the current player
    document.getElementById(`score-player${curPlayer + 1}`).innerText = scores[curPlayer];

    currentScore = 0;
    document.getElementById("cur-score").innerText = currentScore;

    //checking for the winning condition
    if(scores[0]>=target || scores[1]>=target){  
      document.getElementById('winner-msg').innerText = document.getElementById(`name-player${curPlayer+1}`).value + ' is winner!!!';
      hasAnyWinner = true;
    }

    changingPlayer();
  }
}

function reset() {
  scores = [0, 0];
  currentScore = 0;
  curPlayer = 0;

  players.forEach(ele => ele.classList.remove('active-player'));
  players[curPlayer].classList.add('active-player');
  document.getElementById("cur-score").innerText = currentScore;
  document.getElementById("score-player1").innerText = scores[0];
  document.getElementById("score-player2").innerText = scores[1];


  //REMOVING EXISTING DOTS ON DICE i.e. resetting dice
  for (let i = 0; i < dots.length; i++) {
    dots[i].style.visibility = "hidden";
  }

  // Remove any winner message if present
  document.getElementById('winner-msg').innerText = "";
  hasAnyWinner = false;

  //Setting the target to 100
  target = 100;
  document.getElementById('target').value = target;

  //Enabling to edit the names of players
  gameStarted = false;
  document.getElementById("name-player2").disabled = false;
  document.getElementById("name-player1").disabled = false;
  document.getElementById('target').disabled = false;
}


function changingPlayer(){
  players[curPlayer].classList.remove('active-player');
  curPlayer = curPlayer === 0 ? 1 : 0;
  players[curPlayer].classList.add('active-player');

  for (let i = 0; i < dots.length; i++) {
    dots[i].style.visibility = "hidden";
  }
}


function setNewTarget(){
    let newTargetValue = parseInt(document.getElementById('target').value);
  
    
      if (!isNaN(newTargetValue) && scores[0] < newTargetValue && scores[1] < newTargetValue) {
          target = newTargetValue;  
      } else {
        document.getElementById('target').value = target;  
      }

      console.log(target);

  }


function refuseToChangeNames(){
  document.getElementById("name-player2").setAttribute('disabled',true);
  document.getElementById("name-player1").setAttribute('disabled',true);
  document.getElementById('target').setAttribute('disabled',true);
}

  