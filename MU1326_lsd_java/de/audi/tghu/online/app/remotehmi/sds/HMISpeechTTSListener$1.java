/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.sds;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener;

class HMISpeechTTSListener$1
extends AbstractCommandHandler {
    private final /* synthetic */ HMISpeechTTSListener this$0;

    HMISpeechTTSListener$1(HMISpeechTTSListener hMISpeechTTSListener, String string) {
        this.this$0 = hMISpeechTTSListener;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        boolean bl = false;
        if (object == null || object.equals("")) {
            bl = true;
        }
        String string = object.toString();
        this.this$0.startTts(string, bl, true);
    }
}

