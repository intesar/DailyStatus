package com.bia.dailystandup.rest;

import com.bia.dailystandup.entity.Standup;
import com.bia.dailystandup.service.StandupService;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
@Path("/standup")
@Component
public class StandupRest {

    @Autowired
    protected StandupService standupService;

    /**
     *
     *
     * @param hashtag - user id
     *
     * @return
     */
    @GET
    @Path("/{hashtag}")
    @Produces({MediaType.APPLICATION_JSON})
    public Standup search(@PathParam("hashtag") String hashtag) {
        return this.standupService.searchByHashTag(hashtag);
    }

    /**
     *
     *
     * @param hashtag - user id
     *
     * @return
     */
    @POST
    //@Path()
    @Produces({MediaType.APPLICATION_JSON})
    public Standup create() {
        return standupService.create();
    }

    @POST
    @Path("/status")
    @Produces({MediaType.APPLICATION_JSON})
    public Standup addStatus(@FormParam("hashtag") String hashtag, @FormParam("statusDay") Date date,
            @FormParam("statuses") String statuses) {
        return standupService.addStatus(hashtag, date, statuses);
    }
}
