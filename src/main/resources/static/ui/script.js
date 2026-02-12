const API_URL = "http://localhost:8080/api/convert";

async function convert() {
    const value = document.getElementById("value").value.trim();
    const from = document.getElementById("from").value;
    const to = document.getElementById("to").value;
    const resultBox = document.getElementById("result");
    const button = document.querySelector("button");

    if (!value || !from || !to) {
        resultBox.innerText = "Please fill all fields.";
        resultBox.className = "result error";
        return;
    }

    button.disabled = true;
    resultBox.innerHTML = '<div class="loader"></div>';

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ value, from, to })
        });

        const data = await response.json();
        resultBox.classList.remove("success", "error");

        if (!response.ok) {
            resultBox.innerText = data.message || "Something went wrong.";
            resultBox.classList.add("error");
            return;
        }

        resultBox.innerText = "Result: " + data.result;
        resultBox.classList.add("success");

    } catch (error) {
        resultBox.className = "result error";
        resultBox.innerText = "Cannot connect to server.";
    } finally {
        button.disabled = false;
    }
}

// Remove focus from selects after choosing
document.querySelectorAll("select").forEach(select => {
    select.addEventListener("change", () => select.blur());
});
