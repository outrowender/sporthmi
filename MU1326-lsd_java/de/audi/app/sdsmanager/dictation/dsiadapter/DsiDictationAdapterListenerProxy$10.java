/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapterListenerProxy;
import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;

class DsiDictationAdapterListenerProxy$10
implements Runnable {
    private final /* synthetic */ String val$pLanguage;
    private final /* synthetic */ String val$pFallbackLanguage;
    private final /* synthetic */ DsiDictationAdapterListenerProxy this$0;

    DsiDictationAdapterListenerProxy$10(DsiDictationAdapterListenerProxy dsiDictationAdapterListenerProxy, String string, String string2) {
        this.this$0 = dsiDictationAdapterListenerProxy;
        this.val$pLanguage = string;
        this.val$pFallbackLanguage = string2;
    }

    @Override
    public void run() {
        DsiDictationAdapterListenerProxy.access$000(this.this$0).log(1078071040, "[DsiDictationAdapterListenerProxy#updateLanguage] language = %1, fallbackLanguage = %2", (Object)this.val$pLanguage, (Object)this.val$pFallbackLanguage);
        if (!DsiDictationAdapterListenerProxy.access$200(this.this$0).equals(this.val$pLanguage) || !DsiDictationAdapterListenerProxy.access$300(this.this$0).equals(this.val$pFallbackLanguage)) {
            DsiDictationAdapterListenerProxy.access$202(this.this$0, this.val$pLanguage);
            DsiDictationAdapterListenerProxy.access$302(this.this$0, this.val$pFallbackLanguage);
            IDsiDictationAdapterListener[] iDsiDictationAdapterListenerArray = DsiDictationAdapterListenerProxy.access$800(this.this$0);
            for (int i2 = 0; i2 < iDsiDictationAdapterListenerArray.length; ++i2) {
                try {
                    iDsiDictationAdapterListenerArray[i2].updateLanguage(this.val$pLanguage, this.val$pFallbackLanguage);
                    continue;
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapterListenerProxy.access$000(this.this$0), exception, "[DsiDictationAdapterListenerProxy#updateLanguage]");
                }
            }
        }
    }
}

