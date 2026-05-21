const API_URL = "http://localhost:8080/api/tickets";

const loadButton = document.getElementById("loadticketsbtn");

async function fetchTickets() {
    try{
        const response = await fetch(API_URL);

        if(!response.ok){
            throw new error(`server returned a bad response ${response.status}`);
        }

        const tickets = await response.json();

        console.log("success! Data recieved from database: " , tickets);

    }catch(error){
        console.error("Network communication failure !", error);
    }
}

loadButton.addEventListener("click", fetchTickets);