/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.version;

import de.audi.app.navi.evo.version.EvoNavVersionInfoList;
import de.audi.atip.hmi.model.list.EvoListRow;

class EvoNavVersionInfoList$EvoNavVersionInfo
implements Comparable {
    private String name = "";
    private String version = "";
    private int colID;
    private final /* synthetic */ EvoNavVersionInfoList this$0;

    public EvoNavVersionInfoList$EvoNavVersionInfo(EvoNavVersionInfoList evoNavVersionInfoList, String string, String string2, int n) {
        this.this$0 = evoNavVersionInfoList;
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

    @Override
    public int compareTo(Object object) {
        if (object instanceof EvoNavVersionInfoList$EvoNavVersionInfo) {
            return this.getName().compareTo(((EvoNavVersionInfoList$EvoNavVersionInfo)object).getName());
        }
        return 0;
    }
}

