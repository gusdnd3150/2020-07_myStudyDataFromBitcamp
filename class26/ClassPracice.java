class Vehicle implements Cloneable {
 private String ownerName;
 private int year;
 private String color;

 public Vehicle(int year, String color) {
  this.year = year;
  this.color = color;
 }

 public String getOwnerName() {
  return ownerName;
 }

 public void setOwnerName(String ownerName) {
  this.ownerName = ownerName;
 }

 public int getYear() {
  return year;
 }

 public void setYear(int year) {
  this.year = year;
 }

 public String getColor() {
  return color;
 }

 public void setColor(String color) {
  this.color = color;
 }

 public void move() {
  System.out.println("이동하다");
 }

 public Object clone() { // override
  Object obj = null;
  try {
   obj = super.clone(); // clone()은 반드시 예외처리를 해주어야 한다.
  } catch (CloneNotSupportedException e) {
  }
  return obj;
 }

}

class Car extends Vehicle {
 private String carType;

 public Car(int year, String color, String carType) {
  super(year, color);
  this.carType = carType;
 }

 public String getCarType() {
  return carType;
 }

 public void setCarType(String carType) {
  this.carType = carType;
 }

 public void move() {
  System.out.println("Car로 이동하다");
 }

 public void refuel() {

 }

 public boolean equals(Object obj) {
  if (obj != null && obj instanceof Car) { // obj가 Person2의 Instance
   return super.getOwnerName() == ((Car) obj).getOwnerName(); // 멤버변수값이 같은지 비교
  } else {
   return false;
  }
 }

 public String toString() {
  return super.getOwnerName() + "/" + super.getYear();
 }

}

class Autobicycle extends Vehicle {
 private String autoType;

 public Autobicycle(int year, String color, String autoType) {
  super(year, color);
  this.autoType = autoType;
 }

 public String getAutoType() {
  return autoType;
 }

 public void setAutoType(String autoType) {
  this.autoType = autoType;
 }

 public void move() {
  System.out.println("오토바이로 이동하다");
 }

 public void refuel() {

 }

 public boolean equals(Object obj) {
  if (obj != null && obj instanceof Autobicycle) { // obj가 Person2의 Instance
   return super.getOwnerName() == ((Autobicycle) obj).getOwnerName(); // 멤버변수값이 같은지 비교
  } else {
   return false;
  }
 }

 public String toString() {
  return super.getOwnerName() + "/" + super.getYear();
 }
}