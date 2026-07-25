interface face1{
void fun1();}
interface face2{
void fun2();}
class class1 implements face1,face2 {
public void fun1(){
System.out.println("interafce_1 function");
}
public void fun2(){
System.out.println("interafce_2 function");
}}

public class Multiple_inheritance{
public static void main(String[] args){
class1 obj = new class1() ;
obj.fun1;
obj.fun2;
}}
