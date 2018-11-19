package date.configuration;

import com.mongodb.MongoClientOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class ConfigMongoDB {
    @Autowired
    private Environment env;

    @Bean
    public MongoClient client() {
        MongoClientOptions.Builder build = new MongoClientOptions.Builder();
        //设置每个主机的最大连接数。
        build.connectionsPerHost(10);
        //设置允许阻塞等待连接的线程数量的倍数。(如果当前所有的connection都在使用中，则每个connection上可以有4个线程排队等待)
        build.threadsAllowedToBlockForConnectionMultiplier(4);
        //设置连接超时。
        build.connectTimeout(0);
        //设置的最长时间，线程阻塞等待连接。
        build.maxWaitTime(5000);
//		build.autoConnectRetry(true);
        //默认为true
        build.socketKeepAlive(true);
        //设置套接字超时。
        build.socketTimeout(0);

        MongoClientOptions myOptions = build.build();
        try {
            //数据库连接实例
            String host = env.getProperty("spring.data.mongodb.host");
            Integer port = Integer.valueOf(env.getProperty("spring.data.mongodb.port"));
            ServerAddress serverAddress = new ServerAddress(host, port);

            MongoClient MongoClient = new MongoClient(serverAddress, myOptions);
            return MongoClient;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        String url = env.getProperty("spring.data.mongodb.uri");
        String database = new MongoClientURI(url).getDatabase();
        return new SimpleMongoDbFactory(client(), database);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        MappingMongoConverter converter =
                new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

        return mongoTemplate;
    }
}
