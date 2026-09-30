/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbEntry;

public interface DSIAdbEditC {
    public void insertEntry(AdbEntry var1, int var2) throws MethodException;

    public void getEntries(long[] var1, int var2, int var3) throws MethodException;

    public void getEntryDataSets(long[] var1, int var2, int var3) throws MethodException;

    public void changeEntry(AdbEntry var1, int var2) throws MethodException;

    public void copyEntry(long var1) throws MethodException;

    public void deleteEntries(long[] var1, int var2, int var3) throws MethodException;

    public void setSpeedDial(AdbEntry var1) throws MethodException;

    public void deleteSpeedDial(int var1) throws MethodException;

    public void getEntryByReferenceId(String var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

