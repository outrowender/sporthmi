.version 50 0 
.class public super [135] 
.super [137] 
.field private [138] [139] 
.field private [140] [141] 
.field private static [142] [143] 

.method public static synchronized [145] : [146] 
    .attribute [144] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     ifnonnull L16 
L6:     new [22] 
L9:     dup 
L10:    invokespecial [19] 
L13:    putstatic [18] 
L16:    getstatic [2] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public [147] : [148] 
    .attribute [144] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [20] 
L4:     aload_0 
L5:     new [23] 
L8:     dup 
L9:     invokespecial [21] 
L12:    putfield [24] 
L15:    return 
L16:    
    .end code 
.end method 

.method public synchronized [149] : [150] 
    .attribute [144] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [151] : [152] 
    .attribute [144] .code stack 4 locals 0 
L0:     getstatic [5] 
L3:     ldc [6] 
L5:     ldc [7] 
L7:     aload_1 
L8:     invokevirtual [17] 
L11:    invokestatic [8] 
L14:    aload_0 
L15:    getfield [16] 
L18:    ifnull L35 
L21:    aload_0 
L22:    getfield [16] 
L25:    aload_1 
L26:    invokeinterface [26] 0 
L31:    pop 
L32:    goto L46 
L35:    aload_0 
L36:    getfield [15] 
L39:    aload_1 
L40:    invokeinterface [27] 0 
L45:    pop 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public synchronized [153] : [154] 
    .attribute [144] .code stack 4 locals 0 
L0:     getstatic [5] 
L3:     ldc [6] 
L5:     ldc [9] 
L7:     aload_1 
L8:     invokevirtual [17] 
L11:    invokestatic [8] 
L14:    aload_0 
L15:    getfield [16] 
L18:    ifnull L35 
L21:    aload_0 
L22:    getfield [16] 
L25:    aload_1 
L26:    invokeinterface [28] 0 
L31:    pop 
L32:    goto L46 
L35:    aload_0 
L36:    getfield [15] 
L39:    aload_1 
L40:    invokeinterface [29] 0 
L45:    pop 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public synchronized [155] : [156] 
    .attribute [144] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokeinterface [30] 0 
L9:     istore_1 
L10:    iload_1 
L11:    anewarray [10] 
L14:    astore_2 
L15:    aload_0 
L16:    getfield [15] 
L19:    aload_2 
L20:    invokeinterface [31] 0 
L25:    pop 
L26:    aload_2 
L27:    areturn 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [32] [33] 
.const [3] = Class [34] 
.const [4] = Class [35] 
.const [5] = Field [36] [37] 
.const [6] = String [38] 
.const [7] = String [39] 
.const [8] = Method [40] [41] 
.const [9] = String [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Field [48] [49] 
.const [16] = Field [50] [51] 
.const [17] = Method [52] [53] 
.const [18] = Field [54] [55] 
.const [19] = Method [56] [57] 
.const [20] = Method [58] [59] 
.const [21] = Method [60] [61] 
.const [22] = Class [62] 
.const [23] = Class [63] 
.const [24] = Field [64] [65] 
.const [25] = Field [66] [67] 
.const [26] = InterfaceMethod [68] [69] 
.const [27] = InterfaceMethod [70] [71] 
.const [28] = InterfaceMethod [72] [73] 
.const [29] = InterfaceMethod [74] [75] 
.const [30] = InterfaceMethod [76] [77] 
.const [31] = InterfaceMethod [78] [79] 
.const [32] = Class [80] 
.const [33] = NameAndType [81] [82] 
.const [34] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [35] = Utf8 java/util/ArrayList 
.const [36] = Class [83] 
.const [37] = NameAndType [84] [85] 
.const [38] = Utf8 TraceChannelList 
.const [39] = Utf8 'registerChannel: %1' 
.const [40] = Class [86] 
.const [41] = NameAndType [87] [88] 
.const [42] = Utf8 'unregisterChannel: %1' 
.const [43] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [46] = Utf8 de/esolutions/fw/util/tracing/ITraceClient 
.const [47] = Utf8 java/util/List 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Class [92] 
.const [51] = NameAndType [93] [94] 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Class [104] 
.const [59] = NameAndType [105] [106] 
.const [60] = Class [107] 
.const [61] = NameAndType [108] [109] 
.const [62] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [63] = Utf8 java/util/ArrayList 
.const [64] = Class [110] 
.const [65] = NameAndType [111] [112] 
.const [66] = Class [113] 
.const [67] = NameAndType [114] [115] 
.const [68] = Class [116] 
.const [69] = NameAndType [117] [118] 
.const [70] = Class [119] 
.const [71] = NameAndType [120] [121] 
.const [72] = Class [122] 
.const [73] = NameAndType [123] [124] 
.const [74] = Class [125] 
.const [75] = NameAndType [126] [127] 
.const [76] = Class [128] 
.const [77] = NameAndType [129] [130] 
.const [78] = Class [131] 
.const [79] = NameAndType [132] [133] 
.const [80] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [81] = Utf8 theChannelList 
.const [82] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannelList; 
.const [83] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [84] = Utf8 DEBUG 
.const [85] = Utf8 I 
.const [86] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [87] = Utf8 msg 
.const [88] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [89] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [90] = Utf8 channels 
.const [91] = Utf8 Ljava/util/List; 
.const [92] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [93] = Utf8 client 
.const [94] = Utf8 Lde/esolutions/fw/util/tracing/ITraceClient; 
.const [95] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [96] = Utf8 getPath 
.const [97] = Utf8 ()Ljava/lang/String; 
.const [98] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [99] = Utf8 theChannelList 
.const [100] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannelList; 
.const [101] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/lang/Object 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 java/util/ArrayList 
.const [108] = Utf8 <init> 
.const [109] = Utf8 ()V 
.const [110] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [111] = Utf8 channels 
.const [112] = Utf8 Ljava/util/List; 
.const [113] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [114] = Utf8 client 
.const [115] = Utf8 Lde/esolutions/fw/util/tracing/ITraceClient; 
.const [116] = Utf8 de/esolutions/fw/util/tracing/ITraceClient 
.const [117] = Utf8 registerChannel 
.const [118] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;)Z 
.const [119] = Utf8 java/util/List 
.const [120] = Utf8 add 
.const [121] = Utf8 (Ljava/lang/Object;)Z 
.const [122] = Utf8 de/esolutions/fw/util/tracing/ITraceClient 
.const [123] = Utf8 unregisterChannel 
.const [124] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;)Z 
.const [125] = Utf8 java/util/List 
.const [126] = Utf8 remove 
.const [127] = Utf8 (Ljava/lang/Object;)Z 
.const [128] = Utf8 java/util/List 
.const [129] = Utf8 size 
.const [130] = Utf8 ()I 
.const [131] = Utf8 java/util/List 
.const [132] = Utf8 toArray 
.const [133] = Utf8 ([Ljava/lang/Object;)[Ljava/lang/Object; 
.const [134] = Utf8 de/esolutions/fw/util/tracing/TraceChannelList 
.const [135] = Class [134] 
.const [136] = Utf8 java/lang/Object 
.const [137] = Class [136] 
.const [138] = Utf8 channels 
.const [139] = Utf8 Ljava/util/List; 
.const [140] = Utf8 client 
.const [141] = Utf8 Lde/esolutions/fw/util/tracing/ITraceClient; 
.const [142] = Utf8 theChannelList 
.const [143] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannelList; 
.const [144] = Utf8 Code 
.const [145] = Utf8 getInstance 
.const [146] = Utf8 ()Lde/esolutions/fw/util/tracing/TraceChannelList; 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 setClient 
.const [150] = Utf8 (Lde/esolutions/fw/util/tracing/ITraceClient;)V 
.const [151] = Utf8 registerChannel 
.const [152] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;)V 
.const [153] = Utf8 unregisterChannel 
.const [154] = Utf8 (Lde/esolutions/fw/util/tracing/TraceChannel;)V 
.const [155] = Utf8 getAllChannels 
.const [156] = Utf8 ()[Lde/esolutions/fw/util/tracing/TraceChannel; 
.end class 
