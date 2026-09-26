/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.LicenseManager;
import de.audi.app.messaging.core.dictation.LicenseManager$1;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;

class LicenseManager$MyChoiceListener
extends DefaultChoiceListener {
    private final /* synthetic */ LicenseManager this$0;

    private LicenseManager$MyChoiceListener(LicenseManager licenseManager) {
        this.this$0 = licenseManager;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == -1819139840) {
            this.onlineLicenceExpirationReminderChoice(n2);
        } else {
            LicenseManager.access$1200(this.this$0).log(10000, "[LicenseManager#itemSelected] Unexpected modelID = %1", (long)n);
        }
    }

    private void onlineLicenceExpirationReminderChoice(int n) {
        LicenseManager.access$1300(this.this$0).log(1078071040, "[SettingsManager#onlineLicenceExpirationReminderChoice] itemID = %1", (long)n);
        this.this$0.setExpirationWarning(n == 0);
    }

    /* synthetic */ LicenseManager$MyChoiceListener(LicenseManager licenseManager, LicenseManager$1 licenseManager$1) {
        this(licenseManager);
    }
}

