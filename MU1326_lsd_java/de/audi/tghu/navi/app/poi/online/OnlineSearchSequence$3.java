/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import org.dsi.ifc.global.NavLocation;

class OnlineSearchSequence$3
extends NavCommand {
    private final /* synthetic */ int val$searchContext;
    private final /* synthetic */ NavLocation val$referencePoint;
    private final /* synthetic */ OnlineSearchSequence this$0;

    OnlineSearchSequence$3(OnlineSearchSequence onlineSearchSequence, String string, int n, NavLocation navLocation) {
        this.this$0 = onlineSearchSequence;
        this.val$searchContext = n;
        this.val$referencePoint = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        switch (this.val$searchContext) {
            case 3: {
                OnlineSearchSequence.access$200(this.this$0).setPreviewLocation(this.val$referencePoint, 3, null, null);
                break;
            }
            case 1: 
            case 2: {
                OnlineSearchSequence.access$200(this.this$0).setPreviewDestination(this.val$referencePoint, 3, null, null);
                break;
            }
            default: {
                OnlineSearchSequence.access$200(this.this$0).setPreviewAreaAroundCCP(3);
            }
        }
        this.getCommandList().commandFinished();
    }
}

