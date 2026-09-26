/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$1;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$2;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateManager$DsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateManager;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.recognizer.IRecognizerStateObserver;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public final class DictationStateManager
extends AbstractDictationComponent
implements IRecognizerStateObserver,
IDictationStateManager {
    private static final long DICTATION_MAX_DURATION = DictationStateManager.getDictationMaxDuration();
    private volatile DispatcherBase dispatcher;
    private volatile DictationStateObserverProxy observerProxy;
    private volatile boolean dsiAvailable = false;
    private volatile boolean isSpeechInProgress = false;
    private volatile int activationState = 0;
    private volatile int dictationState = 0;

    private static long getDictationMaxDuration() {
        int n = 0;
        String string = System.getProperty("dictation.maxDuration", String.valueOf((long)0));
        try {
            n = (int)Long.parseLong(string);
        }
        catch (Exception exception) {
            n = 0;
        }
        return n;
    }

    public DictationStateManager(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    @Override
    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.dispatcher = dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher();
        this.initObserverProxy();
        dictationComponentManager.getDsiDictationAdapter().addListener(new DictationStateManager$DsiDictationAdapterListener(this, null));
    }

    private void initObserverProxy() {
        DispatcherBase dispatcherBase = this.dictationComponentManager.getDispatcherManager().getExternalTaskDispatcher();
        this.observerProxy = new DictationStateObserverProxy(dispatcherBase, this.log);
        this.observerProxy.updateDictationMaxDuration(DICTATION_MAX_DURATION);
        this.observerProxy.updateDictationState(this.dictationState);
    }

    private void setDsiAvailable(boolean bl) {
        this.dsiAvailable = bl;
        this.setDictationState();
    }

    private void setSpeechInProgress(boolean bl) {
        this.isSpeechInProgress = bl;
        this.setDictationState();
    }

    private void setActivationState(int n) {
        this.activationState = n;
        this.setDictationState();
    }

    private void setDictationState() {
        int n = this.dictationState;
        if (!this.dsiAvailable || this.activationState == 0) {
            this.dictationState = 0;
        } else if (this.activationState == 1) {
            this.dictationState = 1;
        } else if (this.activationState == 2) {
            this.dictationState = 2;
        } else if (this.activationState == 3) {
            this.dictationState = 4;
        }
        if ((this.dictationState == 2 || this.dictationState == 4) && this.isSpeechInProgress) {
            this.dictationState = 3;
        }
        this.observerProxy.updateDictationState(this.dictationState);
        if (this.dictationState == 3 && n != 3) {
            this.observerProxy.indicateRecordingStarted();
        } else if (this.dictationState != 3 && n == 3) {
            this.observerProxy.indicateRecordingStopped();
        }
    }

    @Override
    public void addObserver(IDictationStateObserver iDictationStateObserver) {
        this.log.log(1078071040, "[DictationStateManager#addObserver] observer = %1", (Object)iDictationStateObserver);
        this.observerProxy.addObserver(iDictationStateObserver);
    }

    @Override
    public void removeObserver(IDictationStateObserver iDictationStateObserver) {
        this.log.log(1078071040, "[DictationStateManager#removeObserver] observer = %1", (Object)iDictationStateObserver);
        this.observerProxy.removeObserver(iDictationStateObserver);
    }

    @Override
    public void indicateStartOfSpeech() {
        this.dispatcher.execute(new DictationStateManager$1(this));
    }

    @Override
    public void indicateEndOfSpeech() {
        this.dispatcher.execute(new DictationStateManager$2(this));
    }

    static /* synthetic */ LogChannel access$100(DictationStateManager dictationStateManager) {
        return dictationStateManager.log;
    }

    static /* synthetic */ void access$200(DictationStateManager dictationStateManager, boolean bl) {
        dictationStateManager.setSpeechInProgress(bl);
    }

    static /* synthetic */ LogChannel access$300(DictationStateManager dictationStateManager) {
        return dictationStateManager.log;
    }

    static /* synthetic */ LogChannel access$500(DictationStateManager dictationStateManager) {
        return dictationStateManager.log;
    }

    static /* synthetic */ void access$600(DictationStateManager dictationStateManager, int n) {
        dictationStateManager.setActivationState(n);
    }

    static /* synthetic */ DispatcherBase access$700(DictationStateManager dictationStateManager) {
        return dictationStateManager.dispatcher;
    }

    static /* synthetic */ LogChannel access$800(DictationStateManager dictationStateManager) {
        return dictationStateManager.log;
    }

    static /* synthetic */ void access$900(DictationStateManager dictationStateManager, boolean bl) {
        dictationStateManager.setDsiAvailable(bl);
    }
}

