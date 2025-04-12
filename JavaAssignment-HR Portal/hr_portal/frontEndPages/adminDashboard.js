let allUsers ;
// ==================START js used mainly for css manipulations========================
//table container that holds maximum outputs
let tablesContainer = document.querySelector(".tablesContainer");

// add hovered class to selected list item
let list = document.querySelectorAll(".listOfMenus .listItem");

function activeLink() {
      
    list.forEach((item) => {
        item.classList.remove("active");
    });
    this.classList.add("active");
}

list.forEach((item) => item.addEventListener("click", activeLink));


// ==making the nav item active if there respective method is called===
function showActiveNavItem(navId){
    let list = document.querySelectorAll(".listOfMenus .listItem");

    list.forEach((item)=> item.classList.remove("active"));

    document.getElementById(navId).classList.add("active");

}


//toggling the navbar
let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

toggle.onclick = function () {
    navigation.classList.toggle("active");
    main.classList.toggle("active");
};

// ==================START js used mainly for css manipulations========================

window.onload = async function () {


    await fetchingUsers();

    printingUsersDataInTable(allUsers);

}





// ==========================Handling clicking on the navigations ============================

function HandlingOnClickUsers(){
    printingUsersDataInTable(allUsers);
}


// ====================== Start fetching entities========================================

//Fetching all users from backend
async function fetchingUsers() {
    try {
        let response = await fetch(`http://localhost:8080/employee/getAllEmployees`, {
            method: "GET"
        });
        if (response.ok) {
            let data = await response.json();
            allUsers = data.reverse();
        }

    } catch (error) {
        console.log(error);
    }
}



// ==================================== Storing In Databases =================================

async function storingNewUserInDB(newUser){
    try {
        let response = await fetch(
            `http://localhost:8080/employee/add`, {
            method: 'POST',
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(newUser)
        }
        );

        if (response.ok) {
            let result = await response.json();

            allUsers.push(result);


            alert("User added succesfully");
            printingUsersDataInTable(allUsers);


        }
        else {
            alert(await response.text());
        }
    } catch (error) {
        console.error(error);
    }

}


// ===================================START UPDATING IN DATABASE=======================================

async function updatingUserInDB(userId, updatedUser, fromUsersSection = false) {

    try {
        let response = await fetch(
            `http://localhost:8080/employee/update/${userId}`, {
            method: 'PUT',
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(updatedUser)
        }
        );

        if (response.ok) {
            let result = await response.json();

            let index = allUsers.findIndex(user => user.userId === result.userId);
            if (index !== -1) {
                allUsers[index] = result;  // Update user in the array
            }

            printingUsersDataInTable(allUsers);
        
        }
        else {
            console.error("Error updating user:", await response.text());
        }
    } catch (error) {
        console.error(error);
    }

}

// ====================================== Deleting entities===========================

async function deletingUserFromDB(userToDelete) {

    try {
        let response = await fetch(
            `http://localhost:8080/employee/delete/${userToDelete.employeeId}`, {
            method: 'DELETE',
            headers: {
                "Content-type": "application/json"
            },
        }
        );

        if (response.ok) {

            alert(await response.text());

            allUsers = allUsers.filter(user => user.employeeId !== userToDelete.employeeId);

            printingUsersDataInTable(allUsers);

        }
        else {
            console.error("Error updating user:",await response.text());
        }
    } catch (error) {
        console.error(error);
    }

}






// ================================== start printing Tables=====================================


//print all users in table
function printingUsersDataInTable(usersParam,eraseBefore=true) {

    
    // Clear existing content before adding new data
    if(eraseBefore){
        tablesContainer.innerHTML = "";
        showActiveNavItem("userNav");
    }

    let heading = document.createElement("h2");
    heading.innerText = "All Users";

    // =============== Add user btn ==================
    let addBtn = document.createElement("span");
    addBtn.classList.add("material-symbols-outlined");
    addBtn.innerText = "add";
    addBtn.classList.add("addBtn");
    addBtn.title = "Add User"



    addBtn.addEventListener("click",async ()=>{
          

        let fields = [
            { label: "Name", value: "", id: "name", type: "text",required : true },
            { label: "Email", value: "", id: "email", type: "email",required : true },
            { label: "Password", value: "", id: "password", type: "password",required : true },
            { label: "Salary", value: "", id: "salary", type: "number",required : true },
            { label: "Department", value: "FINANCE", id: "department", type: "select",required : true,options : [ "FINANCE", "IT", "SALES", "MARKETING","HR"] },
            { label: "Role", value: "EMPLOYEE", id: "role", type: "select",required : true,options : ["EMPLOYEE","HR"] }
        ];

        printingFormLayout("Enter New User Details",fields,"USER", true, true);
    });

    // Add User btn ends===============


    //= User table creation starts

    let userTable = document.createElement("table");
    userTable.classList.add("entityTable");


    let thead = document.createElement("thead");
    thead.innerHTML = `
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Role</th>
        </tr>
    `;


    let tbody = document.createElement("tbody");



    usersParam.forEach(element => {
        let employeeId = document.createElement("td");
        employeeId.innerText = element.employeeId;
        let name = document.createElement("td");
        name.innerText = element.name;
        let email = document.createElement("td");
        email.innerText = element.email;
        let salary = document.createElement("td");
        salary.innerText = element.salary;
        let department = document.createElement("td");
        department.innerText = element.department;
        let role = document.createElement("td");
        role.innerText = element.role;
        if (element.role == "HR")
            role.style.color = "var(--success)";


        let modifyColumn = document.createElement("td")
        let deleteBtn = document.createElement("span");
        deleteBtn.classList.add("Del-icon");
        deleteBtn.classList.add("material-symbols-outlined");
        deleteBtn.innerText = "delete";

        deleteBtn.addEventListener("click", async () => {
            if(element.role == "HR"){
                alert("You cannot delete HR");
                return;
            }
            if (confirm("Are you sure you want to delete this employee?")) {
                await deletingUserFromDB(element);
                console.log("employee deleted successfully");
            }
        });

        let updateBtn = document.createElement("span");
        updateBtn.classList.add("update-btn");
        updateBtn.classList.add("material-symbols-outlined");
        updateBtn.innerText = "edit_square";


        updateBtn.addEventListener("click", () => {
            printingProfile(element, true);
        })




        modifyColumn.appendChild(deleteBtn);
        modifyColumn.appendChild(updateBtn);



        let newRow = document.createElement("tr");
        newRow.append(employeeId, name, email, salary,department, role, modifyColumn);

        tbody.appendChild(newRow);

    });


    userTable.appendChild(thead);
    userTable.appendChild(tbody);
    userTable.appendChild(addBtn);

    // ==============================User table creation ends ===============================


    tablesContainer.appendChild(heading);
    tablesContainer.appendChild(userTable);
}



// =================================Start printing profiles=================================

//printing a layout for profile, making it generalize so that i dont have to create profile for each vehicle,rating,review etc.
//trying to do that here
function printingFormLayout(headingContent="Update Details", fieldsComing, entityType,isAdding=false , fromSection = false) {

    tablesContainer.innerHTML = "";

    //creating main heading of table
    let heading = document.createElement("h2");
    heading.innerText = headingContent;
    heading.classList.add("heading");

    //this will contain the user form
    let userFormContainer = document.createElement("div");
    userFormContainer.classList.add("userFormContainer");

    //This is a user form
    let userForm = document.createElement("form");
    userForm.classList.add("userForm");

    let fields = fieldsComing;

    fields.forEach(specificField => {

        let inputContainer = document.createElement("div");
        inputContainer.classList.add("inputContainer");


        let label = document.createElement("label");
        label.for = specificField.label;
        label.innerText = specificField.label;

        if (specificField.type == "select") {

            let inputSelect = document.createElement("select");
            inputSelect.id = specificField.id;
            
            specificField.options.forEach((ele) => {
                  
                let option = document.createElement("option");
                option.text = ele;
                option.value = ele;
                

                inputSelect.appendChild(option);
            });
            inputSelect.value = specificField.value;
            
            if(!isAdding || specificField.id=="role"){
                inputSelect.classList.add("read-only-select");
            }
            if(isAdding)
                inputSelect.required = specificField.required;

            inputContainer.append(label,inputSelect);

        }else{

            
            let input = document.createElement("input");
            input.id = specificField.id;
            input.name = specificField.label;
            input.value = specificField.value;
            if(!isAdding){
                input.readOnly = true;
            }
            if(isAdding)
                input.required = specificField.required;
            
            input.type = specificField.type;
            
            inputContainer.append(label, input);
        }   
        
        userForm.appendChild(inputContainer);
         
    });

    //==================Edit btn starts===========
    let editBtn = document.createElement("button");
    editBtn.classList.add("editBtn");
    if(isAdding && entityType=="USER"){
        editBtn.innerText = "Create User";
    }
    else{
        editBtn.innerText = "Update Details";
    }

     

    editBtn.addEventListener("click", async () => {

        if (!validateForm(fields)) {
            return; // Stop if form is invalid
        }
        if(isAdding){

            if (entityType.toUpperCase() == "USER") {
                let newUser = {
                    name: (document.getElementById("name").value),
                    email: (document.getElementById("email").value),
                    salary: parseFloat( document.getElementById("salary").value ),
                    department: (document.getElementById("department").value).toUpperCase(),
                    role: (document.getElementById("role").value).toUpperCase(),
                    password : (document.getElementById("password").value)
                };

                await storingNewUserInDB(newUser);
            }
        }
        else{

       
        if (editBtn.innerText == "Save Changes") {

            let id = document.getElementById(fields[0].id).value;
              

            if (isNaN(id)) {
                console.log("Invalid id or not a number");
                console.log(id);
                return;
            }


            if (entityType.toUpperCase() == "USER") {
                let updatedUser = {
                    name: (document.getElementById("name").value),
                    email: (document.getElementById("email").value),
                    salary: parseFloat(document.getElementById("salary").value),
                    department: (document.getElementById("department").value).toUpperCase(),
                    role: (document.getElementById("role").value).toUpperCase(),
                };

                await updatingUserInDB(id, updatedUser, fromSection);
            }
           
        }
        


        let inputs = document.querySelectorAll(".inputContainer input");


        inputs.forEach((ele) => {
            //userId and role cannot be updated
            if (ele.id != "employeeId" ) {
                ele.readOnly = !ele.readOnly;
                ele.classList.toggle("editable");
            }
        });


        let selects = document.querySelectorAll(".inputContainer select");


        selects.forEach((ele) => {
            //userId and role cannot be updated
            if ( ele.id != "role") {
                    ele.classList.remove("read-only-select");
            }
        });

         

        if(inputs!=null && inputs.length!=0)
            editBtn.innerText = inputs[2].readOnly ? "Update Details" : "Save Changes";

    }
         
    });



    userFormContainer.appendChild(userForm);
    userFormContainer.appendChild(editBtn);
    tablesContainer.appendChild(heading);
    tablesContainer.appendChild(userFormContainer);



}


//Printing a user profile
function printingProfile(element, fromUsersSection = false) {

    
    let employeeId = element.employeeId;
    let name = element.name;
    let email = element.email;
    let salary = element.salary;
    let department = element.department;
    let role = element.role;


    let fields = [

        { label: "Employee ID", value: employeeId, id: "employeeId", type: "number",required : true },
        { label: "Name", value: name, id: "name", type: "text",required : true },
        { label: "Email", value: email, id: "email", type: "email",required : true },
        { label: "Salary", value: salary, id: "salary", type: "number",required : true },
        { label: "Department", value: department, id: "department", type: "select",required : true,options : [ "FINANCE", "IT", "SALES", "MARKETING","HR"] },
        { label: "Role", value:role, id: "role", type: "select",required : true,options : ["EMPLOYEE","HR"] }
    ];

    printingFormLayout("User Details", fields,"USER",false,fromUsersSection);
}


// validating forms
function validateForm(fields) {
    let isValid = true;
    fields.forEach(field => {
        let inputElement = document.getElementById(field.id);
        if (inputElement && inputElement.hasAttribute("required")) {
            if (!inputElement.value || inputElement.value.trim() === "") {
                alert(`Please fill in the required field: ${field.label}`);
                isValid = false;
                inputElement.focus();
                return false;
            }
        }
      
          if(inputElement && inputElement.type == "email"){
      
            if (!inputElement.checkValidity()) {
                  alert(`Invalid value in ${inputElement.name}`);
                  isValid = false;
                  return false;
            }
          }


          


    });
    return isValid;
}


//implementing logout.......

function logout(){
    window.location.href = "index.html";
}