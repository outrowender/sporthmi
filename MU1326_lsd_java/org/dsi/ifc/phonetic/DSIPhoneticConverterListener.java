/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.phonetic;

import org.dsi.ifc.base.DSIListener;

public interface DSIPhoneticConverterListener
extends DSIListener {
    public void hanziToPinYinResult(String var1, String var2, String var3, String var4);

    public void hanziToZhuYinResult(String var1, String var2, String var3, String var4);
}

