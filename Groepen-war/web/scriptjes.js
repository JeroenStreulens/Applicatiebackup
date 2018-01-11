function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}

function searchFunc(){
    var input, lijst, opties, filter, i, opt;
    input = document.getElementById('myInput');
    lijst = document.getElementById('studenten');
    opties = document.getElementsByTagName('option');
    filter = input.value.toUpperCase();
    
    for(i = 0; i < opties.length; i++){
        opt = opties[i];
        if(opt.innerHTML.toUpperCase().indexOf(filter) > -1){
            opties[i].hidden = false;
            opties[i].selected = true;
        }    
        else{
            opties[i].hidden = true;
        }
    }
}

function studenten(){
    var voorkeuren, opties, studenten, opt, voor;
    voorkeuren = document.getElementsByName('verwijder');
    studenten = document.getElementById('studenten');
    opties = studenten.options;
    
    for(var i = 0; i < opties.length; i++){
        opt = opties[i];
        for(var j = 0; j < voorkeuren.length; j++){
            voor = voorkeuren[j];
            if(opt.value == voor.value){
                opties[i].hidden = true;
            }
        }
    }
}