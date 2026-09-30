/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sfa;

import org.dsi.ifc.base.DSIBase;

public interface DSISFA
extends DSIBase {
    public static final String VERSION = "2.11.1";
    public static final int ATTR_AUDIOREQUEST = 1;
    public static final int ATTR_DISPLAYREQUEST = 2;
    public static final int RT_AUDIOREQUESTRESULT = 1000;
    public static final int RT_DISPLAYREQUESTRESULT = 1001;
    public static final int RT_REQUESTKEYTOUCHEVALUATION = 1002;
    public static final int RT_REQUESTDISPLAYNOTVISIBLE = 1003;
    public static final int RP_RESPONSEKEYTOUCHEVALUATION = 2000;
    public static final int RP_RESPONSEDISPLAYNOTVISIBLE = 2001;

    public void audioRequestResult(int var1, int var2);

    public void displayRequestResult(int var1, int var2);

    public void requestKeyTouchEvaluation(int var1);

    public void requestDisplayNotVisible();
}

