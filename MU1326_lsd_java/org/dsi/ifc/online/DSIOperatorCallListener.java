/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.OperatorCallResult;

public interface DSIOperatorCallListener
extends DSIListener {
    public void responseOperatorCallResult(int var1, OperatorCallResult[] var2);

    public void responseOperatorPhoneNumber(int var1, String var2, String[] var3, int var4);
}

