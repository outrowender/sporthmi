/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

class OnlineSearchSequence$2
extends NavCommand {
    private final /* synthetic */ IStartGuidanceToDestinationSequence val$sequence;
    private final /* synthetic */ OnlineSearchSequence this$0;

    OnlineSearchSequence$2(OnlineSearchSequence onlineSearchSequence, String string, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
        this.this$0 = onlineSearchSequence;
        this.val$sequence = iStartGuidanceToDestinationSequence;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = OnlineSearchSequence.access$100(this.this$0).getCurrentlySelectedLocation();
        OnlineSearchSequence.access$000(this.this$0).log(1078071040, new StringBuffer().append(this.CLASS_NAME).append("#startRouteGuidance: %1").toString(), (Object)LocationFormatter.formatLocationShort(navLocation));
        this.this$0.startGuidance(navLocation, this.val$sequence, false);
        this.this$0.markCurrentResultUsedFor(10);
        this.getCommandList().commandFinished();
    }
}

