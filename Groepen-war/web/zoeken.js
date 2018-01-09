/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            return;
        }    
        else{
            opties[i].hidden = true;
        }
    }
}


       