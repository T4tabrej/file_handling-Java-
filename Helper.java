import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*; 
public class Helper {
    File myObj;
    String filename;
    Scanner sc=new Scanner(System.in);
    public boolean CreateDataBase(String dbName){
        myObj= new File(dbName); 
        filename=dbName;

       try {

        if (myObj.createNewFile()) {
            // System.out.println("DataBase Created");
            return true;
        } 
        // else {
        //     // System.out.println("No DataBase Found");
        //     // return false;
        // }

       } 
       catch (Exception e) {
          System.out.println(e);
       }
       return false;

    }



    public void write(){
        try {
            FileWriter myWriter=new FileWriter(filename,true);
            // FileWriter myWriter=new FileWriter(filename,true); true for append file
            System.out.println("Enter name");
            String name=sc.next();
            System.out.println("Enter roll");
            String roll=sc.next();
            System.out.println("Enter class");
            String std=sc.next();

            




            if (!checkId(roll)) {
            myWriter.write(roll+" "+name+" "+std+"\n");
            myWriter.close();
            System.out.println("Data Inserted SuccesFully....");
                
            } else {
                System.out.println("Id Already Present in DataBase");
            }

            

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public boolean checkId(String roll){

       
boolean result=false;


        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().substring(0,3);
                if (data.equals(roll)) {
                    //  System.out.println("id Already Present");
                     result=true;
                     break;
                     
                }
                // System.out.println(data.substring(0,3));
              }
              myReader.close();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        return result;
    }


     
}
