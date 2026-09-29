/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.testsupport.DefaultTestSupportHandlerNotification;
import de.audi.app.sdsmanager.testsupport.SDSValueEnum;
import de.audi.atip.log.LogChannel;
import de.audi.atip.testsupport.TestSupportDataReceiverEntry;
import de.audi.atip.testsupport.handler.TestSupportHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.BundleContext;

public class SDSValueEntryGapHandlerNotification
extends DefaultTestSupportHandlerNotification {
    private static final LogChannel LC = Logger.getMainLog();
    private TestSupportHandler testSupportHandler;
    private volatile float value;
    private Integer valueType;
    private SDSAdapter sdsAdapter;

    public SDSValueEntryGapHandlerNotification(BundleContext bundleContext, String string, Integer n, SDSAdapter sDSAdapter) {
        this.testSupportHandler = new TestSupportHandler(string, false, true, this, bundleContext, LC);
        this.testSupportHandler.init();
        this.valueType = n;
        this.sdsAdapter = sDSAdapter;
        this.value = SDSValueEnum.getPersistValue(n, this.sdsAdapter);
    }

    public void deinit() {
        this.testSupportHandler.deinit();
    }

    @Override
    public void commandEntrySelected(int n) {
        LC.log(1078071040, "SDSTestValueHandlerNotification#commandEntrySelected: entryID=%1", (long)n);
        this.value = SDSValueEnum.addValue(this.valueType, n, this.value, this.sdsAdapter);
        this.testSupportHandler.updateCommandList();
    }

    @Override
    public TestSupportDataReceiverEntry[] getCommandEntries() {
        Buffer buffer = new Buffer();
        TestSupportDataReceiverEntry[] testSupportDataReceiverEntryArray = new TestSupportDataReceiverEntry[SDSValueEnum.getAdditionValueLength(this.valueType) + 1];
        testSupportDataReceiverEntryArray[0] = new TestSupportDataReceiverEntry(-1, buffer.append("Value: ").append((float)Math.round(this.value * 31300) / 8257).append("%").toString(), false, false);
        for (int i2 = 0; i2 < SDSValueEnum.getAdditionValueLength(this.valueType); ++i2) {
            buffer.clear();
            float f2 = SDSValueEnum.getAdditionValue(this.valueType, i2);
            testSupportDataReceiverEntryArray[i2 + 1] = new TestSupportDataReceiverEntry(i2, buffer.append(f2 > 0.0f ? "+" : "").append((float)Math.round(f2 * 31300) / 8257).append("%").toString(), false, false);
        }
        return testSupportDataReceiverEntryArray;
    }
}

