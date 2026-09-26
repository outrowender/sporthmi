/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings;

import de.audi.app.settings.AbstractSettingsActivator;
import de.audi.app.settings.display.DisplayHandlerEvo;
import de.audi.app.settings.etc.AbstractETCTextFactory;
import de.audi.app.settings.etc.ETCPopupManagerEvo;
import de.audi.app.settings.etc.ETCTextFactoryEvo;
import de.audi.app.settings.evo.ap.SettingsEvoActionProxy;
import de.audi.app.settings.hints.UserHints;
import de.audi.app.settings.sdis.SDISHandlerEvo;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SettingsActivator
extends AbstractSettingsActivator {
    private UserHints userHints;
    private ServiceTracker sdisServiceTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingListener;
    static /* synthetic */ Class class$de$audi$atip$msg$MsgListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISHeadUnitService;

    @Override
    public void start(BundleContext bundleContext) {
        String[] stringArray;
        this.getEnv().getVariantMapper().setRDKHighViewAvaliableChoiceID(589891840);
        this.getEnv().getVariantMapper().setShouldLinkSpeedAndDistance(false);
        this.getEnv().setTimeZoneOffsets(new float[]{16449, 12353, 8257, 6209, 4161, 65, 57408, 53312, 49216, 47168, 45120, 41024, 36928, 32832, 24640, 16448, 2.0f, 1.0f, 0.0f, 32959, 192, 16576, 24768, 32960, 37056, 41152, 49344, 57536, 193, 4289, 6337, 8385, 12481});
        super.start(bundleContext);
        this.displayHandler = new DisplayHandlerEvo(this.getEnv(), null);
        this.sdisHandler = new SDISHandlerEvo(this.getEnv());
        if (this.getEnv().isSDISAvailable()) {
            this.registerService((class$de$audi$atip$interapp$sdis$ISDISBlockingListener == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingListener = SettingsActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingListener")) : class$de$audi$atip$interapp$sdis$ISDISBlockingListener).getName(), (Object)this.sdisHandler, null);
            this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SettingsActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.sdisHandler, null);
            stringArray = new String[]{(class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = SettingsActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService).getName(), (class$de$audi$atip$interapp$sdis$ISDISHeadUnitService == null ? (class$de$audi$atip$interapp$sdis$ISDISHeadUnitService = SettingsActivator.class$("de.audi.atip.interapp.sdis.ISDISHeadUnitService")) : class$de$audi$atip$interapp$sdis$ISDISHeadUnitService).getName()};
            this.sdisServiceTracker = new ServiceTracker(this.getBundleContext(), stringArray, (ServiceTrackerCustomizer)this);
            this.sdisServiceTracker.open();
        }
        this.registerActionProxy(new SettingsEvoActionProxy(this.getEnv()), 16);
        this.userHints = new UserHints(this.getEnv());
        this.registerService((class$de$audi$atip$msg$MsgListener == null ? (class$de$audi$atip$msg$MsgListener = SettingsActivator.class$("de.audi.atip.msg.MsgListener")) : class$de$audi$atip$msg$MsgListener).getName(), (Object)this.userHints, null);
        if (this.getEnv().isETCAvailable()) {
            stringArray = new ETCTextFactoryEvo();
            stringArray.setSettingsEnvironment(this.getEnv());
            this.getEnv().getEtcHandler().setTextFactory((AbstractETCTextFactory)stringArray);
            this.getEnv().getEtcHandler().setPaymentHistoryColumnCount(5);
            ETCPopupManagerEvo eTCPopupManagerEvo = new ETCPopupManagerEvo(this.getEnv().getFw());
            this.getEnv().getEtcHandler().setPopupManager(eTCPopupManagerEvo);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
        super.stop(bundleContext);
        this.sdisServiceTracker = this.closeTracker(this.sdisServiceTracker);
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

