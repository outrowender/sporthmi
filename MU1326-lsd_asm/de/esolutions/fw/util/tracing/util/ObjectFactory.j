.version 50 0 
.class public super [121] 
.super [123] 
.field private static final [124] [125] 
.field private [126] [127] 

.method public [129] : [130] 
    .attribute [128] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     new [26] 
L8:     dup 
L9:     invokespecial [25] 
L12:    putfield [27] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [131] : [132] 
    .attribute [128] .code stack 5 locals 0 
L0:     getstatic [3] 
L3:     ldc [4] 
L5:     ldc [5] 
L7:     aload_1 
L8:     aload_2 
L9:     invokevirtual [22] 
L12:    invokestatic [6] 
L15:    aload_0 
L16:    getfield [21] 
L19:    aload_1 
L20:    aload_2 
L21:    invokeinterface [28] 0 
L26:    pop 
L27:    return 
L28:    
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [128] .code stack 4 locals 0 
L0:     getstatic [3] 
L3:     ldc [4] 
L5:     ldc [7] 
L7:     aload_1 
L8:     invokestatic [8] 
L11:    aload_0 
L12:    getfield [21] 
L15:    aload_1 
L16:    invokeinterface [29] 0 
L21:    pop 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [128] .code stack 6 locals 3 
L0:     aload_0 
L1:     getfield [21] 
L4:     aload_1 
L5:     invokeinterface [30] 0 
L10:    astore_2 
L11:    aload_2 
L12:    ifnonnull L28 
L15:    getstatic [9] 
L18:    ldc [4] 
L20:    ldc [10] 
L22:    aload_1 
L23:    invokestatic [8] 
L26:    aconst_null 
L27:    areturn 
L28:    aload_2 
L29:    checkcast [11] 
L32:    astore_3 
        .catch [12] from L33 to L37 using L38 
        .catch [16] from L33 to L37 using L59 
L33:    aload_3 
L34:    invokevirtual [23] 
L37:    areturn 
L38:    astore 4 
L40:    getstatic [13] 
L43:    ldc [4] 
L45:    ldc [14] 
L47:    aload_1 
L48:    aload_3 
L49:    invokevirtual [22] 
L52:    aload 4 
L54:    invokestatic [15] 
L57:    aconst_null 
L58:    areturn 
L59:    astore 4 
L61:    getstatic [13] 
L64:    ldc [4] 
L66:    ldc [14] 
L68:    aload_1 
L69:    aload_3 
L70:    invokevirtual [22] 
L73:    aload 4 
L75:    invokestatic [15] 
L78:    aconst_null 
L79:    areturn 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [31] 
.const [3] = Field [32] [33] 
.const [4] = String [34] 
.const [5] = String [35] 
.const [6] = Method [36] [37] 
.const [7] = String [38] 
.const [8] = Method [39] [40] 
.const [9] = Field [41] [42] 
.const [10] = String [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Field [46] [47] 
.const [14] = String [48] 
.const [15] = Method [49] [50] 
.const [16] = Class [51] 
.const [17] = Class [52] 
.const [18] = Class [53] 
.const [19] = Class [54] 
.const [20] = Class [55] 
.const [21] = Field [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Class [66] 
.const [27] = Field [67] [68] 
.const [28] = InterfaceMethod [69] [70] 
.const [29] = InterfaceMethod [71] [72] 
.const [30] = InterfaceMethod [73] [74] 
.const [31] = Utf8 java/util/HashMap 
.const [32] = Class [75] 
.const [33] = NameAndType [76] [77] 
.const [34] = Utf8 Registry 
.const [35] = Utf8 'registry: register name=%1 class=%2' 
.const [36] = Class [78] 
.const [37] = NameAndType [79] [80] 
.const [38] = Utf8 'unregister name=%1' 
.const [39] = Class [81] 
.const [40] = NameAndType [82] [83] 
.const [41] = Class [84] 
.const [42] = NameAndType [85] [86] 
.const [43] = Utf8 'no name=%1 found!' 
.const [44] = Utf8 java/lang/Class 
.const [45] = Utf8 java/lang/IllegalAccessException 
.const [46] = Class [87] 
.const [47] = NameAndType [88] [89] 
.const [48] = Utf8 'name=%1 class=%2: %3' 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Utf8 java/lang/InstantiationException 
.const [52] = Utf8 de/esolutions/fw/util/tracing/util/ObjectFactory 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [55] = Utf8 java/util/Map 
.const [56] = Class [93] 
.const [57] = NameAndType [94] [95] 
.const [58] = Class [96] 
.const [59] = NameAndType [97] [98] 
.const [60] = Class [99] 
.const [61] = NameAndType [100] [101] 
.const [62] = Class [102] 
.const [63] = NameAndType [103] [104] 
.const [64] = Class [105] 
.const [65] = NameAndType [106] [107] 
.const [66] = Utf8 java/util/HashMap 
.const [67] = Class [108] 
.const [68] = NameAndType [109] [110] 
.const [69] = Class [111] 
.const [70] = NameAndType [112] [113] 
.const [71] = Class [114] 
.const [72] = NameAndType [115] [116] 
.const [73] = Class [117] 
.const [74] = NameAndType [118] [119] 
.const [75] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [76] = Utf8 DEBUG 
.const [77] = Utf8 I 
.const [78] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [79] = Utf8 msg 
.const [80] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [81] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [82] = Utf8 msg 
.const [83] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V 
.const [84] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [85] = Utf8 WARN 
.const [86] = Utf8 I 
.const [87] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [88] = Utf8 ERROR 
.const [89] = Utf8 I 
.const [90] = Utf8 de/esolutions/fw/util/commons/traceme/TraceMe 
.const [91] = Utf8 msg 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [93] = Utf8 de/esolutions/fw/util/tracing/util/ObjectFactory 
.const [94] = Utf8 map 
.const [95] = Utf8 Ljava/util/Map; 
.const [96] = Utf8 java/lang/Class 
.const [97] = Utf8 getName 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/Class 
.const [100] = Utf8 newInstance 
.const [101] = Utf8 ()Ljava/lang/Object; 
.const [102] = Utf8 java/lang/Object 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 java/util/HashMap 
.const [106] = Utf8 <init> 
.const [107] = Utf8 ()V 
.const [108] = Utf8 de/esolutions/fw/util/tracing/util/ObjectFactory 
.const [109] = Utf8 map 
.const [110] = Utf8 Ljava/util/Map; 
.const [111] = Utf8 java/util/Map 
.const [112] = Utf8 put 
.const [113] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.const [114] = Utf8 java/util/Map 
.const [115] = Utf8 remove 
.const [116] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [117] = Utf8 java/util/Map 
.const [118] = Utf8 get 
.const [119] = Utf8 (Ljava/lang/Object;)Ljava/lang/Object; 
.const [120] = Utf8 de/esolutions/fw/util/tracing/util/ObjectFactory 
.const [121] = Class [120] 
.const [122] = Utf8 java/lang/Object 
.const [123] = Class [122] 
.const [124] = Utf8 chn 
.const [125] = Utf8 Ljava/lang/String; 
.const [126] = Utf8 map 
.const [127] = Utf8 Ljava/util/Map; 
.const [128] = Utf8 Code 
.const [129] = Utf8 <init> 
.const [130] = Utf8 ()V 
.const [131] = Utf8 register 
.const [132] = Utf8 (Ljava/lang/String;Ljava/lang/Class;)V 
.const [133] = Utf8 unregister 
.const [134] = Utf8 (Ljava/lang/String;)V 
.const [135] = Utf8 create 
.const [136] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.end class 
