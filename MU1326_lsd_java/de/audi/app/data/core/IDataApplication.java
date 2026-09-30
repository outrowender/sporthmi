/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.app.connectivity.core.IApplication;
import de.audi.app.connectivity.core.IConnectivity;
import de.audi.app.data.core.online.AbstractSimStateListener;
import de.audi.app.data.core.online.IOnline;
import de.audi.app.data.core.profile.IDataProfile;
import de.audi.app.data.core.setup.IDataSetup;

public interface IDataApplication
extends IApplication {
    public static final String MODULE_NAME = "AppData";
    public static final String LOGCHANNEL = "App.Data.Main";
    public static final String LOGCHANNEL_CMD = "App.Data.Commands";

    public IConnectivity getConnectivity();

    public IOnline getOnline();

    public IDataSetup getDataSetup();

    public IDataProfile getDataProfile();

    public AbstractSimStateListener getSimStateListener();
}

