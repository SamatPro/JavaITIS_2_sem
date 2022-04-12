function sendProduct() {
    let title = document.getElementById("title").value
    let description = document.getElementById("description").value
    let cost = document.getElementById('cost').value

    const productDto = {
        title: title,
        description: description,
        cost: cost
    };
    console.log(JSON.stringify(productDto))

    $.ajax({
        url: '/products',
        method: 'POST',
        // dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(productDto),
        success: function (data) {
            alert(data);
        }
    })
}