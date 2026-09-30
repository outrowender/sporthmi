/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.searcharea;

import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.modelaccess.IHistoryRowBuilder;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class PoiSearchAreaModelAccess
implements IPoiSearchAreaModelAccess {
    private static final int MAX_HISTORY_RESULTS = 3;
    private static final int CHOICE_ENABLED = 0;
    private static final int CHOICE_DISABLED = 1;
    private static final int SUBTITLE_DYNAMIC_OFFSET = 6;
    private static final int SUBTITLE_STATIC_OFFSET = 0;
    private final NavigationEnv env;
    private final CityHistory cityHistory;
    private final IHistoryRowBuilder listRowBuilder;
    private final ListModelApp historyListModelApp;
    private final LogChannel logChannel;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    static final int LOCATION_VICINITY = 0;
    static final int ALONG_ROUTE = 1;
    static final int DEST_VICINITY = 2;
    static final int STOP_OVER_VICINITY = 3;
    static final int COUNRTY_CITY_VICINITY = 4;

    public PoiSearchAreaModelAccess(NavigationEnv navigationEnv, CityHistory cityHistory, IHistoryRowBuilder iHistoryRowBuilder, ListListener listListener) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.cityHistory = cityHistory;
        this.listRowBuilder = iHistoryRowBuilder;
        this.historyListModelApp = navigationEnv.getListModel(400263);
        this.historyListModelApp.setMaxColumns(iHistoryRowBuilder.getColumnCount());
        this.historyListModelApp.setListListener(listListener);
    }

    public void onUpdateSearchArea(PoiSearchArea poiSearchArea, boolean bl, int n) {
        this.onUpdateSearchArea(poiSearchArea);
        this.setChoiceRouteActive(bl);
        this.setChoiceStopOverActive(bl, n);
        this.setChoiceDestinationActive(bl, n);
    }

    private void setChoiceRouteActive(boolean bl) {
        int n = bl ? 0 : 1;
        this.env.getChoiceModel(401301).setValue(n);
    }

    private void setChoiceStopOverActive(boolean bl, int n) {
        int n2 = bl && n > 1 ? 0 : 1;
        this.env.getChoiceModel(401303).setValue(n2);
    }

    private void setChoiceDestinationActive(boolean bl, int n) {
        int n2 = bl && n > 0 ? 0 : 1;
        this.env.getChoiceModel(401302).setValue(n2);
    }

    public void onUpdateSearchArea(PoiSearchArea poiSearchArea) {
        int n = 0;
        String string = null;
        NavLocation navLocation = poiSearchArea.getLocation();
        switch (poiSearchArea.getSearchContext()) {
            case 1: {
                n = 1;
                break;
            }
            case 4: {
                n = 4;
                string = this.getSearchAreaLabelString(navLocation);
                break;
            }
            case 5: {
                n = 4;
                string = this.getCountry(navLocation);
                break;
            }
            case 2: {
                n = 2;
                if (this.getCountry(navLocation) != null) {
                    string = this.getCountry(navLocation);
                }
                if (this.getSearchAreaLabelString(navLocation) == null) break;
                string = this.getSearchAreaLabelString(navLocation);
                break;
            }
            case 0: {
                n = 0;
                break;
            }
            case 3: {
                n = 3;
                if (this.getCountry(navLocation) != null) {
                    string = this.getCountry(navLocation);
                }
                if (this.getSearchAreaLabelString(navLocation) == null) break;
                string = this.getSearchAreaLabelString(navLocation);
                break;
            }
            default: {
                n = 0;
            }
        }
        if (string != null) {
            this.env.getLabelModel(401180).setText(string);
        }
        this.env.getChoiceModel(402577).setValue(n);
        int n2 = this.env.getChoiceModel(400960).getValue() == 0 ? 0 : 6;
        this.env.getChoiceModel(402724).setValue(n + n2);
    }

    private String getCountry(NavLocation navLocation) {
        if (navLocation != null) {
            return navLocation.getCountry();
        }
        return null;
    }

    private String getSearchAreaLabelString(NavLocation navLocation) {
        if (navLocation != null) {
            if (Util.isHURegionAsia()) {
                return AddressInputUtil.formatCompleteCityNameAsiaForPoiSearchAreaLabel(this.env, navLocation);
            }
            return navLocation.getTown();
        }
        return null;
    }

    public void onStart(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "%1#onStart - the given navLocation is null", (Object)this.CLASS_NAME);
            return;
        }
        String string = navLocation.getCountry();
        if (Util.isHURegionNAR()) {
            string = LocationFormatter.formatState(navLocation);
        }
        if (Util.isEmpty(string)) {
            string = LocationFormatter.formatCountry(navLocation);
        }
        this.env.getTextfieldModel(400278).setText1(string);
        this.onUpdateHistoryList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onUpdateHistoryList() {
        this.logChannel.log(10000000, "%1#updateHistoryList", (Object)this.CLASS_NAME);
        List list = this.cityHistory.getAllMatchingLastCities(false);
        this.logChannel.log(10000000, "%1#updateHistoryList - matching entries: %2", (Object)this.CLASS_NAME, (Object)list);
        int n = 0;
        if (list != null) {
            n = Math.min(list.size(), 3);
        }
        this.logChannel.log(10000000, "%1#updateHistoryList - previewLength: %2", (Object)this.CLASS_NAME, (long)n);
        this.historyListModelApp.beginTransaction();
        try {
            this.historyListModelApp.clear();
            for (int i2 = 0; i2 < n; ++i2) {
                CityHistory.HistoryEntry historyEntry = (CityHistory.HistoryEntry)list.get(i2);
                this.logChannel.log(10000000, "%1#updateHistoryList - entry: %2", (Object)this.CLASS_NAME, (Object)historyEntry);
                LICityHistoryEntry lICityHistoryEntry = (LICityHistoryEntry)historyEntry.getEntry();
                this.logChannel.log(10000000, "%1#updateHistoryList - lastCity: %2", (Object)this.CLASS_NAME, (Object)lICityHistoryEntry);
                this.historyListModelApp.addRow(this.listRowBuilder.buildListRow(lICityHistoryEntry));
            }
        }
        finally {
            this.logChannel.log(10000000, "%1#updateHistoryList - end transaction", (Object)this.CLASS_NAME);
            this.historyListModelApp.endTransaction();
        }
    }

    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "%1#updateHistoryList#onElementSelected the given navLocation is null", (Object)this.CLASS_NAME);
            return;
        }
    }
}

