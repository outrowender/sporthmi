/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.ServiceProviderInfo;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import java.util.LinkedList;
import org.dsi.ifc.online.DictationValueSentence;

class DsiDictationAdapter$10
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DictationValueSentence val$dictationSentence;
    private final /* synthetic */ DsiDictationAdapter this$0;

    DsiDictationAdapter$10(DsiDictationAdapter dsiDictationAdapter, int n, DictationValueSentence dictationValueSentence) {
        this.this$0 = dsiDictationAdapter;
        this.val$result = n;
        this.val$dictationSentence = dictationValueSentence;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$3501(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleProcessVoiceDataResult] result = %1", (long)this.val$result);
        if (DsiDictationAdapter.access$300(this.this$0, 5)) {
            int n = this.val$result;
            LinkedList linkedList = new LinkedList();
            if (this.val$result == 0) {
                DsiDictationAdapter.access$3600(this.this$0, new ServiceProviderInfo(this.val$dictationSentence));
                try {
                    linkedList = DsiDictationAdapter.access$3700(this.this$0).preprocessTranscript(this.val$dictationSentence);
                }
                catch (Exception exception) {
                    DictationUtil.logException(DsiDictationAdapter.access$3801(this.this$0), exception, "[DsiDictationAdapter#handleProcessVoiceDataResult]");
                    n = 1;
                }
            }
            DsiDictationAdapter.access$2400(this.this$0, 1);
            DsiDictationAdapter.access$700(this.this$0).responseProcessVoiceData(n, linkedList);
            DsiDictationAdapter.access$1500(this.this$0, 5);
        } else {
            DsiDictationAdapter.access$3901(this.this$0).log(-2137614336, "[DsiDictationAdapter#handleProcessVoiceDataResult] Discarding obsolete result.");
        }
    }
}

