/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AbstractAddressInputMatchSpellerSequence;

class AbstractAddressInputMatchSpellerSequence$4
extends NavCommand {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AbstractAddressInputMatchSpellerSequence this$0;

    AbstractAddressInputMatchSpellerSequence$4(AbstractAddressInputMatchSpellerSequence abstractAddressInputMatchSpellerSequence, String string, int n, int n2) {
        this.this$0 = abstractAddressInputMatchSpellerSequence;
        this.val$model = n;
        this.val$terminal = n2;
        super(string);
    }

    @Override
    public void execute() {
        this.env.fireModelEvent(this.val$model, this.val$terminal);
        this.getCommandList().commandFinished();
    }
}

