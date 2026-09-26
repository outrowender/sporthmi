/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.models;

import de.audi.app.navi.evo.addressinput.poi.PoiScreensEvo;
import de.audi.app.navi.evo.addressinput.poi.listbuilders.PoiIconedResultsListRowBuilder;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithMatchSpellerModelAccess;
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

public class PoiResultScreenWithMatchSpellerModelAccess
extends AbstractPoiScreenModelAccess
implements IPoiResultScreenWithMatchSpellerModelAccess {
    private final TiledListModelApp previewList;
    private final MatchspellerModelApp matchSpeller;

    public PoiResultScreenWithMatchSpellerModelAccess(NavigationEnv navigationEnv, int n, int n2, IconHandler iconHandler, IRouteManager iRouteManager, IVehicle iVehicle, PoiSearchArea poiSearchArea) {
        super(navigationEnv, iconHandler, iRouteManager, iVehicle, poiSearchArea);
        this.previewList = navigationEnv.getTiledListModel(n);
        this.matchSpeller = navigationEnv.getMatchSpellerModel(n2);
    }

    @Override
    public void onUpdateResultList(LIValueList lIValueList, long l, String string, boolean bl) {
        super.onUpdateResultList(lIValueList, l, string, bl);
        this.previewList.setLength((int)l);
        this.previewList.clearAll();
        this.logChannel.log(-2137614336, "%1#onUpdateResultList() - valueList: %2, matchCount = %3, currentInput: %4", (Object)this.CLASS_NAME, (Object)lIValueList, (Object)Long.toString(l), (Object)string);
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "%1#onUpdateResultList() - invalid value list: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
            this.previewList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n = this.previewList.getLength();
        this.logChannel.log(-2137614336, "%1#onUpdateResultList() - valueListSize: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)lIValueListElementArray.length, (long)n);
        EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
        this.previewList.setRows(-1, 0, evoListRowArray);
        if (l > 0L && l <= 0) {
            this.logChannel.log(-2137614336, "%1#onUpdateResultList automatically select first item when the amount of result list is less than 5", (Object)this.CLASS_NAME);
            int n2 = Util.isEmpty(string) ? 0 : 1;
            this.matchSpeller.setMatchCount((int)l, n2);
        }
    }

    @Override
    public void onUpdateSpeller(String string, String string2, boolean bl, boolean bl2) {
        this.logChannel.log(-2137614336, "%1#onUpdateSpeller - validCharacters=%2, currentInput=%3, isFullMatch=%4", (Object)this.CLASS_NAME, (Object)string, (Object)string2, (Object)Boolean.toString(bl));
        int n = bl2 ? 1 : 0;
        this.matchSpeller.setFullMatch(bl);
        this.matchSpeller.setText(string2);
        this.matchSpeller.setValidChars(string, n);
        Util.setModelStatus(this.matchSpeller, 1);
    }

    @Override
    public void onStart() {
        this.env.getChoiceModel(1344144896).setValue(1);
        this.previewList.removeAll();
        this.matchSpeller.clear();
    }

    @Override
    public void onUnrequestItems(int n, int n2) {
        this.previewList.clearRows(n, n2);
    }

    @Override
    public void onUpdateResultListForRequest(LIValueList lIValueList, long l, String string, boolean bl, int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateResultListForRequest( %1, %2, %3, %4)").toString(), (Object)string, (Object)Long.toString(l), (Object)Integer.toString(n), (Object)Integer.toString(n2));
        if (!Util.isListValid(lIValueList) || lIValueList.getList().length == 0) {
            this.logChannel.log(-2137614336, "%1#onUpdateResultListForRequest() - invalid value list: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
            this.previewList.removeAll();
            return;
        }
        LIValueListElement[] lIValueListElementArray = lIValueList.getList();
        int n3 = this.previewList.getLength();
        this.logChannel.log(-2137614336, "%1#onUpdateResultListForRequest() - valueListSize: %2, currentListModelLength: %3", (Object)this.CLASS_NAME, (long)lIValueListElementArray.length, (long)n3);
        EvoListRow[] evoListRowArray = this.createUpdateListRow(lIValueListElementArray, PoiScreensEvo.createPoiIconedResultsListRowBuilder(this.poiSearchArea, this.env, this.iconHandler, this.vehicle, this.routeManager));
        this.previewList.setRows(n, n2, evoListRowArray);
        if (l > 0L && l <= 0) {
            this.logChannel.log(-2137614336, "%1#onUpdateResultList automatically select first item when the amount of result list is less than 5", (Object)this.CLASS_NAME);
            int n4 = Util.isEmpty(string) ? 0 : 1;
            this.matchSpeller.setMatchCount((int)l, n4);
        }
    }

    @Override
    public void onElementSelected(LIValueListElement lIValueListElement) {
        this.logChannel.log(-2137614336, "%1#onElementSelected - selectedElement.data=%2", (Object)this.CLASS_NAME, (Object)lIValueListElement.data);
        this.env.getLabelModel(2098923008).setText(lIValueListElement.data);
    }

    private EvoListRow[] createUpdateListRow(LIValueListElement[] lIValueListElementArray, PoiIconedResultsListRowBuilder poiIconedResultsListRowBuilder) {
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
                this.env.getPOILogChannel().log(1078071040, "%1#createUpdateListRow no valid searchContext : %2", (Object)this.CLASS_NAME, (long)n);
            }
        }
        return evoListRowArray;
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

    @Override
    public void onUpdatePoiList(LIValueList lIValueList) {
        this.logChannel.log(-2137614336, "%1#onUpdatePoiList() - poiValueList: %2", (Object)this.CLASS_NAME, (Object)lIValueList);
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
    public void onUpdateSearchStatus(ValueListStatus valueListStatus) {
        int n = valueListStatus.getNumberOfAvailableItems();
        int n2 = valueListStatus.getDistance();
        this.logChannel.log(-2137614336, "%1#onUpdateSearchStatus(%2, %3)", (Object)this.CLASS_NAME, (long)n, (long)n2);
        this.env.getChoiceModel(35456512).setValue(n);
        this.previewList.setLength(n);
        int n3 = valueListStatus.getStatus();
        if (n3 == 3) {
            this.env.getChoiceModel(-685767168).setValue(0);
        } else {
            this.env.getChoiceModel(-685767168).setValue(1);
        }
    }

    @Override
    public void prepareParentChild(int n) {
        this.logChannel.log(-2137614336, "%1#prepareParentChild(%2)", (Object)this.CLASS_NAME, (long)n);
        this.env.getChoiceModel(538838528).setValue(n);
    }
}

