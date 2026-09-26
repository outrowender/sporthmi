/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.AugmentationsImpl;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;

class XMLAttributesImpl$Attribute {
    public QName name = new QName();
    public String type;
    public String value;
    public String nonNormalizedValue;
    public boolean specified;
    public boolean schemaId;
    public Augmentations augs = new AugmentationsImpl();
    public XMLAttributesImpl$Attribute next;

    XMLAttributesImpl$Attribute() {
    }
}

