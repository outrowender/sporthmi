/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$12
implements Runnable {
    private final /* synthetic */ int val$pActivationState;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$12(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, int n) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$pActivationState = n;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#updateActivationState] activationState = %1", (long)this.val$pActivationState);
        if (DsiDictationAdapterListenerProxy.access$500(this.this$0) != this.val$pActivationState) {
            DsiDictationAdapterListenerProxy.access$502(this.this$0, this.val$pActivationState);
            IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
            for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                try {
                    iDsiDictationAdapterListenerArray[i2].updateActivationState(this.val$pActivationState);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#updateActivationState]");
                }
            }
        }
    }
}

