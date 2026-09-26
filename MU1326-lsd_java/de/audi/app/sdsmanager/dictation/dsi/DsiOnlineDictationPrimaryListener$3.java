/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineDictationListener;

class DsiOnlineDictationPrimaryListener$3
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiOnlineDictationPrimaryListener this$0;

    DsiOnlineDictationPrimaryListener$3(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener, int n) {
        this.this$0 = dsiOnlineDictationPrimaryListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIOnlineDictationListener dSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.access$100(this.this$0);
        try {
            dSIOnlineDictationListener = (DSIOnlineDictationListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            DictationUtil.logException(DsiOnlineDictationPrimaryListener.access$300(this.this$0), classCastException, "[DsiOnlineDictationPrimaryListener#finishDictationResponse]");
        }
        dSIOnlineDictationListener.finishDictationResponse(this.val$result);
    }
}

