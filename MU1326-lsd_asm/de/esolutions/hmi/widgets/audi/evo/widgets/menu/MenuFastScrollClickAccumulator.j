.version 50 0 
.class public super [83] 
.super [85] 
.implements [87] 
.field private static final [88] [89] 
.field private [90] [91] 

.method public [93] : [94] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [14] 
L4:     aload_0 
L5:     iconst_4 
L6:     newarray long 
L8:     putfield [19] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 9 locals 3 
L0:     aload_0 
L1:     lload_2 
L2:     invokespecial [15] 
L5:     istore 4 
L7:     aload_0 
L8:     iload 4 
L10:    invokespecial [16] 
L13:    istore 5 
L15:    aload_0 
L16:    iload 5 
L18:    invokespecial [17] 
L21:    iload 5 
L23:    iload_1 
L24:    iadd 
L25:    istore 6 
L27:    iload 6 
L29:    aload_0 
L30:    getfield [12] 
L33:    arraylength 
L34:    if_icmplt L59 
L37:    getstatic [2] 
L40:    ldc [3] 
L42:    ldc [4] 
L44:    iload 4 
L46:    i2l 
L47:    iload 5 
L49:    i2l 
L50:    iload 6 
L52:    i2l 
L53:    invokevirtual [13] 
L56:    pop 
L57:    iconst_1 
L58:    areturn 
L59:    aload_0 
L60:    iload 5 
L62:    iload_1 
L63:    lload_2 
L64:    invokespecial [18] 
L67:    getstatic [2] 
L70:    ldc [3] 
L72:    ldc [5] 
L74:    iload 4 
L76:    i2l 
L77:    iload 5 
L79:    i2l 
L80:    iload 6 
L82:    i2l 
L83:    invokevirtual [13] 
L86:    pop 
L87:    iconst_0 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [92] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     lconst_0 
L5:     invokestatic [6] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method private [99] : [100] 
    .attribute [92] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [12] 
L4:     iconst_0 
L5:     laload 
L6:     lconst_0 
L7:     lcmp 
L8:     ifne L13 
L11:    iconst_0 
L12:    areturn 
L13:    iconst_0 
L14:    istore_3 
L15:    iload_3 
L16:    aload_0 
L17:    getfield [12] 
L20:    arraylength 
L21:    if_icmpge L51 
L24:    lload_1 
L25:    aload_0 
L26:    getfield [12] 
L29:    iload_3 
L30:    laload 
L31:    lsub 
L32:    lstore 4 
L34:    lload 4 
L36:    ldc_w [1] 
L39:    lcmp 
L40:    ifge L45 
L43:    iload_3 
L44:    areturn 
L45:    iinc 3 1 
L48:    goto L15 
L51:    aload_0 
L52:    getfield [12] 
L55:    arraylength 
L56:    areturn 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method private [101] : [102] 
    .attribute [92] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [12] 
L4:     arraylength 
L5:     iload_1 
L6:     isub 
L7:     istore_2 
L8:     iconst_0 
L9:     istore_3 
L10:    iload_3 
L11:    iload_2 
L12:    if_icmpge L53 
L15:    iload_3 
L16:    iload_1 
L17:    iadd 
L18:    istore 4 
L20:    aload_0 
L21:    getfield [12] 
L24:    iload 4 
L26:    laload 
L27:    lconst_0 
L28:    lcmp 
L29:    ifne L34 
L32:    iload_3 
L33:    areturn 
L34:    aload_0 
L35:    getfield [12] 
L38:    iload_3 
L39:    aload_0 
L40:    getfield [12] 
L43:    iload 4 
L45:    laload 
L46:    lastore 
L47:    iinc 3 1 
L50:    goto L10 
L53:    iload_2 
L54:    areturn 
L55:    nop 
L56:    
    .end code 
.end method 

.method private [103] : [104] 
    .attribute [92] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     aload_0 
L6:     getfield [12] 
L9:     arraylength 
L10:    lconst_0 
L11:    invokestatic [7] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [105] : [106] 
    .attribute [92] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     iload_1 
L5:     iload_1 
L6:     iload_2 
L7:     iadd 
L8:     lload_3 
L9:     invokestatic [7] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method interface [107] : [108] 
    .attribute [92] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [21] [22] 
.const [3] = Int -2137614336 
.const [4] = String [23] 
.const [5] = String [24] 
.const [6] = Method [25] [26] 
.const [7] = Method [27] [28] 
.const [8] = Class [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Field [33] [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Method [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = Int -100663296 
.const [21] = Class [49] 
.const [22] = NameAndType [50] [51] 
.const [23] = Utf8 'MenuFastScrollClickAccumulator#keyTurned: Start FastScroll. removed %1 obsolete ticks, %2 ticks remaining, with new ticks reached %3 ticks' 
.const [24] = Utf8 'MenuFastScrollClickAccumulator#keyTurned: removed %1 obsolete ticks, %2 ticks remaining, with new ticks reached %3 ticks within timeout' 
.const [25] = Class [52] 
.const [26] = NameAndType [53] [54] 
.const [27] = Class [55] 
.const [28] = NameAndType [56] [57] 
.const [29] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [30] = Utf8 java/lang/Object 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Utf8 java/util/Arrays 
.const [33] = Class [58] 
.const [34] = NameAndType [59] [60] 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [50] = Utf8 menuLogCh 
.const [51] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [52] = Utf8 java/util/Arrays 
.const [53] = Utf8 fill 
.const [54] = Utf8 ([JJ)V 
.const [55] = Utf8 java/util/Arrays 
.const [56] = Utf8 fill 
.const [57] = Utf8 ([JIIJ)V 
.const [58] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [59] = Utf8 tickTimestamps 
.const [60] = Utf8 [J 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 log 
.const [63] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [68] = Utf8 getObsoleteTickCount 
.const [69] = Utf8 (J)I 
.const [70] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [71] = Utf8 deleteObsoleteTicks 
.const [72] = Utf8 (I)I 
.const [73] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [74] = Utf8 clearGarbageAfterTicks 
.const [75] = Utf8 (I)V 
.const [76] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [77] = Utf8 addTicks 
.const [78] = Utf8 (IIJ)V 
.const [79] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [80] = Utf8 tickTimestamps 
.const [81] = Utf8 [J 
.const [82] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/menu/MenuFastScrollClickAccumulator 
.const [83] = Class [82] 
.const [84] = Utf8 java/lang/Object 
.const [85] = Class [84] 
.const [86] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [87] = Class [86] 
.const [88] = Utf8 TIMESTAMP_EMPTY 
.const [89] = Utf8 I 
.const [90] = Utf8 tickTimestamps 
.const [91] = Utf8 [J 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 ()V 
.const [95] = Utf8 keyTurned 
.const [96] = Utf8 (IJ)Z 
.const [97] = Utf8 clear 
.const [98] = Utf8 ()V 
.const [99] = Utf8 getObsoleteTickCount 
.const [100] = Utf8 (J)I 
.const [101] = Utf8 deleteObsoleteTicks 
.const [102] = Utf8 (I)I 
.const [103] = Utf8 clearGarbageAfterTicks 
.const [104] = Utf8 (I)V 
.const [105] = Utf8 addTicks 
.const [106] = Utf8 (IIJ)V 
.const [107] = Utf8 getTickTimestamps 
.const [108] = Utf8 ()[J 
.end class 
