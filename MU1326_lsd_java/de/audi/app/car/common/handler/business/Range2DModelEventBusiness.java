/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.Range2DModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;

public interface Range2DModelEventBusiness
extends ButtonModelEventBusiness {
    default public boolean processAdjustment(int n, int n2, Range2DModelHandler range2DModelHandler) {
    }

    default public boolean processAdjustment(HandlerTransactionData handlerTransactionData, Range2DModelHandler range2DModelHandler) {
    }
}

