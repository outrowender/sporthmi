/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;
import de.audi.tghu.navi.app.rml.RequestNavRectangleForCombinedRouteListElement;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;

class RMLSequence$18
extends NavCommand {
    private final /* synthetic */ CombinedRouteListElement val$combinedRouteListElement;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$18(RMLSequence rMLSequence, String string, CombinedRouteListElement combinedRouteListElement) {
        this.this$0 = rMLSequence;
        this.val$combinedRouteListElement = combinedRouteListElement;
        super(string);
    }

    @Override
    public void execute() {
        NavRectangle navRectangle = (NavRectangle)this.getCommandList().get(RequestNavRectangleForCombinedRouteListElement.NAV_RECTANGLE_FOR_COMBINED_ROUTE_LIST_NAV_RECTANGLE);
        this.this$0.modelAccess.onElementFocused(navRectangle, this.val$combinedRouteListElement);
        this.getCommandList().commandFinished();
    }
}

