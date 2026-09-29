/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPDestinationInfo {
    private CombiBAPNaviDestination destination;
    private int noOfStopovers;
    private int noOfNextStopover;

    public CombiBAPDestinationInfo(CombiBAPNaviDestination combiBAPNaviDestination) {
        this.destination = combiBAPNaviDestination;
    }

    public CombiBAPDestinationInfo(int n, int n2, CombiBAPNaviDestination combiBAPNaviDestination) {
        this.noOfStopovers = n;
        this.noOfNextStopover = n2;
        this.destination = combiBAPNaviDestination;
    }

    public void setStopoverInformation(int n, int n2) {
        this.noOfStopovers = n;
        this.noOfNextStopover = n2;
    }

    public int getNoOfStopovers() {
        return this.noOfStopovers;
    }

    public int getNoOfNextStopover() {
        return this.noOfNextStopover;
    }

    public CombiBAPNaviDestination getDestination() {
        return this.destination;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPDestinationInfo {noOfStopovers=");
        buffer.append(this.noOfStopovers);
        buffer.append(", noOfNextStopover=");
        buffer.append(this.noOfNextStopover);
        buffer.append(", destination=");
        buffer.append(this.destination.toString());
        buffer.append("}");
        return buffer.toString();
    }
}

