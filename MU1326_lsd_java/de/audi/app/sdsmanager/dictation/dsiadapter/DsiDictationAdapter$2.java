/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.SetLanguageCommand;

class DsiDictationAdapter$2
implements Runnable {
    private final /* synthetic */ String val$pFallbackLanguage;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$2(DsiDictationAdapter dsiDictationAdapter, String string) {
        this.this$0 = dsiDictationAdapter;
        this.val$pFallbackLanguage = string;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$1101(this.this$0).log(1078071040, "[DsiDictationAdapter#requestSetFallbackLanguage] fallbackLanguage = %1", (Object)this.val$pFallbackLanguage);
        if (DsiDictationAdapter.access$300(this.this$0, 1)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestSetFallbackLanguage]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseSetFallbackLanguage(3);
        } else {
            DsiDictationAdapter.access$800(this.this$0, 1);
            SetLanguageCommand.schedule(DsiDictationAdapter.access$1201(this.this$0), DsiDictationAdapter.access$1000(this.this$0), this.val$pFallbackLanguage, true);
        }
    }
}

