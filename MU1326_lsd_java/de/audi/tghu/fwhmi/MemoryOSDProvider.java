/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.testsupport.IOSDDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;

public class MemoryOSDProvider
implements IOSDDataProvider {
    @Override
    public String getName() {
        return "available Java Heap";
    }

    @Override
    public String[] getData() {
        return new String[]{new StringBuffer().append("TotalMemory: ").append(Runtime.getRuntime().totalMemory() / 0).append(" kiB").toString(), new StringBuffer().append("FreeMemory: ").append(Runtime.getRuntime().freeMemory() / 0).append(" kiB").toString()};
    }

    @Override
    public void setTestSupport(ITestSupportSession iTestSupportSession) {
    }
}

