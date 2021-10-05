package com.company;
import java.io.*;
public class serializeencryptdemo
{
    public static void main(String[] args) throws Exception
    {
        Account a1 = new Account();                                    //creating a1 object having name and password
        FileOutputStream fos = new FileOutputStream("myfilehari.txt");  //creating a file to store in database
        ObjectOutputStream oos = new ObjectOutputStream(fos);            //oos to write on fos
        oos.writeObject(a1);

        FileInputStream fis = new FileInputStream("myfilehari.txt");   //to read file binary from database
        ObjectInputStream ois = new ObjectInputStream (fis);           //reading object from file
        Account a2 = (Account)ois.readObject();                         //typecasting parent object into account type
        System.out.println(a1.username+"......"+a1.password);
       System.out.println(a2.username+"......"+a2.password);

    }
}

class Account implements Serializable
{
    String username = "hari";
    transient String password = "chidambaram";             //while serialization default value saved in database

    private void writeObject(ObjectOutputStream os) throws Exception
    {
        os.defaultWriteObject();                           //calling default() to write a1 in database
        String epassword = "encryptingyou1233"+password;   //encrypting the orginal password
        os.writeObject(epassword);                          //writing the encrypted password in file

    }

    private void readObject(ObjectInputStream is) throws Exception
    {
        is.defaultReadObject();                     //calling default() to read a1 from database
        String epassword = (String)is.readObject();  //reading encryption,typecasting returntype parent to stringtype,assinging that to epassword
		System.out.println(epassword);
        password = epassword.substring(17);         //DECRYPTING and calling substing() on string returntype, assign that returntype string to password
    }
}
