/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParkingNearDestinationScreenModelAccess;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiParkingNearDestinationScreenModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiParkingNearDestinationScreenModelAccess {
    private final TiledListModelApp previewListModel;
    private final SpellerModelApp spellerModelApp;
    private final PoiIconedResultsListRowBuilder poiIconedResultListRowBuilder;
    private NavLocation navLocation;

    public PoiParkingNearDestinationScreenModelAccess(NavigationEnv navigationEnv, int n, PoiIconedResultsListRowBuilder poiIconedResultsListRowBuilder, int n2) {
        super(navigationEnv);
        this.poiIconedResultListRowBuilder = poiIconedResultsListRowBuilder;
        this.previewListModel = navigationEnv.getTiledListModel(n);
        this.spellerModelApp = navigationEnv.getSpellerModel(n2);
    }

    @Override
    public void updateNavLocationForAirDistance(NavLocation navLocation) {
        this.navLocation = navLocation;
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getChoiceModel(35456512).setValue((int)l);
        this.previewListModel.setLength((int)l);
        this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateResultList() - valueList: %1, currentInput: %2", (Object)lIValueList, (Object)string);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateResultList() - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n);
        try {
            EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray);
            this.previewListModel.setRows(-1, 0, evoListRowArray);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, exception.getMessage());
        }
    }

    @Override
    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(-2137614336, " PoiParkingNearDestinationScreenModelAccess#onUpdateResultListForRequest( %1, %2, %3, %4)", (Object)string, (Object)Long.toString(l), (Object)Integer.toString(n), (Object)Integer.toString(n2));
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateResultListForRequest() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.clearAll();
            if (n > -1) {
                this.previewListModel.setRows(n, n2, null);
            }
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateResultListForRequest - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n3);
        try {
            EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray);
            this.previewListModel.setRows(n, n2, evoListRowArray);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "PoiParkingNearDestinationScreenModelAccess#onUpdateResultListForRequest - filling preview list failed with exception=%1", (Object)exception.getMessage());
        }
    }

    private EvoListRow[] createUpdateListRow(LIValueListElement[] lIValueListElementArray) {
        EvoListRow[] evoListRowArray = new EvoListRow[lIValueListElementArray.length];
        for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
            LIValueListElement lIValueListElement = lIValueListElementArray[i2];
            EvoListRow evoListRow = this.navLocation != null ? this.poiIconedResultListRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex, this.navLocation) : this.poiIconedResultListRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
            evoListRowArray[i2] = evoListRow;
        }
        return evoListRowArray;
    }

    @Override
    public void onUnrequestItems(int n, int n2) {
        this.previewListModel.clearRows(n, n2);
    }

    @Override
    public void onStart() {
        this.previewListModel.removeAll();
        this.spellerModelApp.clear();
    }

    @Override
    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        int n = valueListStatus.getNumberOfAvailableItems();
        int n2 = valueListStatus.getDistance();
        this.env.getChoiceModel(35456512).setValue(n);
        this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateSearchStatus(%1)", (long)n);
        this.previewListModel.setLength(n);
        this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateSearchStatus(%1, %2)", (long)n, (long)n2);
        if (n > 0) {
            this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateSearchStatusm, setting DEST_POI_DEST_PARKING_AVAILABLE_CHOICE to one");
            this.env.getChoiceModel(-1323366912).setValue(1);
        } else if (n == 0) {
            this.logChannel.log(-2137614336, "PoiParkingNearDestinationScreenModelAccess#onUpdateSearchStatusm, setting DEST_POI_DEST_PARKING_AVAILABLE_CHOICE to zero");
            this.env.getChoiceModel(-1323366912).setValue(0);
        }
        int n3 = valueListStatus.getStatus();
        if (n3 == 3) {
            this.env.getChoiceModel(-685767168).setValue(0);
        } else {
            this.env.getChoiceModel(-685767168).setValue(1);
        }
    }
}

