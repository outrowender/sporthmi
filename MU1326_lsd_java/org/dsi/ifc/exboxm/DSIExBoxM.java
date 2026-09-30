/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public interface DSIExBoxM
extends DSIBase {
    public static final String VERSION = "2.11.8";
    public static final int ATTR_AUDIOREQUEST = 1;
    public static final int ATTR_DISPLAYREQUEST = 2;
    public static final int ATTR_OPERATIONSTATE = 4;
    public static final int ATTR_ACTIVESOURCETYPE = 5;
    public static final int ATTR_CURRENTSTATIONINFO = 6;
    public static final int ATTR_MOBILEDEVICELINKSTATUS = 7;
    public static final int ATTR_PUBLICDEVICEADDRESS = 8;
    public static final int RT_DISPLAYCONTROL = 1000;
    public static final int RT_DISPLAYCURRENTVOLUME = 1001;
    public static final int RT_AUDIOREQUESTREJECTED = 1005;
    public static final int RT_DISPLAYREQUESTREJECTED = 1006;
    public static final int RT_VOLUMERANGE = 1007;
    public static final int RT_RESETTOFACTORY = 1008;
    public static final int RT_SETMOBILEDEVICELINK = 1009;
    public static final int RT_REQUESTCONNECTIONCONTROL = 1010;
    public static final int RP_RESPONSEDISPLAYCONTROL = 2000;
    public static final int RP_RESPONSEVOLUMERANGE = 2002;
    public static final int RP_RESPONSERESETTOFACTORY = 2003;
    public static final int RP_RESPONSECONNECTIONCONTROL = 2004;

    public void displayControl(int var1);

    public void displayCurrentVolume(int var1, int var2);

    public void audioRequestRejected(int var1, int var2);

    public void displayRequestRejected(int var1);

    public void volumeRange(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    public void resetToFactory();

    public void setMobileDeviceLink(MobileDeviceLinkStatus var1);

    public void requestConnectionControl(ConnectionControl var1, PublicDeviceAddress var2);
}

