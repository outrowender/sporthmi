/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMessagingReadoutServiceListener {
    public void responseBeginDialog(int var1);

    public void responseEndDialog(int var1);

    public void responseReadoutMessage(int var1);

    public void indicateFolderContentListItemSelected(boolean var1);
}

