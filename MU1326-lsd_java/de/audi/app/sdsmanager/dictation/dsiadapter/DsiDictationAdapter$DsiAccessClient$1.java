/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$DsiAccessClient;

class DsiDictationAdapter$DsiAccessClient$1
implements Runnable {
    private final /* synthetic */ boolean val$pDsiAvailable;
    private final /* synthetic */ DsiDictationAdapter$DsiAccessClient this$1;

    DsiDictationAdapter$DsiAccessClient$1(DsiDictationAdapter$DsiAccessClient dsiDictationAdapter$DsiAccessClient, boolean bl) {
        this.this$1 = dsiDictationAdapter$DsiAccessClient;
        this.val$pDsiAvailable = bl;
    }

    @Override
    public void run() {
        DsiDictationAdapter.access$4801(DsiDictationAdapter$DsiAccessClient.access$4700(this.this$1)).log(-2137614336, "[DsiDictationAdapter#updateDsiAvailability] dsiAvailable = %1", this.val$pDsiAvailable);
        DsiDictationAdapter.access$4900(DsiDictationAdapter$DsiAccessClient.access$4700(this.this$1), this.val$pDsiAvailable);
    }
}

