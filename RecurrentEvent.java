import java.util.*;
import java.lang.Math.*;
import java.text.SimpleDateFormat;

public class RecurrentEvent extends Event
{
private int duration;
private char recurrence;

public RecurrentEvent(String title,String des,Date start, Date end,int duration, char recurrence)
{
super(title,des,start,end);
this.duration=duration;
this.recurrence= recurrence;
}

public boolean remind()
{

Date Today = new Date();
int x= Math.abs(Today.getDate() - getEnd().getDate());

//if(getStart().after(Today))
//{x= Math.abs(getEnd().getDate()- getStart().getDate());}

if(recurrence =='W')
x= x/7;
else if(recurrence =='M')
x= x/30;

if(x>=1)
return true;
else
return false;
}

public String toString()
{


int x=0;
if(recurrence=='D')
x=1;
else if(recurrence=='W')
x=7;
else if(recurrence =='M')
x=30;


 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 
String all="";

Date START= new Date(getStart().getYear(),getStart().getMonth(),getStart().getDate());
Date END = new Date (getStart().getYear(),getStart().getMonth(),(getStart().getDate()+(duration-1)));

int i=0;
while(START.before(getEnd())) 
{
all+="\n"+sdf.format(START)+" - "+sdf.format(END);

START.setDate((START.getDate()+x));
END.setDate((START.getDate()+(duration-1)));
i++;
}
return "Event#"+id+": "+title+"\nDescription: "+description+""+all ;}


public int getDuration() 
{return duration;}

public char getRecurrence()
{return recurrence;}

}//:end class