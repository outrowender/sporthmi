/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.SetLanguageCommand;

class DsiDictationAdapter$1
implements Runnable {
    private final /* synthetic */ String val$pLanguage;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$1(DsiDictationAdapter dsiDictationAdapter, String string) {
        this.this$0 = dsiDictationAdapter;
        this.val$pLanguage = string;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$201(this.this$0).log(1078071040, "[DsiDictationAdapter#requestSetLanguage] language = %1", (Object)this.val$pLanguage);
        if (DsiDictationAdapter.access$300(this.this$0, 0)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestSetLanguage]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseSetLanguage(3);
        } else {
            DsiDictationAdapter.access$800(this.this$0, 0);
            SetLanguageCommand.schedule(DsiDictationAdapter.access$901(this.this$0), DsiDictationAdapter.access$1000(this.this$0), this.val$pLanguage, false);
        }
    }
}

