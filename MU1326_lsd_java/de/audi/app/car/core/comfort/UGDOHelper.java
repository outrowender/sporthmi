/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.comfort;

import java.util.HashMap;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;

public class UGDOHelper {
    private static UGDOHelper ugdoHelper = new UGDOHelper();
    private static HashMap doorMovementStatesMap = new HashMap();
    private static HashMap syncStatesMap = new HashMap();

    public static String toString(UGDOSynchronisation uGDOSynchronisation) {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("state: ");
        stringBuffer.append(syncStatesMap.get(String.valueOf(uGDOSynchronisation.getState())));
        stringBuffer.append(", softKey: ");
        stringBuffer.append(uGDOSynchronisation.getSoftkey());
        stringBuffer.append(", doorMovement: ");
        stringBuffer.append(doorMovementStatesMap.get(String.valueOf(uGDOSynchronisation.getDoorMovement())));
        return stringBuffer.toString();
    }

    static {
        doorMovementStatesMap.put("15", "UGDOMOVEMENTSTATE_INIT");
        doorMovementStatesMap.put("0", "UGDOMOVEMENTSTATE_WAITINGFORUSER");
        doorMovementStatesMap.put("1", "UGDOMOVEMENTSTATE_NODOORMOVEMENT");
        doorMovementStatesMap.put("2", "UGDOMOVEMENTSTATE_DOORMOVEMENT");
        syncStatesMap.put("0", "UGDOSYNCSTATE_PRESSBUTTON");
        syncStatesMap.put("1", "UGDOSYNCSTATE_RESETRECEIVER");
        syncStatesMap.put("2", "UGDOSYNCSTATE_REPEATRESETRECEIVER");
        syncStatesMap.put("3", "UGDOSYNCSTATE_WRONGBUTTON");
        syncStatesMap.put("4", "UGDOSYNCSTATE_SUCCESSFUL");
        syncStatesMap.put("5", "UGDOSYNCSTATE_SYNCFAILED");
        syncStatesMap.put("6", "UGDOSYNCSTATE_CHECKMOVEMENT");
        syncStatesMap.put("7", "UGDOSYNCSTATE_SYNCABORTED");
        syncStatesMap.put("255", "UGDOSYNCSTATE_INIT");
    }
}

