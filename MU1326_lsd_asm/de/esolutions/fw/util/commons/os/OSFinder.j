.version 50 0 
.class public final super [85] 
.super [87] 
.field public static final [88] [89] 
.field private [90] [91] 
.field private [92] [93] 
.field private static [94] [95] 

.method public static synchronized [97] : [98] 
    .attribute [96] .code stack 2 locals 0 
L0:     getstatic [2] 
L3:     ifnonnull L16 
L6:     new [18] 
L9:     dup 
L10:    invokespecial [16] 
L13:    putstatic [15] 
L16:    getstatic [2] 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private [99] : [100] 
    .attribute [96] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokespecial [17] 
        .catch [8] from L4 to L39 using L42 
L4:     aload_0 
L5:     ldc [4] 
L7:     invokestatic [5] 
L10:    putfield [19] 
L13:    iconst_0 
L14:    anewarray [6] 
L17:    astore_1 
L18:    aload_0 
L19:    getfield [11] 
L22:    ldc [7] 
L24:    aload_1 
L25:    invokevirtual [12] 
L28:    astore_2 
L29:    aload_0 
L30:    aload_2 
L31:    aconst_null 
L32:    aconst_null 
L33:    invokevirtual [13] 
L36:    putfield [20] 
L39:    goto L53 
L42:    astore_1 
L43:    aload_0 
L44:    aconst_null 
L45:    putfield [20] 
L48:    aload_0 
L49:    aconst_null 
L50:    putfield [19] 
L53:    return 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public final interface [101] : [102] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public final interface [103] : [104] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [21] [22] 
.const [3] = Class [23] 
.const [4] = String [24] 
.const [5] = Method [25] [26] 
.const [6] = Class [27] 
.const [7] = String [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Field [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Class [46] 
.const [19] = Field [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Class [51] 
.const [22] = NameAndType [52] [53] 
.const [23] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [24] = Utf8 'de.esolutions.fw.util.os.OS' 
.const [25] = Class [54] 
.const [26] = NameAndType [55] [56] 
.const [27] = Utf8 java/lang/Class 
.const [28] = Utf8 getInstance 
.const [29] = Utf8 java/lang/Exception 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 java/lang/reflect/Method 
.const [32] = Class [57] 
.const [33] = NameAndType [58] [59] 
.const [34] = Class [60] 
.const [35] = NameAndType [61] [62] 
.const [36] = Class [63] 
.const [37] = NameAndType [64] [65] 
.const [38] = Class [66] 
.const [39] = NameAndType [67] [68] 
.const [40] = Class [69] 
.const [41] = NameAndType [70] [71] 
.const [42] = Class [72] 
.const [43] = NameAndType [73] [74] 
.const [44] = Class [75] 
.const [45] = NameAndType [76] [77] 
.const [46] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [52] = Utf8 instance 
.const [53] = Utf8 Lde/esolutions/fw/util/commons/os/OSFinder; 
.const [54] = Utf8 java/lang/Class 
.const [55] = Utf8 forName 
.const [56] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [57] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [58] = Utf8 osClass 
.const [59] = Utf8 Ljava/lang/Class; 
.const [60] = Utf8 java/lang/Class 
.const [61] = Utf8 getDeclaredMethod 
.const [62] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [63] = Utf8 java/lang/reflect/Method 
.const [64] = Utf8 invoke 
.const [65] = Utf8 (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object; 
.const [66] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [67] = Utf8 osInstance 
.const [68] = Utf8 Ljava/lang/Object; 
.const [69] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [70] = Utf8 instance 
.const [71] = Utf8 Lde/esolutions/fw/util/commons/os/OSFinder; 
.const [72] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [79] = Utf8 osClass 
.const [80] = Utf8 Ljava/lang/Class; 
.const [81] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [82] = Utf8 osInstance 
.const [83] = Utf8 Ljava/lang/Object; 
.const [84] = Utf8 de/esolutions/fw/util/commons/os/OSFinder 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 OSClassName 
.const [89] = Utf8 Ljava/lang/String; 
.const [90] = Utf8 osClass 
.const [91] = Utf8 Ljava/lang/Class; 
.const [92] = Utf8 osInstance 
.const [93] = Utf8 Ljava/lang/Object; 
.const [94] = Utf8 instance 
.const [95] = Utf8 Lde/esolutions/fw/util/commons/os/OSFinder; 
.const [96] = Utf8 Code 
.const [97] = Utf8 getInstance 
.const [98] = Utf8 ()Lde/esolutions/fw/util/commons/os/OSFinder; 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.const [101] = Utf8 getOSInstance 
.const [102] = Utf8 ()Ljava/lang/Object; 
.const [103] = Utf8 getOSClass 
.const [104] = Utf8 ()Ljava/lang/Class; 
.end class 
