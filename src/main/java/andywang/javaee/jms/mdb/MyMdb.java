package andywang.javaee.jms.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

@MessageDriven(name = "MyMdb", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MyMdb implements MessageListener {

    private static final Logger LOGGER = Logger.getLogger(MyMdb.class.getSimpleName());

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String text = ((TextMessage) message).getText();
                LOGGER.info("Received Message: " + text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
