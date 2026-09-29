/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipementTopologyAccess$1;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.TelDSIMobileEquipmentListener;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.ServiceProvider;

class TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipmentTopologyDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelDSIMobileEquipementTopologyAccess this$0;

    private TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipmentTopologyDiag(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess) {
        this.this$0 = telDSIMobileEquipementTopologyAccess;
    }

    public String getTopology() {
        return TelDSIMobileEquipementTopologyAccess.access$1000(this.this$0).toString();
    }

    public void cmdTogglePhones() {
        this.this$0.togglePhones(0, null, null);
    }

    public void cmdChangeTopology(int n, int n2, int n3) {
        TelDSIMobileEquipementTopologyAccess.access$2000(this.this$0, new int[]{n, n2, n3}, 0, null, null);
    }

    public void cmdDSIUpdateRegistrationState(int n, int n2, String string) {
        TelDSIMobileEquipmentListener telDSIMobileEquipmentListener;
        TelDSIMobileEquipmentListener telDSIMobileEquipmentListener2 = telDSIMobileEquipmentListener = TelDSIMobileEquipementTopologyAccess.access$800(this.this$0)[n] != null ? TelDSIMobileEquipementTopologyAccess.access$800(this.this$0)[n].getDsiListener() : null;
        if (telDSIMobileEquipmentListener != null) {
            RegisterStateStruct registerStateStruct = new RegisterStateStruct();
            registerStateStruct.telRegisterState = n2;
            registerStateStruct.telLongProviderName = string;
            registerStateStruct.telRegMode = 1;
            telDSIMobileEquipmentListener.updateRegisterState(registerStateStruct, 1);
        }
    }

    public void cmdDSIUpdateServiceProvider(int n, boolean bl, String string) {
        TelDSIMobileEquipmentListener telDSIMobileEquipmentListener;
        TelDSIMobileEquipmentListener telDSIMobileEquipmentListener2 = telDSIMobileEquipmentListener = TelDSIMobileEquipementTopologyAccess.access$800(this.this$0)[n] != null ? TelDSIMobileEquipementTopologyAccess.access$800(this.this$0)[n].getDsiListener() : null;
        if (telDSIMobileEquipmentListener != null) {
            ServiceProvider serviceProvider = new ServiceProvider();
            serviceProvider.displayConditionServiceProviderName = bl;
            serviceProvider.displayConditionProviderName = !bl;
            serviceProvider.telServiceProviderName = string;
            telDSIMobileEquipmentListener.updateServiceProvider(serviceProvider, 1);
        }
    }

    public String cmdTelFeature_ReadOut() {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess;
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess2;
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("\r\nActual tel features: \r\n");
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess3 = this.this$0.getPrimaryTelephoneAccess();
        if (iTelDSIMobileEquipmentDeviceAccess3 instanceof TelDSIMobileEquipmentDeviceAccess) {
            iTelDSIMobileEquipmentDeviceAccess2 = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess3;
            stringBuffer.append("\r\n Primary tel features: ");
            stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess2).getActivationState().getTelFeat());
            stringBuffer.append("\r\n   Primary Activation state: ");
            stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess2).getActivationState().toString());
        } else {
            stringBuffer.append("\r\n No primary device found");
        }
        iTelDSIMobileEquipmentDeviceAccess2 = this.this$0.getSecondaryTelephoneAccess();
        if (iTelDSIMobileEquipmentDeviceAccess2 instanceof TelDSIMobileEquipmentDeviceAccess) {
            iTelDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess2;
            stringBuffer.append("\r\n Associated tel features: ");
            stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess).getActivationState().getTelFeat());
            stringBuffer.append("\r\n   Associated Activation state: ");
            stringBuffer.append(((TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess).getActivationState().toString());
        } else {
            stringBuffer.append("\r\n No associated device found");
        }
        iTelDSIMobileEquipmentDeviceAccess = this.this$0.getDataOnlyNadAccess();
        if (iTelDSIMobileEquipmentDeviceAccess instanceof TelDSIMobileEquipmentDeviceAccess) {
            TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess;
            stringBuffer.append("\r\n Data tel features: ");
            stringBuffer.append(telDSIMobileEquipmentDeviceAccess.getActivationState().getTelFeat());
            stringBuffer.append("\r\n   Data Activation state: ");
            stringBuffer.append(telDSIMobileEquipmentDeviceAccess.getActivationState().toString());
        } else {
            stringBuffer.append("\r\n No data device found");
        }
        return stringBuffer.toString();
    }

    public String cmdTelFeature_Set_Readme() {
        String string = " \r\n The parameter for cmdTelFeature_Set is the sum of the needed tel features:  \r\n   -   1 = TELFEAT_INBAND \r\n   -   2 = TELFEAT_REJECTCALL ------------------  !!MANDATORY!! \r\n   -   4 = TELFEAT_RESPHOLD (In Japan) \r\n   -   8 = TELFEAT_THREEWAY \r\n   -  16 = TELFEAT_ENHCALL \r\n   -  32 = TELFEAT_ENHSTAT ------------------  !!MANDATORY!! \r\n   -  64 = TELFEAT_ADD_TO_CONFERENCE \r\n  Example: iphone (inband) that supports ADD_TO_CONFERENCE but does NOT supports ENHCALL = 1 + 2 + 8 + 32 + 64 = 107";
        return string;
    }

    public String cmdTelFeature_Set_Primary(int n) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.this$0.getPrimaryTelephoneAccess();
        if (iTelDSIMobileEquipmentDeviceAccess instanceof TelDSIMobileEquipmentDeviceAccess) {
            TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess;
            TelDSIMobileEquipementTopologyAccess.access$2100(this.this$0).log(1078071040, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipmentTopologyDiag#cmdTelFeature_Set_Primary] telFeat=%1", (long)n);
            telDSIMobileEquipmentDeviceAccess.getActivationState().telFeat = (short)n;
            telDSIMobileEquipmentDeviceAccess.updateGlobalTelephoneState(4);
            return telDSIMobileEquipmentDeviceAccess.getActivationState().toString();
        }
        return "\r\n No primary device found";
    }

    public String cmdTelFeature_Set_Associated(int n) {
        ITelDSIMobileEquipmentDeviceAccess iTelDSIMobileEquipmentDeviceAccess = this.this$0.getSecondaryTelephoneAccess();
        if (iTelDSIMobileEquipmentDeviceAccess instanceof TelDSIMobileEquipmentDeviceAccess) {
            TelDSIMobileEquipmentDeviceAccess telDSIMobileEquipmentDeviceAccess = (TelDSIMobileEquipmentDeviceAccess)iTelDSIMobileEquipmentDeviceAccess;
            TelDSIMobileEquipementTopologyAccess.access$2200(this.this$0).log(1078071040, "[TelDSIMobileEquipementTopologyAccess.TelDSIMobileEquipmentTopologyDiag#cmdTelFeature_Set_Associated] telFeat=%1", (long)n);
            telDSIMobileEquipmentDeviceAccess.getActivationState().telFeat = (short)n;
            telDSIMobileEquipmentDeviceAccess.updateGlobalTelephoneState(4);
            return telDSIMobileEquipmentDeviceAccess.getActivationState().toString();
        }
        return "\r\n No associated device found";
    }

    /* synthetic */ TelDSIMobileEquipementTopologyAccess$TelDSIMobileEquipmentTopologyDiag(TelDSIMobileEquipementTopologyAccess telDSIMobileEquipementTopologyAccess, TelDSIMobileEquipementTopologyAccess$1 telDSIMobileEquipementTopologyAccess$1) {
        this(telDSIMobileEquipementTopologyAccess);
    }
}

