/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenNoSpellerModelAccess;
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

public class PoiResultScreenNoSpellerModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiResultScreenNoSpellerModelAccess {
    protected final BaseListModelApp previewListModel;

    public PoiResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, int n) {
        super(navigationEnv);
        this.previewListModel = navigationEnv.getBaseListModel(n);
    }

    public PoiResultScreenNoSpellerModelAccess(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea, int n) {
        super(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea);
        this.previewListModel = navigationEnv.getBaseListModel(n);
    }

    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        int n = valueListStatus.getNumberOfAvailableItems();
        int n2 = valueListStatus.getDistance();
        this.logChannel.log(10000000, "%1#onUpdateSearchStatus(%2, %3)", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.env.getChoiceModel(400642).setValue(n);
        this.previewListModel.setLength(n);
        int n3 = valueListStatus.getStatus();
        if (n3 == 3) {
            this.env.getChoiceModel(401623).setValue(0);
        } else {
            this.env.getChoiceModel(401623).setValue(1);
        }
    }

    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        this.env.getChoiceModel(400642).setValue((int)l);
        this.previewListModel.setLength((int)l);
        this.logChannel.log(10000000, "%1#onUpdateResultList() - valueList: %2, currentInput: %3", (Object)this.CLASS_NAME, (Object)lIValueList, (Object)string);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(10000000, "%1#onUpdateResultList() - invalid value list: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.previewListModel.getLength();
        this.logChannel.log(10000000, "%1#onUpdateResultList() - valueListSize: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)lIValueListElementArray.length, (long)n);
        EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
        this.previewListModel.setRows(-1, 0, evoListRowArray);
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
                this.env.getPOILogChannel().log(1000000, "%1#createUpdateListRow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return evoListRowArray;
    }

    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.logChannel.log(10000000, "%1#onElementSelected - selectedElement.data=%2", (Object)this.CLASS_NAME, (Object)lIValueListElement.data);
        if (this.env.getChoiceModel(400960).getValue() == 1) {
            this.env.getLabelModel(402582).setText(lIValueListElement.data);
        }
    }

    public void onUpdatePoiList(LIValueList lIValueList) {
        this.logChannel.log(10000000, "%1#onUpdatePoiList() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
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
            if ((n = CommandUtil.getIndexForCriteria(3, lIValueList)) >= 0) {
                bl3 = true;
                lIValueListElementArray = lIValueList.getList();
                string = lIValueListElementArray[n].data;
            }
            if (bl || bl2 || bl3) {
                this.env.getChoiceModel(400291).setValue(1);
                this.env.getLabelModel(400954).setText(string);
            } else {
                this.env.getChoiceModel(400291).setValue(0);
            }
        }
    }

    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onUpdateResultListForRequest( %1, %2, %3, %4)", (Object)string, (Object)Long.toString(l), (Object)Integer.toString(n), (Object)Integer.toString(n2));
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(10000000, "%1#onUpdateResultListForRequest() - invalid value list: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
            this.previewListModel.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.previewListModel.getLength();
        this.logChannel.log(10000000, "%1#onUpdateResultListForRequest() - valueListSize: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)lIValueListElementArray.length, (long)n3);
        EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
        this.previewListModel.setRows(n, n2, evoListRowArray);
    }

    public void onUnrequestItems(int n, int n2) {
        this.previewListModel.clearRows(n, n2);
    }

    public void onStart() {
        this.previewListModel.removeAll();
    }

    public void prepareParentChild(int n) {
        this.logChannel.log(10000000, "%1#prepareParentChild(%2)", (Object)this.CLASS_NAME, (long)n);
        this.env.getChoiceModel(400928).setValue(n);
    }

    public void onElementFocused(NavLocation navLocation) {
        String string = LocationFormatter.getPhoneNumber(navLocation);
        if (Util.isEmpty(string)) {
            this.env.getChoiceModel(401640).setValue(2);
        } else {
            this.env.getChoiceModel(401640).setValue(1);
        }
    }
}

