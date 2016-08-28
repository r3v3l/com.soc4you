package controllers.common;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by adrian on 28.08.16.
 */
public class CommonSecuredController extends Security.Authenticator {

    public String getUsername(Http.Context ctx){
        return ctx.session().get("username");
    }

    public Result onUnauthorized(Http.Context ctx) {
        return unauthorized();
    }

}
