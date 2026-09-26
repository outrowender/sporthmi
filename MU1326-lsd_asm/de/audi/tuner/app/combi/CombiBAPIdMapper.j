.version 50 0 
.class public super [45] 
.super [47] 
.field private static final [48] [49] 
.field private static final [50] [51] 
.field private [52] [53] 

.method public [55] : [56] 
    .attribute [54] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     sipush 500 
L8:     newarray long 
L10:    putfield [10] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method synchronized [57] : [58] 
    .attribute [54] .code stack 4 locals 1 
L0:     iconst_0 
L1:     istore_3 
L2:     iload_3 
L3:     aload_0 
L4:     getfield [6] 
L7:     arraylength 
L8:     if_icmpge L47 
L11:    aload_0 
L12:    getfield [6] 
L15:    iload_3 
L16:    laload 
L17:    lload_1 
L18:    lcmp 
L19:    ifne L27 
L22:    iload_3 
L23:    bipush 20 
L25:    iadd 
L26:    areturn 
L27:    aload_0 
L28:    getfield [6] 
L31:    iload_3 
L32:    laload 
L33:    lconst_0 
L34:    lcmp 
L35:    ifne L41 
L38:    goto L47 
L41:    iinc 3 1 
L44:    goto L2 
L47:    iload_3 
L48:    aload_0 
L49:    getfield [6] 
L52:    arraylength 
L53:    if_icmpne L66 
L56:    aload_0 
L57:    invokespecial [9] 
L60:    aload_0 
L61:    lload_1 
L62:    invokevirtual [7] 
L65:    areturn 
L66:    aload_0 
L67:    getfield [6] 
L70:    iload_3 
L71:    lload_1 
L72:    lastore 
L73:    iload_3 
L74:    bipush 20 
L76:    iadd 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method private [59] : [60] 
    .attribute [54] .code stack 5 locals 1 
L0:     iconst_2 
L1:     aload_0 
L2:     getfield [6] 
L5:     arraylength 
L6:     imul 
L7:     newarray long 
L9:     astore_1 
L10:    aload_0 
L11:    getfield [6] 
L14:    iconst_0 
L15:    aload_1 
L16:    iconst_0 
L17:    aload_0 
L18:    getfield [6] 
L21:    arraylength 
L22:    invokestatic [2] 
L25:    aload_0 
L26:    aload_1 
L27:    putfield [10] 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method synchronized [61] : [62] 
    .attribute [54] .code stack 2 locals 1 
L0:     iload_1 
L1:     bipush 20 
L3:     isub 
L4:     istore_2 
L5:     iload_2 
L6:     iflt L18 
L9:     iload_2 
L10:    aload_0 
L11:    getfield [6] 
L14:    arraylength 
L15:    if_icmplt L20 
L18:    lconst_0 
L19:    return 
L20:    aload_0 
L21:    getfield [6] 
L24:    iload_2 
L25:    laload 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method synchronized [63] : [64] 
    .attribute [54] .code stack 2 locals 0 
L0:     aload_0 
L1:     sipush 500 
L4:     newarray long 
L6:     putfield [10] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [11] [12] 
.const [3] = Class [13] 
.const [4] = Class [14] 
.const [5] = Class [15] 
.const [6] = Field [16] [17] 
.const [7] = Method [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Field [24] [25] 
.const [11] = Class [26] 
.const [12] = NameAndType [27] [28] 
.const [13] = Utf8 de/audi/tuner/app/combi/CombiBAPIdMapper 
.const [14] = Utf8 java/lang/Object 
.const [15] = Utf8 java/lang/System 
.const [16] = Class [29] 
.const [17] = NameAndType [30] [31] 
.const [18] = Class [32] 
.const [19] = NameAndType [33] [34] 
.const [20] = Class [35] 
.const [21] = NameAndType [36] [37] 
.const [22] = Class [38] 
.const [23] = NameAndType [39] [40] 
.const [24] = Class [41] 
.const [25] = NameAndType [42] [43] 
.const [26] = Utf8 java/lang/System 
.const [27] = Utf8 arraycopy 
.const [28] = Utf8 (Ljava/lang/Object;ILjava/lang/Object;II)V 
.const [29] = Utf8 de/audi/tuner/app/combi/CombiBAPIdMapper 
.const [30] = Utf8 ids 
.const [31] = Utf8 [J 
.const [32] = Utf8 de/audi/tuner/app/combi/CombiBAPIdMapper 
.const [33] = Utf8 getBapId 
.const [34] = Utf8 (J)I 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 <init> 
.const [37] = Utf8 ()V 
.const [38] = Utf8 de/audi/tuner/app/combi/CombiBAPIdMapper 
.const [39] = Utf8 resize 
.const [40] = Utf8 ()V 
.const [41] = Utf8 de/audi/tuner/app/combi/CombiBAPIdMapper 
.const [42] = Utf8 ids 
.const [43] = Utf8 [J 
.const [44] = Utf8 de/audi/tuner/app/combi/CombiBAPIdMapper 
.const [45] = Class [44] 
.const [46] = Utf8 java/lang/Object 
.const [47] = Class [46] 
.const [48] = Utf8 INIT_SIZE 
.const [49] = Utf8 I 
.const [50] = Utf8 OFFSET 
.const [51] = Utf8 I 
.const [52] = Utf8 ids 
.const [53] = Utf8 [J 
.const [54] = Utf8 Code 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 getBapId 
.const [58] = Utf8 (J)I 
.const [59] = Utf8 resize 
.const [60] = Utf8 ()V 
.const [61] = Utf8 getRadioId 
.const [62] = Utf8 (I)J 
.const [63] = Utf8 reset 
.const [64] = Utf8 ()V 
.end class 
