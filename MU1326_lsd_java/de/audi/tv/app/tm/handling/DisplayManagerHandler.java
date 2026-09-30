/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm.handling;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.SourceManager;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeTuple;
import de.audi.tv.app.util.generics.AbstractNewAndPreviousValueDelivery;
import de.audi.tv.app.util.generics.Triple;
import de.audi.tv.app.util.generics.TvPredicates;

public class DisplayManagerHandler {
    private static final int START_WARMUP_MILLIS = 600;
    private IDispatcher.ICancelable lastStartComponentJob = new IDispatcher.ICancelable.Stub();
    private final DSITV dsi;
    private final IDispatcher tvDispatcher;
    private final TVEnv env;

    public DisplayManagerHandler(final TVEnv tVEnv, DSITV dSITV, IDispatcher iDispatcher) {
        this.dsi = dSITV;
        this.tvDispatcher = iDispatcher;
        this.env = tVEnv;
        Properties properties = tVEnv.properties.dmComponent;
        SourceManager.Properties properties2 = tVEnv.properties.source;
        tVEnv.properties.terminalMode.terminalModeChangeRunning.filter(TvPredicates.IS_FALSE).combineWith(tVEnv.properties.terminalMode.currentTerminalAndScreenMode).using(new Observables.Combinator<Boolean, TerminalAndScreenModeTuple, Integer>(){

            @Override
            public Integer combine(Boolean bl, TerminalAndScreenModeTuple terminalAndScreenModeTuple) {
                return new Integer(terminalAndScreenModeTuple.terminalMode == 0 ? 26 : 31);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2) {
                return this.combine((Boolean)object, (TerminalAndScreenModeTuple)object2);
            }
        }).subscribe(properties.writeableCurrentDisplayableId());
        tVEnv.properties.terminalMode.terminalModeChangeRunning.combineWith(tVEnv.properties.eventDispatcher.tunerEsmReady).combineWith(tVEnv.properties.eventDispatcher.mostUnused).using(new Observables.Combinator3<Boolean, Boolean, Boolean, Boolean>(){

            @Override
            public Boolean combine(Boolean bl, Boolean bl2, Boolean bl3) {
                return new Boolean(bl == false && bl2 == false && bl3 != false);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2, Object object3) {
                return this.combine((Boolean)object, (Boolean)object2, (Boolean)object3);
            }
        }).subscribe(properties.writeableShowVideoPossible());
        properties.showVideoPossible.combineWith(properties.currentDisplayableId).combineWith(properties2.currentSource).using(Triple.combine()).distinctUntilChanged().async(iDispatcher).subscribe(new AbstractNewAndPreviousValueDelivery<Triple<Boolean, Integer, Integer>>(){

            @Override
            protected void accept(Triple<Boolean, Integer, Integer> triple, Triple<Boolean, Integer, Integer> triple2) {
                Integer n;
                Integer n2 = n = triple != null ? (Integer)triple.b : null;
                boolean bl = triple != null && triple2 != null ? triple.c != triple2.c : false;
                tVEnv.lcDSI.log(10000000, "[DisplayManagerHandler. property showVideoPossible] newdata: showVideoPossible:%1, currentDisplayableId:%2, currentSource:%3 SourceSwitched%4", triple2.a, triple2.b, triple2.c, (Object)new Boolean(bl));
                DisplayManagerHandler.this.onRelevantDataChanged((Boolean)triple2.a, (Integer)triple2.b, n, bl);
            }

            @Override
            protected /* synthetic */ void accept(Object object, Object object2) {
                this.accept((Triple)object, (Triple)object2);
            }
        });
    }

    private void onRelevantDataChanged(boolean bl, final int n, Integer n2, boolean bl2) {
        boolean bl3 = n2 != null && n != n2;
        this.env.lcDSI.log(10000000, "[DisplayManagerHandler.onRelevantDataChanged] isDisplayIdChange: %1", bl3);
        this.env.lcDSI.log(10000000, "[DisplayManagerHandler.onRelevantDataChanged] showVideoPossible: %1, displayId: %2, previousDisplayId: %3, SourceSwitched: %4", (Object)bl, (Object)new Integer(n), (Object)n2, (Object)bl2);
        this.lastStartComponentJob.cancel();
        if (!bl || bl3 || bl2 && bl3) {
            if (n2 != null) {
                this.dsi.stopComponent(n2);
                this.env.framework.getMsgDistrib().sendMessage(203);
                this.env.lcDSI.log(10000000, "[DisplayManagerHandler.onRelevantDataChanged] -> TV_TUNER_DEACTIVATED!!");
            } else {
                this.dsi.stopComponent(0);
            }
        }
        if (bl) {
            this.lastStartComponentJob = this.tvDispatcher.execute(new Runnable(){

                public void run() {
                    ((DisplayManagerHandler)DisplayManagerHandler.this).env.framework.getMsgDistrib().sendMessage(202);
                    DisplayManagerHandler.this.dsi.startComponent(n);
                    ((DisplayManagerHandler)DisplayManagerHandler.this).env.lcDSI.log(10000000, "[DisplayManagerHandler.onRelevantDataChanged] -> TV_TUNER_ACTIVATED!!");
                }
            }, 600L);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final ReadOnlyProperty<Integer> currentDisplayableId;
        public final ReadOnlyProperty<Boolean> showVideoPossible;

        public Properties(PropertyFactory propertyFactory) {
            this.currentDisplayableId = propertyFactory.createProperty("DisplayManagerHandler.currentDisplayableId");
            this.showVideoPossible = propertyFactory.createProperty("DisplayManagerHandler.showVideoPossible", new Boolean(false));
        }

        private Property<Integer> writeableCurrentDisplayableId() {
            return (Property)this.currentDisplayableId;
        }

        private Property<Boolean> writeableShowVideoPossible() {
            return (Property)this.showVideoPossible;
        }
    }
}

