.version 50 0 
.class public super [85] 
.super [87] 
.field public [88] [89] 
.field public [90] [91] 
.field public [92] [93] 

.method public annotation [95] : [96] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     iload_2 
L7:     iload_3 
L8:     invokevirtual [6] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aload_1 
L6:     invokevirtual [7] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [101] : [102] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [15] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [16] 
L10:    aload_0 
L11:    iload_3 
L12:    putfield [17] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     getfield [8] 
L5:     aload_1 
L6:     getfield [9] 
L9:     aload_1 
L10:    getfield [10] 
L13:    invokevirtual [6] 
L16:    return 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [15] 
L5:     aload_0 
L6:     iconst_0 
L7:     putfield [16] 
L10:    aload_0 
L11:    iconst_m1 
L12:    putfield [17] 
L15:    return 
L16:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [94] .code stack 4 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     getfield [10] 
L10:    iload_3 
L11:    if_icmpeq L16 
L14:    iconst_0 
L15:    areturn 
L16:    iconst_0 
L17:    istore 4 
L19:    iload 4 
L21:    iload_3 
L22:    if_icmpge L54 
L25:    aload_0 
L26:    getfield [8] 
L29:    aload_0 
L30:    getfield [9] 
L33:    iload 4 
L35:    iadd 
L36:    caload 
L37:    aload_1 
L38:    iload_2 
L39:    iload 4 
L41:    iadd 
L42:    caload 
L43:    if_icmpeq L48 
L46:    iconst_0 
L47:    areturn 
L48:    iinc 4 1 
L51:    goto L19 
L54:    iconst_1 
L55:    areturn 
L56:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [94] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L6 
L4:     iconst_0 
L5:     areturn 
L6:     aload_0 
L7:     getfield [10] 
L10:    aload_1 
L11:    invokevirtual [11] 
L14:    if_icmpeq L19 
L17:    iconst_0 
L18:    areturn 
L19:    iconst_0 
L20:    istore_2 
L21:    iload_2 
L22:    aload_0 
L23:    getfield [10] 
L26:    if_icmpge L56 
L29:    aload_0 
L30:    getfield [8] 
L33:    aload_0 
L34:    getfield [9] 
L37:    iload_2 
L38:    iadd 
L39:    caload 
L40:    aload_1 
L41:    iload_2 
L42:    invokevirtual [12] 
L45:    if_icmpeq L50 
L48:    iconst_0 
L49:    areturn 
L50:    iinc 2 1 
L53:    goto L21 
L56:    iconst_1 
L57:    areturn 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [111] : [112] 
    .attribute [94] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     ifle L29 
L7:     new [18] 
L10:    dup 
L11:    aload_0 
L12:    getfield [8] 
L15:    aload_0 
L16:    getfield [9] 
L19:    aload_0 
L20:    getfield [10] 
L23:    invokespecial [14] 
L26:    goto L31 
L29:    ldc [3] 
L31:    areturn 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [19] 
.const [3] = String [20] 
.const [4] = Class [21] 
.const [5] = Class [22] 
.const [6] = Method [23] [24] 
.const [7] = Method [25] [26] 
.const [8] = Field [27] [28] 
.const [9] = Field [29] [30] 
.const [10] = Field [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Method [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Class [47] 
.const [19] = Utf8 java/lang/String 
.const [20] = Utf8 '' 
.const [21] = Utf8 org/apache/xerces/xni/XMLString 
.const [22] = Utf8 java/lang/Object 
.const [23] = Class [48] 
.const [24] = NameAndType [49] [50] 
.const [25] = Class [51] 
.const [26] = NameAndType [52] [53] 
.const [27] = Class [54] 
.const [28] = NameAndType [55] [56] 
.const [29] = Class [57] 
.const [30] = NameAndType [58] [59] 
.const [31] = Class [60] 
.const [32] = NameAndType [61] [62] 
.const [33] = Class [63] 
.const [34] = NameAndType [64] [65] 
.const [35] = Class [66] 
.const [36] = NameAndType [67] [68] 
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
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 org/apache/xerces/xni/XMLString 
.const [49] = Utf8 setValues 
.const [50] = Utf8 ([CII)V 
.const [51] = Utf8 org/apache/xerces/xni/XMLString 
.const [52] = Utf8 setValues 
.const [53] = Utf8 (Lorg/apache/xerces/xni/XMLString;)V 
.const [54] = Utf8 org/apache/xerces/xni/XMLString 
.const [55] = Utf8 ch 
.const [56] = Utf8 [C 
.const [57] = Utf8 org/apache/xerces/xni/XMLString 
.const [58] = Utf8 offset 
.const [59] = Utf8 I 
.const [60] = Utf8 org/apache/xerces/xni/XMLString 
.const [61] = Utf8 length 
.const [62] = Utf8 I 
.const [63] = Utf8 java/lang/String 
.const [64] = Utf8 length 
.const [65] = Utf8 ()I 
.const [66] = Utf8 java/lang/String 
.const [67] = Utf8 charAt 
.const [68] = Utf8 (I)C 
.const [69] = Utf8 java/lang/Object 
.const [70] = Utf8 <init> 
.const [71] = Utf8 ()V 
.const [72] = Utf8 java/lang/String 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ([CII)V 
.const [75] = Utf8 org/apache/xerces/xni/XMLString 
.const [76] = Utf8 ch 
.const [77] = Utf8 [C 
.const [78] = Utf8 org/apache/xerces/xni/XMLString 
.const [79] = Utf8 offset 
.const [80] = Utf8 I 
.const [81] = Utf8 org/apache/xerces/xni/XMLString 
.const [82] = Utf8 length 
.const [83] = Utf8 I 
.const [84] = Utf8 org/apache/xerces/xni/XMLString 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 ch 
.const [89] = Utf8 [C 
.const [90] = Utf8 offset 
.const [91] = Utf8 I 
.const [92] = Utf8 length 
.const [93] = Utf8 I 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 ()V 
.const [97] = Utf8 <init> 
.const [98] = Utf8 ([CII)V 
.const [99] = Utf8 <init> 
.const [100] = Utf8 (Lorg/apache/xerces/xni/XMLString;)V 
.const [101] = Utf8 setValues 
.const [102] = Utf8 ([CII)V 
.const [103] = Utf8 setValues 
.const [104] = Utf8 (Lorg/apache/xerces/xni/XMLString;)V 
.const [105] = Utf8 clear 
.const [106] = Utf8 ()V 
.const [107] = Utf8 equals 
.const [108] = Utf8 ([CII)Z 
.const [109] = Utf8 equals 
.const [110] = Utf8 (Ljava/lang/String;)Z 
.const [111] = Utf8 toString 
.const [112] = Utf8 ()Ljava/lang/String; 
.end class 
