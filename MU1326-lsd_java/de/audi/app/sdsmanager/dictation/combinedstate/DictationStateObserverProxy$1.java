/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DictationStateObserverProxy$1
implements Runnable {
    private final /* synthetic */ IDictationStateObserver val$observer;
    private final /* synthetic */ DictationStateObserverProxy this$0;

    DictationStateObserverProxy$1(DictationStateObserverProxy dictationStateObserverProxy, IDictationStateObserver iDictationStateObserver) {
        this.this$0 = dictationStateObserverProxy;
        this.val$observer = iDictationStateObserver;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        DictationStateObserverProxy.access$000(this.this$0).log(-2137614336, "[DictationStateObserverProxy#addObserver] observer = %1", (Object)this.val$observer);
        DictationStateObserverProxy dictationStateObserverProxy = this.this$0;
        synchronized (dictationStateObserverProxy) {
            DictationStateObserverProxy.access$100(this.this$0).add(this.val$observer);
        }
        try {
            this.val$observer.updateDictationMaxDuration(DictationStateObserverProxy.access$200(this.this$0));
            this.val$observer.updateDictationState(DictationStateObserverProxy.access$300(this.this$0));
        }
        catch (Exception exception) {
            DictationUtil.logException(DictationStateObserverProxy.access$000(this.this$0), exception, "[DictationStateObserverProxy#addObserver]");
        }
    }
}

