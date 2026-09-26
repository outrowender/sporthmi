/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.testsupport;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TestSupportStartupSettingsReader {
    private static final String PROPERTY_VMOPTION_BEM_STARTUP;
    List startupList;

    public void init() {
        this.startupList = new ArrayList(20);
        String string = System.getProperty("SetBemActiveProviders");
        if (string != null) {
            this.startupList.addAll(this.parseArgs(string, ","));
        }
    }

    public void deinit() {
        this.startupList.clear();
    }

    public boolean isActive(String string) {
        if (this.startupList != null) {
            return this.startupList.contains(string);
        }
        return false;
    }

    private List parseArgs(String string, String string2) {
        if (string == null) {
            return new ArrayList();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList arrayList = new ArrayList(5);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }
}

