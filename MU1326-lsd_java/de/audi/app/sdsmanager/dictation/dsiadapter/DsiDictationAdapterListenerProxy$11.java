/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$11
implements Runnable {
    private final /* synthetic */ String val$pUserId;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$11(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, String string) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$pUserId = string;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#updateUserId] userId = %1", (Object)this.val$pUserId);
        if (!DsiDictationAdapterListenerProxy.access$400(this.this$0).equals(this.val$pUserId)) {
            DsiDictationAdapterListenerProxy.access$402(this.this$0, this.val$pUserId);
            IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
            for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                try {
                    iDsiDictationAdapterListenerArray[i2].updateUserId(this.val$pUserId);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#updateUserId]");
                }
            }
        }
    }
}

