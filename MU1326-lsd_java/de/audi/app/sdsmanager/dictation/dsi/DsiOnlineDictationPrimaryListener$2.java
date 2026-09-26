/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineDictationListener;

class DsiOnlineDictationPrimaryListener$2
extends CommandResponse {
    private final /* synthetic */ int val$returnCode;
    private final /* synthetic */ DsiOnlineDictationPrimaryListener this$0;

    DsiOnlineDictationPrimaryListener$2(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener, int n) {
        this.this$0 = dsiOnlineDictationPrimaryListener;
        this.val$returnCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIOnlineDictationListener dSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.access$100(this.this$0);
        try {
            dSIOnlineDictationListener = (DSIOnlineDictationListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            DictationUtil.logException(DsiOnlineDictationPrimaryListener.access$200(this.this$0), classCastException, "[DsiOnlineDictationPrimaryListener#dictationResult]");
        }
        dSIOnlineDictationListener.dictationResult(this.val$returnCode);
    }
}

