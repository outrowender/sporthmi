.version 50 0 
.class public super [108] 
.super [110] 
.field private static final [111] [112] 
.field private static final [113] [114] 
.field private static final [115] [116] 
.field private static final [117] [118] 
.field private final [119] [120] 
.field private final [121] [122] 

.method public [124] : [125] 
    .attribute [123] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [22] 
L7:     aload_0 
L8:     aload 4 
L10:    putfield [23] 
L13:    aload_0 
L14:    aload 5 
L16:    iconst_0 
L17:    invokestatic [2] 
L20:    putfield [24] 
L23:    return 
L24:    
    .end code 
.end method 

.method public [126] : [127] 
    .attribute [123] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     invokevirtual [18] 
L12:    aload_0 
L13:    getfield [16] 
L16:    i2l 
L17:    invokevirtual [19] 
L20:    pop 
L21:    aload_0 
L22:    getfield [16] 
L25:    tableswitch 0 
            L56 
            L84 
            L56 
            L112 
            default : L140 

L56:    aload_0 
L57:    getfield [17] 
L60:    ldc [3] 
L62:    ldc [5] 
L64:    aload_0 
L65:    invokevirtual [18] 
L68:    invokevirtual [20] 
L71:    pop 
L72:    aload_0 
L73:    getfield [15] 
L76:    invokeinterface [25] 0 
L81:    goto L156 
L84:    aload_0 
L85:    getfield [17] 
L88:    ldc [3] 
L90:    ldc [6] 
L92:    aload_0 
L93:    invokevirtual [18] 
L96:    invokevirtual [20] 
L99:    pop 
L100:   aload_0 
L101:   getfield [15] 
L104:   invokeinterface [26] 0 
L109:   goto L156 
L112:   aload_0 
L113:   getfield [17] 
L116:   ldc [3] 
L118:   ldc [6] 
L120:   aload_0 
L121:   invokevirtual [18] 
L124:   invokevirtual [20] 
L127:   pop 
L128:   aload_0 
L129:   getfield [15] 
L132:   invokeinterface [27] 0 
L137:   goto L156 
L140:   aload_0 
L141:   getfield [17] 
L144:   ldc [7] 
L146:   ldc [8] 
L148:   aload_0 
L149:   invokevirtual [18] 
L152:   invokevirtual [20] 
L155:   pop 
L156:   aload_0 
L157:   ldc [9] 
L159:   invokevirtual [21] 
L162:   return 
L163:   nop 
L164:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [28] [29] 
.const [3] = Int -2137614336 
.const [4] = String [30] 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = Int -1601830656 
.const [8] = String [33] 
.const [9] = Int -131858176 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Field [55] [56] 
.const [24] = Field [57] [58] 
.const [25] = InterfaceMethod [59] [60] 
.const [26] = InterfaceMethod [61] [62] 
.const [27] = InterfaceMethod [63] [64] 
.const [28] = Class [65] 
.const [29] = NameAndType [66] [67] 
.const [30] = Utf8 '%1#execute: deleteMode=%2' 
.const [31] = Utf8 '%1#execute: Requesting undo of last section!' 
.const [32] = Utf8 '%1#execute: Requesting deletion of full body!' 
.const [33] = Utf8 '%1#execute: Unhandled deletion mode -> NOP!' 
.const [34] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [35] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [36] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [37] = Utf8 de/audi/atip/log/LogChannel 
.const [38] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [39] = Class [68] 
.const [40] = NameAndType [69] [70] 
.const [41] = Class [71] 
.const [42] = NameAndType [72] [73] 
.const [43] = Class [74] 
.const [44] = NameAndType [75] [76] 
.const [45] = Class [77] 
.const [46] = NameAndType [78] [79] 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Utf8 de/audi/app/sdsmanager/common/SDSUtils 
.const [66] = Utf8 retrieveInteger 
.const [67] = Utf8 ([Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;I)I 
.const [68] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [69] = Utf8 dictationHandler 
.const [70] = Utf8 Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [71] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [72] = Utf8 deleteMode 
.const [73] = Utf8 I 
.const [74] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [75] = Utf8 logger 
.const [76] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [77] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [78] = Utf8 getName 
.const [79] = Utf8 ()Ljava/lang/String; 
.const [80] = Utf8 de/audi/atip/log/LogChannel 
.const [81] = Utf8 log 
.const [82] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [83] = Utf8 de/audi/atip/log/LogChannel 
.const [84] = Utf8 log 
.const [85] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [86] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [87] = Utf8 sendResult 
.const [88] = Utf8 (I)V 
.const [89] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [90] = Utf8 <init> 
.const [91] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [92] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [93] = Utf8 dictationHandler 
.const [94] = Utf8 Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [95] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [96] = Utf8 deleteMode 
.const [97] = Utf8 I 
.const [98] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [99] = Utf8 undoLastInsertion 
.const [100] = Utf8 ()V 
.const [101] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [102] = Utf8 clearBody 
.const [103] = Utf8 ()V 
.const [104] = Utf8 de/audi/app/sdsmanager/apps/dictate/MessageDictationHandler 
.const [105] = Utf8 clearSubject 
.const [106] = Utf8 ()V 
.const [107] = Utf8 de/audi/app/sdsmanager/apps/dictate/commands/MsgDictateDeleteCommand 
.const [108] = Class [107] 
.const [109] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [110] = Class [109] 
.const [111] = Utf8 DELETE_MODE_UNDO 
.const [112] = Utf8 I 
.const [113] = Utf8 DELETE_MODE_ALL 
.const [114] = Utf8 I 
.const [115] = Utf8 DELETE_MODE_UNDO_MAIL_SUBJECT 
.const [116] = Utf8 I 
.const [117] = Utf8 DELETE_MODE_ALL_MAIL_SUBJECTL 
.const [118] = Utf8 I 
.const [119] = Utf8 dictationHandler 
.const [120] = Utf8 Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler; 
.const [121] = Utf8 deleteMode 
.const [122] = Utf8 I 
.const [123] = Utf8 Code 
.const [124] = Utf8 <init> 
.const [125] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;Lde/audi/app/sdsmanager/apps/dictate/MessageDictationHandler;[Lde/audi/app/sdsmanager/syscall/ISystemCallParameter;)V 
.const [126] = Utf8 execute 
.const [127] = Utf8 ()V 
.end class 
