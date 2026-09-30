/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataAddress;

public interface IDSIFastListNavBook
extends IDSIFastListNavi {
    public void responseNavBook(int var1, int var2, int var3, int var4, ArrayHeader var5);

    public void responseNavBookArray(DataAddress[] var1);

    public void responseNavBookJobs(int var1, int var2);

    public void pushCurrentListSizeNavBook(int var1);
}

