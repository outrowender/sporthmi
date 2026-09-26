.version 50 0 
.class public super abstract [158] 
.super [160] 
.implements [162] 
.field private final [163] [164] 
.field private [165] [166] 
.field private [167] [168] 
.field protected [169] [170] 

.method protected [172] : [173] 
    .attribute [171] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokevirtual [8] 
L6:     l2f 
L7:     aload_2 
L8:     invokevirtual [9] 
L11:    l2f 
L12:    iconst_0 
L13:    iload 4 
L15:    iload 6 
L17:    invokespecial [23] 
L20:    aload_0 
L21:    aload_1 
L22:    putfield [26] 
L25:    aload_0 
L26:    aload_2 
L27:    putfield [27] 
L30:    aload_0 
L31:    aload_3 
L32:    putfield [28] 
L35:    aload_0 
L36:    aload 5 
L38:    putfield [29] 
L41:    aload_0 
L42:    iconst_1 
L43:    putfield [30] 
L46:    aload_1 
L47:    ldc [2] 
L49:    invokevirtual [15] 
L52:    pop 
L53:    aload_0 
L54:    fconst_1 
L55:    fconst_1 
L56:    fconst_1 
L57:    invokevirtual [16] 
L60:    return 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method public interface [174] : [175] 
    .attribute [171] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [176] : [177] 
    .attribute [171] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     ifnull L12 
L7:     aload_0 
L8:     getfield [11] 
L11:    areturn 
L12:    aload_0 
L13:    aload_0 
L14:    getfield [10] 
L17:    invokevirtual [17] 
L20:    putfield [27] 
L23:    aload_0 
L24:    getfield [11] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method protected [178] : [179] 
    .attribute [171] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ifeq L18 
L7:     aload_0 
L8:     getfield [18] 
L11:    ifne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method public interface [180] : [181] 
    .attribute [171] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [182] : [183] 
    .attribute [171] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected final [184] : [185] 
    .attribute [171] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [186] : [187] 
    .attribute [171] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [24] 
L4:     aload_0 
L5:     getfield [10] 
L8:     ldc [2] 
L10:    invokevirtual [15] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [188] : [189] 
    .attribute [171] .code stack 2 locals 1 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [31] 
L5:     iload_1 
L6:     ifeq L23 
L9:     aload_0 
L10:    getfield [12] 
L13:    invokevirtual [19] 
L16:    ifle L23 
L19:    iconst_1 
L20:    goto L24 
L23:    iconst_0 
L24:    istore_2 
L25:    aload_0 
L26:    getfield [10] 
L29:    invokevirtual [20] 
L32:    iload_2 
L33:    if_icmpne L37 
L36:    return 
L37:    aload_0 
L38:    getfield [10] 
L41:    iload_2 
L42:    invokevirtual [21] 
L45:    pop 
L46:    return 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [190] : [191] 
    .attribute [171] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [25] 
L4:     aload_0 
L5:     getfield [11] 
L8:     ifnull L23 
L11:    aload_0 
L12:    getfield [11] 
L15:    invokevirtual [22] 
L18:    aload_0 
L19:    aconst_null 
L20:    putfield [27] 
L23:    return 
L24:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 13379 
.const [3] = Class [32] 
.const [4] = Class [33] 
.const [5] = Class [34] 
.const [6] = Class [35] 
.const [7] = Class [36] 
.const [8] = Method [37] [38] 
.const [9] = Method [39] [40] 
.const [10] = Field [41] [42] 
.const [11] = Field [43] [44] 
.const [12] = Field [45] [46] 
.const [13] = Field [47] [48] 
.const [14] = Field [49] [50] 
.const [15] = Method [51] [52] 
.const [16] = Method [53] [54] 
.const [17] = Method [55] [56] 
.const [18] = Field [57] [58] 
.const [19] = Method [59] [60] 
.const [20] = Method [61] [62] 
.const [21] = Method [63] [64] 
.const [22] = Method [65] [66] 
.const [23] = Method [67] [68] 
.const [24] = Method [69] [70] 
.const [25] = Method [71] [72] 
.const [26] = Field [73] [74] 
.const [27] = Field [75] [76] 
.const [28] = Field [77] [78] 
.const [29] = Field [79] [80] 
.const [30] = Field [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [34] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [35] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [36] = Utf8 java/lang/String 
.const [37] = Class [85] 
.const [38] = NameAndType [86] [87] 
.const [39] = Class [88] 
.const [40] = NameAndType [89] [90] 
.const [41] = Class [91] 
.const [42] = NameAndType [92] [93] 
.const [43] = Class [94] 
.const [44] = NameAndType [95] [96] 
.const [45] = Class [97] 
.const [46] = NameAndType [98] [99] 
.const [47] = Class [100] 
.const [48] = NameAndType [101] [102] 
.const [49] = Class [103] 
.const [50] = NameAndType [104] [105] 
.const [51] = Class [106] 
.const [52] = NameAndType [107] [108] 
.const [53] = Class [109] 
.const [54] = NameAndType [110] [111] 
.const [55] = Class [112] 
.const [56] = NameAndType [113] [114] 
.const [57] = Class [115] 
.const [58] = NameAndType [116] [117] 
.const [59] = Class [118] 
.const [60] = NameAndType [119] [120] 
.const [61] = Class [121] 
.const [62] = NameAndType [122] [123] 
.const [63] = Class [124] 
.const [64] = NameAndType [125] [126] 
.const [65] = Class [127] 
.const [66] = NameAndType [128] [129] 
.const [67] = Class [130] 
.const [68] = NameAndType [131] [132] 
.const [69] = Class [133] 
.const [70] = NameAndType [134] [135] 
.const [71] = Class [136] 
.const [72] = NameAndType [137] [138] 
.const [73] = Class [139] 
.const [74] = NameAndType [140] [141] 
.const [75] = Class [142] 
.const [76] = NameAndType [143] [144] 
.const [77] = Class [145] 
.const [78] = NameAndType [146] [147] 
.const [79] = Class [148] 
.const [80] = NameAndType [149] [150] 
.const [81] = Class [151] 
.const [82] = NameAndType [152] [153] 
.const [83] = Class [154] 
.const [84] = NameAndType [155] [156] 
.const [85] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [86] = Utf8 getWidth 
.const [87] = Utf8 ()J 
.const [88] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [89] = Utf8 getHeight 
.const [90] = Utf8 ()J 
.const [91] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [92] = Utf8 node 
.const [93] = Utf8 Lde/esolutions/graphics/eal/api/INode3DText; 
.const [94] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [95] = Utf8 interfaceText 
.const [96] = Utf8 Lde/esolutions/graphics/eal/api/IINodeText; 
.const [97] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [98] = Utf8 text 
.const [99] = Utf8 Ljava/lang/String; 
.const [100] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [101] = Utf8 ealManager 
.const [102] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [103] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [104] = Utf8 shouldFlipBack 
.const [105] = Utf8 Z 
.const [106] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [107] = Utf8 rotateX 
.const [108] = Utf8 (F)Z 
.const [109] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [110] = Utf8 setScale 
.const [111] = Utf8 (FFF)V 
.const [112] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [113] = Utf8 getInterfaceText 
.const [114] = Utf8 ()Lde/esolutions/graphics/eal/api/IINodeText; 
.const [115] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [116] = Utf8 isLtr 
.const [117] = Utf8 Z 
.const [118] = Utf8 java/lang/String 
.const [119] = Utf8 length 
.const [120] = Utf8 ()I 
.const [121] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [122] = Utf8 isVisible 
.const [123] = Utf8 ()Z 
.const [124] = Utf8 de/esolutions/graphics/eal/api/INode3DText 
.const [125] = Utf8 setVisible 
.const [126] = Utf8 (Z)Z 
.const [127] = Utf8 de/esolutions/graphics/eal/api/IINodeText 
.const [128] = Utf8 dispose 
.const [129] = Utf8 ()V 
.const [130] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [131] = Utf8 <init> 
.const [132] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;FFZIZ)V 
.const [133] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [134] = Utf8 resetTransformation 
.const [135] = Utf8 ()V 
.const [136] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [137] = Utf8 dispose 
.const [138] = Utf8 ()V 
.const [139] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [140] = Utf8 node 
.const [141] = Utf8 Lde/esolutions/graphics/eal/api/INode3DText; 
.const [142] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [143] = Utf8 interfaceText 
.const [144] = Utf8 Lde/esolutions/graphics/eal/api/IINodeText; 
.const [145] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [146] = Utf8 text 
.const [147] = Utf8 Ljava/lang/String; 
.const [148] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [149] = Utf8 ealManager 
.const [150] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [151] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [152] = Utf8 shouldFlipBack 
.const [153] = Utf8 Z 
.const [154] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [155] = Utf8 visible 
.const [156] = Utf8 Z 
.const [157] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/AbstractWrappedNode3DText 
.const [158] = Class [157] 
.const [159] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [160] = Class [159] 
.const [161] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IBaseWrappedNode3DText 
.const [162] = Class [161] 
.const [163] = Utf8 node 
.const [164] = Utf8 Lde/esolutions/graphics/eal/api/INode3DText; 
.const [165] = Utf8 interfaceText 
.const [166] = Utf8 Lde/esolutions/graphics/eal/api/IINodeText; 
.const [167] = Utf8 text 
.const [168] = Utf8 Ljava/lang/String; 
.const [169] = Utf8 ealManager 
.const [170] = Utf8 Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [171] = Utf8 Code 
.const [172] = Utf8 <init> 
.const [173] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DText;Lde/esolutions/graphics/eal/api/IINodeText;Ljava/lang/String;ILde/esolutions/hmi/widgets/audi/base/eal/EALManager;Z)V 
.const [174] = Utf8 getEALManager 
.const [175] = Utf8 ()Lde/esolutions/hmi/widgets/audi/base/eal/EALManager; 
.const [176] = Utf8 getInterfaceText 
.const [177] = Utf8 ()Lde/esolutions/graphics/eal/api/IINodeText; 
.const [178] = Utf8 shouldFlipBack 
.const [179] = Utf8 ()Z 
.const [180] = Utf8 getTextNode 
.const [181] = Utf8 ()Lde/esolutions/graphics/eal/api/INode3DText; 
.const [182] = Utf8 getText 
.const [183] = Utf8 ()Ljava/lang/String; 
.const [184] = Utf8 storeText 
.const [185] = Utf8 (Ljava/lang/String;)V 
.const [186] = Utf8 resetTransformation 
.const [187] = Utf8 ()V 
.const [188] = Utf8 setVisible 
.const [189] = Utf8 (Z)V 
.const [190] = Utf8 dispose 
.const [191] = Utf8 ()V 
.end class 
