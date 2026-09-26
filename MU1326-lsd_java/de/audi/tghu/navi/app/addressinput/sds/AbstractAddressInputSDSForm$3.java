/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.sds;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.addressinput.sds.AbstractAddressInputSDSForm;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractAddressInputSDSForm$3
extends NavCommand {
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ AbstractAddressInputSDSForm this$0;

    AbstractAddressInputSDSForm$3(AbstractAddressInputSDSForm abstractAddressInputSDSForm, String string, NaviServiceListener naviServiceListener) {
        this.this$0 = abstractAddressInputSDSForm;
        this.val$naviServiceListener = naviServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.logChannel.log(1078071040, "%1#synchronizeSpeechCountryWithCurrentLD() - sync is done", (Object)this.CLASS_NAME);
        this.val$naviServiceListener.responseSynchronizeSpeechCountryWithCurrentLDResult((byte)0, true);
        this.getCommandList().commandFinished();
    }
}

