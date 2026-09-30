/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.AbstractTelSearchDataProvider;
import de.audi.app.phone.evo.favorite.TelEvoFavoriteListRow;
import de.audi.app.phone.evo.favorite.TelFavoriteListHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;

public class TelFavoriteSearchDataProvider
extends AbstractTelSearchDataProvider {
    private volatile TelFavoriteListHandler activeListHandler;

    public TelFavoriteSearchDataProvider(ITelApplication iTelApplication) {
        super(iTelApplication, 18);
    }

    private Searchable[] getSearchablesForFavorite(TelEvoFavoriteListRow telEvoFavoriteListRow) {
        if (telEvoFavoriteListRow != null) {
            return new Searchable[]{TelFavoriteSearchDataProvider.getSearchable(5, telEvoFavoriteListRow.getName(), this.getTokenPostProcessingMethod()), TelFavoriteSearchDataProvider.getSearchable(11, telEvoFavoriteListRow.getNumber(), this.getTokenPostProcessingMethod()), TelFavoriteSearchDataProvider.getSearchable(22, String.valueOf(telEvoFavoriteListRow.getPhoneNumberType()), this.getTokenPostProcessingMethod())};
        }
        return new Searchable[0];
    }

    public void setActiveListHandler(TelFavoriteListHandler telFavoriteListHandler) {
        this.activeListHandler = telFavoriteListHandler;
    }

    protected DataSet[] getDataSet() {
        TelFavoriteListHandler telFavoriteListHandler = this.activeListHandler;
        if (telFavoriteListHandler != null) {
            BaseListModelApp baseListModelApp = telFavoriteListHandler.getListModelCopy();
            List list = baseListModelApp.asList();
            Iterator iterator = list.iterator();
            DataSet[] dataSetArray = new DataSet[list.size()];
            int n = 0;
            while (iterator.hasNext()) {
                TelEvoFavoriteListRow telEvoFavoriteListRow = (TelEvoFavoriteListRow)iterator.next();
                dataSetArray[n++] = new DataSet(telEvoFavoriteListRow.getUniqueID(), 0, 0, this.getSearchablesForFavorite(telEvoFavoriteListRow));
            }
            return dataSetArray;
        }
        return new DataSet[0];
    }
}

