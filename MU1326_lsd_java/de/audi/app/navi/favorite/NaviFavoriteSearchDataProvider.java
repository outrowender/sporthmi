/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.search.AbstractNaviSearchDataProvider;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;
import org.osgi.framework.BundleContext;

public class NaviFavoriteSearchDataProvider
extends AbstractNaviSearchDataProvider {
    private final BaseListModelApp favoritesListModel;

    public NaviFavoriteSearchDataProvider(LogChannel logChannel, IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, int n, BaseListModelApp baseListModelApp) {
        super(logChannel, iFrameworkAccess, bundleContext, n);
        this.favoritesListModel = baseListModelApp;
    }

    @Override
    protected DataSet[] getDataSet() {
        List list = this.favoritesListModel.asList();
        Iterator iterator = this.favoritesListModel.asList().iterator();
        DataSet[] dataSetArray = new DataSet[list.size()];
        int n = 0;
        while (iterator.hasNext()) {
            NaviFavoriteEvoRow naviFavoriteEvoRow = (NaviFavoriteEvoRow)iterator.next();
            dataSetArray[n++] = new DataSet(naviFavoriteEvoRow.getUniqueID(), 0, 0, this.getSearchablesForFavorite(naviFavoriteEvoRow));
        }
        return dataSetArray;
    }

    private Searchable[] getSearchablesForFavorite(NaviFavoriteEvoRow naviFavoriteEvoRow) {
        if (naviFavoriteEvoRow != null) {
            return new Searchable[]{new Searchable(5, naviFavoriteEvoRow.getFavoriteName(), 0), new Searchable(7, naviFavoriteEvoRow.getHouseNumber(), 0), new Searchable(3, naviFavoriteEvoRow.getStreet(), 0), new Searchable(1, naviFavoriteEvoRow.getCity(), 0), new Searchable(2, naviFavoriteEvoRow.getDistrict(), 0), new Searchable(6, naviFavoriteEvoRow.getState(), 0), new Searchable(4, naviFavoriteEvoRow.getPostCode(), 0), new Searchable(17, naviFavoriteEvoRow.getCountryAbbreviation(), 0), new Searchable(18, String.valueOf(naviFavoriteEvoRow.getLatitude()), 0), new Searchable(19, String.valueOf(naviFavoriteEvoRow.getLongitude()), 0)};
        }
        return new Searchable[0];
    }
}

