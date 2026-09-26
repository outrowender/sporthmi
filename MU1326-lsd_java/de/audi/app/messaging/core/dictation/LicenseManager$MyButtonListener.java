/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.LicenseManager;
import de.audi.app.messaging.core.dictation.LicenseManager$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class LicenseManager$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ LicenseManager this$0;

    private LicenseManager$MyButtonListener(LicenseManager licenseManager) {
        this.this$0 = licenseManager;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == -1903025920) {
            LicenseManager.access$1000(this.this$0, n, n3);
        } else {
            LicenseManager.access$1100(this.this$0).log(10000, "[LicenseManager#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ LicenseManager$MyButtonListener(LicenseManager licenseManager, LicenseManager$1 licenseManager$1) {
        this(licenseManager);
    }
}

