function validateOrderForm() {
    const name = document.getElementById("name").value;
    const address = document.getElementById("address").value;
    const phone = document.getElementById("phone").value;

    if (name === "" || address === "" || phone === "") {
        alert("All fields must be filled out.");
        return false;
    }

    if (!/^\d{10}$/.test(phone)) {
        alert("Phone number must be 10 digits.");
        return false;
    }

    return true;
}
