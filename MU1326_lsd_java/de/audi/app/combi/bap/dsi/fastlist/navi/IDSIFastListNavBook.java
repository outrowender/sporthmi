/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.dsi.fastlist.navi;

import de.audi.app.combi.bap.dsi.fastlist.navi.IDSIFastListNavi;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataAddress;

public interface IDSIFastListNavBook
extends IDSIFastListNavi {
    default public void responseNavBook(int n, int n2, int n3, int n4, ArrayHeader arrayHeader) {
    }

    default public void responseNavBookArray(DataAddress[] dataAddressArray) {
    }

    default public void responseNavBookJobs(int n, int n2) {
    }

    default public void pushCurrentListSizeNavBook(int n) {
    }
}

