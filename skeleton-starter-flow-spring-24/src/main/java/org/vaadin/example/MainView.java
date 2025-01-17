package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) {

        HorizontalLayout entradas = new HorizontalLayout();
        VerticalLayout resultados = new VerticalLayout();




        ComboBox<String> miComboBox = new ComboBox<>("Browser");
        miComboBox.setAllowCustomValue(false);
        miComboBox.setItems("people", "planets", "starships");
        miComboBox.setHelperText("Selecciona el tipo de petición");

        Grid<CaracterSW> grid = new Grid<>(CaracterSW.class, false);
        grid.setWidth("1000px");
        grid.setHeight("1000px");

        grid.addColumn(CaracterSW::getName).setHeader("NOMBRE").setFlexGrow(1);;
        grid.addColumn(CaracterSW::getHeight).setHeader("ALTURA").setFlexGrow(1);;
        grid.addColumn(CaracterSW::getMass).setHeader("PESO").setFlexGrow(1);;
        grid.addColumn(CaracterSW::getHair_color).setHeader("COLOR DE PELO").setFlexGrow(1);;
        grid.addColumn(CaracterSW::getEye_color).setHeader("COLOR DE OJOS").setFlexGrow(1);;


        // Use TextField for standard text input
        TextField pideTipo = new TextField("Tipo de consulta");
        pideTipo.addClassName("bordered");

        TextField pideIDe = new TextField("Id de sonsulta");
        pideTipo.addClassName("bordered");

        entradas.add(miComboBox, pideIDe);

        // Añade un evento al boton.
        Button boton1 = new Button("Mostrar uno", e -> {
            String tipo = miComboBox.getValue();
            int id = Integer.parseInt(pideIDe.getValue());
            try {
                resultados.removeAll();
                resultados.add(service.getSWAPI(tipo, id));
            }catch(Exception ex) {System.out.println(ex);}

        });

        Button boton2 = new Button("Mostrar todos", e -> {
            String tipo = miComboBox.getValue();
            try {
                resultados.removeAll();
                grid.setItems(service.getCaracterSWList(tipo));
                resultados.add(grid);
            }catch(Exception ex) {System.out.println(ex);}

        });

        //Da estilo al boton
        boton1.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        //Asocia el boton con la tecla enter.
        boton1.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in
        // styles.css.

        add(entradas, boton1, boton2, resultados);
    }
}
