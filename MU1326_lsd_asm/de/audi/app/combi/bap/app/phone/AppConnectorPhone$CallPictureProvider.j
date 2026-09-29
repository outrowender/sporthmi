.version 50 0 
.class super [128] 
.super [130] 
.implements [132] 
.field private final synthetic [133] [134] 

.method private [136] : [137] 
    .attribute [135] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [28] 
L5:     aload_0 
L6:     invokespecial [25] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [138] : [139] 
    .attribute [135] .code stack 5 locals 3 
L0:     lload_1 
L1:     l2i 
L2:     istore_3 
L3:     iload_3 
L4:     iflt L149 
L7:     iload_3 
L8:     bipush 7 
L10:    if_icmpge L149 
L13:    aload_0 
L14:    getfield [17] 
L17:    invokestatic [2] 
L20:    ifnull L52 
L23:    aload_0 
L24:    getfield [17] 
L27:    invokestatic [2] 
L30:    iload_3 
L31:    aaload 
L32:    ifnull L52 
L35:    aload_0 
L36:    getfield [17] 
L39:    invokestatic [2] 
L42:    iload_3 
L43:    aaload 
L44:    invokevirtual [18] 
L47:    istore 4 
L49:    goto L55 
L52:    iconst_0 
L53:    istore 4 
L55:    aload_0 
L56:    getfield [17] 
L59:    invokestatic [3] 
L62:    ifnull L113 
L65:    aload_0 
L66:    getfield [17] 
L69:    invokestatic [3] 
L72:    iload_3 
L73:    aaload 
L74:    ifnull L113 
L77:    new [29] 
L80:    dup 
L81:    aload_0 
L82:    getfield [17] 
L85:    invokestatic [3] 
L88:    iload_3 
L89:    aaload 
L90:    invokevirtual [19] 
L93:    aload_0 
L94:    getfield [17] 
L97:    invokestatic [3] 
L100:   iload_3 
L101:   aaload 
L102:   invokevirtual [20] 
L105:   invokespecial [26] 
L108:   astore 5 
L110:   goto L122 
L113:   new [29] 
L116:   dup 
L117:   invokespecial [27] 
L120:   astore 5 
L122:   aload_0 
L123:   getfield [17] 
L126:   invokestatic [5] 
L129:   checkcast [6] 
L132:   invokevirtual [21] 
L135:   iload_3 
L136:   iload 4 
L138:   aload 5 
L140:   iconst_0 
L141:   invokeinterface [30] 0 
L146:   goto L166 
L149:   aload_0 
L150:   getfield [17] 
L153:   invokestatic [7] 
L156:   ldc [8] 
L158:   ldc [9] 
L160:   iload_3 
L161:   i2l 
L162:   invokevirtual [22] 
L165:   pop 
L166:   return 
L167:   nop 
L168:   
    .end code 
.end method 

.method public [140] : [141] 
    .attribute [135] .code stack 3 locals 0 
L0:     aload_0 
L1:     lload_1 
L2:     invokevirtual [23] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method synthetic [142] : [143] 
    .attribute [135] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [24] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [31] [32] 
.const [3] = Method [33] [34] 
.const [4] = Class [35] 
.const [5] = Method [36] [37] 
.const [6] = Class [38] 
.const [7] = Method [39] [40] 
.const [8] = Int -1601830656 
.const [9] = String [41] 
.const [10] = Class [42] 
.const [11] = Class [43] 
.const [12] = Class [44] 
.const [13] = Class [45] 
.const [14] = Class [46] 
.const [15] = Class [47] 
.const [16] = Class [48] 
.const [17] = Field [49] [50] 
.const [18] = Method [51] [52] 
.const [19] = Method [53] [54] 
.const [20] = Method [55] [56] 
.const [21] = Method [57] [58] 
.const [22] = Method [59] [60] 
.const [23] = Method [61] [62] 
.const [24] = Method [63] [64] 
.const [25] = Method [65] [66] 
.const [26] = Method [67] [68] 
.const [27] = Method [69] [70] 
.const [28] = Field [71] [72] 
.const [29] = Class [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = Class [76] 
.const [32] = NameAndType [77] [78] 
.const [33] = Class [79] 
.const [34] = NameAndType [80] [81] 
.const [35] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [36] = Class [82] 
.const [37] = NameAndType [83] [84] 
.const [38] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [39] = Class [85] 
.const [40] = NameAndType [86] [87] 
.const [41] = Utf8 '[AppConnectorPhone.CallPictureProvider#requestPicture] invalid callID: %1' 
.const [42] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone$CallPictureProvider 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone 
.const [45] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [46] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [47] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [48] = Utf8 de/audi/atip/log/LogChannel 
.const [49] = Class [88] 
.const [50] = NameAndType [89] [90] 
.const [51] = Class [91] 
.const [52] = NameAndType [92] [93] 
.const [53] = Class [94] 
.const [54] = NameAndType [95] [96] 
.const [55] = Class [97] 
.const [56] = NameAndType [98] [99] 
.const [57] = Class [100] 
.const [58] = NameAndType [101] [102] 
.const [59] = Class [103] 
.const [60] = NameAndType [104] [105] 
.const [61] = Class [106] 
.const [62] = NameAndType [107] [108] 
.const [63] = Class [109] 
.const [64] = NameAndType [110] [111] 
.const [65] = Class [112] 
.const [66] = NameAndType [113] [114] 
.const [67] = Class [115] 
.const [68] = NameAndType [116] [117] 
.const [69] = Class [118] 
.const [70] = NameAndType [119] [120] 
.const [71] = Class [121] 
.const [72] = NameAndType [122] [123] 
.const [73] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [74] = Class [124] 
.const [75] = NameAndType [125] [126] 
.const [76] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone 
.const [77] = Utf8 access$000 
.const [78] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;)[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState; 
.const [79] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone 
.const [80] = Utf8 access$100 
.const [81] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;)[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo; 
.const [82] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone 
.const [83] = Utf8 access$200 
.const [84] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;)Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [85] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone 
.const [86] = Utf8 access$300 
.const [87] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;)Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone$CallPictureProvider 
.const [89] = Utf8 this$0 
.const [90] = Utf8 Lde/audi/app/combi/bap/app/phone/AppConnectorPhone; 
.const [91] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallState 
.const [92] = Utf8 getCallType 
.const [93] = Utf8 ()I 
.const [94] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [95] = Utf8 getPictureID 
.const [96] = Utf8 ()I 
.const [97] = Utf8 de/audi/atip/interapp/combi/bap/phone/data/CombiBAPCallInfo 
.const [98] = Utf8 getPictureURL 
.const [99] = Utf8 ()Ljava/lang/String; 
.const [100] = Utf8 de/audi/app/combi/bap/fw/AbstractCombiModule 
.const [101] = Utf8 getPictureManager 
.const [102] = Utf8 ()Lde/audi/app/combi/bap/app/kombipictures/IPictureManager; 
.const [103] = Utf8 de/audi/atip/log/LogChannel 
.const [104] = Utf8 log 
.const [105] = Utf8 (ILjava/lang/String;J)Z 
.const [106] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone$CallPictureProvider 
.const [107] = Utf8 requestPicture 
.const [108] = Utf8 (J)V 
.const [109] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone$CallPictureProvider 
.const [110] = Utf8 <init> 
.const [111] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;)V 
.const [112] = Utf8 java/lang/Object 
.const [113] = Utf8 <init> 
.const [114] = Utf8 ()V 
.const [115] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [116] = Utf8 <init> 
.const [117] = Utf8 (ILjava/lang/String;)V 
.const [118] = Utf8 org/dsi/ifc/global/ResourceLocator 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone$CallPictureProvider 
.const [122] = Utf8 this$0 
.const [123] = Utf8 Lde/audi/app/combi/bap/app/phone/AppConnectorPhone; 
.const [124] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureManager 
.const [125] = Utf8 responseActiveCallPicture 
.const [126] = Utf8 (IILorg/dsi/ifc/global/ResourceLocator;Z)V 
.const [127] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorPhone$CallPictureProvider 
.const [128] = Class [127] 
.const [129] = Utf8 java/lang/Object 
.const [130] = Class [129] 
.const [131] = Utf8 de/audi/app/combi/bap/app/kombipictures/IPictureProvider 
.const [132] = Class [131] 
.const [133] = Utf8 this$0 
.const [134] = Utf8 Lde/audi/app/combi/bap/app/phone/AppConnectorPhone; 
.const [135] = Utf8 Code 
.const [136] = Utf8 <init> 
.const [137] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;)V 
.const [138] = Utf8 requestPicture 
.const [139] = Utf8 (J)V 
.const [140] = Utf8 requestPicture 
.const [141] = Utf8 (JI)V 
.const [142] = Utf8 <init> 
.const [143] = Utf8 (Lde/audi/app/combi/bap/app/phone/AppConnectorPhone;Lde/audi/app/combi/bap/app/phone/AppConnectorPhone$1;)V 
.end class 
