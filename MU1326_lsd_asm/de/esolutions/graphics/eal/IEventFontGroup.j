.version 50 0 
.class public super [79] 
.super [81] 
.field private [82] [83] 

.method public [85] : [86] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokestatic [2] 
L5:     iload_3 
L6:     invokespecial [12] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [15] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [87] : [88] 
    .attribute [84] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [9] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [89] : [90] 
    .attribute [84] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [91] : [92] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [11] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [16] 
L21:    aload_0 
L22:    getfield [9] 
L25:    invokestatic [3] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [15] 
L33:    aload_0 
L34:    invokespecial [13] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [84] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [9] 
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

.method public [95] : [96] 
    .attribute [84] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [9] 
L4:     aload_0 
L5:     invokestatic [4] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [17] 
L22:    dup 
L23:    lload_1 
L24:    iconst_0 
L25:    invokespecial [14] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [18] [19] 
.const [3] = Method [20] [21] 
.const [4] = Method [22] [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Field [28] [29] 
.const [10] = Method [30] [31] 
.const [11] = Field [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Method [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Class [44] 
.const [18] = Class [45] 
.const [19] = NameAndType [46] [47] 
.const [20] = Class [48] 
.const [21] = NameAndType [49] [50] 
.const [22] = Class [51] 
.const [23] = NameAndType [52] [53] 
.const [24] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [25] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [26] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [27] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [28] = Class [54] 
.const [29] = NameAndType [55] [56] 
.const [30] = Class [57] 
.const [31] = NameAndType [58] [59] 
.const [32] = Class [60] 
.const [33] = NameAndType [61] [62] 
.const [34] = Class [63] 
.const [35] = NameAndType [64] [65] 
.const [36] = Class [66] 
.const [37] = NameAndType [67] [68] 
.const [38] = Class [69] 
.const [39] = NameAndType [70] [71] 
.const [40] = Class [72] 
.const [41] = NameAndType [73] [74] 
.const [42] = Class [75] 
.const [43] = NameAndType [76] [77] 
.const [44] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [45] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [46] = Utf8 eal_IEventFontGroup_SWIGUpcast 
.const [47] = Utf8 (J)J 
.const [48] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [49] = Utf8 delete_eal_IEventFontGroup 
.const [50] = Utf8 (J)V 
.const [51] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [52] = Utf8 eal_IEventFontGroup_requestFontgroup 
.const [53] = Utf8 (JLde/esolutions/graphics/eal/IEventFontGroup;)J 
.const [54] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [55] = Utf8 swigCPtr 
.const [56] = Utf8 J 
.const [57] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [58] = Utf8 delete 
.const [59] = Utf8 ()V 
.const [60] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [61] = Utf8 swigCMemOwn 
.const [62] = Utf8 Z 
.const [63] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [64] = Utf8 <init> 
.const [65] = Utf8 (JZ)V 
.const [66] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [67] = Utf8 delete 
.const [68] = Utf8 ()V 
.const [69] = Utf8 de/esolutions/graphics/eal/api/IFontGroupAsync 
.const [70] = Utf8 <init> 
.const [71] = Utf8 (JZ)V 
.const [72] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [73] = Utf8 swigCPtr 
.const [74] = Utf8 J 
.const [75] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [76] = Utf8 swigCMemOwn 
.const [77] = Utf8 Z 
.const [78] = Utf8 de/esolutions/graphics/eal/IEventFontGroup 
.const [79] = Class [78] 
.const [80] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [81] = Class [80] 
.const [82] = Utf8 swigCPtr 
.const [83] = Utf8 J 
.const [84] = Utf8 Code 
.const [85] = Utf8 <init> 
.const [86] = Utf8 (JZ)V 
.const [87] = Utf8 getCPtr 
.const [88] = Utf8 (Lde/esolutions/graphics/eal/IEventFontGroup;)J 
.const [89] = Utf8 finalize 
.const [90] = Utf8 ()V 
.const [91] = Utf8 delete 
.const [92] = Utf8 ()V 
.const [93] = Utf8 isDeleted 
.const [94] = Utf8 ()Z 
.const [95] = Utf8 requestFontgroup 
.const [96] = Utf8 ()Lde/esolutions/graphics/eal/api/IFontGroupAsync; 
.end class 
