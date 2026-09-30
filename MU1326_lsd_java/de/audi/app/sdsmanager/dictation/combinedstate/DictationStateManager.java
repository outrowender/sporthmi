/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.DictationComponentManager;
import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateManager;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.component.AbstractDictationComponent;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterEmptyListener;
import de.audi.app.sdsmanager.dictation.osgi.BundleEnvironment;
import de.audi.app.sdsmanager.dictation.recognizer.IRecognizerStateObserver;
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
        long l = 19500L;
        String string = System.getProperty("dictation.maxDuration", String.valueOf(19500L));
        try {
            l = Long.parseLong(string);
        }
        catch (Exception exception) {
            l = 19500L;
        }
        return l;
    }

    public DictationStateManager(BundleEnvironment bundleEnvironment) {
        super(bundleEnvironment, "App.SDS.Dictation");
    }

    public void init(DictationComponentManager dictationComponentManager) {
        super.init(dictationComponentManager);
        this.dispatcher = dictationComponentManager.getDispatcherManager().getInternalTaskDispatcher();
        this.initObserverProxy();
        dictationComponentManager.getDsiDictationAdapter().addListener(new DsiDictationAdapterListener());
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

    public void addObserver(IDictationStateObserver iDictationStateObserver) {
        this.log.log(1000000, "[DictationStateManager#addObserver] observer = %1", (Object)iDictationStateObserver);
        this.observerProxy.addObserver(iDictationStateObserver);
    }

    public void removeObserver(IDictationStateObserver iDictationStateObserver) {
        this.log.log(1000000, "[DictationStateManager#removeObserver] observer = %1", (Object)iDictationStateObserver);
        this.observerProxy.removeObserver(iDictationStateObserver);
    }

    public void indicateStartOfSpeech() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DictationStateManager.this.log.log(1000000, "[DictationStateManager#indicateStartOfSpeech]");
                DictationStateManager.this.setSpeechInProgress(true);
            }
        });
    }

    public void indicateEndOfSpeech() {
        this.dispatcher.execute(new Runnable(){

            public void run() {
                DictationStateManager.this.log.log(1000000, "[DictationStateManager#indicateEndOfSpeech]");
                DictationStateManager.this.setSpeechInProgress(false);
            }
        });
    }

    private class DsiDictationAdapterListener
    extends DsiDictationAdapterEmptyListener {
        private DsiDictationAdapterListener() {
        }

        public void updateActivationState(final int n) {
            DictationStateManager.this.dispatcher.execute(new Runnable(){

                public void run() {
                    DictationStateManager.this.log.log(10000000, "[DictationStateManager#updateActivationState] activationState = %1", (long)n);
                    DictationStateManager.this.setActivationState(n);
                }
            });
        }

        public void updateDsiAvailability(final boolean bl) {
            DictationStateManager.this.dispatcher.execute(new Runnable(){

                public void run() {
                    DictationStateManager.this.log.log(10000000, "[DictationStateManager#updateDsiAvailability] dsiAvailable = %1", bl);
                    DictationStateManager.this.setDsiAvailable(bl);
                }
            });
        }
    }
}

