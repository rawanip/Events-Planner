import java.io.*;
public class User implements Serializable
 {
private String fName;
private String lName;
private String uName;
private String email;
private String password;
private int numOfEvents;
private Event[] eventList;



public User(String fName,String lName,String uName,String password,String email){
this.fName=fName;
this.lName=lName;
this.uName=uName;
this.password=password;
this.email=email;
numOfEvents=0;
eventList= new Event[100];}//end con


public int findEvent(int id){

for(int i=0; i<numOfEvents;i++)
if(id==eventList[i].getId())
return i;

return -1;
}//end findEvent



public void addEvent(Event e){

if(numOfEvents<eventList.length)
{
if(e instanceof RecurrentEvent)
eventList[numOfEvents]= new RecurrentEvent(e.getTitle(),e.getDes(),e.getStart(),e.getEnd(),((RecurrentEvent)e).getDuration(),((RecurrentEvent)e).getRecurrence());
else 
eventList[numOfEvents]= new Event(e.getTitle(),e.getDes(),e.getStart(),e.getEnd());
eventList[numOfEvents].setID(numOfEvents+1);

numOfEvents++;
}
}//end addEvent


public boolean cancelEvent(int id)
{
int find = findEvent(id);

if(find!=-1)
{
for(int i=0; i<numOfEvents-1;i++)
{
if(id==eventList[i].getId())
{eventList[i]=eventList[i+1];
eventList[--numOfEvents]= null;
}
}
return true;
}
return false;

}//end cancelEvent

public void importEvent(String file)throws ClassNotFoundException,IOException {

File ev= new File(file);
FileInputStream SF= new FileInputStream(ev);
ObjectInputStream OBF= new ObjectInputStream (SF);

int count =0;

try
{
 while(true)
 {
 OBF.readObject();
 count++;
 }
}//:try
catch(EOFException e)
{OBF.close();}

FileInputStream SF2= new FileInputStream(ev);
ObjectInputStream OBF2= new ObjectInputStream (SF2);

if(eventList.length> numOfEvents+count)
for(int i=0; i<count;i++)
{
addEvent((Event)OBF2.readObject());
}
OBF2.close();

}//end importEvent

public void exportEvent(String file)throws ClassNotFoundException, IOException {
File ev = new File (file);
FileOutputStream SF = new FileOutputStream(ev);
ObjectOutputStream OBF= new ObjectOutputStream(SF);

 for(int i=0; i<numOfEvents ; i++)
 {
 OBF.writeObject(eventList[i]);
 }
OBF.close();
}//end exportEvent


public void displayAll(){
for(int i=0; i<numOfEvents ; i++)
{
System.out.println(eventList[i]);
}
}//end displayAll



public void saveAgenda()throws ClassNotFoundException, IOException {
File ev= new File(uName+".txt");
FileOutputStream SF= new FileOutputStream(ev);
PrintWriter PF= new PrintWriter (SF);

//:user info
PF.println("Name: "+fName+" "+lName+" UserName: "+uName+" Email: "+email+" Password: "+password+" No. of Event: "+numOfEvents);

for(int i=0; i<numOfEvents; i++)
{ PF.println(eventList[i].toString()); }

PF.close();

}//end saveAgenda


public Event[] remaidAll(){
int count=0;
for(int i=0; i<numOfEvents;i++)
if(eventList[i].remind())
count++;

Event [] newArray= new Event[count];

int k=0;

for(int i=0; i<numOfEvents;i++){
if(eventList[i].remind())
newArray[k++]=eventList[i];
 }//end for
return newArray;
}//end remaidAll


public String getfName(){
return fName;}

public String getlName(){
return lName;}

public String getuName(){
return uName;}

public String getemail(){
return email;}

public String getpassword(){
return password;}

public int getnumOfEvents(){
return numOfEvents;}

public Event[] geteventList(){
return eventList;}

}//end class