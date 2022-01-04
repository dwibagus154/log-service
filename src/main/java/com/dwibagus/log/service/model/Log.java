package com.dwibagus.log.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("log")
public class Log {
    @Id
    private String id;
    private String log_activity;
    private Date created_at = new Date();
}

