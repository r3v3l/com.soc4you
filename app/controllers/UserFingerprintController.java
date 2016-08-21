package controllers;

import models.UserFingerprintModel;
import models.UserModel;
import play.mvc.Controller;

import java.util.Date;

/**
 * Created by adrian on 21.08.16.
 */
public class UserFingerprintController extends Controller {

    public static boolean saveData(String message){

        UserModel userModel = null;

        if(session().get("email") != null) {
            userModel = UserModel.findByEmail(session().get("email"));
        }
        UserFingerprintModel userFingerprintModel = new UserFingerprintModel();
        userFingerprintModel.user = userModel;
        userFingerprintModel.creationDate = new Date();
        userFingerprintModel.currentHost = request().host();
        userFingerprintModel.currentMethod = request().method();
        userFingerprintModel.currentPath = request().path();
        userFingerprintModel.currentUri = request().uri();
        userFingerprintModel.currentVersion = request().version();
        userFingerprintModel.remoteAddress = request().remoteAddress();
        userFingerprintModel.userMessage = message;
        userFingerprintModel.save();

        return true;

    }

}
