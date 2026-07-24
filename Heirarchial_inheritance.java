class parent {
public
parent(){
System.out.println("parent class function");
}}
class child_1 extends parent{
public
child_1(){
System.out.println("child 1 class function");
}}
class child_2 extends parent{
public
child_2(){
System.out.println("child 2 class function");
}
}

public class Heirarchial_inheritance{
public static void main(String[] args){
child_1 obj1 = new child_1();
child_2 obj2 = new child_2();

}}
