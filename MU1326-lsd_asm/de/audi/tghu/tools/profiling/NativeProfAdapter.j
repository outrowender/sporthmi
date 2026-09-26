.version 50 0 
.class public final super [73] 
.super [75] 
.field private static [76] [77] 
.field private static [78] [79] 

.method private annotation [81] : [82] 
    .attribute [80] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static synchronized [83] : [84] 
    .attribute [80] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     ifeq L22 
L6:     getstatic [3] 
L9:     ifnonnull L22 
L12:    new [18] 
L15:    dup 
L16:    invokespecial [17] 
L19:    putstatic [16] 
L22:    getstatic [3] 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method native [85] : [86] 
    .attribute [80] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method native [87] : [88] 
    .attribute [80] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static [89] : [90] 
    .attribute [80] .code stack 2 locals 1 
        .catch [7] from L0 to L9 using L12 
L0:     ldc [5] 
L2:     invokestatic [6] 
L5:     iconst_1 
L6:     putstatic [15] 
L9:     goto L25 
L12:    astore_0 
L13:    getstatic [8] 
L16:    ldc [9] 
L18:    invokevirtual [13] 
L21:    iconst_0 
L22:    putstatic [15] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [19] [20] 
.const [3] = Field [21] [22] 
.const [4] = Class [23] 
.const [5] = String [24] 
.const [6] = Method [25] [26] 
.const [7] = Class [27] 
.const [8] = Field [28] [29] 
.const [9] = String [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Class [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Field [38] [39] 
.const [16] = Field [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Class [44] 
.const [19] = Class [45] 
.const [20] = NameAndType [46] [47] 
.const [21] = Class [48] 
.const [22] = NameAndType [49] [50] 
.const [23] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [24] = Utf8 jprof 
.const [25] = Class [51] 
.const [26] = NameAndType [52] [53] 
.const [27] = Utf8 java/lang/UnsatisfiedLinkError 
.const [28] = Class [54] 
.const [29] = NameAndType [55] [56] 
.const [30] = Utf8 'Native Library not found.' 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 java/lang/System 
.const [33] = Utf8 java/io/PrintStream 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
.const [38] = Class [63] 
.const [39] = NameAndType [64] [65] 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [45] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [46] = Utf8 libLoadingSuccessful 
.const [47] = Utf8 Z 
.const [48] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [49] = Utf8 instance 
.const [50] = Utf8 Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [51] = Utf8 java/lang/System 
.const [52] = Utf8 loadLibrary 
.const [53] = Utf8 (Ljava/lang/String;)V 
.const [54] = Utf8 java/lang/System 
.const [55] = Utf8 out 
.const [56] = Utf8 Ljava/io/PrintStream; 
.const [57] = Utf8 java/io/PrintStream 
.const [58] = Utf8 println 
.const [59] = Utf8 (Ljava/lang/String;)V 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [64] = Utf8 libLoadingSuccessful 
.const [65] = Utf8 Z 
.const [66] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [67] = Utf8 instance 
.const [68] = Utf8 Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [69] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [70] = Utf8 <init> 
.const [71] = Utf8 ()V 
.const [72] = Utf8 de/audi/tghu/tools/profiling/NativeProfAdapter 
.const [73] = Class [72] 
.const [74] = Utf8 java/lang/Object 
.const [75] = Class [74] 
.const [76] = Utf8 instance 
.const [77] = Utf8 Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [78] = Utf8 libLoadingSuccessful 
.const [79] = Utf8 Z 
.const [80] = Utf8 Code 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 getInstance 
.const [84] = Utf8 ()Lde/audi/tghu/tools/profiling/NativeProfAdapter; 
.const [85] = Utf8 createKernelUserEvent 
.const [86] = Utf8 (Ljava/lang/String;)V 
.const [87] = Utf8 createKernelUserEvent 
.const [88] = Utf8 (ILjava/lang/String;)V 
.const [89] = Utf8 <clinit> 
.const [90] = Utf8 ()V 
.end class 
