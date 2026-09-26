/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

class AddressDisambiguator$3
extends NavCommand {
    private final /* synthetic */ LogChannel val$cmdListlogger;
    private final /* synthetic */ boolean val$fillSpeller;
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$3(AddressDisambiguator addressDisambiguator, String string, LogChannel logChannel, boolean bl) {
        this.this$0 = addressDisambiguator;
        this.val$cmdListlogger = logChannel;
        this.val$fillSpeller = bl;
        super(string);
    }

    @Override
    public void execute() {
        LIValueList lIValueList = this.env.getContainer().getLispValueList();
        if (0 == lIValueList.list.length) {
            this.val$cmdListlogger.log(-1601830656, "getHNRListCL no values received");
            this.getCommandList().commandAborted("getHNRListCL no values received");
            return;
        }
        if (this.val$fillSpeller) {
            this.this$0.setSpellerInput(this.this$0.getHouseNrUserInput());
        }
        if (!this.this$0.fillRowsIn(lIValueList)) {
            this.val$cmdListlogger.log(-1601830656, "getHNRListCL negative fillRowsIn(env.getContainer().getLispValueList(), fillSpeller)");
            this.getCommandList().commandAborted("getHNRListCL negative fillRowsIn(env.getContainer().getLispValueList(), fillSpeller)");
            return;
        }
        this.getCommandList().commandFinished();
    }
}

