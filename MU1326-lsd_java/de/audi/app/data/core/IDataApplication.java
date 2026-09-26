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
    public static final String MODULE_NAME;
    public static final String LOGCHANNEL;
    public static final String LOGCHANNEL_CMD;

    default public IConnectivity getConnectivity() {
    }

    default public IOnline getOnline() {
    }

    default public IDataSetup getDataSetup() {
    }

    default public IDataProfile getDataProfile() {
    }

    default public AbstractSimStateListener getSimStateListener() {
    }
}

