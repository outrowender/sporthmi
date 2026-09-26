/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.NaviService$NaviDetails;
import de.esolutions.fw.util.commons.Buffer;

public class NaviService$NaviSUIDetails
extends NaviService$NaviDetails {
    public long poiIconID = -1L;
    public long adbID = -1L;
    public String adbName = "";
    public int entryChildren = 0;

    @Override
    public String toString() {
        Buffer buffer = new Buffer(super.toString());
        buffer.append(", poiIconID=").append(this.poiIconID).append("; adbName=").append(this.adbName).append(" (").append(this.adbID).append("); entryChildren=").append(this.entryChildren);
        return buffer.toString();
    }
}

