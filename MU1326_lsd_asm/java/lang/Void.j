.version 50 0 
.class public final super [89] 
.super [91] 
.field public static final [92] [93] 
.field static synthetic [94] [95] 

.method static [97] : [98] 
    .attribute [96] .code stack 3 locals 2 
L0:     aconst_null 
L1:     astore_0 
L2:     getstatic [4] 
L5:     dup 
L6:     ifnonnull L34 
L9:     pop 
        .catch [15] from L10 to L15 using L22 
        .catch [16] from L2 to L52 using L52 
L10:    ldc [5] 
L12:    invokestatic [7] 
L15:    dup 
L16:    putstatic [20] 
L19:    goto L34 
L22:    new [24] 
L25:    dup_x1 
L26:    swap 
L27:    invokevirtual [17] 
L30:    invokespecial [21] 
L33:    athrow 
L34:    ldc [10] 
L36:    iconst_0 
L37:    anewarray [6] 
L40:    invokevirtual [18] 
L43:    astore_1 
L44:    aload_1 
L45:    invokevirtual [19] 
L48:    astore_0 
L49:    goto L58 
L52:    pop 
L53:    ldc [12] 
L55:    invokestatic [14] 
L58:    aload_0 
L59:    putstatic [22] 
L62:    return 
L63:    nop 
L64:    
    .end code 
.end method 

.method private annotation [99] : [100] 
    .attribute [96] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [23] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [25] 
.const [3] = Class [26] 
.const [4] = Field [27] [28] 
.const [5] = String [29] 
.const [6] = Class [30] 
.const [7] = Method [31] [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = String [35] 
.const [11] = Class [36] 
.const [12] = String [37] 
.const [13] = Class [38] 
.const [14] = Method [39] [40] 
.const [15] = Class [41] 
.const [16] = Class [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Field [53] [54] 
.const [23] = Method [55] [56] 
.const [24] = Class [57] 
.const [25] = Utf8 java/lang/Void 
.const [26] = Utf8 java/lang/Object 
.const [27] = Class [58] 
.const [28] = NameAndType [59] [60] 
.const [29] = Utf8 'java.lang.Runnable' 
.const [30] = Utf8 java/lang/Class 
.const [31] = Class [61] 
.const [32] = NameAndType [62] [63] 
.const [33] = Utf8 java/lang/NoClassDefFoundError 
.const [34] = Utf8 java/lang/Throwable 
.const [35] = Utf8 run 
.const [36] = Utf8 java/lang/reflect/Method 
.const [37] = Utf8 'Cannot initialize Void.TYPE\n' 
.const [38] = Utf8 com/ibm/oti/vm/VM 
.const [39] = Class [64] 
.const [40] = NameAndType [65] [66] 
.const [41] = Utf8 java/lang/ClassNotFoundException 
.const [42] = Utf8 java/lang/Exception 
.const [43] = Class [67] 
.const [44] = NameAndType [68] [69] 
.const [45] = Class [70] 
.const [46] = NameAndType [71] [72] 
.const [47] = Class [73] 
.const [48] = NameAndType [74] [75] 
.const [49] = Class [76] 
.const [50] = NameAndType [77] [78] 
.const [51] = Class [79] 
.const [52] = NameAndType [80] [81] 
.const [53] = Class [82] 
.const [54] = NameAndType [83] [84] 
.const [55] = Class [85] 
.const [56] = NameAndType [86] [87] 
.const [57] = Utf8 java/lang/NoClassDefFoundError 
.const [58] = Utf8 java/lang/Void 
.const [59] = Utf8 class$0 
.const [60] = Utf8 Ljava/lang/Class; 
.const [61] = Utf8 java/lang/Class 
.const [62] = Utf8 forName 
.const [63] = Utf8 (Ljava/lang/String;)Ljava/lang/Class; 
.const [64] = Utf8 com/ibm/oti/vm/VM 
.const [65] = Utf8 dumpString 
.const [66] = Utf8 (Ljava/lang/String;)V 
.const [67] = Utf8 java/lang/Throwable 
.const [68] = Utf8 getMessage 
.const [69] = Utf8 ()Ljava/lang/String; 
.const [70] = Utf8 java/lang/Class 
.const [71] = Utf8 getMethod 
.const [72] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [73] = Utf8 java/lang/reflect/Method 
.const [74] = Utf8 getReturnType 
.const [75] = Utf8 ()Ljava/lang/Class; 
.const [76] = Utf8 java/lang/Void 
.const [77] = Utf8 class$0 
.const [78] = Utf8 Ljava/lang/Class; 
.const [79] = Utf8 java/lang/NoClassDefFoundError 
.const [80] = Utf8 <init> 
.const [81] = Utf8 (Ljava/lang/String;)V 
.const [82] = Utf8 java/lang/Void 
.const [83] = Utf8 TYPE 
.const [84] = Utf8 Ljava/lang/Class; 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 java/lang/Void 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 TYPE 
.const [93] = Utf8 Ljava/lang/Class; 
.const [94] = Utf8 class$0 
.const [95] = Utf8 Ljava/lang/Class; 
.const [96] = Utf8 Code 
.const [97] = Utf8 <clinit> 
.const [98] = Utf8 ()V 
.const [99] = Utf8 <init> 
.const [100] = Utf8 ()V 
.end class 
