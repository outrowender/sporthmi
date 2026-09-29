/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.DSISpeechRecListener;
import org.dsi.ifc.speechrec.GrammarInfo;

class SpeechRecognitionListener$2
extends CommandResponse {
    private final /* synthetic */ int val$replyCode;
    private final /* synthetic */ GrammarInfo[] val$info;
    private final /* synthetic */ SpeechRecognitionListener this$0;

    SpeechRecognitionListener$2(SpeechRecognitionListener speechRecognitionListener, int n, GrammarInfo[] grammarInfoArray) {
        this.this$0 = speechRecognitionListener;
        this.val$replyCode = n;
        this.val$info = grammarInfoArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSISpeechRecListener)dSIListener).responseUnloadGrammar(this.val$replyCode, this.val$info);
    }
}

