/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.tpegpoi.models;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.tpegpoi.AbstractTpegPOIModelAccess;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIResultListModelAccess;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class TpegPOIResultListScreenModelAccess
extends AbstractTpegPOIModelAccess
implements ITpegPOIResultListModelAccess {
    private TiledListModelApp resultList;
    private final IconHandler iconHandler;
    private final IVehicle vehicle;
    private final IRouteManager routeManager;

    public TpegPOIResultListScreenModelAccess(NavigationEnv navigationEnv, int n, IconHandler iconHandler, IVehicle iVehicle, IRouteManager iRouteManager) {
        super(navigationEnv);
        this.resultList = navigationEnv.getTiledListModel(n);
        this.iconHandler = iconHandler;
        this.vehicle = iVehicle;
        this.routeManager = iRouteManager;
    }

    @Override
    public void onStart() {
        this.resultList.removeAll();
    }

    @Override
    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.resultList.setLength((int)l);
        this.logChannel.log(-2137614336, "%1#onUpdateResultListForRequest() - requestID: %2, startIndex: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.logChannel.log(-2137614336, "%1#onUpdateResultListForRequest() - valueList: %2, matchCount: %3", (Object)this.CLASS_NAME, (Object)lIValueList, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "%1#updateResultList() - invalid value list: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
            this.resultList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.resultList.getLength();
        this.logChannel.log(-2137614336, "%1#onUpdateResultListForRequest() - valueListSize: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)lIValueListElementArray.length, (long)n3);
        EvoListRow[] evoListRowArray = this.createListRow(lIValueListElementArray, PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(this.iconHandler, this.routeManager, this.env, this.vehicle));
        this.resultList.setRows(n, n2, evoListRowArray);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.resultList.setLength((int)l);
        this.logChannel.log(-2137614336, "%1#updateResultList() - valueList: %2, matchCount: %3", (Object)this.CLASS_NAME, (Object)lIValueList, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "%1#updateResultList() - invalid value list: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
            this.resultList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.resultList.getLength();
        this.logChannel.log(-2137614336, "%1#updateResultList() - valueListSize: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)lIValueListElementArray.length, (long)n);
        EvoListRow[] evoListRowArray = this.createListRow(lIValueListElementArray, PoiIconedResultsListRowBuilder.createPoiIconedResultsListRowBuilderDistanceFromCCP(this.iconHandler, this.routeManager, this.env, this.vehicle));
        this.resultList.setRows(-1, 0, evoListRowArray);
    }

    private EvoListRow[] createListRow(LIValueListElement[] lIValueListElementArray, PoiIconedResultsListRowBuilder poiIconedResultsListRowBuilder) {
        EvoListRow[] evoListRowArray = new EvoListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            EvoListRow evoListRow;
            LIValueListElement lIValueListElement = lIValueListElementArray[i2];
            evoListRowArray[i2] = evoListRow = poiIconedResultsListRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
        }
        return evoListRowArray;
    }

    @Override
    public void onUnrequestItems(int n, int n2) {
        this.logChannel.log(-2137614336, "%1#unrequestItems() - startIndex: %2, length: %3", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.resultList.clearRows(n, n2);
    }
}

