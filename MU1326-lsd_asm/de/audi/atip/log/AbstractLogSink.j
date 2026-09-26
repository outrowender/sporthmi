.version 50 0 
.class public super abstract [115] 
.super [117] 
.implements [119] 
.field private static final [120] [121] 
.field private [122] [123] 
.field private [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     aload_0 
L5:     new [20] 
L8:     dup 
L9:     invokespecial [17] 
L12:    putfield [21] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [129] : [130] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     invokevirtual [12] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public final [131] : [132] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [22] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifnull L17 
L7:     aload_0 
L8:     getfield [13] 
L11:    invokeinterface [23] 0 
L16:    areturn 
L17:    aconst_null 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [24] 
L7:     dup 
L8:     invokespecial [19] 
L11:    athrow 
L12:    aload_0 
L13:    aload_1 
L14:    putfield [21] 
L17:    aload_0 
L18:    getfield [13] 
L21:    ifnull L33 
L24:    aload_0 
L25:    getfield [13] 
L28:    invokeinterface [25] 0 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L12 
L4:     new [24] 
L7:     dup 
L8:     invokespecial [19] 
L11:    athrow 
L12:    aload_0 
L13:    aload_1 
L14:    putfield [21] 
L17:    aload_0 
L18:    getfield [13] 
L21:    ifnull L34 
L24:    aload_0 
L25:    getfield [13] 
L28:    aload_2 
L29:    invokeinterface [26] 0 
L34:    return 
L35:    nop 
L36:    
    .end code 
.end method 

.method public interface [139] : [140] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [126] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokevirtual [14] 
L4:     aload_1 
L5:     invokeinterface [27] 0 
L10:    astore_2 
L11:    aload_2 
L12:    ifnonnull L27 
L15:    aload_0 
L16:    invokevirtual [14] 
L19:    ldc [4] 
L21:    invokeinterface [27] 0 
L26:    astore_2 
L27:    aload_2 
L28:    ifnull L41 
L31:    aload_2 
L32:    checkcast [5] 
L35:    invokevirtual [15] 
L38:    goto L42 
L41:    iconst_0 
L42:    areturn 
L43:    nop 
L44:    
    .end code 
.end method 

.method public abstract [143] : [144] 
    .attribute [126] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [28] 
.const [3] = Class [29] 
.const [4] = String [30] 
.const [5] = Class [31] 
.const [6] = Class [32] 
.const [7] = Class [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Field [37] [38] 
.const [12] = Method [39] [40] 
.const [13] = Field [41] [42] 
.const [14] = Method [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Method [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Class [55] 
.const [21] = Field [56] [57] 
.const [22] = Field [58] [59] 
.const [23] = InterfaceMethod [60] [61] 
.const [24] = Class [62] 
.const [25] = InterfaceMethod [63] [64] 
.const [26] = InterfaceMethod [65] [66] 
.const [27] = InterfaceMethod [67] [68] 
.const [28] = Utf8 java/util/HashMap 
.const [29] = Utf8 java/lang/IllegalArgumentException 
.const [30] = Utf8 all 
.const [31] = Utf8 java/lang/Integer 
.const [32] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [33] = Utf8 java/lang/Object 
.const [34] = Utf8 java/lang/Class 
.const [35] = Utf8 de/audi/atip/log/LogServAdmin 
.const [36] = Utf8 java/util/Map 
.const [37] = Class [69] 
.const [38] = NameAndType [70] [71] 
.const [39] = Class [72] 
.const [40] = NameAndType [73] [74] 
.const [41] = Class [75] 
.const [42] = NameAndType [76] [77] 
.const [43] = Class [78] 
.const [44] = NameAndType [79] [80] 
.const [45] = Class [81] 
.const [46] = NameAndType [82] [83] 
.const [47] = Class [84] 
.const [48] = NameAndType [85] [86] 
.const [49] = Class [87] 
.const [50] = NameAndType [88] [89] 
.const [51] = Class [90] 
.const [52] = NameAndType [91] [92] 
.const [53] = Class [93] 
.const [54] = NameAndType [94] [95] 
.const [55] = Utf8 java/util/HashMap 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Utf8 java/lang/IllegalArgumentException 
.const [63] = Class [105] 
.const [64] = NameAndType [106] [107] 
.const [65] = Class [108] 
.const [66] = NameAndType [109] [110] 
.const [67] = Class [111] 
.const [68] = NameAndType [112] [113] 
.const [69] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [70] = Utf8 config 
.const [71] = Utf8 Ljava/util/Map; 
.const [72] = Utf8 java/lang/Class 
.const [73] = Utf8 getName 
.const [74] = Utf8 ()Ljava/lang/String; 
.const [75] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [76] = Utf8 owner 
.const [77] = Utf8 Lde/audi/atip/log/LogServAdmin; 
.const [78] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [79] = Utf8 getConfiguration 
.const [80] = Utf8 ()Ljava/util/Map; 
.const [81] = Utf8 java/lang/Integer 
.const [82] = Utf8 intValue 
.const [83] = Utf8 ()I 
.const [84] = Utf8 java/lang/Object 
.const [85] = Utf8 <init> 
.const [86] = Utf8 ()V 
.const [87] = Utf8 java/util/HashMap 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 java/lang/Object 
.const [91] = Utf8 getClass 
.const [92] = Utf8 ()Ljava/lang/Class; 
.const [93] = Utf8 java/lang/IllegalArgumentException 
.const [94] = Utf8 <init> 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [97] = Utf8 config 
.const [98] = Utf8 Ljava/util/Map; 
.const [99] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [100] = Utf8 owner 
.const [101] = Utf8 Lde/audi/atip/log/LogServAdmin; 
.const [102] = Utf8 de/audi/atip/log/LogServAdmin 
.const [103] = Utf8 getAvailableChannels 
.const [104] = Utf8 ()Ljava/util/Map; 
.const [105] = Utf8 de/audi/atip/log/LogServAdmin 
.const [106] = Utf8 updateChannelConfiguration 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/audi/atip/log/LogServAdmin 
.const [109] = Utf8 updateChannelConfiguration 
.const [110] = Utf8 (Ljava/lang/String;)V 
.const [111] = Utf8 java/util/Map 
.const [112] = Utf8 get 
.const [113] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [114] = Utf8 de/audi/atip/log/AbstractLogSink 
.const [115] = Class [114] 
.const [116] = Utf8 java/lang/Object 
.const [117] = Class [116] 
.const [118] = Utf8 de/audi/atip/log/LogSink 
.const [119] = Class [118] 
.const [120] = Utf8 DEFAULT_LEVEL 
.const [121] = Utf8 I 
.const [122] = Utf8 config 
.const [123] = Utf8 Ljava/util/Map; 
.const [124] = Utf8 owner 
.const [125] = Utf8 Lde/audi/atip/log/LogServAdmin; 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 ()V 
.const [129] = Utf8 toString 
.const [130] = Utf8 ()Ljava/lang/String; 
.const [131] = Utf8 registerServices 
.const [132] = Utf8 (Lde/audi/atip/log/LogServAdmin;)V 
.const [133] = Utf8 getAvailableChannel 
.const [134] = Utf8 ()Ljava/util/Map; 
.const [135] = Utf8 setConfiguration 
.const [136] = Utf8 (Ljava/util/Map;)V 
.const [137] = Utf8 updateConfiguration 
.const [138] = Utf8 (Ljava/util/Map;Ljava/lang/String;)V 
.const [139] = Utf8 getConfiguration 
.const [140] = Utf8 ()Ljava/util/Map; 
.const [141] = Utf8 getLogThreshold 
.const [142] = Utf8 (Ljava/lang/String;)I 
.const [143] = Utf8 writeLog 
.const [144] = Utf8 (Lde/audi/atip/log/LogEntry;)V 
.end class 
