.version 50 0 
.class public super [117] 
.super [119] 
.implements [121] 
.field private static final [122] [123] 
.field static final [124] [125] 
.field [126] [127] 
.field [128] [129] 
.field [130] [131] 

.method public [133] : [134] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [20] 
L9:     aload_0 
L10:    dconst_0 
L11:    putfield [21] 
L14:    aload_0 
L15:    invokestatic [5] 
L18:    invokevirtual [13] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [132] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [18] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [20] 
L9:     aload_0 
L10:    dconst_0 
L11:    putfield [21] 
L14:    aload_0 
L15:    lload_1 
L16:    invokevirtual [13] 
L19:    return 
L20:    
    .end code 
.end method 

.method protected synchronized [137] : [138] 
    .attribute [132] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [14] 
L5:     ldc2_w [24] 
L8:     lmul 
L9:     ldc_w [1] 
L12:    ladd 
L13:    ldc2_w [27] 
L16:    land 
L17:    putfield [22] 
L20:    aload_0 
L21:    getfield [14] 
L24:    bipush 48 
L26:    iload_1 
L27:    isub 
L28:    lushr 
L29:    l2i 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [139] : [140] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokevirtual [15] 
L5:     ifeq L10 
L8:     iconst_1 
L9:     areturn 
L10:    iconst_0 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [141] : [142] 
    .attribute [132] .code stack 3 locals 3 
L0:     iconst_0 
L1:     istore_2 
L2:     iconst_0 
L3:     istore_3 
L4:     iconst_0 
L5:     istore 4 
L7:     goto L42 
L10:    iload 4 
L12:    ifne L26 
L15:    aload_0 
L16:    invokevirtual [16] 
L19:    istore_2 
L20:    iconst_3 
L21:    istore 4 
L23:    goto L29 
L26:    iinc 4 -1 
L29:    aload_1 
L30:    iload_3 
L31:    iinc 3 1 
L34:    iload_2 
L35:    i2b 
L36:    bastore 
L37:    iload_2 
L38:    bipush 8 
L40:    ishr 
L41:    istore_2 
L42:    iload_3 
L43:    aload_1 
L44:    arraylength 
L45:    if_icmplt L10 
L48:    return 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [132] .code stack 4 locals 0 
L0:     aload_0 
L1:     bipush 26 
L3:     invokevirtual [15] 
L6:     i2l 
L7:     bipush 27 
L9:     lshl 
L10:    aload_0 
L11:    bipush 27 
L13:    invokevirtual [15] 
L16:    i2l 
L17:    ladd 
L18:    l2d 
L19:    ldc2_w [29] 
L22:    ddiv 
L23:    freturn 
L24:    
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 24 
L3:     invokevirtual [15] 
L6:     i2f 
L7:     ldc [6] 
L9:     fdiv 
L10:    areturn 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [147] : [148] 
    .attribute [132] .code stack 6 locals 8 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifeq L17 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [20] 
L12:    aload_0 
L13:    getfield [12] 
L16:    return 
L17:    ldc2_w [31] 
L20:    aload_0 
L21:    invokevirtual [17] 
L24:    dmul 
L25:    dconst_1 
L26:    dsub 
L27:    dstore_1 
L28:    ldc2_w [31] 
L31:    aload_0 
L32:    invokevirtual [17] 
L35:    dmul 
L36:    dconst_1 
L37:    dsub 
L38:    dstore_3 
L39:    dload_1 
L40:    dload_1 
L41:    dmul 
L42:    dload_3 
L43:    dload_3 
L44:    dmul 
L45:    dadd 
L46:    dstore 5 
L48:    dload 5 
L50:    dconst_1 
L51:    dcmpl 
L52:    ifge L17 
L55:    ldc2_w [33] 
L58:    dload 5 
L60:    invokestatic [8] 
L63:    dmul 
L64:    dload 5 
L66:    ddiv 
L67:    invokestatic [9] 
L70:    dstore 7 
L72:    aload_0 
L73:    dload_3 
L74:    dload 7 
L76:    dmul 
L77:    putfield [21] 
L80:    aload_0 
L81:    iconst_1 
L82:    putfield [20] 
L85:    dload_1 
L86:    dload 7 
L88:    dmul 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [132] .code stack 2 locals 0 
L0:     aload_0 
L1:     bipush 32 
L3:     invokevirtual [15] 
L6:     areturn 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [151] : [152] 
    .attribute [132] .code stack 4 locals 2 
L0:     iload_1 
L1:     ifle L50 
L4:     iload_1 
L5:     iload_1 
L6:     ineg 
L7:     iand 
L8:     iload_1 
L9:     if_icmpne L27 
L12:    iload_1 
L13:    i2l 
L14:    aload_0 
L15:    bipush 31 
L17:    invokevirtual [15] 
L20:    i2l 
L21:    lmul 
L22:    bipush 31 
L24:    lshr 
L25:    l2i 
L26:    areturn 
L27:    aload_0 
L28:    bipush 31 
L30:    invokevirtual [15] 
L33:    istore_2 
L34:    iload_2 
L35:    iload_1 
L36:    irem 
L37:    istore_3 
L38:    iload_2 
L39:    iload_3 
L40:    isub 
L41:    iload_1 
L42:    iconst_1 
L43:    isub 
L44:    iadd 
L45:    iflt L27 
L48:    iload_3 
L49:    areturn 
L50:    new [23] 
L53:    dup 
L54:    invokespecial [19] 
L57:    athrow 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [132] .code stack 4 locals 0 
L0:     aload_0 
L1:     bipush 32 
L3:     invokevirtual [15] 
L6:     i2l 
L7:     bipush 32 
L9:     lshl 
L10:    aload_0 
L11:    bipush 32 
L13:    invokevirtual [15] 
L16:    i2l 
L17:    ladd 
L18:    freturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method public synchronized [155] : [156] 
    .attribute [132] .code stack 5 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     ldc2_w [24] 
L5:     lxor 
L6:     ldc2_w [27] 
L9:     land 
L10:    putfield [22] 
L13:    aload_0 
L14:    iconst_0 
L15:    putfield [20] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [35] 
.const [3] = Class [36] 
.const [4] = Class [37] 
.const [5] = Method [38] [39] 
.const [6] = Int 32843 
.const [7] = Class [40] 
.const [8] = Method [41] [42] 
.const [9] = Method [43] [44] 
.const [10] = Class [45] 
.const [11] = Field [46] [47] 
.const [12] = Field [48] [49] 
.const [13] = Method [50] [51] 
.const [14] = Field [52] [53] 
.const [15] = Method [54] [55] 
.const [16] = Method [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Field [64] [65] 
.const [21] = Field [66] [67] 
.const [22] = Field [68] [69] 
.const [23] = Class [70] 
.const [24] = Long 25214903917L 
.const [26] = Int 184549376 
.const [27] = Long 281474976710655L 
.const [29] = Double +0x10000000000000p1 
.const [31] = Double +0x10000000000000p-51 
.const [33] = Double -0x10000000000000p-51 
.const [35] = Utf8 java/util/Random 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 java/lang/System 
.const [38] = Class [71] 
.const [39] = NameAndType [72] [73] 
.const [40] = Utf8 java/lang/Math 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Utf8 java/lang/IllegalArgumentException 
.const [46] = Class [80] 
.const [47] = NameAndType [81] [82] 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Utf8 java/lang/IllegalArgumentException 
.const [71] = Utf8 java/lang/System 
.const [72] = Utf8 currentTimeMillis 
.const [73] = Utf8 ()J 
.const [74] = Utf8 java/lang/Math 
.const [75] = Utf8 log 
.const [76] = Utf8 (D)D 
.const [77] = Utf8 java/lang/Math 
.const [78] = Utf8 sqrt 
.const [79] = Utf8 (D)D 
.const [80] = Utf8 java/util/Random 
.const [81] = Utf8 haveNextNextGaussian 
.const [82] = Utf8 Z 
.const [83] = Utf8 java/util/Random 
.const [84] = Utf8 nextNextGaussian 
.const [85] = Utf8 D 
.const [86] = Utf8 java/util/Random 
.const [87] = Utf8 setSeed 
.const [88] = Utf8 (J)V 
.const [89] = Utf8 java/util/Random 
.const [90] = Utf8 seed 
.const [91] = Utf8 J 
.const [92] = Utf8 java/util/Random 
.const [93] = Utf8 next 
.const [94] = Utf8 (I)I 
.const [95] = Utf8 java/util/Random 
.const [96] = Utf8 nextInt 
.const [97] = Utf8 ()I 
.const [98] = Utf8 java/util/Random 
.const [99] = Utf8 nextDouble 
.const [100] = Utf8 ()D 
.const [101] = Utf8 java/lang/Object 
.const [102] = Utf8 <init> 
.const [103] = Utf8 ()V 
.const [104] = Utf8 java/lang/IllegalArgumentException 
.const [105] = Utf8 <init> 
.const [106] = Utf8 ()V 
.const [107] = Utf8 java/util/Random 
.const [108] = Utf8 haveNextNextGaussian 
.const [109] = Utf8 Z 
.const [110] = Utf8 java/util/Random 
.const [111] = Utf8 nextNextGaussian 
.const [112] = Utf8 D 
.const [113] = Utf8 java/util/Random 
.const [114] = Utf8 seed 
.const [115] = Utf8 J 
.const [116] = Utf8 java/util/Random 
.const [117] = Class [116] 
.const [118] = Utf8 java/lang/Object 
.const [119] = Class [118] 
.const [120] = Utf8 java/io/Serializable 
.const [121] = Class [120] 
.const [122] = Utf8 serialVersionUID 
.const [123] = Utf8 J 
.const [124] = Utf8 multiplier 
.const [125] = Utf8 J 
.const [126] = Utf8 haveNextNextGaussian 
.const [127] = Utf8 Z 
.const [128] = Utf8 seed 
.const [129] = Utf8 J 
.const [130] = Utf8 nextNextGaussian 
.const [131] = Utf8 D 
.const [132] = Utf8 Code 
.const [133] = Utf8 <init> 
.const [134] = Utf8 ()V 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (J)V 
.const [137] = Utf8 next 
.const [138] = Utf8 (I)I 
.const [139] = Utf8 nextBoolean 
.const [140] = Utf8 ()Z 
.const [141] = Utf8 nextBytes 
.const [142] = Utf8 ([B)V 
.const [143] = Utf8 nextDouble 
.const [144] = Utf8 ()D 
.const [145] = Utf8 nextFloat 
.const [146] = Utf8 ()F 
.const [147] = Utf8 nextGaussian 
.const [148] = Utf8 ()D 
.const [149] = Utf8 nextInt 
.const [150] = Utf8 ()I 
.const [151] = Utf8 nextInt 
.const [152] = Utf8 (I)I 
.const [153] = Utf8 nextLong 
.const [154] = Utf8 ()J 
.const [155] = Utf8 setSeed 
.const [156] = Utf8 (J)V 
.end class 
