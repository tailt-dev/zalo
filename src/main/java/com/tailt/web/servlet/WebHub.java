package com.tailt.web.servlet;

import com.tailt.web.controller.BotController;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/tailt")
public class WebHub {
    @GET
    @Path("/callback")
    @Produces(MediaType.APPLICATION_JSON)
//    public String callBack(@QueryParam("sendmsg") String sendmsg,
//                           @QueryParam("oaid") String oaid,
//                           @QueryParam("message") String message){
//        System.out.println(message + "----------" + oaid);
//        System.out.println("ok");
//        return "ok";
//    }
    public String callBack(@Context UriInfo info){
        BotController.sendMsgZalo(info.getQueryParameters());
        return "ok";
    }
}
