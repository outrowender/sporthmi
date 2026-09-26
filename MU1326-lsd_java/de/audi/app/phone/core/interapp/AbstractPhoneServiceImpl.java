/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$1;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$2;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$3;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$4;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$5;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$6;
import de.audi.app.phone.core.interapp.AbstractPhoneServiceImpl$PhoneServiceDiag;
import de.audi.app.phone.core.interapp.TelDialNumberSessionHandler;
import de.audi.app.phone.core.interapp.TelServiceSDSListenerWrapper;
import de.audi.app.phone.core.sim.ITelLockStateHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.PhoneUtils;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.phone.ITelCallSession;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.atip.phone.ITelServiceSDS;
import de.audi.atip.phone.ITelServiceSDSListener;
import de.audi.atip.phone.TelServiceCallStackEntry;
import java.util.Calendar;
import java.util.Hashtable;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractPhoneServiceImpl
extends AbstractPhoneComponent
implements ITelServiceSDS,
ServiceTrackerCustomizer {
    private volatile PhoneServiceProvider sdsPhoneService;
    private volatile PhoneServiceProvider phoneService;
    protected volatile IGlobalTelephoneStateStruct globalState;
    private volatile PhoneServiceTracker lockStateHandlerServiceTracker;
    private volatile ITelLockStateHandler lockStateHandlerService;
    private final TelDialNumberSessionHandler dialNumberSessionHandler;
    static /* synthetic */ Class class$de$audi$app$phone$core$sim$ITelLockStateHandler;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelServiceSDS;
    static /* synthetic */ Class class$de$audi$atip$phone$ITelService;

    public AbstractPhoneServiceImpl(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.dialNumberSessionHandler = new TelDialNumberSessionHandler(iTelApplication);
        this.addSubPhoneComponent(this.dialNumberSessionHandler);
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().addDiagnosisComponent(new AbstractPhoneServiceImpl$PhoneServiceDiag(this, null));
        this.registerPhoneService();
        this.registerPhoneServiceSDS();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.lockStateHandlerServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$app$phone$core$sim$ITelLockStateHandler == null ? (class$de$audi$app$phone$core$sim$ITelLockStateHandler = AbstractPhoneServiceImpl.class$("de.audi.app.phone.core.sim.ITelLockStateHandler")) : class$de$audi$app$phone$core$sim$ITelLockStateHandler).getName(), (ServiceTrackerCustomizer)this, this.log);
        this.lockStateHandlerServiceTracker.openTracker();
    }

    @Override
    public void deinit() {
        super.deinit();
        if (this.sdsPhoneService != null) {
            this.sdsPhoneService.stopService();
        }
        if (this.phoneService != null) {
            this.phoneService.stopService();
        }
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        if (this.lockStateHandlerServiceTracker != null) {
            this.lockStateHandlerServiceTracker.closeTracker();
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof ITelLockStateHandler) {
            this.lockStateHandlerService = (ITelLockStateHandler)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof ITelLockStateHandler) {
            this.getApplication().getBundleContext().ungetService(serviceReference);
            this.lockStateHandlerService = null;
        }
    }

    private void registerPhoneServiceSDS() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.sdsPhoneService = new PhoneServiceProvider((class$de$audi$atip$phone$ITelServiceSDS == null ? (class$de$audi$atip$phone$ITelServiceSDS = AbstractPhoneServiceImpl.class$("de.audi.atip.phone.ITelServiceSDS")) : class$de$audi$atip$phone$ITelServiceSDS).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.sdsPhoneService.startService();
    }

    private void registerPhoneService() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.phoneService = new PhoneServiceProvider((class$de$audi$atip$phone$ITelService == null ? (class$de$audi$atip$phone$ITelService = AbstractPhoneServiceImpl.class$("de.audi.atip.phone.ITelService")) : class$de$audi$atip$phone$ITelService).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.phoneService.startService();
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.globalState = iGlobalTelephoneStateStruct;
    }

    @Override
    public void dialNumber(String string, ITelServiceListener iTelServiceListener, boolean bl) {
        this.getApplication().enqueueEvent(new AbstractPhoneServiceImpl$1(this, "AbstractPhoneServiceImpl#dialNumber", string, bl, iTelServiceListener));
    }

    @Override
    public void dialNumberFromADBEntry(String string, String string2, short s, short s2, long l, ResourceLocator resourceLocator, int n, int n2, ITelServiceListener iTelServiceListener, boolean bl) {
        this.getApplication().enqueueEvent(new AbstractPhoneServiceImpl$2(this, "AbstractPhoneServiceImpl#dialNumberFromADBEntry", string, string2, s, s2, l, resourceLocator, n, n2, bl, iTelServiceListener));
    }

    private void triggerJumpToPhone() {
        PhoneUtils.triggerJumpToPhone(this.getApplication().getFrameworkAccess().getHmiServiceApp());
    }

    @Override
    public void dialNumber(ITelCallSession iTelCallSession, boolean bl) {
        this.getApplication().enqueueEvent(new AbstractPhoneServiceImpl$3(this, "AbstractPhoneServiceImpl#dialNumber call session", iTelCallSession, bl));
    }

    @Override
    public boolean checkForSuppService(String string) {
        boolean bl = string != null && ('*' == string.charAt(0) || '#' == string.charAt(0));
        this.log.log(1078071040, "[AbstractPhoneServiceImpl#checkForSuppService] number=%1, suppService=%2", (Object)string, (Object)String.valueOf(bl));
        return bl;
    }

    @Override
    public String getPINSpellerContent() {
        String string = this.getSpellerModel(848692224).getText();
        this.log.log(1078071040, "[AbstractPhoneServiceImpl#getPINSpellerContent] pinText=%1", (Object)string);
        return string;
    }

    @Override
    public void setPINSpeller(String string) {
        this.getApplication().enqueueEvent(new AbstractPhoneServiceImpl$4(this, "AbstractPhoneServiceImpl#setPINSpeller", string));
    }

    @Override
    public String getMailboxSpellerContent() {
        String string = this.getSpellerModel(1687684096).getText();
        this.log.log(1078071040, "[AbstractPhoneServiceImpl#getMailboxSpellerContent] mailboxSpellerText=%1", (Object)string);
        return string;
    }

    @Override
    public void setMailboxSpeller(String string) {
        this.getApplication().enqueueEvent(new AbstractPhoneServiceImpl$5(this, "AbstractPhoneServiceImpl#setMailboxSpeller", string));
    }

    @Override
    public void setMailboxNumber(String string, ITelServiceSDSListener iTelServiceSDSListener) {
        this.log.log(1078071040, "[AbstractPhoneServiceImpl#setMailboxNumber] setting mailbox number to %1", (Object)string);
        this.getApplication().getTelephoneDSIAccess().requestSetMailboxNumber(string, 0, true, iTelServiceSDSListener != null ? new TelServiceSDSListenerWrapper(iTelServiceSDSListener) : this.getApplication().getDefaultListener());
    }

    @Override
    public void unlockSIMWithPIN(String string, ITelServiceSDSListener iTelServiceSDSListener) {
        this.getApplication().enqueueEvent(new AbstractPhoneServiceImpl$6(this, "AbstractPhoneServiceImpl#unlockSIMWithPIN", string, iTelServiceSDSListener));
    }

    @Override
    public String getMailboxNumber() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.globalState;
        if (iGlobalTelephoneStateStruct != null) {
            String string = iGlobalTelephoneStateStruct.getMailboxNumber();
            this.log.log(1078071040, "[AbstractPhoneServiceImpl#getMailboxNumber] mailboxNumber=%1", (Object)string);
            return string;
        }
        return null;
    }

    @Override
    public TelServiceCallStackEntry getLastDialedNumber() {
        CallStackEntry callStackEntry;
        TelServiceCallStackEntry telServiceCallStackEntry = null;
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.globalState;
        if (iGlobalTelephoneStateStruct != null && (callStackEntry = iGlobalTelephoneStateStruct.getLastDialedNumber()) != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(callStackEntry.getClYear(), callStackEntry.getClMonth() - 1, callStackEntry.getClDay(), callStackEntry.getClHour(), callStackEntry.getClMinute(), callStackEntry.getClSecond());
            telServiceCallStackEntry = new TelServiceCallStackEntry(callStackEntry.getClEntryID(), callStackEntry.getClName(), callStackEntry.getClNumber(), callStackEntry.getAdbEntryID(), (short)callStackEntry.getAdbNumberType(), 0, callStackEntry.getAdbPictureID(), callStackEntry.getAdbPhoneDataIndex(), callStackEntry.getAdbPhoneDataCount(), calendar.getTime());
        }
        this.log.log(1078071040, "[AbstractPhoneServiceImpl#getLastDialedNumber] lastDialedNumber=%1", telServiceCallStackEntry);
        return telServiceCallStackEntry;
    }

    protected BaseListModelApp getSDSPickListModel() {
        return this.getBaseListModel(3938);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$100(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ ITelApplication access$400(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$600(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ void access$700(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        abstractPhoneServiceImpl.triggerJumpToPhone();
    }

    static /* synthetic */ LogChannel access$800(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$900(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ ITelApplication access$1000(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$1100(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$1200(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ ITelApplication access$1500(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$1700(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$1800(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$1900(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ ITelApplication access$2000(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$2100(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ TelDialNumberSessionHandler access$2200(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.dialNumberSessionHandler;
    }

    static /* synthetic */ ITelApplication access$2300(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$2400(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$2500(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$2600(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ ITelLockStateHandler access$2700(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.lockStateHandlerService;
    }

    static /* synthetic */ LogChannel access$2800(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$2900(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ SpellerModelApp access$3000(AbstractPhoneServiceImpl abstractPhoneServiceImpl, int n) {
        return abstractPhoneServiceImpl.getSpellerModel(n);
    }

    static /* synthetic */ ButtonModelApp access$3100(AbstractPhoneServiceImpl abstractPhoneServiceImpl, int n) {
        return abstractPhoneServiceImpl.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$3200(AbstractPhoneServiceImpl abstractPhoneServiceImpl, int n) {
        return abstractPhoneServiceImpl.getButtonModel(n);
    }

    static /* synthetic */ LogChannel access$3300(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ ITelApplication access$3400(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.getApplication();
    }

    static /* synthetic */ LogChannel access$3500(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$3700(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$3800(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }

    static /* synthetic */ LogChannel access$3900(AbstractPhoneServiceImpl abstractPhoneServiceImpl) {
        return abstractPhoneServiceImpl.log;
    }
}

