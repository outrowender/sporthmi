/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.ITerminalLogger;
import de.audi.app.terminalmode.logging.ATIPMediaRouterServiceLoggingDecorator;
import de.audi.app.terminalmode.logging.AudioDrawerContextLoggingDecorator;
import de.audi.app.terminalmode.logging.BluetoothServiceLoggingDecorator;
import de.audi.app.terminalmode.logging.CombiBAPServiceTerminalModeLoggingDecorator;
import de.audi.app.terminalmode.logging.DSIAndroidAuto2LoggingDecorator;
import de.audi.app.terminalmode.logging.DSICarlifeListenerLoggingDecorator;
import de.audi.app.terminalmode.logging.DSICarlifeLoggingDecorator;
import de.audi.app.terminalmode.logging.DSICarplayLoggingDecorator;
import de.audi.app.terminalmode.logging.DSISmartphoneIntegrationLoggingDecorator;
import de.audi.app.terminalmode.logging.HMIAudioServiceLoggingDecorator;
import de.audi.app.terminalmode.logging.IAudioFocusManagerLoggingDecorator;
import de.audi.app.terminalmode.logging.ILoggingDecoratorFactory;
import de.audi.app.terminalmode.logging.ToneServiceLoggingDecorator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.interapp.IBluetoothService;
import de.audi.atip.interapp.audio.ATIPMediaRouterService;
import de.audi.atip.interapp.audio.ToneService;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;

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
        this.addFactory(class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration, new Factory(){

            public Object wrap(Object object) {
                return new DSISmartphoneIntegrationLoggingDecorator((DSISmartphoneIntegration)object, TerminalModeLoggingDecoratorFactory.this.logger.dsi(), 1000000);
            }
        });
        this.addFactory(class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay, new Factory(){

            public Object wrap(Object object) {
                return new DSICarplayLoggingDecorator((DSICarplay)object, TerminalModeLoggingDecoratorFactory.this.logger.dsi(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService, new Factory(){

            public Object wrap(Object object) {
                return new HMIAudioServiceLoggingDecorator((HMIAudioService)object, TerminalModeLoggingDecoratorFactory.this.logger.audio(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$interapp$audio$ToneService == null ? (class$de$audi$atip$interapp$audio$ToneService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.audio.ToneService")) : class$de$audi$atip$interapp$audio$ToneService, new Factory(){

            public Object wrap(Object object) {
                return new ToneServiceLoggingDecorator((ToneService)object, TerminalModeLoggingDecoratorFactory.this.logger.audio(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext == null ? (class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.audio.drawer.AudioDrawerContext")) : class$de$audi$atip$interapp$audio$drawer$AudioDrawerContext, new Factory(){

            public Object wrap(Object object) {
                return new AudioDrawerContextLoggingDecorator((AudioDrawerContext)object, TerminalModeLoggingDecoratorFactory.this.logger.main(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$interapp$audio$ATIPMediaRouterService == null ? (class$de$audi$atip$interapp$audio$ATIPMediaRouterService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.audio.ATIPMediaRouterService")) : class$de$audi$atip$interapp$audio$ATIPMediaRouterService, new Factory(){

            public Object wrap(Object object) {
                return new ATIPMediaRouterServiceLoggingDecorator((ATIPMediaRouterService)object, TerminalModeLoggingDecoratorFactory.this.logger.audio(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$audio$IAudioFocusManager == null ? (class$de$audi$atip$audio$IAudioFocusManager = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.audio.IAudioFocusManager")) : class$de$audi$atip$audio$IAudioFocusManager, new Factory(){

            public Object wrap(Object object) {
                return new IAudioFocusManagerLoggingDecorator((IAudioFocusManager)object, TerminalModeLoggingDecoratorFactory.this.logger.audio(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode == null ? (class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTerminalMode")) : class$de$audi$atip$interapp$combi$bap$audio$CombiBAPServiceTerminalMode, new Factory(){

            public Object wrap(Object object) {
                return new CombiBAPServiceTerminalModeLoggingDecorator((CombiBAPServiceTerminalMode)object, TerminalModeLoggingDecoratorFactory.this.logger.main(), 1000000);
            }
        });
        this.addFactory(class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 == null ? (class$org$dsi$ifc$androidauto2$DSIAndroidAuto2 = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.androidauto2.DSIAndroidAuto2")) : class$org$dsi$ifc$androidauto2$DSIAndroidAuto2, new Factory(){

            public Object wrap(Object object) {
                return new DSIAndroidAuto2LoggingDecorator((DSIAndroidAuto2)object, TerminalModeLoggingDecoratorFactory.this.logger.dsi(), 1000000);
            }
        });
        this.addFactory(class$org$dsi$ifc$carlife$DSICarlife == null ? (class$org$dsi$ifc$carlife$DSICarlife = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.carlife.DSICarlife")) : class$org$dsi$ifc$carlife$DSICarlife, new Factory(){

            public Object wrap(Object object) {
                return new DSICarlifeLoggingDecorator((DSICarlife)object, TerminalModeLoggingDecoratorFactory.this.logger.dsi(), 1000000);
            }
        });
        this.addFactory(class$org$dsi$ifc$carlife$DSICarlifeListener == null ? (class$org$dsi$ifc$carlife$DSICarlifeListener = TerminalModeLoggingDecoratorFactory.class$("org.dsi.ifc.carlife.DSICarlifeListener")) : class$org$dsi$ifc$carlife$DSICarlifeListener, new Factory(){

            public Object wrap(Object object) {
                return new DSICarlifeListenerLoggingDecorator((DSICarlifeListener)object, TerminalModeLoggingDecoratorFactory.this.logger.dsi(), 1000000);
            }
        });
        this.addFactory(class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = TerminalModeLoggingDecoratorFactory.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService, new Factory(){

            public Object wrap(Object object) {
                return new BluetoothServiceLoggingDecorator((IBluetoothService)object, TerminalModeLoggingDecoratorFactory.this.logger.main(), 1000000);
            }
        });
    }

    private void addFactory(Class clazz, Factory factory) {
        this.wrapperFactories.put(clazz.getName(), factory);
        this.wrapperFactories.put(clazz.toString(), factory);
    }

    public Object wrap(Class clazz, Object object) {
        return this.wrap(clazz.getName(), object);
    }

    public Object wrap(String string, Object object) {
        Factory factory = (Factory)this.wrapperFactories.get(string);
        if (factory == null) {
            this.logger.main().log(100000000, "[TerminalModeLoggingDecoratorFactory.wrap] no logging wrapper for %1", (Object)string);
            return object;
        }
        try {
            this.logger.main().log(10000000, "[TerminalModeLoggingDecoratorFactory.wrap] found logging wrapper for %1", (Object)string);
            return factory.wrap(object);
        }
        catch (Exception exception) {
            this.logger.main().log(100000, "[TerminalModeLoggingDecoratorFactory.wrap] Something went wrong while wrapping  %1 as %2!", object, (Object)string, (Object)exception);
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

    private static interface Factory {
        public Object wrap(Object var1);
    }
}

