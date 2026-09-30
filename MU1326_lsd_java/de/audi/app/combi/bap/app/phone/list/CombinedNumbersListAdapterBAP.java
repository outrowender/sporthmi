/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_Data;
import de.vw.mib.bap.generated.telephone.serializer.CombinedNumbers_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class CombinedNumbersListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry;

    public CombinedNumbersListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 49, arrayHandler);
    }

    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[15];
        boolean bl2 = blArray[0] || blArray[1];
        boolean bl3 = blArray[0] || blArray[2];
        boolean bl4 = blArray[0] || blArray[1];
        boolean bl5 = blArray[0] || blArray[1];
        boolean bl6 = blArray[0] || blArray[2];
        return CombiBAPCallStackEntry.getRecordAddress(bl, bl2, bl3, bl4, bl5, bl6, bl6, bl6, bl6, bl6, bl6);
    }

    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        CombinedNumbers_Data combinedNumbers_Data = new CombinedNumbers_Data(arrayHeader);
        if (combiBAPArrayElement instanceof CombiBAPCallStackEntry) {
            CombiBAPCallStackEntry combiBAPCallStackEntry = (CombiBAPCallStackEntry)combiBAPArrayElement;
            combinedNumbers_Data.setPos(combiBAPCallStackEntry.getPosID());
            combinedNumbers_Data.pbName.setContent(combiBAPCallStackEntry.getPbName());
            combinedNumbers_Data.numberType = combiBAPCallStackEntry.getNumberType();
            combinedNumbers_Data.callMode = combiBAPCallStackEntry.getCallMode();
            combinedNumbers_Data.telNumber.setContent(combiBAPCallStackEntry.getTelNumber());
            combinedNumbers_Data.day = combiBAPCallStackEntry.getDay();
            combinedNumbers_Data.month = combiBAPCallStackEntry.getMonth();
            combinedNumbers_Data.year = combiBAPCallStackEntry.getYear() % 100;
            combinedNumbers_Data.hour = combiBAPCallStackEntry.getHour();
            combinedNumbers_Data.minute = combiBAPCallStackEntry.getMinute();
            combinedNumbers_Data.second = combiBAPCallStackEntry.getSecond();
        } else {
            this.logChannel.log(10000, "[CombinedNumbersListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry == null ? (class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry = CombinedNumbersListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry")) : class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPCallStackEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return combinedNumbers_Data;
    }

    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        CombinedNumbers_Data combinedNumbers_Data = new CombinedNumbers_Data(arrayHeader);
        combinedNumbers_Data.setPos(n);
        return combinedNumbers_Data;
    }

    protected ChangedArray createChangedArraySerializer() {
        return new CombinedNumbers_ChangedArray();
    }

    protected StatusArray createStatusArraySerializer() {
        return new CombinedNumbers_StatusArray();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

