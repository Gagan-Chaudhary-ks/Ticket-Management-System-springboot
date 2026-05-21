const loadButton = document.getElementById("loadticketsbtn");

function handleButtonClick() {
    alert("Connection established! JavaScript is listening to your button click.");
}

loadButton.addEventListener("click", handleButtonClick);