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
    public boolean setPreferredLanguage(String var1);

    public boolean setParentalML(int var1);

    public boolean requestResetFactorySettings(int var1);

    public boolean eject(long var1, long var3);

    public boolean launchMediaApp(long var1, long var3, String var5);

    public void setFactorySettingListener(IMediaFactoryResetListener var1);

    public void addParentalManagementListener(IMediaParentalManagementListener var1);

    public void removeParentalManagementListener(IMediaParentalManagementListener var1);

    public void addLanguageListener(IMediaLanguageListener var1);

    public void addMediaDeviceListener(IMediaDeviceListener var1);

    public void addMediaVersionListener(IMediaVersionListener var1);

    public void removeMediaVersionListener(IMediaVersionListener var1);
}

