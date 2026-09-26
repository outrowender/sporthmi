/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.search;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.search.AbstractSpellerHandler;
import org.dsi.ifc.search.Suggestion;

class AbstractSpellerHandler$4
extends AbstractRemoteHMITask {
    private final /* synthetic */ Suggestion val$suggestion;
    private final /* synthetic */ AbstractSpellerHandler this$0;

    AbstractSpellerHandler$4(AbstractSpellerHandler abstractSpellerHandler, String string, LogAppender logAppender, Suggestion suggestion) {
        this.this$0 = abstractSpellerHandler;
        this.val$suggestion = suggestion;
        super(string, logAppender);
    }

    @Override
    public void run() {
        if (this.val$suggestion == null) {
            this.this$0.logChannel.log(1078071040, "AbstractSpellerHandler#requestSuggestion: no suggestion");
            return;
        }
        String string = new StringBuffer().append(this.this$0.spellerModel.getText()).append(this.val$suggestion.getSuggestion()).toString();
        this.this$0.logChannel.log(-2137614336, "AbstractGuiSearchHandler#setSlowGuess setting %1 as slow guess", (Object)string);
        this.this$0.spellerModel.setSuggestions(string, this.val$suggestion.getQuery());
    }
}

