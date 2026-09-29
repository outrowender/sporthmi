/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.SearchResult;

class AbstractTelDSISearchManager$TelDSISearchListenerImpl$1
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ SearchResult val$searchResult;
    private final /* synthetic */ AbstractTelDSISearchManager$TelDSISearchListenerImpl this$1;

    AbstractTelDSISearchManager$TelDSISearchListenerImpl$1(AbstractTelDSISearchManager$TelDSISearchListenerImpl abstractTelDSISearchManager$TelDSISearchListenerImpl, int n, SearchResult searchResult) {
        this.this$1 = abstractTelDSISearchManager$TelDSISearchListenerImpl;
        this.val$success = n;
        this.val$searchResult = searchResult;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSISearchListener dSISearchListener = AbstractTelDSISearchManager.access$500(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1));
        try {
            dSISearchListener = (DSISearchListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            AbstractTelDSISearchManager.access$600(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1)).log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#searchResult] %1", (Throwable)classCastException);
        }
        dSISearchListener.searchResult(this.val$success, this.val$searchResult);
    }
}

