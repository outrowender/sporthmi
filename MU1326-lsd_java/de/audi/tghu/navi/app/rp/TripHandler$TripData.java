/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rp;

import de.esolutions.fw.util.commons.Buffer;

public class TripHandler$TripData {
    public boolean etaModeActive = true;
    public long etaToNextDestination = 0L;
    public boolean etaValid = false;
    public long timeToNextDestination = 0L;
    public int distanceToNextDestination = 0;
    public long timeToFinalDestination = 0L;
    public long etaToFinalDestination = 0L;
    public int timeZoneOffset = 0;
    public boolean isTimeZoneOffset = false;
    public int timeZoneOffsetToFinalDest = 0;
    public boolean isTimeZoneOffsetToFinalDest = false;
    public int distanceToFinalDestination = 0;
    public int indexOfCurrentDestination = 0;

    public void clone(TripHandler$TripData tripHandler$TripData) {
        this.etaModeActive = tripHandler$TripData.etaModeActive;
        this.etaToNextDestination = tripHandler$TripData.etaToNextDestination;
        this.etaValid = tripHandler$TripData.etaValid;
        this.timeToNextDestination = tripHandler$TripData.timeToNextDestination;
        this.distanceToNextDestination = tripHandler$TripData.distanceToNextDestination;
        this.timeToFinalDestination = tripHandler$TripData.timeToFinalDestination;
        this.etaToFinalDestination = tripHandler$TripData.etaToFinalDestination;
        this.distanceToFinalDestination = tripHandler$TripData.distanceToFinalDestination;
        this.indexOfCurrentDestination = tripHandler$TripData.indexOfCurrentDestination;
        this.timeZoneOffset = tripHandler$TripData.timeZoneOffset;
        this.isTimeZoneOffset = tripHandler$TripData.isTimeZoneOffset;
        this.timeZoneOffsetToFinalDest = tripHandler$TripData.timeZoneOffsetToFinalDest;
        this.isTimeZoneOffsetToFinalDest = tripHandler$TripData.isTimeZoneOffsetToFinalDest;
    }

    public void clear() {
        this.etaToNextDestination = 0L;
        this.etaValid = false;
        this.timeToNextDestination = 0L;
        this.distanceToNextDestination = 0;
        this.timeToFinalDestination = 0L;
        this.etaToFinalDestination = 0L;
        this.distanceToFinalDestination = 0;
        this.indexOfCurrentDestination = 0;
        this.timeZoneOffset = 0;
        this.isTimeZoneOffset = false;
        this.timeZoneOffsetToFinalDest = 0;
        this.isTimeZoneOffsetToFinalDest = false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("etaModeActive=").append(this.etaModeActive).append(", ");
        buffer.append("etaToNextDestination=").append(this.etaToNextDestination).append(", ");
        buffer.append("etaValid=").append(this.etaValid).append(", ");
        buffer.append("timeToNextDestination=").append(this.timeToNextDestination).append(", ");
        buffer.append("distanceToNextDestination=").append(this.distanceToNextDestination).append(", ");
        buffer.append("timeToFinalDestination=").append(this.timeToFinalDestination).append(", ");
        buffer.append("etaToFinalDestination=").append(this.etaToFinalDestination).append(", ");
        buffer.append("distanceToFinalDestination=").append(this.distanceToFinalDestination).append(", ");
        buffer.append("indexOfCurrentDestination=").append(this.indexOfCurrentDestination).append(", ");
        buffer.append("isTimeZoneOffset=").append(this.isTimeZoneOffset).append(", ");
        buffer.append("timeZoneOffset=").append(this.timeZoneOffset).append(", ");
        buffer.append("isTimeZoneOffsetToFinalDest=").append(this.isTimeZoneOffsetToFinalDest).append(", ");
        buffer.append("timeZoneOffsetToFinalDest=").append(this.timeZoneOffsetToFinalDest);
        return buffer.toString();
    }
}

