public class Planner
{
private int numOfUsers;
private User[]usersList;


public Planner(User[]users)
{

int count =0;
usersList =new User[users.length];

for(int i=0; i<users.length;i++)
{
if(users[i]!=null)
{usersList[i]=new User(users[i].getfName(),users[i].getlName(),users[i].getuName(),users[i].getpassword(),users[i].getemail());

for(int k=0; k<users[i].getnumOfEvents(); k++)
{usersList[i].addEvent(users[i].geteventList()[k]);}
numOfUsers= ++count;

}
}


}//end con

public boolean registerUser(String fName, String lName, String uName, String password, String email)
{
if(numOfUsers<usersList.length)
{
usersList[numOfUsers++]= new User(fName,lName,uName,password,email);
return true;
}
return false;
}//end registerUser

public  boolean login(String uName,String password)
{
for(int i=0; i<usersList.length;i++)
{
if(usersList[i]!=null)
{
if(uName.equals(usersList[i].getuName())&&password.equals(usersList[i].getpassword()))
return true;
}
}

return false;

}//login


public User[] getusersList(){
return usersList;}
}//end class