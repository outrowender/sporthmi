/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public interface IDSIFastListPhoneBook
extends IDSIFastListPhone {
    default public void responsePhoneBook(int n, int n2, int n3, int n4, ArrayHeader arrayHeader) {
    }

    default public void responsePhoneBookArray(DataPhonebook[] dataPhonebookArray) {
    }

    default public void responsePhoneBookJobs(int n, int n2) {
    }

    default public void pushCurrentListSizePhoneBook(int n) {
    }
}

