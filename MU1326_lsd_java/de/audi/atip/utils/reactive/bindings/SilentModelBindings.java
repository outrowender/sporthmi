/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.Function;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.reactive.Disposable;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.observables.Observable;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;

public class SilentModelBindings
implements Disposable,
ModelBindings {
    private final LoggingPropertyFactory propertyFactory;

    public static ModelBindings create() {
        return new SilentModelBindings(LoggingPropertyFactory.create());
    }

    protected SilentModelBindings(LoggingPropertyFactory loggingPropertyFactory) {
        this.propertyFactory = Preconditions.checkNotNull(loggingPropertyFactory);
    }

    public ModelBindings.ButtonModelBinding from(ButtonModelApp buttonModelApp) {
        return new ButtonModelBindingImpl(new ButtonListenerAdapter(buttonModelApp));
    }

    public ModelBindings.ChoiceModelBinding from(ChoiceModelApp choiceModelApp) {
        return new ChoiceModelBindingImpl(choiceModelApp, new ChoiceListenerAdapter(choiceModelApp));
    }

    public ModelBindings.LabelModelBinding from(LabelModelApp labelModelApp) {
        return new LabelModelBindingImpl(labelModelApp);
    }

    public ModelBindings.RangeModelBinding from(RangeModelApp rangeModelApp) {
        return new RangeModelBindingImpl(rangeModelApp, new RangeListenerAdapter(rangeModelApp));
    }

    public void dispose() {
        this.propertyFactory.dispose();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class RangeListenerAdapter
    extends ButtonListenerAdapter
    implements RangeListener {
        private final RangeModelApp rangeModel;
        private final Property<Integer> increment;
        private final Property<Integer> decrement;

        public RangeListenerAdapter(RangeModelApp rangeModelApp) {
            super(rangeModelApp);
            this.rangeModel = Preconditions.checkNotNull(rangeModelApp);
            this.increment = SilentModelBindings.this.propertyFactory.createProperty("");
            this.decrement = SilentModelBindings.this.propertyFactory.createProperty("");
        }

        @Override
        public void decrement(int n, int n2, int n3) {
            if (n == this.rangeModel.getID() && n3 == this.rangeModel.getTerminalID()) {
                this.decrement.accept(new Integer(n2));
            }
        }

        @Override
        public void increment(int n, int n2, int n3) {
            if (n == this.rangeModel.getID() && n3 == this.rangeModel.getTerminalID()) {
                this.increment.accept(new Integer(n2));
            }
        }

        @Override
        protected void doRegister() {
            this.rangeModel.setRangeListener(this);
        }

        public Observable<Integer> increment() {
            this.lazyRegister();
            return this.increment.observeNonSticky();
        }

        public Observable<Integer> decrement() {
            this.lazyRegister();
            return this.decrement.observeNonSticky();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class ButtonListenerAdapter
    implements ButtonListener {
        private final Property<ButtonModelApp> keyTyped;
        private final Property<ButtonModelApp> keyReleased;
        private final Property<ButtonModelApp> keyPressed;
        private final Property<ButtonModelApp> keyLongTyped;
        private final ButtonModelApp buttonModel;
        private boolean isRegistered;

        public ButtonListenerAdapter(ButtonModelApp buttonModelApp) {
            this.buttonModel = Preconditions.checkNotNull(buttonModelApp);
            this.keyTyped = SilentModelBindings.this.propertyFactory.createProperty("");
            this.keyReleased = SilentModelBindings.this.propertyFactory.createProperty("");
            this.keyPressed = SilentModelBindings.this.propertyFactory.createProperty("");
            this.keyLongTyped = SilentModelBindings.this.propertyFactory.createProperty("");
        }

        @Override
        public void keyTyped(int n, int n2, int n3) {
            this.keyTyped.accept(this.buttonModel);
        }

        @Override
        public void keyReleased(int n, int n2, int n3) {
            this.keyReleased.accept(this.buttonModel);
        }

        @Override
        public void keyPressed(int n, int n2, int n3) {
            this.keyPressed.accept(this.buttonModel);
        }

        @Override
        public void keyLongTyped(int n, int n2, int n3) {
            this.keyLongTyped.accept(this.buttonModel);
        }

        public Property<ButtonModelApp> keyPressed() {
            this.lazyRegister();
            return this.keyPressed;
        }

        public Property<ButtonModelApp> keyReleased() {
            this.lazyRegister();
            return this.keyReleased;
        }

        public Property<ButtonModelApp> keyLongTyped() {
            this.lazyRegister();
            return this.keyLongTyped;
        }

        public Property<ButtonModelApp> keyTyped() {
            this.lazyRegister();
            return this.keyTyped;
        }

        protected void doRegister() {
            this.buttonModel.setButtonListener(this);
        }

        protected final synchronized void lazyRegister() {
            if (!this.isRegistered) {
                this.doRegister();
                this.isRegistered = true;
            }
        }

        public void keyAborted(int n, int n2, int n3) {
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class ChoiceListenerAdapter
    extends ButtonListenerAdapter
    implements ChoiceListener {
        private final ChoiceModelApp choiceModel;
        private final Property<Integer> itemSelected;
        private final Property<Integer> itemFocused;

        public ChoiceListenerAdapter(ChoiceModelApp choiceModelApp) {
            super(choiceModelApp);
            this.choiceModel = Preconditions.checkNotNull(choiceModelApp);
            this.itemSelected = SilentModelBindings.this.propertyFactory.createProperty("");
            this.itemFocused = SilentModelBindings.this.propertyFactory.createProperty("");
        }

        @Override
        public void itemSelected(int n, int n2, int n3, int n4) {
            this.itemSelected.accept(new Integer(n2));
        }

        @Override
        public void itemFocused(int n, int n2, int n3, int n4) {
            this.itemFocused.accept(new Integer(n2));
        }

        @Override
        protected void doRegister() {
            this.choiceModel.setChoiceListener(this);
        }

        public Observable<Integer> itemFocused() {
            this.lazyRegister();
            return this.itemFocused.observeNonSticky();
        }

        public Observable<Integer> itemSelected() {
            this.lazyRegister();
            return this.itemSelected.observeNonSticky();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class LabelModelBindingImpl
    implements ModelBindings.LabelModelBinding {
        private final LabelModelApp labelModel;

        public LabelModelBindingImpl(LabelModelApp labelModelApp) {
            this.labelModel = Preconditions.checkNotNull(labelModelApp);
        }

        @Override
        public Consumer<Integer> intStatus() {
            return new Consumer<Integer>(){

                @Override
                public void accept(Integer n) {
                    LabelModelBindingImpl.this.labelModel.setStatus(n);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((Integer)object);
                }
            };
        }

        @Override
        public Consumer<String> text() {
            return new Consumer<String>(){

                @Override
                public void accept(String string) {
                    LabelModelBindingImpl.this.labelModel.setText(string);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((String)object);
                }
            };
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class RangeModelBindingImpl
    extends ButtonModelBindingImpl
    implements ModelBindings.RangeModelBinding {
        private final RangeModelApp rangeModel;
        private final RangeListenerAdapter rangeListenerAdapter;

        public RangeModelBindingImpl(RangeModelApp rangeModelApp, RangeListenerAdapter rangeListenerAdapter) {
            super(rangeListenerAdapter);
            this.rangeModel = Preconditions.checkNotNull(rangeModelApp);
            this.rangeListenerAdapter = Preconditions.checkNotNull(rangeListenerAdapter);
        }

        @Override
        public Observable<Integer> increment() {
            return this.rangeListenerAdapter.increment();
        }

        @Override
        public Observable<Integer> decrement() {
            return this.rangeListenerAdapter.decrement();
        }

        @Override
        public Consumer<Integer> intValue() {
            return new Consumer<Integer>(){

                @Override
                public void accept(Integer n) {
                    if (n >= RangeModelBindingImpl.this.rangeModel.getMinimum() && n < RangeModelBindingImpl.this.rangeModel.getMaximum() && n.intValue() != RangeModelBindingImpl.this.rangeModel.getValue()) {
                        RangeModelBindingImpl.this.rangeModel.setValue(n);
                    }
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((Integer)object);
                }
            };
        }

        @Override
        public Consumer<GList<Integer>> rangeValue() {
            return new Consumer<GList<Integer>>(){

                @Override
                public void accept(GList<Integer> gList) {
                    if (gList.size() < 3) {
                        return;
                    }
                    int n = gList.get(0);
                    int n2 = gList.get(1);
                    int n3 = gList.get(2);
                    if (gList.size() > 3) {
                        int n4 = gList.get(3);
                        if (n != RangeModelBindingImpl.this.rangeModel.getMinimum() || n2 != RangeModelBindingImpl.this.rangeModel.getMaximum() || n3 != RangeModelBindingImpl.this.rangeModel.getStep() || n4 != RangeModelBindingImpl.this.rangeModel.getMedialPosition()) {
                            RangeModelBindingImpl.this.rangeModel.setLimits(n, n2, n3, n4);
                        }
                    } else if (n != RangeModelBindingImpl.this.rangeModel.getMinimum() || n2 != RangeModelBindingImpl.this.rangeModel.getMaximum() || n3 != RangeModelBindingImpl.this.rangeModel.getStep()) {
                        RangeModelBindingImpl.this.rangeModel.setLimits(n, n2, n3);
                    }
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((GList)object);
                }
            };
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ButtonModelBindingImpl
    implements ModelBindings.ButtonModelBinding {
        protected final ButtonListenerAdapter lazyRegisteredButtonListener;

        public ButtonModelBindingImpl(ButtonListenerAdapter buttonListenerAdapter) {
            this.lazyRegisteredButtonListener = Preconditions.checkNotNull(buttonListenerAdapter);
        }

        @Override
        public final Observable<ButtonModelApp> keyTyped() {
            return this.lazyRegisteredButtonListener.keyTyped().observeNonSticky();
        }

        @Override
        public final Observable<ButtonModelApp> keyReleased() {
            return this.lazyRegisteredButtonListener.keyReleased().observeNonSticky();
        }

        @Override
        public final Observable<ButtonModelApp> keyPressed() {
            return this.lazyRegisteredButtonListener.keyPressed().observeNonSticky();
        }

        @Override
        public final Observable<ButtonModelApp> keyLongTyped() {
            return this.lazyRegisteredButtonListener.keyLongTyped().observeNonSticky();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ChoiceModelBindingImpl
    extends ButtonModelBindingImpl
    implements ModelBindings.ChoiceModelBinding {
        private final ChoiceModelApp choiceModel;
        private final ChoiceListenerAdapter listenerPublisherAdapter;

        public ChoiceModelBindingImpl(ChoiceModelApp choiceModelApp, ChoiceListenerAdapter choiceListenerAdapter) {
            super(choiceListenerAdapter);
            this.choiceModel = Preconditions.checkNotNull(choiceModelApp);
            this.listenerPublisherAdapter = Preconditions.checkNotNull(choiceListenerAdapter);
        }

        @Override
        public Observable<Integer> itemSelected() {
            return this.listenerPublisherAdapter.itemSelected();
        }

        @Override
        public Observable<Boolean> itemSelectedBoolean() {
            return this.listenerPublisherAdapter.itemSelected().map(new Function<Integer, Boolean>(){

                @Override
                public Boolean apply(Integer n) {
                    return new Boolean(n != 0);
                }

                @Override
                public /* synthetic */ Object apply(Object object) {
                    return this.apply((Integer)object);
                }
            });
        }

        @Override
        public Observable<Integer> itemFocused() {
            return this.listenerPublisherAdapter.itemFocused();
        }

        @Override
        public Observable<Boolean> onCheckedChanged() {
            return this.itemSelected().map(new Function<Integer, Boolean>(){

                @Override
                public Boolean apply(Integer n) {
                    return new Boolean(n != 0);
                }

                @Override
                public /* synthetic */ Object apply(Object object) {
                    return this.apply((Integer)object);
                }
            });
        }

        @Override
        public Consumer<Integer> intValue() {
            return new Consumer<Integer>(){

                @Override
                public void accept(Integer n) {
                    ChoiceModelBindingImpl.this.choiceModel.setValue(n);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((Integer)object);
                }
            };
        }

        @Override
        public Consumer<Integer> intStatus() {
            return new Consumer<Integer>(){

                @Override
                public void accept(Integer n) {
                    ChoiceModelBindingImpl.this.choiceModel.setStatus(n);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((Integer)object);
                }
            };
        }

        @Override
        public Consumer<Boolean> boolenValue() {
            return new Consumer<Boolean>(){

                @Override
                public void accept(Boolean bl) {
                    ChoiceModelBindingImpl.this.choiceModel.setValue(bl != false ? 1 : 0);
                }

                @Override
                public /* synthetic */ void accept(Object object) {
                    this.accept((Boolean)object);
                }
            };
        }
    }
}

