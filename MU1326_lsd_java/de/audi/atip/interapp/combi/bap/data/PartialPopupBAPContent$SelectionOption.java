/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.data;

import de.esolutions.fw.util.commons.Buffer;

public class PartialPopupBAPContent$SelectionOption {
    int optionID;
    int optionType;
    String optionString;

    public PartialPopupBAPContent$SelectionOption() {
        this.optionID = -1;
        this.optionType = 0;
        this.optionString = "";
    }

    public PartialPopupBAPContent$SelectionOption(int n, int n2, String string) {
        this.optionID = n;
        this.optionType = n2;
        this.optionString = string;
    }

    public int getOptionID() {
        return this.optionID;
    }

    public int getOptionType() {
        return this.optionType;
    }

    public String getOptionString() {
        return this.optionString;
    }

    public boolean isAvailable() {
        return this.optionType != 0;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("type=").append(this.optionType);
        buffer.append(", '").append(this.optionString).append("'");
        return buffer.toString();
    }
}

