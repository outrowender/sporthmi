/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.command.NavCommand;

class CombiBAPListener$2
extends NavCommand {
    private final /* synthetic */ CombiBAPNaviDestination val$address;
    private final /* synthetic */ CombiBAPListener this$0;

    CombiBAPListener$2(CombiBAPListener combiBAPListener, String string, CombiBAPNaviDestination combiBAPNaviDestination) {
        this.this$0 = combiBAPListener;
        this.val$address = combiBAPNaviDestination;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray;
        if (this.val$address.getNaviType() == 2) {
            byArray = this.navigation.getNaviFavoriteHandler().getFavoriteNavLocationStreamByUniqueId(this.val$address.getNaviID());
        } else if (this.val$address.getNaviType() == 1) {
            byArray = this.navigation.getIntelliDestAccess().getLastDestHandler().getLastDestByteStream((int)this.val$address.getNaviID());
        } else {
            this.this$0.routeGuidanceActDeactResult(1);
            this.getCommandList().commandAborted(new StringBuffer().append("CombiBAPListeer#startRouteGuidance() uknown entry type: ").append(this.val$address).toString());
            return;
        }
        this.getCommandList().put("LOCATION_STREAM", byArray);
        this.getCommandList().commandFinished();
    }
}

