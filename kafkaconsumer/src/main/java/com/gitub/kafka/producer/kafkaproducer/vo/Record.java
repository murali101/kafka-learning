package com.gitub.kafka.producer.kafkaproducer.vo;

public class Record {
    private String id;
    private String name;

    public Record(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Record() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
