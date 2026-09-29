/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.ChoiceModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;

public interface ChoiceModelEventBusiness
extends ButtonModelEventBusiness {
    default public boolean processItemSelected(int n, ChoiceModelHandler choiceModelHandler) {
    }

    default public boolean processItemFocused(int n, ChoiceModelHandler choiceModelHandler) {
    }

    default public boolean processItemSelected(HandlerTransactionData handlerTransactionData, ChoiceModelHandler choiceModelHandler) {
    }

    default public boolean processItemFocused(HandlerTransactionData handlerTransactionData, ChoiceModelHandler choiceModelHandler) {
    }
}

