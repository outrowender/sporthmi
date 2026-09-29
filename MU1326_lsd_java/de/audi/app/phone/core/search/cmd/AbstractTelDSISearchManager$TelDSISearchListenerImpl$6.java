/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchListener;

class AbstractTelDSISearchManager$TelDSISearchListenerImpl$6
extends CommandResponse {
    private final /* synthetic */ int[] val$sources;
    private final /* synthetic */ AbstractTelDSISearchManager$TelDSISearchListenerImpl this$1;

    AbstractTelDSISearchManager$TelDSISearchListenerImpl$6(AbstractTelDSISearchManager$TelDSISearchListenerImpl abstractTelDSISearchManager$TelDSISearchListenerImpl, int[] nArray) {
        this.this$1 = abstractTelDSISearchManager$TelDSISearchListenerImpl;
        this.val$sources = nArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSISearchListener dSISearchListener = AbstractTelDSISearchManager.access$500(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1));
        try {
            dSISearchListener = (DSISearchListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            AbstractTelDSISearchManager.access$2600(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1)).log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#invalidateData] %1", (Throwable)classCastException);
        }
        dSISearchListener.invalidateData(this.val$sources);
    }
}

