/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.ILegalDisclaimer;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.esolutions.fw.util.commons.Buffer;

final class LegalDisclaimer
implements ILegalDisclaimer,
SpeedThresholdListener,
ButtonListener {
    private final IFrameworkAccess framework;
    private final LogChannel lc;
    private boolean belowSpeedThreshold = true;
    private boolean disclaimerAcknowledged = false;

    protected LegalDisclaimer(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.lc = logChannel;
        iFrameworkAccess.getSysApp().registerSpeedThresholdListener(this, 1);
        this.getHMIService().getButtonModel(136).setButtonListener(this);
    }

    private final HMIService getHMIService() {
        return this.framework.getHMIService();
    }

    private final IAppSystem getAppSystemVariant() {
        return this.framework.getSysApp().getVariantAppSystem();
    }

    @Override
    public boolean isSpellerAccessAllowed() {
        return this.belowSpeedThreshold || this.disclaimerAcknowledged;
    }

    @Override
    public boolean showDisclaimer(int n) {
        if (!this.disclaimerAcknowledged) {
            this.getHMIService().getChoiceModel(137).setValue(this.framework.getLastmodeHandler().getLastmode(n));
            this.getAppSystemVariant().showLegalDisclaimer(n);
        } else {
            this.lc.log(-2137614336, "disclaimer already acknowledged!");
        }
        return !this.disclaimerAcknowledged;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("belowSpeedThreshold: ").append(this.belowSpeedThreshold).append('\n');
        buffer.append("disclaimerAcknowledged: ").append(this.disclaimerAcknowledged).append('\n');
        return buffer.toString();
    }

    @Override
    public void belowLowerThreshold(int n) {
        this.lc.log(-2137614336, "belowLowerThreshold: thresholdId=%1", (long)n);
        this.belowSpeedThreshold = true;
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        this.lc.log(-2137614336, "exceedsUpperThreshold: thresholdId=%1", (long)n);
        this.belowSpeedThreshold = false;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.lc.log(-2137614336, "keyPressed: modelID=%1", (long)n);
        if (n == 136) {
            this.disclaimerAcknowledged = true;
            this.getAppSystemVariant().removeLegalDisclaimer(n3);
        }
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }
}

