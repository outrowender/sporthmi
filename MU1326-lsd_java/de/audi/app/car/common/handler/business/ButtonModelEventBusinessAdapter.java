/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.ButtonModelHandler;
import de.audi.app.car.common.handler.business.ButtonModelEventBusiness;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class ButtonModelEventBusinessAdapter
implements ButtonModelEventBusiness {
    private DSIBase dsi;
    private LogChannel logChannel;

    protected ButtonModelEventBusinessAdapter(DSIBase dSIBase, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.dsi = dSIBase;
    }

    @Override
    public boolean processKeyPressed(int n, ButtonModelHandler buttonModelHandler) {
        return false;
    }

    @Override
    public boolean processKeyReleased(int n, ButtonModelHandler buttonModelHandler) {
        return false;
    }

    @Override
    public boolean processKeyTyped(int n, ButtonModelHandler buttonModelHandler) {
        return false;
    }

    @Override
    public boolean processKeyPressed(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
        return false;
    }

    @Override
    public boolean processKeyReleased(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
        return false;
    }

    @Override
    public boolean processKeyTyped(HandlerTransactionData handlerTransactionData, ButtonModelHandler buttonModelHandler) {
        return false;
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public DSIBase getDSI() {
        return this.dsi;
    }
}

