/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.phone;

import de.audi.app.combi.bap.dsi.fastlist.phone.IDSIFastListPhone;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public interface IDSIFastListPhoneBook
extends IDSIFastListPhone {
    public void responsePhoneBook(int var1, int var2, int var3, int var4, ArrayHeader var5);

    public void responsePhoneBookArray(DataPhonebook[] var1);

    public void responsePhoneBookJobs(int var1, int var2);

    public void pushCurrentListSizePhoneBook(int var1);
}

