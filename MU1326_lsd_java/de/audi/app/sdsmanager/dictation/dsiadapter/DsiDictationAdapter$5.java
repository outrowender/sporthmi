/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.StartDictationCommand;

class DsiDictationAdapter$5
implements Runnable {
    private final /* synthetic */ String val$customGrammar;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$5(DsiDictationAdapter dsiDictationAdapter, String string) {
        this.this$0 = dsiDictationAdapter;
        this.val$customGrammar = string;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$1801(this.this$0).log(1078071040, "[DsiDictationAdapter#requestStartDictation] customGrammar = %1", (Object)this.val$customGrammar);
        if (DsiDictationAdapter.access$400(this.this$0) != 1 || DsiDictationAdapter.access$300(this.this$0, 3) || DsiDictationAdapter.access$300(this.this$0, 4) || DsiDictationAdapter.access$300(this.this$0, 5) || DsiDictationAdapter.access$300(this.this$0, 6)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestStartDictation]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseStartDictation(3);
        } else {
            DsiDictationAdapter.access$1902(this.this$0, 0);
            DsiDictationAdapter.access$800(this.this$0, 4);
            StartDictationCommand.schedule(DsiDictationAdapter.access$2001(this.this$0), DsiDictationAdapter.access$1000(this.this$0), this.val$customGrammar, DsiDictationAdapter.access$2100(this.this$0));
        }
    }
}

