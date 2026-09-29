/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.ProcessVoiceDataCommand;

class DsiDictationAdapter$6
implements Runnable {
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$6(DsiDictationAdapter dsiDictationAdapter) {
        this.this$0 = dsiDictationAdapter;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$2201(this.this$0).log(1078071040, "[DsiDictationAdapter#requestProcessVoiceData]");
        if (DsiDictationAdapter.access$400(this.this$0) != 2 || DsiDictationAdapter.access$300(this.this$0, 3) || DsiDictationAdapter.access$300(this.this$0, 4) || DsiDictationAdapter.access$300(this.this$0, 5) || DsiDictationAdapter.access$300(this.this$0, 6)) {
            DsiDictationAdapter.access$600(this.this$0, "[DsiDictationAdapter#requestProcessVoiceData]", DsiDictationAdapter.access$400(this.this$0), DsiDictationAdapter.access$500(this.this$0));
            DsiDictationAdapter.access$700(this.this$0).responseProcessVoiceData(3, null);
        } else if (DsiDictationAdapter.access$1900(this.this$0) != 0) {
            DsiDictationAdapter.access$2301(this.this$0).log(-2137614336, "[DsiDictationAdapter#requestProcessVoiceData] The DSI reported an error prior to this call. Responding with cached error code.");
            DsiDictationAdapter.access$2400(this.this$0, 1);
            DsiDictationAdapter.access$700(this.this$0).responseProcessVoiceData(DsiDictationAdapter.access$1900(this.this$0), null);
        } else {
            DsiDictationAdapter.access$800(this.this$0, 5);
            DsiDictationAdapter.access$2400(this.this$0, 3);
            ProcessVoiceDataCommand.schedule(DsiDictationAdapter.access$2501(this.this$0), DsiDictationAdapter.access$1000(this.this$0));
        }
    }
}

