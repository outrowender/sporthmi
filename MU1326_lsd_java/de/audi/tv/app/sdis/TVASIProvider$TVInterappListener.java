/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.ITVInterappListener$ActiveStationInfo;
import de.audi.tv.app.interapp.ITVInterappListener$ServiceInfo;
import de.audi.tv.app.interapp.ITVInterappListener$TvState;
import de.audi.tv.app.interapp.ITVInterappListener$TvTunerConfig;
import de.audi.tv.app.sdis.InterappKeyPanelHandler;
import de.audi.tv.app.sdis.TVASIProvider;
import de.audi.tv.app.sdis.TVASIProvider$1;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import java.util.ArrayList;

class TVASIProvider$TVInterappListener
implements ITVInterappListener {
    private byte activeTerminalMode = 0;
    private final /* synthetic */ TVASIProvider this$0;

    private TVASIProvider$TVInterappListener(TVASIProvider tVASIProvider) {
        this.this$0 = tVASIProvider;
    }

    @Override
    public void updateActiveStation(ITVInterappListener$ActiveStationInfo iTVInterappListener$ActiveStationInfo) {
        this.this$0.updateActiveStationInfo(TVASIProvider.access$200(iTVInterappListener$ActiveStationInfo));
    }

    @Override
    public void updateSeekStatus(boolean bl) {
        this.this$0.updateSeekStatus(bl ? (byte)0 : 1);
    }

    @Override
    public void updateTVStationList(ITVInterappListener$ServiceInfo[] iTVInterappListener$ServiceInfoArray) {
        ArrayList arrayList = new ArrayList(iTVInterappListener$ServiceInfoArray.length);
        for (int i2 = 0; i2 < iTVInterappListener$ServiceInfoArray.length; ++i2) {
            if (iTVInterappListener$ServiceInfoArray[i2] == null) continue;
            arrayList.add(new StationInfo(iTVInterappListener$ServiceInfoArray[i2].id, iTVInterappListener$ServiceInfoArray[i2].name, iTVInterappListener$ServiceInfoArray[i2].serviceType, iTVInterappListener$ServiceInfoArray[i2].contentGroup));
        }
        this.this$0.updateStationInfo((StationInfo[])arrayList.toArray(new StationInfo[0]));
    }

    @Override
    public void enforceTV() {
        this.this$0.parentalEnforcement.enforceTV();
    }

    @Override
    public void updateTerminalMode(byte by) {
        byte by2 = this.activeTerminalMode;
        for (int i2 = 0; i2 < TVASIProvider.TERMINAL_MODE_MAP.length; ++i2) {
            byte[] byArray = TVASIProvider.TERMINAL_MODE_MAP[i2];
            if (byArray[0] != by) continue;
            by2 = byArray[1];
            break;
        }
        if (by2 != this.activeTerminalMode) {
            this.activeTerminalMode = by2;
            this.this$0.updateTerminalMode(by2);
        }
    }

    @Override
    public void updatePanelKeySet(short[] sArray) {
        boolean bl = true;
        int n = -1;
        int n2 = -1;
        ArrayList arrayList = new ArrayList(sArray.length);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            KeySet keySet;
            if (bl) {
                n = i2;
                n2 = i2 + 2;
                bl = false;
                continue;
            }
            if (sArray[i2] != 255) continue;
            if (i2 == n2) {
                keySet = InterappKeyPanelHandler.createKeySet(sArray[n], new short[0]);
            } else {
                short[] sArray2 = new short[i2 - n2];
                System.arraycopy((Object)sArray, n2, (Object)sArray2, 0, sArray2.length);
                keySet = InterappKeyPanelHandler.createKeySet(sArray[n], sArray2);
            }
            arrayList.add(keySet);
            bl = true;
        }
        this.this$0.updatePanelKeySet((KeySet[])arrayList.toArray(new KeySet[0]));
    }

    @Override
    public void updateParentalSettings(boolean bl, int n) {
        this.this$0.updateParentalSettings(new ParentalSettings(bl, n));
    }

    @Override
    public void updateTvTunerConfig(ITVInterappListener$TvTunerConfig iTVInterappListener$TvTunerConfig) {
        long l = 0L;
        if (iTVInterappListener$TvTunerConfig.audioChannels) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.avFormat) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.avNorm) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.avSource) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.cas) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.ews) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.logoList) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.parentalControl) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.serviceLinking) {
            l |= 1L;
        }
        if (iTVInterappListener$TvTunerConfig.skip) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.sorting) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.subtitle) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmAtsc) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmBws) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmCas) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmDb1) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmDb2) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmDmb) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmDtmb) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmDvb) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmEpg) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmIsdb) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmSls) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmTeletext) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmTxt) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tmVisualAudio) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.tvNorm) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.videoFormat) {
            l |= 0;
        }
        if (iTVInterappListener$TvTunerConfig.visualAudio) {
            l |= 0;
        }
        this.this$0.updateTunerConfig(l);
    }

    @Override
    public void updateTvState(ITVInterappListener$TvState iTVInterappListener$TvState) {
        long l = 0L;
        switch (iTVInterappListener$TvState.muteState) {
            case 1: {
                l |= 1L;
                break;
            }
            case 2: {
                l |= 0;
                break;
            }
            case 3: {
                l |= 0;
                break;
            }
            default: {
                l |= 0L;
            }
        }
        this.this$0.updateActiveTVStationState(l);
    }

    /* synthetic */ TVASIProvider$TVInterappListener(TVASIProvider tVASIProvider, TVASIProvider$1 tVASIProvider$1) {
        this(tVASIProvider);
    }
}

