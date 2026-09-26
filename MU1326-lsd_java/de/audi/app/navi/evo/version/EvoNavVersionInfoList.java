/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.app.navi.evo.version.EvoNavVersionInfoList$EvoNavVersionInfo;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public class EvoNavVersionInfoList {
    private static final int SUBREGION_VERSION_START_CN;
    private static final int SUBREGION_VERSION_START;
    private static final int COL_ID;
    private static final int COL_NAME;
    private static final int COL_VERSION;
    private static final int COL_READONLY;
    private static final int COL_COUNT;
    private ArrayList versionInfoList;
    private boolean showNavDbSubmenuButton = false;

    public EvoNavVersionInfoList(String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            int n;
            int n2 = n = Util.isHURegionCN() ? 8 : 5;
            if (stringArray.length > n + 1) {
                this.showNavDbSubmenuButton = true;
                this.versionInfoList = new ArrayList((stringArray.length - 5) / 2);
                for (int i2 = n; i2 < stringArray.length && i2 + 1 != stringArray.length; i2 += 2) {
                    this.versionInfoList.add(new EvoNavVersionInfoList$EvoNavVersionInfo(this, stringArray[i2], stringArray[i2 + 1], i2));
                }
            }
            Collections.sort(this.versionInfoList);
        } else {
            this.versionInfoList = new ArrayList(0);
        }
    }

    boolean showNavDbSubmenuButton() {
        return this.showNavDbSubmenuButton;
    }

    boolean isEmpty() {
        return this.versionInfoList.size() == 0;
    }

    BaseListModelApp fillBaseListModel(BaseListModelApp baseListModelApp) {
        if (baseListModelApp != null) {
            for (int i2 = 0; i2 < this.versionInfoList.size(); ++i2) {
                baseListModelApp.append(((EvoNavVersionInfoList$EvoNavVersionInfo)this.versionInfoList.get(i2)).getRow(i2));
            }
        }
        return baseListModelApp;
    }
}

