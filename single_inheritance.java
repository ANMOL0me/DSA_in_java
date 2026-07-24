class parent { //parent class
public
parent(){
System.out.println("parent class function");
}
}
class child extends parent { //child class
public
child(){
System.out.println("Child class function");
}
}
public class single_inheritance{
public static void main(String[] args){
child obj = new child() ;
}
} 