/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.xni;

import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;

public interface XMLAttributes {
    default public int addAttribute(QName qName, String string, String string2) {
    }

    default public void removeAllAttributes() {
    }

    default public void removeAttributeAt(int n) {
    }

    default public int getLength() {
    }

    default public int getIndex(String string) {
    }

    default public int getIndex(String string, String string2) {
    }

    default public void setName(int n, QName qName) {
    }

    default public void getName(int n, QName qName) {
    }

    default public String getPrefix(int n) {
    }

    default public String getURI(int n) {
    }

    default public String getLocalName(int n) {
    }

    default public String getQName(int n) {
    }

    default public void setType(int n, String string) {
    }

    default public String getType(int n) {
    }

    default public String getType(String string) {
    }

    default public String getType(String string, String string2) {
    }

    default public void setValue(int n, String string) {
    }

    default public String getValue(int n) {
    }

    default public String getValue(String string) {
    }

    default public String getValue(String string, String string2) {
    }

    default public void setNonNormalizedValue(int n, String string) {
    }

    default public String getNonNormalizedValue(int n) {
    }

    default public void setSpecified(int n, boolean bl) {
    }

    default public boolean isSpecified(int n) {
    }

    default public Augmentations getAugmentations(int n) {
    }

    default public Augmentations getAugmentations(String string, String string2) {
    }

    default public Augmentations getAugmentations(String string) {
    }

    default public void setAugmentations(int n, Augmentations augmentations) {
    }
}

