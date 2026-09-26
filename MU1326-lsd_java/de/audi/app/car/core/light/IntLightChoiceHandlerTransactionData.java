/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.light;

import de.audi.app.car.common.handler.business.HandlerTransactionData;

public class IntLightChoiceHandlerTransactionData
implements HandlerTransactionData {
    private int newSelected;
    private int oldSelected;

    public IntLightChoiceHandlerTransactionData(int n, int n2) {
        this.newSelected = n;
        this.oldSelected = n2;
    }

    public int getNewSelected() {
        return this.newSelected;
    }

    public int getOldSelected() {
        return this.oldSelected;
    }
}

