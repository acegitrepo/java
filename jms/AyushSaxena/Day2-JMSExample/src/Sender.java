import java.io.BufferedReader;  
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.naming.*;

import javax.jms.*;  
  
public class Sender {  
    public static void main(String[] args) {  
        try  
        {   //Create and start connection  
            InitialContext ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
            //2) create queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            //3) get the Queue object  
            Queue t=(Queue)ctx.lookup("orderQueue");  
            //4)create QueueSender object         
            QueueSender sender=ses.createSender(t);  
            //5) create TextMessage object  
       //     TextMessage msg=ses.createTextMessage();  
            
           
            ObjectMessage objMsg = ses.createObjectMessage();
            Scanner sc = new Scanner(System.in);
            while(true){
            	Order order= new Order();
            	System.out.println("Enter order details:");
            	System.out.println("1. Enter name ");
            	order.setItemName(sc.nextLine());
            	System.out.println("2. Enter No. of Items ");
            	order.setReqdQuantity(sc.nextInt());
            	System.out.println("3. Enter Price");
            	order.setPrice(sc.nextInt());
            	order.setOrderStatus(Order.Status.WAITING);
            	
            	objMsg.setObject(order);
            	sender.send(objMsg);
            	
            	
            	
            }
              
            
            
            //6) write message  
            /*BufferedReader b=new BufferedReader(new InputStreamReader(System.in));  
            while(true)  
            {  
                System.out.println("Enter Msg, end to terminate:");  
                String s=b.readLine();  
                if (s.equals("end"))  
                    break;  
                msg.setText(s);  
                //7) send message  
                sender.send(msg);  
                System.out.println("Message successfully sent.");  
            }*/  
            //8) connection close  
              
        }catch(Exception e){System.out.println(e);}  
    }  
}  