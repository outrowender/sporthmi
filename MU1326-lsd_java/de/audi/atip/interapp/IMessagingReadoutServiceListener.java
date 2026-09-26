/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMessagingReadoutServiceListener {
    default public void responseBeginDialog(int n) {
    }

    default public void responseEndDialog(int n) {
    }

    default public void responseReadoutMessage(int n) {
    }

    default public void indicateFolderContentListItemSelected(boolean bl) {
    }
}

