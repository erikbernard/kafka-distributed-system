package br.com.kafka.distributed_system;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerRun {
    void consumer(ConsumerRecord<String,String> record);
}
