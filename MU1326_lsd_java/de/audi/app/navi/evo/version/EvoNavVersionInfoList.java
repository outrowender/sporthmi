/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public class EvoNavVersionInfoList {
    private static final int SUBREGION_VERSION_START_CN = 8;
    private static final int SUBREGION_VERSION_START = 5;
    private static final int COL_ID = 0;
    private static final int COL_NAME = 1;
    private static final int COL_VERSION = 2;
    private static final int COL_READONLY = 4;
    private static final int COL_COUNT = 5;
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
                    this.versionInfoList.add(new EvoNavVersionInfo(stringArray[i2], stringArray[i2 + 1], i2));
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
                baseListModelApp.append(((EvoNavVersionInfo)this.versionInfoList.get(i2)).getRow(i2));
            }
        }
        return baseListModelApp;
    }

    private class EvoNavVersionInfo
    implements Comparable {
        private String name = "";
        private String version = "";
        private int colID;

        public EvoNavVersionInfo(String string, String string2, int n) {
            this.colID = n;
            boolean bl = false;
            if (string != null && string.length() > 0) {
                if (Character.isDigit(string.charAt(0))) {
                    bl = true;
                    this.version = string;
                } else {
                    this.name = string;
                }
            }
            if (string2 != null & string2.length() > 0) {
                if (bl) {
                    this.name = string2;
                } else {
                    this.version = string2;
                }
            }
        }

        EvoListRow getRow(int n) {
            EvoListRow evoListRow = new EvoListRow(n, 5);
            evoListRow.setInteger(0, this.colID);
            evoListRow.setText(1, this.getName());
            evoListRow.setText(2, this.getVersion());
            evoListRow.setInteger(4, 0);
            return evoListRow;
        }

        private String getName() {
            return this.name;
        }

        private String getVersion() {
            return this.version;
        }

        public int compareTo(Object object) {
            if (object instanceof EvoNavVersionInfo) {
                return this.getName().compareTo(((EvoNavVersionInfo)object).getName());
            }
            return 0;
        }
    }
}

