/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.search.AbstractSpellerHandler;

class AbstractSpellerHandler$2
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ AbstractSpellerHandler this$0;

    AbstractSpellerHandler$2(AbstractSpellerHandler abstractSpellerHandler, String string, LogAppender logAppender, int n) {
        this.this$0 = abstractSpellerHandler;
        this.val$model = n;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.triggerSpellerAction(this.this$0.service.getAction(-1002107136), this.val$model, (String)this.this$0.spellerValues.get(new Integer(this.val$model)));
    }
}

