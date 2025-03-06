console.log("hellp");
getCategories();
let categories ;

async function getCategories() {
    let urlForCategory = 'https://opentdb.com/api_category.php';
    
    try {
        
        
        let response = await fetch(urlForCategory);
        let data = await response.json();
        categories = data.trivia_categories;
        puttingCategories();

    // console.log(categories);
  } catch (error) {
    console.log('hello there is error: ', error);
  }
}


function puttingCategories(){
    
    let categoryBox = document.getElementById('categories-box');
    console.log(categories);

    categories.forEach(element => {
        console.log(element.id, "  ", element.name);
        let option = document.createElement('option');
        option.value = element.id;
        option.innerText = element.name;

        // option.addEventListener('focus',()=>{
        //     localStorage.setItem('category',element.name);
        // });

        categoryBox.append(option);
    });

    

}


function storingInLocalStorage(){
    storingCategories();
    storingDifficultyLevel();
    window.location.href = 'quiz.html';
}

function storingCategories(){
    let categoryBox = document.getElementById('categories-box') ;

    let categorySelected = categories[categoryBox.selectedIndex] || categories[0];
    console.log(categories[categoryBox.selectedIndex]);

    let categoryID = categorySelected.id;
    let categoryName = categorySelected.name;
    console.log(categoryName);

    localStorage.setItem('categoryName',categoryName);
    localStorage.setItem('categoryID',categoryID);
}

function storingDifficultyLevel(){
    let difficultySelected = document.querySelector('input[name="difficulty-level"]:checked') || document.querySelector('input[value="easy"]');
    // console.log(difficultySelected.value);
    localStorage.setItem('difficulty',difficultySelected.value.toLowerCase() );
}