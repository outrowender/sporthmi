/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.system;

import de.audi.app.system.HeadUnitASIProvider;
import de.audi.atip.agent.IASICall;
import de.esolutions.fw.comm.asi.hmisync.headunit.impl.ASIHMISyncHeadUnitReplyProxy;
import de.esolutions.fw.comm.core.IProxyFrontend;

class HeadUnitASIProvider$1
implements IASICall {
    private final /* synthetic */ HeadUnitASIProvider this$0;

    HeadUnitASIProvider$1(HeadUnitASIProvider headUnitASIProvider) {
        this.this$0 = headUnitASIProvider;
    }

    @Override
    public void call(IProxyFrontend iProxyFrontend) {
        ((ASIHMISyncHeadUnitReplyProxy)iProxyFrontend).resetLanguage(HeadUnitASIProvider.access$000(this.this$0).getSDISLanguage(), HeadUnitASIProvider.access$000(this.this$0).getSDISLocale().toString());
    }
}

