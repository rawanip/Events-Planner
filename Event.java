import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public  class Event implements Serializable{
private Date startD;
private Date endD;
protected int  id;
protected String title;
protected String description;

public Event(String title,String des,Date start,Date end){
this.title=title;
description=des;

if(start.after(end))
throw new IllegalArgumentException();
else
{startD=start;
endD=end;
}
 }

public boolean remind()
{return startD.after(new Date());}


public String toString()
{
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // to print Date object in this format

   return String.format("Event #%d: %s\n\t%s\nStarts: %s\nEnds: %s",id, title, description, sdf.format(startD), sdf.format(endD));
}


public int getId(){
return id;}

public String getTitle(){
return title;}

public String getDes(){
return description;}

public Date getStart(){
return startD;}

public Date getEnd(){
return endD;}

public void setID(int ID)
{id=ID;}
}//clas
