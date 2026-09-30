/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class StartUpMUConfig
extends DefaultTVListener {
    private static final int NOT_AVAILABLE = 0;
    private static final int AVAILABLE = 1;
    private final TVEnv env;

    public StartUpMUConfig(TVEnv tVEnv) {
        this.env = tVEnv;
    }

    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        this.update("Audio channel", 2600053, startUpConfig.audioChannelAvail);
        this.update("AV-Format", 2600054, startUpConfig.avFormatAvail);
        this.update("AV-Norm", 2600055, startUpConfig.avNormAvail);
        this.update("BrowserListSort", 2600056, startUpConfig.browserListSortAvail);
        this.update("CAS", 2600057, startUpConfig.casAvail);
        this.update("EWS", 2600160, startUpConfig.ewsAvail);
        this.update("Parental control", 2600058, startUpConfig.parentalControlReq);
        this.update("Service linking", 2600059, startUpConfig.linkingAvail);
        this.update("Subtitle", 2600060, startUpConfig.subtitleAvail);
        this.update("TV-Norm", 2600061, startUpConfig.tvNormAvail);
        this.update("Video-Format", 2600062, startUpConfig.videoFormatAvail);
        this.update("Visual Audio", 2600063, startUpConfig.visualAudioAvail);
        boolean bl = startUpConfig.tmDatabroadDVBAvail || startUpConfig.tmDatabroadATSCAvail || startUpConfig.tmDatabroadISDBAvail || startUpConfig.tmDatabroadDMBAvail || startUpConfig.tmDatabroadDTMBAvail || startUpConfig.tmDatabroad1Avail || startUpConfig.tmDatabroad2Avail;
        this.update("Terminal mode data broadcast DVB", 2600083, bl);
        this.update("Terminal mode BWS", 2600064, startUpConfig.tmBWSAvail);
        this.update("Terminal mode CAS", 2600065, startUpConfig.tmCASAvail);
        this.update("Terminal mode EPG", 2600066, startUpConfig.tmEPGAvail);
        this.update("Terminal mode SLSDLS", 2600067, startUpConfig.tmSLSDLSAvail);
        this.update("Terminal mode teletext", 2600068, startUpConfig.tmTeletextAvail);
        this.update("Terminal mode TXT", 2600069, startUpConfig.tmTXTAvail);
        this.update("Terminal mode visual audio", 2600070, startUpConfig.tmVisualAudioAvail);
    }

    private void update(String string, int n, boolean bl) {
        this.env.lcMain.log(1000000, "[StartUpMUConfig.update] %2: %1", bl, (Object)string);
        this.env.getChoiceModel(n).setValue(bl ? 1 : 0);
    }
}

