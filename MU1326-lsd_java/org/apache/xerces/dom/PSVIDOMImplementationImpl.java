/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.dom;

import org.apache.xerces.dom.CoreDOMImplementationImpl;
import org.apache.xerces.dom.CoreDocumentImpl;
import org.apache.xerces.dom.DOMMessageFormatter;
import org.apache.xerces.dom.PSVIDocumentImpl;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

public class PSVIDOMImplementationImpl
extends CoreDOMImplementationImpl {
    static PSVIDOMImplementationImpl singleton = new PSVIDOMImplementationImpl();

    public static DOMImplementation getDOMImplementation() {
        return singleton;
    }

    @Override
    public boolean hasFeature(String string, String string2) {
        return super.hasFeature(string, string2) || string.equalsIgnoreCase("psvi");
    }

    @Override
    public Document createDocument(String string, String string2, DocumentType documentType) {
        if (documentType != null && documentType.getOwnerDocument() != null) {
            throw new DOMException(4, DOMMessageFormatter.formatMessage("http://www.w3.org/TR/1998/REC-xml-19980210", "WRONG_DOCUMENT_ERR", null));
        }
        PSVIDocumentImpl pSVIDocumentImpl = new PSVIDocumentImpl(documentType);
        Element element = ((CoreDocumentImpl)pSVIDocumentImpl).createElementNS(string, string2);
        pSVIDocumentImpl.appendChild(element);
        return pSVIDocumentImpl;
    }
}

