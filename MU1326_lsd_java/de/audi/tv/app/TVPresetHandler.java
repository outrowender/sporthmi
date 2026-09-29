/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.tv.app.TVPresetHandler$1;
import de.audi.tv.app.TVPresetHandler$DSIDownListener;
import de.audi.tv.app.TVPresetHandler$IParentActivator;
import de.audi.tv.app.TVPresetHandler$PresetDefinitionHandler;
import de.audi.tv.app.TVPresetHandler$PresetExecutionHandler;
import de.audi.tv.app.TVPresetHandler$StatusListener;
import de.audi.tv.app.TVPresetHandler$TVListener;
import de.audi.tv.app.TVPresetStation;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.interapp.ISourceActivator;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVPresetHandler {
    private final TVEnv env;
    private final LogChannel log;
    private final DSITV dsi;
    private final AudioFocusClient audioFocusClient;
    private final TVPresetHandler$IParentActivator parentActivator;
    private final ISourceActivator sourceActivator;
    private final int[] modelIds;
    public final IAppPresetDefinitionHandler definitionHandler = new TVPresetHandler$PresetDefinitionHandler(this, null);
    public final IAppPresetExecutionHandler executionHandler = new TVPresetHandler$PresetExecutionHandler(this, null);
    public final TVEventDefaultListener eventListener = new TVPresetHandler$StatusListener(this, null);
    public final DSICallListener dsiDownListener = new TVPresetHandler$DSIDownListener(this, null);
    public final TVPresetHandler$TVListener tvListener = new TVPresetHandler$TVListener(this, null);
    private ServiceInfo serviceToTune = null;
    private Object requestMutex = new Object();
    private boolean hasAudioFocusOnMu = false;
    private boolean isTvActive = false;
    private int curSource = -1;
    private ServiceInfo tuneOnChangeToTV = null;
    private ServiceInfo lastTunedService = null;

    public TVPresetHandler(TVEnv tVEnv, DSITV dSITV, AudioFocusClient audioFocusClient, int[] nArray, TVPresetHandler$IParentActivator tVPresetHandler$IParentActivator, ISourceActivator iSourceActivator) {
        this.env = tVEnv;
        this.log = tVEnv.lcHMI;
        this.dsi = dSITV;
        this.audioFocusClient = audioFocusClient;
        this.sourceActivator = iSourceActivator;
        this.parentActivator = tVPresetHandler$IParentActivator != null ? tVPresetHandler$IParentActivator : new TVPresetHandler$1(this);
        this.modelIds = new int[nArray.length + 2];
        this.modelIds[0] = 1085024000;
        this.modelIds[1] = -1146345728;
        System.arraycopy((Object)nArray, 0, (Object)this.modelIds, 2, nArray.length);
    }

    private static ServiceInfo createDsiService(TVPresetStation tVPresetStation) {
        return new ServiceInfo(tVPresetStation.namePID, tVPresetStation.servicePID, tVPresetStation.name, tVPresetStation.sType, 0);
    }

    static /* synthetic */ int[] access$500(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.modelIds;
    }

    static /* synthetic */ Object access$600(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.requestMutex;
    }

    static /* synthetic */ ServiceInfo access$700(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.lastTunedService;
    }

    static /* synthetic */ TVEnv access$800(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.env;
    }

    static /* synthetic */ LogChannel access$900(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.log;
    }

    static /* synthetic */ ServiceInfo access$1000(TVPresetStation tVPresetStation) {
        return TVPresetHandler.createDsiService(tVPresetStation);
    }

    static /* synthetic */ boolean access$1100(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.isTvActive;
    }

    static /* synthetic */ int access$1200(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.curSource;
    }

    static /* synthetic */ DSITV access$1300(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.dsi;
    }

    static /* synthetic */ ServiceInfo access$1402(TVPresetHandler tVPresetHandler, ServiceInfo serviceInfo) {
        tVPresetHandler.tuneOnChangeToTV = serviceInfo;
        return tVPresetHandler.tuneOnChangeToTV;
    }

    static /* synthetic */ ISourceActivator access$1500(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.sourceActivator;
    }

    static /* synthetic */ boolean access$1600(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.hasAudioFocusOnMu;
    }

    static /* synthetic */ AudioFocusClient access$1700(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.audioFocusClient;
    }

    static /* synthetic */ ServiceInfo access$1802(TVPresetHandler tVPresetHandler, ServiceInfo serviceInfo) {
        tVPresetHandler.serviceToTune = serviceInfo;
        return tVPresetHandler.serviceToTune;
    }

    static /* synthetic */ TVPresetHandler$IParentActivator access$1900(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.parentActivator;
    }

    static /* synthetic */ boolean access$1102(TVPresetHandler tVPresetHandler, boolean bl) {
        tVPresetHandler.isTvActive = bl;
        return tVPresetHandler.isTvActive;
    }

    static /* synthetic */ ServiceInfo access$1800(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.serviceToTune;
    }

    static /* synthetic */ boolean access$1602(TVPresetHandler tVPresetHandler, boolean bl) {
        tVPresetHandler.hasAudioFocusOnMu = bl;
        return tVPresetHandler.hasAudioFocusOnMu;
    }

    static /* synthetic */ ServiceInfo access$1400(TVPresetHandler tVPresetHandler) {
        return tVPresetHandler.tuneOnChangeToTV;
    }

    static /* synthetic */ int access$1202(TVPresetHandler tVPresetHandler, int n) {
        tVPresetHandler.curSource = n;
        return tVPresetHandler.curSource;
    }

    static /* synthetic */ ServiceInfo access$702(TVPresetHandler tVPresetHandler, ServiceInfo serviceInfo) {
        tVPresetHandler.lastTunedService = serviceInfo;
        return tVPresetHandler.lastTunedService;
    }
}

