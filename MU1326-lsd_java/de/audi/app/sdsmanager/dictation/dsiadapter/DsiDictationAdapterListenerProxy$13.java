/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$13
implements Runnable {
    private final /* synthetic */ ServiceProviderInfo val$pServiceProviderInfo;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$13(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, ServiceProviderInfo serviceProviderInfo) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$pServiceProviderInfo = serviceProviderInfo;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#updateServiceProviderInfo] serviceProviderInfo = %1", (Object)this.val$pServiceProviderInfo);
        if (!DsiDictationAdapterListenerProxy.access$600(this.this$0).equals(this.val$pServiceProviderInfo)) {
            DsiDictationAdapterListenerProxy.access$602(this.this$0, this.val$pServiceProviderInfo);
            IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
            for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                try {
                    iDsiDictationAdapterListenerArray[i2].updateServiceProviderInfo(this.val$pServiceProviderInfo);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#updateServiceProviderInfo]");
                }
            }
        }
    }
}

