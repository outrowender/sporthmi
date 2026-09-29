/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.RangeModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;

public interface RangeModelEventBusiness
extends ButtonModelEventBusiness {
    default public boolean processAdjustment(int n, RangeModelHandler rangeModelHandler) {
    }

    default public boolean processAdjustment(HandlerTransactionData handlerTransactionData, RangeModelHandler rangeModelHandler) {
    }
}

