/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.stat;

import de.audi.remotehmi.IRemoteHMI;
import de.audi.remotehmi.IRemoteHMIListener;
import de.audi.remotehmi.stat.DataInterface;

public interface IStaticRemoteHMI
extends IRemoteHMI {
    public void setInstanceId(int var1);

    public void setListener(IRemoteHMIListener var1);

    public void setDataInterface(DataInterface var1);
}

