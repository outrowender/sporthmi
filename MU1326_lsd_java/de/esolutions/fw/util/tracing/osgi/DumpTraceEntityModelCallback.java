/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.osgi;

import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.TraceClient;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import java.io.File;
import java.io.IOException;

public class DumpTraceEntityModelCallback
implements ITraceCallback {
    private final String basePath;

    public DumpTraceEntityModelCallback(String string) {
        this.basePath = string;
    }

    public void executeTraceCallback(int n, byte[] byArray) {
        TraceFrontend traceFrontend;
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null && (traceFrontend = traceClient.getFrontend()) != null) {
            String string = SystemConfig.getInstance().getMyProcName();
            String string2 = this.basePath + File.separator + string + ".sem";
            try {
                traceFrontend.writeSemFile(string2, string);
                System.out.println("--> Wrote sem file " + string2);
            }
            catch (IOException iOException) {
                System.out.println("--> Error writing sem file " + string2 + ": " + iOException.getMessage());
            }
        }
    }
}

