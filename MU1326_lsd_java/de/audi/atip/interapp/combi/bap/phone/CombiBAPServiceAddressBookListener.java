/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceAddressBookListener
extends CombiBAPServiceListener {
    default public void requestPhonebookListElements(int n, int n2, int n3) {
    }

    default public void requestPhonebookEntryDetails(long l) {
    }

    default public void pbSpeller(int n, String string) {
    }
}

