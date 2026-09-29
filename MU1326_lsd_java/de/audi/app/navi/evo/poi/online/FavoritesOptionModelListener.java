/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.AbstractOnlineSearchOptionModelListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class FavoritesOptionModelListener
extends AbstractOnlineSearchOptionModelListener {
    private final NaviFavoriteHandler favoriteHandler;

    public FavoritesOptionModelListener(LogChannel logChannel, NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IOnlineSearchForm iOnlineSearchForm, NaviFavoriteHandler naviFavoriteHandler) {
        super(logChannel, navigationEnv, onlineSearchSequence, iOnlineSearchForm);
        this.favoriteHandler = naviFavoriteHandler;
        navigationEnv.getHMIService().getOptionModel(1964901888).setListener(this, -367262208);
    }

    @Override
    public void keyPressed(int n, int n2, int n3, int n4, int n5) {
        NavLocation navLocation = this.sequence.getSearchContext().getResultList().getTransformedLocationAt(n3);
        if (n3 >= this.sequence.getSearchContext().getResultsLength()) {
            this.logChannel.log(-1601830656, "OnlineSearchFavoritesHandler#keyPressed: invalid index %1", (long)n3);
        } else if (navLocation == null) {
            this.logChannel.log(10000, "OnlineSearchFavoritesHandler#keyPressed: NavLocation is null, probably was not resolved");
        } else {
            PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = this.sequence.getSearchContext().getResultList().getPOIElementAt(n3);
            this.favoriteHandler.addToFavorites(navLocation, poiOnlineSearchValuelistElement.name);
            this.env.getHMIService().getOptionModel(n).fireEvent(n5);
        }
    }
}

