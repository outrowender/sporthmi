/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.metrics.Distance;
import de.esolutions.fw.util.commons.Buffer;

public class NaviService$POISDSListEntry
extends SDSListEntry {
    private final Distance distance;

    public NaviService$POISDSListEntry() {
        super("", 0L);
        this.distance = new Distance(0.0f, 1);
    }

    public NaviService$POISDSListEntry(String string, long l) {
        super(string, l);
        this.distance = new Distance(0.0f, 1);
    }

    public NaviService$POISDSListEntry(String string, long l, Distance distance) {
        super(string, l);
        this.distance = distance;
    }

    public Distance getDistance() {
        return this.distance;
    }

    @Override
    public String toString() {
        return new Buffer(super.toString()).append(", poiDistance=").append(this.distance).toString();
    }
}

