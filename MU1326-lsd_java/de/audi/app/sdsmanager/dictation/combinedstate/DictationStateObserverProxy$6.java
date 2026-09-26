/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.combinedstate;

import de.audi.app.sdsmanager.dictation.combinedstate.DictationStateObserverProxy;
import de.audi.app.sdsmanager.dictation.combinedstate.IDictationStateObserver;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DictationStateObserverProxy$6
implements Runnable {
    private final /* synthetic */ DictationStateObserverProxy this$0;

    DictationStateObserverProxy$6(DictationStateObserverProxy dictationStateObserverProxy) {
        this.this$0 = dictationStateObserverProxy;
    }

    @Override
    public void run() {
        DictationStateObserverProxy.access$000(this.this$0).log(1078071040, "[DictationStateObserverProxy#indicateRecordingStopped]");
        IDictationStateObserver[] iDictationStateObserverArray = DictationStateObserverProxy.access$400(this.this$0);
        for (int i2 = 0; i2 < iDictationStateObserverArray.length; ++i2) {
            try {
                iDictationStateObserverArray[i2].indicateRecordingStopped();
                continue;
            }
            catch (Exception exception) {
                DictationUtil.logException(DictationStateObserverProxy.access$000(this.this$0), exception, "[DictationStateObserverProxy#indicateRecordingStopped]");
            }
        }
    }
}

