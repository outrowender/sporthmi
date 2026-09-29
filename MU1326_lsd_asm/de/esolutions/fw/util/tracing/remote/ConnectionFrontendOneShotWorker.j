.version 50 0 
.class public super [145] 
.super [147] 
.field private [148] [149] 
.field private [150] [151] 
.field public static final [152] [153] 

.method public [155] : [156] 
    .attribute [154] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_3 
L3:     invokespecial [26] 
L6:     aload_0 
L7:     aload_2 
L8:     putfield [29] 
L11:    return 
L12:    
    .end code 
.end method 

.method public synchronized [157] : [158] 
    .attribute [154] .code stack 2 locals 0 
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

.method protected [159] : [160] 
    .attribute [154] .code stack 6 locals 0 
L0:     aload_0 
L1:     new [31] 
L4:     dup 
L5:     aload_0 
L6:     getfield [18] 
L9:     aload_0 
L10:    getfield [16] 
L13:    aload_0 
L14:    getfield [19] 
L17:    invokespecial [28] 
L20:    putfield [30] 
L23:    aload_0 
L24:    aload_0 
L25:    getfield [17] 
L28:    invokevirtual [20] 
L31:    aload_0 
L32:    getfield [17] 
L35:    invokevirtual [21] 
L38:    ifeq L96 
L41:    getstatic [3] 
L44:    ldc [4] 
L46:    ldc [5] 
L48:    invokestatic [6] 
L51:    aload_0 
L52:    ldc [4] 
L54:    aload_0 
L55:    getfield [17] 
L58:    invokevirtual [22] 
L61:    getstatic [3] 
L64:    ldc [4] 
L66:    ldc [7] 
L68:    invokestatic [6] 
L71:    aload_0 
L72:    getfield [17] 
L75:    invokevirtual [23] 
L78:    ifeq L113 
L81:    aload_0 
L82:    getfield [17] 
L85:    invokevirtual [24] 
L88:    aload_0 
L89:    aconst_null 
L90:    putfield [30] 
L93:    goto L113 
L96:    getstatic [8] 
L99:    ldc [4] 
L101:   ldc [9] 
L103:   aload_0 
L104:   getfield [16] 
L107:   invokevirtual [25] 
L110:   invokestatic [10] 
L113:   aload_0 
L114:   iconst_0 
L115:   putfield [32] 
L118:   getstatic [3] 
L121:   ldc [4] 
L123:   ldc [11] 
L125:   invokestatic [6] 
L128:   return 
L129:   nop 
L130:   nop 
L131:   nop 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [33] 
.const [3] = Field [34] [35] 
.const [4] = String [36] 
.const [5] = String [37] 
.const [6] = Method [38] [39] 
.const [7] = String [40] 
.const [8] = Field [41] [42] 
.const [9] = String [43] 
.const [10] = Method [44] [45] 
.const [11] = String [46] 
.const [12] = Class [47] 
.const [13] = Class [48] 
.const [14] = Class [49] 
.const [15] = Class [50] 
.const [16] = Field [51] [52] 
.const [17] = Field [53] [54] 
.const [18] = Field [55] [56] 
.const [19] = Field [57] [58] 
.const [20] = Method [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Method [69] [70] 
.const [26] = Method [71] [72] 
.const [27] = Method [73] [74] 
.const [28] = Method [75] [76] 
.const [29] = Field [77] [78] 
.const [30] = Field [79] [80] 
.const [31] = Class [81] 
.const [32] = Field [82] [83] 
.const [33] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [34] = Class [84] 
.const [35] = NameAndType [85] [86] 
.const [36] = Utf8 ConnectionFrontendOneShotWorker 
.const [37] = Utf8 'enter msg loop' 
.const [38] = Class [87] 
.const [39] = NameAndType [88] [89] 
.const [40] = Utf8 'leave msg loop' 
.const [41] = Class [90] 
.const [42] = NameAndType [91] [92] 
.const [43] = Utf8 "can't connect: %1" 
.const [44] = Class [93] 
.const [45] = NameAndType [94] [95] 
.const [46] = Utf8 'Thread done.' 
.const [47] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [48] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [49] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [50] = Utf8 de/esolutions/fw/util/serializer/connection/Connection 
.const [51] = Class [96] 
.const [52] = NameAndType [97] [98] 
.const [53] = Class [99] 
.const [54] = NameAndType [100] [101] 
.const [55] = Class [102] 
.const [56] = NameAndType [103] [104] 
.const [57] = Class [105] 
.const [58] = NameAndType [106] [107] 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Class [114] 
.const [64] = NameAndType [115] [116] 
.const [65] = Class [117] 
.const [66] = NameAndType [118] [119] 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Class [126] 
.const [72] = NameAndType [127] [128] 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [85] = Utf8 INFO 
.const [86] = Utf8 I 
.const [87] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [88] = Utf8 msg 
.const [89] = Utf8 (ILjava/lang/String;Ljava/lang/String;)V 
.const [90] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [91] = Utf8 WARN 
.const [92] = Utf8 I 
.const [93] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [94] = Utf8 msg 
.const [95] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [96] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [97] = Utf8 connection 
.const [98] = Utf8 Lde/esolutions/fw/util/serializer/connection/Connection; 
.const [99] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [100] = Utf8 handler 
.const [101] = Utf8 Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [102] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [103] = Utf8 myName 
.const [104] = Utf8 Ljava/lang/String; 
.const [105] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [106] = Utf8 frontend 
.const [107] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [108] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [109] = Utf8 configureHandler 
.const [110] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [111] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [112] = Utf8 connect 
.const [113] = Utf8 ()Z 
.const [114] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [115] = Utf8 messageLoop 
.const [116] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [117] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [118] = Utf8 isConnected 
.const [119] = Utf8 ()Z 
.const [120] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [121] = Utf8 disconnect 
.const [122] = Utf8 ()V 
.const [123] = Utf8 de/esolutions/fw/util/serializer/connection/Connection 
.const [124] = Utf8 getDescription 
.const [125] = Utf8 ()Ljava/lang/String; 
.const [126] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [129] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [130] = Utf8 stop 
.const [131] = Utf8 (Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler;)V 
.const [132] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/serializer/connection/Connection;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [135] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [136] = Utf8 connection 
.const [137] = Utf8 Lde/esolutions/fw/util/serializer/connection/Connection; 
.const [138] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [139] = Utf8 handler 
.const [140] = Utf8 Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [141] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [142] = Utf8 keepRunning 
.const [143] = Utf8 Z 
.const [144] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendOneShotWorker 
.const [145] = Class [144] 
.const [146] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendWorkerBase 
.const [147] = Class [146] 
.const [148] = Utf8 connection 
.const [149] = Utf8 Lde/esolutions/fw/util/serializer/connection/Connection; 
.const [150] = Utf8 handler 
.const [151] = Utf8 Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [152] = Utf8 chn 
.const [153] = Utf8 Ljava/lang/String; 
.const [154] = Utf8 Code 
.const [155] = Utf8 <init> 
.const [156] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/serializer/connection/Connection;Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [157] = Utf8 stop 
.const [158] = Utf8 ()V 
.const [159] = Utf8 doRun 
.const [160] = Utf8 ()V 
.end class 
