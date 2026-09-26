.version 50 0 
.class final super [87] 
.super [89] 
.implements [91] 
.field final synthetic [92] [93] 
.field private final synthetic [94] [95] 
.field private final synthetic [96] [97] 

.method [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [19] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [20] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [21] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [98] .code stack 3 locals 1 
        .catch [13] from L0 to L31 using L31 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [4] 
L6:     getstatic [6] 
L9:     invokevirtual [16] 
L12:    astore_1 
L13:    aload_1 
L14:    invokevirtual [17] 
L17:    aload_0 
L18:    getfield [15] 
L21:    if_acmpeq L32 
L24:    getstatic [10] 
L27:    areturn 
L28:    goto L32 
L31:    pop 
        .catch [13] from L32 to L63 using L63 
L32:    aload_0 
L33:    getfield [14] 
L36:    ldc [11] 
L38:    getstatic [6] 
L41:    invokevirtual [16] 
L44:    astore_1 
L45:    aload_1 
L46:    invokevirtual [17] 
L49:    aload_0 
L50:    getfield [15] 
L53:    if_acmpeq L64 
L56:    getstatic [10] 
L59:    areturn 
L60:    goto L64 
L63:    pop 
L64:    getstatic [12] 
L67:    areturn 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = Class [23] 
.const [4] = String [24] 
.const [5] = Class [25] 
.const [6] = Field [26] [27] 
.const [7] = Class [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Field [31] [32] 
.const [11] = String [33] 
.const [12] = Field [34] [35] 
.const [13] = Class [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Utf8 java/io/ObjectInputStream$1 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 readFields 
.const [25] = Utf8 java/io/ObjectStreamClass 
.const [26] = Class [53] 
.const [27] = NameAndType [54] [55] 
.const [28] = Utf8 java/lang/Class 
.const [29] = Utf8 java/lang/reflect/Method 
.const [30] = Utf8 java/lang/Boolean 
.const [31] = Class [56] 
.const [32] = NameAndType [57] [58] 
.const [33] = Utf8 readUnshared 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Utf8 java/lang/NoSuchMethodException 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Class [77] 
.const [48] = NameAndType [78] [79] 
.const [49] = Class [80] 
.const [50] = NameAndType [81] [82] 
.const [51] = Class [83] 
.const [52] = NameAndType [84] [85] 
.const [53] = Utf8 java/io/ObjectStreamClass 
.const [54] = Utf8 EMPTY_CONSTRUCTOR_PARAM_TYPES 
.const [55] = Utf8 [Ljava/lang/Class; 
.const [56] = Utf8 java/lang/Boolean 
.const [57] = Utf8 TRUE 
.const [58] = Utf8 Ljava/lang/Boolean; 
.const [59] = Utf8 java/lang/Boolean 
.const [60] = Utf8 FALSE 
.const [61] = Utf8 Ljava/lang/Boolean; 
.const [62] = Utf8 java/io/ObjectInputStream$1 
.const [63] = Utf8 val$implementationClass 
.const [64] = Utf8 Ljava/lang/Class; 
.const [65] = Utf8 java/io/ObjectInputStream$1 
.const [66] = Utf8 val$thisClass 
.const [67] = Utf8 Ljava/lang/Class; 
.const [68] = Utf8 java/lang/Class 
.const [69] = Utf8 getMethod 
.const [70] = Utf8 (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method; 
.const [71] = Utf8 java/lang/reflect/Method 
.const [72] = Utf8 getDeclaringClass 
.const [73] = Utf8 ()Ljava/lang/Class; 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 java/io/ObjectInputStream$1 
.const [78] = Utf8 this$0 
.const [79] = Utf8 Ljava/io/ObjectInputStream; 
.const [80] = Utf8 java/io/ObjectInputStream$1 
.const [81] = Utf8 val$implementationClass 
.const [82] = Utf8 Ljava/lang/Class; 
.const [83] = Utf8 java/io/ObjectInputStream$1 
.const [84] = Utf8 val$thisClass 
.const [85] = Utf8 Ljava/lang/Class; 
.const [86] = Utf8 java/io/ObjectInputStream$1 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 java/security/PrivilegedAction 
.const [91] = Class [90] 
.const [92] = Utf8 this$0 
.const [93] = Utf8 Ljava/io/ObjectInputStream; 
.const [94] = Utf8 val$implementationClass 
.const [95] = Utf8 Ljava/lang/Class; 
.const [96] = Utf8 val$thisClass 
.const [97] = Utf8 Ljava/lang/Class; 
.const [98] = Utf8 Code 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Ljava/io/ObjectInputStream;Ljava/lang/Class;Ljava/lang/Class;)V 
.const [101] = Utf8 run 
.const [102] = Utf8 ()Ljava/lang/Object; 
.end class 
