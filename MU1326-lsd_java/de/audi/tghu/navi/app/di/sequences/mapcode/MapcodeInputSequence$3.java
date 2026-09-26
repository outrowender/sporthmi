/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;

class MapcodeInputSequence$3
extends NavCommand {
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$3(MapcodeInputSequence mapcodeInputSequence, String string) {
        this.this$0 = mapcodeInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        String string = this.dsiResponseContainer.getLispCurrentInput();
        this.getCommandList().put("PREVIOUS_MAP_CODE", string);
        this.getCommandList().commandFinishedWithPostCommand(new SetInputCommand(string.substring(0, string.length() - ((String)MapcodeInputSequence.access$000().peek()).length())));
    }
}

