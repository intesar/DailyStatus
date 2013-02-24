package com.bia.dailystandup.dao;

import com.bia.dailystandup.entity.Standup;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
public interface StandupRepository extends PagingAndSortingRepository<Standup, String>, StandupRespositorySearch {

}
