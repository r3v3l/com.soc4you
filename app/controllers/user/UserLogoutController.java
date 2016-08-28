package controllers.user;

import controllers.common.CommonJsonResponseController;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by adrian on 28.08.16.
 */
public class UserLogoutController extends Controller {

    public static Result logout() {
        session().clear();
        CommonJsonResponseController commonJsonResponseController = new CommonJsonResponseController();
        return ok(commonJsonResponseController.buildJsonResponse("success", "Logged out successfully"));
    }

}
