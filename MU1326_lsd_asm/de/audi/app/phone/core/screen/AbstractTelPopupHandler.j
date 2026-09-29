.version 50 0 
.class public super abstract [216] 
.super [218] 
.implements [220] 
.field private static final [221] [222] 
.field private static final [223] [224] 
.field private static final [225] [226] 
.field private static final [227] [228] 
.field private static final [229] [230] 
.field private final [231] [232] 
.field private volatile [233] [234] 

.method private static [236] : [237] 
    .attribute [235] .code stack 2 locals 0 
L0:     iload_0 
L1:     tableswitch 0 
            L36 
            L39 
            L42 
            L45 
            L48 
            default : L51 

L36:    ldc [2] 
L38:    areturn 
L39:    ldc [3] 
L41:    areturn 
L42:    ldc [4] 
L44:    areturn 
L45:    ldc [5] 
L47:    areturn 
L48:    ldc [6] 
L50:    areturn 
L51:    new [45] 
L54:    dup 
L55:    invokespecial [40] 
L58:    ldc [8] 
L60:    invokevirtual [28] 
L63:    iload_0 
L64:    invokevirtual [29] 
L67:    invokevirtual [30] 
L70:    areturn 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [9] 
L4:     invokespecial [41] 
L7:     aload_0 
L8:     iload_2 
L9:     putfield [46] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [240] : [241] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [41] 
L6:     aload_0 
L7:     iload_3 
L8:     putfield [46] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [42] 
L4:     aload_0 
L5:     invokevirtual [32] 
L8:     invokeinterface [47] 0 
L13:    aload_0 
L14:    getfield [31] 
L17:    aload_0 
L18:    invokeinterface [48] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [43] 
L4:     aload_0 
L5:     invokevirtual [32] 
L8:     invokeinterface [47] 0 
L13:    aload_0 
L14:    getfield [31] 
L17:    aload_0 
L18:    invokeinterface [49] 0 
L23:    return 
L24:    
    .end code 
.end method 

.method protected abstract [246] : [247] 
    .attribute [235] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method private [248] : [249] 
    .attribute [235] .code stack 3 locals 0 
L0:     new [45] 
L3:     dup 
L4:     invokespecial [40] 
L7:     aload_0 
L8:     iload_1 
L9:     invokevirtual [33] 
L12:    invokevirtual [28] 
L15:    ldc [10] 
L17:    invokevirtual [28] 
L20:    iload_1 
L21:    invokevirtual [29] 
L24:    ldc [11] 
L26:    invokevirtual [28] 
L29:    invokevirtual [30] 
L32:    areturn 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public interface [250] : [251] 
    .attribute [235] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [235] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokevirtual [35] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [254] : [255] 
    .attribute [235] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     invokevirtual [36] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [256] : [257] 
    .attribute [235] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     istore_2 
L5:     iload_2 
L6:     ifeq L19 
L9:     iload_2 
L10:    iconst_4 
L11:    if_icmpeq L19 
L14:    iload_2 
L15:    iconst_1 
L16:    if_icmpne L73 
L19:    aload_0 
L20:    getfield [37] 
L23:    ldc [12] 
L25:    ldc [13] 
L27:    aload_0 
L28:    aload_0 
L29:    getfield [31] 
L32:    invokespecial [44] 
L35:    iload_1 
L36:    i2l 
L37:    invokevirtual [38] 
L40:    pop 
L41:    aload_0 
L42:    iconst_1 
L43:    putfield [50] 
L46:    aload_0 
L47:    invokevirtual [32] 
L50:    invokeinterface [51] 0 
L55:    invokeinterface [52] 0 
L60:    aload_0 
L61:    getfield [31] 
L64:    iload_1 
L65:    invokeinterface [53] 0 
L70:    goto L89 
L73:    aload_0 
L74:    getfield [37] 
L77:    ldc [12] 
L79:    ldc [14] 
L81:    iload_2 
L82:    invokestatic [15] 
L85:    invokevirtual [39] 
L88:    pop 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [258] : [259] 
    .attribute [235] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     istore_2 
L5:     iload_2 
L6:     iconst_3 
L7:     if_icmpeq L25 
L10:    iload_2 
L11:    iconst_1 
L12:    if_icmpeq L25 
L15:    iload_2 
L16:    iconst_2 
L17:    if_icmpeq L25 
L20:    iload_2 
L21:    iconst_4 
L22:    if_icmpne L79 
L25:    aload_0 
L26:    getfield [37] 
L29:    ldc [12] 
L31:    ldc [16] 
L33:    aload_0 
L34:    aload_0 
L35:    getfield [31] 
L38:    invokespecial [44] 
L41:    iload_1 
L42:    i2l 
L43:    invokevirtual [38] 
L46:    pop 
L47:    aload_0 
L48:    iconst_4 
L49:    putfield [50] 
L52:    aload_0 
L53:    invokevirtual [32] 
L56:    invokeinterface [51] 0 
L61:    invokeinterface [52] 0 
L66:    aload_0 
L67:    getfield [31] 
L70:    iload_1 
L71:    invokeinterface [54] 0 
L76:    goto L95 
L79:    aload_0 
L80:    getfield [37] 
L83:    ldc [12] 
L85:    ldc [17] 
L87:    iload_2 
L88:    invokestatic [15] 
L91:    invokevirtual [39] 
L94:    pop 
L95:    return 
L96:    
    .end code 
.end method 

.method public [260] : [261] 
    .attribute [235] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [12] 
L6:     ldc [18] 
L8:     aload_0 
L9:     aload_0 
L10:    getfield [31] 
L13:    invokespecial [44] 
L16:    invokevirtual [39] 
L19:    pop 
L20:    aload_0 
L21:    iconst_2 
L22:    putfield [50] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [262] : [263] 
    .attribute [235] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [12] 
L6:     ldc [19] 
L8:     aload_0 
L9:     aload_0 
L10:    getfield [31] 
L13:    invokespecial [44] 
L16:    invokevirtual [39] 
L19:    pop 
L20:    aload_0 
L21:    iconst_3 
L22:    putfield [50] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [264] : [265] 
    .attribute [235] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [37] 
L4:     ldc [12] 
L6:     ldc [20] 
L8:     aload_0 
L9:     aload_0 
L10:    getfield [31] 
L13:    invokespecial [44] 
L16:    invokevirtual [39] 
L19:    pop 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [50] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [55] 
.const [3] = String [56] 
.const [4] = String [57] 
.const [5] = String [58] 
.const [6] = String [59] 
.const [7] = Class [60] 
.const [8] = String [61] 
.const [9] = String [62] 
.const [10] = String [63] 
.const [11] = String [64] 
.const [12] = Int 1078071040 
.const [13] = String [65] 
.const [14] = String [66] 
.const [15] = Method [67] [68] 
.const [16] = String [69] 
.const [17] = String [70] 
.const [18] = String [71] 
.const [19] = String [72] 
.const [20] = String [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Class [76] 
.const [24] = Class [77] 
.const [25] = Class [78] 
.const [26] = Class [79] 
.const [27] = Class [80] 
.const [28] = Method [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Method [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Field [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Method [103] [104] 
.const [40] = Method [105] [106] 
.const [41] = Method [107] [108] 
.const [42] = Method [109] [110] 
.const [43] = Method [111] [112] 
.const [44] = Method [113] [114] 
.const [45] = Class [115] 
.const [46] = Field [116] [117] 
.const [47] = InterfaceMethod [118] [119] 
.const [48] = InterfaceMethod [120] [121] 
.const [49] = InterfaceMethod [122] [123] 
.const [50] = Field [124] [125] 
.const [51] = InterfaceMethod [126] [127] 
.const [52] = InterfaceMethod [128] [129] 
.const [53] = InterfaceMethod [130] [131] 
.const [54] = InterfaceMethod [132] [133] 
.const [55] = Utf8 STATE_IDLE 
.const [56] = Utf8 STATE_SHOW_REQUESTED 
.const [57] = Utf8 STATE_VISIBLE 
.const [58] = Utf8 STATE_HIDDEN 
.const [59] = Utf8 STATE_REMOVE_REQUESTED 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 'UNKNOWN_STATE: ' 
.const [62] = Utf8 'App.Phone.Main' 
.const [63] = Utf8 ( 
.const [64] = Utf8 ')' 
.const [65] = Utf8 '[AbstractTelPopupHandler#requestShowPopup] %1, terminalID=%2' 
.const [66] = Utf8 '[AbstractTelPopupHandler#requestShowPopup] state is %1 --> NOP!' 
.const [67] = Class [134] 
.const [68] = NameAndType [135] [136] 
.const [69] = Utf8 '[AbstractTelPopupHandler#requestRemovePopup] %1, terminalID=%2' 
.const [70] = Utf8 '[AbstractTelPopupHandler#requestRemovePopup] state is %1 --> NOP!' 
.const [71] = Utf8 '[AbstractTelPopupHandler#notifyPopupVisible] %1' 
.const [72] = Utf8 '[AbstractTelPopupHandler#notifyPopupHidden] %1' 
.const [73] = Utf8 '[AbstractTelPopupHandler#notifyPopupRemoved] %1' 
.const [74] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [75] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [76] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [77] = Utf8 de/audi/app/phone/core/screen/IPopupScreenStateDispatcher 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [80] = Utf8 de/audi/atip/hmi/HMIService 
.const [81] = Class [137] 
.const [82] = NameAndType [138] [139] 
.const [83] = Class [140] 
.const [84] = NameAndType [141] [142] 
.const [85] = Class [143] 
.const [86] = NameAndType [144] [145] 
.const [87] = Class [146] 
.const [88] = NameAndType [147] [148] 
.const [89] = Class [149] 
.const [90] = NameAndType [150] [151] 
.const [91] = Class [152] 
.const [92] = NameAndType [153] [154] 
.const [93] = Class [155] 
.const [94] = NameAndType [156] [157] 
.const [95] = Class [158] 
.const [96] = NameAndType [159] [160] 
.const [97] = Class [161] 
.const [98] = NameAndType [162] [163] 
.const [99] = Class [164] 
.const [100] = NameAndType [165] [166] 
.const [101] = Class [167] 
.const [102] = NameAndType [168] [169] 
.const [103] = Class [170] 
.const [104] = NameAndType [171] [172] 
.const [105] = Class [173] 
.const [106] = NameAndType [174] [175] 
.const [107] = Class [176] 
.const [108] = NameAndType [177] [178] 
.const [109] = Class [179] 
.const [110] = NameAndType [180] [181] 
.const [111] = Class [182] 
.const [112] = NameAndType [183] [184] 
.const [113] = Class [185] 
.const [114] = NameAndType [186] [187] 
.const [115] = Utf8 java/lang/StringBuffer 
.const [116] = Class [188] 
.const [117] = NameAndType [189] [190] 
.const [118] = Class [191] 
.const [119] = NameAndType [192] [193] 
.const [120] = Class [194] 
.const [121] = NameAndType [195] [196] 
.const [122] = Class [197] 
.const [123] = NameAndType [198] [199] 
.const [124] = Class [200] 
.const [125] = NameAndType [201] [202] 
.const [126] = Class [203] 
.const [127] = NameAndType [204] [205] 
.const [128] = Class [206] 
.const [129] = NameAndType [207] [208] 
.const [130] = Class [209] 
.const [131] = NameAndType [210] [211] 
.const [132] = Class [212] 
.const [133] = NameAndType [213] [214] 
.const [134] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [135] = Utf8 getStateName 
.const [136] = Utf8 (I)Ljava/lang/String; 
.const [137] = Utf8 java/lang/StringBuffer 
.const [138] = Utf8 append 
.const [139] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [140] = Utf8 java/lang/StringBuffer 
.const [141] = Utf8 append 
.const [142] = Utf8 (I)Ljava/lang/StringBuffer; 
.const [143] = Utf8 java/lang/StringBuffer 
.const [144] = Utf8 toString 
.const [145] = Utf8 ()Ljava/lang/String; 
.const [146] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [147] = Utf8 popupID 
.const [148] = Utf8 I 
.const [149] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [150] = Utf8 getApplication 
.const [151] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [152] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [153] = Utf8 getPopupName 
.const [154] = Utf8 (I)Ljava/lang/String; 
.const [155] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [156] = Utf8 state 
.const [157] = Utf8 I 
.const [158] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [159] = Utf8 requestShowPopup 
.const [160] = Utf8 (I)V 
.const [161] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [162] = Utf8 requestRemovePopup 
.const [163] = Utf8 (I)V 
.const [164] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [165] = Utf8 log 
.const [166] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [167] = Utf8 de/audi/atip/log/LogChannel 
.const [168] = Utf8 log 
.const [169] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [170] = Utf8 de/audi/atip/log/LogChannel 
.const [171] = Utf8 log 
.const [172] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [173] = Utf8 java/lang/StringBuffer 
.const [174] = Utf8 <init> 
.const [175] = Utf8 ()V 
.const [176] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [177] = Utf8 <init> 
.const [178] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [179] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [180] = Utf8 init 
.const [181] = Utf8 ()V 
.const [182] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [183] = Utf8 deinit 
.const [184] = Utf8 ()V 
.const [185] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [186] = Utf8 getPopupNameWithID 
.const [187] = Utf8 (I)Ljava/lang/String; 
.const [188] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [189] = Utf8 popupID 
.const [190] = Utf8 I 
.const [191] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [192] = Utf8 getPopupScreenStateDispatcher 
.const [193] = Utf8 ()Lde/audi/app/phone/core/screen/IPopupScreenStateDispatcher; 
.const [194] = Utf8 de/audi/app/phone/core/screen/IPopupScreenStateDispatcher 
.const [195] = Utf8 addPopupStateListener 
.const [196] = Utf8 (ILde/audi/app/phone/core/screen/IPopupStateListener;)V 
.const [197] = Utf8 de/audi/app/phone/core/screen/IPopupScreenStateDispatcher 
.const [198] = Utf8 removePopupStateListener 
.const [199] = Utf8 (ILde/audi/app/phone/core/screen/IPopupStateListener;)V 
.const [200] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [201] = Utf8 state 
.const [202] = Utf8 I 
.const [203] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [204] = Utf8 getFrameworkAccess 
.const [205] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [206] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [207] = Utf8 getHMIService 
.const [208] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [209] = Utf8 de/audi/atip/hmi/HMIService 
.const [210] = Utf8 showPopup 
.const [211] = Utf8 (II)V 
.const [212] = Utf8 de/audi/atip/hmi/HMIService 
.const [213] = Utf8 removePopup 
.const [214] = Utf8 (II)V 
.const [215] = Utf8 de/audi/app/phone/core/screen/AbstractTelPopupHandler 
.const [216] = Class [215] 
.const [217] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [218] = Class [217] 
.const [219] = Utf8 de/audi/app/phone/core/screen/IPopupStateListener 
.const [220] = Class [219] 
.const [221] = Utf8 STATE_IDLE 
.const [222] = Utf8 I 
.const [223] = Utf8 STATE_SHOW_REQUESTED 
.const [224] = Utf8 I 
.const [225] = Utf8 STATE_VISIBLE 
.const [226] = Utf8 I 
.const [227] = Utf8 STATE_HIDDEN 
.const [228] = Utf8 I 
.const [229] = Utf8 STATE_REMOVE_REQUESTED 
.const [230] = Utf8 I 
.const [231] = Utf8 popupID 
.const [232] = Utf8 I 
.const [233] = Utf8 state 
.const [234] = Utf8 I 
.const [235] = Utf8 Code 
.const [236] = Utf8 getStateName 
.const [237] = Utf8 (I)Ljava/lang/String; 
.const [238] = Utf8 <init> 
.const [239] = Utf8 (Lde/audi/app/phone/core/ITelApplication;I)V 
.const [240] = Utf8 <init> 
.const [241] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;I)V 
.const [242] = Utf8 init 
.const [243] = Utf8 ()V 
.const [244] = Utf8 deinit 
.const [245] = Utf8 ()V 
.const [246] = Utf8 getPopupName 
.const [247] = Utf8 (I)Ljava/lang/String; 
.const [248] = Utf8 getPopupNameWithID 
.const [249] = Utf8 (I)Ljava/lang/String; 
.const [250] = Utf8 getPopupState 
.const [251] = Utf8 ()I 
.const [252] = Utf8 requestShowPopup 
.const [253] = Utf8 ()V 
.const [254] = Utf8 requestRemovePopup 
.const [255] = Utf8 ()V 
.const [256] = Utf8 requestShowPopup 
.const [257] = Utf8 (I)V 
.const [258] = Utf8 requestRemovePopup 
.const [259] = Utf8 (I)V 
.const [260] = Utf8 notifyPopupVisible 
.const [261] = Utf8 (I)V 
.const [262] = Utf8 notifyPopupHidden 
.const [263] = Utf8 (I)V 
.const [264] = Utf8 notifyPopupRemoved 
.const [265] = Utf8 (I)V 
.end class 
