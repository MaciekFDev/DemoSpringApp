var counter=1;

function addObject(kontener){
    counter++;
    var znacznik = document.createElement('input');
    var kontener = document.getElementById(kontener);
    var newCheckBox = document.getElementById("textBox1").value;
    if(newCheckBox==='')
    	return false;
    znacznik.setAttribute('type', 'checkbox');
    znacznik.setAttribute('name', newCheckBox);
    znacznik.classList.add('main2');
    znacznik.setAttribute('value', counter);
    znacznik.className = 'main2';

    znacznik.textContent=newCheckBox;

    var znacznik1 = document.createElement('label');
    znacznik1.setAttribute('for', 'textBox1'+counter);
    znacznik1.textContent=newCheckBox;
    kontener.appendChild(znacznik);
    kontener.appendChild(znacznik1);      
}

function resett()
{
    var inputs=document.getElementsByTagName("input");
    for (var i in inputs)
        if (inputs[i].type=="checkbox") inputs[i].checked=false;
    
    location.reload();
}
