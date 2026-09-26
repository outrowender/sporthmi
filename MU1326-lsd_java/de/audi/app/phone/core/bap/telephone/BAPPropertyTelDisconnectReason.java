/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.DisconnectReason;

class BAPPropertyTelDisconnectReason
extends AbstractTel1EnqueuedBAPPropertyHandler {
    BAPPropertyTelDisconnectReason(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    private int getBAPDisconnectReason(DisconnectReason disconnectReason) {
        if (disconnectReason != null) {
            int n;
            int n2 = disconnectReason.getDisconnectReason();
            switch (n2) {
                case 7: {
                    n = 8;
                    break;
                }
                case 9: {
                    n = 10;
                    break;
                }
                case 6: {
                    n = 7;
                    break;
                }
                case 13: {
                    n = 14;
                    break;
                }
                case 1: {
                    n = 1;
                    break;
                }
                case 0: {
                    n = 0;
                    break;
                }
                case 3: {
                    n = 4;
                    break;
                }
                case 10: {
                    n = 11;
                    break;
                }
                case 11: {
                    n = 12;
                    break;
                }
                case 4: {
                    n = 5;
                    break;
                }
                case 5: {
                    n = 6;
                    break;
                }
                case 14: {
                    n = 0;
                    break;
                }
                case 12: {
                    n = 13;
                    break;
                }
                case 2: {
                    n = 3;
                    break;
                }
                case 8: {
                    n = 9;
                    break;
                }
                default: {
                    this.log.log(-1601830656, "PhoneBapPropertyHandlerDisconnectReason#getBAPDisconnectReason: Couldn't map DSI value %1. Reverting to BAP value REASON_UNKNOWN.", (long)n2);
                    n = 14;
                }
            }
            return n;
        }
        return 14;
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return n == 0xB000100 || n == 0xB000200 || n == 0xB000300;
    }

    @Override
    protected void updateAsync() {
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState;
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState2 = iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() : null;
        if (iTelDSIMobileEquipmentDeviceState == null || combiBAPServicePhone == null) {
            this.log.log(-2137614336, "[BAPPropertyTelDisconnectReason#update nothing to update: callLeadingDeviceState OR combiService is null]");
            return;
        }
        int n = this.getBAPDisconnectReason(iTelDSIMobileEquipmentDeviceState.getDisconnectReason());
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("disonnect reason = ");
            buffer.append(n);
            this.log.log(1078071040, "[BAPPropertyTelDisconnectReason#update] updating cluster: %1", (Object)buffer);
        }
        combiBAPServicePhone.updateDisconnectReason(n);
    }
}

