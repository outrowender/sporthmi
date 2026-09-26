.version 50 0 
.class public super abstract [125] 
.super [127] 
.implements [129] 
.field private [130] [131] 
.field protected [132] [133] 

.method public annotation [135] : [136] 
    .attribute [134] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [134] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnonnull L33 
L7:     aload_0 
L8:     new [26] 
L11:    dup 
L12:    aload_0 
L13:    ldc [3] 
L15:    invokespecial [23] 
L18:    putfield [25] 
L21:    aload_0 
L22:    iconst_1 
L23:    putfield [27] 
L26:    aload_0 
L27:    getfield [11] 
L30:    invokevirtual [13] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [134] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnull L50 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [27] 
L12:    aload_0 
L13:    invokevirtual [14] 
L16:    pop 
L17:    aload_0 
L18:    getfield [11] 
L21:    invokevirtual [15] 
        .catch [4] from L24 to L31 using L34 
L24:    aload_0 
L25:    getfield [11] 
L28:    invokevirtual [16] 
L31:    goto L50 
L34:    astore_1 
L35:    aload_0 
L36:    getfield [17] 
L39:    aload_0 
L40:    getfield [18] 
L43:    ldc [5] 
L45:    invokeinterface [28] 0 
L50:    aload_0 
L51:    invokespecial [24] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [134] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     ifne L8 
L7:     return 
L8:     aload_0 
L9:     getfield [17] 
L12:    aload_0 
L13:    getfield [18] 
L16:    ldc [6] 
L18:    invokeinterface [28] 0 
L23:    aload_0 
L24:    getfield [12] 
L27:    ifeq L47 
        .catch [4] from L30 to L37 using L43 
L30:    aload_0 
L31:    invokevirtual [20] 
L34:    ifne L40 
L37:    goto L47 
L40:    goto L23 
L43:    astore_1 
L44:    goto L47 
L47:    aload_0 
L48:    getfield [17] 
L51:    aload_0 
L52:    getfield [18] 
L55:    ldc [7] 
L57:    invokeinterface [28] 0 
L62:    aload_0 
L63:    invokevirtual [21] 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method protected abstract [143] : [144] 
    .attribute [134] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [145] : [146] 
    .attribute [134] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [147] : [148] 
    .attribute [134] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [29] 
.const [3] = String [30] 
.const [4] = Class [31] 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = String [34] 
.const [8] = Class [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Field [38] [39] 
.const [12] = Field [40] [41] 
.const [13] = Method [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Field [50] [51] 
.const [18] = Field [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Method [56] [57] 
.const [21] = Method [58] [59] 
.const [22] = Method [60] [61] 
.const [23] = Method [62] [63] 
.const [24] = Method [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = Class [68] 
.const [27] = Field [69] [70] 
.const [28] = InterfaceMethod [71] [72] 
.const [29] = Utf8 java/lang/Thread 
.const [30] = Utf8 TraceRemote 
.const [31] = Utf8 java/lang/InterruptedException 
.const [32] = Utf8 'waiting for remote worker interrupted' 
.const [33] = Utf8 'worker thread started' 
.const [34] = Utf8 'worker thread stopped' 
.const [35] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [36] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteBackend 
.const [37] = Utf8 de/esolutions/fw/util/tracing/backend/ITraceBackendListener 
.const [38] = Class [73] 
.const [39] = NameAndType [74] [75] 
.const [40] = Class [76] 
.const [41] = NameAndType [77] [78] 
.const [42] = Class [79] 
.const [43] = NameAndType [80] [81] 
.const [44] = Class [82] 
.const [45] = NameAndType [83] [84] 
.const [46] = Class [85] 
.const [47] = NameAndType [86] [87] 
.const [48] = Class [88] 
.const [49] = NameAndType [89] [90] 
.const [50] = Class [91] 
.const [51] = NameAndType [92] [93] 
.const [52] = Class [94] 
.const [53] = NameAndType [95] [96] 
.const [54] = Class [97] 
.const [55] = NameAndType [98] [99] 
.const [56] = Class [100] 
.const [57] = NameAndType [101] [102] 
.const [58] = Class [103] 
.const [59] = NameAndType [104] [105] 
.const [60] = Class [106] 
.const [61] = NameAndType [107] [108] 
.const [62] = Class [109] 
.const [63] = NameAndType [110] [111] 
.const [64] = Class [112] 
.const [65] = NameAndType [113] [114] 
.const [66] = Class [115] 
.const [67] = NameAndType [116] [117] 
.const [68] = Utf8 java/lang/Thread 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [74] = Utf8 thread 
.const [75] = Utf8 Ljava/lang/Thread; 
.const [76] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [77] = Utf8 doRun 
.const [78] = Utf8 Z 
.const [79] = Utf8 java/lang/Thread 
.const [80] = Utf8 start 
.const [81] = Utf8 ()V 
.const [82] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [83] = Utf8 remoteDisconnect 
.const [84] = Utf8 ()Z 
.const [85] = Utf8 java/lang/Thread 
.const [86] = Utf8 interrupt 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/Thread 
.const [89] = Utf8 join 
.const [90] = Utf8 ()V 
.const [91] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [92] = Utf8 listener 
.const [93] = Utf8 Lde/esolutions/fw/util/tracing/backend/ITraceBackendListener; 
.const [94] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [95] = Utf8 bid 
.const [96] = Utf8 S 
.const [97] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [98] = Utf8 doInit 
.const [99] = Utf8 ()Z 
.const [100] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [101] = Utf8 doWork 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [104] = Utf8 doExit 
.const [105] = Utf8 ()V 
.const [106] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteBackend 
.const [107] = Utf8 <init> 
.const [108] = Utf8 (Ljava/lang/String;)V 
.const [109] = Utf8 java/lang/Thread 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Ljava/lang/Runnable;Ljava/lang/String;)V 
.const [112] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteBackend 
.const [113] = Utf8 exit 
.const [114] = Utf8 ()V 
.const [115] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [116] = Utf8 thread 
.const [117] = Utf8 Ljava/lang/Thread; 
.const [118] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [119] = Utf8 doRun 
.const [120] = Utf8 Z 
.const [121] = Utf8 de/esolutions/fw/util/tracing/backend/ITraceBackendListener 
.const [122] = Utf8 logMessage 
.const [123] = Utf8 (SLjava/lang/String;)V 
.const [124] = Utf8 de/esolutions/fw/util/tracing/remote/ActiveRemoteBackend 
.const [125] = Class [124] 
.const [126] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteBackend 
.const [127] = Class [126] 
.const [128] = Utf8 java/lang/Runnable 
.const [129] = Class [128] 
.const [130] = Utf8 thread 
.const [131] = Utf8 Ljava/lang/Thread; 
.const [132] = Utf8 doRun 
.const [133] = Utf8 Z 
.const [134] = Utf8 Code 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Ljava/lang/String;)V 
.const [137] = Utf8 startWorker 
.const [138] = Utf8 ()V 
.const [139] = Utf8 stopWorker 
.const [140] = Utf8 ()V 
.const [141] = Utf8 run 
.const [142] = Utf8 ()V 
.const [143] = Utf8 doInit 
.const [144] = Utf8 ()Z 
.const [145] = Utf8 doWork 
.const [146] = Utf8 ()Z 
.const [147] = Utf8 doExit 
.const [148] = Utf8 ()V 
.end class 
