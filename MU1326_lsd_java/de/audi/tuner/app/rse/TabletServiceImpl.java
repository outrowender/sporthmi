/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.rse.TabletServiceHandler;
import de.audi.tuner.app.rse.TabletServiceImpl$TabletRequest;
import de.audi.tuner.ifc.ITunerGUIHandler;

public class TabletServiceImpl {
    public final TabletServiceImpl$TabletRequest tabletRequest = new TabletServiceImpl$TabletRequest(this, null);
    private final Logger logger;
    private final TabletServiceHandler handler;
    private final AudioFocusClient audioFocusClient;

    public TabletServiceImpl(TunerBasics tunerBasics, TabletServiceHandler tabletServiceHandler, AudioFocusClient audioFocusClient) {
        this.logger = tunerBasics.getLogger();
        this.handler = tabletServiceHandler;
        this.audioFocusClient = audioFocusClient;
    }

    private void selectListEntry(long l) {
        this.logger.rse.log(-2137614336, "[TabletServiceImpl#selectListEntry], radioId: %1", l);
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler != null) {
            boolean bl = iTunerGUIHandler.tuneById(l, 2);
            this.logger.rse.log(-2137614336, "[TabletServiceImpl#selectListEntry], result %1", bl);
        } else {
            this.logger.rse.log(10000, "[TabletServiceImpl#selectListEntry], guiHandler == null!");
        }
    }

    private void switchSource(int n) {
        this.logger.rse.log(-2137614336, "[TabletServiceImpl#switchSource] : %1", (long)n);
        switch (n) {
            case 1: 
            case 4: 
            case 5: 
            case 7: 
            case 10: 
            case 11: {
                int n2 = this.handler.getCurrentWaveBand();
                if (n2 != n) {
                    this.logger.rse.log(1078071040, "[TabletServiceImpl#switchSource] switch band from: %1 to %2", (long)n2, (long)n);
                    this.audioFocusClient.switchSource(2, n, null);
                } else {
                    this.logger.rse.log(1078071040, "[TabletServiceImpl#switchSource] no audio switch needed - old band(%1) equals new band(%2)", (long)n2, (long)n);
                }
                this.handler.updatedWaveband(n);
                break;
            }
            default: {
                this.logger.rse.log(10000, "[TabletServiceImpl#switchSource] unsupported band: %1", (long)n);
                this.handler.initConnection();
            }
        }
    }

    static /* synthetic */ void access$100(TabletServiceImpl tabletServiceImpl, long l) {
        tabletServiceImpl.selectListEntry(l);
    }

    static /* synthetic */ Logger access$200(TabletServiceImpl tabletServiceImpl) {
        return tabletServiceImpl.logger;
    }

    static /* synthetic */ void access$300(TabletServiceImpl tabletServiceImpl, int n) {
        tabletServiceImpl.switchSource(n);
    }
}

