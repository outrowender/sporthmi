/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcalendar.starter.client;

import de.eso.vcalendar.starter.client.Activator;
import de.eso.vcalendar.starter.client.b;
import de.eso.vcalendar.starter.client.d;
import de.esolutions.fw.comm.asi.calendar.db.provider.VCalendarDbProviderReply;
import de.esolutions.fw.comm.asi.calendar.db.provider.VersionInfo;
import de.esolutions.fw.comm.asi.calendar.db.provider.impl.VCalendarDbProviderProxy;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.calendar.VEvent;
import org.osgi.framework.BundleContext;

public class a
implements VCalendarDbProviderReply,
ILifecycleListener {
    private static final String[] e = new String[]{"myEven.ics", "test_attaced.ics", "4.4_bastille_day_party.ics", "4.6.1_anniversary_implicitly_transparent.ics", "4.6.1_business_event.ics", "4.6.1_transparent.ics", "eso_Brotzeitservice_Outlook2007.ics", "sc_calendar.ics", "test_attaced.ics", "test.ics", "Ferien_Bayern_2010.ics", "Ferien_Bayern_2011.ics", "Ferien_Bayern_2012.ics", "Kalenderwochen-2011-2020.ics"};
    int a = 0;
    private static final int f = 500;
    private int g;
    private VCalendarDbProviderProxy h = null;
    private Proxy i = null;
    d b = null;
    private TraceChannel j;
    Timer c = new Timer(true);
    TimerTask d = new b(this);

    public a(int n, BundleContext bundleContext) {
        TraceClient.init("VCalendarDbProviderReply");
        this.j = TraceClient.createTraceChannel("VCalendarDbProviderReply");
        this.g = n;
        this.h = new VCalendarDbProviderProxy(n, this);
        this.h.getProxy().getLifecycle().setListener(this);
        this.i = this.h.getProxy();
        this.i.connectAsync();
        de.eso.a.d.b.c("VCalendarParser starting on instance id=" + this.g);
        this.c.schedule(this.d, 140000L, 20000L);
        if (this.b == null) {
            de.eso.a.d.b.c("SerializationWorker starting");
            this.b = new d("SerializationWorker", 500);
            de.eso.a.d.b.c("SerializationWorker started");
            this.b.start(Activator.a);
        }
    }

    public boolean a() {
        boolean bl = false;
        if (this.h == null) {
            this.h = new VCalendarDbProviderProxy(this.g, this);
            if (this.h != null) {
                this.i = this.h.getProxy();
                if (this.i != null) {
                    // empty if block
                }
            }
        } else if (this.i == null) {
            this.i = this.h.getProxy();
            Lifecycle lifecycle = this.i.getLifecycle();
            if (lifecycle != null) {
                lifecycle.setListener(this);
            }
        }
        if (this.i != null) {
            bl = this.i.isAlive() ? true : this.i.connectAsync();
        }
        return bl;
    }

    public boolean b() {
        boolean bl = true;
        if (this.h != null && this.i != null) {
            try {
                if (this.i.isAlive()) {
                    this.i.disconnectAsync();
                    this.i.waitUntilDead();
                }
            }
            catch (InterruptedException interruptedException) {
                bl = false;
            }
            this.i = null;
            this.h = null;
        }
        return bl;
    }

    public void c() {
        if (this.i != null) {
            de.eso.a.d.b.c("CalendarDBClient alive state =" + this.i.isAlive());
        }
    }

    public void d() {
        this.b();
        try {
            this.a();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void e() {
        de.eso.a.d.b.b("-> JVCALENDAR[" + this.g + "] initialization started.");
        this.b.start(Activator.a);
        de.eso.a.d.b.b("<- JVCALENDAR[" + this.g + "] initialization done.");
    }

    private boolean a(int n) {
        boolean bl = true;
        switch (n) {
            case 0: {
                bl = false;
                break;
            }
            case 2: {
                break;
            }
            case 4: {
                break;
            }
            case 3: {
                break;
            }
        }
        return bl;
    }

    public void a(String string) {
        this.j.log((short)3, "_______________>parseVCalendar<_______________");
        de.eso.a.d.b.c(string + " should be parsed.");
        File file = new File(string);
        if (!file.exists()) {
            de.eso.a.d.b.d("VCalendar not found: " + file.getAbsolutePath());
            return;
        }
        if (this.h != null && this.i != null && this.i.isAlive()) {
            this.b.a(file, this.g, this.h);
            this.j.log((short)3, "_______________>worker.addSerializeObject added <_______________");
        }
    }

    public void a(int n, int n2, VCalendar[] vCalendarArray) {
        this.h.addEntries(n, n2, vCalendarArray);
    }

    public void addEntriesResult(int n) {
        this.j.log((short)3, "_______________>addEntriesResult <_______________");
        this.a(n);
    }

    public void beginTransactionResult(int n) {
    }

    public void commitTransactionResult(int n) {
        this.h.commitTransaction();
    }

    public void forceGetData() {
        int n = 0;
        this.h.forceGetDataResult(n);
    }

    public void a(VersionInfo[] versionInfoArray) {
    }

    public void removeAllResult(int n) {
    }

    public void removeEntriesResult(int n) {
    }

    public void removeProfileResult(int n) {
    }

    public void setActiveProfilesResult(int n) {
    }

    public void lifecycleChanged(Lifecycle lifecycle, Object object) {
        this.j.log((short)3, "_______________>lifecycleChanged: Connected <_______________");
    }

    public void getVersionResult(VersionInfo[] versionInfoArray) {
    }

    public void deleteProfileResult(int n) {
    }

    public void getCalendarConfigResult(int n, CalendarConfig calendarConfig) {
    }

    public void getCalendarEntryResult(int n, VEvent vEvent) {
    }

    public void getCalendarSummariesResult(int n, VEvent[] vEventArray) {
    }

    public void insertProfileResult(int n) {
    }

    public void setCalendarConfigResult(int n) {
    }

    static Proxy a(a a2) {
        return a2.i;
    }

    static VCalendarDbProviderProxy a(a a2, VCalendarDbProviderProxy vCalendarDbProviderProxy) {
        a2.h = vCalendarDbProviderProxy;
        return a2.h;
    }

    static Proxy a(a a2, Proxy proxy) {
        a2.i = proxy;
        return a2.i;
    }

    static int b(a a2) {
        return a2.g;
    }

    static VCalendarDbProviderProxy c(a a2) {
        return a2.h;
    }

    static TraceChannel d(a a2) {
        return a2.j;
    }

    static String[] f() {
        return e;
    }
}

