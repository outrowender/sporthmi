/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiBrandResultScreenNoSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiBrandResultScreenNoSpellerModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiBrandResultScreenNoSpellerModelAccess {
    private TiledListModelApp previewListModel;

    public PoiBrandResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, int n, IconHandler iconHandler, IRouteManager iRouteManager, NavigationEnv navigationEnv2, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        super(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea);
        this.previewListModel = navigationEnv.getTiledListModel(n);
    }

    @Override
    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        int n = valueListStatus.getNumberOfAvailableItems();
        int n2 = valueListStatus.getDistance();
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#onUpdateSearchStatus(%1, %2)", (long)n, (long)n2);
        this.env.getChoiceModel(35456512).setValue(valueListStatus.getNumberOfAvailableItems());
        int n3 = valueListStatus.getStatus();
        if (n3 == 3) {
            this.env.getChoiceModel(-685767168).setValue(0);
        } else {
            this.env.getChoiceModel(-685767168).setValue(1);
        }
        this.previewListModel.setLength(valueListStatus.getNumberOfAvailableItems());
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getChoiceModel(35456512).setValue((int)l);
        this.previewListModel.setLength((int)l);
        this.logChannel.log(-2137614336, " PoiBrandResultScreenNoSpellerModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#onUpdateResultList - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n);
        try {
            EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
            this.previewListModel.setRows(-1, 0, evoListRowArray);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, exception.getMessage());
        }
    }

    protected EvoListRow[] createUpdateListRow(LIValueListElement[] lIValueListElementArray, PoiIconedResultsListRowBuilder poiIconedResultsListRowBuilder) {
        int n = this.poiSearchArea.getSearchContext();
        EvoListRow[] evoListRowArray = null;
        switch (n) {
            case 2: 
            case 3: 
            case 4: {
                evoListRowArray = new EvoListRow[lIValueListElementArray.length];
                for (int i2 = 0; i2 < lIValueListElementArray.length; ++i2) {
                    EvoListRow evoListRow;
                    LIValueListElement lIValueListElement = lIValueListElementArray[i2];
                    evoListRowArray[i2] = evoListRow = poiIconedResultsListRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex, this.poiSearchArea.getLocation());
                }
                break;
            }
            case 0: 
            case 1: 
            case 5: {
                evoListRowArray = new EvoListRow[lIValueListElementArray.length];
                for (int i3 = 0; i3 < lIValueListElementArray.length; ++i3) {
                    EvoListRow evoListRow;
                    LIValueListElement lIValueListElement = lIValueListElementArray[i3];
                    evoListRowArray[i3] = evoListRow = poiIconedResultsListRowBuilder.buildListRow(lIValueListElement, lIValueListElement.listIndex);
                }
                break;
            }
            default: {
                this.env.getPOILogChannel().log(1078071040, "PoiBrandResultScreenNoSpellerModelAccess#createUpdateListRow no valid searchContext : %1", (long)n);
            }
        }
        return evoListRowArray;
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#onElementSelected - selectedElement.data=%1", (Object)lIValueListElement.data);
        this.env.getLabelModel(958268928).setText(lIValueListElement.data);
    }

    @Override
    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(-2137614336, " PoiBrandResultScreenNoSpellerModelAccess#onUpdateResultListForRequest( %1, %2, %3, %4)", (Object)string, (Object)Long.toString(l), (Object)Integer.toString(n), (Object)Integer.toString(n2));
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#onUpdateResultListForRequest() - invalid value list: %1", (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.previewListModel.getLength();
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#onUpdateResultListForRequest - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n3);
        try {
            EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
            this.previewListModel.setRows(n, n2, evoListRowArray);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, exception.getMessage());
        }
    }

    @Override
    public void onUnrequestItems(int n, int n2) {
        this.previewListModel.clearRows(n, n2);
    }

    @Override
    public void onStart() {
        this.previewListModel.removeAll();
    }

    @Override
    public void prepareParentChild(int n) {
        this.logChannel.log(-2137614336, "PoiBrandResultScreenNoSpellerModelAccess#prepareParentChild(%1)", (long)n);
        this.env.getChoiceModel(538838528).setValue(n);
    }

    @Override
    public void onElementFocused(NavLocation navLocation) {
        String string = LocationFormatter.getPhoneNumber(navLocation);
        if (Util.isEmpty(string)) {
            this.env.getChoiceModel(-400554496).setValue(2);
        } else {
            this.env.getChoiceModel(-400554496).setValue(1);
        }
    }
}

