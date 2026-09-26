/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DictationStateObserverProxy$4
implements Runnable {
    private final /* synthetic */ long val$dictationMaxDuration;
    private final /* synthetic */ DictationStateObserverProxy this$0;

    DictationStateObserverProxy$4(DictationStateObserverProxy dictationStateObserverProxy, long l) {
        this.this$0 = dictationStateObserverProxy;
        this.val$dictationMaxDuration = l;
    }

    @Override
    public void run() {
        DictationStateObserverProxy.access$000(this.this$0).log(-2137614336, "[DictationStateObserverProxy#updateDictationMaxDuration] dictationMaxDuration = %1", this.val$dictationMaxDuration);
        if (DictationStateObserverProxy.access$200(this.this$0) != this.val$dictationMaxDuration) {
            DictationStateObserverProxy.access$202(this.this$0, this.val$dictationMaxDuration);
            IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.access$400(this.this$0);
            for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
                try {
                    iDictationStateObserverArray[i2].updateDictationMaxDuration(this.val$dictationMaxDuration);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DictationStateObserverProxy.access$000(this.this$0), exception, "[DictationStateObserverProxy#updateDictationMaxDuration]");
                }
            }
        }
    }
}

