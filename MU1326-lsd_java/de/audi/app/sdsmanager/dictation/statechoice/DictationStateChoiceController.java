/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.statechoice;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.statechoice.IDictationStateChoiceController;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public final class DictationStateChoiceController
extends AbstractDictationComponent
implements IDictationStateChoiceController,
IDictationStateObserver {
    private final ChoiceModelApp choiceModel;

    public DictationStateChoiceController(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
        this.choiceModel = this.framework.getHmiServiceApp().getChoiceModel(3880);
    }

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        dictationComponentManager.getDictationStateManager().addObserver(this);
    }

    private void setDictationState(int n) {
        this.log.log(-2137614336, "[DictationStateChoiceController#setDictationState] dictationState = %1", (long)n);
        this.choiceModel.setValue(n);
    }

    @Override
    public void updateDictationState(int n) {
        this.log.log(-2137614336, "[DictationStateChoiceController#updateDictationState] dictationState = %1");
        this.setDictationState(n);
    }

    @Override
    public void updateDictationMaxDuration(long l) {
    }

    @Override
    public void indicateRecordingStarted() {
    }

    @Override
    public void indicateRecordingStopped() {
    }
}

