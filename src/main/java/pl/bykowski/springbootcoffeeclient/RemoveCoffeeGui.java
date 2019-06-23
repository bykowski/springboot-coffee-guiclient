package pl.bykowski.springbootcoffeeclient;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Route
public class RemoveCoffeeGui extends VerticalLayout {

    private CoffeeClient coffeeClient;

    @Autowired
    public RemoveCoffeeGui(CoffeeClient coffeeClient) {
        this.coffeeClient = coffeeClient;
        TextField textField = new TextField("Give id to remove");
        Label label = new Label();
        Image image = new Image("https://media.giphy.com/media/l1J9u3TZfpmeDLkD6/giphy.gif", "nie ma obrazka :(");

        Button button = new Button("Removed");
        button.addClickListener(
                clickEvent -> {
                    coffeeClient.removeCoffee(Long.parseLong(textField.getValue()));
                    label.setText("Removed!");
                    add(image);
                });
        add(textField);
        add(label);
        add(button);
    }


}
