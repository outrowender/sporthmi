/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler$4;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$4$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ IntelliDestGuiSearchHandler$4 this$1;

    IntelliDestGuiSearchHandler$4$1(IntelliDestGuiSearchHandler$4 intelliDestGuiSearchHandler$4, String string, NavLocation navLocation) {
        this.this$1 = intelliDestGuiSearchHandler$4;
        this.val$navLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(null, this.val$navLocation, true, false));
    }
}

