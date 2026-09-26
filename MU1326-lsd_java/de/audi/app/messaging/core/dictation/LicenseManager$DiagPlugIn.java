/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.dictation.DiagOnlineServiceDummy
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.LicenseManager;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.atip.interapp.online.IOnlineService;
import de.mib.swdiagnosis.msg.core.dictation.DiagOnlineServiceDummy;

final class LicenseManager$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ LicenseManager this$0;

    LicenseManager$DiagPlugIn(LicenseManager licenseManager) {
        this.this$0 = licenseManager;
    }

    public void cmdSetDummyOnlineService() {
        LicenseManager.access$500(this.this$0, (IOnlineService)new DiagOnlineServiceDummy());
    }
}

