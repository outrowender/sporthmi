/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.MediatorRegistry;
import java.util.NoSuchElementException;

public interface MediatorManager
extends MediatorRegistry {
    public void fireEvent(int var1);

    public void lockScreen();

    public void unlockScreen();

    public HMIModel getModel(int var1) throws NoSuchElementException;

    public LogChannel getLogChannel();

    public LogChannel getEventLogChannel();

    public IFrameworkAccess getFramework();

    public void resetJumpBackPoint(int var1, int var2);
}

