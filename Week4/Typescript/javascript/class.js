// class Person {

//     constructor(name, age) {
//         this.name = name;
//         this.age = age;
//     }

//     live(){}
//     payTax(){}
//     die(){}
// }

// var Person2 = (function(){

//     function Person(name, age){
//         this.name = name;
//         this.age = age;
//     }

//     Person.live = function() {}
//     Person.payTax = function(){}
//     Person.die = function(){}

//     return Person;
// })()

// var p1 = new Person("August", 35);
// var p2 = new Person2("John", 48);

// var p3 = new Person(()=>{console.log("this ain't no string")}, true);

document.addEventListener("DOMContentLoaded", () =>{
    document.querySelector("button").addEventListener('click', () => {
        const xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            if(xhr.readyState === 4) {
                if(xhr.status == 200) {
                    document.querySelector("#data").innerHTML = xhr.responseText;
                } else {
                    document.querySelector("#data").innerHTML = "Nope";
                }
            }
        }
        xhr.open("GET", "http://localhost:8080/msw/my-first-servlet");
        xhr.send();
    });
});