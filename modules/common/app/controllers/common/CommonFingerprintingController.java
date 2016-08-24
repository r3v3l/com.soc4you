package controllers.common;

import models.common.CommonFingerprintingModel;
import play.mvc.Controller;
import repositories.common.commonUserModel.FindCommonUserModelByUsernameRepository;

import java.util.Date;

/**
 * Created by adrian on 24.08.16.
 */
public class CommonFingerprintingController extends Controller {

    public void save(String message){

        FindCommonUserModelByUsernameRepository findCommonUserModelByUsernameRepository =
                new FindCommonUserModelByUsernameRepository();

        CommonFingerprintingModel commonFingerprintingModel = new CommonFingerprintingModel();
        commonFingerprintingModel.commonUserModel = findCommonUserModelByUsernameRepository.find(
                session().get("username")
        );
        commonFingerprintingModel.creationDate = new Date();
        commonFingerprintingModel.currentHost = request().host();
        commonFingerprintingModel.currentMethod = request().method();
        commonFingerprintingModel.currentPath = request().path();
        commonFingerprintingModel.currentUri = request().uri();
        commonFingerprintingModel.currentVersion = request().version();
        commonFingerprintingModel.remoteAddress = request().remoteAddress();
        commonFingerprintingModel.userMessage = message;
        commonFingerprintingModel.save();

    }

}
