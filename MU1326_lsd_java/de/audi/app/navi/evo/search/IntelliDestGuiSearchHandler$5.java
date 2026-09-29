/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.Route;

class IntelliDestGuiSearchHandler$5
extends NavCommand {
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$5(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, String string) {
        this.this$0 = intelliDestGuiSearchHandler;
        super(string);
    }

    @Override
    public void execute() {
        this.navigation.getStartGuidanceDependantSequence().start((Route)this.getCommandList().get("TRANSLATED_ROUTE"));
        this.getCommandList().commandFinished();
    }
}

