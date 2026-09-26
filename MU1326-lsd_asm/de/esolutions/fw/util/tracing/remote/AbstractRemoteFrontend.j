.version 50 0 
.class public super [115] 
.super [117] 
.implements [119] 
.field private [120] [121] 
.field private [122] [123] 

.method public [125] : [126] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [23] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [24] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     invokevirtual [11] 
L8:     iconst_1 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     invokevirtual [12] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [124] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_1 
L5:     invokevirtual [13] 
L8:     checkcast [2] 
L11:    astore_3 
L12:    aload_3 
L13:    ifnonnull L17 
L16:    return 
L17:    aload_3 
L18:    invokevirtual [14] 
L21:    new [25] 
L24:    dup 
L25:    aload_1 
L26:    invokevirtual [15] 
L29:    aload_3 
L30:    invokevirtual [16] 
L33:    invokespecial [20] 
L36:    iload_2 
L37:    invokevirtual [17] 
L40:    pop 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [124] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [9] 
L4:     new [25] 
L7:     dup 
L8:     iconst_4 
L9:     iload_1 
L10:    invokespecial [20] 
L13:    invokevirtual [13] 
L16:    checkcast [2] 
L19:    astore_3 
L20:    aload_3 
L21:    ifnonnull L25 
L24:    return 
L25:    aload_3 
L26:    invokevirtual [14] 
L29:    aload_3 
L30:    invokevirtual [16] 
L33:    aload_2 
L34:    invokevirtual [18] 
L37:    pop 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public synchronized [135] : [136] 
    .attribute [124] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [24] 
L5:     aload_0 
L6:     invokespecial [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [137] : [138] 
    .attribute [124] .code stack 1 locals 1 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifne L17 
        .catch [4] from L7 to L11 using L14 
L7:     aload_0 
L8:     invokespecial [22] 
L11:    goto L0 
L14:    astore_1 
L15:    iconst_0 
L16:    areturn 
L17:    iconst_1 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Class [27] 
.const [4] = Class [28] 
.const [5] = Class [29] 
.const [6] = Class [30] 
.const [7] = Class [31] 
.const [8] = Class [32] 
.const [9] = Field [33] [34] 
.const [10] = Field [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Method [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Field [63] [64] 
.const [25] = Class [65] 
.const [26] = Utf8 de/esolutions/fw/util/tracing/remote/EntityBackRef 
.const [27] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [28] = Utf8 java/lang/InterruptedException 
.const [29] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteFrontend 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [32] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [33] = Class [66] 
.const [34] = NameAndType [67] [68] 
.const [35] = Class [69] 
.const [36] = NameAndType [70] [71] 
.const [37] = Class [72] 
.const [38] = NameAndType [73] [74] 
.const [39] = Class [75] 
.const [40] = NameAndType [76] [77] 
.const [41] = Class [78] 
.const [42] = NameAndType [79] [80] 
.const [43] = Class [81] 
.const [44] = NameAndType [82] [83] 
.const [45] = Class [84] 
.const [46] = NameAndType [85] [86] 
.const [47] = Class [87] 
.const [48] = NameAndType [88] [89] 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [66] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteFrontend 
.const [67] = Utf8 frontend 
.const [68] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [69] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteFrontend 
.const [70] = Utf8 doQuit 
.const [71] = Utf8 Z 
.const [72] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [73] = Utf8 registerListener 
.const [74] = Utf8 (Lde/esolutions/fw/util/tracing/frontend/ITraceFrontendListener;)V 
.const [75] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [76] = Utf8 unregisterListener 
.const [77] = Utf8 (Lde/esolutions/fw/util/tracing/frontend/ITraceFrontendListener;)V 
.const [78] = Utf8 de/esolutions/fw/util/tracing/frontend/TraceFrontend 
.const [79] = Utf8 getAttachment 
.const [80] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;)Ljava/lang/Object; 
.const [81] = Utf8 de/esolutions/fw/util/tracing/remote/EntityBackRef 
.const [82] = Utf8 getHandler 
.const [83] = Utf8 ()Lde/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler; 
.const [84] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [85] = Utf8 getType 
.const [86] = Utf8 ()S 
.const [87] = Utf8 de/esolutions/fw/util/tracing/remote/EntityBackRef 
.const [88] = Utf8 getExtId 
.const [89] = Utf8 ()I 
.const [90] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [91] = Utf8 requestFilterLevelExtUri 
.const [92] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;S)Z 
.const [93] = Utf8 de/esolutions/fw/util/tracing/remote/ConnectionFrontendHandler 
.const [94] = Utf8 executeCallbackExtUri 
.const [95] = Utf8 (I[B)Z 
.const [96] = Utf8 java/lang/Object 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/esolutions/fw/util/tracing/entity/TraceEntityURI 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (SI)V 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 notifyAll 
.const [104] = Utf8 ()V 
.const [105] = Utf8 java/lang/Object 
.const [106] = Utf8 wait 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteFrontend 
.const [109] = Utf8 frontend 
.const [110] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [111] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteFrontend 
.const [112] = Utf8 doQuit 
.const [113] = Utf8 Z 
.const [114] = Utf8 de/esolutions/fw/util/tracing/remote/AbstractRemoteFrontend 
.const [115] = Class [114] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [116] 
.const [118] = Utf8 de/esolutions/fw/util/tracing/frontend/ITraceFrontendListener 
.const [119] = Class [118] 
.const [120] = Utf8 frontend 
.const [121] = Utf8 Lde/esolutions/fw/util/tracing/frontend/TraceFrontend; 
.const [122] = Utf8 doQuit 
.const [123] = Utf8 Z 
.const [124] = Utf8 Code 
.const [125] = Utf8 <init> 
.const [126] = Utf8 (Lde/esolutions/fw/util/tracing/frontend/TraceFrontend;)V 
.const [127] = Utf8 start 
.const [128] = Utf8 ()Z 
.const [129] = Utf8 stop 
.const [130] = Utf8 ()V 
.const [131] = Utf8 requestFilterLevel 
.const [132] = Utf8 (Lde/esolutions/fw/util/tracing/entity/TraceEntityURI;S)V 
.const [133] = Utf8 executeCallback 
.const [134] = Utf8 (I[B)V 
.const [135] = Utf8 requestQuit 
.const [136] = Utf8 ()V 
.const [137] = Utf8 waitForQuit 
.const [138] = Utf8 ()Z 
.end class 
