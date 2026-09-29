/*
 * Decompiled with CFR 0.152.
 */
package de.eso.widgets.preset;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.model.PresetListRow;
import de.audi.atip.preset.DefinitionRequest;
import de.audi.atip.preset.ITunerNARHandler;
import de.audi.atip.preset.Preset;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.eso.widgets.preset.PresetManager;
import de.eso.widgets.preset.PresetManagerNAR$1;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import java.io.Serializable;
import org.osgi.framework.BundleContext;

public class PresetManagerNAR
extends PresetManager {
    public PresetManagerNAR(HMITerminalEvo hMITerminalEvo, BundleContext bundleContext, IFrameworkAccess iFrameworkAccess) {
        super(hMITerminalEvo, bundleContext, iFrameworkAccess);
    }

    @Override
    public void saveToPersistence(int n) {
        super.saveToPersistence(n);
        ITunerNARHandler iTunerNARHandler = this.presetDefinitionReg.getTunerNARHandler();
        if (iTunerNARHandler != null) {
            Preset preset = this.getPresetStorageProvider().getPersistedPresetPopupData(n).getPreset();
            iTunerNARHandler.presetSavedByPresetPopup(n, preset);
        }
    }

    @Override
    public void favoriteDefinitionChanged(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(false, new PresetManagerNAR$1(this, definitionRequest, n, serializable, presetListRow, n2)));
    }

    @Override
    protected void responseDefineEvent(DefinitionRequest definitionRequest, int n, Serializable serializable, PresetListRow presetListRow, int n2) {
        if (n2 != 1) {
            n = 2;
        }
        super.responseDefineEvent(definitionRequest, n, serializable, presetListRow, n2);
    }
}

