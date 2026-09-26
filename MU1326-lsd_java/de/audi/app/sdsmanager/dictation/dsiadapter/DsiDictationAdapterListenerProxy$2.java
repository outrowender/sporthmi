/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;

class DsiDictationAdapterListenerProxy$2
implements Runnable {
    private final /* synthetic */ IDsiDictationAdapterListener val$listener;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$2(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$listener = iDsiDictationAdapterListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(-2137614336, "[DsiDictationAdapterListenerProxy#removeListener] listener = %1", (Object)this.val$listener);
        DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy = this.this$0;
        synchronized (dsiDictationAdapterListenerProxy) {
            DsiDictationAdapterListenerProxy.access$100(this.this$0).remove(this.val$listener);
        }
    }
}

