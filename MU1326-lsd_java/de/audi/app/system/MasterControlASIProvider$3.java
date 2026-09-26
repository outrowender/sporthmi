/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.MasterControlASIProvider;
import de.audi.atip.agent.IASICall;
import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.comm.core.IProxyFrontend;

class MasterControlASIProvider$3
implements IASICall {
    private final /* synthetic */ int val$appContext;
    private final /* synthetic */ String val$param;
    private final /* synthetic */ MasterControlASIProvider this$0;

    MasterControlASIProvider$3(MasterControlASIProvider masterControlASIProvider, int n, String string) {
        this.this$0 = masterControlASIProvider;
        this.val$appContext = n;
        this.val$param = string;
    }

    @Override
    public void call(IProxyFrontend iProxyFrontend) {
        ((ASIHMISyncMasterControlReplyProxy)iProxyFrontend).enterAppContext(this.val$appContext, this.val$param);
    }
}

