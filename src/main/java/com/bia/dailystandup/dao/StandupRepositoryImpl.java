package com.bia.dailystandup.dao;

import com.bia.dailystandup.entity.Standup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
public class StandupRepositoryImpl implements StandupRespositorySearch {

    protected static final Logger logger = LoggerFactory.getLogger(StandupRepositoryImpl.class);
    @PersistenceUnit(unitName = "daily-standup-pu")
    private EntityManagerFactory emf;

    @Override
    public Standup searchByHashTag(String hashtag) {
        logger.info("searchByHashTag = {}", hashtag);
        EntityManager em = emf.createEntityManager();

        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(em);


        final QueryBuilder b = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Standup.class).get();

        org.apache.lucene.search.Query luceneQuery =
                b.keyword()
                .onField("hashtag")
                .matching(hashtag)
                .createQuery();

        FullTextQuery fullTextQuery =
                fullTextEntityManager.createFullTextQuery(luceneQuery);

        Standup standup = (Standup) fullTextQuery.getSingleResult();

        logger.info("searchBySurahName result = {}", standup);

        return standup;

    }
}
