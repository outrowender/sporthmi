/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone.list;

import de.audi.app.bap.fw.arrays.AbstractListAdapterBAP;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_ChangedArray;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_Data;
import de.vw.mib.bap.generated.telephone.serializer.Phonebook_StatusArray;
import de.vw.mib.bap.requests.ChangedArray;
import de.vw.mib.bap.requests.StatusArray;

public class PhonebookListAdapterBAP
extends AbstractListAdapterBAP {
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry;

    public PhonebookListAdapterBAP(AbstractCombiModule abstractCombiModule, ArrayHandler arrayHandler) {
        super(abstractCombiModule, 52, arrayHandler);
    }

    protected int getCommonRecordAddress(boolean[] blArray) {
        boolean bl = blArray[0] || blArray[15];
        boolean bl2 = blArray[0] || blArray[1] || blArray[3];
        boolean bl3 = blArray[0] || blArray[1];
        boolean bl4 = blArray[0] || blArray[1] || blArray[3] || blArray[4];
        boolean bl5 = blArray[0] || blArray[1] || blArray[3] || blArray[4];
        boolean bl6 = blArray[0] || blArray[2] || blArray[4];
        return CombiBAPPhonebookEntry.getRecordAddress(bl, bl2, bl3, bl4, bl5, bl6);
    }

    protected BAPArrayElement convertArrayElement(CombiBAPArrayElement combiBAPArrayElement, ArrayHeader arrayHeader) {
        Phonebook_Data phonebook_Data = null;
        if (combiBAPArrayElement instanceof CombiBAPPhonebookEntry) {
            CombiBAPPhonebookEntry combiBAPPhonebookEntry = (CombiBAPPhonebookEntry)combiBAPArrayElement;
            CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray = combiBAPPhonebookEntry.getDetails();
            if (combiBAPPhonebookEntryDetailsArray != null) {
                phonebook_Data = new Phonebook_Data(arrayHeader, combiBAPPhonebookEntryDetailsArray.length);
                if (phonebook_Data.telNumberQuantity != combiBAPPhonebookEntryDetailsArray.length) {
                    this.logChannel.log(100000, "[PhonebookListAdapterBAP#convertPhonebookEntry] details length(%1) doesn't match telNumberQuantity(%2)", (long)combiBAPPhonebookEntryDetailsArray.length, (long)phonebook_Data.telNumberQuantity);
                }
                for (int i2 = 0; i2 < combiBAPPhonebookEntryDetailsArray.length && i2 < phonebook_Data.telNumberQuantity; ++i2) {
                    phonebook_Data.telNumberN[i2].setContent(combiBAPPhonebookEntryDetailsArray[i2].getTelNumber());
                    phonebook_Data.numberTypeN[i2] = combiBAPPhonebookEntryDetailsArray[i2].getNumberType();
                }
            } else {
                phonebook_Data = new Phonebook_Data(arrayHeader, 0);
            }
            phonebook_Data.setPos(combiBAPPhonebookEntry.getPosID());
            phonebook_Data.pbName.setContent(combiBAPPhonebookEntry.getPbName());
            phonebook_Data.storage = combiBAPPhonebookEntry.getStorage();
            phonebook_Data.telNumberQuantity = combiBAPPhonebookEntry.getTelNumberQuantity();
        } else {
            this.logChannel.log(10000, "[PhonebookListAdapterBAP#convertArrayElement] wrong dataType (expected: %1, is: %2)", (Object)(class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry == null ? (class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry = PhonebookListAdapterBAP.class$("de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry")) : class$de$audi$atip$interapp$combi$bap$phone$data$CombiBAPPhonebookEntry).getName(), (Object)combiBAPArrayElement.getClass().getName());
        }
        return phonebook_Data;
    }

    protected BAPArrayElement createArrayElement(ArrayHeader arrayHeader, int n) {
        Phonebook_Data phonebook_Data = new Phonebook_Data(arrayHeader, 0);
        phonebook_Data.setPos(n);
        return phonebook_Data;
    }

    protected ChangedArray createChangedArraySerializer() {
        return new Phonebook_ChangedArray();
    }

    protected StatusArray createStatusArraySerializer() {
        return new Phonebook_StatusArray();
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

