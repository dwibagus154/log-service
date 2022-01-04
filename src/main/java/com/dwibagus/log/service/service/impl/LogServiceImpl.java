package com.dwibagus.log.service.service.impl;

import com.dwibagus.log.service.kafka.KafkaConsumerLog;
import com.dwibagus.log.service.kafka.KafkaProducerLog;
import com.dwibagus.log.service.model.Log;
import com.dwibagus.log.service.repository.LogRepository;
import com.dwibagus.log.service.service.LogService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    @Autowired
    private KafkaConsumerLog consumerLog;

    @Autowired
    private KafkaProducerLog producerLog;

    @Override
    public void createLog(){
//        List<String> allmessage = KafkaConsumerLog.messages;
//        List<Log> logList = logRepository.findAll();
//        Log log = new Log();
//        String[] message;
//        LocalDate datenow;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
//        for(int i = 0; i < allmessage.size(); i++){
//            System.out.println(allmessage.get(i));
//            message = allmessage.get(i).split(";");
//            datenow = LocalDate.parse(message[0], formatter);
//            if (logList.size() == 0){
//                log.setLog_activity(allmessage.get(i));
//                logRepository.save(log);
//            }else{
//                if (logList.get(logList.size() - 1).getCreated_at().compareTo(datenow))
//            }
//        }
        List<String> allmessage = KafkaConsumerLog.messages;
        List<Log> logList = logRepository.findAll();
        Boolean notfound = true;
        Log log = new Log();
        int i = 0;
        while(i < allmessage.size() && notfound){
            if(allmessage.get(i).equals(logList.get(logList.size()))){
                notfound = false;
            }
            i++;
        }
        if (notfound){
            for(int j = 0; j < allmessage.size(); j++){
                log.setLog_activity(allmessage.get(j));
            }
        }else{
            for(int j = i+1; j < allmessage.size(); j++){
                log.setLog_activity(allmessage.get(j));
            }
        }

    }

}
