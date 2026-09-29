.version 50 0 
.class public super [59] 
.super [61] 
.field static [62] [63] 
.field static [64] [65] 

.method public static [67] : [68] 
    .attribute [66] .code stack 2 locals 2 
L0:     getstatic [2] 
L3:     dup 
L4:     astore_0 
L5:     monitorenter 
        .catch [0] from L6 to L27 using L28 
L6:     getstatic [3] 
L9:     ifnonnull L22 
L12:    new [14] 
L15:    dup 
L16:    invokespecial [11] 
L19:    putstatic [10] 
L22:    getstatic [3] 
L25:    aload_0 
L26:    monitorexit 
L27:    areturn 
        .catch [0] from L28 to L31 using L28 
L28:    astore_1 
L29:    aload_0 
L30:    monitorexit 
L31:    aload_1 
L32:    athrow 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method private [69] : [70] 
    .attribute [66] .code stack 3 locals 0 
L0:     aload_0 
L1:     ldc [5] 
L3:     ldc [6] 
L5:     invokespecial [12] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static [71] : [72] 
    .attribute [66] .code stack 2 locals 0 
L0:     new [15] 
L3:     dup 
L4:     invokespecial [13] 
L7:     putstatic [9] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [16] [17] 
.const [3] = Field [18] [19] 
.const [4] = Class [20] 
.const [5] = String [21] 
.const [6] = String [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Field [25] [26] 
.const [10] = Field [27] [28] 
.const [11] = Method [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Method [33] [34] 
.const [14] = Class [35] 
.const [15] = Class [36] 
.const [16] = Class [37] 
.const [17] = NameAndType [38] [39] 
.const [18] = Class [40] 
.const [19] = NameAndType [41] [42] 
.const [20] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [21] = Utf8 tracing 
.const [22] = Utf8 './config' 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 de/esolutions/fw/util/config/ConfigProvider 
.const [25] = Class [43] 
.const [26] = NameAndType [44] [45] 
.const [27] = Class [46] 
.const [28] = NameAndType [47] [48] 
.const [29] = Class [49] 
.const [30] = NameAndType [50] [51] 
.const [31] = Class [52] 
.const [32] = NameAndType [53] [54] 
.const [33] = Class [55] 
.const [34] = NameAndType [56] [57] 
.const [35] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [38] = Utf8 lock 
.const [39] = Utf8 Ljava/lang/Object; 
.const [40] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [41] = Utf8 provider 
.const [42] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfigProvider; 
.const [43] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [44] = Utf8 lock 
.const [45] = Utf8 Ljava/lang/Object; 
.const [46] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [47] = Utf8 provider 
.const [48] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfigProvider; 
.const [49] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [50] = Utf8 <init> 
.const [51] = Utf8 ()V 
.const [52] = Utf8 de/esolutions/fw/util/config/ConfigProvider 
.const [53] = Utf8 <init> 
.const [54] = Utf8 (Ljava/lang/String;Ljava/lang/String;)V 
.const [55] = Utf8 java/lang/Object 
.const [56] = Utf8 <init> 
.const [57] = Utf8 ()V 
.const [58] = Utf8 de/esolutions/fw/util/tracing/config/TraceConfigProvider 
.const [59] = Class [58] 
.const [60] = Utf8 de/esolutions/fw/util/config/ConfigProvider 
.const [61] = Class [60] 
.const [62] = Utf8 provider 
.const [63] = Utf8 Lde/esolutions/fw/util/tracing/config/TraceConfigProvider; 
.const [64] = Utf8 lock 
.const [65] = Utf8 Ljava/lang/Object; 
.const [66] = Utf8 Code 
.const [67] = Utf8 getInstance 
.const [68] = Utf8 ()Lde/esolutions/fw/util/tracing/config/TraceConfigProvider; 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 <clinit> 
.const [72] = Utf8 ()V 
.end class 
