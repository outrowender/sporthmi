/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.mapcode;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.mapcode.MapcodeInputSequence;
import de.audi.tghu.navi.app.util.Util;

class MapcodeInputSequence$9
extends NavCommand {
    private final /* synthetic */ MapcodeInputSequence this$0;

    MapcodeInputSequence$9(MapcodeInputSequence mapcodeInputSequence, String string) {
        this.this$0 = mapcodeInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.dsiResponseContainer.isLispIsFullMatch() && Util.isEmpty(this.dsiResponseContainer.getLispValidCharacters())) {
            this.getCommandList().commandAborted("Revieved invalid result from south side after SetInputCommand execution.");
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

