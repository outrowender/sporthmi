/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.intercommunication.OSDConstants;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tv.app.BCDTime;
import de.audi.tv.app.IOSDUpdateListener;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DefaultTVListener;
import java.util.GregorianCalendar;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class TVInfobar
implements OSDConstants {
    private static final int IS_NOT_HD = 0;
    private static final int IS_HD = 1;
    private final Object mutex = new Object();
    public final EventListener tvListener = new EventListener();
    public final IOSDUpdateListener osdUpdateListener = new OsdUpdateListener();
    private volatile ProgramInfo activeProgram = new ProgramInfo();
    private volatile int muteState = 0;
    private volatile boolean isInAVMode = false;
    private final TVEnv env;
    public final TVListener sourceListener = new TVListener();
    public final TVCallListener callListener = new TVCallListener();
    private final ModelGroup osdModelGroup = new ModelGroup();
    private final LogChannel log;
    private boolean isFullscreenActive = false;
    private boolean isTvOnMuActive = false;
    private boolean isEWSInfoVisible = false;
    private final Timer osdShowTimer;
    private final Timer osdHideTimer;

    public TVInfobar(TVEnv tVEnv) {
        this.env = tVEnv;
        this.log = tVEnv.lcMain;
        this.osdShowTimer = new Timer("Show OSD timer", 5, this.log, new DefaultTimerListener(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void fireTimer(Timer timer) {
                Object object = TVInfobar.this.mutex;
                synchronized (object) {
                    TVInfobar.this.showOSD();
                }
            }
        }, 400L, true);
        this.osdHideTimer = new Timer("Hide OSD timer", 5, this.log, new DefaultTimerListener(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void fireTimer(Timer timer) {
                Object object = TVInfobar.this.mutex;
                synchronized (object) {
                    TVInfobar.this.hideOSD();
                }
            }
        }, 4000L, true);
        this.osdModelGroup.add(tVEnv.getLabelModel(2600078));
        this.osdModelGroup.add(tVEnv.getLabelModel(2600073));
        this.osdModelGroup.add(tVEnv.getLabelModel(2600074));
        this.osdModelGroup.add(tVEnv.getLabelModel(2600112));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600102));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600190));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600104));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600103));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600076));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600071));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600077));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600113));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600118));
        this.osdModelGroup.add(tVEnv.getChoiceModel(2600120));
        this.osdModelGroup.add(tVEnv.getMetricsModel(2600109));
        this.osdModelGroup.add(tVEnv.getMetricsModel(2600108));
        this.osdModelGroup.add(tVEnv.getRangeModel(2600105));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void update(ProgramInfo programInfo, boolean bl) {
        boolean bl2 = this.osdShowTimer.cancel();
        String string = this.getStationName(programInfo.serviceInfo);
        String string2 = this.getEPGQuickInfo(programInfo);
        String string3 = programInfo.channelName == null ? "" : programInfo.channelName;
        int n = 1;
        int n2 = programInfo.videoFormat;
        int n3 = this.getIsHDService(programInfo.serviceInfo);
        this.setProgress(programInfo);
        int n4 = this.getAvailability(programInfo.getTeletextFlag());
        int n5 = this.getMultiChannelIcon(programInfo);
        int n6 = this.getAvailability(programInfo.subtitleFlag);
        int n7 = TVUtil.getChannelType(programInfo.serviceInfo.sType);
        int n8 = this.getStationStatus(programInfo);
        int n9 = -1;
        if (!bl) {
            n9 = this.getContentGroup(programInfo.serviceInfo);
        }
        Object object = this.mutex;
        synchronized (object) {
            this.env.getLabelModel(2600078).setText(string);
            this.env.getLabelModel(2600073).setText(string2);
            this.env.getLabelModel(2600112).setText(string3);
            this.env.getChoiceModel(2600102).setValue(n);
            this.env.getChoiceModel(2600104).setValue(n2);
            this.env.getChoiceModel(2600103).setValue(n3);
            this.env.getChoiceModel(2600190).setValue(n4);
            this.env.getChoiceModel(2600076).setValue(n5);
            this.env.getChoiceModel(2600071).setValue(n9);
            this.env.getChoiceModel(2600077).setValue(n7);
            this.env.getChoiceModel(2600118).setValue(n8);
            this.env.getChoiceModel(2600120).setValue(n6);
            this.setTime(programInfo);
            this.env.getChoiceModel(2600113).setValue(TVUtil.isVideoService(programInfo.serviceInfo) ? 0 : 1);
            this.osdModelGroup.flush();
            boolean bl3 = !TVUtil.equalsNamePID(this.activeProgram.serviceInfo, programInfo.serviceInfo);
            this.activeProgram = programInfo;
            if ((bl2 || bl3) && this.isFullscreenActive && !this.isInAVMode && this.isTvOnMuActive && !this.isEWSInfoVisible) {
                this.log.log(10000000, "[TVInfobar.update] new service recognized and fullscreen active -> show OSD");
                this.showOSD();
            }
        }
        this.log.log(10000000, "[TVInfobar.update] Content-Group:0x%1", (long)programInfo.serviceInfo.getContentGroup());
    }

    private void showOSD() {
        this.log.log(100000000, "[TVInfobar.showOSD]");
        if (this.env.getChoiceModel(2600107).getValue() == 1) {
            this.hideOSD();
        }
        if (TVUtil.isChannelTypeAlwaysShowOSD(this.activeProgram.serviceInfo.sType)) {
            this.env.getChoiceModel(2600107).setValue(2);
            this.log.log(100000000, "[TVInfobar.showOSD] - activate osdAlwaysOn for sType:  %2, name %1", (Object)this.activeProgram.serviceInfo.name, (long)this.activeProgram.serviceInfo.sType);
        } else {
            this.env.getChoiceModel(2600107).setValue(1);
            this.log.log(100000000, "[TVInfobar.showOSD] - activate osdHide for sType: %2, name %1", (Object)this.activeProgram.serviceInfo.name, (long)this.activeProgram.serviceInfo.sType);
            this.osdHideTimer.start();
        }
    }

    private void hideOSD() {
        this.log.log(100000000, "[TVInfobar.hideOSD]");
        this.osdHideTimer.cancel();
        this.env.getChoiceModel(2600107).setValue(0);
    }

    private int getContentGroup(ServiceInfo serviceInfo) {
        return serviceInfo.contentGroup == 0 ? -1 : serviceInfo.getContentGroup();
    }

    private String getStationName(ServiceInfo serviceInfo) {
        return serviceInfo != null && serviceInfo.name != null && !this.isInAVMode ? serviceInfo.name : "";
    }

    private String getEPGQuickInfo(ProgramInfo programInfo) {
        return programInfo.getNowProgramInfo() != null ? programInfo.getNowProgramInfo() : "";
    }

    private int getAvailability(int n) {
        return n == 2 ? 1 : 0;
    }

    private int getIsHDService(ServiceInfo serviceInfo) {
        return serviceInfo != null && serviceInfo.sType == 2 ? 1 : 0;
    }

    private void setTime(ProgramInfo programInfo) {
        MetricsModelApp metricsModelApp = this.env.getMetricsModel(2600109);
        MetricsModelApp metricsModelApp2 = this.env.getMetricsModel(2600108);
        DateMetric[] dateMetricArray = BCDTime.getDateMetrics(programInfo.nowStartTime, programInfo.nowEndTime);
        if (dateMetricArray.length == 2) {
            this.log.log(100000000, "[TVInfobar.setTime] START: 0x%1:0x%2", (long)programInfo.nowStartTime.hour, (long)programInfo.nowStartTime.minute);
            this.log.log(100000000, "[TVInfobar.setTime] END: 0x%1:0x%2", (long)programInfo.nowEndTime.hour, (long)programInfo.nowEndTime.minute);
            metricsModelApp.setMetric(dateMetricArray[0]);
            metricsModelApp2.setMetric(dateMetricArray[1]);
            metricsModelApp.setStatus(1);
            metricsModelApp2.setStatus(1);
        } else {
            this.log.log(100000000, "[TVInfobar.setTime] time unkown or uncorrect. Set models to waiting.");
            metricsModelApp.setMetric(null);
            metricsModelApp2.setMetric(null);
            metricsModelApp.setStatus(0);
            metricsModelApp2.setStatus(0);
        }
    }

    private void setProgress(ProgramInfo programInfo) {
        RangeModelApp rangeModelApp = this.env.getRangeModel(2600105);
        if (programInfo.nowStartTime == null || programInfo.nowEndTime == null) {
            rangeModelApp.setLimits(0, 100, 1);
            rangeModelApp.setValue(0);
            return;
        }
        int n = TVUtil.singleByteBCDToDual(programInfo.nowStartTime.hour) * 60 + TVUtil.singleByteBCDToDual(programInfo.nowStartTime.minute);
        int n2 = TVUtil.singleByteBCDToDual(programInfo.nowEndTime.hour) * 60 + TVUtil.singleByteBCDToDual(programInfo.nowEndTime.minute);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(this.env.framework.getKombiTime());
        int n3 = gregorianCalendar.get(11) * 60 + gregorianCalendar.get(12);
        if (n > n3) {
            n3 += 1440;
            n2 += 1440;
        }
        if (n2 < n3) {
            n2 += 1440;
        }
        rangeModelApp.setLimits(n, n2, 1);
        rangeModelApp.setValue(n3);
        this.log.log(100000000, "[TVInfobar.setProgress] Set progressbar values -> start: %1, current: %2, end: %3", (long)n, (long)n3, (long)n2);
    }

    private int getMultiChannelIcon(ProgramInfo programInfo) {
        return programInfo.availableAudioChannels.length > 1 ? 1 : 0;
    }

    private int getStationStatus(ProgramInfo programInfo) {
        int n = TVUtil.getCasStatus(programInfo.casStatus);
        if (n == 0) {
            n = TVUtil.getMuteStatus(this.muteState);
        }
        return n;
    }

    public void deinit() {
        this.osdShowTimer.cancel();
        this.isFullscreenActive = false;
        this.isTvOnMuActive = false;
        this.hideOSD();
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateMuteState(int n) {
            TVInfobar.this.muteState = n;
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                int n2 = TVInfobar.this.getStationStatus(TVInfobar.this.activeProgram);
                TVInfobar.this.env.getChoiceModel(2600118).setValue(n2);
                TVInfobar.this.osdModelGroup.flush();
            }
        }
    }

    private class EventListener
    extends TVEventDefaultListener {
        private EventListener() {
        }

        public void onSelectedServiceDebounced(ProgramInfo programInfo) {
            TVInfobar.this.update(programInfo, false);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onMuGotTvAudioFocus() {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.isTvOnMuActive = true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onMuLostTvAudioFocus() {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.osdShowTimer.cancel();
                TVInfobar.this.isTvOnMuActive = false;
                TVInfobar.this.hideOSD();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onEWSInfoVisibilityChange(boolean bl) {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.isEWSInfoVisible = bl;
                if (bl) {
                    TVInfobar.this.osdShowTimer.cancel();
                    TVInfobar.this.hideOSD();
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onFullscreenEntered(int n) {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.isFullscreenActive = true;
                if (!TVInfobar.this.isInAVMode && !TVInfobar.this.isEWSInfoVisible) {
                    TVInfobar.this.osdShowTimer.cancel();
                    TVInfobar.this.setProgress(TVInfobar.this.activeProgram);
                    TVInfobar.this.osdModelGroup.flush();
                    TVInfobar.this.osdShowTimer.start();
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onFullscreenLeft(int n) {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.osdShowTimer.cancel();
                TVInfobar.this.isFullscreenActive = false;
                TVInfobar.this.hideOSD();
            }
        }
    }

    private class TVCallListener
    extends DSICallListener {
        private TVCallListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.muteState = 0;
                ProgramInfo programInfo = new ProgramInfo();
                programInfo.serviceInfo = serviceInfo;
                programInfo.availableAudioChannels = new AudioChannel[0];
                TVInfobar.this.update(programInfo, true);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void switchSource(int n, boolean bl) {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                if (n == 1 && !TVInfobar.this.isInAVMode) {
                    TVInfobar.this.osdShowTimer.cancel();
                    TVInfobar.this.isInAVMode = true;
                    TVInfobar.this.hideOSD();
                    TVInfobar.this.env.getLabelModel(2600078).setText("");
                } else if (n == 0 && TVInfobar.this.isInAVMode) {
                    TVInfobar.this.isInAVMode = false;
                    TVInfobar.this.env.getLabelModel(2600078).setText(TVInfobar.this.getStationName(((TVInfobar)TVInfobar.this).activeProgram.serviceInfo));
                }
                TVInfobar.this.osdModelGroup.flush();
            }
        }
    }

    private class OsdUpdateListener
    implements IOSDUpdateListener {
        private OsdUpdateListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateProgress() {
            Object object = TVInfobar.this.mutex;
            synchronized (object) {
                TVInfobar.this.setProgress(TVInfobar.this.activeProgram);
                TVInfobar.this.osdModelGroup.flush();
            }
        }
    }
}

