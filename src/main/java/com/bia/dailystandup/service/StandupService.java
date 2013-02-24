/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.dailystandup.service;

import com.bia.dailystandup.entity.Standup;
import java.util.Date;

/**
 *
 * @author mdshannan
 */
public interface StandupService {

    Standup searchByHashTag(String hashtag);

    Standup create();
    
    Standup addStatus(String hashtag, Date date, String status);
}
