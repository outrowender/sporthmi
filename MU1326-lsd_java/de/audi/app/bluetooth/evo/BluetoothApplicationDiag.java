/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.AbstractBluetoothApplicationDiag
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.bluetooth.evo;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.mib.swdiagnosis.connectivity.AbstractBluetoothApplicationDiag;
import de.mib.swdiagnosis.connectivity.IDiagComponent;

class BluetoothApplicationDiag
extends AbstractBluetoothApplicationDiag
implements IDiagComponent {
    BluetoothApplicationDiag(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }
}

