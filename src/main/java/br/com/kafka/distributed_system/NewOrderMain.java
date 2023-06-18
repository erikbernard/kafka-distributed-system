package br.com.kafka.distributed_system;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var dispatcher = new KafkaDispatcher()) {
            for (var i = 0; i < 30; i++) {
                var key = UUID.randomUUID().toString();
                var value = key + ",67523,1234";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

                var email = "Obrigado pelo seu pedido! Estamos processando seu pedido! id:" + key;
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
            }
        }
    }

}