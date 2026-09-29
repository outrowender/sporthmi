/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ITelComponent;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.OptionModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import java.util.ArrayList;

public abstract class AbstractPhoneComponent
implements ITelComponent,
IGlobalTelephoneStateListener {
    public static final int STATUS_WAITING;
    public static final int STATUS_VALID;
    public static final int STATUS_ERROR;
    public static final int VALUE_AVAILABLE;
    public static final int VALUE_UNAVAILABLE;
    public static final int VALUE_UNKNOWN;
    private final ITelApplication phoneApplication;
    protected final LogChannel log;
    private ArrayList subComponents;
    private final Object subComponentLock = new Object();

    public AbstractPhoneComponent(ITelApplication iTelApplication, String string) {
        this.phoneApplication = iTelApplication;
        this.log = iTelApplication.getFrameworkAccess().getLogChannel(string);
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
    }

    protected ITelApplication getApplication() {
        return this.phoneApplication;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void addSubPhoneComponent(ITelComponent iTelComponent) {
        Object object = this.subComponentLock;
        synchronized (object) {
            if (this.subComponents == null) {
                this.subComponents = new ArrayList();
            }
            this.subComponents.add(iTelComponent);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initSubComponents() {
        Object object = this.subComponentLock;
        synchronized (object) {
            if (this.subComponents != null) {
                for (int i2 = 0; i2 < this.subComponents.size(); ++i2) {
                    ((ITelComponent)this.subComponents.get(i2)).init();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void deinitSubComponents() {
        Object object = this.subComponentLock;
        synchronized (object) {
            if (this.subComponents != null) {
                for (int i2 = 0; i2 < this.subComponents.size(); ++i2) {
                    ((ITelComponent)this.subComponents.get(i2)).deinit();
                }
                this.subComponents.clear();
            }
        }
    }

    protected MenuModelApp getMenuModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getMenuModel(n);
    }

    protected ChoiceModelApp getChoiceModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getChoiceModel(n);
    }

    protected LabelModelApp getLabelModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getLabelModel(n);
    }

    protected RangeModelApp getRangeModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getRangeModel(n);
    }

    protected ListModelApp getListModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getListModel(n);
    }

    protected BaseListModelApp getBaseListModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getBaseListModel(n);
    }

    protected ButtonModelApp getButtonModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getButtonModel(n);
    }

    protected OptionModelApp getOptionModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getOptionModel(n);
    }

    protected MetricsModelApp getMetricsModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getMetricsModel(n);
    }

    protected SpellerModelApp getSpellerModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getSpellerModel(n);
    }

    protected MatchspellerModelApp getMatchSpellerModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getMatchSpellerModel(n);
    }

    protected ResourceLocatorModelApp getResourceLocatorModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getResourceLocatorModel(n);
    }

    protected TiledListModelApp getTiledListModel(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getTiledListModel(n);
    }

    protected AbstractMetrics getMetric(int n) {
        return this.getMetricsModel(n).getMetric();
    }

    protected DateMetric getDateMetric(int n) {
        return (DateMetric)this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getMetricsModel(n).getMetric();
    }

    protected void logStartupEvent(String string) {
        this.phoneApplication.getFrameworkAccess().getStartupMgr().logStartupEvent(string);
    }

    public SpellerModelApp getSpellerModelApp(int n) {
        return this.phoneApplication.getFrameworkAccess().getHmiServiceApp().getSpellerModel(n);
    }

    @Override
    public void init() {
        this.initSubComponents();
    }

    @Override
    public void deinit() {
        this.deinitSubComponents();
    }
}

