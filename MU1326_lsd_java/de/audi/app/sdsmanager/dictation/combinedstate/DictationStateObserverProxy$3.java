/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DictationStateObserverProxy$3
implements Runnable {
    private final /* synthetic */ int val$dictationState;
    private final /* synthetic */ DictationStateObserverProxy this$0;

    DictationStateObserverProxy$3(DictationStateObserverProxy dictationStateObserverProxy, int n) {
        this.this$0 = dictationStateObserverProxy;
        this.val$dictationState = n;
    }

    @Override
    public void run() {
        DictationStateObserverProxy.access$000(this.this$0).log(1078071040, "[DictationStateObserverProxy#updateDictationState] dictationState = %1", (long)this.val$dictationState);
        if (DictationStateObserverProxy.access$300(this.this$0) != this.val$dictationState) {
            DictationStateObserverProxy.access$302(this.this$0, this.val$dictationState);
            IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.access$400(this.this$0);
            for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
                try {
                    iDictationStateObserverArray[i2].updateDictationState(this.val$dictationState);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DictationStateObserverProxy.access$000(this.this$0), exception, "[DictationStateObserverProxy#updateDictationState]");
                }
            }
        }
    }
}

