/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import java.util.Vector;
import org.apache.xerces.dom.DOMImplementationListImpl;
import org.apache.xerces.dom.DOMImplementationSourceImpl;
import org.apache.xerces.dom.PSVIDOMImplementationImpl;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMImplementationList;

public class DOMXSImplementationSourceImpl
extends DOMImplementationSourceImpl {
    public DOMImplementation getDOMImplementation(String string) {
        DOMImplementation dOMImplementation = super.getDOMImplementation(string);
        if (dOMImplementation != null) {
            return dOMImplementation;
        }
        dOMImplementation = PSVIDOMImplementationImpl.getDOMImplementation();
        if (this.testImpl(dOMImplementation, string)) {
            return dOMImplementation;
        }
        return null;
    }

    public DOMImplementationList getDOMImplementationList(String string) {
        Vector vector = new Vector();
        DOMImplementationList dOMImplementationList = super.getDOMImplementationList(string);
        for (int i2 = 0; i2 < dOMImplementationList.getLength(); ++i2) {
            vector.addElement(dOMImplementationList.item(i2));
        }
        DOMImplementation dOMImplementation = PSVIDOMImplementationImpl.getDOMImplementation();
        if (this.testImpl(dOMImplementation, string)) {
            vector.addElement(dOMImplementation);
        }
        return new DOMImplementationListImpl(vector);
    }
}

