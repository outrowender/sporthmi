/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.testsupport;

import de.audi.atip.testsupport.ITestSupportSession;

public interface IOSDDataProvider {
    default public String getName() {
    }

    default public String[] getData() {
    }

    default public void setTestSupport(ITestSupportSession iTestSupportSession) {
    }
}

