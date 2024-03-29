package pl.bykowski.springbootcoffeeclient;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
public class HelloGui extends VerticalLayout {

    private Label label;
    private TextField textField;
    private Button thumbsUpButton;

    public HelloGui() {
        label = new Label();
        textField = new TextField();
        textField.setLabel("Give U name");
        thumbsUpButton = new Button(new Icon(VaadinIcon.DOCTOR_BRIEFCASE));

        thumbsUpButton.addClickListener(
                clickEvent-> label.setText("Hello " + textField.getValue()));

        add(textField);
        add(thumbsUpButton);
        add(label);
    }
}
