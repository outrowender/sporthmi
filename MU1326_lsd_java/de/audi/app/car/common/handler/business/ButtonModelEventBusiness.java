/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.ModelEventBusiness;

public interface ButtonModelEventBusiness
extends ModelEventBusiness {
    public boolean processKeyPressed(int var1, ButtonModelHandler var2);

    public boolean processKeyReleased(int var1, ButtonModelHandler var2);

    public boolean processKeyTyped(int var1, ButtonModelHandler var2);

    public boolean processKeyPressed(HandlerTransactionData var1, ButtonModelHandler var2);

    public boolean processKeyReleased(HandlerTransactionData var1, ButtonModelHandler var2);

    public boolean processKeyTyped(HandlerTransactionData var1, ButtonModelHandler var2);
}

