/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl;

import de.audi.app.swdl.DriverResetHandlerEvo;
import de.audi.atip.statemachine.ap.CustDownloadActionProxy;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.AbstractCustDownloadActionProxy;
import de.audi.tghu.swdl.app.dsi.SwdlDSIManager;

public class CustDownloadActionProxyEvo
extends AbstractCustDownloadActionProxy
implements CustDownloadActionProxy {
    public CustDownloadActionProxyEvo(SwdlEnv swdlEnv, SwdlDSIManager swdlDSIManager) {
        super(swdlEnv, swdlDSIManager);
        this.driverResetHandler = new DriverResetHandlerEvo(swdlEnv);
    }
}

