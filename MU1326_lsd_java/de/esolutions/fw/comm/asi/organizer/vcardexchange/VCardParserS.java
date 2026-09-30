/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.AdbEntry;

public interface VCardParserS {
    public void parseVCard(String var1, int var2, int var3, VCardParserReply var4) throws MethodException;

    public void parseVCardDirectory(String var1, int var2, int var3, VCardParserReply var4) throws MethodException;

    public void exportVCard(AdbEntry var1, String var2, int var3, VCardParserReply var4) throws MethodException;

    public void exportSmallVCard(AdbEntry var1, String var2, int var3, VCardParserReply var4) throws MethodException;

    public void finishParsing(int var1, VCardParserReply var2) throws MethodException;

    public void finishExport(int var1, int var2, VCardParserReply var3) throws MethodException;

    public void finishSmallExport(String var1, int var2, VCardParserReply var3) throws MethodException;

    public void setBinaryContentTempPath(String var1, VCardParserReply var2) throws MethodException;

    public void setBinaryContentQuotaPerFile(long var1, VCardParserReply var3) throws MethodException;

    public void setExtendedAddressHandling(boolean var1, VCardParserReply var2) throws MethodException;
}

