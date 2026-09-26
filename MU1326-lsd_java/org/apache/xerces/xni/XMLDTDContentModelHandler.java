/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.parser.XMLDTDContentModelSource;

public interface XMLDTDContentModelHandler {
    public static final short SEPARATOR_CHOICE;
    public static final short SEPARATOR_SEQUENCE;
    public static final short OCCURS_ZERO_OR_ONE;
    public static final short OCCURS_ZERO_OR_MORE;
    public static final short OCCURS_ONE_OR_MORE;

    default public void startContentModel(String string, Augmentations augmentations) {
    }

    default public void any(Augmentations augmentations) {
    }

    default public void empty(Augmentations augmentations) {
    }

    default public void startGroup(Augmentations augmentations) {
    }

    default public void pcdata(Augmentations augmentations) {
    }

    default public void element(String string, Augmentations augmentations) {
    }

    default public void separator(short s, Augmentations augmentations) {
    }

    default public void occurrence(short s, Augmentations augmentations) {
    }

    default public void endGroup(Augmentations augmentations) {
    }

    default public void endContentModel(Augmentations augmentations) {
    }

    default public void setDTDContentModelSource(XMLDTDContentModelSource xMLDTDContentModelSource) {
    }

    default public XMLDTDContentModelSource getDTDContentModelSource() {
    }
}

