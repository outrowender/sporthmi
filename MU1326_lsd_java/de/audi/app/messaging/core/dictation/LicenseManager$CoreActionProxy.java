/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.LicenseManager;
import de.audi.app.messaging.core.dictation.LicenseManager$1;
import de.audi.app.messaging.core.guide.DefaultCoreActionProxy;
import de.audi.app.messaging.core.guide.IActionProxySubscriber;

final class LicenseManager$CoreActionProxy
extends DefaultCoreActionProxy
implements IActionProxySubscriber {
    private final /* synthetic */ LicenseManager this$0;

    private LicenseManager$CoreActionProxy(LicenseManager licenseManager) {
        this.this$0 = licenseManager;
    }

    @Override
    public void onlineLicenseCheckEntered(int n) {
        LicenseManager.access$600(this.this$0).log(-2137614336, "[LicenseManager#onlineLicenseCheckEntered]");
        LicenseManager.access$700(this.this$0);
    }

    @Override
    public void onlineLicenseCheckExited(int n) {
        LicenseManager.access$800(this.this$0).log(-2137614336, "[LicenseManager#onlineLicenseCheckExited]");
        LicenseManager.access$900(this.this$0);
    }

    /* synthetic */ LicenseManager$CoreActionProxy(LicenseManager licenseManager, LicenseManager$1 licenseManager$1) {
        this(licenseManager);
    }
}

