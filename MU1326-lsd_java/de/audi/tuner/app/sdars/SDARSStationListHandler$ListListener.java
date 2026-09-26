/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.CategoryFilterRow;
import de.audi.tuner.app.sdars.SDARSListRow;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.ifc.AbstractRadioListRow;
import java.util.Iterator;
import java.util.List;

class SDARSStationListHandler$ListListener
extends RadioBaseListModelListener {
    private final /* synthetic */ SDARSStationListHandler this$0;

    public SDARSStationListHandler$ListListener(SDARSStationListHandler sDARSStationListHandler, TunerModels tunerModels, int n) {
        this.this$0 = sDARSStationListHandler;
        super(tunerModels, n);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        switch (n) {
            case 100471: {
                if (SDARSStationListHandler.access$1000(this.this$0).isStoreModeActive()) {
                    SDARSStationListHandler.access$1000(this.this$0).store((AbstractRadioListRow)evoListRow);
                    SDARSStationListHandler.access$1100(this.this$0).fireEvent(n4);
                    return;
                }
                SDARSStationListHandler.access$1200(this.this$0).abortScan();
                if (!this.isNewSelection(evoListRow, n, n2, n3, n4)) break;
                StationInfoExt stationInfoExt = ((SDARSListRow)evoListRow).getStation();
                if (stationInfoExt.subscription != 2) {
                    if (SDARSStationListHandler.access$1300(this.this$0).isEntertainmentDrawerOpened()) {
                        return;
                    }
                    SDARSStationListHandler.access$1400(this.this$0).getLabelModel(411631872).setText(stationInfoExt.fullLabel);
                    SDARSStationListHandler.access$1300(this.this$0).getAdvisoryHandler().requestAdvisory(3);
                    break;
                }
                SDARSStationListHandler.access$1300(this.this$0).selectStation(stationInfoExt, n4);
                break;
            }
            case 100479: {
                int n5 = ((CategoryFilterRow)evoListRow).getCategory();
                List list = SDARSStationListHandler.access$1100(this.this$0).asList();
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    SDARSListRow sDARSListRow = (SDARSListRow)iterator.next();
                    StationInfoExt stationInfoExt = sDARSListRow.getStation();
                    if (stationInfoExt.categoryNumber != n5 || stationInfoExt.subscription != 2) continue;
                    SDARSStationListHandler.access$1300(this.this$0).selectStation(stationInfoExt, n4);
                    MenuModelApp menuModelApp = SDARSStationListHandler.access$1400(this.this$0).getMenuModel(-662175488);
                    menuModelApp.setFocusedItem(2005401856, FocusAdvice.VIEWPORT_FIRST_POSITION, sDARSListRow.getUniqueID());
                    this.this$0.focusSet = true;
                    SDARSStationListHandler.access$1400(this.this$0).getBaseListModel(2139619584).fireEvent(n4);
                    return;
                }
                break;
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        SDARSStationListHandler.access$1200(this.this$0).abortScan();
        if (SDARSStationListHandler.access$1100(this.this$0).getSelected().getIndex() != n2) {
            int n5 = ((SDARSListRow)evoListRow).getStation().getSubscription();
            if (n5 != 2) {
                SDARSStationListHandler.access$1300(this.this$0).getAdvisoryHandler().requestAdvisory(3);
            } else {
                StationInfoExt stationInfoExt = ((SDARSListRow)evoListRow).getStation();
                SDARSStationListHandler.access$1300(this.this$0).selectStation(stationInfoExt, n4);
            }
        }
        if (SDARSStationListHandler.access$1500(this.this$0) != null) {
            SDARSStationListHandler.access$1500(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
        }
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        StationInfoExt stationInfoExt = ((SDARSListRow)evoListRow).getStation();
        SDARSStationListHandler.access$1600(this.this$0, stationInfoExt.sID);
        boolean bl = SDARSStationListHandler.access$1800(this.this$0).isEPGAvailableFor(stationInfoExt, SDARSStationListHandler.access$1700(this.this$0));
        SDARSStationListHandler.access$1700(this.this$0).epgAvailibiltyChanged(stationInfoExt, bl);
    }
}

