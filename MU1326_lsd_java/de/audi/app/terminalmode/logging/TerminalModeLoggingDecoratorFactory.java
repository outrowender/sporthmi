/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.logging.ILoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$1;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$10;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$11;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$12;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$2;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$3;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$4;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$5;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$6;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$7;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$8;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$9;
import de.audi.app.terminalmode.logging.TerminalModeLoggingDecoratorFactory$Factory;
import java.util.HashMap;
import java.util.Map;

public class TerminalModeLoggingDecoratorFactory
implements ILoggingDecoratorFactory {
    private final Map wrapperFactories;
    private final ITerminalLogger logger;
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplay;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ToneService;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext;
    static /* synthetic */ Class class$de$audi$atip$interapp$audio$ATIPMediaRouterService;
    static /* synthetic */ Class class$de$audi$atip$audio$IAudioFocusManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode;
    static /* synthetic */ Class class$org$dsi$ifc$androidauto2$DSIAndroidAuto2;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlife;
    static /* synthetic */ Class class$org$dsi$ifc$carlife$DSICarlifeListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothService;

    public TerminalModeLoggingDecoratorFactory(ITerminalLogger iTerminalLogger) {
        this.logger = iTerminalLogger;
        this.wrapperFactories = new HashMap();
        this.addFactory(class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration, new TerminalModeLoggingDecoratorFactory$1(this));
        this.addFactory(class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay, new TerminalModeLoggingDecoratorFactory$2(this));
        this.addFactory(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService, new TerminalModeLoggingDecoratorFactory$3(this));
        this.addFactory(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new TerminalModeLoggingDecoratorFactory$4(this));
        this.addFactory(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, new TerminalModeLoggingDecoratorFactory$5(this));
        this.addFactory(class$de$audi$atip$interapp$audio$ATIPMediaRouterService == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.audio.ATIPMediaRouterService")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterService, new TerminalModeLoggingDecoratorFactory$6(this));
        this.addFactory(class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager, new TerminalModeLoggingDecoratorFactory$7(this));
        this.addFactory(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode, new TerminalModeLoggingDecoratorFactory$8(this));
        this.addFactory(class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2, new TerminalModeLoggingDecoratorFactory$9(this));
        this.addFactory(class$org$dsi$ifc$carlife$DSICarlife == null ? (class$org$dsi$ifc$carlife$DSICarlife = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.carlife.DSICarlife")) : class$org$dsi$ifc$carlife$DSICarlife, new TerminalModeLoggingDecoratorFactory$10(this));
        this.addFactory(class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener, new TerminalModeLoggingDecoratorFactory$11(this));
        this.addFactory(class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService, new TerminalModeLoggingDecoratorFactory$12(this));
    }

    private void addFactory(Class clazz, TerminalModeLoggingDecoratorFactory$Factory terminalModeLoggingDecoratorFactory$Factory) {
        this.wrapperFactories.put(clazz.getName(), terminalModeLoggingDecoratorFactory$Factory);
        this.wrapperFactories.put(clazz.toString(), terminalModeLoggingDecoratorFactory$Factory);
    }

    @Override
    public Object wrap(Class clazz, Object object) {
        return this.wrap(clazz.getName(), object);
    }

    @Override
    public Object wrap(String string, Object object) {
        TerminalModeLoggingDecoratorFactory$Factory terminalModeLoggingDecoratorFactory$Factory = (TerminalModeLoggingDecoratorFactory$Factory)this.wrapperFactories.get(string);
        if (terminalModeLoggingDecoratorFactory$Factory == null) {
            this.logger.main().log(14808325, "[TerminalModeLoggingDecoratorFactory.wrap] no logging wrapper for %1", (Object)string);
            return object;
        }
        try {
            this.logger.main().log(-2137614336, "[TerminalModeLoggingDecoratorFactory.wrap] found logging wrapper for %1", (Object)string);
            return terminalModeLoggingDecoratorFactory$Factory.wrap(object);
        }
        catch (Exception exception) {
            this.logger.main().log(-1601830656, "[TerminalModeLoggingDecoratorFactory.wrap] Something went wrong while wrapping  %1 as %2!", object, (Object)string, (Object)exception);
            return object;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITerminalLogger access$000(TerminalModeLoggingDecoratorFactory terminalModeLoggingDecoratorFactory) {
        return terminalModeLoggingDecoratorFactory.logger;
    }
}

