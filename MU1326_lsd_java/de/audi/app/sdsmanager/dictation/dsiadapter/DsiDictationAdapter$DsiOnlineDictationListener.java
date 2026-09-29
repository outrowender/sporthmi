/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsi.AbstractDsiOnlineDictationCommand;
import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationEmptyListener;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter;
import de.audi.app.sdsmanager.dictation.dsiadapter.DsiDictationAdapter$1;

class DsiDictationAdapter$DsiOnlineDictationListener
extends DsiOnlineDictationEmptyListener {
    private final /* synthetic */ DsiDictationAdapter this$0;

    private DsiDictationAdapter$DsiOnlineDictationListener(DsiDictationAdapter dsiDictationAdapter) {
        this.this$0 = dsiDictationAdapter;
    }

    @Override
    public void dictationResult(int n) {
        int n2 = AbstractDsiOnlineDictationCommand.mapDsiErrorCode(n);
        DsiDictationAdapter.access$4600(this.this$0, n2);
    }

    /* synthetic */ DsiDictationAdapter$DsiOnlineDictationListener(DsiDictationAdapter dsiDictationAdapter, DsiDictationAdapter$1 dsiDictationAdapter$1) {
        this(dsiDictationAdapter);
    }
}

