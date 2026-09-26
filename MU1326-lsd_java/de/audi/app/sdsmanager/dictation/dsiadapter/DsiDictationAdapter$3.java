/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;

class DsiDictationAdapter$3
implements Runnable {
    private final /* synthetic */ String val$pUserId;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$3(DsiDictationAdapter dsiDictationAdapter, String string) {
        this.this$0 = dsiDictationAdapter;
        this.val$pUserId = string;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$1301(this.this$0).log(1078071040, "[DsiDictationAdapter#requestSetUserId] userId = %1", (Object)this.val$pUserId);
        if (DsiDictationAdapter.access$300(this.this$0, 2)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestSetUserId]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseSetUserId(3);
        } else {
            DsiDictationAdapter.access$800(this.this$0, 2);
            DsiDictationAdapter.access$1400(this.this$0, this.val$pUserId);
            DsiDictationAdapter.access$700(this.this$0).responseSetUserId(0);
            DsiDictationAdapter.access$1500(this.this$0, 2);
        }
    }
}

