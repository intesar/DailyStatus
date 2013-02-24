package com.bia.dailystandup.dao;

import com.bia.dailystandup.entity.Standup;

/**
 *
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
public interface StandupRespositorySearch {

    Standup searchByHashTag(String hashtag);
}
