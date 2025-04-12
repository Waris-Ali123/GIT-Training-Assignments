let loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", login);

async function login(event) {
  event.preventDefault();

  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  try {
    const response = await fetch(
      `http://localhost:8080/employee/login?email=${email}&password=${password}`,
      {
        method: "GET",
      }
    );

    if (response.ok) {
        // console.log("Response is ok");
        window.location.href = "adminDashboard.html";
    } else {
        let errMsg = await response.text();
        let isExisting = document.querySelector(".invalidMsg");
        if (!isExisting) {
            let invalidMsg = document.createElement("div");
            invalidMsg.innerText = errMsg;
            invalidMsg.classList.add("invalidMsg");

            loginForm.insertBefore(invalidMsg, loginForm.firstChild);
        } else {
            isExisting.innerHTML = errMsg;
        }
    }
  } catch (error) {
    console.log(error);
  }
}
