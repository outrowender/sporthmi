/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.business.HandlerTransactionData;

public class IntLightRangeHandlerTransactionData
implements HandlerTransactionData {
    private int profileID;
    private int value;

    public IntLightRangeHandlerTransactionData(int n, int n2) {
        this.profileID = n;
        this.value = n2;
    }

    public int getProfileID() {
        return this.profileID;
    }

    public int getValue() {
        return this.value;
    }
}

