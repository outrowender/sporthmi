/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.properties;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.properties.ReadOnlyProperty;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface Property<T>
extends Consumer<T>,
ReadOnlyProperty<T> {
}

