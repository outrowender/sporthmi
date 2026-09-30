/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;

public class DisplayContextHandler {
    private static final Observables.Combinator4<Boolean, Boolean, Integer, TerminalAndScreenModeTuple, Boolean> TVPICTURE_ALLOWED_COMBINATOR = new Observables.Combinator4<Boolean, Boolean, Integer, TerminalAndScreenModeTuple, Boolean>(){

        @Override
        public Boolean combine(Boolean bl, Boolean bl2, Integer n, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
            boolean bl3;
            boolean bl4;
            boolean bl5 = n == 0;
            boolean bl6 = false;
            if (bl.booleanValue()) {
                bl4 = TVUtil.doesTerminalModeShowFastMovingPictures(terminalAndScreenModeTuple.terminalMode);
                bl6 = bl5 && bl4;
            }
            bl4 = false;
            if (bl2.booleanValue()) {
                bl3 = TVUtil.doesTerminalModeShowTvPictures(terminalAndScreenModeTuple.terminalMode);
                bl4 = bl5 && bl3;
            }
            bl3 = n != 0 && terminalAndScreenModeTuple.terminalMode != 14;
            return new Boolean(!bl6 && !bl4 && !bl3);
        }

        @Override
        public /* synthetic */ Object combine(Object object, Object object2, Object object3, Object object4) {
            return this.combine((Boolean)object, (Boolean)object2, (Integer)object3, (TerminalAndScreenModeTuple)object4);
        }
    };
    private static final Observables.Combinator<Boolean, Integer, Integer> DISPLAY_CONTEXT_COMBINATOR = new Observables.Combinator<Boolean, Integer, Integer>(){

        @Override
        public Integer combine(Boolean bl, Integer n) {
            int n2 = 0;
            if (bl.booleanValue()) {
                n2 = n == 26 ? 1 : 23;
            }
            return new Integer(n2);
        }

        @Override
        public /* synthetic */ Object combine(Object object, Object object2) {
            return this.combine((Boolean)object, (Integer)object2);
        }
    };

    public DisplayContextHandler(TVEnv tVEnv) {
        Properties properties = tVEnv.properties.displayContext;
        tVEnv.properties.speedDisclaimer.speedDisclaimerShown.combineWith(tVEnv.properties.childlock.childlockActive).combineWith(tVEnv.properties.displayMode.currentDisplayMode).combineWith(tVEnv.properties.terminalMode.currentTerminalAndScreenMode).using(TVPICTURE_ALLOWED_COMBINATOR).subscribe(properties.writeableTvPictureIsAllowedToBeShown());
        properties.tvPictureIsAllowedToBeShown.combineWith(tVEnv.properties.dmComponent.currentDisplayableId).using(DISPLAY_CONTEXT_COMBINATOR).subscribe(properties.writeableCurrentDisplayContext());
        ChoiceModelApp choiceModelApp = tVEnv.getChoiceModel(2600123);
        properties.writeableCurrentDisplayContext().subscribe(tVEnv.modelBindings.from(choiceModelApp).intValue());
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final ReadOnlyProperty<Integer> currentDisplayContext;
        public final ReadOnlyProperty<Boolean> tvPictureIsAllowedToBeShown;

        public Properties(PropertyFactory propertyFactory) {
            this.currentDisplayContext = propertyFactory.createProperty("DisplayContextHandler.currentDisplayContext", new Integer(0));
            this.tvPictureIsAllowedToBeShown = propertyFactory.createProperty("DisplayContextHandler.tvPictureIsAllowedToBeShown", new Boolean(false));
        }

        private Property<Integer> writeableCurrentDisplayContext() {
            return (Property)this.currentDisplayContext;
        }

        private Property<Boolean> writeableTvPictureIsAllowedToBeShown() {
            return (Property)this.tvPictureIsAllowedToBeShown;
        }
    }
}

