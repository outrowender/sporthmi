/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.command.Command;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AbstractAddressInputNoSpellerSequence;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputNoSpellerSequence$1
extends NavCommand {
    private final /* synthetic */ Command val$callback;
    private final /* synthetic */ AbstractAddressInputNoSpellerSequence this$0;

    AbstractAddressInputNoSpellerSequence$1(AbstractAddressInputNoSpellerSequence abstractAddressInputNoSpellerSequence, String string, Command command) {
        this.this$0 = abstractAddressInputNoSpellerSequence;
        this.val$callback = command;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        this.logger.log(-2137614336, "Get NavLocation from Response Container - location=%1", (Object)navLocation);
        this.getCommandList().put("LocationToTest", navLocation);
        this.getCommandList().commandFinishedWithPostCommand(this.val$callback);
    }
}

