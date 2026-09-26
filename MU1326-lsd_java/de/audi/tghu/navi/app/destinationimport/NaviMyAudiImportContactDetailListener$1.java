/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.destinationimport;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.destinationimport.NaviMyAudiImportContactDetailListener;
import org.dsi.ifc.global.NavLocation;

class NaviMyAudiImportContactDetailListener$1
extends NavCommand {
    private final /* synthetic */ NaviMyAudiImportContactDetailListener this$0;

    NaviMyAudiImportContactDetailListener$1(NaviMyAudiImportContactDetailListener naviMyAudiImportContactDetailListener, String string) {
        this.this$0 = naviMyAudiImportContactDetailListener;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = (NavLocation)this.getCommandList().get("STREAMED_LOCATION");
        if (navLocation != null) {
            NaviMyAudiImportContactDetailListener.access$000(this.this$0).setPreviewLocation(navLocation, 3, null, null);
        } else {
            NaviMyAudiImportContactDetailListener.access$000(this.this$0).hidePreviewMap();
        }
        this.getCommandList().commandFinished();
    }
}

