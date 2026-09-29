/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;

class MapcodeInputSequence$5
extends NavCommand {
    private final /* synthetic */ String val$inputCharacter;
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$5(MapcodeInputSequence mapcodeInputSequence, String string, String string2) {
        this.this$0 = mapcodeInputSequence;
        this.val$inputCharacter = string2;
        super(string);
    }

    @Override
    public void execute() {
        String string = this.dsiResponseContainer.getLispCurrentInput();
        this.getCommandList().put("PREVIOUS_MAP_CODE", string);
        this.getCommandList().commandFinishedWithPostCommand(new SetInputCommand(new StringBuffer().append(string).append(this.val$inputCharacter).toString()));
        this.getCommandList().commandFinished();
    }
}

