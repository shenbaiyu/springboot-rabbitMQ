package date.common;

import com.sun.org.apache.xpath.internal.operations.String;
import date.dao.repository.LotteryRecognitionRecordRepository;
import date.model.LotteryRecognitionRecord;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 接收队列消息（queueName=recognition）
 */
@Component
@RabbitListener(queues = "queueTest")
public class MessageHandler {

    @Autowired
    private LotteryRecognitionRecordRepository lotteryRecognitionRecordRepository;

    @RabbitHandler
    public void handleMessage(HashMap message) {
        try {
//            Map map = (HashMap) SerializationUtils.deserialize(message);
//            java.lang.String msg = new java.lang.String(message, "UTF-8");
//            System.out.println(msg);

            System.out.println(message.get("result"));
            System.out.println(message.get("lotteryImage"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}