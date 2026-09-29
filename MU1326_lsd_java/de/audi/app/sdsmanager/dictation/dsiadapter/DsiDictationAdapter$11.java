/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;

class DsiDictationAdapter$11
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$11(DsiDictationAdapter dsiDictationAdapter, int n) {
        this.this$0 = dsiDictationAdapter;
        this.val$result = n;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$4001(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleStartDictationResult] result = %1", (long)this.val$result);
        if (DsiDictationAdapter.access$300(this.this$0, 4)) {
            if (this.val$result == 0) {
                DsiDictationAdapter.access$2400(this.this$0, 2);
            } else {
                DsiDictationAdapter.access$2400(this.this$0, 0);
            }
            DsiDictationAdapter.access$700(this.this$0).responseStartDictation(this.val$result);
            DsiDictationAdapter.access$1500(this.this$0, 4);
        } else {
            DsiDictationAdapter.access$4101(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleStartDictationResult] Discarding obsolete result.");
        }
    }
}

