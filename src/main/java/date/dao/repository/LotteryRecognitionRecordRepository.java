package date.dao.repository;

import date.model.LotteryRecognitionRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LotteryRecognitionRecordRepository extends MongoRepository<LotteryRecognitionRecord, String> {
}
