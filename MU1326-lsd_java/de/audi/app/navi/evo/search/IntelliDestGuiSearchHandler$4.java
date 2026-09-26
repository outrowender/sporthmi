/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler$4$1;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class IntelliDestGuiSearchHandler$4
implements NavLocationCallback {
    private final /* synthetic */ SearchResultListRow val$listRow;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ IntelliDestGuiSearchHandler this$0;

    IntelliDestGuiSearchHandler$4(IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, SearchResultListRow searchResultListRow, int n) {
        this.this$0 = intelliDestGuiSearchHandler;
        this.val$listRow = searchResultListRow;
        this.val$terminal = n;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        if (IntelliDestGuiSearchHandler.access$400(this.this$0) != null) {
            IntelliDestGuiSearchHandler.access$400(this.this$0).setTransfereToNdf(true);
        }
        if (this.this$0.isDisambiguationNeeded(this.val$listRow)) {
            this.this$0.cancelJobs();
            if (null != this.this$0.addressDisambiguator) {
                iCommandList.commandFinishedWithPostSequence(this.this$0.addressDisambiguator.prepareCandidatesList(this.val$listRow, this.val$terminal));
            } else {
                this.this$0.env.getLogChannel().log(-1601830656, "IntelliDestGuiSearchHandler#searchResultSelected() - addressDisambiguator is null");
            }
        } else {
            IntelliDestGuiSearchHandler.access$500(this.this$0, navLocation, this.val$listRow);
            this.this$0.cachedSelectedRow = null;
            IntelliDestGuiSearchHandler$4$1 intelliDestGuiSearchHandler$4$1 = new IntelliDestGuiSearchHandler$4$1(this, "IntelliDestGuiSearchHandler#StartRouteGuidance", navLocation);
            iCommandList.commandFinishedWithPostCommand(intelliDestGuiSearchHandler$4$1);
        }
    }
}

