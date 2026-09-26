/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$5
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$5(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, int n) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$result = n;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#responseSetUserId] result = %1", (long)this.val$result);
        IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
        for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
            try {
                iDsiDictationAdapterListenerArray[i2].responseSetUserId(this.val$result);
                continue;
            }
            catch (Exception exception) {
                DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#responseSetUserId]");
            }
        }
    }
}

