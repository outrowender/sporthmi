/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.ModelEventBusiness;

public interface ButtonModelEventBusiness
extends ModelEventBusiness {
    default public boolean processKeyPressed(int n, ButtonModelHandler buttonModelHandler) {
    }

    default public boolean processKeyReleased(int n, ButtonModelHandler buttonModelHandler) {
    }

    default public boolean processKeyTyped(int n, ButtonModelHandler buttonModelHandler) {
    }

    default public boolean processKeyPressed(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
    }

    default public boolean processKeyReleased(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
    }

    default public boolean processKeyTyped(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
    }
}

