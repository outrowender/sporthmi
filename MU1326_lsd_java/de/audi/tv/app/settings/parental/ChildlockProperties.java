/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.utils.reactive.properties.Property;
import de.audi.atip.utils.reactive.properties.PropertyFactory;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;

public class ChildlockProperties {
    public final TVEventDefaultListener childLockListener = new ChildlockListener();
    private final Properties myProperties;

    public ChildlockProperties(TVEnv tVEnv) {
        this.myProperties = tVEnv.properties.childlock;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class Properties {
        public final ReadOnlyProperty<Boolean> childlockActive;
        public final ReadOnlyProperty<Integer> childlockActivationAge;

        public Properties(PropertyFactory propertyFactory) {
            this.childlockActive = propertyFactory.createProperty("ChildlockProperties.childlockActive", new Boolean(false));
            this.childlockActivationAge = propertyFactory.createProperty("ChildlockProperties.childlockActivationAge");
        }

        private Property<Boolean> writeableChildlockActive() {
            return (Property)this.childlockActive;
        }

        private Property<Integer> writeableChildlockActivationAge() {
            return (Property)this.childlockActivationAge;
        }
    }

    private class ChildlockListener
    extends TVEventDefaultListener {
        private ChildlockListener() {
        }

        public void onChildLockEnabled() {
            ChildlockProperties.this.myProperties.writeableChildlockActive().accept(new Boolean(true));
        }

        public void onChildLockDisabled() {
            ChildlockProperties.this.myProperties.writeableChildlockActive().accept(new Boolean(false));
        }

        public void parentalLevelSettingChanged(int n) {
            ChildlockProperties.this.myProperties.writeableChildlockActivationAge().accept(new Integer(n));
        }
    }
}

