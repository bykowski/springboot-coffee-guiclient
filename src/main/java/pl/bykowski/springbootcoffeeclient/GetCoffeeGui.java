package pl.bykowski.springbootcoffeeclient;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Route
public class GetCoffeeGui extends VerticalLayout {

    private CoffeeClient coffeeClient;

    @Autowired
    public GetCoffeeGui(CoffeeClient coffeeClient) {
        this.coffeeClient = coffeeClient;

        Label label = new Label();
        Button button = new Button("Show All!");
        button.addClickListener(
                clickEvent -> label.setText(Arrays.toString(coffeeClient.getCoffes())));
        add(label);
        add(button);
    }


}
