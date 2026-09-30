/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.test;

import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.LoggingUtils;
import de.audi.atip.testsupport.IOSDDataProvider;
import de.audi.atip.testsupport.ITestSupportSession;
import de.esolutions.fw.util.commons.Buffer;
import de.vw.mib.bap.requests.StatusProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAPOSDDataProvider
implements IOSDDataProvider {
    private final AbstractBAPModule module;

    public BAPOSDDataProvider(AbstractBAPModule abstractBAPModule) {
        this.module = abstractBAPModule;
    }

    public String getName() {
        Buffer buffer = new Buffer();
        buffer.append("AppBAP - ");
        buffer.append(LSGIDs.getDescription(this.module.getLSGID()));
        buffer.append(" module");
        return buffer.toString();
    }

    public String[] getData() {
        ArrayList arrayList = new ArrayList(200);
        Buffer buffer = new Buffer();
        buffer.clear();
        buffer.append("-> BAPStack state: ");
        buffer.append(this.module.getInitializationManager().getBapStackState() == 1);
        arrayList.add(buffer.toString());
        buffer.clear();
        buffer.append("-> HMI state: ");
        buffer.append(LoggingUtils.getHMIStateDescription(this.module.getInitializationManager().getHMIState()));
        arrayList.add(buffer.toString());
        buffer.clear();
        buffer.append("-> module initialization state: ");
        buffer.append(LoggingUtils.getInitStateDescription(this.module.getInitializationManager().getInitState()));
        arrayList.add("-> module operation state:");
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = (BAPFunctionPropertyFSG)this.module.getBAPFunction(this.module.getFunctionList().getOperationStateBAPFctID());
        StatusProperty statusProperty = bAPFunctionPropertyFSG.getLastStatus();
        arrayList.addAll(BAPOSDDataProvider.splitString(bAPFunctionPropertyFSG.isDataValid() ? statusProperty.toString() : "value not set"));
        arrayList.add("-> application states:");
        arrayList.addAll(BAPOSDDataProvider.splitString(this.module.getInitializationManager().appStatesToString()));
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    private static List splitString(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, "\n");
        int n = stringTokenizer.countTokens();
        ArrayList arrayList = new ArrayList(n);
        for (int i2 = 0; i2 < n; ++i2) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    public void setTestSupport(ITestSupportSession iTestSupportSession) {
    }
}

