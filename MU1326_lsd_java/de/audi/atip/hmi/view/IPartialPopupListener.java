/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IPartialPopupListener {
    public void partialPopupVisible(int var1, int var2);

    public void partialPopupHidden(int var1, int var2);

    public void partialPopupRemoved(int var1, int var2);

    public int[] getPPIDsForCallbacks();

    public void partialPopupListenerRegistered(int var1, int var2, boolean var3);

    public void informAboutPPCoordinates(int var1, int var2, int var3, int var4, int var5, int var6);
}

