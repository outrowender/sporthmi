/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;

public interface ASGArrayListDelegate {
    public void requestGetArray(ASGArrayList var1, BAPGetArray var2);

    public void requestSetGetArray(ASGArrayList var1, BAPSetGetArray var2);

    public void requestTimeout(ASGArrayList var1, int var2, boolean var3);

    public int getMaxRequestableElements(ASGArrayList var1, int var2);

    public int getDefaultRecordAddress(ASGArrayList var1);

    public boolean continueLoading(ASGArrayList var1);

    public Logger getLogger(ASGArrayList var1);
}

