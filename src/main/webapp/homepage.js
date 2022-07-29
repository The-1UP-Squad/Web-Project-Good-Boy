  
function myFunction(input1, table1, tableRow) {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
   input = document.getElementById(input1);
  filter = input.value.toUpperCase();
  table = document.getElementById(table1);
  tr = table.getElementsByTagName(tableRow);
  

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

my




