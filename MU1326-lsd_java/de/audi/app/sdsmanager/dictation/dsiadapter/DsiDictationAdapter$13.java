/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;

class DsiDictationAdapter$13
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$13(DsiDictationAdapter dsiDictationAdapter, int n) {
        this.this$0 = dsiDictationAdapter;
        this.val$result = n;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$4401(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleDictationResult] result = %1", (long)this.val$result);
        if (DsiDictationAdapter.access$400(this.this$0) == 2) {
            DsiDictationAdapter.access$1902(this.this$0, this.val$result);
        } else {
            DsiDictationAdapter.access$4501(this.this$0).log(-1601830656, "[DsiDictationAdapter#handleDictationResult] Invalid state, ignoring call.");
        }
    }
}

