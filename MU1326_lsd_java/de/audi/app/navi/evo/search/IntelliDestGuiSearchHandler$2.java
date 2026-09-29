/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler$2$1;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$2
implements NavLocationCallback {
    private final /* synthetic */ SearchResultListRow val$listRow;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$2(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, SearchResultListRow searchResultListRow, int n) {
        this.this$0 = intelliDestGuiSearchHandler;
        this.val$listRow = searchResultListRow;
        this.val$terminal = n;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        if (this.this$0.isDisambiguationNeeded(this.val$listRow)) {
            if (null != this.this$0.addressDisambiguator) {
                iCommandList.commandFinishedWithPostSequence(this.this$0.addressDisambiguator.prepareCandidatesList(this.val$listRow, this.val$terminal));
            } else {
                this.this$0.env.getLogChannel().log(-1601830656, "%1#searchResultSelected() - addressDisambiguator is null", (Object)"IntelliDestGuiSearchHandler");
            }
        } else {
            this.this$0.dispatcher.execute(new IntelliDestGuiSearchHandler$2$1(this, navLocation));
        }
    }

    static /* synthetic */ IntelliDestGuiSearchHandler access$000(IntelliDestGuiSearchHandler$2 intelliDestGuiSearchHandler$2) {
        return intelliDestGuiSearchHandler$2.this$0;
    }
}

