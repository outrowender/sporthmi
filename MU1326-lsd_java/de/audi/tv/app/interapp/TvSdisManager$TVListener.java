/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.interapp.ITVInterappListener$TvState;
import de.audi.tv.app.interapp.ITVInterappListener$TvTunerConfig;
import de.audi.tv.app.interapp.InterappUtil;
import de.audi.tv.app.interapp.TvSdisManager;
import de.audi.tv.app.interapp.TvSdisManager$1;
import org.dsi.ifc.tvtuner.StartUpConfig;

class TvSdisManager$TVListener
extends DefaultTVListener {
    private final /* synthetic */ TvSdisManager this$0;

    private TvSdisManager$TVListener(TvSdisManager tvSdisManager) {
        this.this$0 = tvSdisManager;
    }

    @Override
    public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        boolean bl5 = bl4 = bl || bl2;
        if (bl4 != TvSdisManager.access$1400(this.this$0)) {
            TvSdisManager.access$1402(this.this$0, bl4);
            TvSdisManager.access$800(this.this$0).updateSeekStatus(bl4);
        }
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        TvSdisManager.access$1502(this.this$0, startUpConfig.requiredKeypanelList);
        TvSdisManager.access$1102(this.this$0, startUpConfig.parentalControlReq);
        TvSdisManager.access$800(this.this$0).updatePanelKeySet(startUpConfig.requiredKeypanelList);
        TvSdisManager.access$800(this.this$0).updateParentalSettings(startUpConfig.parentalControlReq, TvSdisManager.access$1000(this.this$0));
        TvSdisManager.access$1602(this.this$0, new ITVInterappListener$TvTunerConfig(startUpConfig.linkingAvail, startUpConfig.avSrcAvail, startUpConfig.tvNormAvail, startUpConfig.audioChannelAvail, startUpConfig.videoFormatAvail, startUpConfig.avNormAvail, startUpConfig.avFormatAvail, startUpConfig.subtitleAvail, startUpConfig.ewsAvail, startUpConfig.logoListAvail, startUpConfig.casAvail, startUpConfig.skipBehaviourAvail, startUpConfig.visualAudioAvail, startUpConfig.browserListSortAvail, startUpConfig.parentalControlReq, startUpConfig.tmTeletextAvail, startUpConfig.tmDatabroadDMBAvail, startUpConfig.tmDatabroadISDBAvail, startUpConfig.tmDatabroadDTMBAvail, startUpConfig.tmDatabroadDMBAvail, startUpConfig.tmDatabroadATSCAvail, startUpConfig.tmDatabroad1Avail, startUpConfig.tmDatabroad2Avail, startUpConfig.tmBWSAvail, startUpConfig.tmSLSDLSAvail, startUpConfig.tmTXTAvail, startUpConfig.tmCASAvail, startUpConfig.tmEPGAvail, startUpConfig.tmVisualAudioAvail));
        TvSdisManager.access$800(this.this$0).updateTvTunerConfig(TvSdisManager.access$1600(this.this$0));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedSource(int n) {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$1702(this.this$0, n);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTerminalMode(int n, int n2) {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$602(this.this$0, n);
            TvSdisManager.access$1800(this.this$0, n);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    @Override
    public void updateMuteState(int n) {
        TvSdisManager.access$800(this.this$0).updateTvState(new ITVInterappListener$TvState(InterappUtil.translateMuteState(n)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateMessageService(int n) {
        Object object = TvSdisManager.access$500(this.this$0);
        synchronized (object) {
            TvSdisManager.access$1902(this.this$0, n == 1);
            TvSdisManager.access$800(this.this$0).updateTerminalMode(TvSdisManager.access$700(this.this$0));
        }
    }

    /* synthetic */ TvSdisManager$TVListener(TvSdisManager tvSdisManager, TvSdisManager$1 tvSdisManager$1) {
        this(tvSdisManager);
    }
}

