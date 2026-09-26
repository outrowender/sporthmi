/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$14
implements Runnable {
    private final /* synthetic */ boolean val$pDsiAvailable;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$14(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, boolean bl) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$pDsiAvailable = bl;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#updateDsiAvailability] dsiAvaiable = %1", this.val$pDsiAvailable);
        if (DsiDictationAdapterListenerProxy.access$700(this.this$0) != this.val$pDsiAvailable) {
            DsiDictationAdapterListenerProxy.access$702(this.this$0, this.val$pDsiAvailable);
            IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
            for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                try {
                    iDsiDictationAdapterListenerArray[i2].updateDsiAvailability(this.val$pDsiAvailable);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#updateDsiAvailability]");
                }
            }
        }
    }
}

