let options = document.getElementById('id');
let insured_id = document.getElementById('insured_id');

for(let i = 0; i < options.length; i++){
console.log(options[i].value);
if(options[i].value === insured_id.value){
 options[i].setAttribute('selected', true);
}
}