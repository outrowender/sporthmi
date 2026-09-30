/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.reactive.observables.Observable;

public interface ModelBindings {
    public ButtonModelBinding from(ButtonModelApp var1);

    public ChoiceModelBinding from(ChoiceModelApp var1);

    public LabelModelBinding from(LabelModelApp var1);

    public RangeModelBinding from(RangeModelApp var1);

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface LabelModelBinding {
        public Consumer<Integer> intStatus();

        public Consumer<String> text();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface RangeModelBinding
    extends ButtonModelBinding {
        public Observable<Integer> increment();

        public Observable<Integer> decrement();

        public Consumer<Integer> intValue();

        public Consumer<GList<Integer>> rangeValue();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface ButtonModelBinding {
        public Observable<ButtonModelApp> keyTyped();

        public Observable<ButtonModelApp> keyReleased();

        public Observable<ButtonModelApp> keyPressed();

        public Observable<ButtonModelApp> keyLongTyped();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface ChoiceModelBinding
    extends ButtonModelBinding {
        public Observable<Integer> itemSelected();

        public Observable<Boolean> itemSelectedBoolean();

        public Observable<Integer> itemFocused();

        public Observable<Boolean> onCheckedChanged();

        public Consumer<Integer> intValue();

        public Consumer<Integer> intStatus();

        public Consumer<Boolean> boolenValue();
    }
}

