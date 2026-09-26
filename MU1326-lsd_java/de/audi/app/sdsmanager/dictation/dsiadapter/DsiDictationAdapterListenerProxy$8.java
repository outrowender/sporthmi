/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import java.util.LinkedList;

class DsiDictationAdapterListenerProxy$8
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ LinkedList val$dictationText;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$8(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, int n, LinkedList linkedList) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$result = n;
        this.val$dictationText = linkedList;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#responseProcessVoiceData] result = %1", (long)this.val$result);
        IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
        for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
            try {
                iDsiDictationAdapterListenerArray[i2].responseProcessVoiceData(this.val$result, this.val$dictationText);
                continue;
            }
            catch (Exception exception) {
                DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#responseProcessVoiceData]");
            }
        }
    }
}

