/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.core.light.IntLightSetEvaluator;

public class IntLightSetEvaluator$SingleZoneIdentity {
    private int setNumber;
    private int zoneIdentifier;
    private final /* synthetic */ IntLightSetEvaluator this$0;

    public IntLightSetEvaluator$SingleZoneIdentity(IntLightSetEvaluator intLightSetEvaluator) {
        this.this$0 = intLightSetEvaluator;
    }

    public int getSetNumber() {
        return this.setNumber;
    }

    public void setSetNumber(int n) {
        this.setNumber = n;
    }

    public int getZoneIdentifier() {
        return this.zoneIdentifier;
    }

    public void setZoneIdentifier(int n) {
        this.zoneIdentifier = n;
    }
}

