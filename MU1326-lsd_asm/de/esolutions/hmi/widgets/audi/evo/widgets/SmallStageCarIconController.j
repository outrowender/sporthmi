.version 50 0 
.class public super [55] 
.super [57] 

.method public annotation [59] : [60] 
    .attribute [58] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [10] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [61] : [62] 
    .attribute [58] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [63] : [64] 
    .attribute [58] .code stack 2 locals 2 
L0:     aload_0 
L1:     getfield [8] 
L4:     invokevirtual [9] 
L7:     invokeinterface [12] 0 
L12:    istore_2 
L13:    invokestatic [2] 
L16:    istore_3 
L17:    iload_2 
L18:    bipush 20 
L20:    if_icmpne L37 
L23:    iload_3 
L24:    ifeq L32 
L27:    iconst_0 
L28:    istore_1 
L29:    goto L83 
L32:    iconst_1 
L33:    istore_1 
L34:    goto L83 
L37:    iload_2 
L38:    bipush 21 
L40:    if_icmpne L57 
L43:    iload_3 
L44:    ifeq L52 
L47:    iconst_2 
L48:    istore_1 
L49:    goto L83 
L52:    iconst_3 
L53:    istore_1 
L54:    goto L83 
L57:    aload_0 
L58:    getfield [8] 
L61:    invokevirtual [9] 
L64:    invokeinterface [13] 0 
L69:    ifeq L83 
L72:    iload_3 
L73:    ifeq L81 
L76:    iconst_4 
L77:    istore_1 
L78:    goto L83 
L81:    iconst_5 
L82:    istore_1 
L83:    aload_0 
L84:    iload_1 
L85:    invokespecial [11] 
L88:    areturn 
L89:    nop 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Class [20] 
.const [8] = Field [21] [22] 
.const [9] = Method [23] [24] 
.const [10] = Method [25] [26] 
.const [11] = Method [27] [28] 
.const [12] = InterfaceMethod [29] [30] 
.const [13] = InterfaceMethod [31] [32] 
.const [14] = Class [33] 
.const [15] = NameAndType [34] [35] 
.const [16] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageCarIconController 
.const [17] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [18] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [19] = Utf8 de/audi/tghu/hmi/evo/ICarCodingHelper 
.const [20] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
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
.const [33] = Utf8 de/esolutions/hmi/widgets/audi/base/AbstractWidget 
.const [34] = Utf8 isRightHandDrive 
.const [35] = Utf8 ()Z 
.const [36] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageCarIconController 
.const [37] = Utf8 terminal 
.const [38] = Utf8 Lde/esolutions/hmi/widgets/audi/base/HMITerminalImpl; 
.const [39] = Utf8 de/esolutions/hmi/widgets/audi/base/HMITerminalImpl 
.const [40] = Utf8 getCarCodingHelper 
.const [41] = Utf8 ()Lde/audi/tghu/hmi/evo/ICarCodingHelper; 
.const [42] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [43] = Utf8 <init> 
.const [44] = Utf8 ()V 
.const [45] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [46] = Utf8 getBitmap 
.const [47] = Utf8 (I)I 
.const [48] = Utf8 de/audi/tghu/hmi/evo/ICarCodingHelper 
.const [49] = Utf8 getCarType 
.const [50] = Utf8 ()I 
.const [51] = Utf8 de/audi/tghu/hmi/evo/ICarCodingHelper 
.const [52] = Utf8 isR8 
.const [53] = Utf8 ()Z 
.const [54] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/SmallStageCarIconController 
.const [55] = Class [54] 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/evo/widgets/IconController 
.const [57] = Class [56] 
.const [58] = Utf8 Code 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 processModelUpdateEvent 
.const [62] = Utf8 (Lde/audi/atip/hmi/event/ModelUpdateEvent;)V 
.const [63] = Utf8 getBitmap 
.const [64] = Utf8 (I)I 
.end class 
