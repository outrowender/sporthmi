/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.stat;

import de.audi.remotehmi.IRemoteHMI;
import de.audi.remotehmi.IRemoteHMIListener;
import de.audi.remotehmi.stat.DataInterface;

public interface IStaticRemoteHMI
extends IRemoteHMI {
    default public void setInstanceId(int n) {
    }

    default public void setListener(IRemoteHMIListener iRemoteHMIListener) {
    }

    default public void setDataInterface(DataInterface dataInterface) {
    }
}

