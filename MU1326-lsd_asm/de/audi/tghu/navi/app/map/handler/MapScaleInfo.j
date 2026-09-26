.version 50 0 
.class public super [43] 
.super [45] 
.field public [46] [47] 
.field public [48] [49] 
.field public [50] [51] 
.field public [52] [53] 

.method public annotation [55] : [56] 
    .attribute [54] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [57] : [58] 
    .attribute [54] .code stack 2 locals 2 
L0:     iconst_1 
L1:     istore_2 
L2:     bipush 31 
L4:     iload_2 
L5:     imul 
L6:     aload_0 
L7:     getfield [4] 
L10:    ifeq L19 
L13:    sipush 1231 
L16:    goto L22 
L19:    sipush 1237 
L22:    iadd 
L23:    istore_2 
L24:    bipush 31 
L26:    iload_2 
L27:    imul 
L28:    aload_0 
L29:    getfield [5] 
L32:    iadd 
L33:    istore_2 
L34:    bipush 31 
L36:    iload_2 
L37:    imul 
L38:    aload_0 
L39:    getfield [6] 
L42:    iadd 
L43:    istore_2 
L44:    bipush 31 
L46:    iload_2 
L47:    imul 
L48:    aload_0 
L49:    getfield [7] 
L52:    ifeq L61 
L55:    sipush 1231 
L58:    goto L64 
L61:    sipush 1237 
L64:    iadd 
L65:    istore_2 
L66:    iload_2 
L67:    areturn 
L68:    
    .end code 
.end method 

.method public [59] : [60] 
    .attribute [54] .code stack 2 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     if_acmpne L7 
L5:     iconst_1 
L6:     areturn 
L7:     aload_1 
L8:     ifnonnull L13 
L11:    iconst_0 
L12:    areturn 
L13:    aload_0 
L14:    invokespecial [9] 
L17:    aload_1 
L18:    invokespecial [9] 
L21:    if_acmpeq L26 
L24:    iconst_0 
L25:    areturn 
L26:    aload_1 
L27:    checkcast [2] 
L30:    astore_2 
L31:    aload_0 
L32:    getfield [4] 
L35:    aload_2 
L36:    getfield [4] 
L39:    if_icmpeq L44 
L42:    iconst_0 
L43:    areturn 
L44:    aload_0 
L45:    getfield [5] 
L48:    aload_2 
L49:    getfield [5] 
L52:    if_icmpeq L57 
L55:    iconst_0 
L56:    areturn 
L57:    aload_0 
L58:    getfield [6] 
L61:    aload_2 
L62:    getfield [6] 
L65:    if_icmpeq L70 
L68:    iconst_0 
L69:    areturn 
L70:    aload_0 
L71:    getfield [7] 
L74:    aload_2 
L75:    getfield [7] 
L78:    if_icmpeq L83 
L81:    iconst_0 
L82:    areturn 
L83:    iconst_1 
L84:    areturn 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [10] 
.const [3] = Class [11] 
.const [4] = Field [12] [13] 
.const [5] = Field [14] [15] 
.const [6] = Field [16] [17] 
.const [7] = Field [18] [19] 
.const [8] = Method [20] [21] 
.const [9] = Method [22] [23] 
.const [10] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [11] = Utf8 java/lang/Object 
.const [12] = Class [24] 
.const [13] = NameAndType [25] [26] 
.const [14] = Class [27] 
.const [15] = NameAndType [28] [29] 
.const [16] = Class [30] 
.const [17] = NameAndType [31] [32] 
.const [18] = Class [33] 
.const [19] = NameAndType [34] [35] 
.const [20] = Class [36] 
.const [21] = NameAndType [37] [38] 
.const [22] = Class [39] 
.const [23] = NameAndType [40] [41] 
.const [24] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [25] = Utf8 isMaxScale 
.const [26] = Utf8 Z 
.const [27] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [28] = Utf8 scale 
.const [29] = Utf8 I 
.const [30] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [31] = Utf8 scaleUnit 
.const [32] = Utf8 I 
.const [33] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [34] = Utf8 scaleValidity 
.const [35] = Utf8 Z 
.const [36] = Utf8 java/lang/Object 
.const [37] = Utf8 <init> 
.const [38] = Utf8 ()V 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 getClass 
.const [41] = Utf8 ()Ljava/lang/Class; 
.const [42] = Utf8 de/audi/tghu/navi/app/map/handler/MapScaleInfo 
.const [43] = Class [42] 
.const [44] = Utf8 java/lang/Object 
.const [45] = Class [44] 
.const [46] = Utf8 scale 
.const [47] = Utf8 I 
.const [48] = Utf8 scaleUnit 
.const [49] = Utf8 I 
.const [50] = Utf8 scaleValidity 
.const [51] = Utf8 Z 
.const [52] = Utf8 isMaxScale 
.const [53] = Utf8 Z 
.const [54] = Utf8 Code 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 hashCode 
.const [58] = Utf8 ()I 
.const [59] = Utf8 equals 
.const [60] = Utf8 (Ljava/lang/Object;)Z 
.end class 
