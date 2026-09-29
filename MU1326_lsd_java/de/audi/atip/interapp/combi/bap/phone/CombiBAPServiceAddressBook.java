/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPPhonebookEntryDetails;

public interface CombiBAPServiceAddressBook
extends CombiBAPService {
    public static final int PB_SPELLER_RESULT_MATCHING_ENTRIES_NOT_SUPPORTED_NO_MATCH;
    public static final int PB_SPELLER_RESULT_MATCHING_ENTRIES_NOT_SUPPORTED_MATCH;

    default public void updateMobileServiceSupport(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updatePbState(int n, int n2) {
    }

    default public void responsePhonebookListElements(int n, CombiBAPPhonebookEntry[] combiBAPPhonebookEntryArray) {
    }

    default public void responsePhonebookEntryDetails(long l, CombiBAPPhonebookEntryDetails[] combiBAPPhonebookEntryDetailsArray) {
    }

    default public void phonebookChanged(int n) {
    }

    default public void pbSpellerResult(int n, int n2, int n3) {
    }

    default public void updatePhonebookDownloadProgress(int n, int n2, int n3, int n4) {
    }
}

