package com.websocket;

import com.controller.OrderController;
import com.controller.RedisController;
import com.controller.RestaurantController;
import com.controller.UserController;
import org.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nathan on 2018/1/14.
 */

@ServerEndpoint(value = "/fypServer")
public class WebSocketEntry {

    private String sessionId;
    private Session session;
    private UserController userController;
    private OrderController orderController;
    private RedisController redisController;
    private RestaurantController restaurantController;
    private JSONObject responseParams;

    private static Map<String, Session> userSessions = new ConcurrentHashMap<>();
    //连接时执行
    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
        this.sessionId = session.getId();
        userSessions.put(this.sessionId,this.session);
        System.out.println(userSessions.size());
        System.out.println("New Connection: "+sessionId);
    }
    //关闭时执行
    @OnClose
    public void onClose() {
        System.out.println("Close Connection: "+sessionId);
        userSessions.remove(sessionId);
    }
    //收到消息时执行
    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("Get Message From: "+sessionId);
        JSONObject requestParams = new JSONObject(message);
        String requestType = (String)requestParams.getString("type");
        switch (requestType){
            // sign in
            case "signIn":
                userController = new UserController(requestParams);
                responseParams = userController.actionSignIn(sessionId);
                break;
            // sign up
            case "signUp":
                userController = new UserController(requestParams);
                responseParams = userController.actionNewSignUp();
                break;
            // get friend
            case "getFriend":
                userController = new UserController(requestParams);
                responseParams = userController.actionGetFriends();
                break;
            // add friend
            case "addFriend":
                userController = new UserController(requestParams);
                responseParams = userController.actionAddFriend();
                break;
            // copy friend taste
            case "copyTaste":
                userController = new UserController(requestParams);
                responseParams = userController.actionCopyTaste();
                break;
            // update location information
            case "updateLoc":
                userController = new UserController(requestParams);
                System.out.println(requestParams);
                responseParams = userController.actionUpdateLocation();
                break;
            // show nearby restaurants
            case "showRes":
                restaurantController = new RestaurantController(requestParams);
                responseParams = restaurantController.actionSearchRestaurantByDistance();
                break;
            // assign to a restaurant
            case "assignRes":
                restaurantController = new RestaurantController(requestParams);
                responseParams = restaurantController.actionAssignRestaurant();
                break;
            // turn on/off share for sharer
            case "changeStatus":
                userController = new UserController(requestParams);
                responseParams = userController.actionChangeStatus();
                break;
            // search a specific restaurant
            case "searchRes":
                restaurantController = new RestaurantController(requestParams);
                responseParams = restaurantController.actionSearchRestaurantByName();
                break;
            // get restaurant viewing history
            case "restaurantHis":
                restaurantController = new RestaurantController(requestParams);
                responseParams = restaurantController.actionGetHistoryRestaurants();
                break;
            // get recommended restaurant with user history action
            case "nextRes":
                restaurantController = new RestaurantController(requestParams);
                responseParams = restaurantController.actionGetRecommendedRestaurants();
                break;
            // requester calls sharer for an order
            case "callOrder":

                break;
            // sharer answers requester for start an order
            case "answerOrder":

                break;
            // terminate an order
            case "terminateOrder":

                break;
            // finish an order
            case "finishOrder":

                break;
            // add comment to order
            case "commentOrder":

            // send message to the others
            case "sendMessage":
                sendMsg2User(requestParams,responseParams);
                break;
            // get all history orders
            case "historyOrder":
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionGetHistoryOrders();
                break;
            // hungry mode
            case "hungryMode":
                break;
            // hunter mode
            case "hunterMode":
                break;
            // eagel mode
            case "eagleMode":
                break;
            // fans mode
            case "fansMode":
                break;
        }
        System.out.println("response params: "+responseParams);
        sendMessage(responseParams);
    }
    //连接错误时执行
    @OnError
    public void onError(Throwable error) {
        System.out.println("Error Happened In: "+sessionId);
        error.printStackTrace();
    }
    void sendMessage(JSONObject responseParams) throws IOException{
        this.session.getAsyncRemote().sendText(responseParams.toString());
    }

    /**
     *
     * @param requestParams params received from sender
     * @param responseParams params to feed back to sender
     * @return the processed responseParams
     * @throws IOException
     */
    JSONObject sendMsg2User(JSONObject requestParams, JSONObject responseParams) throws IOException{
        userController = new UserController(requestParams);
        String sessionid = userController.actionGetUserSession();
        if(sessionid==null){
            responseParams.put("responseType","SENDMSG_FAIL");
        }else{
            responseParams.put("responseType","SENDMSG_SUCCESS");
            responseParams.put("message",requestParams.getString("message"));
            JSONObject sendParams = new JSONObject();
            sendParams.put("responseType","MSG_COMEIN");
            sendParams.put("message",requestParams.getString("message"));
            userSessions.get(sessionid).getAsyncRemote().sendText(sendParams.toString());
        }
        return responseParams;
    }

}
