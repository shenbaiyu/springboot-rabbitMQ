package date.controller;

import date.model.ResultResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.HashMap;

@Controller
public class TestRabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/test", produces = {"application/json"}, method = RequestMethod.GET)
    public ResponseEntity<ResultResponse> testRabbitMQ() {
        HashMap message = new HashMap();
        message.put("baiduAccurateResult", "测试1");
        message.put("baiduReceiptResult", "测试2");
        message.put("result", "测试3");
        message.put("lotteryImage", "测试4");
        message.put("createTime", "测试5");


        rabbitTemplate.convertAndSend("queueTest", "testKey", message);
        return new ResponseEntity<ResultResponse>(new ResultResponse(200, "成功"), HttpStatus.OK);
    }
}
