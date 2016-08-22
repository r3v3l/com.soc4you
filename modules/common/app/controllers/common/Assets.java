package controllers.common;
import play.api.mvc.*;
/**
 * Created by adrian on 22.08.16.
 */

public class Assets {
    public static Action<AnyContent> at(String path, String file) {
        return controllers.common.Assets.at(path, file);
    }
}
