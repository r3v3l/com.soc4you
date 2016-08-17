package controllers;

import models.NewsletterModel;
import play.data.Form;
import play.data.validation.Constraints;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;

/**
 * Created by adrian on 17.08.16.
 */
public class NewsletterController extends Controller {

    public static class Newsletter {

        @Constraints.Required
        @Constraints.MaxLength(255)
        @Constraints.Email
        public String email;

    }

    //@RequireCSRFCheck
    public Result index(){

        Form<Newsletter> newsletterForm = Form.form(Newsletter.class).bindFromRequest();
        if(newsletterForm.hasErrors()){

            return ok("Niestety nie udało się dodać adresu e-mail.");

        }

        Newsletter newsletter = newsletterForm.get();

        if(NewsletterModel.findByEmail(newsletter.email) != null){

            return ok("Wybrany adres e-mail istnieje już na naszej liście. Wprowadź inny adres e-mail.");

        }

        NewsletterModel newsletterModel = new NewsletterModel();
        newsletterModel.email = newsletter.email;
        newsletterModel.creationDate = new Date();
        newsletterModel.save();

        return ok("Wiadomość została wysłana.");

    }

}
