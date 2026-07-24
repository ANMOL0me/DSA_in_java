class grand_parent {
public
grand_parent(){
System.out.println("grand_parent class function");
}}
class parent extends grand_parent{
public
parent(){
System.out.println("parent class function");
}}
class child extends parent{
public
child(){
System.out.println("child class function");
}
}

public class Multilevel_inheritance{
public static void main(String[] args){
child obj = new child();
}}
