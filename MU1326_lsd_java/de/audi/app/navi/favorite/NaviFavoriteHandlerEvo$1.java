/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class NaviFavoriteHandlerEvo$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$navLocation;
    private final /* synthetic */ NaviFavoriteHandlerEvo this$0;

    NaviFavoriteHandlerEvo$1(NaviFavoriteHandlerEvo naviFavoriteHandlerEvo, String string, NavLocation navLocation) {
        this.this$0 = naviFavoriteHandlerEvo;
        this.val$navLocation = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        NaviFavoriteHandlerEvo.access$000(this.this$0).log(-2137614336, "%1#startRouteGuidance - Starting route guidance to: %2", (Object)"NaviFavoriteHandlerEvo", (Object)LocationFormatter.formatLocationShort(this.val$navLocation));
        if (this.val$navLocation != null) {
            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(this.val$navLocation));
        }
        this.getCommandList().commandFinished();
    }
}

