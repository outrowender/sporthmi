.version 50 0 
.class public super [105] 
.super [107] 
.field private [108] [109] 

.method public [111] : [112] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [17] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [20] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [113] : [114] 
    .attribute [110] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [14] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [115] : [116] 
    .attribute [110] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [15] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [117] : [118] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [16] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [21] 
L21:    aload_0 
L22:    getfield [14] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [20] 
L33:    aload_0 
L34:    invokespecial [18] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [119] : [120] 
    .attribute [110] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifne L13 
L9:     iconst_1 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [121] : [122] 
    .attribute [110] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     invokestatic [4] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [123] : [124] 
    .attribute [110] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     invokestatic [5] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [125] : [126] 
    .attribute [110] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     invokestatic [6] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [22] 
L22:    dup 
L23:    lload_1 
L24:    iconst_1 
L25:    invokespecial [19] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [127] : [128] 
    .attribute [110] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [14] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [8] 
L9:     aload_1 
L10:    aload_2 
L11:    invokestatic [9] 
L14:    lstore_3 
L15:    lload_3 
L16:    lconst_0 
L17:    lcmp 
L18:    ifne L25 
L21:    aconst_null 
L22:    goto L34 
L25:    new [22] 
L28:    dup 
L29:    lload_3 
L30:    iconst_1 
L31:    invokespecial [19] 
L34:    areturn 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Method [25] [26] 
.const [4] = Method [27] [28] 
.const [5] = Method [29] [30] 
.const [6] = Method [31] [32] 
.const [7] = Class [33] 
.const [8] = Method [34] [35] 
.const [9] = Method [36] [37] 
.const [10] = Class [38] 
.const [11] = Class [39] 
.const [12] = Class [40] 
.const [13] = Class [41] 
.const [14] = Field [42] [43] 
.const [15] = Method [44] [45] 
.const [16] = Field [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Field [56] [57] 
.const [22] = Class [58] 
.const [23] = Class [59] 
.const [24] = NameAndType [60] [61] 
.const [25] = Class [62] 
.const [26] = NameAndType [63] [64] 
.const [27] = Class [65] 
.const [28] = NameAndType [66] [67] 
.const [29] = Class [68] 
.const [30] = NameAndType [69] [70] 
.const [31] = Class [71] 
.const [32] = NameAndType [72] [73] 
.const [33] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [34] = Class [74] 
.const [35] = NameAndType [75] [76] 
.const [36] = Class [77] 
.const [37] = NameAndType [78] [79] 
.const [38] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [39] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [40] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [41] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [42] = Class [80] 
.const [43] = NameAndType [81] [82] 
.const [44] = Class [83] 
.const [45] = NameAndType [84] [85] 
.const [46] = Class [86] 
.const [47] = NameAndType [87] [88] 
.const [48] = Class [89] 
.const [49] = NameAndType [90] [91] 
.const [50] = Class [92] 
.const [51] = NameAndType [93] [94] 
.const [52] = Class [95] 
.const [53] = NameAndType [96] [97] 
.const [54] = Class [98] 
.const [55] = NameAndType [99] [100] 
.const [56] = Class [101] 
.const [57] = NameAndType [102] [103] 
.const [58] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [59] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [60] = Utf8 eal_api_ITemplateNode2D_SWIGUpcast 
.const [61] = Utf8 (J)J 
.const [62] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [63] = Utf8 delete_eal_api_ITemplateNode2D 
.const [64] = Utf8 (J)V 
.const [65] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [66] = Utf8 eal_api_ITemplateNode2D_isValid 
.const [67] = Utf8 (JLde/esolutions/graphics/eal/api/ITemplateNode2D;)Z 
.const [68] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [69] = Utf8 eal_api_ITemplateNode2D_dispose 
.const [70] = Utf8 (JLde/esolutions/graphics/eal/api/ITemplateNode2D;)V 
.const [71] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [72] = Utf8 eal_api_ITemplateNode2D_getRoot 
.const [73] = Utf8 (JLde/esolutions/graphics/eal/api/ITemplateNode2D;)J 
.const [74] = Utf8 de/esolutions/graphics/eal/api/IProject 
.const [75] = Utf8 getCPtr 
.const [76] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;)J 
.const [77] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [78] = Utf8 eal_api_ITemplateNode2D_instantiate 
.const [79] = Utf8 (JLde/esolutions/graphics/eal/api/ITemplateNode2D;JLde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)J 
.const [80] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [81] = Utf8 swigCPtr 
.const [82] = Utf8 J 
.const [83] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [84] = Utf8 delete 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [87] = Utf8 swigCMemOwn 
.const [88] = Utf8 Z 
.const [89] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (JZ)V 
.const [92] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [93] = Utf8 delete 
.const [94] = Utf8 ()V 
.const [95] = Utf8 de/esolutions/graphics/eal/api/INode2D 
.const [96] = Utf8 <init> 
.const [97] = Utf8 (JZ)V 
.const [98] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [99] = Utf8 swigCPtr 
.const [100] = Utf8 J 
.const [101] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [102] = Utf8 swigCMemOwn 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/esolutions/graphics/eal/api/ITemplateNode2D 
.const [105] = Class [104] 
.const [106] = Utf8 de/esolutions/graphics/eal/api/IObject 
.const [107] = Class [106] 
.const [108] = Utf8 swigCPtr 
.const [109] = Utf8 J 
.const [110] = Utf8 Code 
.const [111] = Utf8 <init> 
.const [112] = Utf8 (JZ)V 
.const [113] = Utf8 getCPtr 
.const [114] = Utf8 (Lde/esolutions/graphics/eal/api/ITemplateNode2D;)J 
.const [115] = Utf8 finalize 
.const [116] = Utf8 ()V 
.const [117] = Utf8 delete 
.const [118] = Utf8 ()V 
.const [119] = Utf8 isDeleted 
.const [120] = Utf8 ()Z 
.const [121] = Utf8 isValid 
.const [122] = Utf8 ()Z 
.const [123] = Utf8 dispose 
.const [124] = Utf8 ()V 
.const [125] = Utf8 getRoot 
.const [126] = Utf8 ()Lde/esolutions/graphics/eal/api/INode2D; 
.const [127] = Utf8 instantiate 
.const [128] = Utf8 (Lde/esolutions/graphics/eal/api/IProject;Ljava/lang/String;)Lde/esolutions/graphics/eal/api/INode2D; 
.end class 
