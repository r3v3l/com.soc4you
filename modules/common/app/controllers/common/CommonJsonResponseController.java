package controllers.common;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.Controller;

/**
 * Created by adrian on 25.08.16.
 */
public class CommonJsonResponseController extends Controller {

    public ObjectNode buildJsonResponse(String type, String message){

        ObjectNode wrapper = Json.newObject();
        ObjectNode msg = Json.newObject();
        msg.put("message", message);
        wrapper.put(type, msg);
        return wrapper;

    }

}
