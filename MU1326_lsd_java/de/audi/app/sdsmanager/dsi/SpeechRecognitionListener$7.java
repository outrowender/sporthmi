/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.DSISpeechRecListener;

class SpeechRecognitionListener$7
extends CommandResponse {
    private final /* synthetic */ int val$replyCode;
    private final /* synthetic */ SpeechRecognitionListener this$0;

    SpeechRecognitionListener$7(SpeechRecognitionListener speechRecognitionListener, int n) {
        this.this$0 = speechRecognitionListener;
        this.val$replyCode = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSISpeechRecListener)dSIListener).responseSetLanguage(this.val$replyCode);
    }
}

