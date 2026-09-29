/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.search.AbstractSpellerHandler;
import org.dsi.ifc.search.Token;

class AbstractSpellerHandler$3
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$row;
    private final /* synthetic */ Token[] val$highlightedCells;
    private final /* synthetic */ AbstractSpellerHandler this$0;

    AbstractSpellerHandler$3(AbstractSpellerHandler abstractSpellerHandler, String string, LogAppender logAppender, int n, Token[] tokenArray) {
        this.this$0 = abstractSpellerHandler;
        this.val$row = n;
        this.val$highlightedCells = tokenArray;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.applySearchFilter(this.val$row, this.val$highlightedCells);
    }
}

