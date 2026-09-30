/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import org.dsi.ifc.organizer.AdbEntry;

class b
implements VCardParserReply {
    b() {
    }

    public void a(int n, AdbEntry adbEntry) {
        if (n != 0) {
            System.err.println("EROR parsing vcard: " + n + " ... " + adbEntry);
        }
        System.out.println("received an answer: " + n + " ... " + adbEntry);
    }

    public void a(int n, String string) {
        System.out.println("Received an exportVCardResult answer: " + string);
    }

    public void exportFinished(int n, int n2) {
        System.out.println("Export finished.");
    }

    public void a() {
        System.out.println("Parsing finished.");
    }

    public void setBinaryContentQuotaPerFileResult(int n, long l) {
        System.out.println("setBinaryContentQuotaPerFileResult()");
    }

    public void setBinaryContentTempPathResult(int n, String string) {
        System.out.println("setBinaryContentTempPathResult()");
    }

    public void b(int n, String string) {
        System.out.println("exportSmallVCardResult()");
    }

    public void a(int n, AdbEntry[] adbEntryArray) {
        System.out.println("parseVCardDirectoryResult()");
    }

    public void a(int n, int[] nArray, int n2, String string) {
        System.out.println("smallExportFinished()");
    }

    public void a(int n) {
        new Exception().printStackTrace(System.out);
    }

    public void exportSmallVCardResult(int n, String string, int n2) {
        new Exception().printStackTrace(System.out);
    }

    public void exportVCardResult(int n, String string, int n2) {
        new Exception().printStackTrace(System.out);
    }

    public void parseVCardDirectoryResult(int n, AdbEntry[] adbEntryArray, int n2, int n3) {
        new Exception().printStackTrace(System.out);
    }

    public void parseVCardResult(int n, AdbEntry adbEntry, int n2, int n3) {
        new Exception().printStackTrace(System.out);
    }

    public void parsingFinished(int n) {
        new Exception().printStackTrace(System.out);
    }

    public void smallExportFinished(int n, long[] lArray, int n2, String string, int n3) {
        new Exception().printStackTrace(System.out);
    }
}

