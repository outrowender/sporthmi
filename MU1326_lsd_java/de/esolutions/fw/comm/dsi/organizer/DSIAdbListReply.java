/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public interface DSIAdbListReply {
    public static final String IPL_COMM_UUID = "42dbbcd2-3ea6-5bd5-bf1c-1688f4fb8458";
    public static final String IPL_COMM_INTERFACE_KEY = "1f064d36-4f05-57d2-af73-a3c0a190b478";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void updateViewSize(AdbViewSize var1, int var2) throws MethodException;

    public void invalidData(int var1) throws MethodException;

    public void stopSpellerResult(int var1, int var2) throws MethodException;

    public void spellerResult(int var1, int var2, DataSet[] var3, int var4, String var5, String var6) throws MethodException;

    public void validateSpellerCharsResult(int var1, int var2, String var3, String var4) throws MethodException;

    public void getViewWindowResult(int var1, DataSet[] var2, int var3) throws MethodException;

    public void getSpellerViewWindowResult(int var1, int var2, DataSet[] var3, int var4) throws MethodException;

    public void getValidHanziCharsWindowResult(int var1, int var2, int var3, String var4, int var5) throws MethodException;

    public void setListStyleResult(int var1) throws MethodException;

    public void updateAlphabeticalIndex(IndexInformation[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

