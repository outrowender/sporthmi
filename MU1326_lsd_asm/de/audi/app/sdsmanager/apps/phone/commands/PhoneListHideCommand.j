.version 50 0 
.class public super [85] 
.super [87] 
.field private [88] [89] 
.field private final [90] [91] 
.field private static final [92] [93] 
.field private static final [94] [95] 

.method public [97] : [98] 
    .attribute [96] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [18] 
L7:     aload_0 
L8:     aload 4 
L10:    putfield [19] 
L13:    aload_0 
L14:    aload 5 
L16:    iconst_0 
L17:    invokestatic [2] 
L20:    putfield [20] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [99] : [100] 
    .attribute [96] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [15] 
L12:    aload_0 
L13:    getfield [13] 
L16:    i2l 
L17:    invokevirtual [16] 
L20:    pop 
L21:    aload_0 
L22:    getfield [13] 
L25:    lookupswitch 
            0 : L52 
            1 : L67 
            default : L82 

L52:    aload_0 
L53:    getfield [12] 
L56:    bipush 30 
L58:    iconst_0 
L59:    invokeinterface [21] 0 
L64:    goto L103 
L67:    aload_0 
L68:    getfield [12] 
L71:    bipush 74 
L73:    iconst_0 
L74:    invokeinterface [21] 0 
L79:    goto L103 
L82:    aload_0 
L83:    getfield [14] 
L86:    ldc [5] 
L88:    ldc [6] 
L90:    aload_0 
L91:    invokevirtual [15] 
L94:    aload_0 
L95:    getfield [13] 
L98:    i2l 
L99:    invokevirtual [16] 
L102:   pop 
L103:   aload_0 
L104:   invokevirtual [17] 
L107:   return 
L108:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Int -2137614336 
.const [4] = String [24] 
.const [5] = Int -1601830656 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Class [30] 
.const [12] = Field [31] [32] 
.const [13] = Field [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Method [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = Field [47] [48] 
.const [21] = InterfaceMethod [49] [50] 
.const [22] = Class [51] 
.const [23] = NameAndType [52] [53] 
.const [24] = Utf8 '%1#execute: called, listmode=%2' 
.const [25] = Utf8 '%1#execute: called, unhandled listmode=%2' 
.const [26] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [27] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [28] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [29] = Utf8 de/audi/atip/log/LogChannel 
.const [30] = Utf8 de/audi/app/sdsmanager/common/ISDSPopupHelper 
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
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [52] = Utf8 retrieveInteger 
.const [53] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [54] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [55] = Utf8 popupHelper 
.const [56] = Utf8 Lde/audi/app/sdsmanager/common/ISDSPopupHelper; 
.const [57] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [58] = Utf8 listMode 
.const [59] = Utf8 I 
.const [60] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [61] = Utf8 logger 
.const [62] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [63] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [64] = Utf8 getName 
.const [65] = Utf8 ()Ljava/lang/String; 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Utf8 log 
.const [68] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [69] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [70] = Utf8 processingFinished 
.const [71] = Utf8 ()V 
.const [72] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [73] = Utf8 <init> 
.const [74] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [75] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [76] = Utf8 popupHelper 
.const [77] = Utf8 Lde/audi/app/sdsmanager/common/ISDSPopupHelper; 
.const [78] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [79] = Utf8 listMode 
.const [80] = Utf8 I 
.const [81] = Utf8 de/audi/app/sdsmanager/common/ISDSPopupHelper 
.const [82] = Utf8 triggerHapticalPopup 
.const [83] = Utf8 (IZ)V 
.const [84] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneListHideCommand 
.const [85] = Class [84] 
.const [86] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [87] = Class [86] 
.const [88] = Utf8 listMode 
.const [89] = Utf8 I 
.const [90] = Utf8 popupHelper 
.const [91] = Utf8 Lde/audi/app/sdsmanager/common/ISDSPopupHelper; 
.const [92] = Utf8 LIST_MODE_SDS_PHONE_PICKLIST 
.const [93] = Utf8 I 
.const [94] = Utf8 LIST_MODE_TEL_SDS_NUM 
.const [95] = Utf8 I 
.const [96] = Utf8 Code 
.const [97] = Utf8 <init> 
.const [98] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;Lde/audi/app/sdsmanager/common/ISDSPopupHelper;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;)V 
.const [99] = Utf8 execute 
.const [100] = Utf8 ()V 
.end class 
