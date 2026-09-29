/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.interapp.NaviCruiseModeServiceListener;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.CruiseModeHandler$1;
import de.audi.tghu.navi.app.map.handler.CruiseModeHandler$2;
import de.audi.tghu.navi.app.map.handler.ICruiseModeHandler;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class CruiseModeHandler
implements ICruiseModeHandler {
    private LogChannel logger;
    private boolean isInCruiseMode = false;
    private boolean isCenterToCar = true;
    private boolean isInManoeverzoom = false;
    private int currentContext = 0;
    private final DispatcherBase cruiseModeNotificationDispatcher;
    private static final int NAVI_CONTEXT;
    private static final int MAP_CONTEXT;
    private NaviCruiseModeServiceListener NULL_NOTIFICATIONSERVICE;
    private NaviCruiseModeServiceListener notificationService = this.NULL_NOTIFICATIONSERVICE = new CruiseModeHandler$1(this);
    private final NavigationEnv env;
    private final AbstractMap map;

    public CruiseModeHandler(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.logger = navigationEnv.getLogChannel("App.Map.Main");
        this.cruiseModeNotificationDispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher("CruiseModeNotficationDispatcher", new JobLogger(this.logger));
        this.cruiseModeNotificationDispatcher.start();
        this.env = navigationEnv;
        this.map = abstractMap;
    }

    @Override
    public void onEvent(int n, int n2) {
        this.logger.log(-2137614336, "CruiseModeHandler#onEvent( %1, %2 )", (long)n, (long)n2);
        switch (n) {
            case 102: {
                this.currentContext = n2;
                break;
            }
            case 104: {
                this.setManoeverzoomState(n2);
                break;
            }
        }
        this.determineCruiseMode();
        this.logger.log(-2137614336, "CruiseModeHandler#onEvent(currentContext %1 )", (long)this.currentContext);
        this.logger.log(-2137614336, "CruiseModeHandler#onEvent(isInCruiseMode %1, isInManoeverzoom %2)", this.isInCruiseMode, this.isInManoeverzoom);
    }

    private boolean isValidApplicationContext(int n) {
        if (Util.isPorsche(this.env.getFramework())) {
            return 39 == n;
        }
        return 5 == n;
    }

    private void determineCruiseMode() {
        int n = this.env.getChoiceModel(8).getValue();
        this.logger.log(-2137614336, "CruiseModeHandler#determineCruiseMode activeApplication = %1", (long)n);
        if (this.isValidApplicationContext(n)) {
            switch (this.currentContext) {
                case 6: 
                case 7: 
                case 8: 
                case 10: 
                case 11: {
                    this.setCenterToCar(true);
                    this.setCruiseMode(this.isMZInactive());
                    break;
                }
                default: {
                    this.setCenterToCar(false);
                    this.setCruiseMode(false);
                    break;
                }
            }
        } else {
            this.setCenterToCar(false);
            this.setCruiseMode(false);
        }
    }

    private void setCenterToCar(boolean bl) {
        this.isCenterToCar = bl;
    }

    private void setManoeverzoomState(int n) {
        switch (n) {
            case 3: {
                this.isInManoeverzoom = true;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 255: {
                this.isInManoeverzoom = false;
                break;
            }
            default: {
                this.isInManoeverzoom = false;
            }
        }
    }

    private boolean isMZInactive() {
        if (Util.isPorsche(this.env.getFramework())) {
            boolean bl = this.map.getSetup().getIntersectionZoom() == 0;
            return !this.isInManoeverzoom || !bl;
        }
        return !this.isInManoeverzoom;
    }

    private void setCruiseMode(boolean bl) {
        this.logger.log(-2137614336, "CruiseModeHandler#setCruiseMode( %1 )", bl);
        if (bl == this.isInCruiseMode) {
            return;
        }
        this.isInCruiseMode = bl;
        this.dispatchCruiseModeUpdate(bl);
    }

    private void dispatchCruiseModeUpdate(boolean bl) {
        this.cruiseModeNotificationDispatcher.execute(new CruiseModeHandler$2(this, bl));
    }

    @Override
    public boolean isInCruiseMode() {
        return this.isInCruiseMode;
    }

    @Override
    public void setNaviCruiseModeNotificationService(NaviCruiseModeServiceListener naviCruiseModeServiceListener) {
        this.logger.log(-2137614336, "CruiseModeHandler#setNaviCruiseModeNotificationService(Service %1 )", (Object)naviCruiseModeServiceListener);
        this.notificationService = naviCruiseModeServiceListener != null ? naviCruiseModeServiceListener : this.NULL_NOTIFICATIONSERVICE;
    }

    @Override
    public void cleanup() {
        this.cruiseModeNotificationDispatcher.stop();
        this.notificationService = this.NULL_NOTIFICATIONSERVICE;
    }

    @Override
    public boolean isCenterToCar() {
        return this.isCenterToCar;
    }

    static /* synthetic */ LogChannel access$000(CruiseModeHandler cruiseModeHandler) {
        return cruiseModeHandler.logger;
    }

    static /* synthetic */ NaviCruiseModeServiceListener access$100(CruiseModeHandler cruiseModeHandler) {
        return cruiseModeHandler.notificationService;
    }
}

