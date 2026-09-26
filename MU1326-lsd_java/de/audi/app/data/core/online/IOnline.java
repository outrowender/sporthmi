/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import org.dsi.ifc.bluetooth.ReconnectInfo;

public interface IOnline {
    default public void notifyLocalNetMode() {
    }

    default public void updateSimState(int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updateProfileState(int n) {
    }

    default public void updatePermissionGeneral(int n) {
    }

    default public void updatePermission(int n, int n2) {
    }

    default public void updatePermissionRoaming(int n) {
    }

    default public void roamingSettingDeactivatedByUser() {
    }

    default public void wlanHotspotActive(boolean bl) {
    }

    default public void onlineAppEntered() {
    }

    default public void onlineAppLeft() {
    }

    default public void onlineCheckEntered() {
    }

    default public void onlineCheckLeft() {
    }

    default public void onlinePopupEntered() {
    }

    default public void onlinePopupLeft() {
    }

    default public void onlinePopupRemoved() {
    }

    default public void onlineRequestEntered(int n) {
    }

    default public void telAppEntered() {
    }

    default public void telAppLeft() {
    }

    default public void telUnlockEntered() {
    }

    default public void telUnlockLeft() {
    }

    default public void hkTelPressed() {
    }

    default public void updateReconnectInfo(ReconnectInfo reconnectInfo) {
    }

    default public void updateWlanMode(boolean bl, boolean bl2) {
    }

    default public void updateTrustedNetworks(boolean bl) {
    }
}

