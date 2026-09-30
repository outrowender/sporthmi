/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIBase;

public interface DSIBrowserBoardbook
extends DSIBase {
    public static final String VERSION = "2.11.18";
    public static final int ATTR_BOARDBOOKSTATUS = 1;
    public static final int RT_STARTBOARDBOOK = 1000;
    public static final int RT_OPENPAGE = 1001;
    public static final int RT_SEARCH = 1002;
    public static final int RT_SETLANGUAGE = 1003;
    public static final int IN_INDICATESEARCHRESULTS = 3000;

    public void startBoardbook(int var1, String var2);

    public void setLanguage(String var1);

    public void openPage(int var1);

    public void search(String var1, int var2);
}

