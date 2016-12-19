import javax.jms.*;
import javax.naming.InitialContext;  
public class Listener implements MessageListener {  
	
	 
    public void onMessage(Message m) {  
    	
    	
        try{  
        //TextMessage msg=(TextMessage)m;  
         ObjectMessage recvd = (ObjectMessage)m;
         
         
       
         Order or = (Order) recvd.getObject();
         if(or.getReqdQuantity() > or.availQuantity){
        	 
        	 throw new InsufficientStockException("Required Quantity of " + or.getItemName() + "not in Stock");
         }
         
         or.setOrderStatus(Order.Status.PROCESSED);
         submitToProcessedQ(m);
         
      //   System.out.println("following message is received:"+msg.getText());  
        }catch(JMSException e){System.out.println(e);}  
    }  
    
    private void submitToProcessedQ(Message m){
    	
    	try{
       	 //Create and start connection  
           InitialContext ctx=new InitialContext();  
           QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");  
           QueueConnection con=f.createQueueConnection();  
          con.start();
           //2) create queue session  
           QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
           //3) get the Queue object  
           Queue t=(Queue)ctx.lookup("executedOrderQueue");  
           //4)create QueueSender object         
           QueueSender sender=ses.createSender(t);  
           
           sender.send(m);
           
           System.out.println("Order processed successfully");
           
           
       	}catch(Exception e){
       		
       		System.out.println("Exception caught" + e);
       	}
    	
    }
}  
