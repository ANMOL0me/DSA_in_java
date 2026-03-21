import java.io.*;

import java.awt.*;

class StudentFile extends Frame{

//Defining window components

TextField number, name, marks;

Button enter, done;

Label numLabel, namelabel, markLabel;

DataOutputStream dos ;

//Initialize the Frame

public StudentFile()
{
super ("Create Student File");
}
// Setup the window

public void setup()
{
resize (400, 200);

setLayout (new GridLayout (4, 2));

// Create the components of the Frame

number = new TextField (25);

numLabel = new Label ("Roll Number");

name = new TextField (25);


namelabel = new Label ("Student name") ;
marks = new TextField (25) ;

markLabel = new Label ("Marks") ;

enter =  new Button ("ENTER");
done = new Button("DONE") ;


//Add the components to the Frame:

add (numlabel) ;

add (number) ;

add (nameLabel);

add (name);

add (markLabel);

add (marks);

add (enter);

add (done);

//Show the Frame

show () ;



//Open the file
try{
dos = new DataOutputStream (new FileOutputStream ("student.dat")) ;

catch (IOException e)

{

System.err.println (e.toString());
 System.exit (1);
}}
//Write to the file

public void addRecord (){

int num;

Double d;

num = (new Integer (number.getText())).intValue();
try{
dos.writeInt(num);

dos.writeUTF(name.getText());

d = new Double (marks.getText()) ;

dos.writeDouble (d. doubleValue());

catch (10Exception e) [

Clear the text fields

number.setText(""):

name.setText ("");

//Adding the record and clearing the TextFields

public void cleanup()307

if it number.getText().equals("")

das.flush()

dos.close();

L catch (IOException e)(

Processing the event

public boolean action (Event event, obtect al

if (event.teg instanceof Button)

if (event.arg.equals ("ENTER"

addRecord ( return true;

return super.action (event, al

public boolean handleEvent (Event event)

if (event-get instanceof Button)

if (event.arg.equals("DONE"))

cleanup (1

xit (0) 2

System.exit return truer

return super.handleEvent (event):

Execute the program

public static void main (String arge (1)

Student File student student.setup() new StudentFile 11
