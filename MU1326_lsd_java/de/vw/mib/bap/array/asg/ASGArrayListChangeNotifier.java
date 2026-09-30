/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.datatypes.BAPArrayDataList;

public interface ASGArrayListChangeNotifier {
    public void elementsInserted(ASGArrayList var1, int var2, BAPArrayDataList var3);

    public void elementsDeleted(ASGArrayList var1, int var2, BAPArrayDataList var3);

    public void elementsUpdated(ASGArrayList var1, int var2, BAPArrayDataList var3);

    public void reloaded(ASGArrayList var1);
}

