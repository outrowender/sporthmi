/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

import de.audi.app.messaging.core.guide.AbstractActionProxyService;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class AbstractActionProxyService$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ AbstractActionProxyService this$0;

    AbstractActionProxyService$DiagPlugIn(AbstractActionProxyService abstractActionProxyService) {
        this.this$0 = abstractActionProxyService;
    }

    public void cmdParentFolderSelected() {
        this.this$0.parentFolderSelected(0);
    }
}

