package places.municipalities;

import basics.norway.NorwegianProvince;
import templates.Categories;

public enum NorwegianMunicipality {
    ALSTAHAUG("Alstahaug", "1820", NorwegianProvince.NORDLAND), ALTA("Alta", "5403", NorwegianProvince.TROMS_OG_FINNMARK),
    ALVDAL("Alvdal", "3428", NorwegianProvince.INNLANDET), ALVER("Alver", "4631", NorwegianProvince.VESTLAND),
    ANDOEY("Andøy", "1871", NorwegianProvince.NORDLAND), AREMARK("Aremark", "3012", NorwegianProvince.VIKEN),
    ARENDAL("Arendal", "4203", NorwegianProvince.AGDER), ASKER("Asker", "3025", NorwegianProvince.VIKEN),
    ASKVOLL("Askvoll", "4645", NorwegianProvince.VESTLAND), ASKOEY("Askøy", "4627", NorwegianProvince.VESTLAND),
    AUKRA("Aukra", "1547", NorwegianProvince.MOERE_OG_ROMSDAL), AURE("Aure", "1576", NorwegianProvince.MOERE_OG_ROMSDAL),
    AURLAND("Aurland", "4641", NorwegianProvince.VESTLAND), AURSKOG_HOELAND("Aurskog-Høland", "3026", NorwegianProvince.VIKEN),
    AUSTEVOLL("Austevoll", "4625", NorwegianProvince.VESTLAND), AUSTRHEIM("Austrheim", "4632", NorwegianProvince.VESTLAND),
    AVEROEY("Averøy", "1554", NorwegianProvince.MOERE_OG_ROMSDAL), BALSFJORD("Balsfjord", "5422", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"),
    BAMBLE("Bamble", "3813", NorwegianProvince.VESTFOLD_OG_TELEMARK), BARDU("Bardu", "5416", NorwegianProvince.TROMS_OG_FINNMARK),
    BEIARN("Beiarn", "1839", NorwegianProvince.NORDLAND), BERGEN("Bergen", "4601", NorwegianProvince.VESTLAND, "Norwegen"),
    BERLEVAAG("Berlevåg", "5440", NorwegianProvince.TROMS_OG_FINNMARK), BINDAL("Bindal", "1811", NorwegianProvince.NORDLAND),
    BIRKENES("Birkenes", "4216", NorwegianProvince.AGDER), BJERKREIM("Bjerkreim", "1114", NorwegianProvince.ROGALAND),
    BJOERNAFJORDEN("Bjørnafjorden", "4624", NorwegianProvince.VESTLAND), BODOE("Bodø", "1804", NorwegianProvince.NORDLAND),
    BOKN("Bokn", "1145", NorwegianProvince.ROGALAND), BREMANGER("Bremanger", "4648", NorwegianProvince.VESTLAND),
    BROENNOEY("Brønnøy", "1813", NorwegianProvince.NORDLAND), BYGLAND("Bygland", "4220", NorwegianProvince.AGDER),
    BYKLE("Bykle", "4222", NorwegianProvince.AGDER), BAERUM("Bærum", "3024", NorwegianProvince.VIKEN),
    BOE("Bø", "1867", NorwegianProvince.NORDLAND, "Nordland"), BOEMLO("Bømlo", "4613", NorwegianProvince.VESTLAND),
    BAATSFJORD("Båtsfjord", "5443", NorwegianProvince.TROMS_OG_FINNMARK), TANA("Tana", "5441", NorwegianProvince.TROMS_OG_FINNMARK, "Norwegen"),
    TJELDSUND("Tjeldsund", "5412", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"), DOVRE("Dovre", "3431", NorwegianProvince.INNLANDET),
    DRAMMEN("Drammen", "3005", NorwegianProvince.VIKEN), DRANGEDAL("Drangedal", "3815", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    DYROEY("Dyrøy", "5420", NorwegianProvince.TROMS_OG_FINNMARK), DOENNA("Dønna", "1827", NorwegianProvince.NORDLAND),
    EIDFJORD("Eidfjord", "4619", NorwegianProvince.VESTLAND, "Kommune"), EIDSKOG("Eidskog", "3416", NorwegianProvince.INNLANDET),
    EIDSVOLL("Eidsvoll", "3035", NorwegianProvince.VIKEN), EIGERSUND("Eigersund", "1101", NorwegianProvince.ROGALAND),
    ELVERUM("Elverum", "3420", NorwegianProvince.INNLANDET), ENEBAKK("Enebakk", "3028", NorwegianProvince.VIKEN),
    ENGERDAL("Engerdal", "3425", NorwegianProvince.INNLANDET), ETNE("Etne", "4611", NorwegianProvince.VESTLAND),
    ETNEDAL("Etnedal", "3450", NorwegianProvince.INNLANDET), EVENES("Evenes", "1853", NorwegianProvince.NORDLAND, "Kommune"),
    EVJE_OG_HORNNES("Evje og Hornnes", "4219", NorwegianProvince.AGDER), FARSUND("Farsund", "4206", NorwegianProvince.AGDER),
    FAUSKE("Fauske", "1841", NorwegianProvince.NORDLAND), FEDJE("Fedje", "4633", NorwegianProvince.VESTLAND),
    FITJAR("Fitjar", "4615", NorwegianProvince.VESTLAND), FJALER("Fjaler", "4646", NorwegianProvince.VESTLAND),
    FJORD("Fjord", "1578", NorwegianProvince.MOERE_OG_ROMSDAL, "Kommune"), FLAKSTAD("Flakstad", "1859", NorwegianProvince.NORDLAND),
    FLATANGER("Flatanger", "5049", NorwegianProvince.TROENDELAG), FLEKKEFJORD("Flekkefjord", "4207", NorwegianProvince.AGDER),
    FLESBERG("Flesberg", "3050", NorwegianProvince.VIKEN), FLAA("Flå", "3039", NorwegianProvince.VIKEN),
    FOLLDAL("Folldal", "3429", NorwegianProvince.INNLANDET), FREDRIKSTAD("Fredrikstad", "3004", NorwegianProvince.VIKEN),
    FROGN("Frogn", "3022", NorwegianProvince.VIKEN), FROLAND("Froland", "4214", NorwegianProvince.AGDER),
    FROSTA("Frosta", "5036", NorwegianProvince.TROENDELAG, "Norwegen"), FROEYA("Frøya", "5014", NorwegianProvince.TROENDELAG),
    FYRESDAL("Fyresdal", "3823", NorwegianProvince.VESTFOLD_OG_TELEMARK), FAERDER("Færder", "3811", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    KAAFJORD("Kåfjord", "5426", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"), GAMVIK("Gamvik", "5439", NorwegianProvince.TROMS_OG_FINNMARK),
    GAUSDAL("Gausdal", "3441", NorwegianProvince.INNLANDET), GILDESKAAL("Gildeskål", "1838", NorwegianProvince.NORDLAND),
    GISKE("Giske", "1532", NorwegianProvince.MOERE_OG_ROMSDAL), GJEMNES("Gjemnes", "1557", NorwegianProvince.MOERE_OG_ROMSDAL),
    GJERDRUM("Gjerdrum", "3032", NorwegianProvince.VIKEN), GJERSTAD("Gjerstad", "4211", NorwegianProvince.AGDER),
    GJESDAL("Gjesdal", "1122", NorwegianProvince.ROGALAND), GJOEVIK("Gjøvik", "3407", NorwegianProvince.INNLANDET),
    GLOPPEN("Gloppen", "4650", NorwegianProvince.VESTLAND), GOL("Gol", "3041", NorwegianProvince.VIKEN, "Norwegen"),
    GRAN("Gran", "3446", NorwegianProvince.INNLANDET, "Kommune"), GRANE("Grane", "1825", NorwegianProvince.NORDLAND, "Nordland"),
    GRATANGEN("Gratangen", "5414", NorwegianProvince.TROMS_OG_FINNMARK), GRIMSTAD("Grimstad", "4202", NorwegianProvince.AGDER),
    GRONG("Grong", "5045", NorwegianProvince.TROENDELAG), GRUE("Grue", "3417", NorwegianProvince.INNLANDET),
    GULEN("Gulen", "4635", NorwegianProvince.VESTLAND), KAUTOKEINO("Kautokeino", "5430", NorwegianProvince.TROMS_OG_FINNMARK),
    HAMAROEY("Hamarøy", "1875", NorwegianProvince.NORDLAND), HADSEL("Hadsel", "1866", NorwegianProvince.NORDLAND),
    HALDEN("Halden", "3001", NorwegianProvince.VIKEN, "Norwegen"), HAMAR("Hamar", "3403", NorwegianProvince.INNLANDET),
    HAMMERFEST("Hammerfest", "5406", NorwegianProvince.TROMS_OG_FINNMARK), HAREID("Hareid", "1517", NorwegianProvince.MOERE_OG_ROMSDAL),
    HARSTAD("Harstad", "5402", NorwegianProvince.TROMS_OG_FINNMARK), HASVIK("Hasvik", "5433", NorwegianProvince.TROMS_OG_FINNMARK),
    HAUGESUND("Haugesund", "1106", NorwegianProvince.ROGALAND), HEIM("Heim", "5055", NorwegianProvince.TROENDELAG, "Norwegen"),
    HEMNES("Hemnes", "1832", NorwegianProvince.NORDLAND), HEMSEDAL("Hemsedal", "3042", NorwegianProvince.VIKEN),
    HEROEY1818("Herøy", "1818", NorwegianProvince.NORDLAND, "Nordland"), HEROEY1515("Herøy", "1515", NorwegianProvince.MOERE_OG_ROMSDAL, "Møre og Romsdal"),
    HITRA("Hitra", "5056", NorwegianProvince.TROENDELAG), HJARTDAL("Hjartdal", "3819", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    HJELMELAND("Hjelmeland", "1133", NorwegianProvince.ROGALAND), HOL("Hol", "3044", NorwegianProvince.VIKEN, "Norwegen"),
    HOLE("Hole", "3038", NorwegianProvince.VIKEN, "Norwegen"), HOLMESTRAND("Holmestrand", "3802", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    HOLTAALEN("Holtålen", "5026", NorwegianProvince.TROENDELAG), HORTEN("Horten", "3801", NorwegianProvince.VESTFOLD_OG_TELEMARK, "Norwegen"),
    HURDAL("Hurdal", "3037", NorwegianProvince.VIKEN), HUSTADVIKA("Hustadvika", "1579", NorwegianProvince.MOERE_OG_ROMSDAL, "Kommune"),
    HVALER("Hvaler", "3011", NorwegianProvince.VIKEN), HYLLESTAD("Hyllestad", "4637", NorwegianProvince.VESTLAND),
    HAEGEBOSTAD("Hægebostad", "4226", NorwegianProvince.AGDER), HOEYANGER("Høyanger", "4638", NorwegianProvince.VESTLAND),
    HOEYLANDET("Høylandet", "5046", NorwegianProvince.TROENDELAG), HAA("Hå", "1119", NorwegianProvince.ROGALAND),
    IBESTAD("Ibestad", "5413", NorwegianProvince.TROMS_OG_FINNMARK), INDEROEY("Inderøy", "5053", NorwegianProvince.TROENDELAG),
    INDRE_FOSEN("Indre Fosen", "5054", NorwegianProvince.TROENDELAG), INDRE_OESTFOLD("Indre Østfold", "3014", NorwegianProvince.VIKEN),
    IVELAND("Iveland", "4218", NorwegianProvince.AGDER), JEVNAKER("Jevnaker", "3053", NorwegianProvince.VIKEN),
    KARASJOK("Karasjok", "5437", NorwegianProvince.TROMS_OG_FINNMARK), KARLSOEY("Karlsøy", "5423", NorwegianProvince.TROMS_OG_FINNMARK),
    KARMOEY("Karmøy", "1149", NorwegianProvince.ROGALAND), KINN("Kinn", "4602", NorwegianProvince.VESTLAND, "Kommune"),
    KLEPP("Klepp", "1120", NorwegianProvince.ROGALAND), KONGSBERG("Kongsberg", "3006", NorwegianProvince.VIKEN),
    KONGSVINGER("Kongsvinger", "3401", NorwegianProvince.INNLANDET), KRAGEROE("Kragerø", "3814", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    KRISTIANSAND("Kristiansand", "4204", NorwegianProvince.AGDER), KRISTIANSUND("Kristiansund", "1505", NorwegianProvince.MOERE_OG_ROMSDAL),
    KROEDSHERAD("Krødsherad", "3046", NorwegianProvince.VIKEN), KVAM("Kvam", "4622", NorwegianProvince.VESTLAND),
    KVINESDAL("Kvinesdal", "4227", NorwegianProvince.AGDER), KVINNHERAD("Kvinnherad", "4617", NorwegianProvince.VESTLAND),
    KVITESEID("Kviteseid", "3821", NorwegianProvince.VESTFOLD_OG_TELEMARK), KVITSOEY("Kvitsøy", "1144", NorwegianProvince.ROGALAND),
    KVAEFJORD("Kvæfjord", "5411", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"), KVAENANGEN("Kvænangen", "5429", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"),
    LARVIK("Larvik", "3805", NorwegianProvince.VESTFOLD_OG_TELEMARK), LEBESBY("Lebesby", "5438", NorwegianProvince.TROMS_OG_FINNMARK),
    LEIRFJORD("Leirfjord", "1822", NorwegianProvince.NORDLAND), LEKA("Leka", "5052", NorwegianProvince.TROENDELAG, "Norwegen"),
    LESJA("Lesja", "3432", NorwegianProvince.INNLANDET), LEVANGER("Levanger", "5037", NorwegianProvince.TROENDELAG),
    LIER("Lier", "3049", NorwegianProvince.VIKEN, "Norwegen"), LIERNE("Lierne", "5042", NorwegianProvince.TROENDELAG),
    LILLEHAMMER("Lillehammer", "3405", NorwegianProvince.INNLANDET), LILLESAND("Lillesand", "4215", NorwegianProvince.AGDER),
    LILLESTROEM("Lillestrøm", "3030", NorwegianProvince.VIKEN, "Kommune"), LINDESNES("Lindesnes", "4205", NorwegianProvince.AGDER),
    LAVANGEN("Lavangen", "5415", NorwegianProvince.TROMS_OG_FINNMARK), LOM("Lom", "3434", NorwegianProvince.INNLANDET, "Norwegen"),
    LOPPA("Loppa", "5432", NorwegianProvince.TROMS_OG_FINNMARK), LUND("Lund", "1112", NorwegianProvince.ROGALAND, "Norwegen"),
    LUNNER("Lunner", "3054", NorwegianProvince.VIKEN), LUROEY("Lurøy", "1834", NorwegianProvince.NORDLAND),
    LUSTER("Luster", "4644", NorwegianProvince.VESTLAND, "Norwegen"), LYNGDAL("Lyngdal", "4225", NorwegianProvince.AGDER),
    LYNGEN("Lyngen", "5424", NorwegianProvince.TROMS_OG_FINNMARK), LAERDAL("Lærdal", "4642", NorwegianProvince.VESTLAND),
    LOEDINGEN("Lødingen", "1851", NorwegianProvince.NORDLAND), LOERENSKOG("Lørenskog", "3029", NorwegianProvince.VIKEN),
    LOETEN("Løten", "3412", NorwegianProvince.INNLANDET), MALVIK("Malvik", "5031", NorwegianProvince.TROENDELAG),
    MARKER("Marker", "3013", NorwegianProvince.VIKEN, "Norwegen"), MASFJORDEN("Masfjorden", "4634", NorwegianProvince.VESTLAND),
    MELHUS("Melhus", "5028", NorwegianProvince.TROENDELAG), MELOEY("Meløy", "1837", NorwegianProvince.NORDLAND),
    MERAAKER("Meråker", "5034", NorwegianProvince.TROENDELAG), MIDTRE_GAULDAL("Midtre Gauldal", "5027", NorwegianProvince.TROENDELAG),
    MIDT_TELEMARK("Midt-Telemark", "3817", NorwegianProvince.VESTFOLD_OG_TELEMARK), MODALEN("Modalen", "4629", NorwegianProvince.VESTLAND),
    MODUM("Modum", "3047", NorwegianProvince.VIKEN), MOLDE("Molde", "1506", NorwegianProvince.MOERE_OG_ROMSDAL),
    MOSKENES("Moskenes", "1874", NorwegianProvince.NORDLAND), MOSS("Moss", "3002", NorwegianProvince.VIKEN),
    MAALSELV("Målselv", "5418", NorwegianProvince.TROMS_OG_FINNMARK), MAASOEY("Måsøy", "5434", NorwegianProvince.TROMS_OG_FINNMARK),
    NAMSOS("Namsos", "5007", NorwegianProvince.TROENDELAG), NAMSSKOGAN("Namsskogan", "5044", NorwegianProvince.TROENDELAG),
    NANNESTAD("Nannestad", "3036", NorwegianProvince.VIKEN), NARVIK("Narvik", "1806", NorwegianProvince.NORDLAND),
    NES("Nes", "3034", NorwegianProvince.VIKEN, "Akershus"), NESBYEN("Nesbyen", "3040", NorwegianProvince.VIKEN),
    NESNA("Nesna", "1828", NorwegianProvince.NORDLAND), NESODDEN("Nesodden", "3023", NorwegianProvince.VIKEN),
    NISSEDAL("Nissedal", "3822", NorwegianProvince.VESTFOLD_OG_TELEMARK), NITTEDAL("Nittedal", "3031", NorwegianProvince.VIKEN),
    NOME("Nome", "3816", NorwegianProvince.VESTFOLD_OG_TELEMARK, "Norwegen"), NORD_AURDAL("Nord-Aurdal", "3451", NorwegianProvince.INNLANDET),
    NORD_FRON("Nord-Fron", "3436", NorwegianProvince.INNLANDET), NORDKAPP("Nordkapp", "5435", NorwegianProvince.TROMS_OG_FINNMARK),
    NORD_ODAL("Nord-Odal", "3414", NorwegianProvince.INNLANDET), NORDRE_FOLLO("Nordre Follo", "3020", NorwegianProvince.VIKEN),
    NORDREISA("Nordreisa", "5428", NorwegianProvince.TROMS_OG_FINNMARK), NORDRE_LAND("Nordre Land", "3448", NorwegianProvince.INNLANDET),
    NORE_OG_UVDAL("Nore og Uvdal", "3052", NorwegianProvince.VIKEN), NOTODDEN("Notodden", "3808", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    NAEROEYSUND("Nærøysund", "5060", NorwegianProvince.TROENDELAG), OPPDAL("Oppdal", "5021", NorwegianProvince.TROENDELAG),
    ORKLAND("Orkland", "5059", NorwegianProvince.TROENDELAG), OS("Os", "3430", NorwegianProvince.INNLANDET, "Innlandet"),
    OSEN("Osen", "5020", NorwegianProvince.TROENDELAG), OSLO("Oslo", "0301", NorwegianProvince.OSLO),
    OSTEROEY("Osterøy", "4630", NorwegianProvince.VESTLAND), OVERHALLA("Overhalla", "5047", NorwegianProvince.TROENDELAG),
    PORSANGER("Porsanger", "5436", NorwegianProvince.TROMS_OG_FINNMARK), PORSGRUNN("Porsgrunn", "3806", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    RAKKESTAD("Rakkestad", "3016", NorwegianProvince.VIKEN), RANA("Rana", "1833", NorwegianProvince.NORDLAND, "Nordland"),
    RANDABERG("Randaberg", "1127", NorwegianProvince.ROGALAND), RAUMA("Rauma", "1539", NorwegianProvince.MOERE_OG_ROMSDAL, "Kommune"),
    RENDALEN("Rendalen", "3424", NorwegianProvince.INNLANDET), RENNEBU("Rennebu", "5022", NorwegianProvince.TROENDELAG),
    RINDAL("Rindal", "5061", NorwegianProvince.TROENDELAG), RINGEBU("Ringebu", "3439", NorwegianProvince.INNLANDET),
    RINGERIKE("Ringerike", "3007", NorwegianProvince.VIKEN), RINGSAKER("Ringsaker", "3411", NorwegianProvince.INNLANDET),
    RISOER("Risør", "4201", NorwegianProvince.AGDER), ROLLAG("Rollag", "3051", NorwegianProvince.VIKEN),
    RAELINGEN("Rælingen", "3027", NorwegianProvince.VIKEN), ROEDOEY("Rødøy", "1836", NorwegianProvince.NORDLAND),
    ROEROS("Røros", "5025", NorwegianProvince.TROENDELAG), ROEST("Røst", "1856", NorwegianProvince.NORDLAND),
    RAADE("Råde", "3017", NorwegianProvince.VIKEN), ROEYRVIK("Røyrvik", "5043", NorwegianProvince.TROENDELAG),
    SALANGEN("Salangen", "5417", NorwegianProvince.TROMS_OG_FINNMARK), SALTDAL("Saltdal", "1840", NorwegianProvince.NORDLAND),
    SAMNANGER("Samnanger", "4623", NorwegianProvince.VESTLAND), SANDE("Sande", "1514", NorwegianProvince.MOERE_OG_ROMSDAL, "Møre og Romsdal"),
    SANDEFJORD("Sandefjord", "3804", NorwegianProvince.VESTFOLD_OG_TELEMARK), SANDNES("Sandnes", "1108", NorwegianProvince.ROGALAND),
    SARPSBORG("Sarpsborg", "3003", NorwegianProvince.VIKEN), SAUDA("Sauda", "1135", NorwegianProvince.ROGALAND),
    SEL("Sel", "3437", NorwegianProvince.INNLANDET), SELBU("Selbu", "5032", NorwegianProvince.TROENDELAG),
    SELJORD("Seljord", "3820", NorwegianProvince.VESTFOLD_OG_TELEMARK), SENJA("Senja", "5421", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"),
    SIGDAL("Sigdal", "3045", NorwegianProvince.VIKEN), SILJAN("Siljan", "3812", NorwegianProvince.VESTFOLD_OG_TELEMARK, "Norwegen"),
    SIRDAL("Sirdal", "4228", NorwegianProvince.AGDER), SKAUN("Skaun", "5029", NorwegianProvince.TROENDELAG),
    SKIEN("Skien", "3807", NorwegianProvince.VESTFOLD_OG_TELEMARK), SKIPTVET("Skiptvet", "3015", NorwegianProvince.VIKEN),
    SKJERVOEY("Skjervøy", "5427", NorwegianProvince.TROMS_OG_FINNMARK), SKJAAK("Skjåk", "3433", NorwegianProvince.INNLANDET),
    SMOELA("Smøla", "1573", NorwegianProvince.MOERE_OG_ROMSDAL), SNAASA("Snåsa", "5041", NorwegianProvince.TROENDELAG),
    SOGNDAL("Sogndal", "4640", NorwegianProvince.VESTLAND), SOKNDAL("Sokndal", "1111", NorwegianProvince.ROGALAND),
    SOLA("Sola", "1124", NorwegianProvince.ROGALAND, "Norwegen"), SOLUND("Solund", "4636", NorwegianProvince.VESTLAND),
    SORTLAND("Sortland", "1870", NorwegianProvince.NORDLAND), STAD("Stad", "4649", NorwegianProvince.VESTLAND),
    STANGE("Stange", "3413", NorwegianProvince.INNLANDET, "Norwegen"), STAVANGER("Stavanger", "1103", NorwegianProvince.ROGALAND),
    STEIGEN("Steigen", "1848", NorwegianProvince.NORDLAND), STEINKJER("Steinkjer", "5006", NorwegianProvince.TROENDELAG),
    STJOERDAL("Stjørdal", "5035", NorwegianProvince.TROENDELAG), STORD("Stord", "4614", NorwegianProvince.VESTLAND),
    STOR_ELVDAL("Stor-Elvdal", "3423", NorwegianProvince.INNLANDET), STORFJORD("Storfjord", "5425", NorwegianProvince.TROMS_OG_FINNMARK, "Kommune"),
    STRAND("Strand", "1130", NorwegianProvince.ROGALAND, "Norwegen"), STRANDA("Stranda", "1525", NorwegianProvince.MOERE_OG_ROMSDAL),
    STRYN("Stryn", "4651", NorwegianProvince.VESTLAND), SULA("Sula", "1531", NorwegianProvince.MOERE_OG_ROMSDAL, "Kommune"),
    SULDAL("Suldal", "1134", NorwegianProvince.ROGALAND), SUNNDAL("Sunndal", "1563", NorwegianProvince.MOERE_OG_ROMSDAL, "Kommune"),
    SUNNFJORD("Sunnfjord", "4647", NorwegianProvince.VESTLAND, "Kommune"), SURNADAL("Surnadal", "1566", NorwegianProvince.MOERE_OG_ROMSDAL),
    SVEIO("Sveio", "4612", NorwegianProvince.VESTLAND), SYKKYLVEN("Sykkylven", "1528", NorwegianProvince.MOERE_OG_ROMSDAL),
    SOEMNA("Sømna", "1812", NorwegianProvince.NORDLAND), SOENDRE_LAND("Søndre Land", "3447", NorwegianProvince.INNLANDET),
    SOER_AURDAL("Sør-Aurdal", "3449", NorwegianProvince.INNLANDET), SOERFOLD("Sørfold", "1845", NorwegianProvince.NORDLAND),
    SOER_FRON("Sør-Fron", "3438", NorwegianProvince.INNLANDET), SOER_ODAL("Sør-Odal", "3415", NorwegianProvince.INNLANDET),
    SOERREISA("Sørreisa", "5419", NorwegianProvince.TROMS_OG_FINNMARK), SOER_VARANGER("Sør-Varanger", "5444", NorwegianProvince.TROMS_OG_FINNMARK),
    TIME("Time", "1121", NorwegianProvince.ROGALAND, "Norwegen"), TINGVOLL("Tingvoll", "1560", NorwegianProvince.MOERE_OG_ROMSDAL),
    TINN("Tinn", "3818", NorwegianProvince.VESTFOLD_OG_TELEMARK), TOKKE("Tokke", "3824", NorwegianProvince.VESTFOLD_OG_TELEMARK),
    TOLGA("Tolga", "3426", NorwegianProvince.INNLANDET, "Norwegen"), TROMSOE("Tromsø", "5401", NorwegianProvince.TROMS_OG_FINNMARK),
    TRONDHEIM("Trondheim", "5001", NorwegianProvince.TROENDELAG), TRYSIL("Trysil", "3421", NorwegianProvince.INNLANDET),
    TRAENA("Træna", "1835", NorwegianProvince.NORDLAND), TVEDESTRAND("Tvedestrand", "4213", NorwegianProvince.AGDER),
    TYDAL("Tydal", "5033", NorwegianProvince.TROENDELAG), TYNSET("Tynset", "3427", NorwegianProvince.INNLANDET),
    TYSNES("Tysnes", "4616", NorwegianProvince.VESTLAND), TYSVAER("Tysvær", "1146", NorwegianProvince.ROGALAND),
    TOENSBERG("Tønsberg", "3803", NorwegianProvince.VESTFOLD_OG_TELEMARK), ULLENSAKER("Ullensaker", "3033", NorwegianProvince.VIKEN),
    ULLENSVANG("Ullensvang", "4618", NorwegianProvince.VESTLAND), ULSTEIN("Ulstein", "1516", NorwegianProvince.MOERE_OG_ROMSDAL),
    ULVIK("Ulvik", "4620", NorwegianProvince.VESTLAND), NESSEBY("Nesseby", "5442", NorwegianProvince.TROMS_OG_FINNMARK),
    UTSIRA("Utsira", "1151", NorwegianProvince.ROGALAND), VADSOE("Vadsø", "5405", NorwegianProvince.TROMS_OG_FINNMARK),
    VAKSDAL("Vaksdal", "4628", NorwegianProvince.VESTLAND, "Kommune"), VALLE("Valle", "4221", NorwegianProvince.AGDER),
    VANG("Vang", "3454", NorwegianProvince.INNLANDET), VANYLVEN("Vanylven", "1511", NorwegianProvince.MOERE_OG_ROMSDAL),
    VARDOE("Vardø", "5404", NorwegianProvince.TROMS_OG_FINNMARK), VEFSN("Vefsn", "1824", NorwegianProvince.NORDLAND),
    VEGA("Vega", "1815", NorwegianProvince.NORDLAND, "Norwegen"), VEGAARSHEI("Vegårshei", "4212", NorwegianProvince.AGDER),
    VENNESLA("Vennesla", "4223", NorwegianProvince.AGDER), VERDAL("Verdal", "5038", NorwegianProvince.TROENDELAG),
    VESTBY("Vestby", "3019", NorwegianProvince.VIKEN), VESTNES("Vestnes", "1535", NorwegianProvince.MOERE_OG_ROMSDAL),
    VESTRE_SLIDRE("Vestre Slidre", "3452", NorwegianProvince.INNLANDET), VESTRE_TOTEN("Vestre Toten", "3443", NorwegianProvince.INNLANDET),
    VESTVAAGOEY("Vestvågøy", "1860", NorwegianProvince.NORDLAND), VEVELSTAD("Vevelstad", "1816", NorwegianProvince.NORDLAND),
    VIK("Vik", "4639", NorwegianProvince.VESTLAND, "Kommune"), VINDAFJORD("Vindafjord", "1160", NorwegianProvince.ROGALAND),
    VINJE("Vinje", "3825", NorwegianProvince.VESTFOLD_OG_TELEMARK), VOLDA("Volda", "1577", NorwegianProvince.MOERE_OG_ROMSDAL),
    VOSS("Voss", "4621", NorwegianProvince.VESTLAND, "Norwegen"), VAEROEY("Værøy", "1857", NorwegianProvince.NORDLAND),
    VAAGAN("Vågan", "1865", NorwegianProvince.NORDLAND), VAAGAA("Vågå", "3435", NorwegianProvince.INNLANDET),
    VAALER3018("Våler", "3018", NorwegianProvince.VIKEN, "Viken"), VAALER3419("Våler", "3419", NorwegianProvince.INNLANDET, "Innlandet"),
    OEKSNES("Øksnes", "1868", NorwegianProvince.NORDLAND), OERLAND("Ørland", "5057", NorwegianProvince.TROENDELAG),
    OERSTA("Ørsta", "1520", NorwegianProvince.MOERE_OG_ROMSDAL), OESTRE_TOTEN("Østre Toten", "3442", NorwegianProvince.INNLANDET),
    OEVRE_EIKER("Øvre Eiker", "3048", NorwegianProvince.VIKEN), OEYER("Øyer", "3440", NorwegianProvince.INNLANDET),
    OEYGARDEN("Øygarden", "4626", NorwegianProvince.VESTLAND), OEYSTRE_SLIDRE("Øystre Slidre", "3453", NorwegianProvince.INNLANDET),
    AAFJORD("Åfjord", "5058", NorwegianProvince.TROENDELAG), AAL("Ål", "3043", NorwegianProvince.VIKEN),
    AALESUND("Ålesund", "1507", NorwegianProvince.MOERE_OG_ROMSDAL), AAMLI("Åmli", "4217", NorwegianProvince.AGDER),
    AAMOT("Åmot", "3422", NorwegianProvince.INNLANDET), HATTFJELLDAL("Hattfjelldal", "1826", NorwegianProvince.NORDLAND),
    AARDAL("Årdal", "4643", NorwegianProvince.VESTLAND), AAS("Ås", "3021", NorwegianProvince.VIKEN, "Kommune"),
    AASERAL("Åseral", "4224", NorwegianProvince.AGDER), AASNES("Åsnes", "3418", NorwegianProvince.INNLANDET);


    private final String name;
    private final String municipalityNumber;
    private final NorwegianProvince province;
    private final String link;

    NorwegianMunicipality(String name, String number, NorwegianProvince province) {
        this.name = name;
        this.municipalityNumber = number;
        this.province = province;
        this.link = "[[" + name + "]]";
    }

    NorwegianMunicipality(String name, String number, NorwegianProvince province, String lemma) {
        this.name = name;
        this.municipalityNumber = number;
        this.province = province;
        this.link = "[[" + name + " (" + lemma + ")|" + name + "]]";
    }

    /**
     * Checks if the name of a municipality is in the list of municipalities and returns
     * the municipality or null.
     *
     * @param name the input name
     * @return the municipality or null
     */
    public static NorwegianMunicipality getMunicipalityByName(String name) {
        for (NorwegianMunicipality municipality : NorwegianMunicipality.values()) {
            if (municipality.getName().toLowerCase().equals(name.toLowerCase())) {
                return municipality;
            }
        }

        return null;
    }

    /**
     * Checks if the name of a municipality is in the list of municipalities and returns
     * the municipality or null.
     *
     * @param municipalityNumber the input number
     * @return the municipality or null
     */
    public static NorwegianMunicipality getMunicipalityByNumber(String municipalityNumber) {
        for (NorwegianMunicipality municipality : NorwegianMunicipality.values()) {
            if (municipality.getMunicipalityNumber().toLowerCase().equals(municipalityNumber)) {
                return municipality;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getMunicipalityNumber() {
        return municipalityNumber;
    }

    public NorwegianProvince getProvince() {
        return province;
    }

    public String getProvinceName() {
        return province.getName();
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the category of the municipality.
     *
     * @return the category
     */
    public String getMunicipalityCategory() {
        return Categories.createCategory(name);
    }

    public boolean isSami() {
        MunicipalityData municipalityData = MunicipalityAPI.getMunicipalityData(municipalityNumber);

        return municipalityData.isSamiPlace();
    }
}