/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguator$2
extends NavCommand {
    private final /* synthetic */ LogChannel val$cmdListlogger;
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$2(AddressDisambiguator addressDisambiguator, String string, LogChannel logChannel) {
        this.this$0 = addressDisambiguator;
        this.val$cmdListlogger = logChannel;
        super(string);
    }

    @Override
    public void execute() {
        if (this.val$cmdListlogger.isDebug2()) {
            this.val$cmdListlogger.log(14808325, "Selected location navLoc is >>%1<<", (Object)this.env.getContainer().getSelectedLocation());
        }
        this.getCommandList().commandFinished();
    }
}

