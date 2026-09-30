/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;

public interface CombiBAPServiceAddressBook
extends CombiBAPService {
    public static final int PB_SPELLER_RESULT_MATCHING_ENTRIES_NOT_SUPPORTED_NO_MATCH = 65534;
    public static final int PB_SPELLER_RESULT_MATCHING_ENTRIES_NOT_SUPPORTED_MATCH = 65535;

    public void updateMobileServiceSupport(boolean var1, boolean var2, boolean var3);

    public void updatePbState(int var1, int var2);

    public void responsePhonebookListElements(int var1, CombiBAPPhonebookEntry[] var2);

    public void responsePhonebookEntryDetails(long var1, CombiBAPPhonebookEntryDetails[] var3);

    public void phonebookChanged(int var1);

    public void pbSpellerResult(int var1, int var2, int var3);

    public void updatePhonebookDownloadProgress(int var1, int var2, int var3, int var4);
}

