package controllers.user;

import play.api.mvc.Action;
import play.api.mvc.AnyContent;

/**
 * Created by adrian on 22.08.16.
 */

public class Assets {
    public static Action<AnyContent> at(String path, String file) {
        return controllers.user.Assets.at(path, file);
    }
}
