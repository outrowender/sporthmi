/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.asia;

import de.audi.tghu.navi.app.util.LocationFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class DisambiguatedNavLocation {
    private final int type;
    private final NavLocation location;

    public DisambiguatedNavLocation(int n, NavLocation navLocation) {
        this.type = n;
        this.location = navLocation;
    }

    public NavLocation getLocation() {
        return this.location;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("type=");
        buffer.append(this.type);
        buffer.append(", location=");
        buffer.append(LocationFormatter.formatLocationShort(this.location));
        return buffer.toString();
    }
}

