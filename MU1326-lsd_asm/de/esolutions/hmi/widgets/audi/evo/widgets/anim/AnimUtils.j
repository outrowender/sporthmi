.version 50 0 
.class public super [81] 
.super [83] 
.field public static final [84] [85] 
.field public static final [86] [87] 

.method public annotation [89] : [90] 
    .attribute [88] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [91] : [92] 
    .attribute [88] .code stack 3 locals 0 
L0:     new [20] 
L3:     dup 
L4:     invokespecial [19] 
L7:     iload_0 
L8:     iflt L27 
L11:    aload_1 
L12:    ifnull L27 
L15:    iload_0 
L16:    aload_1 
L17:    arraylength 
L18:    if_icmpge L27 
L21:    aload_1 
L22:    iload_0 
L23:    aaload 
L24:    goto L29 
L27:    ldc [3] 
L29:    invokevirtual [15] 
L32:    ldc [4] 
L34:    invokevirtual [15] 
L37:    iload_0 
L38:    invokevirtual [16] 
L41:    ldc [5] 
L43:    invokevirtual [15] 
L46:    invokevirtual [17] 
L49:    areturn 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [93] : [94] 
    .attribute [88] .code stack 2 locals 0 
L0:     fload_0 
L1:     fload_2 
L2:     invokestatic [6] 
L5:     fload_1 
L6:     invokestatic [7] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [95] : [96] 
    .attribute [88] .code stack 2 locals 0 
L0:     iload_0 
L1:     iload_2 
L2:     invokestatic [8] 
L5:     iload_1 
L6:     invokestatic [9] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public static [97] : [98] 
    .attribute [88] .code stack 3 locals 3 
L0:     fconst_1 
L1:     fstore_3 
L2:     fload_0 
L3:     fload_1 
L4:     fcmpl 
L5:     ifeq L33 
L8:     fload_0 
L9:     fload_1 
L10:    invokestatic [7] 
L13:    fstore 4 
L15:    fload_0 
L16:    fload_1 
L17:    invokestatic [6] 
L20:    fstore 5 
L22:    fload_2 
L23:    fload 4 
L25:    fsub 
L26:    fload 5 
L28:    fload 4 
L30:    fsub 
L31:    fdiv 
L32:    fstore_3 
L33:    fload_3 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 

.method public static [99] : [100] 
    .attribute [88] .code stack 3 locals 3 
L0:     fconst_1 
L1:     fstore_3 
L2:     fload_0 
L3:     fload_1 
L4:     fcmpl 
L5:     ifeq L47 
L8:     fload_0 
L9:     fload_1 
L10:    invokestatic [7] 
L13:    fstore 4 
L15:    fload_0 
L16:    fload_1 
L17:    invokestatic [6] 
L20:    fstore 5 
L22:    fload_0 
L23:    fload 4 
L25:    fcmpl 
L26:    ifeq L36 
L29:    fload 5 
L31:    fload_2 
L32:    fsub 
L33:    goto L40 
L36:    fload_2 
L37:    fload 4 
L39:    fsub 
L40:    fload 5 
L42:    fload 4 
L44:    fsub 
L45:    fdiv 
L46:    fstore_3 
L47:    fload_3 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public static [101] : [102] 
    .attribute [88] .code stack 3 locals 5 
L0:     fload_0 
L1:     fstore_3 
L2:     fload_0 
L3:     fload_1 
L4:     invokestatic [7] 
L7:     fstore 4 
L9:     fload_0 
L10:    fload_1 
L11:    invokestatic [6] 
L14:    fstore 5 
L16:    fload 5 
L18:    fload 4 
L20:    fsub 
L21:    fstore 6 
L23:    fconst_0 
L24:    fconst_1 
L25:    fload_2 
L26:    invokestatic [10] 
L29:    fstore 7 
L31:    fload 4 
L33:    fload_0 
L34:    fcmpl 
L35:    ifeq L45 
L38:    fconst_1 
L39:    fload 7 
L41:    fsub 
L42:    goto L47 
L45:    fload 7 
L47:    fstore 7 
L49:    fload 4 
L51:    fload 6 
L53:    fload 7 
L55:    fmul 
L56:    fadd 
L57:    fstore_3 
L58:    fload_3 
L59:    areturn 
L60:    
    .end code 
.end method 

.method public static [103] : [104] 
    .attribute [88] .code stack 3 locals 0 
L0:     fload_2 
L1:     fload_0 
L2:     fload_1 
L3:     invokestatic [7] 
L6:     fcmpl 
L7:     iflt L24 
L10:    fload_2 
L11:    fload_0 
L12:    fload_1 
L13:    invokestatic [6] 
L16:    fcmpg 
L17:    ifgt L24 
L20:    iconst_1 
L21:    goto L25 
L24:    iconst_0 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public static [105] : [106] 
    .attribute [88] .code stack 2 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            0 : L28 
            1 : L34 
            default : L40 

L28:    fload_1 
L29:    fload_2 
L30:    invokestatic [7] 
L33:    areturn 
L34:    fload_1 
L35:    fload_2 
L36:    invokestatic [6] 
L39:    areturn 
L40:    fconst_0 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public static [107] : [108] 
    .attribute [88] .code stack 2 locals 0 
L0:     iload_0 
L1:     lookupswitch 
            0 : L28 
            1 : L34 
            default : L40 

L28:    fload_1 
L29:    fload_2 
L30:    invokestatic [6] 
L33:    areturn 
L34:    fload_1 
L35:    fload_2 
L36:    invokestatic [7] 
L39:    areturn 
L40:    fconst_0 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [21] 
.const [3] = String [22] 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = Method [25] [26] 
.const [7] = Method [27] [28] 
.const [8] = Method [29] [30] 
.const [9] = Method [31] [32] 
.const [10] = Method [33] [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = String [37] 
.const [14] = Class [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Class [49] 
.const [21] = Utf8 java/lang/StringBuffer 
.const [22] = Utf8 NO_VALUE_TO_STRING_MAPPING 
.const [23] = Utf8 ' ( ' 
.const [24] = Utf8 ' )' 
.const [25] = Class [50] 
.const [26] = NameAndType [51] [52] 
.const [27] = Class [53] 
.const [28] = NameAndType [54] [55] 
.const [29] = Class [56] 
.const [30] = NameAndType [57] [58] 
.const [31] = Class [59] 
.const [32] = NameAndType [60] [61] 
.const [33] = Class [62] 
.const [34] = NameAndType [63] [64] 
.const [35] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/anim/AnimUtils 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 '<UNKNOWN::>' 
.const [38] = Utf8 java/lang/Math 
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
.const [49] = Utf8 java/lang/StringBuffer 
.const [50] = Utf8 java/lang/Math 
.const [51] = Utf8 max 
.const [52] = Utf8 (FF)F 
.const [53] = Utf8 java/lang/Math 
.const [54] = Utf8 min 
.const [55] = Utf8 (FF)F 
.const [56] = Utf8 java/lang/Math 
.const [57] = Utf8 max 
.const [58] = Utf8 (II)I 
.const [59] = Utf8 java/lang/Math 
.const [60] = Utf8 min 
.const [61] = Utf8 (II)I 
.const [62] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/anim/AnimUtils 
.const [63] = Utf8 clamp 
.const [64] = Utf8 (FFF)F 
.const [65] = Utf8 java/lang/StringBuffer 
.const [66] = Utf8 append 
.const [67] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [68] = Utf8 java/lang/StringBuffer 
.const [69] = Utf8 append 
.const [70] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [71] = Utf8 java/lang/StringBuffer 
.const [72] = Utf8 toString 
.const [73] = Utf8 ()Ljava/lang/String; 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 java/lang/StringBuffer 
.const [78] = Utf8 <init> 
.const [79] = Utf8 ()V 
.const [80] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/anim/AnimUtils 
.const [81] = Class [80] 
.const [82] = Utf8 java/lang/Object 
.const [83] = Class [82] 
.const [84] = Utf8 NULL_PREFIX 
.const [85] = Utf8 Ljava/lang/String; 
.const [86] = Utf8 NO_VALUE_TO_STRING_MAPPING 
.const [87] = Utf8 Ljava/lang/String; 
.const [88] = Utf8 Code 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 valueToString 
.const [92] = Utf8 (I[Ljava/lang/String;)Ljava/lang/String; 
.const [93] = Utf8 clamp 
.const [94] = Utf8 (FFF)F 
.const [95] = Utf8 clamp 
.const [96] = Utf8 (III)I 
.const [97] = Utf8 norm1 
.const [98] = Utf8 (FFF)F 
.const [99] = Utf8 getNormalizedProgress 
.const [100] = Utf8 (FFF)F 
.const [101] = Utf8 lerp1 
.const [102] = Utf8 (FFF)F 
.const [103] = Utf8 isValueInBounds 
.const [104] = Utf8 (FFF)Z 
.const [105] = Utf8 idxMinMax 
.const [106] = Utf8 (IFF)F 
.const [107] = Utf8 idxMaxMin 
.const [108] = Utf8 (IFF)F 
.end class 
