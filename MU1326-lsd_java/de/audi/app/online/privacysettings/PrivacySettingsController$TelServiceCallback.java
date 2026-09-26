/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.privacysettings;

import de.audi.app.online.privacysettings.PrivacySettingsController;
import de.audi.atip.phone.ITelServiceConnectivityListener;

final class PrivacySettingsController$TelServiceCallback
implements ITelServiceConnectivityListener {
    private final /* synthetic */ PrivacySettingsController this$0;

    PrivacySettingsController$TelServiceCallback(PrivacySettingsController privacySettingsController) {
        this.this$0 = privacySettingsController;
    }

    @Override
    public void responseChangePhoneModulePowerState(int n) {
        if (n == 0) {
            PrivacySettingsController.access$000(this.this$0).log(1078071040, "PrivacySettingsController.TelServiceCallback#responseChangePhoneModulePowerState: Deactivate NAD module successful");
        } else {
            PrivacySettingsController.access$000(this.this$0).log(-1601830656, "PrivacySettingsController.TelServiceCallback#responseChangePhoneModulePowerState: Deactivate NAD module not successful");
        }
    }

    @Override
    public void responseTogglePhones(int n) {
    }

    @Override
    public void responseSetNadRole(int n) {
    }

    @Override
    public void responseSetNadMode(int n) {
    }
}

