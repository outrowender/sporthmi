/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.RadioSearchDataProvider;
import de.audi.app.tuner.truffles.TrufflesCommandHandler$ITrufflesCommand;

class RadioSearchDataProvider$InvalidationTruffleCmd
implements TrufflesCommandHandler$ITrufflesCommand {
    private int id;
    private final /* synthetic */ RadioSearchDataProvider this$0;

    public RadioSearchDataProvider$InvalidationTruffleCmd(RadioSearchDataProvider radioSearchDataProvider, int n) {
        this.this$0 = radioSearchDataProvider;
        this.id = n;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void execute() {
        RadioSearchDataProvider.access$200(this.this$0).invalidateAllData(this.id);
    }
}

