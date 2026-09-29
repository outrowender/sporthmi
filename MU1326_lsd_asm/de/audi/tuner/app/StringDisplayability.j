.version 50 0 
.class public super [55] 
.super [57] 
.field private final [58] [59] 

.method public [61] : [62] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     aload_0 
L5:     sipush 2048 
L8:     newarray int 
L10:    putfield [13] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [60] .code stack 5 locals 1 
L0:     aload_1 
L1:     arraylength 
L2:     aload_0 
L3:     getfield [8] 
L6:     arraylength 
L7:     if_icmpeq L20 
L10:    new [14] 
L13:    dup 
L14:    ldc [3] 
L16:    invokespecial [11] 
L19:    athrow 
L20:    iconst_0 
L21:    istore_2 
L22:    iload_2 
L23:    aload_1 
L24:    arraylength 
L25:    if_icmpge L46 
L28:    aload_0 
L29:    getfield [8] 
L32:    iload_2 
L33:    dup2 
L34:    iaload 
L35:    aload_1 
L36:    iload_2 
L37:    iaload 
L38:    ior 
L39:    iastore 
L40:    iinc 2 1 
L43:    goto L22 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [65] : [66] 
    .attribute [60] .code stack 6 locals 6 
L0:     iconst_0 
L1:     istore_2 
L2:     iconst_0 
L3:     istore_3 
L4:     aload_1 
L5:     invokevirtual [9] 
L8:     astore 4 
L10:    iconst_0 
L11:    istore 5 
L13:    iload 5 
L15:    aload 4 
L17:    arraylength 
L18:    if_icmpge L71 
L21:    aload 4 
L23:    iload 5 
L25:    caload 
L26:    bipush 32 
L28:    idiv 
L29:    istore 6 
L31:    aload 4 
L33:    iload 5 
L35:    caload 
L36:    bipush 32 
L38:    irem 
L39:    istore 7 
L41:    aload_0 
L42:    getfield [8] 
L45:    iload 6 
L47:    iaload 
L48:    iconst_1 
L49:    iload 7 
L51:    ishl 
L52:    iand 
L53:    ifeq L62 
L56:    iinc 2 1 
L59:    goto L65 
L62:    iinc 3 1 
L65:    iinc 5 1 
L68:    goto L13 
L71:    new [15] 
L74:    dup 
L75:    aload 4 
L77:    arraylength 
L78:    iload_2 
L79:    iload_3 
L80:    aconst_null 
L81:    invokespecial [12] 
L84:    areturn 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = String [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Class [21] 
.const [8] = Field [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Field [32] [33] 
.const [14] = Class [34] 
.const [15] = Class [35] 
.const [16] = Utf8 java/lang/IllegalArgumentException 
.const [17] = Utf8 '[StringDisplayability.addLookupTable] wrong length' 
.const [18] = Utf8 de/audi/tuner/app/StringDisplayability$Result 
.const [19] = Utf8 de/audi/tuner/app/StringDisplayability 
.const [20] = Utf8 java/lang/Object 
.const [21] = Utf8 java/lang/String 
.const [22] = Class [36] 
.const [23] = NameAndType [37] [38] 
.const [24] = Class [39] 
.const [25] = NameAndType [40] [41] 
.const [26] = Class [42] 
.const [27] = NameAndType [43] [44] 
.const [28] = Class [45] 
.const [29] = NameAndType [46] [47] 
.const [30] = Class [48] 
.const [31] = NameAndType [49] [50] 
.const [32] = Class [51] 
.const [33] = NameAndType [52] [53] 
.const [34] = Utf8 java/lang/IllegalArgumentException 
.const [35] = Utf8 de/audi/tuner/app/StringDisplayability$Result 
.const [36] = Utf8 de/audi/tuner/app/StringDisplayability 
.const [37] = Utf8 charArr 
.const [38] = Utf8 [I 
.const [39] = Utf8 java/lang/String 
.const [40] = Utf8 toCharArray 
.const [41] = Utf8 ()[C 
.const [42] = Utf8 java/lang/Object 
.const [43] = Utf8 <init> 
.const [44] = Utf8 ()V 
.const [45] = Utf8 java/lang/IllegalArgumentException 
.const [46] = Utf8 <init> 
.const [47] = Utf8 (Ljava/lang/String;)V 
.const [48] = Utf8 de/audi/tuner/app/StringDisplayability$Result 
.const [49] = Utf8 <init> 
.const [50] = Utf8 (IIILde/audi/tuner/app/StringDisplayability$1;)V 
.const [51] = Utf8 de/audi/tuner/app/StringDisplayability 
.const [52] = Utf8 charArr 
.const [53] = Utf8 [I 
.const [54] = Utf8 de/audi/tuner/app/StringDisplayability 
.const [55] = Class [54] 
.const [56] = Utf8 java/lang/Object 
.const [57] = Class [56] 
.const [58] = Utf8 charArr 
.const [59] = Utf8 [I 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 addLookupTable 
.const [64] = Utf8 ([I)V 
.const [65] = Utf8 check 
.const [66] = Utf8 (Ljava/lang/String;)Lde/audi/tuner/app/StringDisplayability$Result; 
.end class 
