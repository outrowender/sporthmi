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

    @Override
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

    @Override
    public void synchronizeSettings(KbdService kbdService) {
        if (kbdService instanceof KbdLightsState) {
            this.hardkey = ((KbdLightsState)kbdService).getActiveHK();
            this.softkey = ((KbdLightsState)kbdService).getActiveSK();
        }
    }

    @Override
    public void setHKIlluminationExclusive(int n) {
        this.hardkey = n;
    }

    @Override
    public void setHKIlluminationOff() {
        this.hardkey = -1;
    }

    @Override
    public void setSKIlluminationExclusive(int n) {
        this.softkey = n;
    }

    @Override
    public void setSKIlluminationOff() {
        this.softkey = -1;
    }

    @Override
    public boolean setRecognizerMode(int n) {
        return false;
    }

    @Override
    public int getRecognizerMode() {
        return -1;
    }

    @Override
    public void setRecognizerLanguage(String string, int n) {
    }

    protected Object clone() {
        KbdService kbdService = (KbdService)super.clone();
        kbdService.synchronizeSettings(this);
        return kbdService;
    }

    @Override
    public int getCurrentKeyboardType() {
        return 0;
    }

    @Override
    public boolean isTouchKeypanel() {
        return true;
    }

    @Override
    public boolean isPanelWithJoystick() {
        return true;
    }

    @Override
    public void setTouchSensitiveArea(int n, int n2, int n3, int n4) {
    }

    @Override
    public void setIgnoreNextMutePressButtonFlag() {
    }

    @Override
    public void setRecognitionTimeoutAsia(int n) {
    }

    @Override
    public void setGenericSetting(int n, int n2) {
    }

    @Override
    public int getGenericSettingPresetLayout() {
        return 0;
    }

    @Override
    public void setAdditionHKIllumination(int n, boolean bl) {
    }

    @Override
    public void clearRecognizer() {
    }
}

