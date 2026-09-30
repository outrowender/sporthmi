/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.dsi.TelDSIUtils;
import de.audi.app.phone.core.state.CallStateStruct;
import de.audi.app.phone.core.state.GlobalTelephoneState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.interapp.phone.ITelCallControl;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.audi.atip.interapp.phone.ITelCallSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.telephoneng.CallInformation;

public class TelDialNumberSessionHandler
extends AbstractPhoneComponent {
    private final Object mapLock = new Object();
    private final Map numberToSessionMap = new HashMap();
    private final Map sessionActiveMap = new HashMap();

    public TelDialNumberSessionHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
    }

    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        if (n == 65544 || n == 65543 || n == 65553 || n == 131080 || n == 131079 || n == 131089 || n == 196616 || n == 196615 || n == 196625) {
            this.log.log(10000000, "[TelDialNumberSessionHandler#updateGlobalTelephoneStateProperty] update %1", (Object)GlobalTelephoneState.getAttributeName(n));
            ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = iGlobalTelephoneStateStruct.getCallLeadingDevice();
            if (iTelDSIMobileEquipmentDeviceState != null) {
                this.log.log(10000000, "[TelDialNumberSessionHandler#updateGlobalTelephoneStateProperty] call leading device role is %1", (Object)TelDSIUtils.getRoleName(iTelDSIMobileEquipmentDeviceState.getDeviceRole()));
                this.updateSessions(iTelDSIMobileEquipmentDeviceState.getCallState(), iTelDSIMobileEquipmentDeviceState.getmICMuteState());
            } else {
                this.log.log(100000, "[TelDialNumberSessionHandler#updateGlobalTelephoneStateProperty] callLeadingDeviceState is null --> NOP!");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void addSession(ITelCallSession iTelCallSession) {
        this.log.log(10000000, "[TelDialNumberSessionHandler#addSession] session=%1", (Object)iTelCallSession.getClass().getName());
        Object object = this.mapLock;
        synchronized (object) {
            this.numberToSessionMap.put(PhoneUtils.normalizeTelNumber(iTelCallSession.getTelephoneNumber()), iTelCallSession);
            this.sessionActiveMap.put(iTelCallSession, Boolean.FALSE);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateSessions(CallStateStruct callStateStruct, int n) {
        int n2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        ArrayList arrayList = new ArrayList();
        CallInformation[] callInformationArray = null;
        if (callStateStruct != null && (callInformationArray = callStateStruct.getDsiCallList()) != null) {
            for (int i2 = 0; i2 < callInformationArray.length; ++i2) {
                object4 = callInformationArray[i2];
                arrayList.add(((CallInformation)object4).getTelRemNumber());
                if (object4 == null) continue;
                object3 = this.mapLock;
                synchronized (object3) {
                    object2 = (ITelCallSession)this.numberToSessionMap.get(((CallInformation)object4).getTelRemNumber());
                    if (object2 != null && !((Boolean)this.sessionActiveMap.get(object2)).booleanValue()) {
                        object2.onActive(new TelCallControlHandler(((CallInformation)object4).getTelCallID()));
                        this.sessionActiveMap.put(object2, Boolean.TRUE);
                    }
                }
                if (object2 == null) continue;
                object3 = object2.getClass().getName();
                object = callStateStruct.getCall(((CallInformation)object4).getTelCallID());
                n2 = n == 0 ? 0 : 1;
                this.log.log(1000000, "[TelDialNumberSessionHandler#updateSessions] session=%1, phoneCall=%2, micMuteState=%3", object3, (Object)((CallInformation)object).getTelRemNumber(), (long)n2);
                object2.updateCallInformation((ITelCallInformation)object, n2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        object4 = this.mapLock;
        synchronized (object4) {
            object2 = this.numberToSessionMap.keySet().iterator();
            while (object2.hasNext()) {
                object3 = (String)object2.next();
                if (arrayList.contains(object3) || (n2 = ((Boolean)this.sessionActiveMap.get(object = (ITelCallSession)this.numberToSessionMap.get(object3))).booleanValue()) == 0) continue;
                this.log.log(10000000, "[TelDialNumberSessionHandler#updateSessions] adding session %1 to sessionsToInformIdle", (Object)object.getClass().getName());
                arrayList2.add(object);
                this.numberToSessionMap.remove(object3);
                this.sessionActiveMap.remove(object);
            }
        }
        object4 = arrayList2.iterator();
        while (object4.hasNext()) {
            object2 = (ITelCallSession)object4.next();
            if (object2 == null) continue;
            this.log.log(1000000, "[TelDialNumberSessionHandler#updateSessions] calling close on session %1", (Object)object2.getClass().getName());
            object2.onClose();
        }
    }

    private class TelCallControlHandler
    implements ITelCallControl {
        private final short telCallId;

        public TelCallControlHandler(short s) {
            this.telCallId = s;
        }

        public void hangupCall() {
            TelDialNumberSessionHandler.this.log.log(1000000, "[TelDialNumberSessionHandler.TelCallControlHandler#hangupCall] hanging up callID=%1", (long)this.telCallId);
            TelDialNumberSessionHandler.this.getApplication().getTelephoneDSIAccess().hangupCall(this.telCallId, 0);
        }

        public void muteMicrophone(boolean bl) {
            TelDialNumberSessionHandler.this.log.log(1000000, "[TelDialNumberSessionHandler.TelCallControlHandler#muteMicrophone] mute=%1", bl);
            int n = bl ? 0 : 1;
            TelDialNumberSessionHandler.this.getApplication().getTelephoneDSIAccess().requestSetMICMuteState(n, 0);
        }
    }
}

