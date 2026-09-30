/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public interface DSICarEcoC {
    public void requestBCmEConsumerList(BCmEListUpdateInfo var1) throws MethodException;

    public void setBCmELiveTip(int var1, boolean var2) throws MethodException;

    public void setBcmeSetFactoryDefault() throws MethodException;

    public void requestStartStopProhibitList(StartStopListUpdateInfo var1) throws MethodException;

    public void requestStartStopRestartList(StartStopListUpdateInfo var1) throws MethodException;

    public void requestStartStopRestartProhibitList(StartStopListUpdateInfo var1) throws MethodException;

    public void requestBCmEConsumerListConsumption(BCmEListUpdateInfo var1) throws MethodException;

    public void requestBCmEConsumerListRange(BCmEListUpdateInfo var1) throws MethodException;

    public void setRDSetFactoryDefault() throws MethodException;

    public void setEASystem(boolean var1) throws MethodException;

    public void setEAPedalJerk(boolean var1) throws MethodException;

    public void setEASetFactoryDefault() throws MethodException;

    public void setEAFreeWheeling(boolean var1) throws MethodException;

    public void setEAStartStop(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

