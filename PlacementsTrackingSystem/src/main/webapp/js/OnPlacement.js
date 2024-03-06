// gets a reference to the search input element from the DOM using its ID attribute.
const searchInput = document.getElementById('search');
//gets a reference to the first table element in the document.
const table = document.querySelector('table');
//gets a reference to the rows in the table.
const rows = table.tBodies[0].rows;

searchInput.addEventListener('keyup', function(event) {
    const searchTerm = event.target.value.toLowerCase();

    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].cells;
        let hasMatch = false;

        for (let j = 0; j < cells.length; j++) {
            //lower case-sensitive
            const cellText = cells[j].textContent.toLowerCase();

            if (cellText.indexOf(searchTerm) >= 0) {
                hasMatch = true;
                break;
            }
        }

        rows[i].style.display = hasMatch ? '' : 'none';
    }
});