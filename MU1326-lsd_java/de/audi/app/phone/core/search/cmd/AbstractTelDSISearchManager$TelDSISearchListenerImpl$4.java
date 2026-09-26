/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchListener;

class AbstractTelDSISearchManager$TelDSISearchListenerImpl$4
extends CommandResponse {
    private final /* synthetic */ int val$queryId;
    private final /* synthetic */ boolean val$isActive;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ AbstractTelDSISearchManager$TelDSISearchListenerImpl this$1;

    AbstractTelDSISearchManager$TelDSISearchListenerImpl$4(AbstractTelDSISearchManager$TelDSISearchListenerImpl abstractTelDSISearchManager$TelDSISearchListenerImpl, int n, boolean bl, int n2) {
        this.this$1 = abstractTelDSISearchManager$TelDSISearchListenerImpl;
        this.val$queryId = n;
        this.val$isActive = bl;
        this.val$validFlag = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSISearchListener dSISearchListener = AbstractTelDSISearchManager.access$500(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1));
        try {
            dSISearchListener = (DSISearchListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            AbstractTelDSISearchManager.access$1600(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1)).log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#updateSearchIsActive] %1", (Throwable)classCastException);
        }
        dSISearchListener.updateSearchIsActive(this.val$queryId, this.val$isActive, this.val$validFlag);
    }
}

