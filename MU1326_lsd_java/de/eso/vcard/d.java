/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard;

import de.eso.a.d.b;
import de.eso.vcard.b.g;
import de.eso.vcard.c;
import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserS;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserService;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.organizer.AdbEntry;

public class d
implements VCardParserS {
    private int c = 0;
    private static c d;
    private int e = 0;
    private List f = new LinkedList();
    public static final int a = 8192;
    private static final String[] g;
    public static final Collection b;

    public d(int n) {
        de.eso.a.d.b.c("JVCARDPARSER is starting on instance " + n);
        de.eso.vcard.b.g.a((String[])b.toArray(new String[0]));
        this.c = n;
        if (d == null) {
            d = new c("VCardParseWorker", 500);
        }
    }

    public void a() {
        de.eso.a.d.b.b("-> JVCARDPARSER[" + this.c + "] initialization started.");
        Agent.start();
        VCardParserService vCardParserService = new VCardParserService(this.c, this);
        Agent.getAgent().registerService(vCardParserService);
        d.start(5);
        de.eso.a.d.b.b("<- JVCARDPARSER[" + this.c + "] initialization done.");
    }

    public void b() {
        if (d != null && this.e == 1) {
            d.stop();
            this.e = 0;
        } else {
            --this.e;
        }
        TraceClient.exit();
    }

    public void c() {
        if (this.e == 0 && d != null) {
            d.start(5);
        }
        ++this.e;
    }

    public void a(String[] stringArray) {
        de.eso.vcard.b.g.a(stringArray);
    }

    public void parseVCard(String string, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.a.d.b.c(string + " should be parsed.");
        if (string == null) {
            de.eso.a.d.b.d("vcdFile was null");
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        File file = new File(string);
        if (!file.exists()) {
            de.eso.a.d.b.d("VCard not found: " + file.getAbsolutePath());
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        d.a(file, n, n2, vCardParserReply);
    }

    public void a(InputStream inputStream, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.a.d.b.c(inputStream + " should be parsed.");
        if (inputStream == null) {
            de.eso.a.d.b.d("stream was null");
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        d.a(inputStream, n, n2, vCardParserReply);
    }

    public void parseVCardDirectory(String string, int n, int n2, VCardParserReply vCardParserReply) {
        de.eso.a.d.b.c("vCard directory " + string + " should be parsed.");
        if (string == null) {
            de.eso.a.d.b.d("fullPathToVCardDir was null");
            vCardParserReply.parseVCardResult(2, null, n, n2);
            return;
        }
        d.a(string, n, n2, vCardParserReply);
    }

    public void exportVCard(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
        d.a(adbEntry, string, n, vCardParserReply);
    }

    public void a(int n, VCardParserReply vCardParserReply) {
        d.a(n, 0, vCardParserReply);
    }

    public void finishExport(int n, int n2, VCardParserReply vCardParserReply) {
        d.a(n, n2, vCardParserReply);
    }

    public void finishParsing(int n, VCardParserReply vCardParserReply) {
        d.a(n, vCardParserReply);
    }

    public void setBinaryContentQuotaPerFile(long l, VCardParserReply vCardParserReply) {
        de.eso.vcard.b.g.a(l);
        vCardParserReply.setBinaryContentQuotaPerFileResult(0, l);
    }

    public void setBinaryContentTempPath(String string, VCardParserReply vCardParserReply) {
        if (string == null) {
            vCardParserReply.setBinaryContentTempPathResult(2, null);
            return;
        }
        File file = new File(string);
        if (!file.exists() || !file.canWrite()) {
            vCardParserReply.setBinaryContentTempPathResult(2, string);
            return;
        }
        de.eso.vcard.b.g.a(new File(string));
        vCardParserReply.setBinaryContentTempPathResult(0, string);
    }

    public void exportSmallVCard(AdbEntry adbEntry, String string, int n, VCardParserReply vCardParserReply) {
        d.a(adbEntry, string, n, this.f, vCardParserReply);
    }

    public void finishSmallExport(String string, int n, VCardParserReply vCardParserReply) {
        d.a(n, this.f, string, vCardParserReply);
    }

    public void setExtendedAddressHandling(boolean bl, VCardParserReply vCardParserReply) {
        de.eso.vcard.b.g.a(bl);
    }

    static {
        g = new String[]{"BEGIN", "VERSION", "END", "N", "FN", "EMAIL", "BDAY", "URL", "ADR", "TEL", "ORG", "PHOTO", "GEO", "X-MIB_HIGH_NAV_LOCATION", "SOUND", "X-PHONETIC-FIRST-NAME", "X-PHONETIC-LAST-NAME"};
        b = Collections.unmodifiableCollection(Arrays.asList(g));
        Collections.unmodifiableCollection(Arrays.asList(g));
    }
}

