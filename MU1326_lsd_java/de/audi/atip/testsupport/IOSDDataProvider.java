/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.ITestSupportSession;

public interface IOSDDataProvider {
    public String getName();

    public String[] getData();

    public void setTestSupport(ITestSupportSession var1);
}

