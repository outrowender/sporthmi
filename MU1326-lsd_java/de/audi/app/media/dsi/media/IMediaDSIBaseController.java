/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.IDSIController;
import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.dsi.media.IMediaFactoryResetListener;
import de.audi.app.media.dsi.media.IMediaLanguageListener;
import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.app.media.dsi.media.IMediaVersionListener;

public interface IMediaDSIBaseController
extends IDSIController {
    default public boolean setPreferredLanguage(String string) {
    }

    default public boolean setParentalML(int n) {
    }

    default public boolean requestResetFactorySettings(int n) {
    }

    default public boolean eject(long l, long l2) {
    }

    default public boolean launchMediaApp(long l, long l2, String string) {
    }

    default public void setFactorySettingListener(IMediaFactoryResetListener iMediaFactoryResetListener) {
    }

    default public void addParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
    }

    default public void removeParentalManagementListener(IMediaParentalManagementListener iMediaParentalManagementListener) {
    }

    default public void addLanguageListener(IMediaLanguageListener iMediaLanguageListener) {
    }

    default public void addMediaDeviceListener(IMediaDeviceListener iMediaDeviceListener) {
    }

    default public void addMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
    }

    default public void removeMediaVersionListener(IMediaVersionListener iMediaVersionListener) {
    }
}

