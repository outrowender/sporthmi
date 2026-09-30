/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.keypanel;

import de.audi.app.terminalmode.dsi.keypanel.TMDSIKeyPanelListener;
import de.audi.atip.log.LogChannel;

public class NullTMDSIKeyPanelListener
implements TMDSIKeyPanelListener {
    private static final String LOGCLASS = "NullTMDSIKeyPanelListener";
    private final LogChannel logger;

    public NullTMDSIKeyPanelListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public void updateRecognizerLanguage2(int n, String string, int n2) {
        this.logger.log(1000000, "[%1.updateRecognizerLanguage2]", (Object)LOGCLASS);
    }

    public void updateRecognizerMode(int n, int n2) {
        this.logger.log(1000000, "[%1.updateRecognizerMode]", (Object)LOGCLASS);
    }

    public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray) {
        this.logger.log(1000000, "[%1.updateCharacterEvent2]", (Object)LOGCLASS);
    }
}

