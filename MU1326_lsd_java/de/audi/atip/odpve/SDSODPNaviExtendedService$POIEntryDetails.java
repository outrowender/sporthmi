/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odpve;

import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.odp.SDSODPNaviService$POIEntry;

public class SDSODPNaviExtendedService$POIEntryDetails
extends SDSODPNaviService$POIEntry {
    private DateMetric ete;

    public SDSODPNaviExtendedService$POIEntryDetails(long l, String string, int n, Distance distance, DateMetric dateMetric) {
        super(l, string, n, distance == null ? 0 : Math.round(distance.getValue()));
        this.ete = dateMetric;
    }

    public DateMetric getEte() {
        return this.ete;
    }

    @Override
    public String toString() {
        return new StringBuffer(super.toString()).append(", ETE=").append(this.ete.format()).toString();
    }
}

