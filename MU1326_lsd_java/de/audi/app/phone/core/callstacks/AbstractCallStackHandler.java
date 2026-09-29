/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.callstacks;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.callstacks.AbstractCallStackEntryRow;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler$TelCallStackLanguageUpdateListener;
import de.audi.app.phone.core.callstacks.AbstractCallStackHandler$UnitsChangedListener;
import de.audi.app.phone.core.callstacks.TelCallStacksUtils;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.BufferedListModel;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.PhoneServiceListener;
import de.audi.atip.phone.TelServiceCallStackEntry;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class AbstractCallStackHandler
extends AbstractPhoneComponent
implements ListListener,
ServiceTrackerCustomizer {
    private final int maxColumns;
    protected volatile IGlobalTelephoneStateStruct telephoneState;
    private volatile PhoneServiceListener sdsPhoneServiceListener;
    private volatile ServiceTracker sdsPhoneServiceListenerTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$PhoneServiceListener;

    private static TelServiceCallStackEntry getTelServiceCallStackEntry(CallStackEntry callStackEntry, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return new TelServiceCallStackEntry(callStackEntry.getClEntryID(), iGlobalTelephoneStateStruct.getDisplayName(callStackEntry.getClName(), callStackEntry.getClNumber()), callStackEntry.getClNumber(), callStackEntry.getAdbEntryID(), (short)callStackEntry.getAdbNumberType(), (short)callStackEntry.getClEntryOrigin(), callStackEntry.getAdbPictureID(), callStackEntry.getAdbPhoneDataIndex(), callStackEntry.getAdbPhoneDataCount(), TelCallStacksUtils.getDate(callStackEntry));
    }

    private static TelServiceCallStackEntry[] createSDSCallStackArray(CallStackEntry[] callStackEntryArray, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        TelServiceCallStackEntry[] telServiceCallStackEntryArray = new TelServiceCallStackEntry[callStackEntryArray.length];
        for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
            telServiceCallStackEntryArray[i2] = AbstractCallStackHandler.getTelServiceCallStackEntry(callStackEntryArray[i2], iGlobalTelephoneStateStruct);
        }
        return telServiceCallStackEntryArray;
    }

    public AbstractCallStackHandler(ITelApplication iTelApplication, int n) {
        super(iTelApplication, "App.Phone.Main");
        this.maxColumns = n;
        this.addSubPhoneComponent(new AbstractCallStackHandler$UnitsChangedListener(this, iTelApplication));
        this.addSubPhoneComponent(new AbstractCallStackHandler$TelCallStackLanguageUpdateListener(this, iTelApplication));
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getGlobalTelephoneStateManager().registerListener(this);
        this.getCombinedNumbersList().setListListener(this);
        this.getLastAnsweredNumbersList().setListListener(this);
        this.getLastDialedNumbersList().setListListener(this);
        this.getMissedNumbersList().setListListener(this);
        this.getCombinedNumbersList().setMaxColumns(this.maxColumns);
        this.getLastAnsweredNumbersList().setMaxColumns(this.maxColumns);
        this.getLastDialedNumbersList().setMaxColumns(this.maxColumns);
        this.getMissedNumbersList().setMaxColumns(this.maxColumns);
        this.sdsPhoneServiceListenerTracker = new ServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$PhoneServiceListener == null ? (class$de$audi$atip$interapp$PhoneServiceListener = AbstractCallStackHandler.class$("de.audi.atip.interapp.PhoneServiceListener")) : class$de$audi$atip$interapp$PhoneServiceListener).getName(), (ServiceTrackerCustomizer)this);
        this.sdsPhoneServiceListenerTracker.open();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getApplication().getGlobalTelephoneStateManager().removeListener(this);
        this.getCombinedNumbersList().resetListener();
        this.getLastAnsweredNumbersList().resetListener();
        this.getLastDialedNumbersList().resetListener();
        this.getMissedNumbersList().resetListener();
        if (this.sdsPhoneServiceListenerTracker != null) {
            this.sdsPhoneServiceListenerTracker.close();
        }
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractCallStackHandler#addingService reference is null");
            return null;
        }
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object == null) {
            this.log.log(10000, "AbstractCallStackHandler#addingService service is null");
            return null;
        }
        if (object instanceof PhoneServiceListener) {
            this.sdsPhoneServiceListener = (PhoneServiceListener)object;
            this.updateSDS();
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    private void updateSDS() {
        PhoneServiceListener phoneServiceListener = this.sdsPhoneServiceListener;
        if (phoneServiceListener != null) {
            IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.telephoneState;
            if (iGlobalTelephoneStateStruct != null) {
                CallStackEntry[] callStackEntryArray = iGlobalTelephoneStateStruct.getCombinedCallStackEntries();
                if (callStackEntryArray != null) {
                    phoneServiceListener.updateCallStacks(AbstractCallStackHandler.createSDSCallStackArray(callStackEntryArray, iGlobalTelephoneStateStruct));
                }
            } else {
                this.log.log(-1601830656, "[AbstractCallStackHandler#updateSDS] global state is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[AbstractCallStackHandler#updateSDS] PhoneServiceListener not available --> NOP!");
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (serviceReference == null) {
            this.log.log(10000, "AbstractTel2EnqueuedBAPPropertyHandler#addingService reference is null");
            return;
        }
        if (object == null) {
            this.log.log(10000, "AbstractTel2EnqueuedBAPPropertyHandler#addingService service is null");
            return;
        }
        if (object instanceof PhoneServiceListener) {
            this.sdsPhoneServiceListener = null;
            this.getApplication().getBundleContext().ungetService(serviceReference);
        }
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        this.telephoneState = iGlobalTelephoneStateStruct;
        switch (n) {
            case 65576: {
                this.updateCombinedCallStackList(iGlobalTelephoneStateStruct.getCombinedCallStackEntries());
                break;
            }
            case 65573: {
                this.updateLastAnsweredNumbers(iGlobalTelephoneStateStruct.getLastAnsweredNumbers());
                break;
            }
            case 65574: {
                this.updateLastDialedNumbers(iGlobalTelephoneStateStruct.getLastDialedNumbers());
                break;
            }
            case 65575: {
                this.updateMissedNumbers(iGlobalTelephoneStateStruct.getMissedNumbers());
                break;
            }
            default: {
                this.log.log(-2137614336, "[AbstractCallStackHandler#updateGlobalTelephoneStateProperty] no handling for key %1", (long)n);
            }
        }
    }

    protected ListModelApp getCombinedNumbersList() {
        return this.getListModel(412484608);
    }

    protected ListModelApp getLastAnsweredNumbersList() {
        return this.getListModel(529925120);
    }

    protected ListModelApp getLastDialedNumbersList() {
        return this.getListModel(462816256);
    }

    protected ListModelApp getMissedNumbersList() {
        return this.getListModel(496370688);
    }

    protected void updateMissedNumbers(CallStackEntry[] callStackEntryArray) {
        this.updateCallStackList(callStackEntryArray, (BufferedListModel)this.getMissedNumbersList(), 2);
    }

    protected void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray) {
        this.updateCallStackList(callStackEntryArray, (BufferedListModel)this.getLastDialedNumbersList(), 0);
    }

    protected void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray) {
        this.updateCallStackList(callStackEntryArray, (BufferedListModel)this.getLastAnsweredNumbersList(), 1);
    }

    protected void updateCombinedCallStackList(CallStackEntry[] callStackEntryArray) {
        this.updateCallStackList(callStackEntryArray, (BufferedListModel)this.getCombinedNumbersList(), 3);
        this.updateSDS();
    }

    private void updateCallStackList(CallStackEntry[] callStackEntryArray, BufferedListModel bufferedListModel, int n) {
        if (callStackEntryArray != null && bufferedListModel != null) {
            bufferedListModel.beginTransaction();
            bufferedListModel.clear();
            for (int i2 = 0; i2 < callStackEntryArray.length; ++i2) {
                BaseListRow baseListRow;
                if (callStackEntryArray[i2] == null || (baseListRow = this.getCallStackRow(callStackEntryArray[i2])) == null) continue;
                bufferedListModel.addRow(baseListRow);
            }
            bufferedListModel.endTransaction();
        }
    }

    @Override
    public void itemReleased(int n, int n2, int n3, int n4) {
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        AbstractCallStackEntryRow abstractCallStackEntryRow = this.getCallStackRow(n, n2);
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[AbstractCallStackHandler#itemSelected] %1, callStackRow=%2", (Object)TelLoggingUtils.itemSelectedList(n, n2, n3, n4), (Object)abstractCallStackEntryRow);
        }
        this.callStackEntrySelected(n, abstractCallStackEntryRow, n3, n4);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected AbstractCallStackEntryRow getCallStackRow(int n, int n2) {
        return (AbstractCallStackEntryRow)this.getListModel(n).getRow(n2);
    }

    protected void callEntry(CallStackEntry callStackEntry, int n) {
        if (callStackEntry != null) {
            this.getApplication().getTelephoneDSIAccess().dialNumberFromCallStackEntry(callStackEntry, n);
            this.callStackEntryDialed(callStackEntry);
        } else {
            this.log.log(-1601830656, "[TelEvoCombinedCallStackHandler#keyTyped] no call stack entry available!");
        }
    }

    protected abstract BaseListRow getCallStackRow(CallStackEntry callStackEntry) {
    }

    protected abstract void callStackEntrySelected(int n, AbstractCallStackEntryRow abstractCallStackEntryRow, int n2, int n3) {
    }

    protected abstract void updateCallStackEntries() {
    }

    protected abstract void callStackEntryDialed(CallStackEntry callStackEntry) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

