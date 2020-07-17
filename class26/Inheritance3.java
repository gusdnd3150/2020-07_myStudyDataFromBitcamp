class Hobby{
 String name;
 String type;
 
 Hobby(){
 }
 
 Hobby(String name, String type){
  this.name = name;
  this.type = type;
 }
 
 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getType() {
  return type;
 }

 public void setType(String type) {
  this.type = type;
 } 
}

class Person{                  ///사람  이름 취미 성별      부모클래스
 private String name;
 private String gender;
 private Hobby b;
 
 public Person() {
 }
 
 public Person(String name, String gender) {              //생성자 2개
  this.name = name;
  this.gender = gender;
 }
 
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getGender() {
  return gender;
 }
 public void setGender(String gender) {
  this.gender = gender;
 }
 public Hobby getB() {
  return b;
 }
 public void setB(Hobby b) {
  this.b = b;
 }
 
 public void eat() {
  System.out.println("식사합시다");
 }
 
 public void hello() {
  System.out.println("안녕하세요");
 }
}

class Student extends Person{                           // 자식클래스
 
 public Student() {
 }                  
 public Student(String name, String gender) {             //생성자 2개
  super(name, gender);
  //super.setName(name);
  //super.setGender(gender);
 }
 
 public void hello() {
  System.out.println("안녕하세요 취미가 "+super.getB().getName()+"인 "+super.getName()+"입니다");
 }
} 