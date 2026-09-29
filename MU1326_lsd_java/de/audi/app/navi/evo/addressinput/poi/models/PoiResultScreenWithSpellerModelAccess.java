/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.command.poi.CommandUtil;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;
import org.dsi.ifc.navigation.ValueListStatus;

public class PoiResultScreenWithSpellerModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiResultScreenWithSpellerModelAccess {
    private final TiledListModelApp previewList;
    private final SpellerModelApp spellerModel;
    private final IPreviewMap previewMapInterface;

    public PoiResultScreenWithSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea, int n, int n2, IPreviewMap iPreviewMap) {
        super(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea);
        this.previewMapInterface = iPreviewMap;
        this.previewList = navigationEnv.getTiledListModel(n);
        this.spellerModel = navigationEnv.getSpellerModel(n2);
        this.spellerModel.setMaxLength(128);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        super.onUpdateResultList(lIValueList, l, string, bl);
        this.previewList.clearAll();
        this.previewList.setLength((int)l);
        this.logChannel.log(-2137614336, " PoiResultScreenWithSpellerModelAccess#onUpdateResultList( %1, %2)", (Object)string, l);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onUpdateResultList() - invalid value list: %1", (Object)lIValueList);
            this.previewList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.previewList.getLength();
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onUpdateResultList - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n);
        EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
        this.previewList.setRows(-1, 0, evoListRowArray);
    }

    @Override
    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        int n = valueListStatus.getStatus();
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.env.getChoiceModel(-685767168));
        modelGroup.add(this.env.getChoiceModel(35456512));
        if (n == 3) {
            this.env.getChoiceModel(-685767168).setValue(0);
        } else {
            this.env.getChoiceModel(-685767168).setValue(1);
        }
        this.env.getChoiceModel(35456512).setValue(valueListStatus.getNumberOfAvailableItems());
        this.previewList.setLength(valueListStatus.getNumberOfAvailableItems());
        if (valueListStatus.status == 1 || valueListStatus.status == 3 && valueListStatus.numberOfAvailableItems == 0) {
            this.previewMapInterface.hidePreviewMap();
        }
        modelGroup.flush();
        modelGroup.removeAll();
    }

    @Override
    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(-2137614336, " PoiResultScreenWithSpellerModelAccess#onUpdateResultListForRequest( %1, %2, %3, %4)", (Object)string, (Object)Long.toString(l), (Object)Integer.toString(n), (Object)Integer.toString(n2));
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onUpdateResultListForRequest() - invalid value list: %1", (Object)lIValueList);
            this.previewList.clearAll();
            if (n > -1) {
                this.previewList.setRows(n, n2, null);
            }
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.previewList.getLength();
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onUpdateResultListForRequest - valueListSize: %1, currentListModelLength: %2", (long)lIValueListElementArray.length, (long)n3);
        EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
        this.previewList.setRows(n, n2, evoListRowArray);
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
                this.env.getPOILogChannel().log(1078071040, "PoiResultScreenNoSpellerModelAccess#createUpdateListRow no valid searchContext : %1", (long)n);
            }
        }
        return evoListRowArray;
    }

    @Override
    public void onUnrequestItems(int n, int n2) {
        this.previewList.clearRows(n, n2);
    }

    @Override
    public void onStart() {
        this.env.getChoiceModel(1344144896).setValue(0);
        this.spellerModel.clear();
        this.previewList.removeAll();
    }

    @Override
    public void prepareParentChild(int n) {
        this.env.getLogChannel().log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onElementSelected(%1)", (long)n);
        this.env.getChoiceModel(538838528).setValue(n);
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onElementSelected - selectedElement.data=%1", (Object)lIValueListElement.data);
    }

    @Override
    public void onUpdatePoiList(LIValueList lIValueList) {
        this.logChannel.log(-2137614336, "PoiResultScreenWithSpellerModelAccess#onUpdatePoiList() - poiValueList: %1", (Object)lIValueList);
        boolean bl = false;
        boolean bl2 = false;
        String string = "";
        if (lIValueList != null && lIValueList.getList() != null) {
            LIValueListElement[] lIValueListElementArray;
            int n = CommandUtil.getIndexForCriteria(11, lIValueList);
            if (n >= 0) {
                bl2 = true;
                lIValueListElementArray = lIValueList.getList();
                string = lIValueListElementArray[n].data;
            }
            if ((n = CommandUtil.getIndexForCriteria(13, lIValueList)) >= 0) {
                bl = true;
                lIValueListElementArray = lIValueList.getList();
                string = lIValueListElementArray[n].data;
            }
            if (bl || bl2) {
                this.env.getChoiceModel(-1558510080).setValue(1);
                this.env.getLabelModel(975046144).setText(string);
            } else {
                this.env.getChoiceModel(-1558510080).setValue(0);
            }
        }
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

