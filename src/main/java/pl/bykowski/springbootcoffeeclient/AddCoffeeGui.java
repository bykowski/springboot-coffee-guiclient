package pl.bykowski.springbootcoffeeclient;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class AddCoffeeGui extends VerticalLayout {

    private CoffeeClient coffeeClient;

    @Autowired
    public AddCoffeeGui(CoffeeClient coffeeClient) {
        this.coffeeClient = coffeeClient;
        TextField textFieldName = new TextField("Coffee name");
        TextField textFieldType = new TextField("Coffe type");
        Button button = new Button("Add coffee");
        Image image = new Image("https://media.tenor.com/images/0f44d1960381f1729f3b6f995cccd857/tenor.gif", "nie ma obrazka :(");


        button.addClickListener(
                clickEvent -> {
                    coffeeClient.addCoffee(textFieldName.getValue(), textFieldType.getValue());
                    Notification notification = new Notification(
                            "Added new item: " + textFieldName.getValue() + " of " + textFieldType.getValue(), 5000);
                    notification.open();
                    add(image);
                });
        add(textFieldName);
        add(textFieldType);
        add(button);
    }



}
