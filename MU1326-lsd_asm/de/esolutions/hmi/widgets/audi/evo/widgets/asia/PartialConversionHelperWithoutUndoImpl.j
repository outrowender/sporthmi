.version 50 0 
.class public super [67] 
.super [69] 

.method public annotation [71] : [72] 
    .attribute [70] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [73] : [74] 
    .attribute [70] .code stack 1 locals 0 
L0:     aload_1 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [75] : [76] 
    .attribute [70] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [7] 
L4:     invokeinterface [10] 0 
L9:     ifne L56 
L12:    iconst_0 
L13:    istore 4 
L15:    iload 4 
L17:    aload_0 
L18:    getfield [7] 
L21:    invokeinterface [11] 0 
L26:    if_icmpge L56 
L29:    aload_2 
L30:    aload_0 
L31:    getfield [7] 
L34:    iload 4 
L36:    invokeinterface [12] 0 
L41:    checkcast [2] 
L44:    iconst_1 
L45:    invokeinterface [13] 0 
L50:    iinc 4 1 
L53:    goto L15 
L56:    aload_0 
L57:    aload_1 
L58:    aload_2 
L59:    aload_3 
L60:    invokespecial [9] 
L63:    aload_0 
L64:    getfield [7] 
L67:    invokeinterface [14] 0 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method protected [77] : [78] 
    .attribute [70] .code stack 2 locals 0 
L0:     aload_2 
L1:     iconst_0 
L2:     invokeinterface [15] 0 
L7:     return 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [16] 
.const [3] = Class [17] 
.const [4] = Class [18] 
.const [5] = Class [19] 
.const [6] = Class [20] 
.const [7] = Field [21] [22] 
.const [8] = Method [23] [24] 
.const [9] = Method [25] [26] 
.const [10] = InterfaceMethod [27] [28] 
.const [11] = InterfaceMethod [29] [30] 
.const [12] = InterfaceMethod [31] [32] 
.const [13] = InterfaceMethod [33] [34] 
.const [14] = InterfaceMethod [35] [36] 
.const [15] = InterfaceMethod [37] [38] 
.const [16] = Utf8 java/lang/String 
.const [17] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithoutUndoImpl 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithUndoImpl 
.const [19] = Utf8 java/util/List 
.const [20] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia 
.const [21] = Class [39] 
.const [22] = NameAndType [40] [41] 
.const [23] = Class [42] 
.const [24] = NameAndType [43] [44] 
.const [25] = Class [45] 
.const [26] = NameAndType [46] [47] 
.const [27] = Class [48] 
.const [28] = NameAndType [49] [50] 
.const [29] = Class [51] 
.const [30] = NameAndType [52] [53] 
.const [31] = Class [54] 
.const [32] = NameAndType [55] [56] 
.const [33] = Class [57] 
.const [34] = NameAndType [58] [59] 
.const [35] = Class [60] 
.const [36] = NameAndType [61] [62] 
.const [37] = Class [63] 
.const [38] = NameAndType [64] [65] 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithoutUndoImpl 
.const [40] = Utf8 userSelectedConversions 
.const [41] = Utf8 Ljava/util/List; 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithUndoImpl 
.const [43] = Utf8 <init> 
.const [44] = Utf8 ()V 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithUndoImpl 
.const [46] = Utf8 handlePartialConversion 
.const [47] = Utf8 (Ljava/lang/String;Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia;Lde/esolutions/hmi/widgets/audi/base/IWordPredictionAccess;)V 
.const [48] = Utf8 java/util/List 
.const [49] = Utf8 isEmpty 
.const [50] = Utf8 ()Z 
.const [51] = Utf8 java/util/List 
.const [52] = Utf8 size 
.const [53] = Utf8 ()I 
.const [54] = Utf8 java/util/List 
.const [55] = Utf8 get 
.const [56] = Utf8 (I)Ljava/lang/Object; 
.const [57] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia 
.const [58] = Utf8 appendRegularCharacters 
.const [59] = Utf8 (Ljava/lang/String;Z)V 
.const [60] = Utf8 java/util/List 
.const [61] = Utf8 clear 
.const [62] = Utf8 ()V 
.const [63] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia 
.const [64] = Utf8 clearUnconvertedCharacters 
.const [65] = Utf8 (Z)V 
.const [66] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithoutUndoImpl 
.const [67] = Class [66] 
.const [68] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/asia/PartialConversionHelperWithUndoImpl 
.const [69] = Class [68] 
.const [70] = Utf8 Code 
.const [71] = Utf8 <init> 
.const [72] = Utf8 ()V 
.const [73] = Utf8 getPartialConversion 
.const [74] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [75] = Utf8 handlePartialConversion 
.const [76] = Utf8 (Ljava/lang/String;Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia;Lde/esolutions/hmi/widgets/audi/base/IWordPredictionAccess;)V 
.const [77] = Utf8 handleEmptySpelling 
.const [78] = Utf8 (Ljava/lang/String;Lde/esolutions/hmi/widgets/audi/evo/widgets/asia/ITouchInputDataAsia;)V 
.end class 
