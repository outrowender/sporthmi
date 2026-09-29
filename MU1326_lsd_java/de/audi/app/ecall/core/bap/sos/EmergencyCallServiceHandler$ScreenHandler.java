/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.EcallUtil;
import de.audi.app.ecall.core.bap.sos.EmergencyCallServiceHandler;
import de.audi.app.ecall.core.bap.sos.ScreenContext;
import de.audi.app.ecall.core.state.IEcallStateStruct;

final class EmergencyCallServiceHandler$ScreenHandler {
    private final ScreenContext screenContext;
    private final /* synthetic */ EmergencyCallServiceHandler this$0;

    public EmergencyCallServiceHandler$ScreenHandler(EmergencyCallServiceHandler emergencyCallServiceHandler, ScreenContext screenContext) {
        this.this$0 = emergencyCallServiceHandler;
        this.screenContext = screenContext;
    }

    public void onCallServiceStateChanged(IEcallStateStruct iEcallStateStruct) {
        if (iEcallStateStruct.isEmergencyCallBackIncoming()) {
            EmergencyCallServiceHandler.access$000(this.this$0);
            EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.callBackIncomingScreen);
        } else if (iEcallStateStruct.isEmergencyConnecting()) {
            EmergencyCallServiceHandler.access$300(this.this$0, this.screenContext.connectingScreen);
        } else if (iEcallStateStruct.isEmergencyConnected()) {
            EmergencyCallServiceHandler.access$300(this.this$0, this.screenContext.connectedScreen);
        }
    }

    public void handleServiceState(int n) {
        if (EcallUtil.isStateValidForScreenActivation(EmergencyCallServiceHandler.access$400(this.this$0), n)) {
            EmergencyCallServiceHandler.access$500(this.this$0);
        }
        switch (n) {
            case 8: {
                EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.sendingDataScreen);
                break;
            }
            case 10: {
                EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.accomplishedScreen);
                break;
            }
            case 12: 
            case 21: {
                EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.failedScreen);
                break;
            }
            case 13: {
                EmergencyCallServiceHandler.access$600(this.this$0).getSOSPopupHandler().showLicencePopup();
                break;
            }
            case 9: 
            case 14: {
                EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.canceledScreen);
                break;
            }
            case 18: {
                EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.redialScreen);
                break;
            }
            case 7: {
                EmergencyCallServiceHandler.access$200(this.this$0, this.screenContext.redialScreen);
                break;
            }
            default: {
                EmergencyCallServiceHandler.access$700(this.this$0).log(-2137614336, "EmergencyCallServiceHandler#handleServiceState(): unhandled service call state for MEC/ACN %1 ", (long)n);
                EcallUtil.logStructFieldForDbg(EmergencyCallServiceHandler.access$800(this.this$0), EmergencyCallServiceHandler.class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState == null ? (EmergencyCallServiceHandler.class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState = EmergencyCallServiceHandler.class$("de.audi.atip.interapp.bap.ecall.data.ServiceRequestState")) : EmergencyCallServiceHandler.class$de$audi$atip$interapp$bap$ecall$data$ServiceRequestState, n);
            }
        }
    }
}

