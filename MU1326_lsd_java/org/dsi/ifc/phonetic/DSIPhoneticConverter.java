/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.phonetic;

import org.dsi.ifc.base.DSIBase;

public interface DSIPhoneticConverter
extends DSIBase {
    public static final String VERSION = "2.11.1";
    public static final int RT_HANZITOPINYIN = 1000;
    public static final int RT_HANZITOZHUYIN = 1001;
    public static final int RP_HANZITOPINYINRESULT = 2000;
    public static final int RP_HANZITOZHUYINRESULT = 2001;

    public void hanziToPinYin(String var1);

    public void hanziToZhuYin(String var1);
}

