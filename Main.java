    import java.util.List;
    import java.util.Scanner;
    import java.util.*;
    public class Main {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
   
    		System.out.println("Enter the source");
    		String src = sc.nextLine();
    		System.out.println("Enter the destination");
    		String des = sc.nextLine();
    		System.out.println("Enter the coach type");
            String cah = sc.nextLine();
            String cah2 = cah.toLowerCase();
            
            TrainManagementSystem tms = new TrainManagementSystem();
            if(cah2.matches("^(ac1|ac2|ac3|sleeper|seater)$"))
            {
               List <Train> train = tms.viewTrain(cah2,src,des);
               if(train.isEmpty())
               {
                   System.out.println("No trains found");
              }
               else
               {
                   for(Train t : train)
                   {
                       System.out.println(t.getTrainNumber()+" "+t.getTrainName());
                   }
               }
            }
            else
                System.out.println("Invalid Coach Type");
    		
    	}
    }
