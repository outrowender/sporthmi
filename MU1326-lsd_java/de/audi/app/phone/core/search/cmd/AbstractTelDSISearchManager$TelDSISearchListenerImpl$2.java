/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager;
import de.audi.app.phone.core.search.cmd.AbstractTelDSISearchManager$TelDSISearchListenerImpl;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.search.DSISearchListener;
import org.dsi.ifc.search.Suggestion;

class AbstractTelDSISearchManager$TelDSISearchListenerImpl$2
extends CommandResponse {
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$queryID;
    private final /* synthetic */ Suggestion[] val$suggestions;
    private final /* synthetic */ AbstractTelDSISearchManager$TelDSISearchListenerImpl this$1;

    AbstractTelDSISearchManager$TelDSISearchListenerImpl$2(AbstractTelDSISearchManager$TelDSISearchListenerImpl abstractTelDSISearchManager$TelDSISearchListenerImpl, int n, int n2, Suggestion[] suggestionArray) {
        this.this$1 = abstractTelDSISearchManager$TelDSISearchListenerImpl;
        this.val$success = n;
        this.val$queryID = n2;
        this.val$suggestions = suggestionArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSISearchListener dSISearchListener = AbstractTelDSISearchManager.access$500(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1));
        try {
            dSISearchListener = (DSISearchListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            AbstractTelDSISearchManager.access$900(AbstractTelDSISearchManager$TelDSISearchListenerImpl.access$400(this.this$1)).log(10000, "[AbstractTelDSISearchManager.TelDSISearchListenerImpl#requestSuggestionResult] %1", (Throwable)classCastException);
        }
        dSISearchListener.requestSuggestionResult(this.val$success, this.val$queryID, this.val$suggestions);
    }
}

