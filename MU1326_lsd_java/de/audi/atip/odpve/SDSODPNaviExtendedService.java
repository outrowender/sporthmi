/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odpve;

import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.odp.SDSODPNaviService;

public interface SDSODPNaviExtendedService
extends SDSODPNaviService {
    public void getPoiResultDetailsByLine(int var1);

    public static class POIEntryDetails
    extends SDSODPNaviService.POIEntry {
        private DateMetric ete;

        public POIEntryDetails(long l, String string, int n, Distance distance, DateMetric dateMetric) {
            super(l, string, n, distance == null ? 0 : Math.round(distance.getValue()));
            this.ete = dateMetric;
        }

        public DateMetric getEte() {
            return this.ete;
        }

        public String toString() {
            return super.toString() + ", ETE=" + this.ete.format();
        }
    }
}

