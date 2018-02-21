// //to run on the command line: navigate to file then type node .\PracticingJavaScript.js or node PracticingJavaScript

// console.log("HelloWorld");

// var num = 10;
// //num = "Hello World";
// var num2 = new Number(10);
// console.log(num+num2);

// //automatic conversions
// console.log(5+"cat");

// function printStatement(msg){
// 	console.log(msg);
// }

// var ps = function(msg){
// 	console.log(msg);
// }

// printStatement("Hello, printStatment!");
// ps("Hello, ps!");

// //I can throw in random crap and it won't bite me for it
// ps("Hello, ps!", true, 10, () =>{});

// //but lets recreate it:
// var ps = function(msg){
// 	console.log(msg);
// 	for(let o of arguments){
// 		console.log(typeof o);
// 	}
// }
// ps("Hello", 1, true, ()=>{});

// //another way to use functions (remember that functions can return anything)
// function Person(name, age){
// 	this.name = name;
// 	this.age = age;
// }

// var p = new Person("Spencer", 24);
// console.log(p.name + " is ".concat(p.age));
// console.log(typeof p);
// console.log(p); //works like a toString method

// //high order function
// var teams = ['Saints', 'Buckaneers', 'Eagles'];
// teams.forEach(function(item){
// 	console.log(item);
// });

var root = function(){
	return function(){
		console.log("I am the child of root.");
	}
}();  

//<= immediately invoking function
//root()();