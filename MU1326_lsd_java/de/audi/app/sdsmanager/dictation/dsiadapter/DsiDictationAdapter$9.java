/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;

class DsiDictationAdapter$9
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$9(DsiDictationAdapter dsiDictationAdapter, int n) {
        this.this$0 = dsiDictationAdapter;
        this.val$result = n;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$3301(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleActivateDictationResult] result = %1", (long)this.val$result);
        if (DsiDictationAdapter.access$300(this.this$0, 3)) {
            if (this.val$result == 0) {
                DsiDictationAdapter.access$2400(this.this$0, 1);
            } else {
                DsiDictationAdapter.access$2400(this.this$0, 0);
            }
            DsiDictationAdapter.access$700(this.this$0).responseActivateDictation(this.val$result);
            DsiDictationAdapter.access$1500(this.this$0, 3);
        } else {
            DsiDictationAdapter.access$3401(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleActivateDictationResult] Discarding obsolete result.");
        }
    }
}

