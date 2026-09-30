/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.GeoPictureSerializer;
import de.esolutions.fw.comm.dsi.picturestore.impl.PictureAttributeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureStoreReplyProxy
implements PictureStoreReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.explorer.picturestore.PictureStore");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public PictureStoreReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a4508c38-8b16-4130-967f-f23cb2238fda", -1, "ca2869dd-3831-51b0-8093-231b81bca2c1", "asi.explorer.picturestore.PictureStore");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void beginImportResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }

    public void endImportResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)43, iSerializable);
    }

    public void importPictureFromSourceResult(final int n, final ResourceLocator resourceLocator, final ResourceLocator resourceLocator2, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator2);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)49, iSerializable);
    }

    public void importPictureWithSynchronizationIDResult(final int n, final ResourceLocator resourceLocator, final ResourceLocator resourceLocator2, final int n2, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator2);
                iSerializer.putEnum(n2);
                iSerializer.putInt64(l);
            }
        };
        this.proxy.remoteCallMethod((short)66, iSerializable);
    }

    public void getMaxSynchronizationIDResult(final int n, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt64(l);
            }
        };
        this.proxy.remoteCallMethod((short)64, iSerializable);
    }

    public void setSynchronizationIDResult(final int n, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt64(l);
            }
        };
        this.proxy.remoteCallMethod((short)72, iSerializable);
    }

    public void renameFolderResult(final int n, final String string, final String string2, final long l, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putInt64(l);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)70, iSerializable);
    }

    public void countPicturesInContextResult(final int n, final int n2, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void increaseRefCounterResult(final ResourceLocator resourceLocator, final ResourceLocator resourceLocator2, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator2);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)50, iSerializable);
    }

    public void deletedPictures(final ResourceLocator[] resourceLocatorArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void deleteSynchronizedPictureResult(final int n, final long l, final long l2, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt64(l);
                iSerializer.putInt64(l2);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)68, iSerializable);
    }

    public void getPictureAttributesResult(final ResourceLocator resourceLocator, final PictureAttribute[] pictureAttributeArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
                PictureAttributeSerializer.putOptionalPictureAttributeVarArray(iSerializer, pictureAttributeArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)47, iSerializable);
    }

    public void listWithFilterResult(final ResourceLocator[] resourceLocatorArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void listForContextResult(final int n, final ResourceLocator[] resourceLocatorArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)51, iSerializable);
    }

    public void listForContextWithFilterResult(final int n, final ResourceLocator[] resourceLocatorArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void listForContextWithFilterSortDistResult(final int n, final ResourceLocator[] resourceLocatorArray, final int n2, final float f2, final float f3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                ResourceLocatorSerializer.putOptionalResourceLocatorVarArray(iSerializer, resourceLocatorArray);
                iSerializer.putInt32(n2);
                iSerializer.putFloat(f2);
                iSerializer.putFloat(f3);
            }
        };
        this.proxy.remoteCallMethod((short)73, iSerializable);
    }

    public void getRectanglePicturesGridResult(final GeoPicture[] geoPictureArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                GeoPictureSerializer.putOptionalGeoPictureVarArray(iSerializer, geoPictureArray);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void getAvailableYearsResult(final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void getAvailableMonthsResult(final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void createFilterSetResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void cloneFilterSetResult(final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void invalidData(final int[] nArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt32VarArray(nArray);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)75, iSerializable);
    }

    public void getAvailableFoldersResult(final int n, final String[] stringArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putOptionalStringVarArray(stringArray);
            }
        };
        this.proxy.remoteCallMethod((short)58, iSerializable);
    }
}

