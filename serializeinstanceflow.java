package com.company;
import java.io.*;

class serializeinstanceflow
{
    public static void main(String[] args) throws Exception
    {
        cat c1 = new cat();
        FileOutputStream fos = new FileOutputStream ("animal.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c1);
		System.out.println("deserializing");

        FileInputStream fis = new FileInputStream ("animal.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        cat	c2 =(cat)ois.readObject(); /* while deserialization,variables from non-serializale 
		parent class has the default value then uses the INSTANCE CONTROL FLOW */
        System.out.println(c1.king+"..."+ c1.name1+".."+c1.name2);
        System.out.println(c2.total+"..."+ c2.totaldog+".."+c2.totalcat);

    }
}
class Animals 

    {
		String king = "lion";
        transient int total = 10;
        Animals()
	    {
        System.out.println("no-argument constructor");
        }   
    }
    class dog extends Animals
    {   
       String name1 ="puppy";
       transient int totaldog = 20;  
    }
    class cat extends dog implements Serializable
    {
        String name2 = "housecat";
        transient int totalcat = 30;
    }