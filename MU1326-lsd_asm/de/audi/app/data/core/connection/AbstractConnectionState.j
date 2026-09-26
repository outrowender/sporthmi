.version 50 0 
.class public super [76] 
.super [78] 
.field private static final [79] [80] 
.field private static final [81] [82] 
.field private final [83] [84] 
.field private final [85] [86] 

.method public [88] : [89] 
    .attribute [87] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [15] 
L5:     aload_0 
L6:     iconst_1 
L7:     newarray int 
L9:     dup 
L10:    iconst_0 
L11:    iconst_1 
L12:    iastore 
L13:    putfield [16] 
L16:    aload_0 
L17:    aload_0 
L18:    bipush 93 
L20:    invokevirtual [10] 
L23:    putfield [17] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected interface [90] : [91] 
    .attribute [87] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [9] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [92] : [93] 
    .attribute [87] .code stack 4 locals 1 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L9 
L5:     aload_1 
L6:     ifnonnull L10 
L9:     return 
L10:    aload_1 
L11:    invokevirtual [12] 
L14:    tableswitch 0 
            L56 
            L56 
            L56 
            L56 
            L61 
            L61 
            L61 
            default : L61 

L56:    iconst_1 
L57:    istore_3 
L58:    goto L63 
L61:    iconst_0 
L62:    istore_3 
L63:    aload_0 
L64:    getfield [13] 
L67:    ldc [2] 
L69:    ldc [3] 
L71:    iload_3 
L72:    invokevirtual [14] 
L75:    pop 
L76:    aload_0 
L77:    getfield [11] 
L80:    iload_3 
L81:    ifeq L88 
L84:    iconst_1 
L85:    goto L89 
L88:    iconst_0 
L89:    invokeinterface [18] 0 
L94:    return 
L95:    nop 
L96:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [19] 
.const [4] = Class [20] 
.const [5] = Class [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Field [25] [26] 
.const [10] = Method [27] [28] 
.const [11] = Field [29] [30] 
.const [12] = Method [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Method [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Field [39] [40] 
.const [17] = Field [41] [42] 
.const [18] = InterfaceMethod [43] [44] 
.const [19] = Utf8 'AbstractConnectionState#updateStateDataConnection(): connected=%1' 
.const [20] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [21] = Utf8 de/audi/app/data/core/AbstractDataConnectionComponent 
.const [22] = Utf8 org/dsi/ifc/networking/DataConnectionStateStruct 
.const [23] = Utf8 de/audi/atip/log/LogChannel 
.const [24] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
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
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [46] = Utf8 attributeNotifications 
.const [47] = Utf8 [I 
.const [48] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [49] = Utf8 getChoiceModel 
.const [50] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [51] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [52] = Utf8 connectionState 
.const [53] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [54] = Utf8 org/dsi/ifc/networking/DataConnectionStateStruct 
.const [55] = Utf8 getContextState 
.const [56] = Utf8 ()I 
.const [57] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [58] = Utf8 log 
.const [59] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [60] = Utf8 de/audi/atip/log/LogChannel 
.const [61] = Utf8 log 
.const [62] = Utf8 (ILjava/lang/String;Z)Z 
.const [63] = Utf8 de/audi/app/data/core/AbstractDataConnectionComponent 
.const [64] = Utf8 <init> 
.const [65] = Utf8 (Lde/audi/app/data/core/IDataApplication;)V 
.const [66] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [67] = Utf8 attributeNotifications 
.const [68] = Utf8 [I 
.const [69] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [70] = Utf8 connectionState 
.const [71] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [72] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [73] = Utf8 setValue 
.const [74] = Utf8 (I)V 
.const [75] = Utf8 de/audi/app/data/core/connection/AbstractConnectionState 
.const [76] = Class [75] 
.const [77] = Utf8 de/audi/app/data/core/AbstractDataConnectionComponent 
.const [78] = Class [77] 
.const [79] = Utf8 DISCONNECTED 
.const [80] = Utf8 I 
.const [81] = Utf8 CONNECTED 
.const [82] = Utf8 I 
.const [83] = Utf8 attributeNotifications 
.const [84] = Utf8 [I 
.const [85] = Utf8 connectionState 
.const [86] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [87] = Utf8 Code 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (Lde/audi/app/data/core/IDataApplication;)V 
.const [90] = Utf8 getAttributeNotifications 
.const [91] = Utf8 ()[I 
.const [92] = Utf8 updateStateDataConnection 
.const [93] = Utf8 (Lorg/dsi/ifc/networking/DataConnectionStateStruct;I)V 
.end class 
