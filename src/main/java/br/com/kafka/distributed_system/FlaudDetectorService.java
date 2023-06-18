package br.com.kafka.distributed_system;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FlaudDetectorService {
    public static void main(String [] args) {
        var topic = "ECOMMERCE_NEW_ORDER";
        var flaudDetectorService = new FlaudDetectorService();
        var service = new KafkaService(FlaudDetectorService.class.getSimpleName(), topic, flaudDetectorService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Processando novo pedido, verificando se há fraude");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Pedido processada");
    }
}
