.version 50 0 
.class public super [78] 
.super [80] 
.implements [82] 
.field private static final [83] [84] 
.field private static final [85] [86] 
.field private static final [87] [88] 
.field private static final [89] [90] 
.field private static final [91] [92] 
.field private static final [93] [94] 
.field private static final [95] [96] 
.field private static final [97] [98] 
.field private [99] [100] 
.field private [101] [102] 
.field private [103] [104] 

.method [106] : [107] 
    .attribute [105] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [14] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [15] 
L14:    aload_0 
L15:    iconst_m1 
L16:    bipush 32 
L18:    aload_0 
L19:    getfield [6] 
L22:    isub 
L23:    iushr 
L24:    putfield [16] 
L27:    return 
L28:    
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [105] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     aload_0 
L5:     iload_2 
L6:     putfield [14] 
L9:     aload_0 
L10:    iload_1 
L11:    putfield [15] 
L14:    aload_0 
L15:    iconst_m1 
L16:    bipush 32 
L18:    iload_2 
L19:    isub 
L20:    iushr 
L21:    putfield [16] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [110] : [111] 
    .attribute [105] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 32 
L3:     invokespecial [12] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [112] : [113] 
    .attribute [105] .code stack 4 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [7] 
L5:     bipush 8 
L7:     ishl 
L8:     putfield [15] 
L11:    aload_0 
L12:    dup 
L13:    getfield [7] 
L16:    iload_1 
L17:    sipush 255 
L20:    iand 
L21:    ior 
L22:    putfield [15] 
L25:    aload_0 
L26:    dup 
L27:    getfield [7] 
L30:    aload_0 
L31:    getfield [8] 
L34:    iand 
L35:    putfield [15] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [114] : [115] 
    .attribute [105] .code stack 4 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [7] 
L5:     bipush 16 
L7:     ishl 
L8:     putfield [15] 
L11:    aload_0 
L12:    dup 
L13:    getfield [7] 
L16:    iload_1 
L17:    ldc [2] 
L19:    iand 
L20:    ior 
L21:    putfield [15] 
L24:    aload_0 
L25:    dup 
L26:    getfield [7] 
L29:    aload_0 
L30:    getfield [8] 
L33:    iand 
L34:    putfield [15] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [116] : [117] 
    .attribute [105] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     aload_0 
L3:     getfield [8] 
L6:     iand 
L7:     putfield [15] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [118] : [119] 
    .attribute [105] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     iload_1 
L3:     ifeq L10 
L6:     iconst_1 
L7:     goto L11 
L10:    iconst_0 
L11:    invokevirtual [9] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [120] : [121] 
    .attribute [105] .code stack 4 locals 2 
L0:     aload_1 
L1:     arraylength 
L2:     istore_2 
L3:     iconst_0 
L4:     istore_3 
L5:     iload_3 
L6:     iload_2 
L7:     if_icmpge L25 
L10:    aload_0 
L11:    bipush 8 
L13:    aload_1 
L14:    iload_3 
L15:    baload 
L16:    invokevirtual [9] 
L19:    iinc 3 1 
L22:    goto L5 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [122] : [123] 
    .attribute [105] .code stack 6 locals 0 
L0:     iload_1 
L1:     bipush 32 
L3:     if_icmpne L14 
L6:     aload_0 
L7:     iload_2 
L8:     putfield [15] 
L11:    goto L41 
L14:    aload_0 
L15:    dup 
L16:    getfield [7] 
L19:    iload_1 
L20:    ishl 
L21:    putfield [15] 
L24:    aload_0 
L25:    dup 
L26:    getfield [7] 
L29:    iload_2 
L30:    iconst_m1 
L31:    bipush 32 
L33:    iload_1 
L34:    isub 
L35:    iushr 
L36:    iand 
L37:    ior 
L38:    putfield [15] 
L41:    aload_0 
L42:    dup 
L43:    getfield [7] 
L46:    aload_0 
L47:    getfield [8] 
L50:    iand 
L51:    putfield [15] 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public [124] : [125] 
    .attribute [105] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iconst_0 
L3:     invokevirtual [9] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [126] : [127] 
    .attribute [105] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [128] : [129] 
    .attribute [105] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [130] : [131] 
    .attribute [105] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_2 
L2:     putfield [14] 
L5:     aload_0 
L6:     iload_1 
L7:     putfield [15] 
L10:    aload_0 
L11:    iconst_m1 
L12:    bipush 32 
L14:    aload_0 
L15:    getfield [6] 
L18:    isub 
L19:    iushr 
L20:    putfield [16] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [132] : [133] 
    .attribute [105] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     istore_2 
L5:     iload_1 
L6:     aload_0 
L7:     getfield [6] 
L10:    if_icmple L21 
L13:    new [17] 
L16:    dup 
L17:    invokespecial [13] 
L20:    athrow 
L21:    iload_1 
L22:    bipush 32 
L24:    if_icmpge L44 
L27:    iload_2 
L28:    bipush 32 
L30:    aload_0 
L31:    getfield [6] 
L34:    isub 
L35:    ishl 
L36:    istore_2 
L37:    iload_2 
L38:    bipush 32 
L40:    iload_1 
L41:    isub 
L42:    iushr 
L43:    istore_2 
L44:    aload_0 
L45:    dup 
L46:    getfield [7] 
L49:    iload_1 
L50:    ishl 
L51:    putfield [15] 
L54:    aload_0 
L55:    dup 
L56:    getfield [7] 
L59:    aload_0 
L60:    getfield [8] 
L63:    iand 
L64:    putfield [15] 
L67:    iload_2 
L68:    areturn 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [134] : [135] 
    .attribute [105] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [7] 
L5:     iload_1 
L6:     ishl 
L7:     putfield [15] 
L10:    aload_0 
L11:    dup 
L12:    getfield [7] 
L15:    aload_0 
L16:    getfield [8] 
L19:    iand 
L20:    putfield [15] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [136] : [137] 
    .attribute [105] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [10] 
L5:     iconst_1 
L6:     if_icmpne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [105] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 8 
L3:     invokevirtual [10] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [105] .code stack 4 locals 5 
L0:     iload_1 
L1:     iconst_4 
L2:     if_icmpge L9 
L5:     iload_1 
L6:     goto L10 
L9:     iconst_4 
L10:    istore_2 
L11:    iload_2 
L12:    bipush 8 
L14:    imul 
L15:    istore_3 
L16:    aload_0 
L17:    getfield [7] 
L20:    bipush 32 
L22:    iload_3 
L23:    isub 
L24:    iushr 
L25:    istore 4 
L27:    iload_1 
L28:    newarray byte 
L30:    astore 5 
L32:    iload_2 
L33:    iconst_1 
L34:    isub 
L35:    istore 6 
L37:    iload 6 
L39:    iflt L67 
L42:    aload 5 
L44:    iload 6 
L46:    iload 4 
L48:    sipush 255 
L51:    iand 
L52:    i2b 
L53:    bastore 
L54:    iload 4 
L56:    bipush 8 
L58:    iushr 
L59:    istore 4 
L61:    iinc 6 -1 
L64:    goto L37 
L67:    aload_0 
L68:    dup 
L69:    getfield [7] 
L72:    iload_3 
L73:    ishl 
L74:    putfield [15] 
L77:    aload 5 
L79:    areturn 
L80:    
    .end code 
.end method 

.method public [142] : [143] 
    .attribute [105] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     aload_0 
L5:     getfield [8] 
L8:     iand 
L9:     istore_1 
L10:    aload_0 
L11:    iconst_0 
L12:    putfield [15] 
L15:    iload_1 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [144] : [145] 
    .attribute [105] .code stack 3 locals 1 
L0:     aload_0 
L1:     getfield [6] 
L4:     bipush 16 
L6:     if_icmpgt L31 
L9:     aload_0 
L10:    getfield [7] 
L13:    ldc [2] 
L15:    iand 
L16:    istore_1 
L17:    aload_0 
L18:    dup 
L19:    getfield [7] 
L22:    bipush 16 
L24:    ishr 
L25:    putfield [15] 
L28:    goto L50 
L31:    aload_0 
L32:    getfield [7] 
L35:    bipush 16 
L37:    iushr 
L38:    istore_1 
L39:    aload_0 
L40:    dup 
L41:    getfield [7] 
L44:    bipush 16 
L46:    ishl 
L47:    putfield [15] 
L50:    iload_1 
L51:    areturn 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -65536 
.const [3] = Class [18] 
.const [4] = Class [19] 
.const [5] = Class [20] 
.const [6] = Field [21] [22] 
.const [7] = Field [23] [24] 
.const [8] = Field [25] [26] 
.const [9] = Method [27] [28] 
.const [10] = Method [29] [30] 
.const [11] = Method [31] [32] 
.const [12] = Method [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Field [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Class [43] 
.const [18] = Utf8 java/nio/BufferUnderflowException 
.const [19] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [20] = Utf8 java/lang/Object 
.const [21] = Class [44] 
.const [22] = NameAndType [45] [46] 
.const [23] = Class [47] 
.const [24] = NameAndType [48] [49] 
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
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Utf8 java/nio/BufferUnderflowException 
.const [44] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [45] = Utf8 bitSize 
.const [46] = Utf8 I 
.const [47] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [48] = Utf8 bitsData 
.const [49] = Utf8 I 
.const [50] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [51] = Utf8 bitsMask 
.const [52] = Utf8 I 
.const [53] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [54] = Utf8 pushBits 
.const [55] = Utf8 (II)V 
.const [56] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [57] = Utf8 popFrontBits 
.const [58] = Utf8 (I)I 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 <init> 
.const [61] = Utf8 ()V 
.const [62] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (I)V 
.const [65] = Utf8 java/nio/BufferUnderflowException 
.const [66] = Utf8 <init> 
.const [67] = Utf8 ()V 
.const [68] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [69] = Utf8 bitSize 
.const [70] = Utf8 I 
.const [71] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [72] = Utf8 bitsData 
.const [73] = Utf8 I 
.const [74] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [75] = Utf8 bitsMask 
.const [76] = Utf8 I 
.const [77] = Utf8 de/vw/mib/bap/stream/IntegerStream 
.const [78] = Class [77] 
.const [79] = Utf8 java/lang/Object 
.const [80] = Class [79] 
.const [81] = Utf8 de/vw/mib/bap/stream/BitStream 
.const [82] = Class [81] 
.const [83] = Utf8 INT_MASK 
.const [84] = Utf8 I 
.const [85] = Utf8 SHORT_MASK 
.const [86] = Utf8 I 
.const [87] = Utf8 BYTE_MASK 
.const [88] = Utf8 I 
.const [89] = Utf8 TRUE_CONSTANT 
.const [90] = Utf8 I 
.const [91] = Utf8 BYTES_IN_INTEGER 
.const [92] = Utf8 I 
.const [93] = Utf8 DEFAULT_BIT_SIZE 
.const [94] = Utf8 I 
.const [95] = Utf8 TRUE_INT_CONSTANT 
.const [96] = Utf8 I 
.const [97] = Utf8 FALSE_INT_CONSTANT 
.const [98] = Utf8 I 
.const [99] = Utf8 bitSize 
.const [100] = Utf8 I 
.const [101] = Utf8 bitsData 
.const [102] = Utf8 I 
.const [103] = Utf8 bitsMask 
.const [104] = Utf8 I 
.const [105] = Utf8 Code 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (I)V 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (II)V 
.const [110] = Utf8 <init> 
.const [111] = Utf8 ()V 
.const [112] = Utf8 pushByte 
.const [113] = Utf8 (B)V 
.const [114] = Utf8 pushShort 
.const [115] = Utf8 (S)V 
.const [116] = Utf8 pushInt 
.const [117] = Utf8 (I)V 
.const [118] = Utf8 pushBoolean 
.const [119] = Utf8 (Z)V 
.const [120] = Utf8 pushBytes 
.const [121] = Utf8 ([B)V 
.const [122] = Utf8 pushBits 
.const [123] = Utf8 (II)V 
.const [124] = Utf8 resetBits 
.const [125] = Utf8 (I)V 
.const [126] = Utf8 toInteger 
.const [127] = Utf8 ()I 
.const [128] = Utf8 bitSize 
.const [129] = Utf8 ()I 
.const [130] = Utf8 reset 
.const [131] = Utf8 (II)V 
.const [132] = Utf8 popFrontBits 
.const [133] = Utf8 (I)I 
.const [134] = Utf8 discardBits 
.const [135] = Utf8 (I)V 
.const [136] = Utf8 popFrontBoolean 
.const [137] = Utf8 ()Z 
.const [138] = Utf8 popFrontByte 
.const [139] = Utf8 ()I 
.const [140] = Utf8 popFrontBytes 
.const [141] = Utf8 (I)[B 
.const [142] = Utf8 popFrontInt 
.const [143] = Utf8 ()I 
.const [144] = Utf8 popFrontShort 
.const [145] = Utf8 ()I 
.end class 
