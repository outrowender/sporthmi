/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.generics;

import de.audi.atip.utils.generics.GCollectionSerializable;
import de.audi.atip.utils.generics.GList;
import java.io.Serializable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface GListSerializable<T extends Serializable>
extends GCollectionSerializable<T>,
GList<T> {
}

