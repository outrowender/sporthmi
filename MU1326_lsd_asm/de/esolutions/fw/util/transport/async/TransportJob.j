.version 50 0 
.class public super abstract [105] 
.super [107] 
.field protected final [108] [109] 
.field protected final [110] [111] 
.field private [112] [113] 
.field private [114] [115] 

.method public [117] : [118] 
    .attribute [116] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [20] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [119] : [120] 
    .attribute [116] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [121] : [122] 
    .attribute [116] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected abstract [123] : [124] 
    .attribute [116] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [116] .code stack 2 locals 1 
        .catch [2] from L0 to L10 using L11 
        .catch [3] from L0 to L10 using L34 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     aload_0 
L5:     iconst_1 
L6:     invokespecial [16] 
L9:     iconst_1 
L10:    areturn 
L11:    astore_1 
L12:    aload_0 
L13:    getfield [8] 
L16:    ifnull L27 
L19:    aload_0 
L20:    getfield [8] 
L23:    aload_1 
L24:    invokevirtual [11] 
L27:    aload_0 
L28:    iconst_0 
L29:    invokespecial [16] 
L32:    iconst_0 
L33:    areturn 
L34:    astore_1 
L35:    aload_0 
L36:    getfield [8] 
L39:    ifnull L50 
L42:    aload_0 
L43:    getfield [8] 
L46:    aload_1 
L47:    invokevirtual [12] 
L50:    aload_0 
L51:    iconst_0 
L52:    invokespecial [16] 
L55:    iconst_0 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private synchronized [127] : [128] 
    .attribute [116] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [21] 
L5:     aload_0 
L6:     iload_1 
L7:     putfield [22] 
L10:    aload_0 
L11:    invokespecial [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public synchronized [129] : [130] 
    .attribute [116] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifne L18 
        .catch [4] from L7 to L11 using L14 
L7:     aload_0 
L8:     invokespecial [18] 
L11:    goto L0 
L14:    astore_1 
L15:    goto L0 
L18:    aload_0 
L19:    getfield [14] 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [23] 
.const [3] = Class [24] 
.const [4] = Class [25] 
.const [5] = Class [26] 
.const [6] = Class [27] 
.const [7] = Class [28] 
.const [8] = Field [29] [30] 
.const [9] = Field [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Method [35] [36] 
.const [12] = Method [37] [38] 
.const [13] = Field [39] [40] 
.const [14] = Field [41] [42] 
.const [15] = Method [43] [44] 
.const [16] = Method [45] [46] 
.const [17] = Method [47] [48] 
.const [18] = Method [49] [50] 
.const [19] = Field [51] [52] 
.const [20] = Field [53] [54] 
.const [21] = Field [55] [56] 
.const [22] = Field [57] [58] 
.const [23] = Utf8 java/io/IOException 
.const [24] = Utf8 de/esolutions/fw/util/transport/exception/TransportException 
.const [25] = Utf8 java/lang/InterruptedException 
.const [26] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [29] = Class [59] 
.const [30] = NameAndType [60] [61] 
.const [31] = Class [62] 
.const [32] = NameAndType [63] [64] 
.const [33] = Class [65] 
.const [34] = NameAndType [66] [67] 
.const [35] = Class [68] 
.const [36] = NameAndType [69] [70] 
.const [37] = Class [71] 
.const [38] = NameAndType [72] [73] 
.const [39] = Class [74] 
.const [40] = NameAndType [75] [76] 
.const [41] = Class [77] 
.const [42] = NameAndType [78] [79] 
.const [43] = Class [80] 
.const [44] = NameAndType [81] [82] 
.const [45] = Class [83] 
.const [46] = NameAndType [84] [85] 
.const [47] = Class [86] 
.const [48] = NameAndType [87] [88] 
.const [49] = Class [89] 
.const [50] = NameAndType [90] [91] 
.const [51] = Class [92] 
.const [52] = NameAndType [93] [94] 
.const [53] = Class [95] 
.const [54] = NameAndType [96] [97] 
.const [55] = Class [98] 
.const [56] = NameAndType [99] [100] 
.const [57] = Class [101] 
.const [58] = NameAndType [102] [103] 
.const [59] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [60] = Utf8 context 
.const [61] = Utf8 Lde/esolutions/fw/util/transport/async/ClientContext; 
.const [62] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [63] = Utf8 transport 
.const [64] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [65] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [66] = Utf8 doIO 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [69] = Utf8 setIOException 
.const [70] = Utf8 (Ljava/io/IOException;)V 
.const [71] = Utf8 de/esolutions/fw/util/transport/async/ClientContext 
.const [72] = Utf8 setTransportException 
.const [73] = Utf8 (Lde/esolutions/fw/util/transport/exception/TransportException;)V 
.const [74] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [75] = Utf8 isDone 
.const [76] = Utf8 Z 
.const [77] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [78] = Utf8 ok 
.const [79] = Utf8 Z 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [84] = Utf8 setDone 
.const [85] = Utf8 (Z)V 
.const [86] = Utf8 java/lang/Object 
.const [87] = Utf8 notifyAll 
.const [88] = Utf8 ()V 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 wait 
.const [91] = Utf8 ()V 
.const [92] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [93] = Utf8 context 
.const [94] = Utf8 Lde/esolutions/fw/util/transport/async/ClientContext; 
.const [95] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [96] = Utf8 transport 
.const [97] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [98] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [99] = Utf8 isDone 
.const [100] = Utf8 Z 
.const [101] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [102] = Utf8 ok 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/esolutions/fw/util/transport/async/TransportJob 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Object 
.const [107] = Class [106] 
.const [108] = Utf8 context 
.const [109] = Utf8 Lde/esolutions/fw/util/transport/async/ClientContext; 
.const [110] = Utf8 transport 
.const [111] = Utf8 Lde/esolutions/fw/util/transport/ITransport; 
.const [112] = Utf8 isDone 
.const [113] = Utf8 Z 
.const [114] = Utf8 ok 
.const [115] = Utf8 Z 
.const [116] = Utf8 Code 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/esolutions/fw/util/transport/async/ClientContext;Lde/esolutions/fw/util/transport/ITransport;)V 
.const [119] = Utf8 getClientContext 
.const [120] = Utf8 ()Lde/esolutions/fw/util/transport/async/ClientContext; 
.const [121] = Utf8 getTransport 
.const [122] = Utf8 ()Lde/esolutions/fw/util/transport/ITransport; 
.const [123] = Utf8 doIO 
.const [124] = Utf8 ()V 
.const [125] = Utf8 doTransport 
.const [126] = Utf8 ()Z 
.const [127] = Utf8 setDone 
.const [128] = Utf8 (Z)V 
.const [129] = Utf8 waitDone 
.const [130] = Utf8 ()Z 
.end class 
