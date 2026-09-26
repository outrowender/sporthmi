/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsi;

import de.audi.app.sdsmanager.dictation.dsi.DsiOnlineDictationPrimaryListener;
import de.audi.app.sdsmanager.dictation.util.DictationUtil;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineDictationListener;
import org.dsi.ifc.online.DictationValueSentence;

class DsiOnlineDictationPrimaryListener$4
extends CommandResponse {
    private final /* synthetic */ DictationValueSentence val$dictationSentence;
    private final /* synthetic */ DsiOnlineDictationPrimaryListener this$0;

    DsiOnlineDictationPrimaryListener$4(DsiOnlineDictationPrimaryListener dsiOnlineDictationPrimaryListener, DictationValueSentence dictationValueSentence) {
        this.this$0 = dsiOnlineDictationPrimaryListener;
        this.val$dictationSentence = dictationValueSentence;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIOnlineDictationListener dSIOnlineDictationListener = DsiOnlineDictationPrimaryListener.access$100(this.this$0);
        try {
            dSIOnlineDictationListener = (DSIOnlineDictationListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            DictationUtil.logException(DsiOnlineDictationPrimaryListener.access$400(this.this$0), classCastException, "[DsiOnlineDictationPrimaryListener#dictationValueList]");
        }
        dSIOnlineDictationListener.dictationValueList(this.val$dictationSentence);
    }
}

