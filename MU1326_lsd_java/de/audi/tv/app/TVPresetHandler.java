/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.tv.app.TVPresetStation;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.lists.AbstractTVStationRow;
import java.io.Serializable;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVPresetHandler {
    private final TVEnv env;
    private final LogChannel log;
    private final DSITV dsi;
    private final AudioFocusClient audioFocusClient;
    private final IParentActivator parentActivator;
    private final ISourceActivator sourceActivator;
    private final int[] modelIds;
    public final IAppPresetDefinitionHandler definitionHandler = new PresetDefinitionHandler();
    public final IAppPresetExecutionHandler executionHandler = new PresetExecutionHandler();
    public final TVEventDefaultListener eventListener = new StatusListener();
    public final DSICallListener dsiDownListener = new DSIDownListener();
    public final TVListener tvListener = new TVListener();
    private ServiceInfo serviceToTune = null;
    private Object requestMutex = new Object();
    private boolean hasAudioFocusOnMu = false;
    private boolean isTvActive = false;
    private int curSource = -1;
    private ServiceInfo tuneOnChangeToTV = null;
    private ServiceInfo lastTunedService = null;

    public TVPresetHandler(TVEnv tVEnv, DSITV dSITV, AudioFocusClient audioFocusClient, int[] nArray, IParentActivator iParentActivator, ISourceActivator iSourceActivator) {
        this.env = tVEnv;
        this.log = tVEnv.lcHMI;
        this.dsi = dSITV;
        this.audioFocusClient = audioFocusClient;
        this.sourceActivator = iSourceActivator;
        this.parentActivator = iParentActivator != null ? iParentActivator : new IParentActivator(){

            public void activateParent() {
            }
        };
        this.modelIds = new int[nArray.length + 2];
        this.modelIds[0] = 2600000;
        this.modelIds[1] = 2600123;
        System.arraycopy((Object)nArray, 0, (Object)this.modelIds, 2, nArray.length);
    }

    private static ServiceInfo createDsiService(TVPresetStation tVPresetStation) {
        return new ServiceInfo(tVPresetStation.namePID, tVPresetStation.servicePID, tVPresetStation.name, tVPresetStation.sType, 0);
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void switchSource(int n) {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                if (n == 1 && TVPresetHandler.this.tuneOnChangeToTV != null && TVPresetHandler.this.curSource == 0) {
                    TVPresetHandler.this.dsi.changeService(TVPresetHandler.this.tuneOnChangeToTV, true);
                    TVPresetHandler.this.tuneOnChangeToTV = null;
                }
            }
        }
    }

    private class StatusListener
    extends TVEventDefaultListener {
        private StatusListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onEsmEntered() {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                TVPresetHandler.this.isTvActive = false;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onEsmLeft() {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                TVPresetHandler.this.isTvActive = true;
                if (TVPresetHandler.this.serviceToTune != null) {
                    TVPresetHandler.this.dsi.changeService(TVPresetHandler.this.serviceToTune, true);
                    TVPresetHandler.this.serviceToTune = null;
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onMuGotTvAudioFocus() {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                TVPresetHandler.this.hasAudioFocusOnMu = true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onMuLostTvAudioFocus() {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                TVPresetHandler.this.hasAudioFocusOnMu = false;
            }
        }
    }

    private class DSIDownListener
    extends DSICallListener {
        private DSIDownListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void switchSource(int n, boolean bl) {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                TVPresetHandler.this.curSource = n;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            Object object = TVPresetHandler.this.requestMutex;
            synchronized (object) {
                TVPresetHandler.this.lastTunedService = serviceInfo;
            }
        }
    }

    public static interface IParentActivator {
        public void activateParent();
    }

    private class PresetExecutionHandler
    implements IAppPresetExecutionHandler {
        private PresetExecutionHandler() {
        }

        public int getExecutionType() {
            return 7;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void requestExecute(ExecuteRequest executeRequest) {
            Serializable serializable = executeRequest.getPreset().getData();
            if (serializable instanceof TVPresetStation) {
                ServiceInfo serviceInfo = TVPresetHandler.createDsiService((TVPresetStation)serializable);
                Object object = TVPresetHandler.this.requestMutex;
                synchronized (object) {
                    TVPresetHandler.this.log.log(10000000, "[TVPresetHandler.requestExecute] service: %1", (Object)serviceInfo);
                    if (TVPresetHandler.this.isTvActive) {
                        if (TVPresetHandler.this.curSource != 0) {
                            TVPresetHandler.this.dsi.changeService(serviceInfo, true);
                            TVPresetHandler.this.tuneOnChangeToTV = serviceInfo;
                            TVPresetHandler.this.sourceActivator.activate(0);
                        } else {
                            TVPresetHandler.this.dsi.changeService(serviceInfo, true);
                        }
                        if (!TVPresetHandler.this.hasAudioFocusOnMu) {
                            TVPresetHandler.this.audioFocusClient.activateTVAudio(0);
                            TVPresetHandler.this.log.log(10000000, "[TVPresetHandler.requestExecute] TV audiofocus for MU forced!");
                        }
                    } else {
                        TVPresetHandler.this.serviceToTune = serviceInfo;
                        if (!TVPresetHandler.this.hasAudioFocusOnMu) {
                            TVPresetHandler.this.audioFocusClient.activateTVAudio(0);
                            TVPresetHandler.this.sourceActivator.activate(0);
                            TVPresetHandler.this.parentActivator.activateParent();
                        }
                    }
                }
                executeRequest.responseExecute(0);
            } else {
                TVPresetHandler.this.log.log(10000000, "[TVPresetHandler.requestExecute] error");
                executeRequest.responseExecute(1);
            }
        }
    }

    private class PresetDefinitionHandler
    implements IAppPresetDefinitionHandler {
        private PresetDefinitionHandler() {
        }

        public int getType() {
            return 1;
        }

        public int[] getModelIds() {
            return TVPresetHandler.this.modelIds;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void requestDefinition(DefinitionRequest definitionRequest) {
            Object object;
            int n = definitionRequest.getModelId();
            int n2 = definitionRequest.getRowId();
            ServiceInfo serviceInfo = null;
            if (n == 2600123) {
                object = TVPresetHandler.this.requestMutex;
                synchronized (object) {
                    serviceInfo = TVPresetHandler.this.lastTunedService;
                }
            } else {
                object = TVPresetHandler.this.env.getBaseListModel(n).getRow(n2);
                if (object instanceof AbstractTVStationRow) {
                    serviceInfo = ((AbstractTVStationRow)object).service;
                }
            }
            TVPresetHandler.this.log.log(10000000, "[TVPresetHandler.requestDefinition] model %2, service: %1", (Object)serviceInfo, (long)n);
            if (serviceInfo != null) {
                object = new PresetListRow();
                ((EvoListRow)object).setText(2, serviceInfo.name);
                ((EvoListRow)object).setText(4, "TV");
                definitionRequest.responseDefine(0, new TVPresetStation(serviceInfo), (PresetListRow)object, 7);
            } else {
                definitionRequest.responseDefine(1, null, null, 99);
            }
        }
    }
}

