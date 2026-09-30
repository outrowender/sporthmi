/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIListener;

public interface DSIObjectPushListener
extends DSIListener {
    public void updateOPPIncomingObject(String var1, String var2, int var3, int var4);

    public void responseOPPAbortSending(int var1);

    public void responseOPPAcceptObject(int var1);

    public void responseOPPSendContacts(int var1);

    public void responseOPPSendMessages(int var1);

    public void responseOPPSendBinary(int var1);

    public void updateVCardsReceived(String var1, int var2);
}

