/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists.favorites;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$ButtonListener;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$FavoriteMoveModeListener;
import de.audi.tv.app.lists.favorites.FavoritesActionListener$OptionListener;
import de.audi.tv.app.lists.favorites.IFavoriteActionHandler;

public class FavoritesActionListener {
    private final IFavoriteActionHandler handler;
    public final FavoritesActionListener$FavoriteMoveModeListener favoriteMoveModeListener;
    private final ChoiceModelApp favoriteMoveModeChoice;
    private final BaseListModelApp favoritesList;

    public FavoritesActionListener(TVEnv tVEnv, IFavoriteActionHandler iFavoriteActionHandler, int n) {
        this.handler = iFavoriteActionHandler;
        this.favoritesList = tVEnv.getBaseListModel(n);
        FavoritesActionListener$OptionListener favoritesActionListener$OptionListener = new FavoritesActionListener$OptionListener(this, null);
        tVEnv.getOptionModel(1739335424).setListener(favoritesActionListener$OptionListener, n);
        tVEnv.getOptionModel(1739335424).setCustomIDListener(favoritesActionListener$OptionListener, 2);
        FavoritesActionListener$ButtonListener favoritesActionListener$ButtonListener = new FavoritesActionListener$ButtonListener(this, null);
        tVEnv.getButtonModel(1722558208).setButtonListener(favoritesActionListener$ButtonListener);
        this.favoriteMoveModeChoice = tVEnv.getChoiceModel(-542365952);
        this.favoriteMoveModeListener = new FavoritesActionListener$FavoriteMoveModeListener(this, null);
    }

    static /* synthetic */ BaseListModelApp access$300(FavoritesActionListener favoritesActionListener) {
        return favoritesActionListener.favoritesList;
    }

    static /* synthetic */ IFavoriteActionHandler access$400(FavoritesActionListener favoritesActionListener) {
        return favoritesActionListener.handler;
    }

    static /* synthetic */ ChoiceModelApp access$500(FavoritesActionListener favoritesActionListener) {
        return favoritesActionListener.favoriteMoveModeChoice;
    }
}

