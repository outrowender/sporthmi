/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.StopDictationCommand;

class DsiDictationAdapter$7
implements Runnable {
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$7(DsiDictationAdapter dsiDictationAdapter) {
        this.this$0 = dsiDictationAdapter;
    }

    @Override
    public void run() {
        boolean bl;
        DsiDictationAdapter.access$2601(this.this$0).log(1078071040, "[DsiDictationAdapter#requestStopDictation]");
        boolean bl2 = !DsiDictationAdapter.access$300(this.this$0, 3) && !DsiDictationAdapter.access$300(this.this$0, 4) && !DsiDictationAdapter.access$300(this.this$0, 5) && !DsiDictationAdapter.access$300(this.this$0, 6);
        boolean bl3 = bl2 && DsiDictationAdapter.access$400(this.this$0) == 1;
        boolean bl4 = DsiDictationAdapter.access$300(this.this$0, 4) && DsiDictationAdapter.access$400(this.this$0) == 1;
        boolean bl5 = bl2 && DsiDictationAdapter.access$400(this.this$0) == 2;
        boolean bl6 = bl = DsiDictationAdapter.access$300(this.this$0, 5) && DsiDictationAdapter.access$400(this.this$0) == 3;
        if (!(bl3 || bl4 || bl5 || bl)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestStopDictation]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseStopDictation(3);
        } else if (bl3) {
            DsiDictationAdapter.access$2701(this.this$0).log(-2137614336, "[DsiDictationAdapter#requestStopDictation] No dictation in progress, signalling OK to the client.");
            DsiDictationAdapter.access$700(this.this$0).responseStopDictation(0);
        } else {
            DsiDictationAdapter.access$800(this.this$0, 6);
            DsiDictationAdapter.access$1000(this.this$0).stopMonitoredLists("[DsiDictationAdapter#requestStopDictation] has been called.");
            StopDictationCommand.schedule(DsiDictationAdapter.access$2801(this.this$0), DsiDictationAdapter.access$1000(this.this$0));
        }
    }
}

