/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.dsi;

import de.audi.atip.interapp.displaymanager.Cropping;
import org.dsi.ifc.tvtuner.ServiceInfo;

public interface DSITV {
    default public void setNormAreaSubList(int[] nArray) {
    }

    default public void setNormArea(int n) {
    }

    default public void setAudioChannel(int n) {
    }

    default public void enableServiceLinking(boolean bl) {
    }

    default public void enableSubtitle(boolean bl) {
    }

    default public void selectService(ServiceInfo serviceInfo, boolean bl) {
    }

    default public void changeService(ServiceInfo serviceInfo, boolean bl) {
    }

    default public void selectNextService(int n) {
    }

    default public void abortSeek() {
    }

    default public void switchSource(int n, boolean bl) {
    }

    default public void setTerminalMode(int n, int n2) {
    }

    default public void setTMTVKeyPanel(short s, short s2) {
    }

    default public void incMoved(int n) {
    }

    default public void setAVNorm(int n) {
    }

    default public void setBrowserListSort(int n) {
    }

    default public void setCropping(Cropping cropping, int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void setBrightness(int n, int n2) {
    }

    default public void setContrast(int n, int n2) {
    }

    default public void setColor(int n, int n2) {
    }

    default public void setTint(int n, int n2) {
    }

    default public void startComponent(int n) {
    }

    default public void startComponent(int n, int n2, int n3) {
    }

    default public void stopComponent(int n) {
    }

    default public void stopComponent(int n, int n2, int n3) {
    }
}

