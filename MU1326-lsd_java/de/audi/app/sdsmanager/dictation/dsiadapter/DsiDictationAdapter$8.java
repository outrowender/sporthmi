/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;

class DsiDictationAdapter$8
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ String val$languageCode;
    private final /* synthetic */ boolean val$isFallbackLanguage;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$8(DsiDictationAdapter dsiDictationAdapter, int n, String string, boolean bl) {
        this.this$0 = dsiDictationAdapter;
        this.val$result = n;
        this.val$languageCode = string;
        this.val$isFallbackLanguage = bl;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$2901(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleSetLanguageResult] result = %1, languageCode = %2, isFallbackLanguage = %3", (Object)String.valueOf(this.val$result), (Object)this.val$languageCode, (Object)String.valueOf(this.val$isFallbackLanguage));
        if (this.val$result == 0) {
            String string = DsiDictationAdapter.access$3000(this.this$0);
            String string2 = DsiDictationAdapter.access$3100(this.this$0);
            if (!this.val$isFallbackLanguage) {
                string = this.val$languageCode;
            } else {
                string2 = this.val$languageCode;
            }
            DsiDictationAdapter.access$3200(this.this$0, string, string2);
        }
        if (!this.val$isFallbackLanguage) {
            DsiDictationAdapter.access$700(this.this$0).responseSetLanguage(this.val$result);
        } else {
            DsiDictationAdapter.access$700(this.this$0).responseSetFallbackLanguage(this.val$result);
        }
        DsiDictationAdapter.access$1500(this.this$0, this.val$isFallbackLanguage ? 1 : 0);
    }
}

