package org.encountermanager.encountermanager.view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;
import org.encountermanager.encountermanager.helper.PokemonData;
import org.encountermanager.encountermanager.viewModel.CreatePair;
import org.encountermanager.encountermanager.viewModel.TablePair;

import java.util.Optional;

public class AddPairDialog extends Dialog<ButtonType> {

    private GridPane gridPane = new GridPane();

    private TextField ownMon = new TextField();
    private Label ownMonError = new Label();

    private TextField partnerMon = new TextField();
    private Label partnerMonError = new Label();

    private TextField route = new TextField();
    private Label routeError = new Label();

    private ButtonType savePairButtonType = new ButtonType("Save Pair", ButtonBar.ButtonData.OK_DONE);

    private TablePair tablePair = new TablePair();
    private CreatePair createPair = new CreatePair();

    public AddPairDialog() {
        createView();
    }

    private void bindViewModel(CreatePair pairToCreate) {

        ownMon.textProperty().bindBidirectional(pairToCreate.ownMonNameProperty());

        partnerMon.textProperty().bindBidirectional(pairToCreate.partnerMonNameProperty());

        route.textProperty().bindBidirectional(pairToCreate.routeProperty());
    }

    private void unbindViewModel(CreatePair createPair) {
        ownMon.textProperty().unbindBidirectional(createPair.partnerMonNameProperty());

        partnerMon.textProperty().unbindBidirectional(createPair.partnerMonNameProperty());

        route.textProperty().unbindBidirectional(createPair.routeProperty());
    }

    public void createView() {
        this.getDialogPane().getButtonTypes().addAll(
            savePairButtonType,
            ButtonType.CANCEL
        );

        Button saveButton = (Button) this.getDialogPane()
                .lookupButton(savePairButtonType);

        saveButton.addEventFilter(ActionEvent.ACTION, event -> {
            if (!validate()) {
                event.consume();
            }
        });

        ownMonError.setStyle("-fx-text-fill: #e53935");
        partnerMonError.setStyle("-fx-text-fill: #e53935");
        routeError.setStyle("-fx-text-fill: #e53935");

        TextFields.bindAutoCompletion(ownMon, PokemonData.getPokemon());
        TextFields.bindAutoCompletion(partnerMon, PokemonData.getPokemon());

        VBox gpwrap = new VBox();
        gpwrap.setAlignment( Pos.CENTER );

        gridPane.setPadding( new Insets(40) );
        gridPane.setVgap( 4 );
        gridPane.add(new Label("Your Mon"), 0, 0);
        gridPane.add(ownMon, 1, 0);

        gridPane.add(ownMonError, 1, 1);

        gridPane.add(new Label("Partner Mon"), 0, 2);
        gridPane.add(partnerMon, 1, 2);

        gridPane.add(partnerMonError, 1, 3);

        gridPane.add(new Label("Route"), 0, 4);
        gridPane.add(route, 1, 4);

        gridPane.add(routeError, 1, 5);

        ColumnConstraints labelColumn = new ColumnConstraints();
        labelColumn.setPercentWidth(30);
        labelColumn.setHgrow(Priority.ALWAYS);

        ColumnConstraints fieldColumn = new ColumnConstraints();
        fieldColumn.setPercentWidth(70);
        fieldColumn.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(labelColumn, fieldColumn);

        gpwrap.getChildren().add( gridPane );

        VBox.setVgrow( gpwrap, Priority.ALWAYS );

        this.getDialogPane().setContent(gpwrap);
        this.setHeaderText("Add New Pair");
    }

    public void open(ActionEvent evt) {
        bindViewModel(createPair);

        Optional<ButtonType> result = this.showAndWait();

        if (result.isPresent() && result.get() == savePairButtonType) {
            tablePair.save(createPair);
        }

        unbindViewModel(createPair);
        createPair.reset();
        clearErrors();
    }

    private boolean validate() {
        boolean valid = true;

        if (!createPair.isValidMon(createPair.getOwnMonName())) {
            ownMonError.setText("Pokemon is not valid!");
            valid = false;
        } else if (createPair.isMonAssigned(createPair.getOwnMonName())) {
            ownMonError.setText("Pokemon is already assigned!");
            valid = false;
        } else {
            ownMonError.setText("");
        }

        if (!createPair.isValidMon(createPair.getPartnerMonName())) {
            partnerMonError.setText("Pokemon is not valid!");
            valid = false;
        } else if (createPair.isMonAssigned(createPair.getPartnerMonName())) {
            partnerMonError.setText("Pokemon is already assigned!");
            valid = false;
        } else {
            partnerMonError.setText("");
        }

        if (route.getText().isEmpty()) {
            routeError.setText("Route should not be empty!");
            valid = false;
        } else if (createPair.isRouteAssigned(route.getText())) {
            routeError.setText("Route has already been encountered!");
            valid = false;
        } else {
            routeError.setText("");
        }

        return valid;
    }

    private void clearErrors() {
        ownMonError.setText("");
        partnerMonError.setText("");
        routeError.setText("");
    }
}
