.version 50 0 
.class public super [55] 
.super [57] 
.field private [58] [59] 

.method public annotation [61] : [62] 
    .attribute [60] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [11] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [63] : [64] 
    .attribute [60] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifnull L16 
L7:     aload_0 
L8:     getfield [8] 
L11:    arraylength 
L12:    iconst_2 
L13:    if_icmpge L31 
L16:    getstatic [2] 
L19:    sipush 10000 
L22:    ldc [3] 
L24:    aload_1 
L25:    invokevirtual [9] 
L28:    pop 
L29:    iconst_m1 
L30:    areturn 
L31:    aload_0 
L32:    aload_1 
L33:    invokevirtual [10] 
L36:    astore_2 
L37:    aload_2 
L38:    ifnonnull L43 
L41:    iconst_m1 
L42:    areturn 
L43:    aload_2 
L44:    invokeinterface [13] 0 
L49:    istore_3 
L50:    iload_3 
L51:    aload_0 
L52:    getfield [8] 
L55:    iconst_0 
L56:    iaload 
L57:    if_icmpne L67 
L60:    aload_0 
L61:    getfield [8] 
L64:    iconst_1 
L65:    iaload 
L66:    areturn 
L67:    aload_0 
L68:    getfield [8] 
L71:    iconst_0 
L72:    iaload 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public interface [65] : [66] 
    .attribute [60] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [8] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [67] : [68] 
    .attribute [60] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [12] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [14] [15] 
.const [3] = String [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Class [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = Field [29] [30] 
.const [13] = InterfaceMethod [31] [32] 
.const [14] = Class [33] 
.const [15] = NameAndType [34] [35] 
.const [16] = Utf8 'CheckboxChoiceModelKeyHandler#getNewModelValue: no modelValues configured in handler. widget: %1' 
.const [17] = Utf8 de/esolutions/hmi/widgets/audi/evo/CheckboxChoiceModelKeyHandler 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/evo/ChoiceModelKeyHandler 
.const [19] = Utf8 de/audi/atip/log/LogChannel 
.const [20] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [21] = Class [36] 
.const [22] = NameAndType [37] [38] 
.const [23] = Class [39] 
.const [24] = NameAndType [40] [41] 
.const [25] = Class [42] 
.const [26] = NameAndType [43] [44] 
.const [27] = Class [45] 
.const [28] = NameAndType [46] [47] 
.const [29] = Class [48] 
.const [30] = NameAndType [49] [50] 
.const [31] = Class [51] 
.const [32] = NameAndType [52] [53] 
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/evo/CheckboxChoiceModelKeyHandler 
.const [34] = Utf8 menuItemLogCh 
.const [35] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [36] = Utf8 de/esolutions/hmi/widgets/audi/evo/CheckboxChoiceModelKeyHandler 
.const [37] = Utf8 modelValues 
.const [38] = Utf8 [I 
.const [39] = Utf8 de/audi/atip/log/LogChannel 
.const [40] = Utf8 log 
.const [41] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/evo/CheckboxChoiceModelKeyHandler 
.const [43] = Utf8 getModel 
.const [44] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)Lde/audi/atip/hmi/modelaccess/ChoiceModelGUI; 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/evo/ChoiceModelKeyHandler 
.const [46] = Utf8 <init> 
.const [47] = Utf8 ()V 
.const [48] = Utf8 de/esolutions/hmi/widgets/audi/evo/CheckboxChoiceModelKeyHandler 
.const [49] = Utf8 modelValues 
.const [50] = Utf8 [I 
.const [51] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelGUI 
.const [52] = Utf8 getValue 
.const [53] = Utf8 ()I 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/evo/CheckboxChoiceModelKeyHandler 
.const [55] = Class [54] 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/evo/ChoiceModelKeyHandler 
.const [57] = Class [56] 
.const [58] = Utf8 modelValues 
.const [59] = Utf8 [I 
.const [60] = Utf8 Code 
.const [61] = Utf8 <init> 
.const [62] = Utf8 ()V 
.const [63] = Utf8 getNewModelValue 
.const [64] = Utf8 (Lde/esolutions/hmi/widgets/audi/base/widgets/AbstractWidgetController;)I 
.const [65] = Utf8 getModelValues 
.const [66] = Utf8 ()[I 
.const [67] = Utf8 setModelValues 
.const [68] = Utf8 ([I)V 
.end class 
