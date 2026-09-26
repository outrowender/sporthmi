.version 50 0 
.class public super [37] 
.super [39] 
.field private [40] [41] 
.field private [42] [43] 

.method public annotation [45] : [46] 
    .attribute [44] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [6] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [47] : [48] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [7] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [49] : [50] 
    .attribute [44] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [8] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [51] : [52] 
    .attribute [44] .code stack 2 locals 2 
L0:     aconst_null 
L1:     astore_1 
L2:     aload_0 
L3:     getfield [4] 
L6:     ifnull L19 
L9:     aload_0 
L10:    getfield [4] 
L13:    astore_1 
L14:    aload_0 
L15:    aconst_null 
L16:    putfield [7] 
L19:    aconst_null 
L20:    astore_2 
L21:    aload_0 
L22:    getfield [5] 
L25:    ifnull L38 
L28:    aload_0 
L29:    getfield [5] 
L32:    astore_2 
L33:    aload_0 
L34:    aconst_null 
L35:    putfield [8] 
L38:    aload_1 
L39:    ifnull L44 
L42:    aload_1 
L43:    athrow 
L44:    aload_2 
L45:    ifnull L50 
L48:    aload_2 
L49:    athrow 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [9] 
.const [3] = Class [10] 
.const [4] = Field [11] [12] 
.const [5] = Field [13] [14] 
.const [6] = Method [15] [16] 
.const [7] = Field [17] [18] 
.const [8] = Field [19] [20] 
.const [9] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [10] = Utf8 java/lang/Object 
.const [11] = Class [21] 
.const [12] = NameAndType [22] [23] 
.const [13] = Class [24] 
.const [14] = NameAndType [25] [26] 
.const [15] = Class [27] 
.const [16] = NameAndType [28] [29] 
.const [17] = Class [30] 
.const [18] = NameAndType [31] [32] 
.const [19] = Class [33] 
.const [20] = NameAndType [34] [35] 
.const [21] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [22] = Utf8 ioException 
.const [23] = Utf8 Ljava/io/IOException; 
.const [24] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [25] = Utf8 transportException 
.const [26] = Utf8 Lde/esolutions/fw/util/transport/exception/TransportException; 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 <init> 
.const [29] = Utf8 ()V 
.const [30] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [31] = Utf8 ioException 
.const [32] = Utf8 Ljava/io/IOException; 
.const [33] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [34] = Utf8 transportException 
.const [35] = Utf8 Lde/esolutions/fw/util/transport/exception/TransportException; 
.const [36] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [37] = Class [36] 
.const [38] = Utf8 java/lang/Object 
.const [39] = Class [38] 
.const [40] = Utf8 ioException 
.const [41] = Utf8 Ljava/io/IOException; 
.const [42] = Utf8 transportException 
.const [43] = Utf8 Lde/esolutions/fw/util/transport/exception/TransportException; 
.const [44] = Utf8 Code 
.const [45] = Utf8 <init> 
.const [46] = Utf8 ()V 
.const [47] = Utf8 setIOException 
.const [48] = Utf8 (Ljava/io/IOException;)V 
.const [49] = Utf8 setTransportException 
.const [50] = Utf8 (Lde/esolutions/fw/util/transport/exception/TransportException;)V 
.const [51] = Utf8 throwPendingException 
.const [52] = Utf8 ()V 
.end class 
