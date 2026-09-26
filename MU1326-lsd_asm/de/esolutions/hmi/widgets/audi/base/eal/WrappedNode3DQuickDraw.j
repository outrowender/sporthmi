.version 50 0 
.class public super [115] 
.super [117] 
.implements [119] 
.field private final [120] [121] 
.field private [122] [123] 
.field private [124] [125] 

.method public [127] : [128] 
    .attribute [126] .code stack 7 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     i2f 
L4:     iload_3 
L5:     i2f 
L6:     iconst_0 
L7:     iload 4 
L9:     iload 5 
L11:    invokespecial [15] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [20] 
L19:    return 
L20:    
    .end code 
.end method 

.method public interface [129] : [130] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public annotation [131] : [132] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [16] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [133] : [134] 
    .attribute [126] .code stack 4 locals 1 
L0:     fload_1 
L1:     fconst_0 
L2:     fcmpl 
L3:     ifne L13 
L6:     fload_2 
L7:     fconst_0 
L8:     fcmpl 
L9:     ifne L13 
L12:    return 
L13:    aload_0 
L14:    getfield [6] 
L17:    ifnull L57 
L20:    fload_1 
L21:    aload_0 
L22:    getfield [7] 
L25:    fconst_2 
L26:    fdiv 
L27:    fsub 
L28:    fstore_1 
L29:    fload_2 
L30:    aload_0 
L31:    getfield [8] 
L34:    fconst_2 
L35:    fdiv 
L36:    fsub 
L37:    fstore_2 
L38:    new [21] 
L41:    dup 
L42:    fload_1 
L43:    fload_2 
L44:    invokespecial [17] 
L47:    astore_3 
L48:    aload_0 
L49:    getfield [6] 
L52:    aload_3 
L53:    invokevirtual [9] 
L56:    pop 
L57:    return 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [135] : [136] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [10] 
L4:     fload_1 
L5:     fcmpl 
L6:     ifne L10 
L9:     return 
L10:    aload_0 
L11:    fload_1 
L12:    putfield [22] 
L15:    aload_0 
L16:    getfield [6] 
L19:    ifnull L31 
L22:    aload_0 
L23:    getfield [6] 
L26:    fload_1 
L27:    invokevirtual [11] 
L30:    pop 
L31:    return 
L32:    
    .end code 
.end method 

.method public [137] : [138] 
    .attribute [126] .code stack 3 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [18] 
L5:     ifeq L9 
L8:     return 
L9:     aload_0 
L10:    iload_1 
L11:    invokespecial [19] 
L14:    aload_0 
L15:    getfield [6] 
L18:    ifnull L31 
L21:    aload_0 
L22:    getfield [6] 
L25:    iload_1 
L26:    i2l 
L27:    invokevirtual [12] 
L30:    pop 
L31:    return 
L32:    
    .end code 
.end method 

.method private [139] : [140] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [141] : [142] 
    .attribute [126] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     iload_1 
L5:     if_icmpne L12 
L8:     iconst_1 
L9:     goto L13 
L12:    iconst_0 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [143] : [144] 
    .attribute [126] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [6] 
L4:     ifnull L15 
L7:     aload_0 
L8:     getfield [6] 
L11:    invokevirtual [14] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = Class [25] 
.const [4] = Class [26] 
.const [5] = Class [27] 
.const [6] = Field [28] [29] 
.const [7] = Field [30] [31] 
.const [8] = Field [32] [33] 
.const [9] = Method [34] [35] 
.const [10] = Field [36] [37] 
.const [11] = Method [38] [39] 
.const [12] = Method [40] [41] 
.const [13] = Field [42] [43] 
.const [14] = Method [44] [45] 
.const [15] = Method [46] [47] 
.const [16] = Method [48] [49] 
.const [17] = Method [50] [51] 
.const [18] = Method [52] [53] 
.const [19] = Method [54] [55] 
.const [20] = Field [56] [57] 
.const [21] = Class [58] 
.const [22] = Field [59] [60] 
.const [23] = Field [61] [62] 
.const [24] = Utf8 de/esolutions/graphics/eal/Vec2f 
.const [25] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [26] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [27] = Utf8 de/esolutions/graphics/eal/api/INode3DQuickDraw 
.const [28] = Class [63] 
.const [29] = NameAndType [64] [65] 
.const [30] = Class [66] 
.const [31] = NameAndType [67] [68] 
.const [32] = Class [69] 
.const [33] = NameAndType [70] [71] 
.const [34] = Class [72] 
.const [35] = NameAndType [73] [74] 
.const [36] = Class [75] 
.const [37] = NameAndType [76] [77] 
.const [38] = Class [78] 
.const [39] = NameAndType [79] [80] 
.const [40] = Class [81] 
.const [41] = NameAndType [82] [83] 
.const [42] = Class [84] 
.const [43] = NameAndType [85] [86] 
.const [44] = Class [87] 
.const [45] = NameAndType [88] [89] 
.const [46] = Class [90] 
.const [47] = NameAndType [91] [92] 
.const [48] = Class [93] 
.const [49] = NameAndType [94] [95] 
.const [50] = Class [96] 
.const [51] = NameAndType [97] [98] 
.const [52] = Class [99] 
.const [53] = NameAndType [100] [101] 
.const [54] = Class [102] 
.const [55] = NameAndType [103] [104] 
.const [56] = Class [105] 
.const [57] = NameAndType [106] [107] 
.const [58] = Utf8 de/esolutions/graphics/eal/Vec2f 
.const [59] = Class [108] 
.const [60] = NameAndType [109] [110] 
.const [61] = Class [111] 
.const [62] = NameAndType [112] [113] 
.const [63] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [64] = Utf8 node 
.const [65] = Utf8 Lde/esolutions/graphics/eal/api/INode3DQuickDraw; 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [67] = Utf8 unscaledWidth 
.const [68] = Utf8 F 
.const [69] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [70] = Utf8 unscaledHeight 
.const [71] = Utf8 F 
.const [72] = Utf8 de/esolutions/graphics/eal/api/INode3DQuickDraw 
.const [73] = Utf8 add 
.const [74] = Utf8 (Lde/esolutions/graphics/eal/Vec2f;)Z 
.const [75] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [76] = Utf8 lineWidth 
.const [77] = Utf8 F 
.const [78] = Utf8 de/esolutions/graphics/eal/api/INode3DQuickDraw 
.const [79] = Utf8 setLineWidth 
.const [80] = Utf8 (F)Z 
.const [81] = Utf8 de/esolutions/graphics/eal/api/INode3DQuickDraw 
.const [82] = Utf8 setColor 
.const [83] = Utf8 (J)Z 
.const [84] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [85] = Utf8 color 
.const [86] = Utf8 I 
.const [87] = Utf8 de/esolutions/graphics/eal/api/INode3DQuickDraw 
.const [88] = Utf8 clearArea 
.const [89] = Utf8 ()Z 
.const [90] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Lde/esolutions/graphics/eal/api/INode3D;FFZIZ)V 
.const [93] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [94] = Utf8 resetTransformation 
.const [95] = Utf8 ()V 
.const [96] = Utf8 de/esolutions/graphics/eal/Vec2f 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (FF)V 
.const [99] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [100] = Utf8 sameColor 
.const [101] = Utf8 (I)Z 
.const [102] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [103] = Utf8 storeColor 
.const [104] = Utf8 (I)V 
.const [105] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [106] = Utf8 node 
.const [107] = Utf8 Lde/esolutions/graphics/eal/api/INode3DQuickDraw; 
.const [108] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [109] = Utf8 lineWidth 
.const [110] = Utf8 F 
.const [111] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [112] = Utf8 color 
.const [113] = Utf8 I 
.const [114] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3DQuickDraw 
.const [115] = Class [114] 
.const [116] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/WrappedNode3D 
.const [117] = Class [116] 
.const [118] = Utf8 de/esolutions/hmi/widgets/audi/base/eal/IWrappedNode3DQuickDraw 
.const [119] = Class [118] 
.const [120] = Utf8 node 
.const [121] = Utf8 Lde/esolutions/graphics/eal/api/INode3DQuickDraw; 
.const [122] = Utf8 lineWidth 
.const [123] = Utf8 F 
.const [124] = Utf8 color 
.const [125] = Utf8 I 
.const [126] = Utf8 Code 
.const [127] = Utf8 <init> 
.const [128] = Utf8 (Lde/esolutions/graphics/eal/api/INode3DQuickDraw;IIIZ)V 
.const [129] = Utf8 getQuickDrawNode 
.const [130] = Utf8 ()Lde/esolutions/graphics/eal/api/INode3DQuickDraw; 
.const [131] = Utf8 resetTransformation 
.const [132] = Utf8 ()V 
.const [133] = Utf8 add 
.const [134] = Utf8 (FF)V 
.const [135] = Utf8 setLineWidth 
.const [136] = Utf8 (F)V 
.const [137] = Utf8 setLineColor 
.const [138] = Utf8 (I)V 
.const [139] = Utf8 storeColor 
.const [140] = Utf8 (I)V 
.const [141] = Utf8 sameColor 
.const [142] = Utf8 (I)Z 
.const [143] = Utf8 clearArea 
.const [144] = Utf8 ()V 
.end class 
