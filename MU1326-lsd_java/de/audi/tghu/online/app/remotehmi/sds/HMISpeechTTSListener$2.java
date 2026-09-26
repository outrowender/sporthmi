/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.sds;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener;

class HMISpeechTTSListener$2
extends AbstractCommandHandler {
    private final /* synthetic */ HMISpeechTTSListener this$0;

    HMISpeechTTSListener$2(HMISpeechTTSListener hMISpeechTTSListener, String string) {
        this.this$0 = hMISpeechTTSListener;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.this$0.abort();
    }
}

