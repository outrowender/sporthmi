.version 50 0 
.class public final super [69] 
.super [71] 

.method public annotation [73] : [74] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [75] : [76] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L11 
L4:     aload_0 
L5:     invokevirtual [8] 
L8:     ifne L15 
L11:    iconst_1 
L12:    goto L16 
L15:    iconst_0 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public static [77] : [78] 
    .attribute [72] .code stack 4 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [8] 
L10:    iconst_2 
L11:    if_icmpgt L17 
L14:    ldc [2] 
L16:    areturn 
L17:    aload_0 
L18:    iconst_1 
L19:    aload_0 
L20:    invokevirtual [8] 
L23:    iconst_1 
L24:    isub 
L25:    invokevirtual [9] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public static [79] : [80] 
    .attribute [72] .code stack 2 locals 3 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     new [16] 
L9:     dup 
L10:    invokespecial [15] 
L13:    astore_1 
L14:    iconst_0 
L15:    istore_2 
L16:    iload_2 
L17:    aload_0 
L18:    invokevirtual [8] 
L21:    if_icmpge L49 
L24:    aload_0 
L25:    iload_2 
L26:    invokevirtual [10] 
L29:    istore_3 
L30:    iload_3 
L31:    invokestatic [4] 
L34:    ifeq L43 
L37:    aload_1 
L38:    iload_3 
L39:    invokevirtual [11] 
L42:    pop 
L43:    iinc 2 1 
L46:    goto L16 
L49:    aload_1 
L50:    invokevirtual [12] 
L53:    areturn 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method public static [81] : [82] 
    .attribute [72] .code stack 2 locals 2 
L0:     aload_0 
L1:     ifnull L12 
L4:     aload_0 
L5:     invokevirtual [8] 
L8:     iconst_2 
L9:     if_icmpge L14 
L12:    iconst_0 
L13:    areturn 
L14:    iconst_0 
L15:    istore_1 
L16:    iload_1 
L17:    aload_0 
L18:    invokevirtual [8] 
L21:    if_icmpge L61 
L24:    aload_0 
L25:    iload_1 
L26:    invokevirtual [10] 
L29:    istore_2 
L30:    iload_2 
L31:    invokestatic [4] 
L34:    ifne L55 
L37:    iload_1 
L38:    ifne L47 
L41:    iload_2 
L42:    bipush 43 
L44:    if_icmpeq L55 
L47:    iload_2 
L48:    bipush 32 
L50:    if_icmpeq L55 
L53:    iconst_0 
L54:    areturn 
L55:    iinc 1 1 
L58:    goto L16 
L61:    iconst_1 
L62:    areturn 
L63:    nop 
L64:    
    .end code 
.end method 

.method public static [83] : [84] 
    .attribute [72] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnonnull L6 
L4:     aconst_null 
L5:     areturn 
L6:     aload_0 
L7:     invokevirtual [8] 
L10:    ifne L16 
L13:    ldc [2] 
L15:    areturn 
L16:    aload_0 
L17:    invokevirtual [13] 
L20:    areturn 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [17] 
.const [3] = Class [18] 
.const [4] = Method [19] [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Method [24] [25] 
.const [9] = Method [26] [27] 
.const [10] = Method [28] [29] 
.const [11] = Method [30] [31] 
.const [12] = Method [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Class [40] 
.const [17] = Utf8 '' 
.const [18] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [19] = Class [41] 
.const [20] = NameAndType [42] [43] 
.const [21] = Utf8 java/lang/Object 
.const [22] = Utf8 java/lang/String 
.const [23] = Utf8 java/lang/Character 
.const [24] = Class [44] 
.const [25] = NameAndType [45] [46] 
.const [26] = Class [47] 
.const [27] = NameAndType [48] [49] 
.const [28] = Class [50] 
.const [29] = NameAndType [51] [52] 
.const [30] = Class [53] 
.const [31] = NameAndType [54] [55] 
.const [32] = Class [56] 
.const [33] = NameAndType [57] [58] 
.const [34] = Class [59] 
.const [35] = NameAndType [60] [61] 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [41] = Utf8 java/lang/Character 
.const [42] = Utf8 isDigit 
.const [43] = Utf8 (C)Z 
.const [44] = Utf8 java/lang/String 
.const [45] = Utf8 length 
.const [46] = Utf8 ()I 
.const [47] = Utf8 java/lang/String 
.const [48] = Utf8 substring 
.const [49] = Utf8 (II)Ljava/lang/String; 
.const [50] = Utf8 java/lang/String 
.const [51] = Utf8 charAt 
.const [52] = Utf8 (I)C 
.const [53] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [54] = Utf8 append 
.const [55] = Utf8 (C)Lde/esolutions/fw/util/commons/Buffer; 
.const [56] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [57] = Utf8 toString 
.const [58] = Utf8 ()Ljava/lang/String; 
.const [59] = Utf8 java/lang/String 
.const [60] = Utf8 trim 
.const [61] = Utf8 ()Ljava/lang/String; 
.const [62] = Utf8 java/lang/Object 
.const [63] = Utf8 <init> 
.const [64] = Utf8 ()V 
.const [65] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/audi/app/messaging/core/util/Strings 
.const [69] = Class [68] 
.const [70] = Utf8 java/lang/Object 
.const [71] = Class [70] 
.const [72] = Utf8 Code 
.const [73] = Utf8 <init> 
.const [74] = Utf8 ()V 
.const [75] = Utf8 isNullOrEmpty 
.const [76] = Utf8 (Ljava/lang/String;)Z 
.const [77] = Utf8 removeFirstAndLastChar 
.const [78] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [79] = Utf8 removeNonNumericChars 
.const [80] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [81] = Utf8 isValidNumber 
.const [82] = Utf8 (Ljava/lang/String;)Z 
.const [83] = Utf8 trimForSingleLineDisplay 
.const [84] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.end class 
