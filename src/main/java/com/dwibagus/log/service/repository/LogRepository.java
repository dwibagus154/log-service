package com.dwibagus.log.service.repository;

import com.dwibagus.log.service.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {
}
