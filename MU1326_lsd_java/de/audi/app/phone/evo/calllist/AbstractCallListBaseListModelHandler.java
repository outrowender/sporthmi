/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.calllist;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.calllist.SingleCall;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.state.NullEcallState;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.app.phone.evo.intellicall.PhoneCallEvoListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.telephoneng.CallInformation;

public abstract class AbstractCallListBaseListModelHandler
extends AbstractPhoneComponent
implements BaseListModelListener {
    protected volatile IGlobalTelephoneStateStruct state;

    private static boolean isCallStateAllowed(AbstractPhoneCall abstractPhoneCall) {
        if (abstractPhoneCall == null) {
            return false;
        }
        int n = abstractPhoneCall.getTelCallState();
        return n == 4 || n == 2 || n == 1 || n == 5 && abstractPhoneCall.getPreviousCallState() != 3 || n == 6 || n == 8;
    }

    private static AbstractPhoneCall[] getCallsToShow(CallStateStruct callStateStruct) {
        AbstractPhoneCall[] abstractPhoneCallArray;
        ArrayList arrayList = new ArrayList();
        AbstractPhoneCall[] abstractPhoneCallArray2 = abstractPhoneCallArray = callStateStruct != null ? callStateStruct.getPhoneCalls() : null;
        if (abstractPhoneCallArray != null) {
            for (int i2 = 0; i2 < abstractPhoneCallArray.length; ++i2) {
                AbstractPhoneCall abstractPhoneCall = abstractPhoneCallArray[i2];
                if (abstractPhoneCall == null || !AbstractCallListBaseListModelHandler.isCallStateAllowed(abstractPhoneCall)) continue;
                arrayList.add(abstractPhoneCall);
            }
        }
        return (AbstractPhoneCall[])arrayList.toArray(new AbstractPhoneCall[arrayList.size()]);
    }

    public AbstractCallListBaseListModelHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getCallListList().setListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getCallListList().resetListener();
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.state = iGlobalTelephoneStateStruct;
        switch (n) {
            case 65543: 
            case 65550: 
            case 131079: 
            case 131086: 
            case 196615: 
            case 196622: {
                this.updateListModelWithCurrentState(iGlobalTelephoneStateStruct);
                break;
            }
            case 65544: 
            case 131080: 
            case 196616: {
                this.updateCallList(iGlobalTelephoneStateStruct);
                break;
            }
            case 262156: {
                this.updateEmergencyCallList(iGlobalTelephoneStateStruct);
                break;
            }
            default: {
                this.log.log(10000000, "[AbstractCallListBaseListModelHandler#updateGlobalTelephoneStateProperty] no handling for key %1", (long)n);
            }
        }
    }

    protected abstract EvoListRow getNewListRow(AbstractPhoneCall var1, IGlobalTelephoneStateStruct var2, int var3, LogChannel var4);

    protected abstract BaseListModelApp getCallListList();

    protected abstract void callSelected(EvoListRow var1, int var2);

    public void updateCallList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.updateListModel(iGlobalTelephoneStateStruct);
    }

    public void updateCallListAssociated(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.updateListModel(iGlobalTelephoneStateStruct);
    }

    public void updateCallDurationListAssociated(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.updateListModel(iGlobalTelephoneStateStruct);
    }

    public void updateEmergencyCallList(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        IEcallState iEcallState = iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getConnectedGatewayState() : new NullEcallState();
        PhoneCall phoneCall = iEcallState.getCall();
        if (iEcallState != null && iEcallState.isLowPrioritySOSEmergencyCallType() && phoneCall != null) {
            BaseListModelApp baseListModelApp = this.getCallListList().getCopy();
            CallInformation callInformation = new CallInformation((short)phoneCall.getId(), this.mapBAPCallStateToDSICallState(phoneCall.getState()), 0, PhoneUtils.getSOSCallTextConstant(this.getApplication().geEmergencyTextFactory(), iEcallState.getEmergencyNumberToBeDialed()), "", "", "", iEcallState.getEmergencyNumberToBeDialed(), null, 129, 3, 0L, 8, 0, null, 0);
            if (baseListModelApp.contains(phoneCall.getId())) {
                if (phoneCall.getState() != 0) {
                    int n = baseListModelApp.getIndexForUniqueID(phoneCall.getId());
                    PhoneCallEvoListRow phoneCallEvoListRow = (PhoneCallEvoListRow)baseListModelApp.getRow(n);
                    AbstractPhoneCall abstractPhoneCall = phoneCallEvoListRow.getCall();
                    abstractPhoneCall.updateCall(callInformation);
                    if (phoneCall.getState() == 4 || phoneCall.getState() == 7) {
                        abstractPhoneCall.setDisconnectReason(this.computeDisconnectReason(phoneCall.getState()));
                    }
                    PhoneCallEvoListRow phoneCallEvoListRow2 = new PhoneCallEvoListRow(abstractPhoneCall, this.log);
                    baseListModelApp.setRow(n, phoneCallEvoListRow2);
                } else {
                    baseListModelApp.removeAll();
                }
            } else {
                SingleCall singleCall = new SingleCall(callInformation);
                PhoneCallEvoListRow phoneCallEvoListRow = new PhoneCallEvoListRow(singleCall, this.log);
                baseListModelApp.removeAll();
                baseListModelApp.append(phoneCallEvoListRow);
            }
            this.getCallListList().update(baseListModelApp);
        }
    }

    private int computeDisconnectReason(int n) {
        if (n == 4) {
            return 0;
        }
        if (n == 7) {
            return 3;
        }
        return -1;
    }

    private int mapBAPCallStateToDSICallState(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 1;
                break;
            }
            case 4: {
                n2 = 5;
                break;
            }
            case 5: {
                n2 = 6;
                break;
            }
            case 1: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void updateListModelWithCurrentState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        AbstractPhoneCall[] abstractPhoneCallArray;
        CallStateStruct callStateStruct = this.getCallLeadingDeviceCallState(iGlobalTelephoneStateStruct);
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            return;
        }
        if (callStateStruct != null && (abstractPhoneCallArray = AbstractCallListBaseListModelHandler.getCallsToShow(callStateStruct)) != null) {
            BaseListModelApp baseListModelApp = this.getCallListList().getCopy();
            for (int i2 = 0; i2 < abstractPhoneCallArray.length; ++i2) {
                AbstractPhoneCall abstractPhoneCall = abstractPhoneCallArray[i2];
                if (abstractPhoneCall == null || !baseListModelApp.contains(abstractPhoneCall.getTelCallID())) continue;
                int n = baseListModelApp.getIndexForUniqueID(abstractPhoneCall.getTelCallID());
                EvoListRow evoListRow = this.getNewListRow(abstractPhoneCall, iGlobalTelephoneStateStruct, abstractPhoneCallArray.length, this.log);
                this.log.log(10000000, "[AbstractCallListBaseListModelHandler#updateListModelWithCurrentState] row[%2]=%1", (Object)evoListRow, (long)i2);
                baseListModelApp.setRow(n, evoListRow);
            }
            this.getCallListList().update(baseListModelApp);
        }
    }

    protected void updateListModel(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.log.log(10000000, "[AbstractCallListBaseListModelHandler#updateListModel] updating the list model.");
        CallStateStruct callStateStruct = this.getCallLeadingDeviceCallState(iGlobalTelephoneStateStruct);
        if (iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getConnectedGatewayState() != null && iGlobalTelephoneStateStruct.getConnectedGatewayState().isLowPrioritySOSEmergencyCallType()) {
            return;
        }
        try {
            if (callStateStruct != null) {
                boolean bl;
                BaseListModelApp baseListModelApp = this.getCallListList().getCopy();
                AbstractPhoneCall[] abstractPhoneCallArray = AbstractCallListBaseListModelHandler.getCallsToShow(callStateStruct);
                boolean bl2 = bl = abstractPhoneCallArray != null && abstractPhoneCallArray.length > 0;
                if (bl) {
                    baseListModelApp.removeAll();
                    this.addListRows(iGlobalTelephoneStateStruct, baseListModelApp, abstractPhoneCallArray);
                } else {
                    this.updateCallStateIdle(baseListModelApp);
                }
                this.getCallListList().update(baseListModelApp);
            }
        }
        catch (Exception exception) {
            this.log.log(10000, "[AbstractCallListBaseListModelHandler#updateListModel] %1", (Throwable)exception);
        }
    }

    private CallStateStruct getCallLeadingDeviceCallState(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice().getCallState() : null;
    }

    private void addListRows(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct, BaseListModelApp baseListModelApp, AbstractPhoneCall[] abstractPhoneCallArray) {
        if (abstractPhoneCallArray != null) {
            for (int i2 = 0; i2 < abstractPhoneCallArray.length; ++i2) {
                AbstractPhoneCall abstractPhoneCall = abstractPhoneCallArray[i2];
                if (!AbstractCallListBaseListModelHandler.isCallStateAllowed(abstractPhoneCall)) continue;
                EvoListRow evoListRow = this.getNewListRow(abstractPhoneCall, iGlobalTelephoneStateStruct, abstractPhoneCallArray.length, this.log);
                this.log.log(10000000, "[AbstractCallListBaseListModelHandler#addListRows] row[%2]=%1", (Object)evoListRow, (long)i2);
                baseListModelApp.append(evoListRow);
            }
        }
    }

    protected void updateCallStateIdle(BaseListModelApp baseListModelApp) {
        baseListModelApp.removeAll();
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(1000000, "[AbstractCallListBaseListModelHandler#itemSelected] %1", (Object)TelLoggingUtils.itemSelectedBaseList(evoListRow, n, n2, n3, n4));
        this.callSelected(evoListRow, n4);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }
}

