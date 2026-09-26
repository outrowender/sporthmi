/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.ConnectivityDiag
 */
package de.audi.app.connectivity.core;

import de.audi.app.connectivity.core.common.IClampStateProvider;
import de.audi.app.connectivity.core.common.PhoneProxy;
import de.mib.swdiagnosis.connectivity.ConnectivityDiag;

public interface IConnectivity {
    public static final String LOG_CHANNEL_NAME;

    default public ConnectivityDiag getDiagnosis() {
    }

    default public PhoneProxy getPhone() {
    }

    default public IClampStateProvider getClampStateProvider() {
    }
}

