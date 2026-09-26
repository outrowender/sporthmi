.version 50 0 
.class public super [106] 
.super [108] 
.field private final [109] [110] 

.method public [112] : [113] 
    .attribute [111] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     aload_3 
L4:     invokespecial [26] 
L7:     aload_0 
L8:     aload 4 
L10:    putfield [28] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [114] : [115] 
    .attribute [111] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokevirtual [19] 
L7:     istore_1 
L8:     aload_0 
L9:     getfield [20] 
L12:    ldc [2] 
L14:    ldc [3] 
L16:    iload_1 
L17:    invokevirtual [21] 
L20:    pop 
L21:    iload_1 
L22:    ifne L35 
L25:    aload_0 
L26:    getfield [18] 
L29:    invokevirtual [22] 
L32:    ifne L54 
L35:    aload_0 
L36:    getfield [20] 
L39:    ldc [2] 
L41:    ldc [4] 
L43:    invokevirtual [23] 
L46:    pop 
L47:    aload_0 
L48:    sipush 30001 
L51:    invokespecial [27] 
L54:    aload_0 
L55:    getfield [24] 
L58:    iconst_0 
L59:    invokeinterface [29] 0 
L64:    return 
L65:    nop 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [116] : [117] 
    .attribute [111] .code stack 6 locals 1 
L0:     iload_1 
L1:     tableswitch 0 
            L70 
            L40 
            L64 
            L58 
            L52 
            L46 
            default : L76 

L40:    ldc [5] 
L42:    astore_2 
L43:    goto L79 
L46:    ldc [6] 
L48:    astore_2 
L49:    goto L79 
L52:    ldc [7] 
L54:    astore_2 
L55:    goto L79 
L58:    ldc [8] 
L60:    astore_2 
L61:    goto L79 
L64:    ldc [9] 
L66:    astore_2 
L67:    goto L79 
L70:    ldc [10] 
L72:    astore_2 
L73:    goto L79 
L76:    ldc [11] 
L78:    astore_2 
L79:    aload_0 
L80:    getfield [20] 
L83:    ldc [2] 
L85:    ldc [12] 
L87:    aload_2 
L88:    iload_1 
L89:    i2l 
L90:    invokevirtual [25] 
L93:    pop 
L94:    aload_0 
L95:    iload_1 
L96:    ifne L105 
L99:    sipush 30000 
L102:   goto L108 
L105:   sipush 30001 
L108:   invokespecial [27] 
L111:   return 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [30] 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = String [34] 
.const [8] = String [35] 
.const [9] = String [36] 
.const [10] = String [37] 
.const [11] = String [38] 
.const [12] = String [39] 
.const [13] = Class [40] 
.const [14] = Class [41] 
.const [15] = Class [42] 
.const [16] = Class [43] 
.const [17] = Class [44] 
.const [18] = Field [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Field [49] [50] 
.const [21] = Method [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Method [55] [56] 
.const [24] = Field [57] [58] 
.const [25] = Method [59] [60] 
.const [26] = Method [61] [62] 
.const [27] = Method [63] [64] 
.const [28] = Field [65] [66] 
.const [29] = InterfaceMethod [67] [68] 
.const [30] = Utf8 'PhoneSiriActivateCommand#execute: mobileSRActive=%1' 
.const [31] = Utf8 'PhoneSiriActivateCommand#execute: External speech recognition not started, sending ERROR!' 
.const [32] = Utf8 ABORTED 
.const [33] = Utf8 'ALREADY ACTIVE' 
.const [34] = Utf8 'NOT AVAILABLE' 
.const [35] = Utf8 'NOT STARTED' 
.const [36] = Utf8 UNSPECIFIED 
.const [37] = Utf8 OK 
.const [38] = Utf8 UNKNOWN 
.const [39] = Utf8 'PhoneSiriActivateCommand#responseStartSpeechRecognition: result=%2, mobile speech recognition is %1!' 
.const [40] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneSiriActivateCommand 
.const [41] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [42] = Utf8 de/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [45] = Class [69] 
.const [46] = NameAndType [70] [71] 
.const [47] = Class [72] 
.const [48] = NameAndType [73] [74] 
.const [49] = Class [75] 
.const [50] = NameAndType [76] [77] 
.const [51] = Class [78] 
.const [52] = NameAndType [79] [80] 
.const [53] = Class [81] 
.const [54] = NameAndType [82] [83] 
.const [55] = Class [84] 
.const [56] = NameAndType [85] [86] 
.const [57] = Class [87] 
.const [58] = NameAndType [88] [89] 
.const [59] = Class [90] 
.const [60] = NameAndType [91] [92] 
.const [61] = Class [93] 
.const [62] = NameAndType [94] [95] 
.const [63] = Class [96] 
.const [64] = NameAndType [97] [98] 
.const [65] = Class [99] 
.const [66] = NameAndType [100] [101] 
.const [67] = Class [102] 
.const [68] = NameAndType [103] [104] 
.const [69] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneSiriActivateCommand 
.const [70] = Utf8 mobileSRHandler 
.const [71] = Utf8 Lde/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler; 
.const [72] = Utf8 de/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler 
.const [73] = Utf8 isMobileSpeechRecognitionActive 
.const [74] = Utf8 ()Z 
.const [75] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [76] = Utf8 logger 
.const [77] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;Z)Z 
.const [81] = Utf8 de/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler 
.const [82] = Utf8 requestStartSpeechRecognition 
.const [83] = Utf8 ()Z 
.const [84] = Utf8 de/audi/atip/log/LogChannel 
.const [85] = Utf8 log 
.const [86] = Utf8 (ILjava/lang/String;)Z 
.const [87] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneSiriActivateCommand 
.const [88] = Utf8 sdsHandlerService 
.const [89] = Utf8 Lde/audi/app/sdsmanager/apps/SDSHandlerService; 
.const [90] = Utf8 de/audi/atip/log/LogChannel 
.const [91] = Utf8 log 
.const [92] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [93] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;)V 
.const [96] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [97] = Utf8 sendResult 
.const [98] = Utf8 (I)V 
.const [99] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneSiriActivateCommand 
.const [100] = Utf8 mobileSRHandler 
.const [101] = Utf8 Lde/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler; 
.const [102] = Utf8 de/audi/app/sdsmanager/apps/SDSHandlerService 
.const [103] = Utf8 switchEntertainment 
.const [104] = Utf8 (Z)V 
.const [105] = Utf8 de/audi/app/sdsmanager/apps/phone/commands/PhoneSiriActivateCommand 
.const [106] = Class [105] 
.const [107] = Utf8 de/audi/app/sdsmanager/apps/AbstractSystemCallCommand 
.const [108] = Class [107] 
.const [109] = Utf8 mobileSRHandler 
.const [110] = Utf8 Lde/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler; 
.const [111] = Utf8 Code 
.const [112] = Utf8 <init> 
.const [113] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/String;Lde/audi/app/sdsmanager/apps/SDSHandlerService;Lde/audi/app/sdsmanager/dsi/MobileSpeechRecognitionHandler;)V 
.const [114] = Utf8 execute 
.const [115] = Utf8 ()V 
.const [116] = Utf8 responseStartSpeechRecognition 
.const [117] = Utf8 (I)V 
.end class 
