/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.base.TVEnv;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class DisplayModeHandler {
    public static final int DISPLAYMODE_VIDEO = 0;
    public static final int DISPLAYMODE_AUDIO = 1;
    public static final int DISPLAYMODE_DATA = 2;
    private static final Observables.Combinator3<Boolean, Integer, ServiceInfo, Integer> DISPLAYMODE_CHOICE_COMBINATOR = new Observables.Combinator3<Boolean, Integer, ServiceInfo, Integer>(){

        @Override
        public Integer combine(Boolean bl, Integer n, ServiceInfo serviceInfo) {
            int n2 = 0;
            if (n == 0) {
                n2 = DisplayModeHandler.getFullscreenType(serviceInfo, bl);
            }
            return new Integer(n2);
        }

        @Override
        public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
            return this.combine((Boolean)object, (Integer)object2, (ServiceInfo)object3);
        }
    };

    public DisplayModeHandler(TVEnv tVEnv) {
        Properties properties = tVEnv.properties.displayMode;
        tVEnv.properties.settings.visualAudioActive.combineWith(tVEnv.properties.source.currentSource).combineWith(tVEnv.properties.dsiProperties.selectAndSelectedService).using(DISPLAYMODE_CHOICE_COMBINATOR).async(tVEnv.dispatch).subscribe(properties.writeableCurrentDisplayMode());
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600101);
        properties.currentDisplayMode.subscribe(tVEnv.modelBindings.from(choiceModelApp).intValue());
    }

    private static int getFullscreenType(ServiceInfo serviceInfo, boolean bl) {
        if (serviceInfo == null) {
            return 0;
        }
        switch (serviceInfo.sType) {
            case 3: 
            case 10: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 6: {
                return bl ? 0 : 1;
            }
        }
        return 0;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final ReadOnlyProperty<Integer> currentDisplayMode;

        public Properties(PropertyFactory propertyFactory) {
            this.currentDisplayMode = propertyFactory.createProperty("DisplayModeHandler.currentDisplayMode", new Integer(0));
        }

        private Property<Integer> writeableCurrentDisplayMode() {
            return (Property)this.currentDisplayMode;
        }
    }
}

