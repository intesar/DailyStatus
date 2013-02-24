package com.bia.dailystandup.service;

import com.bia.dailystandup.entity.Standup;
import java.util.Date;

/**
 *
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
public interface StandupService {

    Standup searchByHashTag(String hashtag);

    Standup create();
    
    Standup addStatus(String hashtag, Date date, String status);
}
