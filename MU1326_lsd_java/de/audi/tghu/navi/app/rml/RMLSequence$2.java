/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;

class RMLSequence$2
extends NavCommand {
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$2(RMLSequence rMLSequence, String string) {
        this.this$0 = rMLSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#execute() - isRouteListActive will be set to false because there appeared an error in the running CommandList RMLSequence#start", (Object)this.CLASS_NAME);
        RMLSequence.access$002(this.this$0, false);
        this.getCommandList().commandFinished();
    }
}

