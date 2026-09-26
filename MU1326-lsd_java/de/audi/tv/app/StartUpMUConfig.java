/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class StartUpMUConfig
extends DefaultTVListener {
    private static final int NOT_AVAILABLE;
    private static final int AVAILABLE;
    private final TVEnv env;

    public StartUpMUConfig(TVEnv tVEnv) {
        this.env = tVEnv;
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        this.update("Audio channel", 1974216448, startUpConfig.audioChannelAvail);
        this.update("AV-Format", 1990993664, startUpConfig.avFormatAvail);
        this.update("AV-Norm", 2007770880, startUpConfig.avNormAvail);
        this.update("BrowserListSort", 2024548096, startUpConfig.browserListSortAvail);
        this.update("CAS", 2041325312, startUpConfig.casAvail);
        this.update("EWS", -525588736, startUpConfig.ewsAvail);
        this.update("Parental control", 2058102528, startUpConfig.parentalControlReq);
        this.update("Service linking", 2074879744, startUpConfig.linkingAvail);
        this.update("Subtitle", 2091656960, startUpConfig.subtitleAvail);
        this.update("TV-Norm", 2108434176, startUpConfig.tvNormAvail);
        this.update("Video-Format", 2125211392, startUpConfig.videoFormatAvail);
        this.update("Visual Audio", 2141988608, startUpConfig.visualAudioAvail);
        boolean bl = startUpConfig.tmDatabroadDVBAvail || startUpConfig.tmDatabroadATSCAvail || startUpConfig.tmDatabroadISDBAvail || startUpConfig.tmDatabroadDMBAvail || startUpConfig.tmDatabroadDTMBAvail || startUpConfig.tmDatabroad1Avail || startUpConfig.tmDatabroad2Avail;
        this.update("Terminal mode data broadcast DVB", -1817434368, bl);
        this.update("Terminal mode BWS", -2136201472, startUpConfig.tmBWSAvail);
        this.update("Terminal mode CAS", -2119424256, startUpConfig.tmCASAvail);
        this.update("Terminal mode EPG", -2102647040, startUpConfig.tmEPGAvail);
        this.update("Terminal mode SLSDLS", -2085869824, startUpConfig.tmSLSDLSAvail);
        this.update("Terminal mode teletext", -2069092608, startUpConfig.tmTeletextAvail);
        this.update("Terminal mode TXT", -2052315392, startUpConfig.tmTXTAvail);
        this.update("Terminal mode visual audio", -2035538176, startUpConfig.tmVisualAudioAvail);
    }

    private void update(String string, int n, boolean bl) {
        this.env.lcMain.log(1078071040, "[StartUpMUConfig.update] %2: %1", bl, (Object)string);
        this.env.getChoiceModel(n).setValue(bl ? 1 : 0);
    }
}

