/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmark;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkC;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkReply;
import de.esolutions.fw.comm.dsi.browser.impl.BookmarkSerializer;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkReplyService;
import de.esolutions.fw.comm.dsi.browser.impl.PathInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.PathInfo;

public class DSIBrowserBookmarkProxy
implements DSIBrowserBookmark,
DSIBrowserBookmarkC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.browser.DSIBrowserBookmark");
    private Proxy proxy;

    public DSIBrowserBookmarkProxy(int n, DSIBrowserBookmarkReply dSIBrowserBookmarkReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7b902419-3574-5aa6-8aaa-831e12ba2e89", n, "e25ea6e0-fb0e-57a2-908a-03c8634b8e94", "dsi.browser.DSIBrowserBookmark");
        DSIBrowserBookmarkReplyService dSIBrowserBookmarkReplyService = new DSIBrowserBookmarkReplyService(dSIBrowserBookmarkReply);
        this.proxy = new Proxy(serviceInstanceID, dSIBrowserBookmarkReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void listBookmarks(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void addBookmark(final Bookmark bookmark) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BookmarkSerializer.putOptionalBookmark(iSerializer, bookmark);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void editBookmark(final Bookmark bookmark, final Bookmark bookmark2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BookmarkSerializer.putOptionalBookmark(iSerializer, bookmark);
                BookmarkSerializer.putOptionalBookmark(iSerializer, bookmark2);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void deleteBookmark(final Bookmark bookmark) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BookmarkSerializer.putOptionalBookmark(iSerializer, bookmark);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void createFolder(final Bookmark bookmark) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BookmarkSerializer.putOptionalBookmark(iSerializer, bookmark);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void deleteFolder(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void renameFolder(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void exportBookmarks(final PathInfo pathInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PathInfoSerializer.putOptionalPathInfo(iSerializer, pathInfo);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void importBookmarks(final PathInfo pathInfo, final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PathInfoSerializer.putOptionalPathInfo(iSerializer, pathInfo);
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void getQuotaInformation() throws MethodException {
        this.proxy.remoteCallMethod((short)17, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)25, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }
}

