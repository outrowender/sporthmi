/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.diagnosis;

import de.audi.app.media.content.media.utils.MediaUtils;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagnosisManagerImpl
implements IDiagnosisManager {
    public static final String LOGCLASS = "DiagnosisManagerImpl";
    private final Map[] dataProvider = new HashMap[8];
    private final Map dataProviderAll = new HashMap();
    private final Map[] commandProvider = new HashMap[8];
    private final Map commandProviderAll = new HashMap();
    private final LogChannel logger;

    public DiagnosisManagerImpl(LogChannel logChannel) {
        this.logger = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addDataProvider(int n, IDiagnosisDataProvider iDiagnosisDataProvider) {
        if (iDiagnosisDataProvider == null) {
            throw new IllegalArgumentException();
        }
        this.logger.log(1000000, "[%1.addDataProvider] '%2','%3'", (Object)LOGCLASS, (Object)MediaUtils.getTerminalIDToStr(n), (Object)iDiagnosisDataProvider.getDiagKey());
        Map[] mapArray = this.dataProvider;
        synchronized (this.dataProvider) {
            Map map = this.getDataProviderMap(n);
            if (map.containsKey(iDiagnosisDataProvider.getDiagKey())) {
                this.logger.log(1000000, "[%1.addDataProvider] Already registered.", (Object)LOGCLASS, (Object)iDiagnosisDataProvider);
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return;
            }
            map.put(iDiagnosisDataProvider.getDiagKey(), iDiagnosisDataProvider);
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return;
        }
    }

    private Map getDataProviderMap(int n) {
        if (n == -1) {
            return this.dataProviderAll;
        }
        if (this.dataProvider[n] == null) {
            this.dataProvider[n] = new HashMap();
        }
        return this.dataProvider[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IDiagnosisDataProvider getDataProvider(int n, String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.logger.log(1000000, "[%1.getDataProvider] '%2','%3'", (Object)LOGCLASS, (Object)MediaUtils.getTerminalIDToStr(n), (Object)string);
        Map[] mapArray = this.dataProvider;
        synchronized (this.dataProvider) {
            IDiagnosisDataProvider iDiagnosisDataProvider = (IDiagnosisDataProvider)this.getDataProviderMap(n).get(string);
            IDiagnosisDataProvider iDiagnosisDataProvider2 = (IDiagnosisDataProvider)this.getDataProviderMap(-1).get(string);
            if (iDiagnosisDataProvider == null && iDiagnosisDataProvider2 == null) {
                this.logger.log(1000000, "[%1.getData] No provider '%2' found", (Object)LOGCLASS, (Object)string);
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return null;
            }
            if (iDiagnosisDataProvider != null && iDiagnosisDataProvider2 != null) {
                this.logger.log(1000000, "[%1.getData] '%2' shared key. Return terminal specific.", (Object)LOGCLASS, (Object)string);
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return iDiagnosisDataProvider;
            }
            if (iDiagnosisDataProvider != null) {
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return iDiagnosisDataProvider;
            }
            this.logger.log(1000000, "[%1.getData] Shared key", (Object)LOGCLASS, (Object)string);
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return iDiagnosisDataProvider2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getDataProviderKeys(int n) {
        Map[] mapArray = this.dataProvider;
        synchronized (this.dataProvider) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.getDataProviderMap(-1).keySet());
            arrayList.addAll(this.getDataProviderMap(n).keySet());
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return arrayList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addCommandProvider(int n, IDiagnosisCommandProvider iDiagnosisCommandProvider) {
        if (iDiagnosisCommandProvider == null) {
            throw new IllegalArgumentException();
        }
        this.logger.log(1000000, "[%1.addCommandProvider] '%2','%3'", (Object)LOGCLASS, (Object)MediaUtils.getTerminalIDToStr(n), (Object)iDiagnosisCommandProvider.getDiagKeys());
        Map[] mapArray = this.commandProvider;
        synchronized (this.commandProvider) {
            Map map = this.getCommandProviderMap(n);
            for (int i2 = 0; i2 < iDiagnosisCommandProvider.getDiagKeys().length; ++i2) {
                if (map.containsKey(iDiagnosisCommandProvider.getDiagKeys()[i2])) {
                    this.logger.log(1000000, "[%1.addCommand] Already registered.", (Object)LOGCLASS);
                    // ** MonitorExit[var3_3] (shouldn't be in output)
                    return;
                }
                map.put(iDiagnosisCommandProvider.getDiagKeys()[i2], iDiagnosisCommandProvider);
            }
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return;
        }
    }

    private Map getCommandProviderMap(int n) {
        if (n == -1) {
            return this.commandProviderAll;
        }
        if (this.commandProvider[n] == null) {
            this.commandProvider[n] = new HashMap();
        }
        return this.commandProvider[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getCommandProviderKeys(int n) {
        Map[] mapArray = this.commandProvider;
        synchronized (this.commandProvider) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.getCommandProviderMap(n).keySet());
            arrayList.addAll(this.getCommandProviderMap(-1).keySet());
            // ** MonitorExit[var2_2] (shouldn't be in output)
            return arrayList;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IDiagnosisCommandProvider getCommandProvider(int n, String string) {
        Map[] mapArray = this.commandProvider;
        synchronized (this.commandProvider) {
            IDiagnosisCommandProvider iDiagnosisCommandProvider = (IDiagnosisCommandProvider)this.getCommandProviderMap(n).get(string);
            IDiagnosisCommandProvider iDiagnosisCommandProvider2 = (IDiagnosisCommandProvider)this.getCommandProviderMap(-1).get(string);
            if (iDiagnosisCommandProvider == null && iDiagnosisCommandProvider2 == null) {
                this.logger.log(1000000, "[%1.getCommandProvider] No provider for '%2' found", (Object)LOGCLASS, (Object)string);
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return null;
            }
            if (iDiagnosisCommandProvider != null && iDiagnosisCommandProvider2 != null) {
                this.logger.log(1000000, "[%1.getCommandProvider] '%2' shared key. Return terminal specific.", (Object)LOGCLASS, (Object)string);
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return iDiagnosisCommandProvider;
            }
            if (iDiagnosisCommandProvider != null) {
                // ** MonitorExit[var3_3] (shouldn't be in output)
                return iDiagnosisCommandProvider;
            }
            this.logger.log(1000000, "[%1.getCommandProvider] '%2' shared key", (Object)LOGCLASS, (Object)string);
            // ** MonitorExit[var3_3] (shouldn't be in output)
            return iDiagnosisCommandProvider2;
        }
    }
}

