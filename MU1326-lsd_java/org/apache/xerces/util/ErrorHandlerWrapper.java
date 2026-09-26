/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import org.apache.xerces.util.ErrorHandlerWrapper$1;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.parser.XMLErrorHandler;
import org.apache.xerces.xni.parser.XMLParseException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ErrorHandlerWrapper
implements XMLErrorHandler {
    protected ErrorHandler fErrorHandler;

    public ErrorHandlerWrapper() {
    }

    public ErrorHandlerWrapper(ErrorHandler errorHandler) {
        this.setErrorHandler(errorHandler);
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.fErrorHandler = errorHandler;
    }

    public ErrorHandler getErrorHandler() {
        return this.fErrorHandler;
    }

    @Override
    public void warning(String string, String string2, XMLParseException xMLParseException) {
        if (this.fErrorHandler != null) {
            SAXParseException sAXParseException = ErrorHandlerWrapper.createSAXParseException(xMLParseException);
            try {
                this.fErrorHandler.warning(sAXParseException);
            }
            catch (SAXParseException sAXParseException2) {
                throw ErrorHandlerWrapper.createXMLParseException(sAXParseException2);
            }
            catch (SAXException sAXException) {
                throw ErrorHandlerWrapper.createXNIException(sAXException);
            }
        }
    }

    @Override
    public void error(String string, String string2, XMLParseException xMLParseException) {
        if (this.fErrorHandler != null) {
            SAXParseException sAXParseException = ErrorHandlerWrapper.createSAXParseException(xMLParseException);
            try {
                this.fErrorHandler.error(sAXParseException);
            }
            catch (SAXParseException sAXParseException2) {
                throw ErrorHandlerWrapper.createXMLParseException(sAXParseException2);
            }
            catch (SAXException sAXException) {
                throw ErrorHandlerWrapper.createXNIException(sAXException);
            }
        }
    }

    @Override
    public void fatalError(String string, String string2, XMLParseException xMLParseException) {
        if (this.fErrorHandler != null) {
            SAXParseException sAXParseException = ErrorHandlerWrapper.createSAXParseException(xMLParseException);
            try {
                this.fErrorHandler.fatalError(sAXParseException);
            }
            catch (SAXParseException sAXParseException2) {
                throw ErrorHandlerWrapper.createXMLParseException(sAXParseException2);
            }
            catch (SAXException sAXException) {
                throw ErrorHandlerWrapper.createXNIException(sAXException);
            }
        }
    }

    protected static SAXParseException createSAXParseException(XMLParseException xMLParseException) {
        return new SAXParseException(xMLParseException.getMessage(), xMLParseException.getPublicId(), xMLParseException.getExpandedSystemId(), xMLParseException.getLineNumber(), xMLParseException.getColumnNumber(), xMLParseException.getException());
    }

    protected static XMLParseException createXMLParseException(SAXParseException sAXParseException) {
        String string = sAXParseException.getPublicId();
        String string2 = sAXParseException.getSystemId();
        int n = sAXParseException.getLineNumber();
        int n2 = sAXParseException.getColumnNumber();
        ErrorHandlerWrapper$1 errorHandlerWrapper$1 = new ErrorHandlerWrapper$1(string, string2, n2, n);
        return new XMLParseException(errorHandlerWrapper$1, sAXParseException.getMessage(), sAXParseException);
    }

    protected static XNIException createXNIException(SAXException sAXException) {
        return new XNIException(sAXException.getMessage(), sAXException);
    }
}

