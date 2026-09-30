/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;

public interface CombiBAPServiceAddressBookListener
extends CombiBAPServiceListener {
    public void requestPhonebookListElements(int var1, int var2, int var3);

    public void requestPhonebookEntryDetails(long var1);

    public void pbSpeller(int var1, String var2);
}

