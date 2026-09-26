/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.interapp.OnlinePOICallHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.properties.Property;

class OnlinePOICallHandler$2
extends AbstractCommand {
    private final /* synthetic */ boolean val$poiCallActive;
    private final /* synthetic */ OnlinePOICallHandler this$0;

    OnlinePOICallHandler$2(OnlinePOICallHandler onlinePOICallHandler, LogChannel logChannel, String string, IContext iContext, boolean bl) {
        this.this$0 = onlinePOICallHandler;
        this.val$poiCallActive = bl;
        super(logChannel, string, iContext);
    }

    @Override
    public void execute() {
        TMState tMState = OnlinePOICallHandler.access$000(this.this$0).getCurrentState();
        Property property = this.context.getSmartphoneDSIManager().getSmartphoneProperties().getPropertyMUPhonecallActive();
        if (null == property) {
            OnlinePOICallHandler.access$100(this.this$0).log(-1601830656, "[%1.execute] property is null", (Object)"OnlinePOICallHandler");
        } else {
            property.accept(new Boolean(this.val$poiCallActive));
            tMState.setAccessRestricted(Resource.AUDIO_MEDIA, this.val$poiCallActive);
            OnlinePOICallHandler.access$000(this.this$0).updateState(tMState);
        }
        this.getCommandList().commandFinished();
    }
}

