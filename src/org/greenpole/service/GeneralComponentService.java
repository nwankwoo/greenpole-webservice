/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.greenpole.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import org.greenpole.entity.response.Response;
import org.greenpole.entity.security.Login;

/**
 *
 * @author Akinwale Agbaje
 * Web service for all components.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface GeneralComponentService {
    /**
     * Request to get all notifications for logged in user
     * @param login the user's login details
     * @return response to the get user notifications request
     */
    @WebMethod
    @WebResult(name = "response")
    public Response getReceiverNotifications_Request(@WebParam(name = "login", header = true) Login login);
    
    /**
     * Request to reject notification.
     * @param login the user's login details
     * @param notificationCode the notification code
     * @return response to the reject notification request
     */
    @WebMethod
    @WebResult(name = "response")
    public Response rejectNotification(@WebParam(name = "login", header = true) Login login, @WebParam(name = "notificationCode") String notificationCode);
}
