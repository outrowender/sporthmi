/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.setup.VignetteCountryInputSequence;

class VignetteCountryInputSequence$1
extends NavCommand {
    private final /* synthetic */ VignetteCountryInputSequence this$0;

    VignetteCountryInputSequence$1(VignetteCountryInputSequence vignetteCountryInputSequence) {
        this.this$0 = vignetteCountryInputSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

