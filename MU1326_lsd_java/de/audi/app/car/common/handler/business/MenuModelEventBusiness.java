/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.ModelEventBusiness;

public interface MenuModelEventBusiness
extends ModelEventBusiness {
    default public boolean processItemFocused(int n, MenuModelHandler menuModelHandler) {
    }

    default public boolean processItemFocused(HandlerTransactionData handlerTransactionData, MenuModelHandler menuModelHandler) {
    }
}

