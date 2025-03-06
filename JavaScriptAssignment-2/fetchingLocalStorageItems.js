document.getElementById('difficulty').innerText = localStorage.getItem('difficulty');
document.getElementById('categoryName').innerText = localStorage.getItem('categoryName');

document.getElementById('end-game-btn').addEventListener('click',()=>{
    window.location.href = 'index.html';
})