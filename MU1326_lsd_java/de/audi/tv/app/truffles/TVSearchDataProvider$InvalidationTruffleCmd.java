/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.tv.app.truffles.TVSearchDataProvider;
import de.audi.tv.app.truffles.TrufflesCommandHandler$ITrufflesCommand;

class TVSearchDataProvider$InvalidationTruffleCmd
implements TrufflesCommandHandler$ITrufflesCommand {
    private int id;
    private final /* synthetic */ TVSearchDataProvider this$0;

    public TVSearchDataProvider$InvalidationTruffleCmd(TVSearchDataProvider tVSearchDataProvider, int n) {
        this.this$0 = tVSearchDataProvider;
        this.id = n;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void execute() {
        TVSearchDataProvider.access$600(this.this$0).invalidateAllData(this.id);
    }
}

