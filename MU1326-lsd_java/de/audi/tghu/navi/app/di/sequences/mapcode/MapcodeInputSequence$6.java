/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;

class MapcodeInputSequence$6
extends NavCommand {
    private final /* synthetic */ String val$inputCharacter;
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$6(MapcodeInputSequence mapcodeInputSequence, String string, String string2) {
        this.this$0 = mapcodeInputSequence;
        this.val$inputCharacter = string2;
        super(string);
    }

    @Override
    public void execute() {
        if (MapcodeInputSequence.access$200(this.this$0, this.dsiResponseContainer, (String)this.getCommandList().get("PREVIOUS_MAP_CODE"), this.val$inputCharacter)) {
            MapcodeInputSequence.access$300(this.this$0).log(-2137614336, "%1#addCharacter -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)MapcodeInputSequence.access$000());
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("Unexcepted result");
        }
    }
}

