/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8$1;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8$2;
import de.audi.tghu.navi.app.util.Util;

class MapcodeInputSequence$8
extends NavCommand {
    private final /* synthetic */ String val$previousInput;
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ String val$input;
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$8(MapcodeInputSequence mapcodeInputSequence, String string, String string2, NaviServiceListener naviServiceListener, String string3) {
        this.this$0 = mapcodeInputSequence;
        this.val$previousInput = string2;
        this.val$naviServiceListener = naviServiceListener;
        this.val$input = string3;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        if (!this.dsiResponseContainer.isLispIsFullMatch() && Util.isEmpty(this.dsiResponseContainer.getLispValidCharacters())) {
            commandList.add(new SetInputCommand(this.val$previousInput));
            commandList.add(new MapcodeInputSequence$8$1(this, this.val$naviServiceListener));
        } else {
            commandList.add(new MapcodeInputSequence$8$2(this, "Check whether SetInputCommand execute successfully"));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ String access$400(MapcodeInputSequence$8 mapcodeInputSequence$8) {
        return mapcodeInputSequence$8.val$previousInput;
    }

    static /* synthetic */ String access$500(MapcodeInputSequence$8 mapcodeInputSequence$8) {
        return mapcodeInputSequence$8.val$input;
    }

    static /* synthetic */ MapcodeInputSequence access$600(MapcodeInputSequence$8 mapcodeInputSequence$8) {
        return mapcodeInputSequence$8.this$0;
    }

    static /* synthetic */ NaviServiceListener access$800(MapcodeInputSequence$8 mapcodeInputSequence$8) {
        return mapcodeInputSequence$8.val$naviServiceListener;
    }
}

