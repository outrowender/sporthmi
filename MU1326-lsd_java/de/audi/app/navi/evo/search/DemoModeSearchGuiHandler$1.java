/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.DemoModeSearchGuiHandler;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import org.dsi.ifc.global.NavLocation;

class DemoModeSearchGuiHandler$1
implements NavLocationCallback {
    private final /* synthetic */ SearchResultListRow val$listRow;
    private final /* synthetic */ int val$terminal;
    private final /* synthetic */ DemoModeSearchGuiHandler this$0;

    DemoModeSearchGuiHandler$1(DemoModeSearchGuiHandler demoModeSearchGuiHandler, SearchResultListRow searchResultListRow, int n) {
        this.this$0 = demoModeSearchGuiHandler;
        this.val$listRow = searchResultListRow;
        this.val$terminal = n;
    }

    @Override
    public void callBack(NavLocation navLocation, ICommandList iCommandList) {
        if (this.this$0.isDisambiguationNeeded(this.val$listRow)) {
            if (null != this.this$0.addressDisambiguator) {
                iCommandList.commandFinishedWithPostSequence(this.this$0.addressDisambiguator.prepareCandidatesList(this.val$listRow, this.val$terminal));
            } else {
                this.this$0.env.getLogChannel().log(-1601830656, "%1#searchResultSelected() - addressDisambiguator is null", (Object)DemoModeSearchGuiHandler.access$000());
            }
        } else {
            iCommandList.commandFinishedWithPostCommand(DemoModeSearchGuiHandler.getSetPositionCommand(navLocation, DemoModeSearchGuiHandler.access$100(this.this$0)));
        }
    }
}

