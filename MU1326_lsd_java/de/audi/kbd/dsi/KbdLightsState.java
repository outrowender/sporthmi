/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.atip.hmi.KbdService;

final class KbdLightsState
implements KbdService,
Cloneable {
    private int hardkey = -1;
    private int softkey = -1;

    KbdLightsState() {
    }

    public int getActiveHK() {
        return this.hardkey;
    }

    public int getActiveSK() {
        return this.softkey;
    }

    public void setActiveHK(int n) {
        this.hardkey = n;
    }

    public void setActiveSK(int n) {
        this.softkey = n;
    }

    public KbdService getKbdService() {
        KbdService kbdService;
        try {
            kbdService = (KbdService)this.clone();
        }
        catch (Exception exception) {
            kbdService = new KbdLightsState();
        }
        return kbdService;
    }

    public void synchronizeSettings(KbdService kbdService) {
        if (kbdService instanceof KbdLightsState) {
            this.hardkey = ((KbdLightsState)kbdService).getActiveHK();
            this.softkey = ((KbdLightsState)kbdService).getActiveSK();
        }
    }

    public void setHKIlluminationExclusive(int n) {
        this.hardkey = n;
    }

    public void setHKIlluminationOff() {
        this.hardkey = -1;
    }

    public void setSKIlluminationExclusive(int n) {
        this.softkey = n;
    }

    public void setSKIlluminationOff() {
        this.softkey = -1;
    }

    public boolean setRecognizerMode(int n) {
        return false;
    }

    public int getRecognizerMode() {
        return -1;
    }

    public void setRecognizerLanguage(String string, int n) {
    }

    protected Object clone() throws CloneNotSupportedException {
        KbdService kbdService = (KbdService)super.clone();
        kbdService.synchronizeSettings(this);
        return kbdService;
    }

    public int getCurrentKeyboardType() {
        return 0;
    }

    public boolean isTouchKeypanel() {
        return true;
    }

    public boolean isPanelWithJoystick() {
        return true;
    }

    public void setTouchSensitiveArea(int n, int n2, int n3, int n4) {
    }

    public void setIgnoreNextMutePressButtonFlag() {
    }

    public void setRecognitionTimeoutAsia(int n) {
    }

    public void setGenericSetting(int n, int n2) {
    }

    public int getGenericSettingPresetLayout() {
        return 0;
    }

    public void setAdditionHKIllumination(int n, boolean bl) {
    }

    public void clearRecognizer() {
    }
}

