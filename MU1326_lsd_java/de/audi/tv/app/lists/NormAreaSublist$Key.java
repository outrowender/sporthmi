/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tvtuner.ServiceInfo;

class NormAreaSublist$Key {
    final long namePID;
    final int servicePID;
    final int sType;

    NormAreaSublist$Key(ServiceInfo serviceInfo) {
        this(serviceInfo.namePID, serviceInfo.servicePID, serviceInfo.sType);
    }

    NormAreaSublist$Key(long l, int n, int n2) {
        this.namePID = l;
        this.servicePID = n;
        this.sType = n2;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (int)(this.namePID ^ this.namePID >>> 32);
        n = 31 * n + this.sType;
        n = 31 * n + this.servicePID;
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof NormAreaSublist$Key)) {
            return false;
        }
        NormAreaSublist$Key normAreaSublist$Key = (NormAreaSublist$Key)object;
        if (this.namePID != normAreaSublist$Key.namePID) {
            return false;
        }
        if (this.sType != normAreaSublist$Key.sType) {
            return false;
        }
        return this.servicePID == normAreaSublist$Key.servicePID;
    }

    public String toString() {
        return new Buffer().append(this.namePID).append(',').append(this.servicePID).append(',').append(this.sType).toString();
    }
}

