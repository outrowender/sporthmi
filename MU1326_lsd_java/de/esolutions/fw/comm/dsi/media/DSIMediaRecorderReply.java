/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaRecorderReply {
    public static final String IPL_COMM_UUID = "53731708-ed5a-5568-9cc2-de4fb8d324ab";
    public static final String IPL_COMM_INTERFACE_KEY = "c64e24f0-2106-5742-87b0-661dfecd5ce0";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void updateActiveMedia(long var1, long var3, int var5) throws MethodException;

    public void responseSetSelection(int var1, boolean var2) throws MethodException;

    public void updateImportSummary(long var1, long var3, long var5, long var7, long var9, long var11, int var13) throws MethodException;

    public void updateImportProgress(long var1, ListEntry var3, int var4) throws MethodException;

    public void updateImportStatus(int var1, int var2) throws MethodException;

    public void updateDeletionProgress(long var1, int var3) throws MethodException;

    public void updateDeletionStatus(int var1, int var2) throws MethodException;

    public void updateDatabaseSpace(DatabaseSpace var1, int var2) throws MethodException;

    public void updateTargetMedia(long var1, long var3, int var5) throws MethodException;

    public void responseSetEncodingQuality(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

