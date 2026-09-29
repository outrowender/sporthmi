/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dsi;

import de.audi.app.sdsmanager.dsi.SpeechRecognitionListener;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.speechrec.DSISpeechRecListener;
import org.dsi.ifc.speechrec.NBestList;

class SpeechRecognitionListener$4
extends CommandResponse {
    private final /* synthetic */ int val$replyCode;
    private final /* synthetic */ NBestList val$results;
    private final /* synthetic */ SpeechRecognitionListener this$0;

    SpeechRecognitionListener$4(SpeechRecognitionListener speechRecognitionListener, int n, NBestList nBestList) {
        this.this$0 = speechRecognitionListener;
        this.val$replyCode = n;
        this.val$results = nBestList;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSISpeechRecListener)dSIListener).responseWaitForResults(this.val$replyCode, this.val$results);
    }
}

