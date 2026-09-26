/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8$2$1;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence$8$2$2;

class MapcodeInputSequence$8$2
extends NavCommand {
    private final /* synthetic */ MapcodeInputSequence$8 this$1;

    MapcodeInputSequence$8$2(MapcodeInputSequence$8 mapcodeInputSequence$8, String string) {
        this.this$1 = mapcodeInputSequence$8;
        super(string);
    }

    @Override
    public void execute() {
        if (MapcodeInputSequence.access$200(MapcodeInputSequence$8.access$600(this.this$1), this.dsiResponseContainer, MapcodeInputSequence$8.access$400(this.this$1), MapcodeInputSequence$8.access$500(this.this$1))) {
            MapcodeInputSequence.access$300(MapcodeInputSequence$8.access$600(this.this$1)).log(-2137614336, "%1#inputMapCode -- input stack = %2", (Object)this.CLASS_NAME, (Object)MapcodeInputSequence.access$000());
            CommandList commandList = MapcodeInputSequence$8.access$600((MapcodeInputSequence$8)this.this$1).commandListFactory.createCommandList();
            commandList.add(new ModelUpdateSpellerAndResultListCommand(MapcodeInputSequence.access$700(MapcodeInputSequence$8.access$600(this.this$1))));
            MapcodeInputSequence$8.access$600(this.this$1).updateSelectedLocation(commandList);
            commandList.add(new MapcodeInputSequence$8$2$1(this, MapcodeInputSequence$8.access$800(this.this$1)));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new MapcodeInputSequence$8$2$2(this, MapcodeInputSequence$8.access$800(this.this$1)));
        }
    }
}

