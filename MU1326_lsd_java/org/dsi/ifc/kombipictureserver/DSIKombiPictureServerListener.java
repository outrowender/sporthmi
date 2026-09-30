/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombipictureserver;

import org.dsi.ifc.base.DSIListener;

public interface DSIKombiPictureServerListener
extends DSIListener {
    public void indicationCoverArt(long var1, int var3, int var4);

    public void indicationStationArt(long var1, int var3, int var4);

    public void indicationActiveCallPicture(int var1);

    public void indicationActiveCallPictureInstance(int var1, int var2);

    public void indicationDynamicIcon(int var1, int var2);

    public void indicationInternalAddressID(long var1, int var3);

    public void indicationAdbContactPicture(long var1, int var3);

    public void indicationPictureStreamAbilities();

    public void indicationPictureStream(int var1, short var2, short var3, int var4, int var5, int var6, int var7, byte[] var8);
}

