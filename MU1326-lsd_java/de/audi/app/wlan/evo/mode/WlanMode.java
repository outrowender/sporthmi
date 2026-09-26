/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.evo.mode;

import de.audi.app.data.core.online.IOnline;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.app.wlan.core.mode.AbstractWlanMode;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class WlanMode
extends AbstractWlanMode
implements ChoiceListener {
    private static final int OFF;
    private static final int ON;
    private final ChoiceModelApp wlanModeChoice = this.getChoiceModel(-2061097472);
    private final ChoiceModelApp automatedTetheringReconnect = this.getChoiceModel(505882112);
    private static final int SDIS_NOT_CONNECTED;
    private static final int SDIS_CONNECTED;
    private final ServiceTracker tracker = new ServiceTracker(this.bundleContext, (class$de$audi$app$data$core$online$IOnline == null ? (class$de$audi$app$data$core$online$IOnline = WlanMode.class$("de.audi.app.data.core.online.IOnline")) : class$de$audi$app$data$core$online$IOnline).getName(), (ServiceTrackerCustomizer)this);
    private IOnline iOnline;
    static /* synthetic */ Class class$de$audi$app$data$core$online$IOnline;

    public WlanMode(IWlanApplication iWlanApplication) {
        super(iWlanApplication);
    }

    @Override
    protected void setWlanMode(boolean bl, int n) {
        if (bl) {
            this.wlanModeChoice.setValue(1);
            if (this.automatedTetheringReconnect.getValue() == 1 && !this.isClientModeForbidden()) {
                this.setRoleOnly(4, null);
            }
        } else {
            this.wlanModeChoice.setValue(0);
        }
        this.log.log(-2137614336, "WlanMode#setWlanMode(): new value: %1", (long)this.wlanModeChoice.getValue());
        if (this.iOnline != null) {
            this.iOnline.updateWlanMode(bl, n == 4 || n == 2);
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.wlanModeChoice.getID()) {
            this.log.log(1078071040, "WlanMode#itemSelected(): wlanMode itemID=%1", (long)n2);
            switch (n2) {
                case 0: {
                    this.wlanModeChoice.setValue(0);
                    this.turnWlanOn(false, this.wlanModeChoice);
                    break;
                }
                case 1: {
                    this.wlanModeChoice.setValue(1);
                    this.turnWlanOn(true, this.wlanModeChoice);
                    break;
                }
                default: {
                    this.log.log(-1601830656, "WlanMode#itemSelected(): Unmapped wlan mode selected, doing nothing.");
                    break;
                }
            }
        } else if (n == this.automatedTetheringReconnect.getID()) {
            this.log.log(1078071040, "WlanMode#itemSelected(): automatedTetheringReconnect itemID=%1", (long)n2);
            switch (n2) {
                case 0: {
                    this.automatedTetheringReconnect.setValue(0);
                    this.setRoleOnly(1, null);
                    break;
                }
                case 1: {
                    this.automatedTetheringReconnect.setValue(1);
                    this.setRoleOnly(4, null);
                    break;
                }
                default: {
                    this.log.log(-1601830656, "WlanMode#itemSelected(): Unmapped wlan mode selected, doing nothing.");
                }
            }
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IOnline) {
            this.iOnline = (IOnline)object;
            return object;
        }
        return super.addingService(serviceReference);
    }

    @Override
    public void updateSdisConnected(boolean bl) {
        super.updateSdisConnected(bl);
        if (!this.isClientModeForbidden() && this.automatedTetheringReconnect.getValue() == 1) {
            this.setRoleOnly(4, null);
        }
        this.getChoiceModel(421996032).setValue(bl ? 1 : 0);
    }

    @Override
    public void updateRole(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        super.updateRole(n, n2);
        boolean bl = n == 2 || n == 4;
        this.automatedTetheringReconnect.setValue(bl ? 1 : 0);
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnline) {
            this.iOnline = null;
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnline) {
            this.iOnline = (IOnline)object;
        }
        super.modifiedService(serviceReference, object);
    }

    @Override
    public void init() {
        super.init();
        this.wlanModeChoice.setChoiceListener(this);
        this.automatedTetheringReconnect.setChoiceListener(this);
        this.tracker.open();
    }

    @Override
    public void deinit() {
        this.tracker.close();
        this.automatedTetheringReconnect.resetListener();
        this.wlanModeChoice.resetListener();
        super.deinit();
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

