/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.search.AbstractSpellerHandler;

class AbstractSpellerHandler$1
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$model;
    private final /* synthetic */ String val$text;
    private final /* synthetic */ char val$latestChar;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ AbstractSpellerHandler this$0;

    AbstractSpellerHandler$1(AbstractSpellerHandler abstractSpellerHandler, String string, LogAppender logAppender, int n, String string2, char c2, int n2) {
        this.this$0 = abstractSpellerHandler;
        this.val$model = n;
        this.val$text = string2;
        this.val$latestChar = c2;
        this.val$terminal = n2;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.processTextChanged(this.val$model, this.val$text, this.val$latestChar, this.val$terminal);
    }
}

