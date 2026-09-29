/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelListener;
import de.audi.atip.log.LogChannel;

public class NullTMDSIKeyPanelListener
implements TMDSIKeyPanelListener {
    private static final String LOGCLASS;
    private final LogChannel logger;

    public NullTMDSIKeyPanelListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    @Override
    public void updateRecognizerLanguage2(int n, String string, int n2) {
        this.logger.log(1078071040, "[%1.updateRecognizerLanguage2]", (Object)"NullTMDSIKeyPanelListener");
    }

    @Override
    public void updateRecognizerMode(int n, int n2) {
        this.logger.log(1078071040, "[%1.updateRecognizerMode]", (Object)"NullTMDSIKeyPanelListener");
    }

    @Override
    public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray) {
        this.logger.log(1078071040, "[%1.updateCharacterEvent2]", (Object)"NullTMDSIKeyPanelListener");
    }
}

