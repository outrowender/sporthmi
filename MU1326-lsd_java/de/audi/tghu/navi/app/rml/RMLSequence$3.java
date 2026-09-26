/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.IRMLListener;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.rml.RequestCombinedRouteListCommand;
import org.dsi.ifc.navigation.CombinedRouteListElement;

class RMLSequence$3
extends NavCommand {
    private final /* synthetic */ long[] val$anchorIds;
    private final /* synthetic */ long val$openedListAnchorId;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$3(RMLSequence rMLSequence, String string, long[] lArray, long l) {
        this.this$0 = rMLSequence;
        this.val$anchorIds = lArray;
        this.val$openedListAnchorId = l;
        super(string);
    }

    @Override
    public void execute() {
        CombinedRouteListElement combinedRouteListElement;
        IRMLListener iRMLListener = RMLSequence.access$100(this.this$0);
        if (iRMLListener != null && (combinedRouteListElement = iRMLListener.getOpenedElement()) != null) {
            this.getCommandList().put(RMLSequence.OPENEDANCHOR, new Long(combinedRouteListElement.getUid()));
            this.getCommandList().commandFinishedWithPostCommand(new RequestCombinedRouteListCommand(21, 10, this.val$anchorIds, combinedRouteListElement.getUid(), 10));
            return;
        }
        this.getCommandList().put(RMLSequence.OPENEDANCHOR, new Long(this.val$openedListAnchorId));
        this.getCommandList().commandFinishedWithPostCommand(new RequestCombinedRouteListCommand(21, 10, this.val$anchorIds, this.val$openedListAnchorId, 10));
    }
}

