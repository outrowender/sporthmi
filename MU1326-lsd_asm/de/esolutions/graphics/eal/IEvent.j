.version 50 0 
.class public super [133] 
.super [135] 
.field private [136] [137] 
.field protected [138] [139] 

.method public [141] : [142] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     iload_3 
L6:     putfield [25] 
L9:     aload_0 
L10:    lload_1 
L11:    putfield [26] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public static [143] : [144] 
    .attribute [140] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnonnull L8 
L4:     lconst_0 
L5:     goto L12 
L8:     aload_0 
L9:     getfield [20] 
L12:    freturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [145] : [146] 
    .attribute [140] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [21] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [147] : [148] 
    .attribute [140] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     lconst_0 
L5:     lcmp 
L6:     ifeq L33 
L9:     aload_0 
L10:    getfield [19] 
L13:    ifeq L28 
L16:    aload_0 
L17:    iconst_0 
L18:    putfield [25] 
L21:    aload_0 
L22:    getfield [20] 
L25:    invokestatic [2] 
L28:    aload_0 
L29:    lconst_0 
L30:    putfield [26] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [149] : [150] 
    .attribute [140] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [20] 
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

.method public [151] : [152] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [3] 
L8:     invokestatic [4] 
L11:    areturn 
L12:    
    .end code 
.end method 

.method public [153] : [154] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [5] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [155] : [156] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [6] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [157] : [158] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [7] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [159] : [160] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [8] 
L8:     freturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [161] : [162] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [9] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [163] : [164] 
    .attribute [140] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [10] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [27] 
L22:    dup 
L23:    lload_1 
L24:    iconst_0 
L25:    invokespecial [23] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [165] : [166] 
    .attribute [140] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [12] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [167] : [168] 
    .attribute [140] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [20] 
L4:     aload_0 
L5:     invokestatic [13] 
L8:     lstore_1 
L9:     lload_1 
L10:    lconst_0 
L11:    lcmp 
L12:    ifne L19 
L15:    aconst_null 
L16:    goto L28 
L19:    new [28] 
L22:    dup 
L23:    lload_1 
L24:    iconst_0 
L25:    invokespecial [24] 
L28:    areturn 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [29] [30] 
.const [3] = Method [31] [32] 
.const [4] = Method [33] [34] 
.const [5] = Method [35] [36] 
.const [6] = Method [37] [38] 
.const [7] = Method [39] [40] 
.const [8] = Method [41] [42] 
.const [9] = Method [43] [44] 
.const [10] = Method [45] [46] 
.const [11] = Class [47] 
.const [12] = Method [48] [49] 
.const [13] = Method [50] [51] 
.const [14] = Class [52] 
.const [15] = Class [53] 
.const [16] = Class [54] 
.const [17] = Class [55] 
.const [18] = Class [56] 
.const [19] = Field [57] [58] 
.const [20] = Field [59] [60] 
.const [21] = Method [61] [62] 
.const [22] = Method [63] [64] 
.const [23] = Method [65] [66] 
.const [24] = Method [67] [68] 
.const [25] = Field [69] [70] 
.const [26] = Field [71] [72] 
.const [27] = Class [73] 
.const [28] = Class [74] 
.const [29] = Class [75] 
.const [30] = NameAndType [76] [77] 
.const [31] = Class [78] 
.const [32] = NameAndType [79] [80] 
.const [33] = Class [81] 
.const [34] = NameAndType [82] [83] 
.const [35] = Class [84] 
.const [36] = NameAndType [85] [86] 
.const [37] = Class [87] 
.const [38] = NameAndType [88] [89] 
.const [39] = Class [90] 
.const [40] = NameAndType [91] [92] 
.const [41] = Class [93] 
.const [42] = NameAndType [94] [95] 
.const [43] = Class [96] 
.const [44] = NameAndType [97] [98] 
.const [45] = Class [99] 
.const [46] = NameAndType [100] [101] 
.const [47] = Utf8 de/esolutions/graphics/eal/IEventMerge 
.const [48] = Class [102] 
.const [49] = NameAndType [103] [104] 
.const [50] = Class [105] 
.const [51] = NameAndType [106] [107] 
.const [52] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [53] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [56] = Utf8 de/esolutions/graphics/eal/event_t 
.const [57] = Class [108] 
.const [58] = NameAndType [109] [110] 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Utf8 de/esolutions/graphics/eal/IEventMerge 
.const [74] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [75] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [76] = Utf8 delete_eal_IEvent 
.const [77] = Utf8 (J)V 
.const [78] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [79] = Utf8 eal_IEvent_getType 
.const [80] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)I 
.const [81] = Utf8 de/esolutions/graphics/eal/event_t 
.const [82] = Utf8 swigToEnum 
.const [83] = Utf8 (I)Lde/esolutions/graphics/eal/event_t; 
.const [84] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [85] = Utf8 eal_IEvent_notifyListener 
.const [86] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)Z 
.const [87] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [88] = Utf8 eal_IEvent_isDeleteable 
.const [89] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)Z 
.const [90] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [91] = Utf8 eal_IEvent_isError 
.const [92] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)Z 
.const [93] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [94] = Utf8 eal_IEvent_getId 
.const [95] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)J 
.const [96] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [97] = Utf8 eal_IEvent_isMergeEvent 
.const [98] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)Z 
.const [99] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [100] = Utf8 eal_IEvent_toEventMerge 
.const [101] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)J 
.const [102] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [103] = Utf8 eal_IEvent_isEventImage 
.const [104] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)Z 
.const [105] = Utf8 de/esolutions/graphics/ealswigJNI 
.const [106] = Utf8 eal_IEvent_toEventImage 
.const [107] = Utf8 (JLde/esolutions/graphics/eal/IEvent;)J 
.const [108] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [109] = Utf8 swigCMemOwn 
.const [110] = Utf8 Z 
.const [111] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [112] = Utf8 swigCPtr 
.const [113] = Utf8 J 
.const [114] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [115] = Utf8 delete 
.const [116] = Utf8 ()V 
.const [117] = Utf8 java/lang/Object 
.const [118] = Utf8 <init> 
.const [119] = Utf8 ()V 
.const [120] = Utf8 de/esolutions/graphics/eal/IEventMerge 
.const [121] = Utf8 <init> 
.const [122] = Utf8 (JZ)V 
.const [123] = Utf8 de/esolutions/graphics/eal/IEventImage 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (JZ)V 
.const [126] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [127] = Utf8 swigCMemOwn 
.const [128] = Utf8 Z 
.const [129] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [130] = Utf8 swigCPtr 
.const [131] = Utf8 J 
.const [132] = Utf8 de/esolutions/graphics/eal/IEvent 
.const [133] = Class [132] 
.const [134] = Utf8 java/lang/Object 
.const [135] = Class [134] 
.const [136] = Utf8 swigCPtr 
.const [137] = Utf8 J 
.const [138] = Utf8 swigCMemOwn 
.const [139] = Utf8 Z 
.const [140] = Utf8 Code 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (JZ)V 
.const [143] = Utf8 getCPtr 
.const [144] = Utf8 (Lde/esolutions/graphics/eal/IEvent;)J 
.const [145] = Utf8 finalize 
.const [146] = Utf8 ()V 
.const [147] = Utf8 delete 
.const [148] = Utf8 ()V 
.const [149] = Utf8 isDeleted 
.const [150] = Utf8 ()Z 
.const [151] = Utf8 getType 
.const [152] = Utf8 ()Lde/esolutions/graphics/eal/event_t; 
.const [153] = Utf8 notifyListener 
.const [154] = Utf8 ()Z 
.const [155] = Utf8 isDeleteable 
.const [156] = Utf8 ()Z 
.const [157] = Utf8 isError 
.const [158] = Utf8 ()Z 
.const [159] = Utf8 getId 
.const [160] = Utf8 ()J 
.const [161] = Utf8 isMergeEvent 
.const [162] = Utf8 ()Z 
.const [163] = Utf8 toEventMerge 
.const [164] = Utf8 ()Lde/esolutions/graphics/eal/IEventMerge; 
.const [165] = Utf8 isEventImage 
.const [166] = Utf8 ()Z 
.const [167] = Utf8 toEventImage 
.const [168] = Utf8 ()Lde/esolutions/graphics/eal/IEventImage; 
.end class 
