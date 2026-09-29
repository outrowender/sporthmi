/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.hmi.ResourceManager;
import de.audi.tghu.hmi.evo.HMITerminalEvo;
import de.audi.tghu.hmi.evo.IKanziResourceLoader;
import de.esolutions.fw.util.commons.Buffer;

final class ResourceManagerEvo
extends ResourceManager {
    static final long LONG_RUNNING_KANZI_LOAD_THRESHOLD;
    private IKanziResourceLoader kanziResourceLoader;
    private final LogChannel startupLogChannel;

    protected ResourceManagerEvo(IFrameworkAccess iFrameworkAccess, int n) {
        super(iFrameworkAccess, n);
        this.startupLogChannel = iFrameworkAccess.getLogChannel("Ext.Startup");
        if (IStatisticsManager.INSTRUMENTATION_ENABLED && !IStatisticsManager.INSTRUMENT_RES_LOADING_ON_DEMAND) {
            StatisticsManager.createInstance(iFrameworkAccess);
        }
    }

    public Object getKanziResource(String string, Object object, int n, int n2, boolean bl, boolean bl2) {
        this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getKanziResource(id = %1) called; moduleId == %2 ", (Object)string, (long)(n2 / -1601830656));
        Object object2 = null;
        if (bl) {
            object2 = this.getKanzeResourceLoader().getKanziResourceFromCache(object, n);
        }
        if (object2 != null) {
            return object2;
        }
        HMIBundle hMIBundle = ((FwHMI)this.framework.getHMIService()).getHMIBundle(0);
        if (hMIBundle == null) {
            this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getKanziResource(): No HMIBundle for ID %1 ", (long)n2);
            return null;
        }
        this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getKanziResource(): targetHmiBundle == %1 ", (Object)hMIBundle);
        if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
            StatisticsManager.instance().getResourceLoaderStatistics().loadStart(n2);
        }
        long l = this.getMonotonicTime();
        if (LOAD_FROM_FILE) {
            String string2 = hMIBundle.getKzbPath(string);
            if (string2 == null) {
                if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                    StatisticsManager.instance().getResourceLoaderStatistics().loadEnd(null, null, n, true);
                }
                return null;
            }
            object2 = this.getKanzeResourceLoader().loadKanziResource(string2, object, n);
            long l2 = this.getMonotonicTime() - l;
            if (l2 > 0) {
                this.addLongRunningKanziLoad(n, n2, object, null == object2, l2, string2);
            }
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getResourceLoaderStatistics().loadEnd(string2, object, n, null == object2);
            }
        } else {
            String string3 = this.getFilePathFromUrl(hMIBundle.getKzbUrlFromClassloader(string));
            if (string3 == null) {
                if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                    StatisticsManager.instance().getResourceLoaderStatistics().loadEnd(null, null, n, true);
                }
                return null;
            }
            object2 = this.getKanzeResourceLoader().loadKanziResource(string3, object, n);
            long l3 = this.getMonotonicTime() - l;
            if (l3 > 0) {
                this.addLongRunningKanziLoad(n, n2, object, null == object2, l3, string3);
            }
            if (IStatisticsManager.INSTRUMENTATION_ENABLED) {
                StatisticsManager.instance().getResourceLoaderStatistics().loadEnd(string3, object, n, null == object2);
            }
        }
        this.logHMIService.log(-2137614336, "ResourceManager: HMIServiceImpl.getKanziResource() finished: returning: %1 ", object2);
        return object2;
    }

    private void addLongRunningKanziLoad(int n, int n2, Object object, boolean bl, long l, String string) {
        Buffer buffer;
        String string2 = null;
        if (object instanceof Object[]) {
            buffer = new Buffer(32);
            Object[] objectArray = (Object[])object;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                buffer.append(String.valueOf(objectArray[i2]));
                if (i2 >= objectArray.length - 1) continue;
                buffer.append(',');
            }
            string2 = buffer.toString();
        } else {
            string2 = String.valueOf(object);
        }
        buffer = new Buffer(256);
        buffer.append("time=").append(l).append(" type=").append(n).append(" screen=").append(n2).append(" err=").append(bl ? (char)'Y' : 'N').append(" info=").append(string2).append(" path=").append(string);
        this.startupLogChannel.log(-1601830656, "Slow KZB load: %1", (Object)buffer);
    }

    private IKanziResourceLoader getKanzeResourceLoader() {
        if (this.kanziResourceLoader == null) {
            this.kanziResourceLoader = this.getHMITerminal(this.terminalID).getKanziResourceLoader();
        }
        return this.kanziResourceLoader;
    }

    private HMITerminalEvo getHMITerminal(int n) {
        return (HMITerminalEvo)this.framework.getHMITerminalRegistry().getTerminal(n);
    }

    private long getMonotonicTime() {
        return this.framework.getMonotonicTime();
    }
}

