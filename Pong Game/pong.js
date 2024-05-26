
//global variables
var speedOfPaddle1 = 0;
var positionOfPaddle1 = document.getElementById("paddle1").offsetTop;
var speedOfPaddle2 = 0;
var positionOfPaddle2 = document.getElementById("paddle2").offsetTop;
var paddleHeight = document.getElementById("paddle1").offsetHeight;
var paddleWidth = document.getElementById("paddle1").offsetWidth;
var gameBoardHeight = document.getElementById("gameBoard").offsetHeight;
var gameBoardWidth = document.getElementById("gameBoard").offsetWidth;
var paddleHeight2 = document.getElementById("paddle2").offsetHeight;
var gameBoardHeight2 = document.getElementById("gameBoard").offsetHeight;
const startTopPositionOfBall = document.getElementById("ball").offsetTop;
const startLeftPositionOfBall= document.getElementById("ball").offsetLeft;
var topPositionOfBall = startTopPositionOfBall;
var leftPositionOfBall = startLeftPositionOfBall;
var topSpeedOfBall = 0;
var leftSpeedOfBall = 0;
const ballHeight = document.getElementById("ball").offsetHeight;
var score1 = 0;
var score2 = 0;

var bounce = new sound ("bonk.wav");
var goal = new sound ("goal.wav");
//startBallMotion
console.log("above statement");
window.onload = function () {
	console.log("above start ball");
	startBall();
};//startBall

//move paddles
document.addEventListener('keydown', function (e) {
	 console.log("keydown" + e.keyCode);
	if (e.keyCode == 87|| e.which == 87 ) {
		speedOfPaddle1 = -10;
	}//if 
		if (e.keyCode == 83|| e.which == 83 ) {
		speedOfPaddle1 = 10;
	}//if 
	if (e.keyCode == 38|| e.which == 38 ) {
		speedOfPaddle2 = -10;
	}//if 
	if (e.keyCode == 40|| e.which == 40 ) {
		speedOfPaddle2 = 10;
	}//if 

});
//stop paddles
document.addEventListener('keyup', function (e) {
	// console.log("keyup" + e.keyCode);
	if (e.keyCode == 87|| e.which == 87 ) {
		speedOfPaddle1 = 0;
	}//if 
	if (e.keyCode == 38|| e.which == 38 ) {
		speedOfPaddle2 = 0;
	}//if 
	if (e.keyCode == 83|| e.which == 83 ) {
		speedOfPaddle1 = 0;
	} //if
	if (e.keyCode == 40|| e.which == 40 ) {
		speedOfPaddle2 = 0;
	}//if 

});

// object constructor to play sounds
//https://www.w3schools.com/graphics/game_sound.asp
function sound(src) {
  this.sound = document.createElement("audio");
  this.sound.src = src;
  this.sound.setAttribute("preload", "auto");
  this.sound.setAttribute("controls", "none");
  this.sound.style.display = "none";
  document.body.appendChild(this.sound);
  this.play = function(){
    this.sound.play();
  }
  this.stop = function(){
    this.sound.pause();
  }
}

// start the ball movement
function startBall () {
	console.log("start ball is running");
	let direction = 1;
	topPositionOfBall = startTopPositionOfBall;
	leftPositionOfBall = startLeftPositionOfBall;
	
	// 50% chance of starting either direction
	if (Math.random() < 0.5) {
		direction = 1;
	}else {
		direction = -1;
	}
	
	topSpeedOfBall = -1 * (Math.random() * 2 + 3); // 3-4
	leftSpeedOfBall = direction * (Math.random() * 2 + 3);
	
} // startball

function scoreReset() {
	score1 = 0;
	score2 = 0;
	document.getElementById("score1").innerHTML = score1;
	document.getElementById("score2").innerHTML = score2;
}





//update locations of paddles and ball
window.setInterval (function show() {

	positionOfPaddle1 += speedOfPaddle1;
	positionOfPaddle2 += speedOfPaddle2;
	
	console.log("adding to ball position " + topSpeedOfBall + " and " + leftSpeedOfBall);
	 topPositionOfBall += topSpeedOfBall;
	 leftPositionOfBall += leftSpeedOfBall;

	if (positionOfPaddle1 <= 0) {
		positionOfPaddle1 = 0;
	} //if
	
	if (positionOfPaddle2 <= 0) {
		positionOfPaddle2 = 0;
	} //if
	
	//stops paddle from leaving bottom of board
	if (positionOfPaddle1 >= gameBoardHeight - paddleHeight) {
		positionOfPaddle1= gameBoardHeight - paddleHeight;
	}//if
	if (positionOfPaddle2 >= gameBoardHeight2 - paddleHeight2) {
		positionOfPaddle2 = gameBoardHeight2 - paddleHeight2;
	}//if
	
	if (topPositionOfBall <= 0 || topPositionOfBall >= gameBoardHeight - ballHeight) {
		topSpeedOfBall *= -1;
		
	}
	
	 if (leftPositionOfBall <= paddleWidth) {
		 // if ball hits left paddle, change direction
		 if (topPositionOfBall > positionOfPaddle1 && topPositionOfBall < positionOfPaddle1 +paddleHeight) {
			bounce.play();
			leftSpeedOfBall *= -1;
		 } else {
			 score2++;
			 document.getElementById("score2").innerHTML = score2;
			 goal.play();
			 startBall();
		 }
	 }
	 
	 // ball on right side
	 if (leftPositionOfBall >= gameBoardWidth - paddleWidth - ballHeight) {
		 //if ball hits right paddle, change direction
		 if (topPositionOfBall > positionOfPaddle2 &&  topPositionOfBall < positionOfPaddle2 + paddleHeight) {
			 bounce.play();
			 leftSpeedOfBall *= -1;
		 } else {
			  goal.play();
			 score1++;
			 document.getElementById("score1").innerHTML = score1;
			 startBall();
		 } // else
	 } //if
	
	// debug
	//console.log("moving ball to " + topPositionOfBall + " and " + leftPositionOfBall);
	document.getElementById("paddle1").style.top = positionOfPaddle1 + "px";
	document.getElementById("paddle2").style.top = positionOfPaddle2 + "px";
	document.getElementById("ball").style.top = topPositionOfBall + "px";
	document.getElementById("ball").style.left = leftPositionOfBall + "px";
}, 1000/60); // show

