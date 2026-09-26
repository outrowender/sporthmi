/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ExecuteRequest;
import de.audi.atip.preset.IAppPresetDefinitionHandler;
import de.audi.atip.preset.IAppPresetExecutionHandler;
import de.audi.atip.preset.IPresetManager;
import de.audi.atip.preset.ITunerNARHandler;
import de.audi.atip.preset.Preset;
import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioPresetHandler$NARMemoryListPresetIndexChangeListener;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.ifc.AbstractRadioListRow;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.esolutions.fw.util.commons.Buffer;
import java.io.Serializable;

public class RadioPresetHandler
implements IAppPresetDefinitionHandler,
IAppPresetExecutionHandler,
ITunerNARHandler {
    private final TunerModels models;
    private final AudioFocusClient audioFocusClient;
    private final ITunerVariantExt variantExt;
    private IPresetManager presetManager;
    private final MemoryListHandler memoryListHandler;
    private TunerObjectContainer tocForLastPresetRequest;

    RadioPresetHandler(TunerBasics tunerBasics, AudioFocusClient audioFocusClient, ITunerVariantExt iTunerVariantExt, MemoryListHandler memoryListHandler) {
        this.models = tunerBasics.getModels();
        this.audioFocusClient = audioFocusClient;
        this.variantExt = iTunerVariantExt;
        this.memoryListHandler = memoryListHandler;
        if (Utilities.isNARBuild()) {
            this.memoryListHandler.setNARMemoryListPresetIndexChangeListener(new RadioPresetHandler$NARMemoryListPresetIndexChangeListener(this, null));
        }
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1770520832, 1753743616, 1820852480, 0x11880100, -1954021120, -813235968, 2005401856, 1938292992, 1921515776, 881328384, 1032323328, 931660032, 1049100544};
    }

    @Override
    public void requestDefinition(DefinitionRequest definitionRequest) {
        EvoListRow evoListRow;
        Object object;
        TunerObjectContainer tunerObjectContainer;
        int n = 0;
        switch (definitionRequest.getModelId()) {
            case 100404: 
            case 100413: {
                tunerObjectContainer = new TunerObjectContainer(TunerProxyManager.getInstance().getAmFmTuner().getActiveStation());
                break;
            }
            case 100407: {
                tunerObjectContainer = new TunerObjectContainer(TunerProxyManager.getInstance().getDABTuner().getActiveStation());
                break;
            }
            case 100414: {
                tunerObjectContainer = new TunerObjectContainer(TunerProxyManager.getInstance().getSDARSTuner().getActiveStation());
                break;
            }
            case 100303: {
                tunerObjectContainer = new TunerObjectContainer(TunerProxyManager.getInstance().getUnifiedTuner().getActiveStation());
                break;
            }
            default: {
                object = (AbstractRadioListRow)this.models.getBaseListModel(definitionRequest.getModelId()).getRow(definitionRequest.getRowId());
                tunerObjectContainer = ((AbstractRadioListRow)object).getTOContainer();
                if (!(object instanceof DabListRow) || !tunerObjectContainer.getDABStation().isEnsemble()) break;
                evoListRow = (DabListRow)object;
                DabStation dabStation = TunerProxyManager.getInstance().getDABTuner().getActiveStation();
                if (((DabListRow)evoListRow).isClosed() && RadioComparators.equals(tunerObjectContainer.getDABStation().ensemble, dabStation.ensemble)) {
                    tunerObjectContainer = new TunerObjectContainer(dabStation);
                    break;
                }
                n = 3;
            }
        }
        this.tocForLastPresetRequest = tunerObjectContainer;
        object = tunerObjectContainer;
        if (Utilities.isNARBuild()) {
            object = new Integer(definitionRequest.getPresetIndex());
        }
        evoListRow = RadioPresetHandler.constructPresetListRow(tunerObjectContainer, this.variantExt);
        definitionRequest.responseDefine(n, (Serializable)object, (PresetListRow)evoListRow, 1);
    }

    @Override
    public void requestExecute(ExecuteRequest executeRequest) {
        Integer n;
        int n2;
        TunerObjectContainer tunerObjectContainer;
        Serializable serializable = executeRequest.getPreset().getData();
        int n3 = 1;
        if (serializable instanceof TunerObjectContainer) {
            TunerObjectContainer tunerObjectContainer2 = (TunerObjectContainer)serializable;
            if (tunerObjectContainer2 != null) {
                TunerProxyManager.getInstance().getActiveTuner().forceStationListUpdate(false);
                this.audioFocusClient.switchSource(0, tunerObjectContainer2.getBand(), tunerObjectContainer2);
                this.models.setActiveList(tunerObjectContainer2.getBand());
                n3 = 0;
            }
        } else if (serializable instanceof Integer && (tunerObjectContainer = this.memoryListHandler.prepareTune(n2 = (n = (Integer)serializable) + 1)) != null) {
            this.audioFocusClient.switchSource(0, tunerObjectContainer.getBand(), tunerObjectContainer);
            n3 = 0;
        }
        executeRequest.responseExecute(n3);
    }

    @Override
    public int getExecutionType() {
        return 1;
    }

    private static PresetListRow constructPresetListRow(TunerObjectContainer tunerObjectContainer, ITunerVariantExt iTunerVariantExt) {
        PresetListRow presetListRow = new PresetListRow();
        Buffer buffer = new Buffer(20);
        switch (tunerObjectContainer.getType()) {
            case 3: {
                AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
                if (Utilities.isPiIgnore()) {
                    buffer.append(aMFMStation.getFrequencyString()).append(' ').append(aMFMStation.getFullName());
                    break;
                }
                buffer.append(tunerObjectContainer.getStationName(true));
                break;
            }
            case 5: {
                StationInfoExt stationInfoExt = tunerObjectContainer.getSDARSService();
                buffer.append(Utilities.getFormatedStationNumber(stationInfoExt.getStationNumber())).append(' ').append(stationInfoExt.shortLabel);
                break;
            }
            default: {
                buffer.append(tunerObjectContainer.getStationName(true));
            }
        }
        presetListRow.setText(2, buffer.toString());
        presetListRow.setText(4, iTunerVariantExt.getBandString(tunerObjectContainer.getBand()));
        return presetListRow;
    }

    @Override
    public void injectPresetManager(IPresetManager iPresetManager) {
        this.presetManager = iPresetManager;
    }

    @Override
    public void presetSavedByPresetPopup(int n, Preset preset) {
        this.memoryListHandler.storeStationAt(this.tocForLastPresetRequest, n);
        this.tocForLastPresetRequest = null;
    }

    private void onNARMemoryListIndexChanged(int n, TunerObjectContainer tunerObjectContainer) {
        if (this.presetManager == null || n > 7) {
            return;
        }
        PresetListRow presetListRow = null;
        int n2 = -1;
        int n3 = 99;
        if (tunerObjectContainer != null) {
            presetListRow = RadioPresetHandler.constructPresetListRow(tunerObjectContainer, this.variantExt);
            n2 = 1;
            n3 = 1;
        }
        DefinitionRequest definitionRequest = new DefinitionRequest(this.presetManager, n2, -1, -1, -1, presetListRow);
        definitionRequest.setPresetIndex(n);
        Integer n4 = new Integer(n);
        this.presetManager.favoriteDefinitionChanged(definitionRequest, 0, n4, presetListRow, n3);
    }

    static /* synthetic */ void access$100(RadioPresetHandler radioPresetHandler, int n, TunerObjectContainer tunerObjectContainer) {
        radioPresetHandler.onNARMemoryListIndexChanged(n, tunerObjectContainer);
    }
}

