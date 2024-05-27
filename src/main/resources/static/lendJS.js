function openPopup(books) {
    var popup = window.open("", "popup", "width=600,height=400");
    var htmlContent = `
        <html>
        <head>
            <title>Book Selection</title>
            <script src="lendJS.js"></script>

        </head>
        <body>
            <h2>Select a Book</h2>
            <form id="bookForm" action="#">
                <select id="bookSelect" name="book_id">

                 <option th:each="book : ${books}" th:value="${book.get('value')}" th:text="${book.get('key')}"></option>
                </select><br><br>
                <button type="button">Select Book</button>
            </form>
        </body>
        </html>
    `;
    popup.document.write(htmlContent);
}


function openPopup2(){
    var popup = window.open("", "popup", "width=600,height=400");
    var htmlContent = `
                <html>
                <head>
                    <title>Book Selection</title>
                </head>
                <body>
                    <h1>Hure</h2>
                </body>
                </html>
            `;
    popup.document.write(htmlContent);
}

function generateOptions(books) {
    var options = "";
    books.forEach(function(book) {
        options += `<option value="${book.get('value')}">${book.get('key')}</option>`;
    });
    return options;
}