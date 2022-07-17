let options = document.getElementById('id');
let vehicle_id = document.getElementById('vehicle_id');

for(let i = 0; i < options.length; i++){
console.log(options[i].value);
if(options[i].value === vehicle_id.value){
 options[i].setAttribute('selected', true);
}
}