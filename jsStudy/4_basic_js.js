function Student(name, age, hakbeon)
{
    this.name = name
    this.age = age
    this.hakbeon = hakbeon
}

const dj = new Student('이동준', 33, '2009038033')
const ng = new Student('이나겸', 33, '2009038033')

Student.prototype.DoStudy = function()
{
    alert("야이야이야")
} 
console.log(dj)
console.log(dj.name)
console.log(dj.age)