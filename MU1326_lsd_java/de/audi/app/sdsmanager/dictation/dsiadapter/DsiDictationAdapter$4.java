/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.ActivateDictationCommand;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;

class DsiDictationAdapter$4
implements Runnable {
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$4(DsiDictationAdapter dsiDictationAdapter) {
        this.this$0 = dsiDictationAdapter;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$1601(this.this$0).log(1078071040, "[DsiDictationAdapter#requestActivateDictation]");
        if (DsiDictationAdapter.access$400(this.this$0) != 0 || DsiDictationAdapter.access$300(this.this$0, 3) || DsiDictationAdapter.access$300(this.this$0, 4) || DsiDictationAdapter.access$300(this.this$0, 5) || DsiDictationAdapter.access$300(this.this$0, 6)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestActivateDictation]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseActivateDictation(3);
        } else {
            DsiDictationAdapter.access$800(this.this$0, 3);
            ActivateDictationCommand.schedule(DsiDictationAdapter.access$1701(this.this$0), DsiDictationAdapter.access$1000(this.this$0));
        }
    }
}

