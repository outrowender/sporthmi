/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.car;

import de.esolutions.fw.util.commons.Buffer;

class BreakdownCallCarPositionHandler$GeoPair {
    public final int lat;
    public final int lng;

    public BreakdownCallCarPositionHandler$GeoPair(int n, int n2) {
        this.lat = n;
        this.lng = n2;
    }

    public String toString() {
        return new Buffer("GeoPair [lat=").append(this.lat).append(", lng=").append(this.lng).append("]").toString();
    }
}

