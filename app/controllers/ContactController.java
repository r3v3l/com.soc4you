package controllers;

import models.ContactModel;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;

/**
 * Created by adrian on 17.08.16.
 */
public class ContactController extends Controller {

    public static class Contact {

        @Constraints.Required
        @Constraints.MinLength(1)
        @Constraints.MaxLength(255)
        public String username;

        @Constraints.Required
        @Constraints.MaxLength(255)
        @Constraints.Email
        public String email;

        @Constraints.Required
        @Constraints.MinLength(1)
        @Constraints.MaxLength(255)
        public String message;

    }

    public Result index(){

        Form<Contact> contactForm = Form.form(Contact.class).bindFromRequest();
        if(contactForm.hasErrors()){

            return ok("Niestety nie udało się dodać adresu e-mail.");

        }

        Contact contact = contactForm.get();

        ContactModel contactModel = new ContactModel();
        contactModel.email = contact.email;
        contactModel.username = contact.username;
        contactModel.message = contact.message;
        contactModel.creationDate = new Date();
        contactModel.save();

        return ok("Wiadomość została wysłana.");

    }

}
