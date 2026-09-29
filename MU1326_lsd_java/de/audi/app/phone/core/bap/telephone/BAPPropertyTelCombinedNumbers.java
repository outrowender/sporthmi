/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.addressbook.core.combi.bap.CombiADBUtils;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelTextFactory;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import de.audi.atip.interapp.phone.TelAdbEntryStruct;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class BAPPropertyTelCombinedNumbers
extends AbstractTel1EnqueuedBAPPropertyHandler {
    public static CombiBAPCallStackEntry[] getBAPCallStackEntries(CallStackEntry[] callStackEntryArray, ITelTextFactory iTelTextFactory, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        CombiBAPCallStackEntry[] combiBAPCallStackEntryArray = new CombiBAPCallStackEntry[callStackEntryArray.length];
        int n = 0;
        for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
            CombiBAPCallStackEntry combiBAPCallStackEntry;
            CallStackEntry callStackEntry = callStackEntryArray[i2];
            TelAdbEntryStruct telAdbEntryStruct = new TelAdbEntryStruct(callStackEntry.getClNumber(), callStackEntry.getClName(), callStackEntry.getAdbPictureID(), callStackEntry.getAdbEntryID(), callStackEntry.getAdbPhoneDataIndex(), callStackEntry.getAdbPhoneDataCount(), callStackEntry.getAdbNumberType());
            combiBAPCallStackEntryArray[i2] = combiBAPCallStackEntry = new CombiBAPCallStackEntry(n++, BAPPropertyTelCombinedNumbers.getName(callStackEntry, iTelTextFactory, iGlobalTelephoneStateStruct), callStackEntry.getClNumber(), CombiADBUtils.getCombiPhoneType(callStackEntry.getAdbNumberType()), BAPPropertyTelCombinedNumbers.getCallMode(callStackEntry.getClEntryType()), callStackEntry.getClDay(), callStackEntry.getClMonth(), callStackEntry.getClYear(), callStackEntry.getClHour(), callStackEntry.getClMinute(), callStackEntry.getClSecond(), telAdbEntryStruct);
        }
        return combiBAPCallStackEntryArray;
    }

    private static String getName(CallStackEntry callStackEntry, ITelTextFactory iTelTextFactory, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        String string = callStackEntry.getClNumber();
        if (iGlobalTelephoneStateStruct.isMailboxNumber(string)) {
            return iTelTextFactory.getText(0);
        }
        if (iGlobalTelephoneStateStruct.isInfoNumber(string)) {
            return iTelTextFactory.getText(2);
        }
        if (iGlobalTelephoneStateStruct.isEmergencyNumber(string)) {
            return iTelTextFactory.getText(4);
        }
        if (iGlobalTelephoneStateStruct.isBreakdownNumber(string)) {
            return iTelTextFactory.getText(3);
        }
        return callStackEntry.getClName();
    }

    private static int getCallMode(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        return 0;
    }

    public BAPPropertyTelCombinedNumbers(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return n == 671088896;
    }

    @Override
    protected void updateAsync() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        if (iGlobalTelephoneStateStruct != null) {
            CallStackEntry[] callStackEntryArray = this.getTelephoneState().getCombinedCallStackEntries();
            Object[] objectArray = BAPPropertyTelCombinedNumbers.getBAPCallStackEntries(callStackEntryArray, this.getApplication().getTextFactory(), this.getTelephoneState());
            CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
            if (combiBAPServicePhone != null) {
                this.log.log(1078071040, "[BAPPropertyTelCombinedNumbers#update] %1", (Object)TelLoggingUtils.objectArray2StringNewLines(objectArray));
                combiBAPServicePhone.updateCombinedNumbers((CombiBAPCallStackEntry[])objectArray);
            }
        } else {
            this.log.log(10000, "BAPPropertyTelCombinedNumbers#updateAsync state is null");
        }
    }
}

