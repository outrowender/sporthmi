/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.app.navi.evo.addressinput.RemoteHmiCityHistoryListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.addressinput.IAddressInputModelAccess;
import java.util.List;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public class AddressInputFormOnlineModelAccess
implements IAddressInputModelAccess {
    private static final int MAX_HISTORY_RESULTS = 3;
    private NavigationEnv env;
    private CityHistory cityHistory;
    private INavigationInputModeManager inputModeManager;
    private LogChannel logChannel;
    private final IAddressInputFormModelAccessHelper modelAccessHelper;
    private BaseListModelApp historyListModelApp;

    public AddressInputFormOnlineModelAccess(NavigationEnv navigationEnv, CityHistory cityHistory, int n, IAddressInputFormModelAccessHelper iAddressInputFormModelAccessHelper) {
        this.env = navigationEnv;
        this.inputModeManager = navigationEnv.getInputModeManager();
        this.cityHistory = cityHistory;
        this.logChannel = navigationEnv.getAddressInputLogChannel();
        this.historyListModelApp = navigationEnv.getBaseListModel(n);
        this.modelAccessHelper = iAddressInputFormModelAccessHelper;
    }

    public void onStart(NavLocation navLocation) {
        if (navLocation == null) {
            this.logChannel.log(10000, "AddressInputFormOnlineModelAccess#onElementSelected the given navLocation is null");
        }
        if (this.inputModeManager != null && (this.inputModeManager.getInputMode() == 6 || this.inputModeManager.getInputMode() == 4)) {
            if (this.cityHistory == null) {
                this.logChannel.log(100000, "AddressInputFormOnlineModelAccess#start() --> CityHoistory is NULL");
                return;
            }
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "AddressInputFormOnlineModelAccess#start() --> in online search area mode");
            }
            this.fillCityHistoryForOnline();
        } else {
            this.logChannel.log(100000000, "AddressInputFormOnlineModelAccess#start() --> no online searchArea mode");
        }
    }

    private void fillCityHistoryForOnline() {
        this.env.getLogChannel().log(10000000, "AddressInputFormOnlineModelAccess#fillCityHistoryForOnline");
        List list = this.cityHistory.getAllMatchingLastCities(false);
        this.env.getLogChannel().log(10000000, "AddressInputFormOnlineModelAccess#fillCityHistoryForOnline - matching entries: %1", (Object)list);
        int n = 0;
        if (list != null) {
            n = Math.min(list.size(), 3);
        }
        this.env.getLogChannel().log(10000000, "AddressInputFormOnlineModelAccess#fillCityHistoryForOnline - previewLength: %1", (long)n);
        this.historyListModelApp.clearAll();
        this.historyListModelApp.setLength(n);
        for (int i2 = 0; i2 < n; ++i2) {
            CityHistory.HistoryEntry historyEntry = (CityHistory.HistoryEntry)list.get(i2);
            this.env.getLogChannel().log(10000000, "AddressInputFormOnlineModelAccess#fillCityHistoryForOnline - entry: %1", (Object)historyEntry);
            LICityHistoryEntry lICityHistoryEntry = (LICityHistoryEntry)historyEntry.getEntry();
            this.env.getLogChannel().log(10000000, "AddressInputFormOnlineModelAccess#fillCityHistoryForOnline - lastCity: %2", (Object)lICityHistoryEntry);
            this.historyListModelApp.setRow(i2, new RemoteHmiCityHistoryListRow(lICityHistoryEntry));
        }
    }

    public void onUpdateLocation(NavLocation navLocation, Map map) {
        this.modelAccessHelper.onUpdateLocation(this.env, this.logChannel, navLocation, map);
    }
}

