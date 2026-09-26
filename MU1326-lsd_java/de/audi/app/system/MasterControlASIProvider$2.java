/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.MasterControlASIProvider;
import de.audi.atip.agent.IASICall;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.comm.core.IProxyFrontend;

class MasterControlASIProvider$2
implements IASICall {
    private final /* synthetic */ MasterControlASIProvider this$0;

    MasterControlASIProvider$2(MasterControlASIProvider masterControlASIProvider) {
        this.this$0 = masterControlASIProvider;
    }

    @Override
    public void call(IProxyFrontend iProxyFrontend) {
        ((ASIHMISyncMasterControlReplyProxy)iProxyFrontend).factoryReset();
    }
}

