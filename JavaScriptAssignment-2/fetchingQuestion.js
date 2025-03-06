let quesArray;
let scored = 0;
// scoreElement.innerText = scored;
getQuestions();

async function getQuestions() {
    let categoryID = localStorage.getItem("categoryID");
    console.log(categoryID);
    let difficulty = localStorage.getItem("difficulty").toLowerCase();
    console.log(difficulty);

    let url = `https://opentdb.com/api.php?amount=10&category=${categoryID}&difficulty=${difficulty}&type=multiple`;
    try {
        let response = await fetch(url);

        let data = await response.json();

        quesArray = data.results;

        console.log(quesArray);

        putQuestions();
    } catch (error) {
        console.log(error);
    }
}

function putQuestions() {
    let index = 0;
    let stopTime;

    function displayQuestion() {
        if (index >= quesArray.length) {
            localStorage.setItem('scoreObtained',scored);
            localStorage.setItem('TotalScore',quesArray.length);
            window.location.href = 'finalScore.html';
            console.log('khatam');
            return;
        }

            document.getElementById("questionNo").innerText = index + 1;
            let mainQuestion = document.getElementById("mainQuestion");
            let optionContainer = document.getElementById("optionContainer");

            let currentQuestion = quesArray[index];
            let correctAns = currentQuestion.correct_answer;

            mainQuestion.innerText = currentQuestion.question;

            let optionsArr = [...currentQuestion.incorrect_answers];
            let randomIndex = Math.floor(Math.random() * 4);
            optionsArr.splice(randomIndex, 0, correctAns);

            optionContainer.innerHTML = "";
            document.getElementById("answerBlock").style.visibility = "hidden";

            optionsArr.forEach((ele, ind) => {
                console.log(ele);
                let individualOption = document.createElement("div");
                individualOption.classList.add("individualOption");

                let optionElement = document.createElement("input");
                optionElement.type = "radio";
                optionElement.name = "optionElement";
                optionElement.value = ele;
                optionElement.id = "optionElement" + ind;
                optionElement.innerText = ele;

                optionElement.addEventListener(
                    "click",
                    () => {

                        clearTimeout(stopTime);
                        clearInterval(clock);

                        document
                            .querySelectorAll('input[name="optionElement"]')
                            .forEach((input) => {
                                input.disabled = true;
                            });

                        if (match(ele, correctAns)) {
                            scored++;
                            let scoreElement = document.getElementById('cur-score');
                            scoreElement.innerText = scored;

                            individualOption.innerHTML =
                                individualOption.innerHTML +
                                '<i class="fa-solid fa-circle-check"></i>';
                            individualOption.classList.add("greenBorder");

                        } else {
                            individualOption.innerHTML =
                                individualOption.innerHTML +
                                '<i class="fa-solid fa-xmark"></i>';
                            individualOption.classList.add("redBorder");
                            showCorrectAns(correctAns);
                        }

                        setTimeout(() => {
                            index++;
                            displayQuestion();
                        }, 2000);
                    }
                );

                let label = document.createElement("label");
                label.htmlFor = "optionElement" + ind;
                label.innerText = ele;

                individualOption.appendChild(optionElement);
                individualOption.appendChild(label);
                optionContainer.appendChild(individualOption);
            });
        

        stopTime = setTimeout(()=>{

            clearInterval(clock);

            index++;

            displayQuestion();

        },15000);



        let startTime = 15;
        var countdown  = document.getElementById('countdown');
        countdown.innerText = startTime;

        let timer = document.getElementById('timer');
        timer.style.color = 'green';

        clock = setInterval(() => {

            startTime--;
            countdown.innerText = startTime;

            if(startTime<=5){
                timer.style.color = 'red';
            }
            
        }, 1000);

        
    }

    displayQuestion();
}

function match(ele, correct_answer) {
    if (ele == correct_answer) {
        // console.log("matched executed");
        return true;
    }

    return false;
}

function showCorrectAns(correctAns) {
    let mainAnswer = document.getElementById("mainAnswer");
    mainAnswer.innerText = correctAns;

    document.getElementById("answerBlock").style.visibility = "visible";
}
