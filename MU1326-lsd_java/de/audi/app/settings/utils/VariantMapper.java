/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.utils;

public class VariantMapper {
    private int rDKHighViewAvaliableChoiceModelID;
    private boolean shouldLinkSpeedAndDistance;

    public boolean shouldLinkSpeedAndDistance() {
        return this.shouldLinkSpeedAndDistance;
    }

    public void setShouldLinkSpeedAndDistance(boolean bl) {
        this.shouldLinkSpeedAndDistance = bl;
    }

    public int getRDKHighViewAvaliableChoiceModelID() {
        return this.rDKHighViewAvaliableChoiceModelID;
    }

    public void setRDKHighViewAvaliableChoiceID(int n) {
        this.rDKHighViewAvaliableChoiceModelID = n;
    }
}

