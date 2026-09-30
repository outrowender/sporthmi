/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbDataResolutionListener
extends DSIListener {
    public void resolveMailAddressResult(int var1, DataSet[] var2);

    public void resolvePhoneNumbersResult(int var1, DataSet[] var2);
}

