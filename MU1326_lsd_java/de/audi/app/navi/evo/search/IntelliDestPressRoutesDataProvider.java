/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.search.AbstractNaviSearchDataProvider;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;
import org.osgi.framework.BundleContext;

public class IntelliDestPressRoutesDataProvider
extends AbstractNaviSearchDataProvider {
    private final NavigationEnv env;
    private NavRmRouteListData[] pressRoutes;

    public IntelliDestPressRoutesDataProvider(LogChannel logChannel, NavigationEnv navigationEnv, BundleContext bundleContext, int n) {
        super(logChannel, navigationEnv.getFramework(), bundleContext, n);
        this.env = navigationEnv;
    }

    protected DataSet[] getDataSet() {
        if (this.pressRoutes == null) {
            return new DataSet[0];
        }
        DataSet[] dataSetArray = new DataSet[this.pressRoutes.length];
        for (int i2 = 0; i2 < this.pressRoutes.length; ++i2) {
            dataSetArray[i2] = new DataSet(this.pressRoutes[i2].routeId, 21, 0, this.getSearchablesForRmRouteListData(this.pressRoutes[i2]));
        }
        return dataSetArray;
    }

    private Searchable[] getSearchablesForRmRouteListData(NavRmRouteListData navRmRouteListData) {
        if (navRmRouteListData != null) {
            return new Searchable[]{new Searchable(5, navRmRouteListData.name, 0)};
        }
        return new Searchable[0];
    }

    void updateRmRoutesPress() {
        this.pressRoutes = this.env.getContainer().getRmRoutesPress();
        this.invalidateData();
    }
}

