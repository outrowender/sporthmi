/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;
import de.audi.tghu.navi.app.sds.SDSHandlerImpl;

class SDSHandlerImpl$7
extends NotifySDSCommand {
    private final /* synthetic */ SDSHandlerImpl this$0;

    SDSHandlerImpl$7(SDSHandlerImpl sDSHandlerImpl, NaviServiceListener naviServiceListener) {
        this.this$0 = sDSHandlerImpl;
        super(naviServiceListener);
    }

    @Override
    public void call() {
        String string = (String)this.getCommandList().get("SPELLABLE_CHARACTERS_RESULT");
        boolean bl = true;
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            this.this$0.logChannel.log(-2137614336, "SDSHandlerImpl#requestPostCodeFormat() - got alphanumeric result");
            bl = false;
        }
        this.feedbackNaviServiceListener.responsePostCodeFormat((byte)0, bl);
    }
}

