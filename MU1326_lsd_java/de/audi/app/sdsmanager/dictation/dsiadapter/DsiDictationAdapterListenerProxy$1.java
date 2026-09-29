/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$1
implements Runnable {
    private final /* synthetic */ IDsiDictationAdapterListener val$listener;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$1(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, IDsiDictationAdapterListener iDsiDictationAdapterListener) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$listener = iDsiDictationAdapterListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(-2137614336, "[DsiDictationAdapterListenerProxy#addListener] listener = %1", (Object)this.val$listener);
        DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy = this.this$0;
        synchronized (dsiDictationAdapterListenerProxy) {
            DsiDictationAdapterListenerProxy.access$100(this.this$0).add(this.val$listener);
        }
        try {
            this.val$listener.updateLanguage(DsiDictationAdapterListenerProxy.access$200(this.this$0), DsiDictationAdapterListenerProxy.access$300(this.this$0));
            this.val$listener.updateUserId(DsiDictationAdapterListenerProxy.access$400(this.this$0));
            this.val$listener.updateActivationState(DsiDictationAdapterListenerProxy.access$500(this.this$0));
            this.val$listener.updateServiceProviderInfo(DsiDictationAdapterListenerProxy.access$600(this.this$0));
            this.val$listener.updateDsiAvailability(DsiDictationAdapterListenerProxy.access$700(this.this$0));
        }
        catch (Exception exception) {
            DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#addListener]");
        }
    }
}

