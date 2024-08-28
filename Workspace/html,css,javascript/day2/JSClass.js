class Student {
    constructor(name, age) {
       this.name= name;
       this.age=age;
    }
    display() {
        document.write(this.name+" "+this.age+"<br>")
    }
}

const1=new Student("Kamal",22);
const2=new Student("Kavita",21);

const1.display();
const2.display();