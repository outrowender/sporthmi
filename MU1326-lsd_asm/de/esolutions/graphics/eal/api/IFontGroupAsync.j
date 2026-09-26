.version 50 0 
.class public super [87] 
.super [89] 
.field private [90] [91] 
.field protected [92] [93] 

.method public [95] : [96] 
    .attribute [94] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [17] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [18] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [97] : [98] 
    .attribute [94] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [13] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [99] : [100] 
    .attribute [94] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [101] : [102] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [12] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [17] 
L21:    aload_0 
L22:    getfield [13] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [18] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
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

.method public [105] : [106] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [3] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [94] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [4] 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [109] : [110] 
    .attribute [94] .code stack 6 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_0 
L5:     aload_1 
L6:     invokestatic [5] 
L9:     aload_1 
L10:    invokestatic [6] 
L13:    lstore_2 
L14:    lload_2 
L15:    lconst_0 
L16:    lcmp 
L17:    ifne L24 
L20:    aconst_null 
L21:    goto L33 
L24:    new [19] 
L27:    dup 
L28:    lload_2 
L29:    iconst_1 
L30:    invokespecial [16] 
L33:    areturn 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [20] [21] 
.const [3] = Method [22] [23] 
.const [4] = Method [24] [25] 
.const [5] = Method [26] [27] 
.const [6] = Method [28] [29] 
.const [7] = Class [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Field [35] [36] 
.const [13] = Field [37] [38] 
.const [14] = Method [39] [40] 
.const [15] = Method [41] [42] 
.const [16] = Method [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = Field [47] [48] 
.const [19] = Class [49] 
.const [20] = Class [50] 
.const [21] = NameAndType [51] [52] 
.const [22] = Class [53] 
.const [23] = NameAndType [54] [55] 
.const [24] = Class [56] 
.const [25] = NameAndType [57] [58] 
.const [26] = Class [59] 
.const [27] = NameAndType [60] [61] 
.const [28] = Class [62] 
.const [29] = NameAndType [63] [64] 
.const [30] = Utf8 de/esolutions/graphics/eal/api/IFontGroup 
.const [31] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [34] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Utf8 de/esolutions/graphics/eal/api/IFontGroup 
.const [50] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [51] = Utf8 delete_eal_api_IFontGroupAsync 
.const [52] = Utf8 (J)V 
.const [53] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [54] = Utf8 eal_api_IFontGroupAsync_addFont 
.const [55] = Utf8 (JLde/esolutions/graphics/eal/api/IFontGroupAsync;Ljava/lang/String;)Z 
.const [56] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [57] = Utf8 eal_api_IFontGroupAsync_linkUnicodeRanges 
.const [58] = Utf8 (JLde/esolutions/graphics/eal/api/IFontGroupAsync;Ljava/lang/String;)Z 
.const [59] = Utf8 de/esolutions/graphics/eal/api/IManager 
.const [60] = Utf8 getCPtr 
.const [61] = Utf8 (Lde/esolutions/graphics/eal/api/IManager;)J 
.const [62] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [63] = Utf8 eal_api_IFontGroupAsync_takeOwnership 
.const [64] = Utf8 (JLde/esolutions/graphics/eal/api/IFontGroupAsync;JLde/esolutions/graphics/eal/api/IManager;)J 
.const [65] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [66] = Utf8 swigCMemOwn 
.const [67] = Utf8 Z 
.const [68] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [69] = Utf8 swigCPtr 
.const [70] = Utf8 J 
.const [71] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [72] = Utf8 delete 
.const [73] = Utf8 ()V 
.const [74] = Utf8 java/lang/Object 
.const [75] = Utf8 <init> 
.const [76] = Utf8 ()V 
.const [77] = Utf8 de/esolutions/graphics/eal/api/IFontGroup 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (JZ)V 
.const [80] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [81] = Utf8 swigCMemOwn 
.const [82] = Utf8 Z 
.const [83] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [84] = Utf8 swigCPtr 
.const [85] = Utf8 J 
.const [86] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [87] = Class [86] 
.const [88] = Utf8 java/lang/Object 
.const [89] = Class [88] 
.const [90] = Utf8 swigCPtr 
.const [91] = Utf8 J 
.const [92] = Utf8 swigCMemOwn 
.const [93] = Utf8 Z 
.const [94] = Utf8 Code 
.const [95] = Utf8 <init> 
.const [96] = Utf8 (JZ)V 
.const [97] = Utf8 getCPtr 
.const [98] = Utf8 (Lde/esolutions/graphics/eal/api/IFontGroupAsync;)J 
.const [99] = Utf8 finalize 
.const [100] = Utf8 ()V 
.const [101] = Utf8 delete 
.const [102] = Utf8 ()V 
.const [103] = Utf8 isDeleted 
.const [104] = Utf8 ()Z 
.const [105] = Utf8 addFont 
.const [106] = Utf8 (Ljava/lang/String;)Z 
.const [107] = Utf8 linkUnicodeRanges 
.const [108] = Utf8 (Ljava/lang/String;)Z 
.const [109] = Utf8 takeOwnership 
.const [110] = Utf8 (Lde/esolutions/graphics/eal/api/IManager;)Lde/esolutions/graphics/eal/api/IFontGroup; 
.end class 
