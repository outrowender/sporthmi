/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.NaviService$NaviDetails;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.fw.util.commons.Buffer;

public class NaviService$NaviInfoDetails
extends NaviService$NaviDetails {
    public float distance;
    public int distanceUnit;
    public DateMetric time;

    @Override
    public String toString() {
        Buffer buffer = new Buffer(super.toString());
        buffer.append(", distance=").append(this.distance).append(", unit=").append(this.distanceUnit).append(", time=").append(this.time != null ? this.time.format() : "??:??");
        return buffer.toString();
    }
}

