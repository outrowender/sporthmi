/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.favorites.IFavoriteActionHandler;

public class FavoritesActionListener {
    private final IFavoriteActionHandler handler;
    public final FavoriteMoveModeListener favoriteMoveModeListener;
    private final ChoiceModelApp favoriteMoveModeChoice;
    private final BaseListModelApp favoritesList;

    public FavoritesActionListener(TVEnv tVEnv, IFavoriteActionHandler iFavoriteActionHandler, int n) {
        this.handler = iFavoriteActionHandler;
        this.favoritesList = tVEnv.getBaseListModel(n);
        OptionListener optionListener = new OptionListener();
        tVEnv.getOptionModel(2600039).setListener(optionListener, n);
        tVEnv.getOptionModel(2600039).setCustomIDListener(optionListener, 2);
        ButtonListener buttonListener = new ButtonListener();
        tVEnv.getButtonModel(2600038).setButtonListener(buttonListener);
        this.favoriteMoveModeChoice = tVEnv.getChoiceModel(2600159);
        this.favoriteMoveModeListener = new FavoriteMoveModeListener();
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            if (n == 2600038) {
                FavoritesActionListener.this.handler.handleDeleteAllFavorites();
            }
        }
    }

    private class OptionListener
    extends DefaultOptionListener {
        private OptionListener() {
        }

        public void keyTyped(int n, int n2, int n3, int n4, int n5) {
            if (n4 == 2) {
                SelectedItem selectedItem = FavoritesActionListener.this.favoritesList.getSelected();
                if (selectedItem != null) {
                    FavoritesActionListener.this.handler.handleDeleteFavorite(selectedItem.getIndex());
                }
            } else if (n == 2600039) {
                FavoritesActionListener.this.handler.handleDeleteFavorite(n3);
            }
        }
    }

    public class FavoriteMoveModeListener {
        private FavoriteMoveModeListener() {
            FavoritesActionListener.this.favoriteMoveModeChoice.setValue(0);
        }

        public void enterMoveMode() {
            FavoritesActionListener.this.favoriteMoveModeChoice.setValue(1);
        }

        public void leaveMoveMode() {
            FavoritesActionListener.this.favoriteMoveModeChoice.setValue(0);
        }
    }
}

