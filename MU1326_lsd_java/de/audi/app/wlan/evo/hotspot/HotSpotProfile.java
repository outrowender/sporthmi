/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.evo.hotspot;

import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.hotspot.AbstractHotSpotProfile;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class HotSpotProfile
extends AbstractHotSpotProfile {
    private static final int MODEL_STATUS_ENABLE = 0;
    private static final int MODEL_STATUS_DISABLE = 1;
    private final ButtonModelApp ssidButton = this.getButtonModel(2500244);
    private final ButtonModelApp passwordButton = this.getButtonModel(2500243);

    public HotSpotProfile(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    protected final void updateSsidSpellerStatus() {
        this.ssidSpeller.setStatus(this.ssidSpeller.getText().length() > 0 ? 0 : 1);
    }

    protected void updatePasswordSpellerStatus() {
        boolean bl = this.isPasswordValid(this.profile != null && (this.profile.getCryptoModel() == 3 || this.profile.getCryptoModel() == 2), this.passwordSpeller.getText());
        this.passwordSpeller.setStatus(bl ? 0 : 1);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1000000, "HotSpotProfile#keyTyped(): modelID: %1", (long)n);
        if (n == this.ssidButton.getID()) {
            this.newSsidEntered();
            this.ssidButton.fireEvent(n3);
        } else if (n == this.passwordButton.getID()) {
            this.newPasswordEntered();
            this.passwordButton.fireEvent(n3);
        } else {
            super.keyTyped(n, n2, n3);
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (n == this.ssidSpeller.getID()) {
            this.log.log(10000000, "HotSpotProfile#textChanged(): ssid: %1", (Object)string);
            this.updateSsidSpellerStatus();
        } else if (n == this.ssidSpeller2.getID()) {
            this.log.log(10000000, "HotSpotProfile#textChanged(): ssid2: %1", (Object)string);
            if (string.length() <= this.ssidSpeller.getMaxLength()) {
                this.ssidSpeller.setText(string);
            }
            this.updateSsidSpellerStatus();
            this.ssidSpeller2.fireEvent(n2);
        } else if (n == this.passwordSpeller.getID()) {
            this.log.log(10000000, "HotSpotProfile#textChanged(): password: %1", (Object)string);
            this.updatePasswordSpellerStatus();
        } else if (n == this.passwordSpeller2.getID()) {
            this.log.log(10000000, "HotSpotProfile#textChanged(): password: %1", (Object)string);
            if (string.length() <= this.passwordSpeller.getMaxLength()) {
                this.passwordSpeller.setText(string);
            }
            this.updatePasswordSpellerStatus();
            this.passwordSpeller2.fireEvent(n2);
        }
    }

    public void init() {
        super.init();
        this.ssidButton.setButtonListener(this);
        this.passwordButton.setButtonListener(this);
    }

    public void deinit() {
        this.ssidButton.resetListener();
        this.passwordButton.resetListener();
        super.deinit();
    }
}

