/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.AbstractDriverResetHandler;

public class DriverResetHandlerEvo
extends AbstractDriverResetHandler {
    public DriverResetHandlerEvo(SwdlEnv swdlEnv) {
        super(swdlEnv);
    }

    public void handleDriverResetError(int n) {
        this.stopReset();
        this.getSwdlEnv().getHMIService().showPartialPopup(n, 66);
    }
}

