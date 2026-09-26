/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.util;

import java.io.PrintWriter;
import org.apache.xerces.dom.DOMErrorImpl;
import org.apache.xerces.dom.DOMLocatorImpl;
import org.apache.xerces.util.DOMErrorHandlerWrapper$DOMErrorTypeMap;
import org.apache.xerces.util.XMLErrorCode;
import org.apache.xerces.xni.parser.XMLErrorHandler;
import org.apache.xerces.xni.parser.XMLParseException;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

public class DOMErrorHandlerWrapper
implements XMLErrorHandler,
DOMErrorHandler {
    protected DOMErrorHandler fDomErrorHandler;
    boolean eStatus = true;
    protected PrintWriter fOut;
    public Node fCurrentNode;
    protected final XMLErrorCode fErrorCode = new XMLErrorCode(null, null);
    protected final DOMErrorImpl fDOMError = new DOMErrorImpl();

    public DOMErrorHandlerWrapper() {
        this.fOut = new PrintWriter(System.err);
    }

    public DOMErrorHandlerWrapper(DOMErrorHandler dOMErrorHandler) {
        this.fDomErrorHandler = dOMErrorHandler;
    }

    public void setErrorHandler(DOMErrorHandler dOMErrorHandler) {
        this.fDomErrorHandler = dOMErrorHandler;
    }

    public DOMErrorHandler getErrorHandler() {
        return this.fDomErrorHandler;
    }

    @Override
    public void warning(String string, String string2, XMLParseException xMLParseException) {
        this.fDOMError.fSeverity = 1;
        this.fDOMError.fException = xMLParseException;
        this.fDOMError.fType = string2;
        this.fDOMError.fMessage = xMLParseException.getMessage();
        this.fDOMError.fRelatedData = this.fDOMError.fMessage;
        DOMLocatorImpl dOMLocatorImpl = this.fDOMError.fLocator;
        if (dOMLocatorImpl != null) {
            dOMLocatorImpl.fColumnNumber = xMLParseException.getColumnNumber();
            dOMLocatorImpl.fLineNumber = xMLParseException.getLineNumber();
            dOMLocatorImpl.fUtf16Offset = xMLParseException.getCharacterOffset();
            dOMLocatorImpl.fUri = xMLParseException.getExpandedSystemId();
            dOMLocatorImpl.fRelatedNode = this.fCurrentNode;
        }
        if (this.fDomErrorHandler != null) {
            this.fDomErrorHandler.handleError(this.fDOMError);
        }
    }

    @Override
    public void error(String string, String string2, XMLParseException xMLParseException) {
        this.fDOMError.fSeverity = (short)2;
        this.fDOMError.fException = xMLParseException;
        this.fDOMError.fType = string2;
        this.fDOMError.fMessage = xMLParseException.getMessage();
        this.fDOMError.fRelatedData = this.fDOMError.fMessage;
        DOMLocatorImpl dOMLocatorImpl = this.fDOMError.fLocator;
        if (dOMLocatorImpl != null) {
            dOMLocatorImpl.fColumnNumber = xMLParseException.getColumnNumber();
            dOMLocatorImpl.fLineNumber = xMLParseException.getLineNumber();
            dOMLocatorImpl.fUtf16Offset = xMLParseException.getCharacterOffset();
            dOMLocatorImpl.fUri = xMLParseException.getExpandedSystemId();
            dOMLocatorImpl.fRelatedNode = this.fCurrentNode;
        }
        if (this.fDomErrorHandler != null) {
            this.fDomErrorHandler.handleError(this.fDOMError);
        }
    }

    @Override
    public void fatalError(String string, String string2, XMLParseException xMLParseException) {
        this.fDOMError.fSeverity = (short)3;
        this.fDOMError.fException = xMLParseException;
        this.fErrorCode.setValues(string, string2);
        String string3 = DOMErrorHandlerWrapper$DOMErrorTypeMap.getDOMErrorType(this.fErrorCode);
        this.fDOMError.fType = string3 != null ? string3 : string2;
        this.fDOMError.fMessage = xMLParseException.getMessage();
        this.fDOMError.fRelatedData = this.fDOMError.fMessage;
        DOMLocatorImpl dOMLocatorImpl = this.fDOMError.fLocator;
        if (dOMLocatorImpl != null) {
            dOMLocatorImpl.fColumnNumber = xMLParseException.getColumnNumber();
            dOMLocatorImpl.fLineNumber = xMLParseException.getLineNumber();
            dOMLocatorImpl.fUtf16Offset = xMLParseException.getCharacterOffset();
            dOMLocatorImpl.fUri = xMLParseException.getExpandedSystemId();
            dOMLocatorImpl.fRelatedNode = this.fCurrentNode;
        }
        if (this.fDomErrorHandler != null) {
            this.fDomErrorHandler.handleError(this.fDOMError);
        }
    }

    @Override
    public boolean handleError(DOMError dOMError) {
        this.printError(dOMError);
        return this.eStatus;
    }

    private void printError(DOMError dOMError) {
        short s = dOMError.getSeverity();
        this.fOut.print("[");
        if (s == 1) {
            this.fOut.print("Warning");
        } else if (s == 2) {
            this.fOut.print("Error");
        } else {
            this.fOut.print("FatalError");
            this.eStatus = false;
        }
        this.fOut.print("] ");
        DOMLocator dOMLocator = dOMError.getLocation();
        if (dOMLocator != null) {
            String string;
            this.fOut.print(dOMLocator.getLineNumber());
            this.fOut.print(":");
            this.fOut.print(dOMLocator.getColumnNumber());
            this.fOut.print(":");
            this.fOut.print(dOMLocator.getByteOffset());
            this.fOut.print(",");
            this.fOut.print(dOMLocator.getUtf16Offset());
            Node node = dOMLocator.getRelatedNode();
            if (node != null) {
                this.fOut.print("[");
                this.fOut.print(node.getNodeName());
                this.fOut.print("]");
            }
            if ((string = dOMLocator.getUri()) != null) {
                int n = string.lastIndexOf(47);
                if (n != -1) {
                    string = string.substring(n + 1);
                }
                this.fOut.print(": ");
                this.fOut.print(string);
            }
        }
        this.fOut.print(":");
        this.fOut.print(dOMError.getMessage());
        this.fOut.println();
        this.fOut.flush();
    }
}

