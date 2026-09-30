/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.ops;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class OPSSegment {
    private final int minDistance;
    private final int maxDistance;
    private final ChoiceModelApp distanceModel;
    private final int segmentID;
    public static final int HIDDEN_SEGMENT_ID = 0;
    public static final int WHITE_HIGHLIGHTING = 0;
    public static final int RED_HIGHLIGHTING = 1;
    private boolean hiddenStatus = false;

    public OPSSegment(int n, int n2, ChoiceModelApp choiceModelApp, int n3) {
        this.minDistance = n;
        this.maxDistance = n2;
        this.distanceModel = choiceModelApp;
        this.segmentID = n3;
    }

    public int getMinDistance() {
        return this.minDistance;
    }

    public int getMaxDistance() {
        return this.maxDistance;
    }

    private boolean isDistanceValueInsideRange(int n) {
        return n >= this.minDistance && n <= this.maxDistance;
    }

    public ChoiceModelApp getDistanceModel() {
        return this.distanceModel;
    }

    public boolean isActive(int n, int n2, int n3) {
        if (this.isDistanceValueInsideRange(n)) {
            if (!this.isHiddenStatus()) {
                this.setDistanceValue(n, n3);
            }
            return true;
        }
        if (this.segmentID == n2 && !this.isHiddenStatus()) {
            this.hideSegment();
        }
        return false;
    }

    private void hideSegment() {
        this.distanceModel.setValue(0);
    }

    private void setDistanceValue(int n, int n2) {
        if (n2 <= 0) {
            this.distanceModel.setValue(this.segmentID);
        } else {
            int n3 = 1;
            if (n > 0) {
                n3 = (n + n2 - 1) / n2;
            }
            this.distanceModel.setValue(n3);
        }
    }

    public void setStatus(int n, int n2, int n3) {
        this.setHiddenStatus(n == 0);
        if (this.isHiddenStatus()) {
            this.hideSegment();
            return;
        }
        this.setDistanceValue(n2, n3);
        if (n == 1 || n == 2) {
            this.distanceModel.setStatus(0);
        } else if (n == 3) {
            this.distanceModel.setStatus(1);
        }
    }

    private boolean isHiddenStatus() {
        return this.hiddenStatus;
    }

    private void setHiddenStatus(boolean bl) {
        this.hiddenStatus = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("OPSSegment (minDistance=").append(this.minDistance).append(", maxDistance=").append(this.maxDistance).append(", ");
        if (this.distanceModel != null) {
            stringBuffer.append("distanceModelID=").append(this.distanceModel.getID()).append(", ");
        }
        stringBuffer.append("segmentID=").append(this.segmentID).append(", hiddenStatus=").append(this.hiddenStatus).append(')');
        return stringBuffer.toString();
    }
}

