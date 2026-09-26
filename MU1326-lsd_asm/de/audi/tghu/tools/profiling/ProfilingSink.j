.version 50 0 
.class public super [83] 
.super [85] 
.field [86] [87] 

.method public [89] : [90] 
    .attribute [88] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     invokestatic [2] 
L8:     putfield [16] 
L11:    aload_0 
L12:    getfield [10] 
L15:    ifnonnull L19 
L18:    return 
L19:    return 
L20:    
    .end code 
.end method 

.method public [91] : [92] 
    .attribute [88] .code stack 4 locals 1 
        .catch [4] from L0 to L47 using L50 
L0:     ldc [3] 
L2:     aload_1 
L3:     invokeinterface [17] 0 
L8:     invokevirtual [11] 
L11:    ifeq L34 
L14:    aload_0 
L15:    getfield [10] 
L18:    sipush 907 
L21:    aload_1 
L22:    aconst_null 
L23:    invokeinterface [18] 0 
L28:    invokevirtual [12] 
L31:    goto L47 
L34:    aload_0 
L35:    getfield [10] 
L38:    aload_1 
L39:    invokeinterface [19] 0 
L44:    invokevirtual [13] 
L47:    goto L55 
L50:    astore_2 
L51:    aload_2 
L52:    invokevirtual [14] 
L55:    return 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [20] [21] 
.const [3] = String [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Field [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = InterfaceMethod [43] [44] 
.const [18] = InterfaceMethod [45] [46] 
.const [19] = InterfaceMethod [47] [48] 
.const [20] = Class [49] 
.const [21] = NameAndType [50] [51] 
.const [22] = Utf8 'Ext.Startup' 
.const [23] = Utf8 java/lang/Exception 
.const [24] = Utf8 de/audi/tghu/tools/profiling/ProfilingSink 
.const [25] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [26] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [27] = Utf8 de/audi/atip/log/LogEntry 
.const [28] = Utf8 java/lang/String 
.const [29] = Class [52] 
.const [30] = NameAndType [53] [54] 
.const [31] = Class [55] 
.const [32] = NameAndType [56] [57] 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [50] = Utf8 getInstance 
.const [51] = Utf8 ()Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [52] = Utf8 de/audi/tghu/tools/profiling/ProfilingSink 
.const [53] = Utf8 adapter 
.const [54] = Utf8 Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [55] = Utf8 java/lang/String 
.const [56] = Utf8 equals 
.const [57] = Utf8 (Ljava/lang/Object;)Z 
.const [58] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [59] = Utf8 createKernelUserEvent 
.const [60] = Utf8 (ILjava/lang/String;)V 
.const [61] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [62] = Utf8 createKernelUserEvent 
.const [63] = Utf8 (Ljava/lang/String;)V 
.const [64] = Utf8 java/lang/Exception 
.const [65] = Utf8 printStackTrace 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [68] = Utf8 <init> 
.const [69] = Utf8 ()V 
.const [70] = Utf8 de/audi/tghu/tools/profiling/ProfilingSink 
.const [71] = Utf8 adapter 
.const [72] = Utf8 Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [73] = Utf8 de/audi/atip/log/LogEntry 
.const [74] = Utf8 getChannelName 
.const [75] = Utf8 ()Ljava/lang/String; 
.const [76] = Utf8 de/audi/atip/log/LogEntry 
.const [77] = Utf8 getLogMessage 
.const [78] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [79] = Utf8 de/audi/atip/log/LogEntry 
.const [80] = Utf8 getMsg 
.const [81] = Utf8 ()Ljava/lang/String; 
.const [82] = Utf8 de/audi/tghu/tools/profiling/ProfilingSink 
.const [83] = Class [82] 
.const [84] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [85] = Class [84] 
.const [86] = Utf8 adapter 
.const [87] = Utf8 Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 writeLog 
.const [92] = Utf8 (Lde/audi/atip/log/LogEntry;)V 
.end class 
