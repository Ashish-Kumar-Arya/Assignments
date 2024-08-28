class Student {
    constructor(name, age) {
        this.name=name;
        this.age=age;
    }

    display() {
        console.log(this.name);
        console.log(this.age);
        document.write(this.name+"<br>"+this.age);
    }
}

    const s1=new Student("Ashish", 22);
    const s2= new Student("Aman",23);
    s1.display();
    s2.display();