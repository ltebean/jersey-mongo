/**
 * 
 */
package com.my.web.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jongo.Jongo;
import org.springframework.stereotype.Component;

import com.my.web.model.Friend;
import com.my.web.mongo.JongoClient;

/**
 * @author cong.yu
 * 
 */
@Component
@Path("/friend")
public class FriendResource {

    private Jongo jongo = JongoClient.getInstance();

    public FriendResource() {

    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Friend> getFriendList() {
        return jongo.getCollection("friends").find().as(Friend.class);
    }

}
