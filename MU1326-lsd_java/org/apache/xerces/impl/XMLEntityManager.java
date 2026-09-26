/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Stack;
import org.apache.xerces.impl.XML11EntityScanner;
import org.apache.xerces.impl.XMLEntityHandler;
import org.apache.xerces.impl.XMLEntityManager$1;
import org.apache.xerces.impl.XMLEntityManager$ByteBufferPool;
import org.apache.xerces.impl.XMLEntityManager$CharacterBufferPool;
import org.apache.xerces.impl.XMLEntityManager$Entity;
import org.apache.xerces.impl.XMLEntityManager$ExternalEntity;
import org.apache.xerces.impl.XMLEntityManager$InternalEntity;
import org.apache.xerces.impl.XMLEntityManager$RewindableInputStream;
import org.apache.xerces.impl.XMLEntityManager$ScannedEntity;
import org.apache.xerces.impl.XMLEntityScanner;
import org.apache.xerces.impl.XMLErrorReporter;
import org.apache.xerces.impl.io.ASCIIReader;
import org.apache.xerces.impl.io.Latin1Reader;
import org.apache.xerces.impl.io.UCSReader;
import org.apache.xerces.impl.io.UTF8Reader;
import org.apache.xerces.impl.validation.ValidationManager;
import org.apache.xerces.util.AugmentationsImpl;
import org.apache.xerces.util.EncodingMap;
import org.apache.xerces.util.HTTPInputSource;
import org.apache.xerces.util.SecurityManager;
import org.apache.xerces.util.SymbolTable;
import org.apache.xerces.util.URI;
import org.apache.xerces.util.URI$MalformedURIException;
import org.apache.xerces.util.XMLChar;
import org.apache.xerces.util.XMLEntityDescriptionImpl;
import org.apache.xerces.util.XMLResourceIdentifierImpl;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.XMLResourceIdentifier;
import org.apache.xerces.xni.parser.XMLComponent;
import org.apache.xerces.xni.parser.XMLComponentManager;
import org.apache.xerces.xni.parser.XMLConfigurationException;
import org.apache.xerces.xni.parser.XMLEntityResolver;
import org.apache.xerces.xni.parser.XMLInputSource;

public class XMLEntityManager
implements XMLComponent,
XMLEntityResolver {
    public static final int DEFAULT_BUFFER_SIZE;
    public static final int DEFAULT_XMLDECL_BUFFER_SIZE;
    public static final int DEFAULT_INTERNAL_BUFFER_SIZE;
    protected static final String VALIDATION;
    protected static final String EXTERNAL_GENERAL_ENTITIES;
    protected static final String EXTERNAL_PARAMETER_ENTITIES;
    protected static final String ALLOW_JAVA_ENCODINGS;
    protected static final String WARN_ON_DUPLICATE_ENTITYDEF;
    protected static final String STANDARD_URI_CONFORMANT;
    protected static final String PARSER_SETTINGS;
    protected static final String SYMBOL_TABLE;
    protected static final String ERROR_REPORTER;
    protected static final String ENTITY_RESOLVER;
    protected static final String VALIDATION_MANAGER;
    protected static final String BUFFER_SIZE;
    protected static final String SECURITY_MANAGER;
    private static final String[] RECOGNIZED_FEATURES;
    private static final Boolean[] FEATURE_DEFAULTS;
    private static final String[] RECOGNIZED_PROPERTIES;
    private static final Object[] PROPERTY_DEFAULTS;
    private static final String XMLEntity;
    private static final String DTDEntity;
    private static final boolean DEBUG_BUFFER;
    private static final boolean DEBUG_ENTITIES;
    private static final boolean DEBUG_ENCODINGS;
    private static final boolean DEBUG_RESOLVER;
    protected boolean fValidation;
    protected boolean fExternalGeneralEntities = true;
    protected boolean fExternalParameterEntities = true;
    protected boolean fAllowJavaEncodings;
    protected boolean fWarnDuplicateEntityDef;
    protected boolean fStrictURI;
    protected SymbolTable fSymbolTable;
    protected XMLErrorReporter fErrorReporter;
    protected XMLEntityResolver fEntityResolver;
    protected ValidationManager fValidationManager;
    protected int fBufferSize = 2048;
    protected SecurityManager fSecurityManager = null;
    protected boolean fStandalone;
    protected boolean fInExternalSubset = false;
    protected XMLEntityHandler fEntityHandler;
    protected XMLEntityScanner fEntityScanner;
    protected XMLEntityScanner fXML10EntityScanner;
    protected XMLEntityScanner fXML11EntityScanner;
    protected int fEntityExpansionLimit = 0;
    protected int fEntityExpansionCount = 0;
    protected Hashtable fEntities = new Hashtable();
    protected Stack fEntityStack = new Stack();
    protected XMLEntityManager$ScannedEntity fCurrentEntity;
    protected Hashtable fDeclaredEntities;
    private final XMLResourceIdentifierImpl fResourceIdentifier = new XMLResourceIdentifierImpl();
    private final Augmentations fEntityAugs = new AugmentationsImpl();
    private final XMLEntityManager$ByteBufferPool fByteBufferPool = new XMLEntityManager$ByteBufferPool(this.fBufferSize);
    private byte[] fTempByteBuffer = null;
    private final XMLEntityManager$CharacterBufferPool fCharacterBufferPool = new XMLEntityManager$CharacterBufferPool(this.fBufferSize, 512);
    protected Stack fReaderStack = new Stack();
    private static String gUserDir;
    private static URI gUserDirURI;
    private static boolean[] gNeedEscaping;
    private static char[] gAfterEscaping1;
    private static char[] gAfterEscaping2;
    private static char[] gHexChs;
    private static PrivilegedAction GET_USER_DIR_SYSTEM_PROPERTY;
    static /* synthetic */ Class class$java$net$HttpURLConnection;

    public XMLEntityManager() {
        this(null);
    }

    public XMLEntityManager(XMLEntityManager xMLEntityManager) {
        this.fDeclaredEntities = xMLEntityManager != null ? xMLEntityManager.getDeclaredEntities() : null;
        this.setScannerVersion((short)1);
    }

    public void setStandalone(boolean bl) {
        this.fStandalone = bl;
    }

    public boolean isStandalone() {
        return this.fStandalone;
    }

    public void setEntityHandler(XMLEntityHandler xMLEntityHandler) {
        this.fEntityHandler = xMLEntityHandler;
    }

    public XMLResourceIdentifier getCurrentResourceIdentifier() {
        return this.fResourceIdentifier;
    }

    public XMLEntityManager$ScannedEntity getCurrentEntity() {
        return this.fCurrentEntity;
    }

    public void addInternalEntity(String string, String string2) {
        if (!this.fEntities.containsKey(string)) {
            XMLEntityManager$InternalEntity xMLEntityManager$InternalEntity = new XMLEntityManager$InternalEntity(string, string2, this.fInExternalSubset);
            this.fEntities.put(string, xMLEntityManager$InternalEntity);
        } else if (this.fWarnDuplicateEntityDef) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[]{string}, (short)0);
        }
    }

    public void addExternalEntity(String string, String string2, String string3, String string4) {
        if (!this.fEntities.containsKey(string)) {
            if (string4 == null) {
                int n = this.fEntityStack.size();
                if (n == 0 && this.fCurrentEntity != null && this.fCurrentEntity.entityLocation != null) {
                    string4 = this.fCurrentEntity.entityLocation.getExpandedSystemId();
                }
                for (int i2 = n - 1; i2 >= 0; --i2) {
                    XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity = (XMLEntityManager$ScannedEntity)this.fEntityStack.elementAt(i2);
                    if (xMLEntityManager$ScannedEntity.entityLocation == null || xMLEntityManager$ScannedEntity.entityLocation.getExpandedSystemId() == null) continue;
                    string4 = xMLEntityManager$ScannedEntity.entityLocation.getExpandedSystemId();
                    break;
                }
            }
            XMLEntityManager$ExternalEntity xMLEntityManager$ExternalEntity = new XMLEntityManager$ExternalEntity(string, new XMLEntityDescriptionImpl(string, string2, string3, string4, XMLEntityManager.expandSystemId(string3, string4, false)), null, this.fInExternalSubset);
            this.fEntities.put(string, xMLEntityManager$ExternalEntity);
        } else if (this.fWarnDuplicateEntityDef) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[]{string}, (short)0);
        }
    }

    public boolean isExternalEntity(String string) {
        XMLEntityManager$Entity xMLEntityManager$Entity = (XMLEntityManager$Entity)this.fEntities.get(string);
        if (xMLEntityManager$Entity == null) {
            return false;
        }
        return xMLEntityManager$Entity.isExternal();
    }

    public boolean isEntityDeclInExternalSubset(String string) {
        XMLEntityManager$Entity xMLEntityManager$Entity = (XMLEntityManager$Entity)this.fEntities.get(string);
        if (xMLEntityManager$Entity == null) {
            return false;
        }
        return xMLEntityManager$Entity.isEntityDeclInExternalSubset();
    }

    public void addUnparsedEntity(String string, String string2, String string3, String string4, String string5) {
        if (!this.fEntities.containsKey(string)) {
            XMLEntityManager$ExternalEntity xMLEntityManager$ExternalEntity = new XMLEntityManager$ExternalEntity(string, new XMLEntityDescriptionImpl(string, string2, string3, string4, null), string5, this.fInExternalSubset);
            this.fEntities.put(string, xMLEntityManager$ExternalEntity);
        } else if (this.fWarnDuplicateEntityDef) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "MSG_DUPLICATE_ENTITY_DEFINITION", new Object[]{string}, (short)0);
        }
    }

    public boolean isUnparsedEntity(String string) {
        XMLEntityManager$Entity xMLEntityManager$Entity = (XMLEntityManager$Entity)this.fEntities.get(string);
        if (xMLEntityManager$Entity == null) {
            return false;
        }
        return xMLEntityManager$Entity.isUnparsed();
    }

    public boolean isDeclaredEntity(String string) {
        XMLEntityManager$Entity xMLEntityManager$Entity = (XMLEntityManager$Entity)this.fEntities.get(string);
        return xMLEntityManager$Entity != null;
    }

    @Override
    public XMLInputSource resolveEntity(XMLResourceIdentifier xMLResourceIdentifier) {
        boolean bl;
        if (xMLResourceIdentifier == null) {
            return null;
        }
        String string = xMLResourceIdentifier.getPublicId();
        String string2 = xMLResourceIdentifier.getLiteralSystemId();
        String string3 = xMLResourceIdentifier.getBaseSystemId();
        String string4 = xMLResourceIdentifier.getExpandedSystemId();
        boolean bl2 = bl = string4 == null;
        if (string3 == null && this.fCurrentEntity != null && this.fCurrentEntity.entityLocation != null && (string3 = this.fCurrentEntity.entityLocation.getExpandedSystemId()) != null) {
            bl = true;
        }
        if (bl) {
            string4 = XMLEntityManager.expandSystemId(string2, string3, false);
        }
        XMLInputSource xMLInputSource = null;
        if (this.fEntityResolver != null) {
            xMLResourceIdentifier.setBaseSystemId(string3);
            xMLResourceIdentifier.setExpandedSystemId(string4);
            xMLInputSource = this.fEntityResolver.resolveEntity(xMLResourceIdentifier);
        }
        if (xMLInputSource == null) {
            xMLInputSource = new XMLInputSource(string, string2, string3);
        }
        return xMLInputSource;
    }

    public void startEntity(String string, boolean bl) {
        int n;
        int n2;
        XMLEntityManager$Entity xMLEntityManager$Entity = (XMLEntityManager$Entity)this.fEntities.get(string);
        if (xMLEntityManager$Entity == null) {
            if (this.fEntityHandler != null) {
                String string2 = null;
                this.fResourceIdentifier.clear();
                this.fEntityAugs.removeAllItems();
                this.fEntityAugs.putItem("ENTITY_SKIPPED", Boolean.TRUE);
                this.fEntityHandler.startEntity(string, this.fResourceIdentifier, string2, this.fEntityAugs);
                this.fEntityAugs.removeAllItems();
                this.fEntityAugs.putItem("ENTITY_SKIPPED", Boolean.TRUE);
                this.fEntityHandler.endEntity(string, this.fEntityAugs);
            }
            return;
        }
        boolean bl2 = xMLEntityManager$Entity.isExternal();
        if (bl2 && (this.fValidationManager == null || !this.fValidationManager.isCachedDTD())) {
            boolean bl3;
            n2 = xMLEntityManager$Entity.isUnparsed() ? 1 : 0;
            n = string.startsWith("%") ? 1 : 0;
            boolean bl4 = bl3 = n == 0;
            if (n2 != 0 || bl3 && !this.fExternalGeneralEntities || n != 0 && !this.fExternalParameterEntities) {
                if (this.fEntityHandler != null) {
                    this.fResourceIdentifier.clear();
                    String string3 = null;
                    XMLEntityManager$ExternalEntity xMLEntityManager$ExternalEntity = (XMLEntityManager$ExternalEntity)xMLEntityManager$Entity;
                    String string4 = xMLEntityManager$ExternalEntity.entityLocation != null ? xMLEntityManager$ExternalEntity.entityLocation.getLiteralSystemId() : null;
                    String string5 = xMLEntityManager$ExternalEntity.entityLocation != null ? xMLEntityManager$ExternalEntity.entityLocation.getBaseSystemId() : null;
                    String string6 = XMLEntityManager.expandSystemId(string4, string5, false);
                    this.fResourceIdentifier.setValues(xMLEntityManager$ExternalEntity.entityLocation != null ? xMLEntityManager$ExternalEntity.entityLocation.getPublicId() : null, string4, string5, string6);
                    this.fEntityAugs.removeAllItems();
                    this.fEntityAugs.putItem("ENTITY_SKIPPED", Boolean.TRUE);
                    this.fEntityHandler.startEntity(string, this.fResourceIdentifier, string3, this.fEntityAugs);
                    this.fEntityAugs.removeAllItems();
                    this.fEntityAugs.putItem("ENTITY_SKIPPED", Boolean.TRUE);
                    this.fEntityHandler.endEntity(string, this.fEntityAugs);
                }
                return;
            }
        }
        for (n = n2 = this.fEntityStack.size(); n >= 0; --n) {
            XMLEntityManager$Entity xMLEntityManager$Entity2;
            XMLEntityManager$Entity xMLEntityManager$Entity3 = xMLEntityManager$Entity2 = n == n2 ? this.fCurrentEntity : (XMLEntityManager$Entity)this.fEntityStack.elementAt(n);
            if (xMLEntityManager$Entity2.name != string) continue;
            StringBuffer stringBuffer = new StringBuffer(string);
            for (int i2 = n + 1; i2 < n2; ++i2) {
                xMLEntityManager$Entity2 = (XMLEntityManager$Entity)this.fEntityStack.elementAt(i2);
                stringBuffer.append(" -> ");
                stringBuffer.append(xMLEntityManager$Entity2.name);
            }
            stringBuffer.append(" -> ");
            stringBuffer.append(this.fCurrentEntity.name);
            stringBuffer.append(" -> ");
            stringBuffer.append(string);
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "RecursiveReference", new Object[]{string, stringBuffer.toString()}, (short)2);
            if (this.fEntityHandler != null) {
                this.fResourceIdentifier.clear();
                String string7 = null;
                if (bl2) {
                    XMLEntityManager$ExternalEntity xMLEntityManager$ExternalEntity = (XMLEntityManager$ExternalEntity)xMLEntityManager$Entity;
                    String string8 = xMLEntityManager$ExternalEntity.entityLocation != null ? xMLEntityManager$ExternalEntity.entityLocation.getLiteralSystemId() : null;
                    String string9 = xMLEntityManager$ExternalEntity.entityLocation != null ? xMLEntityManager$ExternalEntity.entityLocation.getBaseSystemId() : null;
                    String string10 = XMLEntityManager.expandSystemId(string8, string9, false);
                    this.fResourceIdentifier.setValues(xMLEntityManager$ExternalEntity.entityLocation != null ? xMLEntityManager$ExternalEntity.entityLocation.getPublicId() : null, string8, string9, string10);
                }
                this.fEntityAugs.removeAllItems();
                this.fEntityAugs.putItem("ENTITY_SKIPPED", Boolean.TRUE);
                this.fEntityHandler.startEntity(string, this.fResourceIdentifier, string7, this.fEntityAugs);
                this.fEntityAugs.removeAllItems();
                this.fEntityAugs.putItem("ENTITY_SKIPPED", Boolean.TRUE);
                this.fEntityHandler.endEntity(string, this.fEntityAugs);
            }
            return;
        }
        XMLInputSource xMLInputSource = null;
        if (bl2) {
            XMLEntityManager$ExternalEntity xMLEntityManager$ExternalEntity = (XMLEntityManager$ExternalEntity)xMLEntityManager$Entity;
            xMLInputSource = this.resolveEntity(xMLEntityManager$ExternalEntity.entityLocation);
        } else {
            XMLEntityManager$InternalEntity xMLEntityManager$InternalEntity = (XMLEntityManager$InternalEntity)xMLEntityManager$Entity;
            StringReader stringReader = new StringReader(xMLEntityManager$InternalEntity.text);
            xMLInputSource = new XMLInputSource(null, null, null, stringReader, null);
        }
        if (xMLInputSource != null) {
            this.startEntity(string, xMLInputSource, bl, bl2);
        }
    }

    public void startDocumentEntity(XMLInputSource xMLInputSource) {
        this.startEntity(XMLEntity, xMLInputSource, false, true);
    }

    public void startDTDEntity(XMLInputSource xMLInputSource) {
        this.startEntity(DTDEntity, xMLInputSource, false, true);
    }

    public void startExternalSubset() {
        this.fInExternalSubset = true;
    }

    public void endExternalSubset() {
        this.fInExternalSubset = false;
    }

    public void startEntity(String string, XMLInputSource xMLInputSource, boolean bl, boolean bl2) {
        String string2 = this.setupCurrentEntity(string, xMLInputSource, bl, bl2);
        if (this.fSecurityManager != null && this.fEntityExpansionCount++ > this.fEntityExpansionLimit) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EntityExpansionLimitExceeded", new Object[]{new Integer(this.fEntityExpansionLimit)}, (short)2);
            this.fEntityExpansionCount = 0;
        }
        if (this.fEntityHandler != null) {
            this.fEntityHandler.startEntity(string, this.fResourceIdentifier, string2, null);
        }
    }

    public String setupCurrentEntity(String string, XMLInputSource xMLInputSource, boolean bl, boolean bl2) {
        String string2 = xMLInputSource.getPublicId();
        Object object = xMLInputSource.getSystemId();
        String string3 = xMLInputSource.getBaseSystemId();
        String string4 = xMLInputSource.getEncoding();
        boolean bl3 = string4 != null;
        Boolean bl4 = null;
        this.fTempByteBuffer = null;
        InputStream inputStream = null;
        Reader reader = xMLInputSource.getCharacterStream();
        Object object2 = XMLEntityManager.expandSystemId((String)object, string3, this.fStrictURI);
        if (string3 == null) {
            string3 = object2;
        }
        if (reader == null) {
            Object object3;
            inputStream = xMLInputSource.getByteStream();
            if (inputStream == null) {
                object3 = new URL((String)object2);
                URLConnection uRLConnection = ((URL)object3).openConnection();
                if (!(uRLConnection instanceof HttpURLConnection)) {
                    inputStream = uRLConnection.getInputStream();
                } else {
                    Object object4;
                    boolean bl5 = true;
                    if (xMLInputSource instanceof HTTPInputSource) {
                        object4 = (HttpURLConnection)uRLConnection;
                        HTTPInputSource hTTPInputSource = (HTTPInputSource)xMLInputSource;
                        Iterator iterator = hTTPInputSource.getHTTPRequestProperties();
                        while (iterator.hasNext()) {
                            Map$Entry map$Entry = (Map$Entry)iterator.next();
                            ((URLConnection)object4).setRequestProperty((String)map$Entry.getKey(), (String)map$Entry.getValue());
                        }
                        bl5 = hTTPInputSource.getFollowHTTPRedirects();
                        if (!bl5) {
                            XMLEntityManager.setInstanceFollowRedirects((HttpURLConnection)object4, bl5);
                        }
                    }
                    inputStream = uRLConnection.getInputStream();
                    if (bl5 && !((String)(object4 = uRLConnection.getURL().toString())).equals(object2)) {
                        object = object4;
                        object2 = object4;
                    }
                }
            }
            inputStream = new XMLEntityManager$RewindableInputStream(this, inputStream);
            if (string4 == null) {
                int n;
                object3 = new byte[4];
                for (n = 0; n < 4; ++n) {
                    object3[n] = (byte)inputStream.read();
                }
                if (n == 4) {
                    Object[] objectArray = this.getEncodingName((byte[])object3, n);
                    string4 = (String)objectArray[0];
                    bl4 = (Boolean)objectArray[1];
                    inputStream.reset();
                    if (n > 2 && string4.equals("UTF-8")) {
                        int n2 = object3[0] & 0xFF;
                        int n3 = object3[1] & 0xFF;
                        int n4 = object3[2] & 0xFF;
                        if (n2 == 239 && n3 == 187 && n4 == 191) {
                            inputStream.skip(0);
                        }
                    }
                    reader = this.createReader(inputStream, string4, bl4);
                } else {
                    reader = this.createReader(inputStream, string4, bl4);
                }
            } else if ((string4 = string4.toUpperCase(Locale.ENGLISH)).equals("UTF-8")) {
                int n;
                object3 = new int[3];
                for (n = 0; n < 3; ++n) {
                    object3[n] = inputStream.read();
                    if (object3[n] == -1) break;
                }
                if (n == 3) {
                    if (object3[0] != 239 || object3[1] != 187 || object3[2] != 191) {
                        inputStream.reset();
                    }
                } else {
                    inputStream.reset();
                }
                reader = this.createReader(inputStream, string4, bl4);
            } else if (string4.equals("UTF-16")) {
                int n;
                object3 = new int[4];
                for (n = 0; n < 4; ++n) {
                    object3[n] = inputStream.read();
                    if (object3[n] == -1) break;
                }
                inputStream.reset();
                String string5 = "UTF-16";
                if (n >= 2) {
                    Object object5 = object3[0];
                    Object object6 = object3[1];
                    if (object5 == 254 && object6 == 255) {
                        string5 = "UTF-16BE";
                        bl4 = Boolean.TRUE;
                    } else if (object5 == 255 && object6 == 254) {
                        string5 = "UTF-16LE";
                        bl4 = Boolean.FALSE;
                    } else if (n == 4) {
                        Object object7 = object3[2];
                        Object object8 = object3[3];
                        if (object5 == false && object6 == 60 && object7 == false && object8 == 63) {
                            string5 = "UTF-16BE";
                            bl4 = Boolean.TRUE;
                        }
                        if (object5 == 60 && object6 == false && object7 == 63 && object8 == false) {
                            string5 = "UTF-16LE";
                            bl4 = Boolean.FALSE;
                        }
                    }
                }
                reader = this.createReader(inputStream, string5, bl4);
            } else if (string4.equals("ISO-10646-UCS-4")) {
                int n;
                object3 = new int[4];
                for (n = 0; n < 4; ++n) {
                    object3[n] = inputStream.read();
                    if (object3[n] == -1) break;
                }
                inputStream.reset();
                if (n == 4) {
                    if (object3[0] == false && object3[1] == false && object3[2] == false && object3[3] == 60) {
                        bl4 = Boolean.TRUE;
                    } else if (object3[0] == 60 && object3[1] == false && object3[2] == false && object3[3] == false) {
                        bl4 = Boolean.FALSE;
                    }
                }
                reader = this.createReader(inputStream, string4, bl4);
            } else if (string4.equals("ISO-10646-UCS-2")) {
                int n;
                object3 = new int[4];
                for (n = 0; n < 4; ++n) {
                    object3[n] = inputStream.read();
                    if (object3[n] == -1) break;
                }
                inputStream.reset();
                if (n == 4) {
                    if (object3[0] == false && object3[1] == 60 && object3[2] == false && object3[3] == 63) {
                        bl4 = Boolean.TRUE;
                    } else if (object3[0] == 60 && object3[1] == false && object3[2] == 63 && object3[3] == false) {
                        bl4 = Boolean.FALSE;
                    }
                }
                reader = this.createReader(inputStream, string4, bl4);
            } else {
                reader = this.createReader(inputStream, string4, bl4);
            }
        }
        this.fReaderStack.push(reader);
        if (this.fCurrentEntity != null) {
            this.fEntityStack.push(this.fCurrentEntity);
        }
        this.fCurrentEntity = new XMLEntityManager$ScannedEntity(this, string, new XMLResourceIdentifierImpl(string2, (String)object, string3, (String)object2), inputStream, reader, this.fTempByteBuffer, string4, bl, false, bl2);
        this.fCurrentEntity.setEncodingExternallySpecified(bl3);
        this.fEntityScanner.setCurrentEntity(this.fCurrentEntity);
        this.fResourceIdentifier.setValues(string2, (String)object, string3, (String)object2);
        return string4;
    }

    public void setScannerVersion(short s) {
        if (s == 1) {
            if (this.fXML10EntityScanner == null) {
                this.fXML10EntityScanner = new XMLEntityScanner();
            }
            this.fXML10EntityScanner.reset(this.fSymbolTable, this, this.fErrorReporter);
            this.fEntityScanner = this.fXML10EntityScanner;
            this.fEntityScanner.setCurrentEntity(this.fCurrentEntity);
        } else {
            if (this.fXML11EntityScanner == null) {
                this.fXML11EntityScanner = new XML11EntityScanner();
            }
            this.fXML11EntityScanner.reset(this.fSymbolTable, this, this.fErrorReporter);
            this.fEntityScanner = this.fXML11EntityScanner;
            this.fEntityScanner.setCurrentEntity(this.fCurrentEntity);
        }
    }

    public XMLEntityScanner getEntityScanner() {
        if (this.fEntityScanner == null) {
            if (this.fXML10EntityScanner == null) {
                this.fXML10EntityScanner = new XMLEntityScanner();
            }
            this.fXML10EntityScanner.reset(this.fSymbolTable, this, this.fErrorReporter);
            this.fEntityScanner = this.fXML10EntityScanner;
        }
        return this.fEntityScanner;
    }

    public void closeReaders() {
        for (int i2 = this.fReaderStack.size() - 1; i2 >= 0; --i2) {
            try {
                ((Reader)this.fReaderStack.pop()).close();
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    @Override
    public void reset(XMLComponentManager xMLComponentManager) {
        boolean bl;
        try {
            bl = xMLComponentManager.getFeature("http://apache.org/xml/features/internal/parser-settings");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            bl = true;
        }
        if (!bl) {
            this.reset();
            return;
        }
        try {
            this.fValidation = xMLComponentManager.getFeature("http://xml.org/sax/features/validation");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fValidation = false;
        }
        try {
            this.fExternalGeneralEntities = xMLComponentManager.getFeature("http://xml.org/sax/features/external-general-entities");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fExternalGeneralEntities = true;
        }
        try {
            this.fExternalParameterEntities = xMLComponentManager.getFeature("http://xml.org/sax/features/external-parameter-entities");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fExternalParameterEntities = true;
        }
        try {
            this.fAllowJavaEncodings = xMLComponentManager.getFeature("http://apache.org/xml/features/allow-java-encodings");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fAllowJavaEncodings = false;
        }
        try {
            this.fWarnDuplicateEntityDef = xMLComponentManager.getFeature("http://apache.org/xml/features/warn-on-duplicate-entitydef");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fWarnDuplicateEntityDef = false;
        }
        try {
            this.fStrictURI = xMLComponentManager.getFeature("http://apache.org/xml/features/standard-uri-conformant");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fStrictURI = false;
        }
        this.fSymbolTable = (SymbolTable)xMLComponentManager.getProperty("http://apache.org/xml/properties/internal/symbol-table");
        this.fErrorReporter = (XMLErrorReporter)xMLComponentManager.getProperty("http://apache.org/xml/properties/internal/error-reporter");
        try {
            this.fEntityResolver = (XMLEntityResolver)xMLComponentManager.getProperty("http://apache.org/xml/properties/internal/entity-resolver");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fEntityResolver = null;
        }
        try {
            this.fValidationManager = (ValidationManager)xMLComponentManager.getProperty("http://apache.org/xml/properties/internal/validation-manager");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fValidationManager = null;
        }
        try {
            this.fSecurityManager = (SecurityManager)xMLComponentManager.getProperty("http://apache.org/xml/properties/security-manager");
        }
        catch (XMLConfigurationException xMLConfigurationException) {
            this.fSecurityManager = null;
        }
        this.reset();
    }

    public void reset() {
        this.fEntityExpansionLimit = this.fSecurityManager != null ? this.fSecurityManager.getEntityExpansionLimit() : 0;
        this.fStandalone = false;
        this.fEntities.clear();
        this.fEntityStack.removeAllElements();
        this.fEntityExpansionCount = 0;
        this.fCurrentEntity = null;
        if (this.fXML10EntityScanner != null) {
            this.fXML10EntityScanner.reset(this.fSymbolTable, this, this.fErrorReporter);
        }
        if (this.fXML11EntityScanner != null) {
            this.fXML11EntityScanner.reset(this.fSymbolTable, this, this.fErrorReporter);
        }
        if (this.fDeclaredEntities != null) {
            Enumeration enumeration = this.fDeclaredEntities.keys();
            while (enumeration.hasMoreElements()) {
                Object object = enumeration.nextElement();
                Object object2 = this.fDeclaredEntities.get(object);
                this.fEntities.put(object, object2);
            }
        }
        this.fEntityHandler = null;
    }

    @Override
    public String[] getRecognizedFeatures() {
        return (String[])RECOGNIZED_FEATURES.clone();
    }

    @Override
    public void setFeature(String string, boolean bl) {
        int n;
        if (string.startsWith("http://apache.org/xml/features/") && (n = string.length() - "http://apache.org/xml/features/".length()) == "allow-java-encodings".length() && string.endsWith("allow-java-encodings")) {
            this.fAllowJavaEncodings = bl;
        }
    }

    @Override
    public String[] getRecognizedProperties() {
        return (String[])RECOGNIZED_PROPERTIES.clone();
    }

    @Override
    public void setProperty(String string, Object object) {
        if (string.startsWith("http://apache.org/xml/properties/")) {
            Integer n;
            int n2 = string.length() - "http://apache.org/xml/properties/".length();
            if (n2 == "internal/symbol-table".length() && string.endsWith("internal/symbol-table")) {
                this.fSymbolTable = (SymbolTable)object;
                return;
            }
            if (n2 == "internal/error-reporter".length() && string.endsWith("internal/error-reporter")) {
                this.fErrorReporter = (XMLErrorReporter)object;
                return;
            }
            if (n2 == "internal/entity-resolver".length() && string.endsWith("internal/entity-resolver")) {
                this.fEntityResolver = (XMLEntityResolver)object;
                return;
            }
            if (n2 == "input-buffer-size".length() && string.endsWith("input-buffer-size") && (n = (Integer)object) != null && n > 64) {
                this.fBufferSize = n;
                this.fEntityScanner.setBufferSize(this.fBufferSize);
                this.fByteBufferPool.setBufferSize(this.fBufferSize);
                this.fCharacterBufferPool.setExternalBufferSize(this.fBufferSize);
            }
            if (n2 == "security-manager".length() && string.endsWith("security-manager")) {
                this.fSecurityManager = (SecurityManager)object;
                this.fEntityExpansionLimit = this.fSecurityManager != null ? this.fSecurityManager.getEntityExpansionLimit() : 0;
            }
        }
    }

    @Override
    public Boolean getFeatureDefault(String string) {
        for (int i2 = 0; i2 < RECOGNIZED_FEATURES.length; ++i2) {
            if (!RECOGNIZED_FEATURES[i2].equals(string)) continue;
            return FEATURE_DEFAULTS[i2];
        }
        return null;
    }

    @Override
    public Object getPropertyDefault(String string) {
        for (int i2 = 0; i2 < RECOGNIZED_PROPERTIES.length; ++i2) {
            if (!RECOGNIZED_PROPERTIES[i2].equals(string)) continue;
            return PROPERTY_DEFAULTS[i2];
        }
        return null;
    }

    private static synchronized URI getUserDir() {
        int n;
        int n2;
        String string = "";
        try {
            string = (String)AccessController.doPrivileged(GET_USER_DIR_SYSTEM_PROPERTY);
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        if (string.length() == 0) {
            return new URI("file", "", "", null, null);
        }
        if (gUserDirURI != null && string.equals(gUserDir)) {
            return gUserDirURI;
        }
        gUserDir = string;
        char c2 = File.separatorChar;
        string = string.replace(c2, '/');
        int n3 = string.length();
        StringBuffer stringBuffer = new StringBuffer(n3 * 3);
        if (n3 >= 2 && string.charAt(1) == ':' && (n2 = Character.toUpperCase(string.charAt(0))) >= 65 && n2 <= 90) {
            stringBuffer.append('/');
        }
        for (n = 0; n < n3 && (n2 = string.charAt(n)) < 128; ++n) {
            if (gNeedEscaping[n2]) {
                stringBuffer.append('%');
                stringBuffer.append(gAfterEscaping1[n2]);
                stringBuffer.append(gAfterEscaping2[n2]);
                continue;
            }
            stringBuffer.append((char)n2);
        }
        if (n < n3) {
            byte[] byArray = null;
            try {
                byArray = string.substring(n).getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                return new URI("file", "", string, null, null);
            }
            for (byte by : byArray) {
                if (by < 0) {
                    n2 = by + 256;
                    stringBuffer.append('%');
                    stringBuffer.append(gHexChs[n2 >> 4]);
                    stringBuffer.append(gHexChs[n2 & 0xF]);
                    continue;
                }
                if (gNeedEscaping[by]) {
                    stringBuffer.append('%');
                    stringBuffer.append(gAfterEscaping1[by]);
                    stringBuffer.append(gAfterEscaping2[by]);
                    continue;
                }
                stringBuffer.append((char)by);
            }
        }
        if (!string.endsWith("/")) {
            stringBuffer.append('/');
        }
        gUserDirURI = new URI("file", "", stringBuffer.toString(), null, null);
        return gUserDirURI;
    }

    public static void absolutizeAgainstUserDir(URI uRI) {
        uRI.absolutize(XMLEntityManager.getUserDir());
    }

    public static String expandSystemId(String string, String string2, boolean bl) {
        if (string == null) {
            return null;
        }
        if (bl) {
            return XMLEntityManager.expandSystemIdStrictOn(string, string2);
        }
        try {
            return XMLEntityManager.expandSystemIdStrictOff(string, string2);
        }
        catch (URI$MalformedURIException uRI$MalformedURIException) {
            if (string.length() == 0) {
                return string;
            }
            String string3 = XMLEntityManager.fixURI(string);
            URI uRI = null;
            URI uRI2 = null;
            try {
                if (string2 == null || string2.length() == 0 || string2.equals(string)) {
                    uRI = XMLEntityManager.getUserDir();
                } else {
                    try {
                        uRI = new URI(XMLEntityManager.fixURI(string2).trim());
                    }
                    catch (URI$MalformedURIException uRI$MalformedURIException2) {
                        uRI = string2.indexOf(58) != -1 ? new URI("file", "", XMLEntityManager.fixURI(string2).trim(), null, null) : new URI(XMLEntityManager.getUserDir(), XMLEntityManager.fixURI(string2));
                    }
                }
                uRI2 = new URI(uRI, string3.trim());
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (uRI2 == null) {
                return string;
            }
            return uRI2.toString();
        }
    }

    private static String expandSystemIdStrictOn(String string, String string2) {
        URI uRI = new URI(string, true);
        if (uRI.isAbsoluteURI()) {
            return string;
        }
        URI uRI2 = null;
        if (string2 == null || string2.length() == 0) {
            uRI2 = XMLEntityManager.getUserDir();
        } else {
            uRI2 = new URI(string2, true);
            if (!uRI2.isAbsoluteURI()) {
                uRI2.absolutize(XMLEntityManager.getUserDir());
            }
        }
        uRI.absolutize(uRI2);
        return uRI.toString();
    }

    private static String expandSystemIdStrictOff(String string, String string2) {
        URI uRI = new URI(string, true);
        if (uRI.isAbsoluteURI()) {
            if (uRI.getScheme().length() > 1) {
                return string;
            }
            throw new URI$MalformedURIException();
        }
        URI uRI2 = null;
        if (string2 == null || string2.length() == 0) {
            uRI2 = XMLEntityManager.getUserDir();
        } else {
            uRI2 = new URI(string2, true);
            if (!uRI2.isAbsoluteURI()) {
                uRI2.absolutize(XMLEntityManager.getUserDir());
            }
        }
        uRI.absolutize(uRI2);
        return uRI.toString();
    }

    public static void setInstanceFollowRedirects(HttpURLConnection httpURLConnection, boolean bl) {
        try {
            Method method = (class$java$net$HttpURLConnection == null ? (class$java$net$HttpURLConnection = XMLEntityManager.class$("java.net.HttpURLConnection")) : class$java$net$HttpURLConnection).getMethod("setInstanceFollowRedirects", new Class[]{Boolean.TYPE});
            method.invoke(httpURLConnection, new Object[]{bl ? Boolean.TRUE : Boolean.FALSE});
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    void endEntity() {
        if (this.fEntityHandler != null) {
            this.fEntityHandler.endEntity(this.fCurrentEntity.name, null);
        }
        try {
            this.fCurrentEntity.reader.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        if (!this.fReaderStack.isEmpty()) {
            this.fReaderStack.pop();
        }
        this.fCharacterBufferPool.returnBuffer(XMLEntityManager$ScannedEntity.access$000(this.fCurrentEntity));
        if (XMLEntityManager$ScannedEntity.access$100(this.fCurrentEntity) != null) {
            this.fByteBufferPool.returnBuffer(XMLEntityManager$ScannedEntity.access$100(this.fCurrentEntity));
        }
        this.fCurrentEntity = this.fEntityStack.size() > 0 ? (XMLEntityManager$ScannedEntity)this.fEntityStack.pop() : null;
        this.fEntityScanner.setCurrentEntity(this.fCurrentEntity);
    }

    protected Object[] getEncodingName(byte[] byArray, int n) {
        if (n < 2) {
            return new Object[]{"UTF-8", null};
        }
        int n2 = byArray[0] & 0xFF;
        int n3 = byArray[1] & 0xFF;
        if (n2 == 254 && n3 == 255) {
            return new Object[]{"UTF-16BE", Boolean.TRUE};
        }
        if (n2 == 255 && n3 == 254) {
            return new Object[]{"UTF-16LE", Boolean.FALSE};
        }
        if (n < 3) {
            return new Object[]{"UTF-8", null};
        }
        int n4 = byArray[2] & 0xFF;
        if (n2 == 239 && n3 == 187 && n4 == 191) {
            return new Object[]{"UTF-8", null};
        }
        if (n < 4) {
            return new Object[]{"UTF-8", null};
        }
        int n5 = byArray[3] & 0xFF;
        if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 60) {
            return new Object[]{"ISO-10646-UCS-4", Boolean.TRUE};
        }
        if (n2 == 60 && n3 == 0 && n4 == 0 && n5 == 0) {
            return new Object[]{"ISO-10646-UCS-4", Boolean.FALSE};
        }
        if (n2 == 0 && n3 == 0 && n4 == 60 && n5 == 0) {
            return new Object[]{"ISO-10646-UCS-4", null};
        }
        if (n2 == 0 && n3 == 60 && n4 == 0 && n5 == 0) {
            return new Object[]{"ISO-10646-UCS-4", null};
        }
        if (n2 == 0 && n3 == 60 && n4 == 0 && n5 == 63) {
            return new Object[]{"UTF-16BE", Boolean.TRUE};
        }
        if (n2 == 60 && n3 == 0 && n4 == 63 && n5 == 0) {
            return new Object[]{"UTF-16LE", Boolean.FALSE};
        }
        if (n2 == 76 && n3 == 111 && n4 == 167 && n5 == 148) {
            return new Object[]{"CP037", null};
        }
        return new Object[]{"UTF-8", null};
    }

    /*
     * Enabled aggressive block sorting
     */
    protected Reader createReader(InputStream inputStream, String string, Boolean bl) {
        if (string == "UTF-8" || string == null) {
            if (this.fTempByteBuffer != null) return new UTF8Reader(inputStream, this.fTempByteBuffer, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
            this.fTempByteBuffer = this.fByteBufferPool.getBuffer();
            return new UTF8Reader(inputStream, this.fTempByteBuffer, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
        }
        String string2 = string.toUpperCase(Locale.ENGLISH);
        if (string2.equals("UTF-8")) {
            if (this.fTempByteBuffer != null) return new UTF8Reader(inputStream, this.fTempByteBuffer, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
            this.fTempByteBuffer = this.fByteBufferPool.getBuffer();
            return new UTF8Reader(inputStream, this.fTempByteBuffer, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
        }
        if (string2.equals("ISO-10646-UCS-4")) {
            if (bl != null) {
                boolean bl2 = bl;
                if (!bl2) return new UCSReader(inputStream, 4);
                return new UCSReader(inputStream, 8);
            }
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingByteOrderUnsupported", new Object[]{string}, (short)2);
        }
        if (string2.equals("ISO-10646-UCS-2")) {
            if (bl != null) {
                boolean bl3 = bl;
                if (!bl3) return new UCSReader(inputStream, 1);
                return new UCSReader(inputStream, 2);
            }
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingByteOrderUnsupported", new Object[]{string}, (short)2);
        }
        boolean bl4 = XMLChar.isValidIANAEncoding(string);
        boolean bl5 = XMLChar.isValidJavaEncoding(string);
        if (!bl4 || this.fAllowJavaEncodings && !bl5) {
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingDeclInvalid", new Object[]{string}, (short)2);
            return new Latin1Reader(inputStream, this.fBufferSize);
        }
        String string3 = EncodingMap.getIANA2JavaMapping(string2);
        if (string3 == null) {
            if (this.fAllowJavaEncodings) {
                string3 = string;
                return new InputStreamReader(inputStream, string3);
            }
            this.fErrorReporter.reportError("http://www.w3.org/TR/1998/REC-xml-19980210", "EncodingDeclInvalid", new Object[]{string}, (short)2);
            if (this.fTempByteBuffer != null) return new Latin1Reader(inputStream, this.fTempByteBuffer);
            this.fTempByteBuffer = this.fByteBufferPool.getBuffer();
            return new Latin1Reader(inputStream, this.fTempByteBuffer);
        }
        if (string3.equals("ASCII")) {
            if (this.fTempByteBuffer != null) return new ASCIIReader(inputStream, this.fTempByteBuffer, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
            this.fTempByteBuffer = this.fByteBufferPool.getBuffer();
            return new ASCIIReader(inputStream, this.fTempByteBuffer, this.fErrorReporter.getMessageFormatter("http://www.w3.org/TR/1998/REC-xml-19980210"), this.fErrorReporter.getLocale());
        }
        if (!string3.equals("ISO8859_1")) return new InputStreamReader(inputStream, string3);
        if (this.fTempByteBuffer != null) return new Latin1Reader(inputStream, this.fTempByteBuffer);
        this.fTempByteBuffer = this.fByteBufferPool.getBuffer();
        return new Latin1Reader(inputStream, this.fTempByteBuffer);
    }

    protected static String fixURI(String string) {
        int n;
        int n2;
        string = string.replace(File.separatorChar, '/');
        StringBuffer stringBuffer = null;
        if (string.length() >= 2) {
            n2 = string.charAt(1);
            if (n2 == 58) {
                n = Character.toUpperCase(string.charAt(0));
                if (n >= 65 && n <= 90) {
                    stringBuffer = new StringBuffer(string.length() + 8);
                    stringBuffer.append("file:///");
                }
            } else if (n2 == 47 && string.charAt(0) == '/') {
                stringBuffer = new StringBuffer(string.length() + 5);
                stringBuffer.append("file:");
            }
        }
        if ((n2 = string.indexOf(32)) < 0) {
            if (stringBuffer != null) {
                stringBuffer.append(string);
                string = stringBuffer.toString();
            }
        } else {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer(string.length());
            }
            for (n = 0; n < n2; ++n) {
                stringBuffer.append(string.charAt(n));
            }
            stringBuffer.append("%20");
            for (n = n2 + 1; n < string.length(); ++n) {
                if (string.charAt(n) == ' ') {
                    stringBuffer.append("%20");
                    continue;
                }
                stringBuffer.append(string.charAt(n));
            }
            string = stringBuffer.toString();
        }
        return string;
    }

    Hashtable getDeclaredEntities() {
        return this.fEntities;
    }

    static final void print(XMLEntityManager$ScannedEntity xMLEntityManager$ScannedEntity) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ XMLEntityManager$CharacterBufferPool access$200(XMLEntityManager xMLEntityManager) {
        return xMLEntityManager.fCharacterBufferPool;
    }

    static /* synthetic */ byte[] access$402(XMLEntityManager xMLEntityManager, byte[] byArray) {
        xMLEntityManager.fTempByteBuffer = byArray;
        return byArray;
    }

    static /* synthetic */ byte[] access$400(XMLEntityManager xMLEntityManager) {
        return xMLEntityManager.fTempByteBuffer;
    }

    static {
        RECOGNIZED_FEATURES = new String[]{"http://xml.org/sax/features/validation", "http://xml.org/sax/features/external-general-entities", "http://xml.org/sax/features/external-parameter-entities", "http://apache.org/xml/features/allow-java-encodings", "http://apache.org/xml/features/warn-on-duplicate-entitydef", "http://apache.org/xml/features/standard-uri-conformant"};
        FEATURE_DEFAULTS = new Boolean[]{null, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE};
        RECOGNIZED_PROPERTIES = new String[]{"http://apache.org/xml/properties/internal/symbol-table", "http://apache.org/xml/properties/internal/error-reporter", "http://apache.org/xml/properties/internal/entity-resolver", "http://apache.org/xml/properties/internal/validation-manager", "http://apache.org/xml/properties/input-buffer-size", "http://apache.org/xml/properties/security-manager"};
        PROPERTY_DEFAULTS = new Object[]{null, null, null, null, new Integer(2048), null};
        XMLEntity = "[xml]".intern();
        DTDEntity = "[dtd]".intern();
        gNeedEscaping = new boolean[128];
        gAfterEscaping1 = new char[128];
        gAfterEscaping2 = new char[128];
        gHexChs = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i2 = 0; i2 <= 31; ++i2) {
            XMLEntityManager.gNeedEscaping[i2] = true;
            XMLEntityManager.gAfterEscaping1[i2] = gHexChs[i2 >> 4];
            XMLEntityManager.gAfterEscaping2[i2] = gHexChs[i2 & 0xF];
        }
        XMLEntityManager.gNeedEscaping[127] = true;
        XMLEntityManager.gAfterEscaping1[127] = 55;
        XMLEntityManager.gAfterEscaping2[127] = 70;
        for (char c2 : new char[]{' ', '<', '>', '#', '%', '\"', '{', '}', '|', '\\', '^', '~', '[', ']', '`'}) {
            XMLEntityManager.gNeedEscaping[c2] = true;
            XMLEntityManager.gAfterEscaping1[c2] = gHexChs[c2 >> 4];
            XMLEntityManager.gAfterEscaping2[c2] = gHexChs[c2 & 0xF];
        }
        GET_USER_DIR_SYSTEM_PROPERTY = new XMLEntityManager$1();
    }
}

