import java.util.Scanner;
//discrete mathematics 
public class Propositional_Logic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter propositional statement for P: ");
        String p_var = sc.nextLine();

        System.out.print("Enter truth value of P (true/false): ");
        boolean p = sc.nextBoolean();
        sc.nextLine(); 

        System.out.print("Enter propositional statement for Q: ");
        String q_var = sc.nextLine();

        System.out.print("Enter truth value of Q (true/false): ");
        boolean q = sc.nextBoolean();

        boolean andResult = p && q;
        boolean orResult = p || q;
        boolean notP = !p;
        boolean implies = !p || q;
        boolean biconditional = (p && q) || (!p && !q);

        System.out.println("\nResults of Propositional Logic:");

        System.out.println("Conjunction: " + p_var + " AND " + q_var + " = " + andResult);
        System.out.println("Disjunction: " + p_var + " OR " + q_var + " = " + orResult);
        System.out.println("Negation: NOT " + p_var + " = " + notP);
        System.out.println("Implication: If " + p_var + " then " + q_var + " = " + implies);
        System.out.println("Biconditional: " + p_var + " iff " + q_var + " = " + biconditional);

        sc.close();}}