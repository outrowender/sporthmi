/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;

class DictationStateObserverProxy$2
implements Runnable {
    private final /* synthetic */ IDictationStateObserver val$observer;
    private final /* synthetic */ DictationStateObserverProxy this$0;

    DictationStateObserverProxy$2(DictationStateObserverProxy dictationStateObserverProxy, IDictationStateObserver iDictationStateObserver) {
        this.this$0 = dictationStateObserverProxy;
        this.val$observer = iDictationStateObserver;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        DictationStateObserverProxy.access$000(this.this$0).log(-2137614336, "[DictationStateObserverProxy#removeObserver] observer = %1", (Object)this.val$observer);
        DictationStateObserverProxy dictationStateObserverProxy = this.this$0;
        synchronized (dictationStateObserverProxy) {
            DictationStateObserverProxy.access$100(this.this$0).remove(this.val$observer);
        }
    }
}

