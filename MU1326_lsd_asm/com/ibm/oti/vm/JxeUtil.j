.version 50 0 
.class public final super [201] 
.super [203] 

.method static [205] : [206] 
    .attribute [204] .code stack 3 locals 0 
        .catch [12] from L0 to L28 using L28 
L0:     new [44] 
L3:     dup 
L4:     ldc [5] 
L6:     invokespecial [41] 
L9:     ldc [6] 
L11:    ldc [7] 
L13:    invokestatic [9] 
L16:    invokevirtual [36] 
L19:    invokevirtual [37] 
L22:    invokestatic [10] 
L25:    goto L58 
L28:    pop 
        .catch [12] from L29 to L57 using L57 
L29:    new [44] 
L32:    dup 
L33:    ldc [11] 
L35:    invokespecial [41] 
L38:    ldc [6] 
L40:    ldc [7] 
L42:    invokestatic [9] 
L45:    invokevirtual [36] 
L48:    invokevirtual [37] 
L51:    invokestatic [10] 
L54:    goto L58 
L57:    pop 
L58:    return 
L59:    nop 
L60:    
    .end code 
.end method 

.method public annotation [207] : [208] 
    .attribute [204] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static native [209] : [210] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [211] : [212] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static [213] : [214] 
    .attribute [204] .code stack 1 locals 0 
L0:     iload_0 
L1:     invokestatic [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [215] : [216] 
    .attribute [204] .code stack 6 locals 1 
L0:     bipush 40 
L2:     newarray byte 
L4:     astore_2 
L5:     aload_0 
L6:     getfield [38] 
L9:     lconst_0 
L10:    lcmp 
L11:    ifne L16 
L14:    aconst_null 
L15:    areturn 
L16:    aload_0 
L17:    getfield [38] 
L20:    aload_0 
L21:    invokevirtual [39] 
L24:    aload_1 
L25:    aload_2 
L26:    invokestatic [15] 
L29:    ifne L34 
L32:    aconst_null 
L33:    areturn 
L34:    aload_2 
L35:    areturn 
L36:    
    .end code 
.end method 

.method private static native [217] : [218] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private static native [219] : [220] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [221] : [222] 
    .attribute [204] .code stack 7 locals 4 
L0:     aload_0 
L1:     getfield [38] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L22 
L9:     new [46] 
L12:    dup 
L13:    ldc [17] 
L15:    invokestatic [19] 
L18:    invokespecial [43] 
L21:    athrow 
L22:    aload_0 
L23:    invokevirtual [39] 
L26:    invokestatic [20] 
L29:    lstore_2 
L30:    lconst_0 
L31:    lload_2 
L32:    lcmp 
L33:    ifne L49 
L36:    new [46] 
L39:    dup 
L40:    ldc [21] 
L42:    invokestatic [19] 
L45:    invokespecial [43] 
L48:    athrow 
L49:    lload_2 
L50:    aload_1 
L51:    aload_0 
L52:    invokevirtual [39] 
L55:    aload_0 
L56:    invokevirtual [40] 
L59:    invokestatic [22] 
L62:    lstore 4 
L64:    lconst_0 
L65:    lload 4 
L67:    lcmp 
L68:    ifne L84 
L71:    new [46] 
L74:    dup 
L75:    ldc [23] 
L77:    invokestatic [19] 
L80:    invokespecial [43] 
L83:    athrow 
L84:    aload_0 
L85:    lload 4 
L87:    putfield [45] 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 

.method private static native [223] : [224] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static [225] : [226] 
    .attribute [204] .code stack 2 locals 1 
L0:     lload_0 
L1:     invokestatic [24] 
L4:     istore_2 
L5:     iload_2 
L6:     ifeq L14 
L9:     iload_2 
L10:    invokestatic [25] 
L13:    athrow 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private static native [227] : [228] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [229] : [230] 
    .attribute [204] .code stack 6 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     iload_3 
L4:     lload 4 
L6:     invokestatic [26] 
L9:     istore 6 
L11:    iload 6 
L13:    ifeq L22 
L16:    iload 6 
L18:    invokestatic [25] 
L21:    athrow 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method private static native [231] : [232] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [233] : [234] 
    .attribute [204] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokestatic [27] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static native [235] : [236] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [237] : [238] 
    .attribute [204] .code stack 2 locals 1 
L0:     lload_0 
L1:     invokestatic [28] 
L4:     istore_2 
L5:     iload_2 
L6:     ifeq L14 
L9:     iload_2 
L10:    invokestatic [25] 
L13:    athrow 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private static native [239] : [240] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [241] : [242] 
    .attribute [204] .code stack 2 locals 0 
L0:     invokestatic [29] 
L3:     i2l 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private static native [243] : [244] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [245] : [246] 
    .attribute [204] .code stack 2 locals 0 
L0:     invokestatic [30] 
L3:     i2l 
L4:     freturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static native [247] : [248] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method public static [249] : [250] 
    .attribute [204] .code stack 1 locals 1 
L0:     aload_0 
L1:     invokestatic [32] 
L4:     astore_1 
L5:     aload_1 
L6:     invokestatic [33] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method static [251] : [252] 
    .attribute [204] .code stack 6 locals 2 
L0:     aload_0 
L1:     invokevirtual [39] 
L4:     invokestatic [20] 
L7:     lstore_1 
L8:     lconst_0 
L9:     lload_1 
L10:    lcmp 
L11:    ifne L16 
L14:    iconst_0 
L15:    areturn 
L16:    lload_1 
L17:    aload_0 
L18:    invokevirtual [39] 
L21:    aload_0 
L22:    invokevirtual [40] 
L25:    invokestatic [34] 
L28:    iconst_1 
L29:    areturn 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method static native [253] : [254] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method static [255] : [256] 
    .attribute [204] .code stack 4 locals 2 
L0:     aload_0 
L1:     invokevirtual [39] 
L4:     invokestatic [20] 
L7:     lstore_1 
L8:     lconst_0 
L9:     lload_1 
L10:    lcmp 
L11:    ifne L16 
L14:    iconst_0 
L15:    areturn 
L16:    lload_1 
L17:    invokestatic [35] 
L20:    iconst_1 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method static native [257] : [258] 
    .attribute [204] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [47] 
.const [3] = Class [48] 
.const [4] = Class [49] 
.const [5] = String [50] 
.const [6] = String [51] 
.const [7] = String [52] 
.const [8] = Class [53] 
.const [9] = Method [54] [55] 
.const [10] = Method [56] [57] 
.const [11] = String [58] 
.const [12] = Class [59] 
.const [13] = Method [60] [61] 
.const [14] = Class [62] 
.const [15] = Method [63] [64] 
.const [16] = Class [65] 
.const [17] = String [66] 
.const [18] = Class [67] 
.const [19] = Method [68] [69] 
.const [20] = Method [70] [71] 
.const [21] = String [72] 
.const [22] = Method [73] [74] 
.const [23] = String [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = Method [84] [85] 
.const [29] = Method [86] [87] 
.const [30] = Method [88] [89] 
.const [31] = Class [90] 
.const [32] = Method [91] [92] 
.const [33] = Method [93] [94] 
.const [34] = Method [95] [96] 
.const [35] = Method [97] [98] 
.const [36] = Method [99] [100] 
.const [37] = Method [101] [102] 
.const [38] = Field [103] [104] 
.const [39] = Method [105] [106] 
.const [40] = Method [107] [108] 
.const [41] = Method [109] [110] 
.const [42] = Method [111] [112] 
.const [43] = Method [113] [114] 
.const [44] = Class [115] 
.const [45] = Field [116] [117] 
.const [46] = Class [118] 
.const [47] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [48] = Utf8 java/lang/Object 
.const [49] = Utf8 java/lang/StringBuffer 
.const [50] = Utf8 iverel 
.const [51] = Utf8 'com.ibm.oti.vm.library.version' 
.const [52] = Utf8 '23' 
.const [53] = Utf8 java/lang/System 
.const [54] = Class [119] 
.const [55] = NameAndType [120] [121] 
.const [56] = Class [122] 
.const [57] = NameAndType [123] [124] 
.const [58] = Utf8 j9vmall 
.const [59] = Utf8 java/lang/UnsatisfiedLinkError 
.const [60] = Class [125] 
.const [61] = NameAndType [126] [127] 
.const [62] = Utf8 com/ibm/oti/vm/Jxe 
.const [63] = Class [128] 
.const [64] = NameAndType [129] [130] 
.const [65] = Utf8 com/ibm/oti/vm/JxeException 
.const [66] = Utf8 K0228 
.const [67] = Utf8 com/ibm/oti/util/Msg 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Class [134] 
.const [71] = NameAndType [135] [136] 
.const [72] = Utf8 K01a1 
.const [73] = Class [137] 
.const [74] = NameAndType [138] [139] 
.const [75] = Utf8 K01a2 
.const [76] = Class [140] 
.const [77] = NameAndType [141] [142] 
.const [78] = Class [143] 
.const [79] = NameAndType [144] [145] 
.const [80] = Class [146] 
.const [81] = NameAndType [147] [148] 
.const [82] = Class [149] 
.const [83] = NameAndType [150] [151] 
.const [84] = Class [152] 
.const [85] = NameAndType [153] [154] 
.const [86] = Class [155] 
.const [87] = NameAndType [156] [157] 
.const [88] = Class [158] 
.const [89] = NameAndType [159] [160] 
.const [90] = Utf8 com/ibm/oti/util/Util 
.const [91] = Class [161] 
.const [92] = NameAndType [162] [163] 
.const [93] = Class [164] 
.const [94] = NameAndType [165] [166] 
.const [95] = Class [167] 
.const [96] = NameAndType [168] [169] 
.const [97] = Class [170] 
.const [98] = NameAndType [171] [172] 
.const [99] = Class [173] 
.const [100] = NameAndType [174] [175] 
.const [101] = Class [176] 
.const [102] = NameAndType [177] [178] 
.const [103] = Class [179] 
.const [104] = NameAndType [180] [181] 
.const [105] = Class [182] 
.const [106] = NameAndType [183] [184] 
.const [107] = Class [185] 
.const [108] = NameAndType [186] [187] 
.const [109] = Class [188] 
.const [110] = NameAndType [189] [190] 
.const [111] = Class [191] 
.const [112] = NameAndType [192] [193] 
.const [113] = Class [194] 
.const [114] = NameAndType [195] [196] 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Class [197] 
.const [117] = NameAndType [198] [199] 
.const [118] = Utf8 com/ibm/oti/vm/JxeException 
.const [119] = Utf8 java/lang/System 
.const [120] = Utf8 getProperty 
.const [121] = Utf8 (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; 
.const [122] = Utf8 java/lang/System 
.const [123] = Utf8 loadLibrary 
.const [124] = Utf8 (Ljava/lang/String;)V 
.const [125] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [126] = Utf8 nativeGetRelocationMessage 
.const [127] = Utf8 (I)Ljava/lang/String; 
.const [128] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [129] = Utf8 nativeGetRomClassCookie 
.const [130] = Utf8 (JJLjava/lang/String;[B)Z 
.const [131] = Utf8 com/ibm/oti/util/Msg 
.const [132] = Utf8 getString 
.const [133] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [134] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [135] = Utf8 nativeGetRomImagePointerFromJxePointer 
.const [136] = Utf8 (J)J 
.const [137] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [138] = Utf8 nativeRomImageLoad 
.const [139] = Utf8 (JLjava/lang/ClassLoader;JJ)J 
.const [140] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [141] = Utf8 nativeRelocateJxeInPlace 
.const [142] = Utf8 (J)I 
.const [143] = Utf8 com/ibm/oti/vm/JxeException 
.const [144] = Utf8 jxeExceptionFromRelocationReturnCode 
.const [145] = Utf8 (I)Lcom/ibm/oti/vm/JxeException; 
.const [146] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [147] = Utf8 nativeRelocateJxeStreaming 
.const [148] = Utf8 (Ljava/io/InputStream;Lcom/ibm/oti/vm/JxeOutputStream;IIJ)I 
.const [149] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [150] = Utf8 nativeGetEnvironmentVariable 
.const [151] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [152] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [153] = Utf8 nativeVerifyJxe 
.const [154] = Utf8 (J)I 
.const [155] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [156] = Utf8 nativeGetCurrentRomImageVersion 
.const [157] = Utf8 ()I 
.const [158] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [159] = Utf8 nativeGetLowestRomImageVersion 
.const [160] = Utf8 ()I 
.const [161] = Utf8 com/ibm/oti/util/Util 
.const [162] = Utf8 getBytes 
.const [163] = Utf8 (Ljava/lang/String;)[B 
.const [164] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [165] = Utf8 nativeGetClassList 
.const [166] = Utf8 ([B)[Ljava/lang/String; 
.const [167] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [168] = Utf8 nativeRegisterJxe 
.const [169] = Utf8 (JJJ)V 
.const [170] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [171] = Utf8 nativeUnregisterJxe 
.const [172] = Utf8 (J)V 
.const [173] = Utf8 java/lang/StringBuffer 
.const [174] = Utf8 append 
.const [175] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [176] = Utf8 java/lang/StringBuffer 
.const [177] = Utf8 toString 
.const [178] = Utf8 ()Ljava/lang/String; 
.const [179] = Utf8 com/ibm/oti/vm/Jxe 
.const [180] = Utf8 romSegmentPointer 
.const [181] = Utf8 J 
.const [182] = Utf8 com/ibm/oti/vm/Jxe 
.const [183] = Utf8 getJxePointer 
.const [184] = Utf8 ()J 
.const [185] = Utf8 com/ibm/oti/vm/Jxe 
.const [186] = Utf8 getJxeAlloc 
.const [187] = Utf8 ()J 
.const [188] = Utf8 java/lang/StringBuffer 
.const [189] = Utf8 <init> 
.const [190] = Utf8 (Ljava/lang/String;)V 
.const [191] = Utf8 java/lang/Object 
.const [192] = Utf8 <init> 
.const [193] = Utf8 ()V 
.const [194] = Utf8 com/ibm/oti/vm/JxeException 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (Ljava/lang/String;)V 
.const [197] = Utf8 com/ibm/oti/vm/Jxe 
.const [198] = Utf8 romSegmentPointer 
.const [199] = Utf8 J 
.const [200] = Utf8 com/ibm/oti/vm/JxeUtil 
.const [201] = Class [200] 
.const [202] = Utf8 java/lang/Object 
.const [203] = Class [202] 
.const [204] = Utf8 Code 
.const [205] = Utf8 <clinit> 
.const [206] = Utf8 ()V 
.const [207] = Utf8 <init> 
.const [208] = Utf8 ()V 
.const [209] = Utf8 nativeGetRomImagePointerFromJxePointer 
.const [210] = Utf8 (J)J 
.const [211] = Utf8 nativeGetRelocationMessage 
.const [212] = Utf8 (I)Ljava/lang/String; 
.const [213] = Utf8 getRelocationMessage 
.const [214] = Utf8 (I)Ljava/lang/String; 
.const [215] = Utf8 getRomClass 
.const [216] = Utf8 (Lcom/ibm/oti/vm/Jxe;Ljava/lang/String;)[B 
.const [217] = Utf8 nativeGetRomClassCookie 
.const [218] = Utf8 (JJLjava/lang/String;[B)Z 
.const [219] = Utf8 nativeRomImageLoad 
.const [220] = Utf8 (JLjava/lang/ClassLoader;JJ)J 
.const [221] = Utf8 romImageLoad 
.const [222] = Utf8 (Lcom/ibm/oti/vm/Jxe;Ljava/lang/ClassLoader;)V 
.const [223] = Utf8 nativeRelocateJxeInPlace 
.const [224] = Utf8 (J)I 
.const [225] = Utf8 relocateJxeInPlace 
.const [226] = Utf8 (J)V 
.const [227] = Utf8 nativeRelocateJxeStreaming 
.const [228] = Utf8 (Ljava/io/InputStream;Lcom/ibm/oti/vm/JxeOutputStream;IIJ)I 
.const [229] = Utf8 relocateJxeStreaming 
.const [230] = Utf8 (Ljava/io/InputStream;Lcom/ibm/oti/vm/JxeOutputStream;IIJ)V 
.const [231] = Utf8 nativeGetEnvironmentVariable 
.const [232] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [233] = Utf8 getEnvironmentVariable 
.const [234] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [235] = Utf8 nativeVerifyJxe 
.const [236] = Utf8 (J)I 
.const [237] = Utf8 verifyJxe 
.const [238] = Utf8 (J)V 
.const [239] = Utf8 nativeGetCurrentRomImageVersion 
.const [240] = Utf8 ()I 
.const [241] = Utf8 getCurrentRomImageVersion 
.const [242] = Utf8 ()J 
.const [243] = Utf8 nativeGetLowestRomImageVersion 
.const [244] = Utf8 ()I 
.const [245] = Utf8 getLowestRomImageVersion 
.const [246] = Utf8 ()J 
.const [247] = Utf8 nativeGetClassList 
.const [248] = Utf8 ([B)[Ljava/lang/String; 
.const [249] = Utf8 getClassList 
.const [250] = Utf8 (Ljava/lang/String;)[Ljava/lang/String; 
.const [251] = Utf8 registerJxe 
.const [252] = Utf8 (Lcom/ibm/oti/vm/Jxe;)Z 
.const [253] = Utf8 nativeRegisterJxe 
.const [254] = Utf8 (JJJ)V 
.const [255] = Utf8 unregisterJxe 
.const [256] = Utf8 (Lcom/ibm/oti/vm/Jxe;)Z 
.const [257] = Utf8 nativeUnregisterJxe 
.const [258] = Utf8 (J)V 
.end class 
