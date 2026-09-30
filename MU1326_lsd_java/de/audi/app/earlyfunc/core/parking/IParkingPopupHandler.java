/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

public interface IParkingPopupHandler {
    public void registerPopup(int var1);

    public void unregisterPopup(int var1);

    public void showPopup(int var1);

    public void removeCurrentPopup(int var1);

    public boolean isPopupActive();
}

