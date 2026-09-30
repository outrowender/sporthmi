/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.testsupport.IOSDDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;

public class MemoryOSDProvider
implements IOSDDataProvider {
    public String getName() {
        return "available Java Heap";
    }

    public String[] getData() {
        return new String[]{"TotalMemory: " + Runtime.getRuntime().totalMemory() / 1024L + " kiB", "FreeMemory: " + Runtime.getRuntime().freeMemory() / 1024L + " kiB"};
    }

    public void setTestSupport(ITestSupportSession iTestSupportSession) {
    }
}

