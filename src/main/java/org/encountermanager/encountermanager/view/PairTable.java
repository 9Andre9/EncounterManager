package org.encountermanager.encountermanager.view;

import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.encountermanager.encountermanager.helper.PokemonSpriteManager;
import org.encountermanager.encountermanager.view.util.ComboBoxWithStyledLabel;
import org.encountermanager.encountermanager.viewModel.TablePair;

public class PairTable extends TableView<TablePair> {

    private TablePair tablePair = new TablePair();

    private FilteredList<TablePair> filteredPairs = tablePair.getFilteredPairs();
    private PokemonSpriteManager spriteManager = new PokemonSpriteManager();

    public PairTable() {
        createView();
    }

    public void createView() {
        this.setItems(filteredPairs);

        TableColumn<TablePair, String> ownMonCol = new TableColumn<>("Your Mon");
        ownMonCol.setCellValueFactory(cellData -> cellData.getValue().ownMonNameProperty());

        TableColumn<TablePair, String> ownMonSpriteCol = new TableColumn<>("");
        ownMonSpriteCol.setCellValueFactory(
                cellData -> cellData.getValue().ownMonNameProperty()
        );
        setupSpriteCol(ownMonSpriteCol);

        TableColumn<TablePair, String> partnerMonCol = new TableColumn<>("Partner Mon");
        partnerMonCol.setCellValueFactory(cellData -> cellData.getValue().partnerMonNameProperty());

        TableColumn<TablePair, String> partnerMonSpriteCol = new TableColumn<>("");
        partnerMonSpriteCol.setCellValueFactory(
                cellData -> cellData.getValue().partnerMonNameProperty()
        );
        setupSpriteCol(partnerMonSpriteCol);

        TableColumn<TablePair, String> routeCol = new TableColumn<>("Route");
        routeCol.setCellValueFactory(cellData -> cellData.getValue().routeProperty());

        var deceasedCol = setupDeceasedCol();

        this.getColumns().setAll(ownMonCol, ownMonSpriteCol, partnerMonCol, partnerMonSpriteCol, routeCol, deceasedCol);

        this.setEditable(true);
    }

    private TableColumn<TablePair, String> setupDeceasedCol() {
        TableColumn<TablePair, String> killedByCol = new TableColumn<>("Pair Killed By");
        killedByCol.setCellValueFactory(
                cellData -> cellData.getValue().killedByProperty()
        );


        killedByCol.setCellFactory(p -> new ComboBoxWithStyledLabel<>("Alive", "You", "Partner"));

        killedByCol.setEditable(true);

        return killedByCol;
    }

    private void setupSpriteCol(TableColumn<TablePair, String> spriteColumn) {
        spriteColumn.setCellFactory(column -> new TableCell<>() {

            private final ImageView imageView = new ImageView();

            {
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                imageView.setPreserveRatio(true);
                setAlignment(Pos.CENTER);
            }

            @Override
            protected void updateItem(String pokemonName, boolean empty) {
                super.updateItem(pokemonName, empty);

                if (empty || pokemonName == null) {
                    setGraphic(null);
                    return;
                }

                String spritePath = spriteManager.getSpritePath(pokemonName);

                if (spritePath != null) {
                    Image image = new Image(
                            getClass().getResourceAsStream(spritePath)
                    );

                    imageView.setImage(image);
                    setGraphic(imageView);
                } else {
                    setGraphic(null);
                }
            }
        });
    }

    public void clear(ActionEvent event) {
        tablePair.clearEncounter();
    }

    public FilteredList<TablePair> getFilteredState() {
        return filteredPairs;
    }
}
