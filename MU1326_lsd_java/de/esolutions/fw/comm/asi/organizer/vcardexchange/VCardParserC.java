/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbEntry;

public interface VCardParserC {
    public void parseVCard(String var1, int var2, int var3) throws MethodException;

    public void parseVCardDirectory(String var1, int var2, int var3) throws MethodException;

    public void exportVCard(AdbEntry var1, String var2, int var3) throws MethodException;

    public void exportSmallVCard(AdbEntry var1, String var2, int var3) throws MethodException;

    public void finishParsing(int var1) throws MethodException;

    public void finishExport(int var1, int var2) throws MethodException;

    public void finishSmallExport(String var1, int var2) throws MethodException;

    public void setBinaryContentTempPath(String var1) throws MethodException;

    public void setBinaryContentQuotaPerFile(long var1) throws MethodException;

    public void setExtendedAddressHandling(boolean var1) throws MethodException;
}

