/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;

class MapcodeInputSequence$4
extends NavCommand {
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$4(MapcodeInputSequence mapcodeInputSequence, String string) {
        this.this$0 = mapcodeInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        MapcodeInputSequence.access$100(this.this$0, MapcodeInputSequence.access$000(), (String)this.getCommandList().get("PREVIOUS_MAP_CODE"), this.dsiResponseContainer.getLispCurrentInput());
        this.getCommandList().commandFinished();
    }
}

