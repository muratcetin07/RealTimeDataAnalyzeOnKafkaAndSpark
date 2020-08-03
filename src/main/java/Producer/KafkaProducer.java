package Producer;

import com.google.gson.Gson;
import model.SearchModel;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class KafkaProducer {

    public static void main(String[] args) {

        Scanner read=new Scanner(System.in);
        String topic="search";
        Gson gson=new Gson();
        Properties properties=new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        Producer producer = new org.apache.kafka.clients.producer.KafkaProducer(properties);

        while(true){
            System.out.println("Search : ");
            String productItem = read.nextLine();
            SearchModel sp=new SearchModel();
            sp.setProduct(productItem);
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            sp.setTime(time);
            String json = gson.toJson(sp);
            System.out.println(json);
            ProducerRecord<String,String> rec=new ProducerRecord<String, String>(topic,json);
            producer.send(rec);
            System.out.println("It was sent to Kafka");
        }
    }
}
