/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestHMIListener;
import de.audi.app.navi.evo.search.IntelliDestHMIListener$1;
import de.audi.tghu.navi.app.command.NavCommand;

class IntelliDestHMIListener$1$1
extends NavCommand {
    private final /* synthetic */ IntelliDestHMIListener$1 this$1;

    IntelliDestHMIListener$1$1(IntelliDestHMIListener$1 intelliDestHMIListener$1, String string) {
        this.this$1 = intelliDestHMIListener$1;
        super(string);
    }

    @Override
    public void execute() {
        IntelliDestHMIListener.access$500(IntelliDestHMIListener$1.access$1700(this.this$1)).focusPreviewAreaAroundCCP();
        this.getCommandList().commandFinished();
    }
}

