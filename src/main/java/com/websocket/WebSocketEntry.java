package com.websocket;

import com.controller.OrderController;
import com.controller.RedisController;
import com.controller.RestaurantController;
import com.controller.UserController;
import org.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

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
    //连接时执行
    @OnOpen
    public void onOpen(Session session) throws IOException {
        this.session = session;
        this.sessionId = session.getId();

        System.out.println("New Connection: "+sessionId);
    }
    //关闭时执行
    @OnClose
    public void onClose() {
        System.out.println("Close Connection: "+sessionId);
    }
    //收到消息时执行
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Get Message From: "+sessionId);
        JSONObject requestParams = new JSONObject(message);
        String requestType = (String)requestParams.getString("type");
        switch (requestType){
            // sign in
            case "signIn":
                userController = new UserController(requestParams);
                responseParams = userController.actionSignIn();
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
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionCallAnOrder();
                break;
            // sharer answers requester for start an order
            case "answerOrder":
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionAnswerAnOrder();
                break;
            // terminate an order
            case "terminateOrder":
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionTerminateAnOrder();
                break;
            // finish an order
            case "finishOrder":
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionFinishAnOrder();
                break;
            // add comment to order
            case "commentOrder":
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionAddCommentToOrder();
            // send message to the others
            case "sendMessage":
                orderController = new OrderController(requestParams);
                responseParams = orderController.actionSendMessage();
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
}
