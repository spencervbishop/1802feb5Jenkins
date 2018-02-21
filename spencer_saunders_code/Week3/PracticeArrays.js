var arr = [];
arr[99] = "hello";

// for(var i = 0; i< arr.length; i++){
// 	console.log(arr[i]);
// }

// for(var o of arr){
// 	console.log(o);
// }

// for(var o in arr){
// 	console.log(o);
// }

var p = {
	name: "Tyler",
	age: 24,
	doWork: function(){
		console.log("Ferrari");
	}
}

console.log(p.name + " is " + p.age + " years old");
p.doWork();
p.retire = function(){
	console.log("I quit"); //this is called duck typing
} 
p.retire();