/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class SMMInfoProvider
implements DumpInfoProvider {
    private final IFrameworkAccess framework;
    private final Map smmInfo;

    public SMMInfoProvider(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.smmInfo = new HashMap(20);
    }

    public String getName() {
        return "SMMInfo";
    }

    public void dump(PrintStream printStream, String string) {
        Iterator iterator = this.smmInfo.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            printStream.print("SMModule: ");
            printStream.println(string2);
            ArrayList arrayList = (ArrayList)this.smmInfo.get(string2);
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                printStream.print("    ");
                printStream.println(arrayList.get(i2));
            }
        }
    }

    public synchronized void addSMM(String string) {
        this.smmInfo.put(string, new ArrayList());
    }

    public synchronized void addSMMInfo(String string, String string2) {
        ArrayList arrayList = (ArrayList)this.smmInfo.get(string);
        if (arrayList == null) {
            this.addSMM(string);
            arrayList = (ArrayList)this.smmInfo.get(string);
        }
        if (arrayList != null) {
            arrayList.add(Long.toString(this.framework.getMonotonicTime()) + " " + string2);
        }
    }
}

