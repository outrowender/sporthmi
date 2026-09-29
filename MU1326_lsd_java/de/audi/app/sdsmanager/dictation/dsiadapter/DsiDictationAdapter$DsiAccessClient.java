/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsi.IDsiAccessClient;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$1;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$DsiAccessClient$1;

class DsiDictationAdapter$DsiAccessClient
implements IDsiAccessClient {
    private final /* synthetic */ DsiDictationAdapter this$0;

    private DsiDictationAdapter$DsiAccessClient(DsiDictationAdapter dsiDictationAdapter) {
        this.this$0 = dsiDictationAdapter;
    }

    @Override
    public void updateDsiAvailability(boolean bl) {
        DsiDictationAdapter.access$5000(this.this$0).execute(new DsiDictationAdapter$DsiAccessClient$1(this, bl));
    }

    /* synthetic */ DsiDictationAdapter$DsiAccessClient(DsiDictationAdapter dsiDictationAdapter, DsiDictationAdapter$1 dsiDictationAdapter$1) {
        this(dsiDictationAdapter);
    }

    static /* synthetic */ DsiDictationAdapter access$4700(DsiDictationAdapter$DsiAccessClient dsiDictationAdapter$DsiAccessClient) {
        return dsiDictationAdapter$DsiAccessClient.this$0;
    }
}

