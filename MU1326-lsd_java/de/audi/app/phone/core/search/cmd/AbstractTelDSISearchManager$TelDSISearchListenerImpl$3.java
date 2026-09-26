/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchListener;

class AbstractTelDSISearchManager$TelDSISearchListenerImpl$3
extends CommandResponse {
    private final /* synthetic */ int val$queryId;
    private final /* synthetic */ int val$success;
    private final /* synthetic */ AbstractTelDSISearchManager$TelDSISearchListenerImpl this$1;

    AbstractTelDSISearchManager$TelDSISearchListenerImpl$3(AbstractTelDSISearchManager$TelDSISearchListenerImpl abstractTelDSISearchManager$TelDSISearchListenerImpl, int n, int n2) {
        this.this$1 = abstractTelDSISearchManager$TelDSISearchListenerImpl;
        this.val$queryId = n;
        this.val$success = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSISearchListener dSISearchListener = AbstractTelDSISearchManager.access$500(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1));
        try {
            dSISearchListener = (DSISearchListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            AbstractTelDSISearchManager.access$1100(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1)).log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#cancelQueryResult] %1", (Throwable)classCastException);
        }
        dSISearchListener.cancelQueryResult(this.val$queryId, this.val$success);
    }
}

