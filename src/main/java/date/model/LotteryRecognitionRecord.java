package date.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

/**
 * 彩票识别记录
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen")
@Document(collection = "lottery_recognition_record")
public class LotteryRecognitionRecord {

    @Id
    private String id = null;

    @Field("lottery_image")
    private String lotteryImage = null;

    @Field("baidu_result")
    private String baiduResult = null;

    @Field("result")
    private String result = null;

    @Field("create_time")
    private String createTime = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotteryImage() {
        return lotteryImage;
    }

    public void setLotteryImage(String lotteryImage) {
        this.lotteryImage = lotteryImage;
    }

    public String getBaiduResult() {
        return baiduResult;
    }

    public void setBaiduResult(String baiduResult) {
        this.baiduResult = baiduResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
