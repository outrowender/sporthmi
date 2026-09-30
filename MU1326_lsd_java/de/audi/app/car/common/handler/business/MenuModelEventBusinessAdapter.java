/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.app.car.common.handler.MenuModelHandler;
import de.audi.app.car.common.handler.business.HandlerTransactionData;
import de.audi.app.car.common.handler.business.MenuModelEventBusiness;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public class MenuModelEventBusinessAdapter
implements MenuModelEventBusiness {
    private DSIBase dsi;
    private LogChannel logChannel;

    protected MenuModelEventBusinessAdapter(DSIBase dSIBase, LogChannel logChannel) {
        this.logChannel = logChannel;
        this.dsi = dSIBase;
    }

    public boolean processItemFocused(int n, MenuModelHandler menuModelHandler) {
        return false;
    }

    public boolean processItemFocused(HandlerTransactionData handlerTransactionData, MenuModelHandler menuModelHandler) {
        return false;
    }

    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    public DSIBase getDSI() {
        return this.dsi;
    }
}

