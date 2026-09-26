/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationAccess;
import org.dsi.ifc.online.DSIOnlineDictation;

class DsiOnlineDictationAccess$1
implements Runnable {
    private final /* synthetic */ DSIOnlineDictation val$dsiOnlineDictation;
    private final /* synthetic */ DsiOnlineDictationAccess this$0;

    DsiOnlineDictationAccess$1(DsiOnlineDictationAccess dsiOnlineDictationAccess, DSIOnlineDictation dSIOnlineDictation) {
        this.this$0 = dsiOnlineDictationAccess;
        this.val$dsiOnlineDictation = dSIOnlineDictation;
    }

    @Override
    public void run() {
        boolean bl;
        DsiOnlineDictationAccess.access$000(this.this$0).log(-2137614336, "[DsiOnlineDictationAccess#setDsiOnlineDictation] dsiOnlineDictation = %1", (Object)this.val$dsiOnlineDictation);
        DsiOnlineDictationAccess.access$102(this.this$0, this.val$dsiOnlineDictation);
        boolean bl2 = bl = this.val$dsiOnlineDictation != null;
        if (bl) {
            this.val$dsiOnlineDictation.setNotification(DsiOnlineDictationAccess.access$200(this.this$0).getDsiOnlineDictationPrimaryListener());
        }
        DsiOnlineDictationAccess.access$300(this.this$0, bl);
    }
}

