.version 50 0 
.class public super [112] 
.super [114] 
.field private final [115] [116] 
.field private final [117] [118] 

.method public [120] : [121] 
    .attribute [119] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [24] 
L7:     aload_0 
L8:     aload 5 
L10:    putfield [25] 
L13:    aload_0 
L14:    aload 4 
L16:    iconst_0 
L17:    invokestatic [2] 
L20:    i2b 
L21:    putfield [26] 
L24:    return 
L25:    nop 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [122] : [123] 
    .attribute [119] .code stack 8 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     getstatic [3] 
L7:     invokestatic [4] 
L10:    istore_1 
L11:    aload_0 
L12:    getfield [19] 
L15:    ldc [5] 
L17:    ldc [6] 
L19:    aload_0 
L20:    invokevirtual [20] 
L23:    aload_0 
L24:    getfield [18] 
L27:    i2l 
L28:    iload_1 
L29:    i2l 
L30:    invokevirtual [21] 
L33:    pop 
L34:    iload_1 
L35:    bipush -128 
L37:    if_icmpne L68 
L40:    aload_0 
L41:    getfield [19] 
L44:    ldc [7] 
L46:    ldc [8] 
L48:    aload_0 
L49:    invokevirtual [20] 
L52:    aload_0 
L53:    getfield [18] 
L56:    i2l 
L57:    invokevirtual [22] 
L60:    pop 
L61:    aload_0 
L62:    ldc [9] 
L64:    invokevirtual [23] 
L67:    return 
L68:    aload_0 
L69:    getfield [17] 
L72:    iload_1 
L73:    invokeinterface [27] 0 
L78:    invokestatic [10] 
L81:    istore_2 
L82:    aload_0 
L83:    iload_2 
L84:    invokevirtual [23] 
L87:    return 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Field [30] [31] 
.const [4] = Method [32] [33] 
.const [5] = Int -2137614336 
.const [6] = String [34] 
.const [7] = Int -1601830656 
.const [8] = String [35] 
.const [9] = Int 1100742656 
.const [10] = Method [36] [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Class [40] 
.const [14] = Class [41] 
.const [15] = Class [42] 
.const [16] = Class [43] 
.const [17] = Field [44] [45] 
.const [18] = Field [46] [47] 
.const [19] = Field [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Method [56] [57] 
.const [24] = Method [58] [59] 
.const [25] = Field [60] [61] 
.const [26] = Field [62] [63] 
.const [27] = InterfaceMethod [64] [65] 
.const [28] = Class [66] 
.const [29] = NameAndType [67] [68] 
.const [30] = Class [69] 
.const [31] = NameAndType [70] [71] 
.const [32] = Class [72] 
.const [33] = NameAndType [73] [74] 
.const [34] = Utf8 '%1#execute: searchArea=%2, poiArea=%3' 
.const [35] = Utf8 '%1#execute: Unhandled searchArea %2!' 
.const [36] = Class [75] 
.const [37] = NameAndType [76] [77] 
.const [38] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [39] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [40] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [41] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/atip/interapp/NaviService 
.const [44] = Class [78] 
.const [45] = NameAndType [79] [80] 
.const [46] = Class [81] 
.const [47] = NameAndType [82] [83] 
.const [48] = Class [84] 
.const [49] = NameAndType [85] [86] 
.const [50] = Class [87] 
.const [51] = NameAndType [88] [89] 
.const [52] = Class [90] 
.const [53] = NameAndType [91] [92] 
.const [54] = Class [93] 
.const [55] = NameAndType [94] [95] 
.const [56] = Class [96] 
.const [57] = NameAndType [97] [98] 
.const [58] = Class [99] 
.const [59] = NameAndType [100] [101] 
.const [60] = Class [102] 
.const [61] = NameAndType [103] [104] 
.const [62] = Class [105] 
.const [63] = NameAndType [106] [107] 
.const [64] = Class [108] 
.const [65] = NameAndType [109] [110] 
.const [66] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [67] = Utf8 retrieveInteger 
.const [68] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [69] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [70] = Utf8 poiAreaToPOISearchArea 
.const [71] = Utf8 [[B 
.const [72] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [73] = Utf8 translate 
.const [74] = Utf8 (B[[B)B 
.const [75] = Utf8 de/audi/app/sdsmanager/apps/navi/NaviSDSUtils 
.const [76] = Utf8 getSDSResult 
.const [77] = Utf8 (B)I 
.const [78] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [79] = Utf8 service 
.const [80] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [81] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [82] = Utf8 searchArea 
.const [83] = Utf8 B 
.const [84] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [85] = Utf8 logger 
.const [86] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [87] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [88] = Utf8 getName 
.const [89] = Utf8 ()Ljava/lang/String; 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [93] = Utf8 de/audi/atip/log/LogChannel 
.const [94] = Utf8 log 
.const [95] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [96] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [97] = Utf8 sendResult 
.const [98] = Utf8 (I)V 
.const [99] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [100] = Utf8 <init> 
.const [101] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [102] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [103] = Utf8 service 
.const [104] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [105] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [106] = Utf8 searchArea 
.const [107] = Utf8 B 
.const [108] = Utf8 de/audi/atip/interapp/NaviService 
.const [109] = Utf8 setPOISearchArea 
.const [110] = Utf8 (B)B 
.const [111] = Utf8 de/audi/app/sdsmanager/apps/navi/commands/NaviPOISearchAreaSetCommand 
.const [112] = Class [111] 
.const [113] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [114] = Class [113] 
.const [115] = Utf8 service 
.const [116] = Utf8 Lde/audi/atip/interapp/NaviService; 
.const [117] = Utf8 searchArea 
.const [118] = Utf8 B 
.const [119] = Utf8 Code 
.const [120] = Utf8 <init> 
.const [121] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;Lde/audi/atip/interapp/NaviService;)V 
.const [122] = Utf8 execute 
.const [123] = Utf8 ()V 
.end class 
