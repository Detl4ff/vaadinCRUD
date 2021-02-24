package com.vaadin.tutorial.crm.views.random;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.MainLayout;
import com.vaadin.tutorial.crm.backend.entity.Company;
import com.vaadin.tutorial.crm.backend.entity.Contact;

import java.util.List;


@PageTitle("Bobo Master | BOBO CRM")
@Route(value = "bobomaster", layout = MainLayout.class)
public class BobomasterView extends VerticalLayout {

    ComboBox<Contact.Status> status = new ComboBox<>("Bobo Master Selector");
    ComboBox<Company> company = new ComboBox<>("Company");
    Button save = new Button("Randomize");

    Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);

    public BobomasterView(List<Company> companies) {
        addClassName("bobo-form");
        binder.bindInstanceFields(this);

        status.setItems(Contact.Status.values());
//        company.setItems(companies);
//        company.setItemLabelGenerator(Company::getName);


           add(
                status,
//                   ,
//                company
                   createButtonsLayout1());
    }

    private HorizontalLayout createButtonsLayout1() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.addClickShortcut(Key.ENTER);
//        save.addClickListener(click -> validateAndSave());
        binder.addStatusChangeListener(evt -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save);
    }

//    private void validateAndSave() {
//        if (binder.isValid()) {
//            fireEvent(new SaveEvent(this, binder.getBean()));
//        }
//    }

//    public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
//        private Contact contact;
//
//        protected ContactFormEvent(ContactForm source, Contact contact) {
//            super(source, false);
//            this.contact = contact;
//        }
//
//        public Contact getContact() {
//            return contact;
//        }
//    }
//
//    public static class SaveEvent extends ContactFormEvent {
//        SaveEvent(ContactForm source, Contact contact) {
//            super(source, contact);
//        }
//    }

}
