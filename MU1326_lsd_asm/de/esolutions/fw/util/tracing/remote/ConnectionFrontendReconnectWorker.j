.version 50 0 
.class public super [160] 
.super [162] 
.field private final [163] [164] 
.field private [165] [166] 
.field private [167] [168] 
.field public static final [169] [170] 

.method public [172] : [173] 
    .attribute [171] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokespecial [26] 
L6:     aload_0 
L7:     ldc_w [1] 
L10:    putfield [30] 
L13:    aload_0 
L14:    aload_2 
L15:    putfield [31] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [174] : [175] 
    .attribute [171] .code stack 3 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     putfield [30] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [176] : [177] 
    .attribute [171] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [17] 
L5:     invokespecial [27] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [178] : [179] 
    .attribute [171] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     ifeq L93 
L7:     aload_0 
L8:     getfield [16] 
L11:    invokeinterface [33] 0 
L16:    astore_1 
L17:    aload_0 
L18:    new [34] 
L21:    dup 
L22:    aload_0 
L23:    getfield [19] 
L26:    aload_1 
L27:    aload_0 
L28:    getfield [20] 
L31:    invokespecial [28] 
L34:    putfield [32] 
L37:    aload_0 
L38:    aload_0 
L39:    getfield [17] 
L42:    invokevirtual [21] 
L45:    aload_0 
L46:    getfield [17] 
L49:    invokevirtual [22] 
L52:    ifeq L58 
L55:    goto L93 
L58:    getstatic [3] 
L61:    ldc [4] 
L63:    ldc [5] 
L65:    new [35] 
L68:    dup 
L69:    aload_0 
L70:    getfield [15] 
L73:    invokespecial [29] 
L76:    invokestatic [7] 
        .catch [9] from L79 to L86 using L89 
L79:    aload_0 
L80:    getfield [15] 
L83:    invokestatic [8] 
L86:    goto L90 
L89:    astore_2 
L90:    goto L0 
L93:    aload_0 
L94:    getfield [18] 
L97:    ifne L101 
L100:   return 
L101:   aload_0 
L102:   ldc [4] 
L104:   aload_0 
L105:   getfield [17] 
L108:   invokevirtual [23] 
L111:   aload_0 
L112:   getfield [17] 
L115:   invokevirtual [24] 
L118:   ifeq L128 
L121:   aload_0 
L122:   getfield [17] 
L125:   invokevirtual [25] 
L128:   aload_0 
L129:   aconst_null 
L130:   putfield [32] 
L133:   return 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Field [38] [39] 
.const [4] = String [40] 
.const [5] = String [41] 
.const [6] = Class [42] 
.const [7] = Method [43] [44] 
.const [8] = Method [45] [46] 
.const [9] = Class [47] 
.const [10] = Class [48] 
.const [11] = Class [49] 
.const [12] = Class [50] 
.const [13] = Class [51] 
.const [14] = Class [52] 
.const [15] = Field [53] [54] 
.const [16] = Field [55] [56] 
.const [17] = Field [57] [58] 
.const [18] = Field [59] [60] 
.const [19] = Field [61] [62] 
.const [20] = Field [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Method [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Field [83] [84] 
.const [31] = Field [85] [86] 
.const [32] = Field [87] [88] 
.const [33] = InterfaceMethod [89] [90] 
.const [34] = Class [91] 
.const [35] = Class [92] 
.const [36] = Int -402456576 
.const [37] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [38] = Class [93] 
.const [39] = NameAndType [94] [95] 
.const [40] = Utf8 ConnectionFrontendReconnectWorker 
.const [41] = Utf8 'connection retry after %1 ms' 
.const [42] = Utf8 java/lang/Long 
.const [43] = Class [96] 
.const [44] = NameAndType [97] [98] 
.const [45] = Class [99] 
.const [46] = NameAndType [100] [101] 
.const [47] = Utf8 java/lang/InterruptedException 
.const [48] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [49] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [50] = Utf8 de/esolutions/fw/util/serializer/connection/IConnectionFactory 
.const [51] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [52] = Utf8 java/lang/Thread 
.const [53] = Class [102] 
.const [54] = NameAndType [103] [104] 
.const [55] = Class [105] 
.const [56] = NameAndType [106] [107] 
.const [57] = Class [108] 
.const [58] = NameAndType [109] [110] 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [92] = Utf8 java/lang/Long 
.const [93] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [94] = Utf8 INFO 
.const [95] = Utf8 I 
.const [96] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [97] = Utf8 msg 
.const [98] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [99] = Utf8 java/lang/Thread 
.const [100] = Utf8 sleep 
.const [101] = Utf8 (J)V 
.const [102] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [103] = Utf8 retryDelay 
.const [104] = Utf8 J 
.const [105] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [106] = Utf8 factory 
.const [107] = Utf8 Lde/esolutions/fw/util/serializer/connection/IConnectionFactory; 
.const [108] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [109] = Utf8 handler 
.const [110] = Utf8 Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [111] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [112] = Utf8 keepRunning 
.const [113] = Utf8 Z 
.const [114] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [115] = Utf8 myName 
.const [116] = Utf8 Ljava/lang/String; 
.const [117] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [118] = Utf8 frontend 
.const [119] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [120] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [121] = Utf8 configureHandler 
.const [122] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [123] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [124] = Utf8 connect 
.const [125] = Utf8 ()Z 
.const [126] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [127] = Utf8 messageLoop 
.const [128] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [129] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [130] = Utf8 isConnected 
.const [131] = Utf8 ()Z 
.const [132] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [133] = Utf8 disconnect 
.const [134] = Utf8 ()V 
.const [135] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [138] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [139] = Utf8 stop 
.const [140] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [141] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/serializer/connection/Connection;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [144] = Utf8 java/lang/Long 
.const [145] = Utf8 <init> 
.const [146] = Utf8 (J)V 
.const [147] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [148] = Utf8 retryDelay 
.const [149] = Utf8 J 
.const [150] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [151] = Utf8 factory 
.const [152] = Utf8 Lde/esolutions/fw/util/serializer/connection/IConnectionFactory; 
.const [153] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [154] = Utf8 handler 
.const [155] = Utf8 Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [156] = Utf8 de/esolutions/fw/util/serializer/connection/IConnectionFactory 
.const [157] = Utf8 createConnection 
.const [158] = Utf8 ()Lde/esolutions/fw/util/serializer/connection/Connection; 
.const [159] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendReconnectWorker 
.const [160] = Class [159] 
.const [161] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [162] = Class [161] 
.const [163] = Utf8 factory 
.const [164] = Utf8 Lde/esolutions/fw/util/serializer/connection/IConnectionFactory; 
.const [165] = Utf8 retryDelay 
.const [166] = Utf8 J 
.const [167] = Utf8 handler 
.const [168] = Utf8 Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [169] = Utf8 chn 
.const [170] = Utf8 Ljava/lang/String; 
.const [171] = Utf8 Code 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/serializer/connection/IConnectionFactory;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [174] = Utf8 setRetryDelay 
.const [175] = Utf8 (J)V 
.const [176] = Utf8 stop 
.const [177] = Utf8 ()V 
.const [178] = Utf8 doRun 
.const [179] = Utf8 ()V 
.end class 
