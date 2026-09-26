/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.searcharea;

import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.CityHistory$HistoryEntry;
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
    private static final int MAX_HISTORY_RESULTS;
    private static final int CHOICE_ENABLED;
    private static final int CHOICE_DISABLED;
    private static final int SUBTITLE_DYNAMIC_OFFSET;
    private static final int SUBTITLE_STATIC_OFFSET;
    private final NavigationEnv env;
    private final CityHistory cityHistory;
    private final IHistoryRowBuilder listRowBuilder;
    private final ListModelApp historyListModelApp;
    private final LogChannel logChannel;
    private final String CLASS_NAME = Util.getClassNameFromPackageName(super.getClass());
    static final int LOCATION_VICINITY;
    static final int ALONG_ROUTE;
    static final int DEST_VICINITY;
    static final int STOP_OVER_VICINITY;
    static final int COUNRTY_CITY_VICINITY;

    public PoiSearchAreaModelAccess(NavigationEnv navigationEnv, CityHistory cityHistory, IHistoryRowBuilder iHistoryRowBuilder, ListListener listListener) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getPOILogChannel();
        this.cityHistory = cityHistory;
        this.listRowBuilder = iHistoryRowBuilder;
        this.historyListModelApp = navigationEnv.getListModel(-2028272128);
        this.historyListModelApp.setMaxColumns(iHistoryRowBuilder.getColumnCount());
        this.historyListModelApp.setListListener(listListener);
    }

    @Override
    public void onUpdateSearchArea(PoiSearchArea poiSearchArea, boolean bl, int n) {
        this.onUpdateSearchArea(poiSearchArea);
        this.setChoiceRouteActive(bl);
        this.setChoiceStopOverActive(bl, n);
        this.setChoiceDestinationActive(bl, n);
    }

    private void setChoiceRouteActive(boolean bl) {
        int n = bl ? 0 : 1;
        this.env.getChoiceModel(-1793128960).setValue(n);
    }

    private void setChoiceStopOverActive(boolean bl, int n) {
        int n2 = bl && n > 1 ? 0 : 1;
        this.env.getChoiceModel(-1759574528).setValue(n2);
    }

    private void setChoiceDestinationActive(boolean bl, int n) {
        int n2 = bl && n > 0 ? 0 : 1;
        this.env.getChoiceModel(-1776351744).setValue(n2);
    }

    @Override
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
            this.env.getLabelModel(471795200).setText(string);
        }
        this.env.getChoiceModel(-1859910144).setValue(n);
        int n2 = this.env.getChoiceModel(1075709440).getValue() == 0 ? 0 : 6;
        this.env.getChoiceModel(606406144).setValue(n + n2);
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

    @Override
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
        this.env.getTextfieldModel(-1776613888).setText1(string);
        this.onUpdateHistoryList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onUpdateHistoryList() {
        this.logChannel.log(-2137614336, "%1#updateHistoryList", (Object)this.CLASS_NAME);
        List list = this.cityHistory.getAllMatchingLastCities(false);
        this.logChannel.log(-2137614336, "%1#updateHistoryList - matching entries: %2", (Object)this.CLASS_NAME, (Object)list);
        int n = 0;
        if (list != null) {
            n = Math.min(list.size(), 3);
        }
        this.logChannel.log(-2137614336, "%1#updateHistoryList - previewLength: %2", (Object)this.CLASS_NAME, (long)n);
        this.historyListModelApp.beginTransaction();
        try {
            this.historyListModelApp.clear();
            for (int i2 = 0; i2 < n; ++i2) {
                CityHistory$HistoryEntry cityHistory$HistoryEntry = (CityHistory$HistoryEntry)list.get(i2);
                this.logChannel.log(-2137614336, "%1#updateHistoryList - entry: %2", (Object)this.CLASS_NAME, (Object)cityHistory$HistoryEntry);
                LICityHistoryEntry lICityHistoryEntry = (LICityHistoryEntry)cityHistory$HistoryEntry.getEntry();
                this.logChannel.log(-2137614336, "%1#updateHistoryList - lastCity: %2", (Object)this.CLASS_NAME, (Object)lICityHistoryEntry);
                this.historyListModelApp.addRow(this.listRowBuilder.buildListRow(lICityHistoryEntry));
            }
        }
        finally {
            this.logChannel.log(-2137614336, "%1#updateHistoryList - end transaction", (Object)this.CLASS_NAME);
            this.historyListModelApp.endTransaction();
        }
    }

    @Override
    public void onElementSelected(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "%1#updateHistoryList#onElementSelected the given navLocation is null", (Object)this.CLASS_NAME);
            return;
        }
    }
}

