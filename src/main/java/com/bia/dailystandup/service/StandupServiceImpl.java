package com.bia.dailystandup.service;

import com.bia.dailystandup.dao.StandupRepository;
import com.bia.dailystandup.entity.DailyStatus;
import com.bia.dailystandup.entity.Standup;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> Standup Facade
 *
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
@Service
@Transactional
public class StandupServiceImpl implements StandupService {

    protected static final Logger logger = LoggerFactory.getLogger(StandupServiceImpl.class);
    @Autowired
    protected StandupRepository standupRepository;

    @Override
    public Standup searchByHashTag(String hashtag) {
        return standupRepository.findOne(hashtag);
    }

    @Override
    public Standup create() {
        UUID uuid = UUID.randomUUID();
        Standup standup = new Standup();
        standup.setHashtag(uuid.toString());
        standup.setCreateDate(new Date());
        standupRepository.save(standup);
        return standup;
    }

    @Override
    public Standup addStatus(String hashtag, Date date, String status) {
        Standup standup = standupRepository.findOne(hashtag);
        DailyStatus dailyStatus = new DailyStatus();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        dailyStatus.setStatusDay(calendar.getTime());
        dailyStatus.setStatuses(status);
        
        standup.getDailyStatuses().remove(dailyStatus);
        standup.getDailyStatuses().add(dailyStatus);

        standupRepository.save(standup);

        return standup;
    }
}
