public class Tekst {

    private String tekst1;
    private String tekst2;
    private String tekst3;

    private final int R = 265;
    private int[] right;
    private int[][] dfa;

    public Tabel searchKMP(String woord) {
        int woordlengte = woord.length();
        int teller = 0;

        dfa = new int[R][woordlengte];
        dfa[woord.charAt(0)][0] = 1;

        for (int i = 0, j = 1; j < woordlengte; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[i][j];
            }
            dfa[woord.charAt(j)][j] = j + 1;
            i = dfa[woord.charAt(j)][i];
        }

        //lengtes van elke string
        int t1 = tekst1.length();
        int t2 = tekst2.length();
        int t3 = tekst3.length();

        Tabel txt1 = search1(t1, tekst1, woord, woordlengte);
        Tabel txt2 = search1(t2, tekst2, woord, woordlengte);
        Tabel txt3 = search1(t3, tekst3, woord, woordlengte);

        return new Tabel((txt1.getTeller() + txt2.getTeller() + txt3.getTeller()),
                (txt1.getVergelijkingen() + txt2.getVergelijkingen() + txt3.getVergelijkingen()));
    }

    public Tabel search1(int tekstlengte, String tekst, String woord, int woordlengte) {
        int teller = 0;
        int vergelijkingen = 0;

        int i, j;
        for (i = 0, j = 0; i < tekstlengte && j < woordlengte; i++) {
            j = dfa[tekst.charAt(i)][j];

            if (j == woordlengte) {
                teller++;
                j = 0;
            }
            vergelijkingen++;
        }
        return new Tabel(teller, vergelijkingen);
    }

    public String toString() {
        return tekst1 + tekst2 + tekst3;
    }

    public Tekst() {
        tekst1 = "Een nieuwe lente en een nieuw geluid:\n" +
                "Ik wil dat dit lied klinkt als het gefluit,\n" +
                "Dat ik vaak hoorde voor een zomernacht,\n" +
                "In een oud stadje, langs de watergracht --\n" +
                "In huis was 't donker, maar de stille straat\n" +
                "Vergaarde schemer, aan de lucht blonk laat\n" +
                "Nog licht, er viel een gouden blanke schijn\n" +
                "Over de gevels van mijn raamkozijn.\n" +
                "Dan blies een jongen als een orgelpijp,\n" +
                "De klanken schudden in de lucht zoo rijp\n" +
                "Als jonge kersen, wen een lentewind\n" +
                "In 't boschje opgaat en zijn reis begint.\n" +
                "Hij dwaald' over de bruggn, op den wal\n" +
                "Van 't water, langzaam gaande, overal\n" +
                "Als 'n jonge vogel fluitend, onbewust\n" +
                "Van eigen blijheid om de avondrust.\n" +
                "En menig moe man, die zijn avondmaal\n" +
                "Nam, luisterde, als naar een oud verhaal,\n" +
                "Glimlachend, en een hand die 't venster sloot,\n" +
                "Talmde een pooze wijl de jongen floot. \n" +
                "Zóó wil ik dat dit lied klinkt, er is één\n" +
                "Die ik wèl wenschte dat mijn stem bescheen\n" +
                "Met meer dan lachen van haar zachte oog...\n" +
                "Heil, heil, ik voel hier handen en den weeken boog\n" +
                "Van haren arm. Een koepel van blind licht,\n" +
                "Mild nevelend, omgeeft mijn aangezicht,\n" +
                "Mijn stem brandt in mij als de geele vlam\n" +
                "Van gas in glazen kooi, een eikenstam\n" +
                "Breekt uit in twijgen en jong loover spruit\n" +
                "Naar buiten: Hoort, er gaat een nieuw geluid:\n" +
                "Een jonge veldheer staat, in 't blauw en goud\n" +
                "Roept aan de holle poort een luid heraut. \n" +
                "\n" +
                "Blauw dreef de zee, het water van de zon\n" +
                "Vloot pas en frisscher uit de gouden bron,\n" +
                "Op woll'ge golven, die zich lieten wasschen\n" +
                "En zalven met zijn licht, uit open plassen\n" +
                "Stonden golven als witte rammen op,\n" +
                "Met trossen schuim en horens op den kop. \n" +
                "Maar in zijn rand verbrak de zee in reven\n" +
                "Telkens en telkens weer, er boven dreven\n" +
                "Als gouden bijen wolken in het blauw,\n" +
                "Duizende volle mondjes bliezen dauw\n" +
                "En zout in ronde droppen op den rand\n" +
                "Van roodgelipte schelpen, vn het strand\n" +
                "De bloemen, witte en geele als room en rood'\n" +
                "Als kindernagels, en gestreepte, lood-\n" +
                "Blauw als een avondlucht bij windgetij.\n" +
                "Kinkhorens murmelden hun melodij\n" +
                "In rust, op 't gonzen van de golf dreef voort\n" +
                "Helderder ruischen als in drooger woord\n" +
                "Vochtige klinkers, schelpen rinkelden\n" +
                "In 't glinst'rend water glas en kiezel en\n" +
                "Metalen ringen, en op veeren wiek\n" +
                "Vervoerde waterbellen vol muziek\n" +
                "Geladen, lichter wind. Over het duin\n" +
                "Dreven ze door de lucht tot in den tuin\n" +
                "Van Holland, en die schoon en vol was zonk\n" +
                "En brak in 't zinken wijl muziek weerklonk\n" +
                "Schooner dan stemmen, en van mijmerij\n" +
                "Elk duin opzag verre en van nabij. \n" +
                "En in een waterwieg, achter in zee -\n" +
                "Duizend schuimige spreien deinen mee -\n" +
                "Ontwaakt' een jonge Trion en een lach\n" +
                "Vloeid' over zijn gelaat heer, als hij zag\n" +
                "De waterheuvels om zich en een toren\n" +
                "Van een wit wolkje boven zich, zijn horen\n" +
                "Lag in zijn blooten arm, verguld in blank.\n" +
                "Hij blies er in, er viel een zacht geklank\n" +
                "Als zomerregen uit den gouden mond.\n" +
                "Toen luider lachend wentelde hij rond\n" +
                "En zwom naar boven door den waterval\n" +
                "Van schuim en sneeuw, die drijft in ieder dal\n" +
                "Tusschen twee waterbergen, zie, hij ligt\n" +
                "Nest'lend in kroezig water, 'n wiegewicht\n" +
                "Door moeder pas gewasschen in haar schoot;\n" +
                "Het drijft van ronde druppels, overrood\n" +
                "Reiken de armpjes, uit het mondje gaat\n" +
                "Gekraai; zoo dreef hij, in het bol gelaat\n" +
                "Tusschen de lippen in, de gouden kelk,\n" +
                "Fontein van gouden klanken, een vaas melk-\n" +
                "Wit was hij drijvend met gemengden wijn,\n" +
                "Vurig rood blozend door het porselein.\n" +
                "Nu zetelt hij in 't water, baar na baar\n" +
                "Ziet hij al lachend rijzen na elkaar,\n" +
                "Daar schatert hij en spant den blanken arm,\n" +
                "En door het water gaat een luid alarm. \n" +
                "Toen werd de zee wel als een groot zwaar man\n" +
                "Van vroeger eeuw en kleding, rijker dan\n" +
                "Nu in dit land zijn: bruin fluweel en zij\n" +
                "Als zilver en zwart vilt en pelterij\n" +
                "Vèr uit Siberisch Rusland; geel koper\n" +
                "Brandt vele lichtjes in de plooien der\n" +
                "Hoozen, in knoopen en in passement\n" +
                "Van het breed overkleed, wijd uithangend. \n" +
                "Was zoo de zee? Neen, neen, een stad geleek\n" +
                "Ze, pleinen en straten in de kermisweek,\n" +
                "Boerinne' en boeren, en muziek en dans\n" +
                "In de herbergen en in lichten krans\n" +
                "Om elke markt de snuisterijenkramen.\n" +
                "Of als een koning komt en alle ramen\n" +
                "Zijn licht des avonds en uit ieder dak\n" +
                "Een witte vlag. Zoo was de zee, er stak\n" +
                "Een vlag van alle gevels, achter 't raam\n" +
                "Der golven brandden rijen lichten, saam\n" +
                "Liep heel het volk. Meermannen zwommen aan,\n" +
                "Nimfen en elven der zee, en zaten aan\n" +
                "De groene hellingen. Maar Tritons woorden stonden\n" +
                "Oud en gebaard ter zijde, aan de monden\n" +
                "Trompetten, bouwende een lange straat\n" +
                "Geluid over het zeegelaat. \n" +
                "Toen werd het stiller en een wolk van licht\n" +
                "Begon te drijven op het zeegezicht,\n" +
                "Dichtbij de wolken waar een witte schaar\n" +
                "Van jonge winden zat te lachen. Daar\n" +
                "Werd alles zwijgend. En een gele boot\n" +
                "Kroop uit den nevel en daarin school rood,\n" +
                "Vooraan en vóór het linnen zeil, een kind...\n" +
                "Wee, wee mij, nu mijn hart mij overwint,\n" +
                "En mijn stem stom slaat nu dit nieuwste woord\n" +
                "Geboren werd...er is iets dat mij bekoort\n" +
                "In ieder ding, en die dat weet, hij gaat\n" +
                "Altijd langs watren, door jong gras, en laat\n" +
                "Zijn voeten koel in dauw van wei.\n" +
                "Voor hem is 't nimmer nev'lig, maar een Mei\n" +
                "Van kind'ren en een stroom vabn bloemen waar\n" +
                "Zijn woning is, en zóó is 't ook mij, maar\n" +
                "Dit kind was louter, niets dan lieflijkheid;\n" +
                "Het zat zoo stil te staren, zoo verblijd\n" +
                "Blonken haar oogen in het schaduwlicht\n" +
                "Achter het zeil, zoo bloosde haar gezicht,\n" +
                "Zóó mooi, zóó zacht was ze, een rozeblad\n" +
                "Geblazen door den waremn boschwind, dat\n" +
                "De beek afloopt onder den hazelaar,\n" +
                "En dan tusschen de lage weiden, waar\n" +
                "Het groen is en de hooge hemel blauw.\n" +
                "Blij en verwonderd of ze nòg niet wou\n" +
                "Gelooven 't water, tot verwond'ring week\n" +
                "Voor veilig lachen en ze beurt'lings keek\n" +
                "Naar schuimfonteinen en de gladde kruin\n" +
                "Van golven in dien witgebloemden tuin\n" +
                "Der zee, of naar den Wind, die danste aan\n" +
                "Als 'n jonge kerel op een kermisbaan,\n" +
                "Of naar 'n visch, die roode vinnen uit\n" +
                "Het water stak. Dat alles was een buit\n" +
                "Voor jonge oogen. Daar veel verder stond\n" +
                "Hoog op zijn teenen een zeegod, zijn mond\n" +
                "Bolde op een gouden horen. In het rond\n" +
                "Brak één geluid van water en van lucht,\n" +
                "En alles nieuw voor een die zulk gerucht\n" +
                "Nooit hoord'; haar hoofd werd voller en ze deed\n" +
                "De oogen toe en rustte - de boot gleed\n" +
                "Langzamer verder; onbeweeglijk scheen\n" +
                "De zon, de wind liep mee en om haar heen.\n" +
                "Wie was ze? Van de twalef zusters één,\n" +
                "Die op de zon staan, hand in hand, alleen,\n" +
                "Als 't spel van kindren in een kleinen kring.\n" +
                "Om beurten gaat er een en breekt den ring\n" +
                "En laat de andren bedroefd achter, maar\n" +
                "Veel zijn hun tranen niet, het weenen waar\n" +
                "Zoo gouden licht is, kan niet durend zijn.\n" +
                "Zoo zijn ze weldra blij weer en hun pijn\n" +
                "Houdt op - toch was hun droefheid nu het meest\n" +
                "Bij deze laatste leegt', er was geweest\n" +
                "Zoo lang gelach met haar, zij was altijd\n" +
                "De schoonste en de vreugd van elk, waar nijd\n" +
                "Niet is. Nu Was zij heen. De zusterrij\n" +
                "Boog over luistrend, ziende hoe 't getij\n" +
                "Met haar hoog ging. Er mistte een waas geluid\n" +
                "Van brekend schuim en gouden horens uit,\n" +
                "Omhoog tot haar. Die kindren keerden om,\n" +
                "En stonden naast elkander, weenend, stom.\n" +
                "Dat zijn de blonde maanden die daar staan,\n" +
                "Gelijk geboren toen de moedermaan\n" +
                "Heel zwaar was in een starr'gen winternacht.\n" +
                "Naakt baarde zij ze, maar de zon hield wacht,\n" +
                "Koudrood zooals hij met Aurora kwam,\n" +
                "Die sloeg ze in haar kleurig kleed, hij nam\n" +
                "Ze tot zich. Zie hoe blank en blond ze staan\n" +
                "In 'n ring van blond haar, één is heengegaan,\n" +
                "De liefste, blondste, ja de kleine Mei. \n" +
                "Niets in de ruime wereld is zoo blij\n" +
                "Als deze aarde: Cynthia als ze zit\n" +
                "In hare nachtboot, toont het blank gebit\n" +
                "Van lachen en de tweelingsterren staan\n" +
                "Stil bij haar, vragend: zal ze hier langs gaan?\n" +
                "En er is altijd vreugde in de lucht\n" +
                "Waar zij voorbij is en het zacht gerucht\n" +
                "Van hare vleugels wijkt. Dan liggen bloemen\n" +
                "Op haren weg en kleine eng'len noemen\n" +
                "Ze zamelend haar naam, hoe vol ze was\n" +
                "Van wonderen. En in het dichte gras\n" +
                "Dat in de hemelwei groeit, liggen zij\n" +
                "Lang pratend' of alleen in mijmerij. \n" +
                "Eén ding is droevig en maakt zacht geklaag\n" +
                "Altijd om de aarde heen, 'n nevel vaag\n" +
                "En luchtig om dat lijf: 't is wisseling\n" +
                "Van zijn en niet zijn en dat ieder ding:\n" +
                "Zielen en bloemen, drijven naar dat rijk,\n" +
                "Waar 't wit en stil is en den dood gelijk.\n" +
                "Want zooals altijd aan het eind van 't jaar\n" +
                "Trekvogels uit het land gaan met misbaar\n" +
                "Van vogelstemmen uit de hooge lucht,\n" +
                "De kind'ren op de straat hooren 't gerucht\n" +
                "En kijken, zeggend: ''zomer is voorbij,\n" +
                "De kou komt'' - in de wolken gaat de rij\n" +
                "Van vogels -- zóó zóó gaat alles voorbij.\n" +
                "Maar zooals ik eens aan het strand der zee\n" +
                "Was 's avonds, doch niet was mijn hart te vree\n" +
                "Maar bevend en ongerust -- en zooals toen\n" +
                "Vlak voor den hemel, voor het vermilioen,\n" +
                "Een vogel, een zwart beest vloog, duidelijk\n" +
                "Gespreid op staart en veer: daaraan gelijk\n" +
                "Komt élk ding en is schoon\n" +
                "Omdat het eenzaam is. Het is de zoon\n" +
                "Van Onrust, in de scheemring van zijn schoot\n" +
                "Geboren, en sterft eensklaps waar de dood\n" +
                "Het neerslaat - maar het staat voor 't licht\n" +
                "Zijn leven lang. Welaan, ik zoek 't gezicht\n" +
                "Van Mei zoolang zij in het leven was. \n" +
                "Zij dreef nu langs de banken, waar een wolk\n" +
                "Van rood zand elke golf afstuift, het volk\n" +
                "Zat daar in scharen, maar een groene grot\n" +
                "Wat verder 'n meermin en een watergod.\n" +
                "Mei zag ze en lachte en een zacht geschater\n" +
                "Klonk even bij haar, toen kwam van het water\n" +
                "Klappend een vlaag van handgeklap en toen\n" +
                "Gesnap van tongen, zooals vrouwen doen.\n" +
                "Maar hij keek fonklend en een rood gebloos\n" +
                "Verroodde háár wang - Mei stond op, een doos\n" +
                "Van zilver stond in hare hand, een poos\n" +
                "Hield ze roerloos - van haar arrem gleed\n" +
                "Langzaam een plooi weg uit het witte kleed.\n" +
                "Toen zagen honderd oogen, werd het stil,\n" +
                "Zoodat niets meer gehoord werd dan 't geril\n" +
                "Dat water maakte op de heuvels en\n" +
                "'t Gedempte lachen van wie nalachten.\n" +
                "Het zilver schitterde - daar vlogen heen\n" +
                "Twee fladderende vlindertjes de één\n" +
                "Als twee blaadjes ivoor van Indië,\n" +
                "En een als lapjes sjaal uit Perzië \n" +
                "Wiss'lend van glans de vlinders dansten voort,\n" +
                "Over de branding heen, toen klonk het woord\n" +
                "Van Mei: de lange dag vindt nu zijn eind\n" +
                "In 't wolkig westen: ziet, de zon verkwijnt\n" +
                "Al, het wordt donker en later en ik mag\n" +
                "Niet langer blijven. Zwemt nu heen. Ik zag\n" +
                "Zoo even reeds het lichten van de ster,\n" +
                "Den page die mijns vaders kleed draagt, ver\n" +
                "Achter het Oosten wacht de maan, een zweem\n" +
                "Van blank licht zwelt al van den diadeem.\n" +
                "Daarom vaart wel. Van hier. Maar vaart al zacht,\n" +
                "Want gaarne wilde ik mijn eersten nacht\n" +
                "Dragen in stilte. Ziet, daar is de maan,\n" +
                "Een vriendelijke gezellin, gij kunt gaan. \n" +
                "Zoo als des nachts de eenden, in het gras\n" +
                "Slapend, dat in de sloot groeit, met geplas\n" +
                "Plotseling wakker worden, snaterend,\n" +
                "Slobberend kroos, één staat er overend\n" +
                "Zijn vleugels slaand' en kruischt hoog in den nacht;\n" +
                "Zoo werd uit diepe stilte onverwacht\n" +
                "Beweging toen zij gingen. Maar nog lang\n" +
                "Verglomme' in 't nat trompetten, een gezang\n" +
                "Zongen een school meermannen, die heenzwom,\n" +
                "Hier dreven minnenden, ginder beklom\n" +
                "Een jonge god een hooge golf en keek\n" +
                "Of Mei stond waar zij stond -- o zij geleek\n" +
                "Een kleine witte baak; er werd in zee\n" +
                "Verlangd dien nacht om met de golven mee\n" +
                "Tot haar te gaan. Menig en menig prins\n" +
                "Zag zijn koralen leger niet, maar ginds\n" +
                "Zaten ze in hun mantels, waar heel ver\n" +
                "Het water spoelt onder een lage ster. \n" +
                "Zij was nu bijna bang, nu ze alleen\n" +
                "Gelaten, droeve golven met geween\n" +
                "Zag komen, zooals vrouwen die rondom\n" +
                "Een doodverdonken man gaan - om en om\n" +
                "Slaan de armen met een wijd en woest gebaar -\n" +
                "Zoo vielen ook de baren na elkaar\n" +
                "Aldoor donkerder en haar hart werd leeg\n" +
                "Door angst, tot plots van uit wat wolken zeeg\n" +
                "Regen van stralen en de gouden maan\n" +
                "Het water laafde. Zoo heb ik zien staan\n" +
                "Een monnik bij een volle donkre ton\n" +
                "Met glazen geraad, en weg nam hij de spon\n" +
                "Dat 't vonken spoot in bekers of de wijn\n" +
                "De zon nog in had van den geelen Rijn.\n" +
                "Zoo stond de maanvrouw in een hoogen wind\n" +
                "En boog de urn voorover voor haar kind.\n" +
                "En tusschen zee en wolken leek een kelder\n" +
                "Van wijn verlicht, 't wijnwater plaste helder\n" +
                "Over haar voetje. En om haar volle kuit\n" +
                "Toen zij door 't maanlicht waadde, lachten uit\n" +
                "Iederen druppel beeldjes van de maan;\n" +
                "Zij zag het telkens en bleef telkens staan. \n" +
                "Er lag op 't strand een zandheuvel, een fort\n" +
                "Als kindren bouwen, schuim en water stort\n" +
                "De grachten binnen als de vloed opkomt:\n" +
                "De bloote voetjes vluchten, de zee gromt.\n" +
                "Dat bouwden visscherskindren of misschien\n" +
                "Wel elven der zee, zooals men 's zomers zien\n" +
                "Kan, op een morgen, als de zon heel vroeg\n" +
                "Begint te schijnen, en juist licht genoeg\n" +
                "Geeft; in de verte is er dan een schijn\n" +
                "Van loopende kindren haastig uit het duin,\n" +
                "Jongens en meisjes, flauw rooskleurig, naakt.\n" +
                "Ze zijn er niet meer als 't zand witter blaakt.\n" +
                "Zoo was dit fort gebouwd misschien, waar zij\n" +
                "Ging zitten tegen 'n wal aan, om en bij\n" +
                "Lagen de schelpen, die het maanlicht maakt\n" +
                "Schatkamertjes van lciht, maar als het staakt,\n" +
                "Dan is de glinstring dood en huist gekreun.\n" +
                "Er binnen, geen behagelijk gedeun\n" +
                "Meer van de zomerachtermiddagen.\n" +
                "O wat verschrikte haar het wisselen\n" +
                "Van 't donker in de lucht en op de zee,\n" +
                "En van het melkig licht als de maan glee\n" +
                "Uit losse wolken in een zwartblauw meer,\n" +
                "Waar sterren fonkelden, maar keer op keer\n" +
                "Wegstierven, als grasbloempjes bij een roos\n" +
                "Gegroeid.- De gulle maan vergoot een hoos\n" +
                "Telkens van stralen, 't was een lange tijd\n" +
                "Voor 't hart weer stiller ging der kleine meid. \n" +
                "En toen zij daarna insliep, was het of\n" +
                "Een moeder heenging als haar kind slaapt, dof\n" +
                "Verblonk in moeders hand de maanlamp, kort\n" +
                "Achter de dunne wolkschermen, een schort\n" +
                "Grauwbruin hing voor de lage lucht; een deur\n" +
                "Waarin de maan verging, één lange scheur\n" +
                "Brandde nog lang en werd pas laat gebluscht.\n" +
                "Zij sliep op 't rustig strand; even gerust\n" +
                "LAg ze als een der schelpen, er bewoog\n" +
                "Niets dan het ondiep water, dat soms hoog\n" +
                "Tot bij haar opliep, met een flikkering\n" +
                "In een licht rimpeltje, alsof een ring\n" +
                "Van geroest goud daar lag, en daarom heen\n" +
                "Het water speelde met den edelsteen;\n" +
                "Zij lag drinkend den slaap, zonder gerucht\n" +
                "Blies zij haar adem in de koele lucht. \n" +
                "En toen begon daar op het wijd tooneel\n" +
                "Der zee, als een oud drama waarin veel\n" +
                "Geroep van moord is, en de lucht van bloed\n" +
                "Hangt in de zaal - de scène is leeg: er woedt\n" +
                "Een dolle storm om 't hooge huis, er vallen\n" +
                "Schoorsteenen en de wachten op de wallen\n" +
                "Hooren geluid van vijanden in 't veld.\n" +
                "De regen huilt en gudst, wind giert, daar snelt\n" +
                "Een moordenaar het huis uit en men weet\n" +
                "Dat daar een lijk ligt: donder rolt en wreed\n" +
                "Rijt over het tooneel de maan een streep. \n" +
                "De diepte leek te kermen van wie scheep\n" +
                "Eens gingen uit dit land op winst en buit,\n" +
                "En die ook keerden, zilver en stapels fruit\n" +
                "Van de Antillen voerend in de prijzen\n" +
                "Op sleeptouw, visschers zagen 't bootsvolk wijzen\n" +
                "Naar torens op de kust wanneer ze langs\n" +
                "Hun boorden varend, den oranje glans\n" +
                "Van appels en citroenen zagen en de kleur\n" +
                "Van goud en zilver, en den zoeten geur\n" +
                "Roken, die uit de open poorten sloeg.\n" +
                "Maar als de nacht kwam en haar wolken droeg,\n" +
                "De zware kussens die haar leger zijn,\n" +
                "Waarin ze lui slaapt - dan zag ze de lijn\n" +
                "Breken en 't stranden van het rijke schip.\n" +
                "Ruw klonk het lachen van haar donkre lip.-\n" +
                "Die leken nu te kermen: tusschen goud\n" +
                "Lang gelaten onder water, oud,\n" +
                "Doodsbleek en doodzwart, van hun lippen vlood\n" +
                "Een flauw geroep als van mannen in nood.\n" +
                "En wiegd' in 't water. Dat was schrikkelijk.\n" +
                "Maar Mei was doof van slapen, liet geen blik\n" +
                "Van hare oogen glippen, was\n" +
                "Een nachtelijke bloem in veel zwaar gras:\n" +
                "Zij lag drinkend den slaap, zonder gerucht\n" +
                "Blies ze haar adem in de koele lucht. \n" +
                "Lang klom dat akelig gehuil alleen\n" +
                "Uit zee, het leek het druppelend geween\n" +
                "Dat in de bosschen herfst maakt, en de wind\n" +
                "Een schouw door in de kamer, waar een kind\n" +
                "Probeert te slapen. Maar het voelt geween\n" +
                "Ook in zichzelf en slaapt niet, zo alleen\n" +
                "Liep dat geluid de zee rond, nu eens hoog,\n" +
                "Hoog in het donker, waar de wind bewoog\n" +
                "Angstig de wolkzoomen, en dan heel laag\n" +
                "Waar tusschen dommelende golven traag\n" +
                "Walvisschen zwommen op hun logge romp.\n" +
                "Dan klonk het als geroep van een roerdomp\n" +
                "Te middernacht, die schreeuwt uit het moeras,\n" +
                "Zoodat de reiziger in het boschgras\n" +
                "Dat langs den grijzen straatweg groeit, blijft staan,\n" +
                "Onder de bladerschaduw; in de maan\n" +
                "Gaat hij dan verder, vol verwondering. \n" +
                "Wat is er in de verte schemering?\n" +
                "Bevangt de lucht ontroering? Komt er thuis\n" +
                "Een rij van visschers, wat is dat gedruisch\n" +
                "Als van een bui zeeschuim? Ik hoor gekras\n" +
                "Als van een vogel als er storrem was\n" +
                "En er een lijk ligt op de grijze kust.\n" +
                "Wat is er, wat verstoort de stille rust\n" +
                "Van Mei, die de oogen opent en daar zit\n" +
                "Staroogend, als een kranke vrouw in 't wit?\n" +
                "Of zijn het ook haar wonderlijke droomen\n" +
                "Die daar in optocht langs den zeezoom komen,\n" +
                "De witte golven lekken hunnen voet.\n" +
                "Het oog van Mei gaat glanzend hun temoet,\n" +
                "Wat is het dat die donkre mannen dragen\n" +
                "In monnikskap en pij, hoor, hoor, ze klagen\n" +
                "Als om een doode; die ligt op de baar.\n" +
                "Zij is nog jong en in het blonde haar\n" +
                "Dat hangt, liggen de bloemen van April.\n" +
                "Wee, wee, het is haar zuster, zie, ze wil\n" +
                "Al tot haar gaan, kussen de witte hand\n" +
                "Die ligt op witte wade, van het zand\n" +
                "Kàn ze niet opstaan, hoor, hoor, hoe ze schreit.\n" +
                "Daar fladdren kraaien en hun schreeuwen rijt\n" +
                "De lucht aan flarden, en een dof gedruisch\n" +
                "Als van een sneeuwbui om een donker huis,\n" +
                "Zwiert om de voeten die al verder gaan.\n" +
                "Stil, kind, wees stil en zie het niet meer aan.\n" +
                "Daar rijdt de Dood, die bleeke groote man,\n" +
                "Den donkren stoet al na, hij alleen kan\n" +
                "Ons troosten, daar rijdt hij, is nu voorbij,\n" +
                "Stil, stil, wees stil, wat dood is berregt hij. \n" +
                "Zooals de schapen van de heide, laat\n" +
                "Doot 't groene avondlicht gaan, dat wie staat\n" +
                "Op een bemosten heuvel, ze ziet gaan\n" +
                "Van den heizoom en in een donkren laan,\n" +
                "Den hoek om - zoo verliet die donkre troep\n" +
                "Die zij nazag zoolang nog het geroep\n" +
                "Van vogels opging, het gerekte strand.\n" +
                "Toen zonk de angst van haar gelaat, haar hand\n" +
                "Lag droomend naast haar, klein en blank en loom\n" +
                "En veilig en sliep mèt haar en geen droom\n" +
                "Kwam meer, het was alsof de Dood\n" +
                "Die meenam toen hij in het Noorden vlood. \n" +
                "Weet iemand wat op aard het schoonste is,\n" +
                "Het allerschoonste? welks gelijkenis\n" +
                "Hij ziet in alles wat hem vreugde geeft?\n" +
                "Waarom hij lief heeft wat rondom hem leeft?\n" +
                "Waarom diè rijkdom en diè een vrouw\n" +
                "En één zichzelf, hoewel ze allen nauw\n" +
                "Weten dat ze iets zoeken dan een woord\n" +
                "Alleen? Weet iemand dit? Wel hoort.\n" +
                "Het is waarom het kuiken zoekt de hen,\n" +
                "Het kind de moederborst, waarom ik ben\n" +
                "Bang voor den winter en den herfst, den nacht\n" +
                "Van 't jaar - waarom een jong kind niet de pracht\n" +
                "Der sterren liefheeft, wel een vlam en vuur\n" +
                "Van een wit kaarsje - met een klaar getuur\n" +
                "Ligt hij op 't kussen wakker, lang en met\n" +
                "Zijn oogen volgt hij 't waaiend flikkren, het\n" +
                "Vlammetje brandt nog in zijn droomen voort.\n" +
                "Het is waarom zang en muziek bekoort,\n" +
                "Maar marmer mij verschrikt en witte kleur,\n" +
                "Ik roode rozen liefheb en den geur\n" +
                "Van blinkend fruit en verf van donzig ooft.\n" +
                "Het is waarom een meisje een man belooft\n" +
                "Te stoven in haar armen en verlangt\n" +
                "Naar 't warme mooie huw'lijksuur, ze dankt\n" +
                "Hem voor zijn liefde, of hij anders kon.\n" +
                "Het is vuur, de warmte, 't is de zon. \n" +
                "De wolken werden van een licht karmijn,\n" +
                "Uit grauw van plassen welde gloor, en wijn\n" +
                "Verwolkte hier en daar tusschen de golven,\n" +
                "Als Bengaalsch licht, het werd dieper bedolven\n" +
                "Door ruige schuimkoppen, maar 't lachte toch:\n" +
                "Zoo lacht in waterkelk wijndroppel nog.\n" +
                "De zee werd aan een oud Grieksch land gelijk\n" +
                "Zooals dat nu is, maar eens was het rijk\n" +
                "Aan beelde' en tempels; nu liggen dooreen\n" +
                "Zuilen en blokken kapiteel: de steen\n" +
                "Verweerde in brokken en werd schaduwig.\n" +
                "Er groeien anjelieren en honig\n" +
                "Zuigen daar bijen, toch lijkt het droevig\n" +
                "Wanneer de zon pas schijnt. - Maar 't werd een dans\n" +
                "Weldra van alle kleuren op de schans\n" +
                "Van wolken, die nog op het Westen lag.\n" +
                "Een wind begon te waaien en een vlag\n" +
                "Leek wel te klapp'ren, of een blanke zwaan\n" +
                "Zijn vlerken uit te slaan stond bij een baan\n" +
                "Van vijverwatere, veeren rak'len los,\n" +
                "En schuim verstoof zooals die vogeldos.\n" +
                "De zon ging aan 't vergulden, spiegelglas\n" +
                "In goudsculpturen dreef in zee, er was\n" +
                "Speling van kleuren en in elken kuil\n" +
                "Ontsproten kleuren, gingen kleuren schuil.\n" +
                "Daar waren 't zeepsopbellen, maar aan 't strand\n" +
                "De kleuren van dat dartel tooverland,\n" +
                "Dat schelpen elkaar maken: violet,\n" +
                "Grijs parelmoer, geele barnsteen, omzet\n" +
                "Met kleine schelpjes als van nat granaat.\n" +
                "Daarvan steeg damp op met een incarnaat\n" +
                "Van al die glanzen tot één witten gloed,\n" +
                "Langs 't heele strand. Maar het werd wonderzoet\n" +
                "Te zien, toen Mei daarin haar armen stak,\n" +
                "Ontwakend, oprijzend, zich op het vlak\n" +
                "Van hare handen steunend dat gekraak\n" +
                "Kwam van de schelpen -- op haar teere kaak,\n" +
                "Vochtig van slapen, schoot een zonstraal schuin,\n" +
                "Dat het bloed beefde, van den rand van 't duin.\n" +
                "Zij keek er langs de zon zelf te gemoet,\n" +
                "Begon te lachen en sprong àp te voet\n" +
                "En schortte 't rimplend kleed zóó dat de knie\n" +
                "Bloot bleef -- toen stond z'en poosde -- wie\n" +
                "Zag in den zomer bij den vollen vliet,\n" +
                "Door 't heete weiland, in het blauwe riet,\n" +
                "Ooit zoo een boschnimf lachen, was er ook\n" +
                "Zingend een leeuwerik vlak bij, al dook\n" +
                "Een voren op of dreef een juffer aan\n" +
                "In 't blauw, al had ze bloemen uit het graan.\n" +
                "Zulk lachen hoorde ik wel eens op een hei,\n" +
                "Laat na een middag als een donkre bij\n" +
                "Vertoornd naar huis raasde onder zijn vracht.\n" +
                "De heuvels werden donker, maar een dracht\n" +
                "Van geel en purper om de westerkim;\n" +
                "Een nimfje gaat langs 't lage hout en slim\n" +
                "Glinstren daar sateroogen, een geschuif\n" +
                "Door dorre bladen, en zijn steile kuif\n" +
                "Zie 'k voor de lucht gaan; dan klinkt stil gekeuvel\n" +
                "En dan genietend lachen om den heuvel.\n" +
                "Zoo als ze lachte zit een vogel lang,\n" +
                "Een nachtegaal, streelend de lucht met zang,\n" +
                "Met open bekje op een stillen tak,\n" +
                "BNoven een boschvijver, het bladerdak\n" +
                "Laat weinig nachtlicht door, er is geluid\n" +
                "Ver in het bosch, maar boven alles uit\n" +
                "Kweelt toch het zwarte vogeltje zijn slag.--\n" +
                "Zoo wolkte en welde van haar mondje lach.\n" +
                "Zoo stond ze lang, toen ijlde ze al voort\n" +
                "Op roode voetjes, wit zand werd verstoord,\n" +
                "In haar blank kleedje en het gouden haar\n" +
                "Daarover heen en met een ruim gebaar\n" +
                "Van arme' en handen als een kind en schel\n" +
                "Een uitroep, rinklend als een arrebel.\n" +
                "Nu op het steile duin, zie waar ze staat,\n" +
                "Tusschen het helm dat waait, om haar gelaat\n" +
                "Wind en haarlokken, en een hooge val\n" +
                "Van stroomgoud achter haar, alsof de hal\n" +
                "Des hemels leeg liep langs vergulden trap,\n" +
                "Onzichtbaar 't blauw van goud, in handgeklap,\n" +
                "Uitwuivend linnen en een geelen gloed.\n" +
                "Hoe eenzaam blijft de zee nu zij het land in spoedt. \n" +
                "En nu haar tooverige tocht begint,\n" +
                "Zoo drijft de maan den hemel in, de wind\n" +
                "Steekt zoo op -- laat nu ieder zien naar haar.\n" +
                "Want wie dit eens zag, heeft het lange jaar\n" +
                "Vreugde genoeg en ook in wintertijd\n" +
                "Ziet hij haar oogen nog. Ze huppelt blijd,\n" +
                "Op maat schom'len haar armen als de ra\n" +
                "Van 't schip in golven. En de wind loopt na,\n" +
                "En zij loopt door het gouden zonlicht, nu\n" +
                "In heete geltschers zand en dan waar 't luw\n" +
                "Is. \n" +
                "Binnen alle duinen waar zij klom,\n" +
                "Heetten haar die valleien wellekom,\n" +
                "En baden of ze bleef; stond niet een rij\n" +
                "Van blauwe en geele bloempjes zij aan zij\n" +
                "Geschaard, zooals menschen in een theater.\n" +
                "Zij zeiden alle hare namen, 't water\n" +
                "Komt daarbij in den mond, de geele nelken\n" +
                "En vroolijke violen die de kelken\n" +
                "Zacht bengelen doen door het grazig mos,\n" +
                "En koude sneeuwklokjes bij kreupelbosch.\n" +
                "Dat te vergeefs; maar eenmaal leek haar doel\n" +
                "Een effen duinvijver, een vogelpoel,\n" +
                "Die 'n zomerdag niets doet dan spiegelen\n" +
                "Het kleone vee dat de lucht afweidt en\n" +
                "Zich samen naar den stal beweegt waar ver\n" +
                "Al zware rind'ren liggen en een ster\n" +
                "Des avonds brandt; zoodra die avond komt,\n" +
                "Dalen daar vogels in, het bijke bromt\n" +
                "LAngs heuvelhelling en de flauwe echo\n" +
                "Der avondzee komt door het duin, en stroo\n" +
                "Wuift neigende. Daar stond ze nu en dronk,\n" +
                "De lippen in 't hol handje, -- 't water wonk\n" +
                "Met de wenkbrauwen waar de druppelk viel,\n" +
                "In lichtgroen gras; nauwsluitend om den hiel\n" +
                "Perste het water op, 't werd stiller weer\n" +
                "En heel stil, toe sloeg ze de oogen neer\n" +
                "En zag zich zelve. En een blijde schrik\n" +
                "Verstelde haar, het werd een oogenblik\n" +
                "Waarin ze niet dacht, vol van zoet gevoel\n" +
                "Van dartelheid en overmoed -- en koel\n" +
                "Lag nog de wel -- schroomend deed ze een stap\n" +
                "En zag haar eigen blozen, voor een lap\n" +
                "Weerspiegelend blauw als een rood robijn\n" +
                "Op hofgewaad. Dat was voor 't oog festijn\n" +
                "Om naar te zien: haar lippen krulden om,\n" +
                "Ze knield' om zich te kussen in den kom.\n" +
                "Maar toen vier lippen raakten en haar oog\n" +
                "Zijn glans vlakbij zag lichten, toen bedroog\n" +
                "Het water haar en vaagde rimpels in\n" +
                "De wangen van 't beeldig kind, haar kin\n" +
                "Ging dobberen in golfjes. Zij bleef stil,\n" +
                "Geuldig wachten tot de breede ril\n" +
                "Aan de oevers uitstierf. Van haar mondje droop\n" +
                "Een kettinkje druppels, waar 't viel daar kroop\n" +
                "Een bloempje uit den grond, een meizoentje.\n" +
                "Zoo zat ze midden in bloemen, en ze\n" +
                "Keek naar hunn witte kroontjes tot de plas\n" +
                "Haar bleed weer stil hield, en het was als las\n" +
                "Ze aandachtig letters van haar schoonheid; zoo\n" +
                "Bewogen hare lippen tot ze bloo,\n" +
                "Of iemand daar was opzag, wien ze kon\n" +
                "Vertellen. Er was niemand dan de zon. \n" +
                "Maar ui den vijver vluchtte een beekje heen,\n" +
                "Water louter juweelig licht, een steen,\n" +
                "Een marm'ren kei in 't beddingzand, laat kwik\n" +
                "Los, zilver, dat fijn schittring geeft waar dik\n" +
                "Riviergras is gewassen. Zwaar geblaard\n" +
                "Staan jonge planten in de oeveraard,\n" +
                "Het zijn de luistraars naar het zacht geschal\n" +
                "Dat 't water maakt. Het springt met zwarten val\n" +
                "En praat en babbelt lager in de schaûw.\n" +
                "Klimpo en varens luisteren, maar nauw\n" +
                "De hooge boomen, die zijn altijd vol\n" +
                "Van zonschijn en van wind en 's avonds dol\n" +
                "Van spreeuwgekwetter. Maar laat in den nacht\n" +
                "Is 't water hoorbaar als de boomuil lacht.\n" +
                "Als een wit vlindertje liep zij daar heen,\n" +
                "Door bonte vlekjes licht, op 't witte been\n" +
                "Bevend schakeerend. En toem klom ze af\n" +
                "Waar het beekwater viel en monding gaf\n" +
                "Tusschen twee weien, die het beide streelt.\n" +
                "Daar staat een wilg, een wachter die zich beeldt,\n" +
                "En kmen grove runderen den stroom\n" +
                "Drinken des avonds, daar valt laat en loom\n" +
                "Het loof af in November, daar licht loomer\n" +
                "In vreemde maanden al de jonge zomer.\n" +
                "Daar stond in 't engste hoekje van de wei,\n" +
                "Tusschen wat elzen en een haag van mei-\n" +
                "Doorn rood geknopt, een bloemkorf opgehoopt\n" +
                "MEt versche bloemen, om den korfrand loopt\n" +
                "Een slinger van seringen, 't lijkt gewicht\n" +
                "Van bloemen, maar heel binnen in half licht\n" +
                "Glimt nog een boterbloem. Mei had gezet\n" +
                "Haar voet in 't weeke zand, en sleepte met\n" +
                "Haar enkels 't klare water door de beek,\n" +
                "Die 't spoor wegwischte; de oppervlakte leek\n" +
                "Om 't voetje pret te hebben, in 't lommer\n" +
                "Bleven spiralen spelen op 't water. \n" +
                "Nauwlijks op 't land, daar zag ze in dien hoek --\n" +
                "Zoo ziet een kindje om de deur, wien koek\n" +
                "Beloofd werd -- bloemen, en een korten weg\n" +
                "Nam zij er heen en liep onder de heg\n" +
                "Dat knopjes schommelden, en gooide dol\n" +
                "Jublend den bloemkorf om. En handen vol\n" +
                "Weer scheppend uit den daus, had ze een dans\n" +
                "Door 't heele weiland; geen klaver had kans\n" +
                "Zijn kluwens niet gesierd te zien, het stoof\n" +
                "Van bloemen om die danste, een boom die 't loof\n" +
                "Bezwaard van regen strooit, geeft zooveel tooi\n" +
                "Niet aan den grond -- het leek ruischend gestrooi\n" +
                "Meer, op den avond van St. Nicolaas\n" +
                "Van gekleurd suikergoed, of als met Paasch\n" +
                "Met bonte eitjes te verbergen gaat.\n" +
                "Zij danste rond en heel de wei had baat,\n" +
                "En ook de beek, want als een springfontein\n" +
                "Die een kolom spuit, maar in drupplen klein\n" +
                "Gemaakt wordt, zoo viel bij haar schouders neer\n" +
                "Een vlucht gebloemte. En telkens wierp ze weer,\n" +
                "De lucht blies ze open. Als een goochelaar\n" +
                "Satijnen ballen gooit, die door elkaar\n" +
                "Omhoog gaan, dat het oog kleurbogen ziet --\n" +
                "Zoo vielen ook veel bloemen in den vliet;\n" +
                "Die nam ze mee en hechtte ze aan den rand\n" +
                "Van landerijen, dat heel Holland brand\n" +
                "Vat van vlammetjes. De schepezeilen\n" +
                "Worden met weidegeur gevuld, en mijlen\n" +
                "Ver wordt de bonte bloesem opgetast\n" +
                "Door wind op ooftboomen. Maar 't is geen last. \n" +
                "Toen legde ze zich moe onder de haag,\n" +
                "Zooals een koejong, een kalfje, dat traag\n" +
                "Zich op z'n weeke pootjes laat, haar kin\n" +
                "Vulde haar handen. En toen viel haar in,\n" +
                "En dacht ze lang hoe nu het mooi Meiwekr\n" +
                "Bezig in stilte was. Zoo wordt een kerk\n" +
                "Gesierd en zuilen die gewelven schoren,\n" +
                "Met beeldjes volgebeiteld. In den toren\n" +
                "Ziet men arbeiders in hun schootsvel staan;\n" +
                "Men schildert ramen, legt den vloer. Wie gaan\n" +
                "Op straat, hooren daar weinig van.-- Zij dacht:\n" +
                "''Zal ik gaan kijken of ik heb gebracht\n" +
                "Den appelboom bloesem, of de oude broeimuur\n" +
                "Den moerbei bloedig maakt, d'oude dorschschuur\n" +
                "De wijnrank al omsluiert. Of zal 'k hier\n" +
                "Blijven met water spelen, en plezier\n" +
                "Met vlinders maken die daar in de poort\n" +
                "Van 't weiland dansen. Of zal ik het soort\n" +
                "Van vlierhout zoeken, waaruit ik een fluit\n" +
                "Boor, om dan door den dorenheg geluid\n" +
                "Te maken in het land hiernaast, dat kalven\n" +
                "Weggaloppeeren: ik kan ook wel malven\n" +
                "Gaan samen zoeken, ook de hazelaar\n" +
                "Is zacht, elzen gezellig met mekaar.''\n" +
                "Zoo dacht ze, maar een vlinder nam de keus\n" +
                "Al dansende, vlak voor haar kleine neus\n" +
                "Knippend en wenkend dat het teekenschrift\n" +
                "Der vlerken moeilijk leesbaar werd, gegrift\n" +
                "Stonden daar runen en een duur geheim\n" +
                "Dat men in Indië weet, het staat in rijm\n" +
                "Op Oostersch roomkleurig tapijt. Heel wel\n" +
                "Wist zij het ook, althans na een kort spel\n" +
                "Van vingers, die toen ook wel vlinders leken,\n" +
                "Had ze 'm in 't handje en haar oogen keken\n" +
                "Met aandacht in het rode kooitje, geel\n" +
                "Zat de gevangene en z'n stuifmeel\n" +
                "Op hare toppen. Zij lag op den rug,\n" +
                "Een knie boven de andere, en vlug\n" +
                "Lazen haar lippen het. Toen lag ze lang\n" +
                "Den hemel aan te zien, niet blij niet bang. \n" +
                "Totdat ze òmging en haar wang 't koraal\n" +
                "Van haren arm deed dalen, en ovaal\n" +
                "Dien maakte van rond als een zuil. Ze zag\n" +
                "Over haar hand die in de schaduw lag,\n" +
                "Twee oogen en het lichaam van een vrouw\n" +
                "Die lag als zij, ook languit op den dauw,\n" +
                "In 't andre weiland in den schijn der zon.\n" +
                "Haar stem was als het ooglicht, die begon\n" +
                "Te klinken en het was als diamant:\n" +
                "''Ik lig hier al zoolang gij aan uw kant\n" +
                "Met bloemen blij zijt, ja lang lag ik al\n" +
                "Hier, toen het grijze ijs dien waterval\n" +
                "Bijna verstremde. Ik heb in winternacht\n" +
                "Menige maal omhoog gegaan, op wacht\n" +
                "Gestaan daar op het duin, wanneer --\n" +
                "Die spotten zelfs bij storm in winterweer --\n" +
                "Ik 't roepen van den Triton had gehoord.\n" +
                "Maar als ik boven was, zag ik het Noord\n" +
                "Verlicht van ppolijs en nog helderblauw\n" +
                "Als bij de winterevening, de kou\n" +
                "Deed mij daar rillen in mijn tranen; dan\n" +
                "Daalde ik weer en lag hier droomend van\n" +
                "Lente en u -- totdat de ochtendrook\n" +
                "Die op de akkers trekt, lichtte en ook\n" +
                "Weer vogels vroeger vlogen. Toen heb ik\n" +
                "Bloemen gezocht; gij hebt ze, eindelijk.''\n" +
                "Dat zei z'en zweeg; terwijl haar buurvrouw vroeg,\n" +
                "En 't was als een schaar vogeltjes, die vroeg\n" +
                "Heenzwieren door een dorpstraat en dan saam\n" +
                "Gaan pikken op de steenen, deur en raam\n" +
                "Zijn nog niet open en er waakt niemand\n" +
                "Dan vogeltjes alleen -- zóó werd dat land\n" +
                "Ook stil met al zijn halmen, aan zijn toom\n" +
                "Knabbelde niet de beek, de wilgeboom\n" +
                "Hield stil zijn witte blaadjes van geraas\n" +
                "En voor zijn hol toefde een bruin duinhaas --\n" +
                "''Hoort ge het mompelen wel van de zee,\n" +
                "Ik hoor 't zoo gaarne, want het doet wel wee,\n" +
                "Is 't niet, een weinig, en mijn zusters staan\n" +
                "Hoog op de zon en hooren het ook aan,\n" +
                "En zijn wat ernstig: hij spreekt zoo alleen\n" +
                "En doet dat altijd, 't lijkt wel soms geween.\n" +
                "Maar ik mocht toch zoo gaarne op de zon\n" +
                "Naar zijn geluid hooren, hij was de bron\n" +
                "Van wat wij wisten dat op aard geschiedt.\n" +
                "Men kan van alles hooren in zijn lied,\n" +
                "Omdat hij wolken kent èn lichte zon;\n" +
                "Zoo hoorde ik namen waaruit ik me spon\n" +
                "De wondre dingen zelf, ik was zoo blij\n" +
                "Toen mijn beurt eindlijk kwam. Nu heb ik blij\n" +
                "Duizende dingen al elks naam genoemd.\n" +
                "Totdat ik hier kwam en uw mooi gebloemt\n" +
                "En u vond. Wie zijt ge? Woont ge alleen,\n" +
                "IS dit uw water, groeiden daar omheen\n" +
                "Al deze bloemekinderen? Ik dacht\n" +
                "Ze hadden allemaal op mij gewacht.''\n" +
                "Zoo zei ze en zweeg, en 't windeke voer laag\n" +
                "Door 't bloemig loover van de meidoornhaag.\n" +
                "En toen het zweeg, sprak uit den zonneschijn --\n" +
                "En 't was als een oud dorrpesklokje fijn,\n" +
                "Als 't zomermiddaguur klept voor den boer --\n" +
                "Die vrouw: ''Mooi meisj', uw stem was als gekoer\n" +
                "Van een houtdoffer die uit roet'gen eik\n" +
                "Om 't wijfje lokt. Gij maakt de ooren rijk\n" +
                "Aan vleiende geluiden; ik zou wel\n" +
                "Zoo willen blijven luistren naar die sche;,\n" +
                "Uw mond: die is gevuld met overvloed\n" +
                "Van honing, meê voor bijen, bloemezoet.\n" +
                "Ik zou wel willen naar dat klein paleis,\n" +
                "Dat kuiltje in uw borst zien, paradijs\n" +
                "Van bloed en schaduw die er speelt, zefier\n" +
                "Die 't weiland inblaast, zal wèl blazen hier.\n" +
                "Maar 'k zal mij liever van u keeren, en\n" +
                "Terwijl ik u vertellen ga wie 'k ben,\n" +
                "Niet naar u zien. Zie hoe dat wolkje bruist\n" +
                "Daar boven ons en uitdampt, de zon huist\n" +
                "AL in het midden van zijn blauwe straat\n" +
                "En lacht achter zijn venster. Hoor, daar baadt\n" +
                "Een jonge mosch zijn veeren in de beek,\n" +
                "Daar verder plast een bont kalf in een kreek,\n" +
                "En achter uit het bosch roept een koekkoek.\n" +
                "Hoe stil is 't overal; het groen dundoek\n" +
                "Dat om de boomen weeft, hangt roerloos, 'k wil\n" +
                "Nu gaan vertellen van mij zelf, wees stil:\n" +
                "Ik ben in 't midden van dit land geboren.\n" +
                "Daar ligt een weiland wijd, daat kunt ge hooren\n" +
                "Den leeuwrik zingen vliegend naar het blauw,\n" +
                "De rundren grazen, lekkend blanken dauw\n" +
                "En lijken als booten op stoom te drijven.\n" +
                "En als de maan verrijst, jaagt witte wijven\n" +
                "De wind de lucht in, nevel dwaalt heel ver\n" +
                "Nog op het weiland, vangend d'avondster.\n" +
                "Daar liggen in de zon de sloten, beide,\n" +
                "De hooge hemel en de klaverweide\n" +
                "ZIjnopen, en een vogel zoekt vergeefs\n" +
                "Een boom er tusschen; daar is veel geschreeuws\n" +
                "Van wilde eenden, want er vaart een stroom.\n" +
                "Op zomermorgens zijgen daar de room\n" +
                "Boerinnen uit de uiters, helder blinken\n" +
                "De kopren hengsels, melkemmers rinkinken,\n" +
                "Oorijzers glimmen met hun gouden schijn.\n" +
                "Daar ligt de zee vlak naast, geen geele lijn\n" +
                "Van zand ligt daar, het weiland maakt een lijst\n" +
                "Vol grasbloemen en biezene, alleen rijst\n" +
                "Een houten vuurbaak uit het water op.\n" +
                "Dat walst er om heen zoodra van den top\n" +
                "'s Nachts licht brandt en een donker zeilend schip\n" +
                "'t riviertje invaart, elfjes met gehip\n" +
                "Wit worden in het schuim om hoogen boeg.\n" +
                "Toen ze mij baarde, want de schoven riet\n" +
                "Die overbogen, zeiden het den vliet,\n" +
                "En die 't de zee en die 't aan 't lichte meer,\n" +
                "Waar op den middag het blank wolkenheir\n" +
                "Statig verzeilt. Zoo hoorden het een visch\n" +
                "En een zeevogel; dien dag was het lis-\n" +
                "Bosch vol geplas en wuivend wit geveert,\n" +
                "Meeuwen en grijze reiger, die weerkeerd'\n" +
                "Des avonds naar zijn boomnest. Op zijn reis,\n" +
                "Zag ik zijn vleugelslag uit het rijs,\n" +
                "Mijn wiegekamer. Nog weet ik het wel.\n" +
                "Mijn moeder was een stroomvrouw en wen hel\n" +
                "De maanschijf hing te prijk, dan zag ik hoe\n" +
                "Zij op mij kwam, een hooge vrouw, en toe\n" +
                "Mijn oogen sloot met een zacht handgestrook.\n" +
                "Die was zoo zacht als wilgbloesem en rook,\n" +
                "Alsof de rozen daar haar morgendrank\n" +
                "Hadden vergoten, heel den nacht was klank\n" +
                "Van citherspel niet van de zee, misschien\n" +
                "Was 't wel mijn vader, 'k heb hem nooit gezien.\n" +
                "Daar groeide ik en leefde als een klein lam\n" +
                "Dat naast zijn moeder huppelt, 's avonds nam\n" +
                "Ze mij dicht bij zich als een wollig schaap,\n" +
                "En hoord' ik haar lang kloppen voor mijn slaap,\n" +
                "Terwijl ik uit mijn warme woning keek\n" +
                "Naar den gezichteinder waar wel een beek\n" +
                "'s Nachts schijnt te stroomen op den onderzoom\n" +
                "Des hemels, donkerblauw; als in een droom\n" +
                "Schijnt hoog gegroeid riet heen en weer te wiegen,\n" +
                "Met schaarse starren barnend als vuurvliegen.\n" +
                "Maar toen er herfst kwam en de ooievaar\n" +
                "Heenvloog, het gras voor 't laatst versch groen was, maar\n" +
                "De lucht vroeg koud en 't water donker werd,\n" +
                "Toen gingen wij ook heen waar in de vert'\n" +
                "De reigers nestten in de hooge bosschen.\n" +
                "Daar heerschte een stil vuur op stammen, rosse\n" +
                "Bladeren fladderden af in 't mos,\n" +
                "'t Getakte kraakt', harsappels drongen los,\n" +
                "Terwijl de wind opflakkerde de vlammen.\n" +
                "Daar liepen wij tusschen de natte stammen,\n" +
                "En zagen hier en daar een witte vrouw\n" +
                "Al dwalen zooals wij; als van herfstkou\n" +
                "Het water in den stroom rilt, dan begint\n" +
                "De groote trek van haar die zomerwind\n" +
                "En zomerzon beminnen. In den nacht\n" +
                "VAren ze heen, al wie den zomer wacht\n" +
                "Hielden bij stroom en vijver. Op de hei\n" +
                "Komen ze samen, daar zijn saters bij\n" +
                "En d'elven met hun koning Oberoon.\n" +
                "Titania is ook daar en haar kroon\n" +
                "Van spinwebdruppen flonkert in de maan\n" +
                "En in haar oog, licht in juweel, een traan.\n" +
                "Zij zegt daar alle nimfen een vaarwel,\n" +
                "En kom hier weder met nieuw waterspel,\n" +
                "Wij allen hebben u zoo lief gehad.\n" +
                "Zij kust mij, lang zag ik op 't heipad\n" +
                "Nog naar haar om, zij zat er in een drom\n" +
                "Van gnomen, op een heuvel, die de trom\n" +
                "Speelden droefgeestig en de sombre luit;\n" +
                "Wij hadden op den weg het bont geluid\n" +
                "Van pansfluit en den rinkeltamboerijn,\n" +
                "Een sater droeg een ton geroofden wijn,\n" +
                "En nimfen door het woud goudschalen vol\n" +
                "Van blauwe trossen, dat de schapewol\n" +
                "Van hare vachten gemorst druifnat dronk.\n" +
                "Mijn moeder riep me, als het woudgeronk\n" +
                "De bergen door dreunde, een rotsravijn\n" +
                "Den wind en dor geblaarte doorliet, pijn\n" +
                "Deed hagel het bloot lijf, den voet steengruis.\n" +
                "Totdat wij waren waar in zijn hoog huis\n" +
                "De zuiderzon woont als een gastvrij heer,\n" +
                "De zoldring laat blauwe tapijten neer,\n" +
                "Geplant staan marmren zuilen aan de wanden;\n" +
                "Rozefestoenen uit de bloemelanden\n" +
                "Schom'len er tusschen met een traag gezwaai,\n" +
                "Hij vult des daags met goud zijn hui, gewaai\n" +
                "Maakt hij op blauwe meeren en gezwier\n" +
                "Op bergen, van pijnen en populier.\n" +
                "Mijn woning was een geeleroze struik,\n" +
                "Een marmren vaas met ooren en een buik\n" +
                "Verschool met mij de rozelaar, een pad\n" +
                "Van goudzand lag daar langs henen naar stad.\n" +
                "Daar kwamen bruine kindren op bezoek,\n" +
                "In d'ooren gouden ringen, purpren doek\n" +
                "Om 't hoofd, en jonge moeders vol van borst,\n" +
                "Een monnik barvoets, beedlaar met een korst\n" +
                "Oud brood en ezels met een rood schabrak,\n" +
                "Bonte soldaten en een doedelzak.\n" +
                "De lucht was heet in 't roosboschje, ik zag\n" +
                "Droomrig die schelle menschen waar ik lag.''\n" +
                "Dat zei z', en Mei zag met haar als een kind,\n" +
                "Dat vliegers hoog ziet staande in den wind,\n" +
                "Van bont papier. Het was juist een verhaal\n" +
                "Voor 'n warmen middag en voor vrouwetaal.\n" +
                "En 't was alsof ze aan haar oude woorden\n" +
                "Bleef denken toen ze nieuwe zei: ''Naar 't Noorden\n" +
                "Keerden wij weer toen jonge bladen kwamen\n" +
                "Aan d'oude boomen; met ons trokken samen\n" +
                "Reisvogeltjes, kanaries en de vink\n" +
                "Die hier ook woont: daar hoort ge zijn getink.''\n" +
                "Ze zei 't maar hoorde 't zelf ter nauwernood,\n" +
                "Toen nam ze hare handen uit den schoot\n" +
                "En stond op als een blank rund uit de wei.\n" +
                "En zoo sprak ze, maar ag heel ver voorbij\n" +
                "De stille boschkruinen waarin iets wits\n" +
                "Blonk, 't was een loandhuis of een torenspits:\n" +
                "''Voor wat ik u nu nog vertellen moet,\n" +
                "Is deze wei niet noch dit licht: de gloed\n" +
                "Van den meimiddazag zou de tranen droogen,\n" +
                "Die schreien zouden uit uw milde oogen,\n" +
                "Die bijna schreien nu 'k van schreien spreek.\n" +
                "Gij leeft nog lang, misschien vindt gij mijn beek\n" +
                "Wel weer, wanneer een witte wintermist\n" +
                "Nog eens het woud hult en gij u vergist\n" +
                "Hebt in de paden. Loop langs 't water snel,\n" +
                "Gij hoort het in den mist kabblen heel wèl,\n" +
                "En vindt me in nevel; ik maak u zoo bleek\n" +
                "Als 't water is, benee den mist, der beek.'' \n" +
                "Toen werd de lucht en 't zonlicht dof en droef,\n" +
                "Terwijl ze heebging; alleen werd de hoef\n" +
                "In 't weeke gras gehoord van een groot paard,\n" +
                "Dat schrikt' en ronddraafde met lossen staart.\n" +
                "Zij klom tusschen de stammen waar het bruin,\n" +
                "Dood, jarig loof lag; en verdween op 't duin. \n" +
                "Er ligt in elk ding schuilend fijne essence\n" +
                "Van and're dingen. Daardoor wordt een mensch\n" +
                "Als een piano, zóó dood, maar besnaard.\n" +
                "Nu eens rilt één snaar, dan d'âar, naar den aard\n" +
                "Van elk geluid buiten, soms te gelijk\n" +
                "Heel veel. Dat maakt ook een stil arm mensch rijk --\n" +
                "Rijen gevoelens staan bij hem in slaap,\n" +
                "En worden wakker terwijl hij van knaap\n" +
                "Oud man wordt -- Ach, er stonden veel zich dood\n" +
                "Te droomen, tot met hem hun leven vlood\n" +
                "En 't al voorbij was -- 't lijkt in oude sprook\n" +
                "Betooverd slot, dat klimop en huislook\n" +
                "Verborgen; binnen is het stil, de wacht,\n" +
                "Pages en vrouwen zijn in slaap gebracht.\n" +
                "Maar als een prins komt en zijn tooverwoord\n" +
                "Spreekt, dan ontwaakt en wijkt wijduit de poort,\n" +
                "Dan liggen kamers open in zonlicht,\n" +
                "En wandlen daar die menschen opgericht.\n" +
                "Zoo is een menschenziel, waar elk ding kan\n" +
                "Elk ding oproepen uit den doffen ban\n" +
                "Des slaaps, laat het maar luiden als een schel\n" +
                "In zijn voorzaal, of bij de waterwel\n" +
                "Heel ver verschallen uit zijn diepe bosch.\n" +
                "Muziek lokt van een ziel muziek weer los,\n" +
                "Die treedt in wondere gedaanten uit\n" +
                "De zielepoort, zoekend dat lokgeluid. \n" +
                "Zoo traden bij dit kind, terwijl 't verhaal\n" +
                "Verluidde, beelden in de spiegelzaal\n" +
                "Van hare ziel. En onder hen geleek\n" +
                "Zij zelf te loopen, schreiend en sneeuwbleek.\n" +
                "Dat werd betoovering van droefenis,\n" +
                "Zij voelde voor het eerst dat zoet gemis\n" +
                "Van vreugde, en de warme tranenbron\n" +
                "'t Hart overstroomen; dan verdwijnt de zon\n" +
                "En is er spel van nevel in de ziel,\n" +
                "En zacht maanlicht en traag rijdend gewiel\n" +
                "Van lichte golven in een zee van wee.\n" +
                "Zij voeld' het led zacht opzwellen en dee\n" +
                "De oogen dicht, dat het niet breken zou\n" +
                "Voor 't zonlicht als een bloemknop voor den dauw. --\n" +
                "Maar zooals kinren en ook menschen zijn\n" +
                "Hun droefheid is als 't kind dat moeder pijn\n" +
                "Doet als ze 't baart, en dat toch sterft -- zoo ook\n" +
                "Ebde haar leed weer heen. Het leek de rook\n" +
                "Die van de schouw trekt en ook beelden maakt,\n" +
                "Tot waar de wind hun teere hulsels slaakt. \n" +
                "En Zefirus zat nog in 't struikgewas,\n" +
                "Daar liep ze heen, hij oefende zijn bas-\n" +
                "Stem, maar hield in toen hij haar zag,\n" +
                "En stak een hand uit, en zei met een lach:\n" +
                "''Blijf nu niet hier, mijn stem is nog te ruw\n" +
                "Voor ooren van dat parelmoer. Voor u\n" +
                "Wil ik een lied maken zoodra mijn keel\n" +
                "Geheel ontdooid is, nu zal ik dit geel\n" +
                "Bloemklokkenspel doen spelen.'' Zoo zei hij\n" +
                "En schudd' een boompje, toen vielen op Mei\n" +
                "De gouden regens. Zelf nam hij er bij,\n" +
                "Zacht bij den groenen steel, lichte papaver:\n" +
                "Die woei daar nog niet lang tusschen de klaver.\n" +
                "Dat werd een mooi tuiltje van geel en rood,\n" +
                "Hij schikte er pluimgrassen bij en bood\n" +
                "Het aan -- ''voorkransen heb ik nu geen tijd,\n" +
                "Ik moet nu zingen.'' En hij gaapte wijd\n" +
                "En zong -- en zij bleef luidkeels lachend staan.\n" +
                "Toen keek hij boos. Toen is ze heengegaan. \n" +
                "'t Was na den middag. Van het woud ging uit\n" +
                "Een zachte adem dampend zongoud, luid\n" +
                "Zongen de zangvogels en vlogen onder\n" +
                "De boomkruinen; zij zag het van een vonder\n" +
                "Hoe ze heenwiekten over 't beekkristal:\n" +
                "De blauwe gaaien op den groenen wal,\n" +
                "Waartegen 't beekijs plaste en het schuim\n" +
                "Als kleurig druipsteen bleef, in wilde luim\n" +
                "Witzwarte eksters die den dag uitvechten,\n" +
                "En van een eik afzwierend de goudspechten,\n" +
                "En 't kleiner boomvolk: roodborst en de mees\n" +
                "En geele lijster en wie nimmer heesch\n" +
                "Wordt, regenroeper. Alles zat heel stil\n" +
                "Zoodra ze voortrad, oogen keken schril\n" +
                "Van takken waar twee duiven in hun tooi\n" +
                "Op schommelden, er daalde een sprietje hooi.\n" +
                "Zij was als een wit beeldje toen ze ging\n" +
                "Een lage laan in, waar de schemering\n" +
                "Nooit optrekt. 's Morgens smelt er koele damp\n" +
                "Uit dauw, en 's middags brandt de geele lamp\n" +
                "Van 't licht er nevelig. En waar de laan\n" +
                "Stuitte op akkers die in breede baan\n" +
                "Lui lagen langs een helling, zat ze neer.\n" +
                "De hemel was in wolken als een meer\n" +
                "Gevat in rotsen. Die zwollen omhoog\n" +
                "Heel ver in 't Oosten waar de ronde boog\n" +
                "Ligt van den horizon. Een doffer vuur\n" +
                "Als 't rood op Alpen in het avonduur,\n" +
                "Gloeid' op die sneeuwbergen. Bewegingsloos\n" +
                "Zat zij, er zat een vogeltje een poos\n" +
                "Dicht voor haar op een berketak te zwijgen,\n" +
                "Begon opeens te zingen dat ze 't hijgen\n" +
                "Kon zien. Dat orgeld' in de lucht heel luid;\n" +
                "Om 't vogeltje trok gouddamp het bosch uit. \n" +
                "En 't was vijf uur, en een zwaar akkerman\n" +
                "Zag zij in 't zwart staan in den grond, moe van\n" +
                "Zijn dagwerk, leunend op zijn ijz'ren spa.\n" +
                "Hij zag nadenkend een span paarden na\n" +
                "Die 'n ander door de voor dreef, en juist om\n" +
                "Aan 't eind het logge kouter wendde; 'n drom\n" +
                "Van zwarte akkervogels vloog daar op.\n" +
                "Hij vaagde met een roode doek een drop\n" +
                "Van zweet af, mompelde, en werkte weer;\n" +
                "Goudvlokken sneeuwden op zijn werkpak neer. \n" +
                "En heel ver uit het bosch kwam fijn gerucht,\n" +
                "Wielen en stemmen, tripp'lend op de lucht.\n" +
                "Daar was een weg belegd met versch geel grint,\n" +
                "Waarlangs een houthakker zijn dorpje vindt;\n" +
                "Maar achter het geluid kwamen gegaan\n" +
                "Eerst kind'ren met helroode jurkjes aan;\n" +
                "Die droegen tusschen zich bloeme-guirlanden.\n" +
                "En groot're meisjes in het wit, de handen\n" +
                "Gestrengeld, op het gras onder de sparren.\n" +
                "Daarachter op den weg de boerekarren,\n" +
                "Die geel stof sponnen van hun raders op.\n" +
                "Het was een bruiloft; zooals een speelpop,\n" +
                "Met kanten en juweel mooi zat de bruid\n" +
                "Hoog boven 't stuiven en de bloemen uit.\n" +
                "De paarden gingen stapvoets dat tuigschellen\n" +
                "Rinkelden, d'akkerman stond ze te tellen\n" +
                "En zwaaide met zijn pet: toen klom 't gepraat\n" +
                "Tot een hoog juichen op die geele straat.\n" +
                "En toen ze traden uit het groene woud,\n" +
                "Begon de zon in het gewrongen hout\n" +
                "Van karresnijwerk stil te glanzen en\n" +
                "In kop'ren bussen op de raderen.\n" +
                "Zoo schoof de stoet voorbij in dichte trein,\n" +
                "'t Geraas verflauwde, menschen werden klein,\n" +
                "Alleen bloemkleuren glansden zichtbaar, 't wit\n" +
                "Der meisjes, en van paarden 't staal gebit. \n" +
                "En midden op de glooijing lag in 't licht\n" +
                "Een vierkant veld met bloemen, opgericht,\n" +
                "Van bekervorm. Ze maakten met elkaar\n" +
                "Een tafel, klaar voor 't drinkgelag, en waar\n" +
                "De gasten nog niet aanzitten. Vol wijn\n" +
                "Staan al de kelken, dungesteeld en fijn\n" +
                "Geslepen. Tulpen waren 't rood en geel.\n" +
                "Rondom, de hyacinthen forsch van steel,\n" +
                "De sombre bloemen donkerblauw getrost.\n" +
                "Hakhout op zode'omsloot ze, zwaar bemost,\n" +
                "Daar hingen, zooals onder zee in 't bosch\n" +
                "Kooraalboomen, nog doode bladen los,\n" +
                "Verbruind. Daarin scheen nog de zon vuurrood,\n" +
                "Maar in 't gebloemte ging de kleur al dood. \n" +
                "Ook lag een dorpje in dat dal, waar rook\n" +
                "Fijn wemelde om heen van schouwen; ook\n" +
                "Dat zag ze. Glans maakte de zin in blauwe\n" +
                "En roode pannen, uit de straat was 't flauwe\n" +
                "Gerucht hoorbaar der zwarte smederij,\n" +
                "Het ijzer klonk onder de hamers, zij\n" +
                "Hamerden in cadans de spranken vuur.\n" +
                "De straat was leeg, ze zagen aan deur twee buur-\n" +
                "Vrouwtjes staan spreken en een zwarte hond\n" +
                "Rondloopen. Onder groene linde stond\n" +
                "Een oud man in de westerzon te zien,\n" +
                "En achter 'n huis 'n vrouw onkruid te wiên.\n" +
                "Toen ging een schooldeur open en daaruit\n" +
                "Kwamen een stoet van kinderen, geruit\n" +
                "Droegen de meisjes boezelaars, geklos\n" +
                "Van klompen en jongensgeschreeuw brak los,\n" +
                "Twee vochten er, de rest stond er om heen;\n" +
                "Tot meester kwam, toen gingen ze bij tweên\n" +
                "En drieën huiswaarts, broertjes hand in hand.\n" +
                "Zij zag ze hier en daar over het land\n" +
                "En brugjes gaan en langs een lage heg,\n" +
                "En door de dorpsstraat, waar ze plotsling weg\n" +
                "Doken in 't huis, geborgen onder 't dak.\n" +
                "Toen was 't weer stil behalve het klikklak\n" +
                "Van staal en uit een stal dof koegeloei.\n" +
                "Ze kon ook zien hoe in de dorpstraat woei\n" +
                "Tusschen de huize' een boschje van seringen,\n" +
                "Een duivenpaar vertrok op witte zwingen\n" +
                "Het zwerk met vlerkgeklepper in, en zwom\n" +
                "In kringen voor den steilen hemel om. \n" +
                "En toen ze 't al gezien had en de klok\n" +
                "Bonde, de lucht beefd' uren ver, vertrok\n" +
                "Zij ook en liep door weien een lang end,\n" +
                "Waar 't gras vol lag gestrooid van schitterend,\n" +
                "Nat diamantgruis. Met gestraalden baard\n" +
                "Raakte de zon de donkerflonkende aard\n" +
                "En lonkte stil oogglanzend. En een stad\n" +
                "Van roode en witte steenen lag daar, zat\n" +
                "Van zonlicht, dat kwam door granieten poort\n" +
                "De glazen straten binne' en vulde boord\n" +
                "Ze vol. Stond ik niet zelf in avondwind\n" +
                "Vol hooigeur, daar, en zag ik niet dat kind\n" +
                "Buiten de poort onder de beukenboomen?\n" +
                "Ik twijfel...ging ze soms tusschen mijn droomen\n" +
                "Mijn oog voorbij met scheemrend droomespel,\n" +
                "Een slaapschaduw. Neen neen zij was het wel.\n" +
                "Kust' ik u niet vaak vaak, mijn zoete Mei,\n" +
                "Waar 't water aanden weg voorbij stroomt, bij\n" +
                "De blauwe wilgen. O gij waart het wel,\n" +
                "Uw wangen waren zacht als poezevel\n" +
                "En als een schelp sloot uwe mond de mijne;\n" +
                "Mijn bloed de zee daarbij, gij waart mijn kleine\n" +
                "Scheepje dat danste op mijn borst die 't droeg.\n" +
                "Gij leekt zoo vol geheimen en ik vroeg\n" +
                "Ze u en las z'en voelde ze in damp\n" +
                "Van warmte uit u wellen. Welk een lamp\n" +
                "Waart gij mijn handen, ik bij u de bij,\n" +
                "uw zoete honing purend, zoete Mei. \n" +
                "Soms is het als ik 's avonds laat vermoeid\n" +
                "Tracht in te slapen, dat dicht langs mij vloeit\n" +
                "Uw zachte adem en uw stroomend haar.\n" +
                "Uw oogen zijn twee stille vlammen waar\n" +
                "Mijn hoofd ligt op mijn peluw; terwijl ik\n" +
                "Indroom, blijven ze branden liefelijk.\n" +
                "Als toen ge kind waart en om uwen voet\n" +
                "Bloemgeuren walmden en dat licht gebroed\n" +
                "Der wolken m' over 't hoofd voer, als de maan\n" +
                "Ontluikte, Phoebus' bloem te rust gegaan.\n" +
                "Ik zat bij u als bij een kleine wel\n" +
                "Van levend water, waar 't rood elvenspel\n" +
                "Te zien is op den geelen zandgrond en\n" +
                "'t Omhoog komen van bobbels kristallen.\n" +
                "Gij spraakt heel stil en veel en gaaft m'een schat\n" +
                "Geheimen dien ik bergde bij me in stad.\n" +
                "Gij laagt op mijne armen, mooi warm wicht,\n" +
                "In 't blonde haar 't rood welriekend gezicht.\n" +
                "Gij maakte uw lippen als een kersje rond,\n" +
                "Ik at zoovele kussen van uw mond.\n" +
                "Gij vluchttet uit mijn arm maar 'k greep uw hand,\n" +
                "En nam u mede door mijn eigen land. \n" +
                "Het was niet heel ver maar het leek toch lang,\n" +
                "Want het was avond en er kwam gezang\n" +
                "Diep uit een dal waar menschen woonden, vaak\n" +
                "Stonden we stil en luisterden, hun taak\n" +
                "Was af, zij blijde -- er kwam ook wel\n" +
                "Een zwarte vogel door de lucht, heel snel\n" +
                "Verschietend boven de gezonken zon.\n" +
                "En onder 't kreupelhout praatte een bron\n" +
                "Stil voor zich heen, een kind, en toen hij zag\n" +
                "Ons luist'ren, werd hij heel stil, maar een lach\n" +
                "Ritselde nog van verd're wateren.\n" +
                "Ook zagen we een nestje, waar de hen\n" +
                "LAg naast het haantje, de oogen toe en veer\n" +
                "In veer -- maar verder haastten we ons we$ecirc;r. \n" +
                "Totdat we kwamen waar de roode bloei\n" +
                "Van een meidoorn de nacht vervuld'. Er woei\n" +
                "Geen wolkje en de geur hing vol en dicht\n" +
                "Om alle takken. Hier verschool 't gezicht\n" +
                "U duisternis en klommen wij door 't zand\n" +
                "In een diep dal, stilzwijgend, hand aan hand.\n" +
                "En hier was alles wonder, 'k wilde wel\n" +
                "Hier eeuwen zwerven of een zilv'ren bel\n" +
                "Hiervan altijd doen luiden in dit land.\n" +
                "Ik lag daar neêr, zij naast mij. Uit mijn hand\n" +
                "At ze als brood de kussen en ze boog\n" +
                "Zich over me als een moeder en bewoog\n" +
                "Haar oogen niet weer heen terwijl ze zei:\n" +
                "''Mijn mondje regent kussen en jij, jij,\n" +
                "Dorstige jongen, vraagt maar altijd meer\n" +
                "En nog meer druppen uit dit wolkje. Keer\n" +
                "Nu naar uw stad'' -- ik zat en wachtte lang,\n" +
                "Mijn hart bonsde, ik had haar zachte wang\n" +
                "Tegen de mijne -- tot ze fluisterd': ''elke laan\n" +
                "Logt noodend open, laat mij hier nu gaan\n" +
                "En zoeken wat daar geurt en wat daar blinkt;\n" +
                "Hoor hoe de nachtegaal in 't boschje zingt,\n" +
                "Waar al de bloemen staan, de volle kelken,\n" +
                "Een feestdisch in het grad, en over elken\n" +
                "Roemer verschuimt de geele zoete wijn.''\n" +
                "Zij leek dien al te drinken toen ze mijn\n" +
                "Vingers liet varen. 'k Stond een lange poos\n" +
                "Te zien hoe ze in 't boschje meen'ge roos-\n" +
                "Kelk en violen leêg dronk, die daar blauw\n" +
                "En rood gegroeid stonden in 't schemergrauw. \n" +
                "Toen vond ze, 't was op 't hoogste van een kling\n" +
                "Van onbegroeide heiheuvels, die 'n ring\n" +
                "Van wallen en verschansing maakten om\n" +
                "Het heikamp, een ondiepe kuil, een kom\n" +
                "Vol donk're erika, nog onbebloemd.\n" +
                "Ze joeg een bij op die er hong'rig zoemd'\n" +
                "Om honing, stapt' er in, verdwijnend voor\n" +
                "Het roode hemelvuur dat er onder door\n" +
                "Haar armen gloeide. En daar zat ze neer\n" +
                "Met wijde oogen naar de heen en weer\n" +
                "Schomm'lende spruiten van het gras te zien,\n" +
                "Die op den rand geen weerstand dorsten biên\n" +
                "Aan 't luwe avondluchtje dat langs vloog\n" +
                "Op transparante vlerkjes en bewoog\n" +
                "De grasjes en zelfs heel verwonderd was.\n" +
                "Zij zag hoe heel langzaam het blauwe glas\n" +
                "Van 't uitspansel besloeg met duisternis,\n" +
                "En van het rood alleen de heugenis\n" +
                "Bleef leven aan den opgeblazen zoom\n" +
                "Van een rood wolkje -- overdag was 't room\n" +
                "Geweest, nu leek het een violenbed,\n" +
                "Heel alleen liggend maar doortrokken met\n" +
                "Een heerlijk paars licht, in verlaten gaard.\n" +
                "Beneden wortelden in lager aard\n" +
                "Bleeke abeel en berken, wier gefluister\n" +
                "Trild' op de helling. In die boomen huist er\n" +
                "Een wonderlijke schrik voor schemering\n" +
                "En voor elk windje dat hun loover ving.\n" +
                "O er was veel te hooren op dien stond,\n" +
                "Benee stapten kromme kabouters rond\n" +
                "En haalden uit den grond hun oude boeken.\n" +
                "Zij zijn het die des nachts de steenen zoeken\n" +
                "Waar eens druïden spreuk en medicijn\n" +
                "In griffelden tegen de hartepijn\n" +
                "Van jonge helden. Ook nu was de slag\n" +
                "Can 't houweel hoorbaar. Toen in 't west de dag\n" +
                "Geheel dood was, traden de jonge elven\n" +
                "Hun ondergrondsche huizen uit, daar delven\n" +
                "Des daags ze gangen en een donk're mijn.\n" +
                "Mijngraverslampen zetten ze, wier schijn\n" +
                "In 't gras smaragden zalen maakt. Daar zit\n" +
                "Met perkamenten schrift en in geelwit\n" +
                "Gewaad, een elf den nacht uit en studeert\n" +
                "Geneeskunst, wat de jicht heelt, wat regeert\n" +
                "De pols en 't hart. Langs hem gaan met gelach\n" +
                "De elven meisjes dansend, dat een vlag\n" +
                "Hun wapperend gewaad lijtk. 't Wuifde zacht\n" +
                "Bij 't schuiflen om den heuvel in dien nacht. \n" +
                "Maar in de vert' bewoog een flauw geschreeuw\n" +
                "Het zijden luchtgewaad. Uit oude eeuw\n" +
                "Reden er heksen om den horizon.\n" +
                "Ze dragen kleine kinderen: Mei kon\n" +
                "Het martlen hooren en het sneeuwgedruisch\n" +
                "Van sleepgewaden bij haars vaders huis. \n" +
                "Daar kwam de maan en als een admiraal\n" +
                "Voer ze den hemel in, die, zelf in 't staal,\n" +
                "Voor op de plecht staat achter 't gouden schild.\n" +
                "Wit zwellen zeilen op het blauw, het zilt\n" +
                "Ziedt en verteert in sprenkels fijn zeeschuim.\n" +
                "De vloot van sterren week weerzijds en ruim\n" +
                "Lag daar de heerweg -- als wapenheraut\n" +
                "Stoof 't wolkje voort, het droeg de kleuren goud\n" +
                "En wit van zijn meestres, en een bazuin\n" +
                "Leek hij te blazen van roodgoud en bruin. \n" +
                "Wie kan den glans verdragen van die zon,\n" +
                "Wanneer zij naakt, witgloeiend staat? Mei kon\n" +
                "Het niet en droomde in. De maan bezag\n" +
                "Den ganschen nacht haar met een gouden lach. \n" +
                "En in de trillende scheem'ring van het woud\n" +
                "Raakten twaalf kleine ridders telkens 't goud\n" +
                "Dat van de maan door zwarte takken brokkelt,\n" +
                "Eerst zijn het lange snaren, de wind tokkelt\n" +
                "Ze klagelijk, diep in den zomernacht.\n" +
                "Ze dalen zich strekkend op donkre dracht\n" +
                "Van't woud en breken in goudsplinters fijn,\n" +
                "Die raakten nu in 't woud twaalf ridders klein. \n" +
                "Ze droegen witte mantels, wit tricot,\n" +
                "Baretten wit gestruisveerd, stapten zoo,\n" +
                "De maan glom in wapens, den heuvel op,\n" +
                "En schaarden in een kring zich op den top. \n" +
                "Dat zijn de twaalf nachturen die daar staan,\n" +
                "Ze zien zoo teer naar 't kind der ronde maan,\n" +
                "Als 't spel van kindren staan z'in kleinen kring.\n" +
                "Om beurten gaat er een en breekt den ring\n" +
                "En laat de andren wakend achter, hij\n" +
                "Treedt snel het woud en wijde wei voorbij\n" +
                "En klimt de trappen op in ouden toren,\n" +
                "En luidt en slaat zijn uur, zijn makkers hooren,\n" +
                "En zien zijn witten mantel boven 't woud,\n" +
                "Die glanst er als ivoor in 't gul maangoud. \n" +
                "Zoo stonden twaalf ridders dien gulden nacht\n" +
                "En hielden trouw om kleine Mei de wacht.\n" +
                "De maan scheen onbeweeg'lijk, in het rond\n" +
                "Stonden zij stil, hun degens in den grond.";

        tekst2 = "Nu staat er midden in het land een dom\n" +
                "Van zuilen die ìk stapeld' en rondom\n" +
                "Buigen zich popels en de treurcypres.\n" +
                "Het groeit vol leliën, er hangt een tres\n" +
                "Van rozen af aan elke schacht, een rij\n" +
                "Van kinderen zit en zingt zij aan zij,\n" +
                "Roodwangig op de treê met open kelen;\n" +
                "Een orgel hing ik aan den wand te spelen\n" +
                "En binnen zette ik een meisjesbeeld.\n" +
                "Ik was de een'ge priester, al die weeld'\n" +
                "Had ik, ìik woonde er, met mij niemand.\n" +
                "Heel eenzaam was om 't heiligdom het land.\n" +
                "'s Nachts waakte ik in de blauwe tempelschauw\n" +
                "Heel vaak, de tempel waadde in zee van dauw,\n" +
                "De maan bevloog den blauwen hemelbrauw,\n" +
                "Dan gudste er tusschen kolommen dauw\n" +
                "Muziek, zijn 't vogels, zijn het vlinderen,\n" +
                "Klapwiekend muzikale vleugelen?\n" +
                "Of zijn 't fluweele voetjes van mijn Mei,\n" +
                "Die om den tempel treedt dat daar de rij\n" +
                "Doodengezichtjes, bloemige viool\n" +
                "Droomerig knikt en heel de bloemenschool?\n" +
                "Of was 't misschien de lucht die klanken gaf\n" +
                "Door wind en bloemgeschommel en den draf\n" +
                "Van Mei die om den tempel liep te spelen.\n" +
                "Maakt niet de lucht ook zoo uit vogelkelen\n" +
                "Geluid, en drijft uit takken van den boom\n" +
                "De wind niet lichte tonen en de zoom\n" +
                "Van 't kleed, ruischt ze niet 's morgens over 't veld --\n" +
                "Muziek komt uit luchtwemeling geweld. \n" +
                "Hoe kon ik ooit verlaten waar mijn ziel\n" +
                "Duizeld', het licht ver van mijn oogen viel,\n" +
                "Mijn oog en oor werd als de groote hemel\n" +
                "Boven de zee met al haar waterwemel\n" +
                "Van prisma's kleur en van muziekballons\n" +
                "Opstijgend van de baren, en van dons\n" +
                "Geplukt uit golvevleugels? Waar de nacht\n" +
                "De aarde sloot, den hemel openlacht'\n" +
                "Uit sterren wit spruitend met klaar gekijk,\n" +
                "Maar zwijgend, naar het zwarte rijke rijk\n" +
                "Der aarde, waar de bloemen met een zucht\n" +
                "Geboren werden in de donk're lucht,\n" +
                "Het nachtegaalgeklaag luid uitjuikte\n" +
                "Boven de bloem, die pas zich uitluikte?\n" +
                "Ik wist niet dat dit alles was zoo mooi.\n" +
                "Zoo staat ook wel een meisje vol in bloei,\n" +
                "De bruigom loopt om haar en streelt het haar,\n" +
                "Zijn spitse ving'ren door haar gouden haar:\n" +
                "En loopt onwetend heen en zoekt in spel\n" +
                "Matheid en slaap. Dan treedt op zijn drempel\n" +
                "Een bloot beeld: onder 't witte bedgordijn\n" +
                "Glijden er blikken en een woordetrein\n" +
                "Dat's om te weenen, want de mijmering\n" +
                "Over een ding, is teerder dan het ding. \n" +
                "Zoo hoor ik ook terwijl ik speel, heel ver\n" +
                "Van over de velden komen als schemer\n" +
                "Van woorden, als ik slaap droomen rondom:\n" +
                "Daarom, mijn jonge zoete zuster, kom. \n" +
                "Kom nu mijn jonge zoete zuster, kom,\n" +
                "Te lang suisde de zeis al rond ons om,\n" +
                "Kom blonde zuster uit ons zonnig koren.\n" +
                "Want hoor, o hoor, daar ver weg is gebore\n" +
                "Zonoogig kroost, het reit al en draagt om\n" +
                "Muziek en wierook, zoete zuster kom.\n" +
                "Zie ik wil nu zoetklinkende schalmei\n" +
                "Hernemen, geef uw hand en sta me bij,\n" +
                "Leer dansen met mij heen uw roode voeten.\n" +
                "Daar staat de tempel. Rijzen en begroeten\n" +
                "Ons als die kind'ren al? Ze lijken bloemen\n" +
                "Zooals ze wieg'lend geuren, hoor, ze noemen\n" +
                "Mijn naam en d'uwe, blijf nu bij ze staan,\n" +
                "Gij zelf een bloem, en laat mij binnen gaan. \n" +
                "Hoe stil is 't hier. Een blauwe schemer stijgt\n" +
                "Uit 't zuilwoud, zonlicht glijdt, het boomloof nijgt.\n" +
                "Maar nu zal 't orgel spelen en er zal\n" +
                "Eerst muziek drijven, dan een waterval\n" +
                "Daveren doe: zoo staat over de bergen\n" +
                "Amerikaansch bosch, de boomstammen tergen\n" +
                "Elkaar om 't hoogst, de blauwe lucht beoogt\n" +
                "Verbaasd de golven loof om 't jaar verhoogd,\n" +
                "Daar drijft in effen vlak en bed rivier,\n" +
                "En spiegelt rots en boomen, het boschdier\n" +
                "Drinkt van het drijvend nat als die stroomstraat\n" +
                "Begint te glimmen van den dageraad.\n" +
                "Ruischende gaat de stroom door 't riet dat fluit;\n" +
                "Dan breekt en knakt hij om en dondert uit\n" +
                "Boven afgronden, en hij duiklaart om\n" +
                "En staat als tamboers roerende de trom.\n" +
                "Zoo zal dit lied liggen, dwars door het land,\n" +
                "Een dorstig volk zal drinken aan zijn kant.\n" +
                "Mijn ziel vliegt uit en waadt in eenzaamheid\n" +
                "Door een blauw wolkenmeer van vroolijkheid,\n" +
                "En slurpt de blauwe lucht als zoeten wijn,\n" +
                "Aetherm gemengd met eeuw'gen zonneschijn.\n" +
                "Mijn lijf dwaalt zielziek om en roept zijn bruid\n" +
                "Die fladdert eenzaam boven wolken uit,\n" +
                "Dan zingt het dronken dwalend dit hooglied,\n" +
                "Gij allen hoort het -- maar zìja weet het niet. \n" +
                "Schaduw slaapt langs de bergen, het bazalt\n" +
                "IS droevig, en de bleeke bergbeek schalt;\n" +
                "Nachtwolken varen van den hemel heen,\n" +
                "Daar is het stil, op aarde weent alleen\n" +
                "Die ééne berg, de lucht is zwaar en moe.\n" +
                "Rondom staan andre bergen en zien toe.\n" +
                "Mei zit daar, juist ontwaakt, een paarse vlak\n" +
                "Van wijn op 't slappe kleed, een wingerdtak\n" +
                "Naast haar, de lichte blauwe oogen lachen\n" +
                "Als half in slaap. Maar daar spant aan zijn wagen\n" +
                "De zon, als bladerige klimop rijst\n" +
                "Rooskleur.de heemlen langs, starren, verijsd\n" +
                "In 't blauw, versmelten. In haar hart komt in\n" +
                "Der menschen mooiste slaaf, herinnering.\n" +
                "Hoe vaak ze nu al luistrend heeft gestaan\n" +
                "Naar 't eerste vogellied, wanneer de blaan\n" +
                "Schrikachtig opfladdren voor morgenwind,\n" +
                "Zwaluwgevlieg en 't bijgegons begint.\n" +
                "Hoe dan de lucht zoo drok werd, dat zij nauw\n" +
                "Meer ééeen geluid hoorde. Zie nu hoe gauw\n" +
                "Die eerste vogel vliegt, het water druipt\n" +
                "In kleuren van de rots, de druppel sluipt\n" +
                "Langs een gebloemd kruid, met zijn zilverstaart\n" +
                "Slaat een forel de beek die met een vaart\n" +
                "Vervalt, o die is altijd slapeloos.\n" +
                "Hoe trilt haar hand nu en begiet een blos\n" +
                "Haar bleeke wang, de helling van haar borst\n" +
                "Zwelt en spant uit de wa met wijn bemorst?\n" +
                "'t Was gistren in de avond, toen de sterren\n" +
                "Als lichtkronen omhoog hingen, en verre\n" +
                "De laagste stonden, gearmde kandelaars.\n" +
                "Toen zat ze hier ook en hoe donker paars\n" +
                "Was 't woud, hoe stom-stil -- toen begon op eens\n" +
                "Een stem te stijgen als fontein die ééns\n" +
                "In 't jaar maar springt en dan zijn wachtend water\n" +
                "Lichtvroolijk maakt en 't eigen uitgeschater\n" +
                "Geniet; zoo was die stem en zij werd bang\n" +
                "En droef te moe, want het leek toch dat lang\n" +
                "Die stem iets miste -- toch was ze als een schat\n" +
                "Van edelsteenen aan den dag, als wat\n" +
                "Arm man alleen bezit en het bewaart\n" +
                "En 'snachts er heengaat en het graaft uit d'aard'\n" +
                "En weent er op en kust het en begeert\n" +
                "Het fijn te gruizen in zijn vuist; verteert\n" +
                "Van liefdewellust het. Nu was 't als klonk\n" +
                "Er ramm'lend geld, mar dan weer of een schonk\n" +
                "Flonkende wijn uit gouden kan, des nachts,\n" +
                "In een groot bronzen koelvat. Onverwachts\n" +
                "Was 't uit geweest en had alleen de maan\n" +
                "Geschenen. Maar nog lang had ze gestaan\n" +
                "Met drinkende ooren en de beenen stil/\n" +
                "Tot ze de stilte merkte en een gil\n" +
                "Gaf en heel bang werd. Maar toch was allengs\n" +
                "Vreugde gekeerd, geroepen door den wensch\n" +
                "Het weêr te hooren, -- troost de mijmering\n" +
                "Over een ding niet zóó wel als het ding?\n" +
                "Ze had een vaart genomen en was af-\n" +
                "Gesprongen van de rotsen en een staf\n" +
                "Van wingerd had ze zich gebroken; toen,\n" +
                "Van d'avonduren tot den stillen noen\n" +
                "Der nacht, had 't hout gekraakt, de beek geplast\n" +
                "Van hare voeten, en het leek als was 't\n" +
                "Bacchantische Maenade op de paâeen\n" +
                "Van het zwartdorre rotsgebergt'. De maan\n" +
                "Had haar uit schaduw zien opdagen, dan\n" +
                "Was ze gaan zitten in het licht en van\n" +
                "Afmatting hijgend had ze nagedaan\n" +
                "Die stem, maar weenend had ze in doô blaâeen\n" +
                "Het hoofd gebogen, want ze kon 't zoo niet. \n" +
                "Dit denkt ze en terwijl ze denkt, begiet\n" +
                "De zon de aard, der aarde hovenier.\n" +
                "En roode bloempjes met licht kleurvertier\n" +
                "Weerschemerden de stralen, 't held're gras\n" +
                "Golfde als vrouwehaar, het hooge bosch\n" +
                "Begon den wind te wiegen als een wicht\n" +
                "Dat klagend gegaan slapen, d'oogen dicht\n" +
                "Nog, wakker wordt en voortklagt, ritseling\n" +
                "Maakte het weldra blij en bladwuiving.\n" +
                "En roode wolken dreven als zeewier\n" +
                "Heene en weer, bewegelijke schier-\n" +
                "Eilanden van den zon'gen horizon.\n" +
                "De aarde lag te dampen: een gloedbron\n" +
                "Wier ope lippen wellust uitwazen,\n" +
                "Geelige hette. Maar de stroomvazen\n" +
                "Vergoten rijkelijk, Donau en Rijn\n" +
                "Vergieten zoo water en koelen wijn.\n" +
                "En wind blies aan der aarde aangezicht,\n" +
                "De wouden op de bergen opgericht\n" +
                "Trilden, moe stof van porfier en graniet\n" +
                "Vervloog, het gouden schuim van de bergvliet\n" +
                "Vloog mee, maar binnen elk groene dal\n" +
                "Voelden hem noch de bloem noch de beekval. \n" +
                "Zoo werd de hemel vol van windlawaai,\n" +
                "En vogelkelen vol van stemgeaai\n" +
                "Schalden als beken mee, als beesten sprongen\n" +
                "Rivieren uit hun holen en hun longen\n" +
                "En monden gromden. Maar de zonneschijn\n" +
                "Vulde haar oogen, die maakt ooren klein.\n" +
                "Haar oogen werden grooter, en een gloed\n" +
                "Vlamde haar hals en wang, het roode bloed\n" +
                "Ruischte, ze hoorde het ter nauwernoo.\n" +
                "De wind kwam op haar als een liefdeboo\n" +
                "Met zalven en reukwatergeuren, zij\n" +
                "Rook welk den wierook, liet hem toch voorbij.\n" +
                "En om haar hoofd vingen gedachten aan\n" +
                "Te zwermen als een bijzwerm, maar verstaan\n" +
                "Kon ze de een niet door den ander; zóó\n" +
                "Gonsden haar ooren dat het was of flauw\n" +
                "Veel lippen voor haar oor stonden en of\n" +
                "Elk woord haar blozen hoogde zoet en dof.\n" +
                "En 't was alsof die zoete woorden in\n" +
                "Haar voeren en in rij maar zonder zin\n" +
                "Rondgingen zooals scheepjes, op haar bloed,\n" +
                "Haar heele lichaam rond, in overvloed\n" +
                "Van hartewarmte. En ze voelde niet\n" +
                "Of ze van buiten kwamen als een vliet\n" +
                "Die uitstroomt in een meer, of of een bron\n" +
                "Ze uit haar zelve opspoot in de zon.\n" +
                "Maar voor haar oogen lichtte alles fel\n" +
                "En tintelde springend zooals een schel\n" +
                "Van zilver die geluid wordt, en het zwol\n" +
                "Met trane' en nevel hare oogen vol.\n" +
                "En ze viel achterover, van den steen\n" +
                "Vielen de wade en haar haren heen\n" +
                "Lust en verlangen en bevrediging\n" +
                "Speelden en streden in haar onderling.\n" +
                "Zoo lag ze midden op de wereld, 't was\n" +
                "Toch of ze in zichzelf een wereld was. \n" +
                "Zoo lag ze lang, en in haar keerde weer\n" +
                "Kalmte, zooals de zomer na onweer;\n" +
                "Een vrouwehart is als een zomerweide\n" +
                "Waar koeien grazend droomend, tusschenbeide\n" +
                "Grazen ze niet en staan met stillen kop.\n" +
                "Zoo waren haar gedachten, ze zag op\n" +
                "Naar 't blauwe hemelwaas, haar heele hoofd\n" +
                "Droomerig warm en rood als zomerooft.\n" +
                "Alles was rondom stil, de middagzon\n" +
                "Flonkerde, stilte gonsde, een bij spon\n" +
                "Zijn dunne vleugels, en het wit zonlicht\n" +
                "Droogde zijn stralen op het rotsgezicht. \n" +
                "Zooals de wolken na een winterdag\n" +
                "Treurende gaan, hoewel geen luchtgeklag\n" +
                "Gehoord wordt waar het ov'ral stil is -- dan,\n" +
                "Terwijl er sneeuw valt hier en ginder, kan\n" +
                "Ik soms een enk'le wolk blosrood zien worden.\n" +
                "Lachende reist die in tusschen de horden\n" +
                "Huilende wolken -- zoo waren de riffen\n" +
                "Van zonverlichte bergen die in effen\n" +
                "Glooiingen hoog liepen, blauwend en grijs.\n" +
                "Daarop verscheen midden in het sneeuwijs\n" +
                "Van blakend stof en rots, blank-rood lichaam\n" +
                "Van een jong God, zijn voeten liepen saâm\n" +
                "Vooruit om beurten, om zijn hoog hoofd woei\n" +
                "Het bossig haar met zonvonkengesproei.\n" +
                "Er lag om nek en hals een keten waard\n" +
                "Van goud, zijn neus blies adem als een paard.\n" +
                "Hij leek een zon maar rood en lief'lijker\n" +
                "Dan de zon zeld, met rood licht als de ster\n" +
                "Van Mars in den midwinternacht, toch gaf\n" +
                "Hij door zijn eigen licht geen schaduw af.\n" +
                "Hij liep neurieënde, de lucht werd gek\n" +
                "Wanneer hij ademde en met een trek\n" +
                "Zijn longen vulde dat zijn borst opzwol.\n" +
                "Dan blies hij uit en maakte zelfs stof dol\n" +
                "Van tinteling, de heele hemel hing\n" +
                "Te wachten -- tot hij gaande aan te zingen ving: \n" +
                "\n" +
                "\n" +
                "Waar de wind is en eeuwig geruisch\n" +
                "Van het water om Wodans huis,\n" +
                "En de duisternis\n" +
                "Verglinstert het sterrengruis. \n" +
                "Waar laat in den nachtorkaan,\n" +
                "Wasblank in de wassende maan,\n" +
                "De godessenschaar\n" +
                "Om het brandaltaar\n" +
                "Reidanst bij den Oceaan. \n" +
                "Waar onweerende wind zoo waait\n" +
                "Dat het boombosch valt gemaaid,\n" +
                "Waar de donderkoe loeit,\n" +
                "Maar omhoog weer groeit\n" +
                "Het pijnwoud door Wodan gezaaid. \n" +
                "Waar Aurora haar kindeke windt\n" +
                "Straalkrans die den nacht verblindt,\n" +
                "En met tinkeling\n" +
                "En met rinkeling\n" +
                "Het lichtend te loopen begint. \n" +
                "Daar woond' ik eens, wee mij, o mij,\n" +
                "Toen droomde de jonge Idoena bij mij\n" +
                "Met de voetjes bloot\n" +
                "In het rozerood\n" +
                "Van de dunne donzige wolkensprei. \n" +
                "Wie bracht aan Wodan en Freya de schaal,\n" +
                "In goud toon roo wijn, aan het godenmaal\n" +
                "Naar de Wodansrots,\n" +
                "Waar in koningstrots\n" +
                "Zij voorzaten in de zaal? \n" +
                "Wie haalde de manemerrie van stal,\n" +
                "En stapte met haar door de hemelhal,\n" +
                "Dat dat zwanepaaar\n" +
                "In die vogelschaar\n" +
                "Klapwiekend meevlogen overal? \n" +
                "Wie joeg de sombere ruiters voort,\n" +
                "Gedromde wolken, op zonnemoord,\n" +
                "Met hun hagelslag\n" +
                "Als met sabelslag,\n" +
                "Gereden uit het Noord? \n" +
                "Wie bouwd' in d'avond het Westersch paleis\n" +
                "Van kolenvuur glorend door wolkenijs,\n" +
                "Van wat wolkenpuim\n" +
                "En wat parels schuim,\n" +
                "Waar de goden in vlogen na dagereis? \n" +
                "Wie maalde de zon dat het gouden geluk,\n" +
                "Het zonnemeel viel, wie gaf den ruk\n" +
                "Aan het zonnerad\n" +
                "Dat de zee opspatt',\n" +
                "En maalde de morgengolven stuk? \n" +
                "Dat deed Balder, ik,\n" +
                "En geen oogenblik\n" +
                "Zat ik met kommer\n" +
                "In wee en lommer,\n" +
                "Of weende ik.\n" +
                "Terwijl hij ging en zong, zat Mei zeer stil.\n" +
                "Toen bleef hij staan naar haar gekeerd, geril\n" +
                "Liep over hare armen en ze greep\n" +
                "Den gronde weerzijds; haar kleed hing in een sleep\n" +
                "Te trillen op haar voeten en het haar\n" +
                "Hing om haar voorhoofd waar de blauwe aar\n" +
                "Golfde; de oogen vulden haar gezicht\n" +
                "Dat bleek werd, mar licht was van zonnelicht.\n" +
                "En ze werd blind met open oogen, toen\n" +
                "Hij daar zoo roerloos stond en weer begon;\n" +
                "Zijn stem spon als een zilvren web der spin:\n" +
                "Zij zag het tintlen, hij versmolt er in: \n" +
                "\n" +
                "\n" +
                "Ontwaakt zoo als ik eens ontwaakte,\n" +
                "Zoo ben ik nu, het was aan 't strand\n" +
                "Der wijdvergulde zee waar 's avonds blaakte\n" +
                "De hooge zonnetoorts van 't godenland. \n" +
                "Had ik niet zien zwieren,\n" +
                "Als loof van populieren,\n" +
                "Godinnehaar en hande' aan de overkant?\n" +
                "En glommen niet de sterren,\n" +
                "O 't kwam wel ver, zoo verre,\n" +
                "Idoena droeg ze als een hareband? \n" +
                "Zoo was ik ingeslapen,\n" +
                "Rondom weidden mijn schapen,\n" +
                "Ik hoorde hun tanden rukken aan het riet,\n" +
                "Dat groeit in vochte wolken\n" +
                "Op stroom van hemelkolken,\n" +
                "de windbruid zong daarin haar slapelied. \n" +
                "O wee toen ik ontwaakte,\n" +
                "Terwijl Aurora slaakte\n" +
                "De wiegewindsels van het zonnekind,\n" +
                "Toen waren dicht omwonden\n" +
                "Mijn oogen en opbronde\n" +
                "Er uit die blinde wellen schaarsch lichttint. \n" +
                "Toen ben ik uitgevaren\n" +
                "Op ritselende baren,\n" +
                "Van wat ik wist dat was hemellichtzee,\n" +
                "Daar heb ik drijven luistren\n" +
                "Naar 't scheemrig zeeëfluistren,\n" +
                "Mijn tranen stroomden met de silte mee. \n" +
                "En heb ik rondgezworven,\n" +
                "Waar eenzaam ligt bestorven\n" +
                "In 't helle maanlicht grauwe zandwoestijn,\n" +
                "En vingen mijne wangen,\n" +
                "Hoe groot was mijn verlangen,\n" +
                "Het eerste roode van den maneschijn -- \n" +
                "En ben ik opgestegen\n" +
                "Naar bronnen van den regen,\n" +
                "De wolkendauw druopte op mijn oogen af,\n" +
                "En zoog ik wolkenhoning\n" +
                "In Iris' roode woning,\n" +
                "Niets vond ik dat mijn blindheid drinken gaf. \n" +
                "Schemering,\n" +
                "Mijmering,\n" +
                "Wie noemt den naam van wat mij ving?\n" +
                "Tinteling,\n" +
                "Rinkeling,\n" +
                "Hoorde ik toen de poort openging. \n" +
                "Engelewacht\n" +
                "Vroegen mij zacht\n" +
                "Naar mijn naam dien ik òverdacht.\n" +
                "Schemering,\n" +
                "Rinkeling,\n" +
                "Deden verdampen herinnering. \n" +
                "Henen is\n" +
                "heugenis\n" +
                "Van lust en droefheid die ik immer droeg\n" +
                "Over is\n" +
                "Lafenis,\n" +
                "Drank van muziek altijd en nooit genoeg. \n" +
                "Het is zacht aanwuiven\n" +
                "Van blauwgeveerde duiven,\n" +
                "Langs zonnestralen komend uit de lucht --\n" +
                "Het is het dicht toedeinen\n" +
                "Van blauwe baldakijnen,\n" +
                "Gezwollen van een vuurge' zuiderzucht. \n" +
                "Het is teer opgroeien,\n" +
                "Het is het nacht'lijk bloeien\n" +
                "Van een aanminnige maar geheime bloem --\n" +
                "Het is het aad'mend vullen\n" +
                "Van geuren die verhullen\n" +
                "Een groote wereld met een wonderdroom. \n" +
                "Het is het hoog ophemelen\n" +
                "Van nevels waarin wemelen\n" +
                "Mannen en vrouwe' in het zonlicht transparant --\n" +
                "Het is het klaar uitkijken\n" +
                "Naar vormen die niet wijken,\n" +
                "Als bergen hard graniet en diamant. \n" +
                "Het zijn de helle nachten\n" +
                "Met maan en ster als wachten,\n" +
                "Een holle lucht gevuld met maneglans --\n" +
                "Als blazende victorie,\n" +
                "Zoo staat de zon in glorie\n" +
                "Daar bij elk dageraden op den trans. \n" +
                "Het is het wiegelen van korenaren,\n" +
                "Het is het klanken van gitaresnaren,\n" +
                "Het is weefsel en spinsel van muziek --\n" +
                "Het is het trillen van muziekgordijnen,\n" +
                "Het is het aanrollen van tonentreinen,\n" +
                "Het zijn muziekwolken voor windewiek. \n" +
                "Er schuift een achtergrond vol wonderen,\n" +
                "Het is barsten en luid uitdonderen,\n" +
                "Breken en knallen van de zwarte zomernachten,\n" +
                "Het is een avondzee vol golveklokken\n" +
                "ONder de wolken luidende, getrokken\n" +
                "Door de zwemmende donkere zeeëmachten. \n" +
                "O 't zijn de karavanen\n" +
                "Muziek, oaselanen\n" +
                "Opspelend uitkomend in zandwoestijn,\n" +
                "Het is het heneglijen\n" +
                "an mijn muziekgaleien\n" +
                "Op zee met gouden koper in den zonneschijn. \n" +
                "Kom dan, wie ook\n" +
                "Bloemen en wierook\n" +
                "Brengt aan mijne, bleeke, stille, eenzaamheid --\n" +
                "Nu wilk ik sling'ren\n" +
                "Zilveren ringen\n" +
                "Van liedekijnen uit mijn eenzaamheid. \n" +
                "Er is niet één,\n" +
                "Neen neen, niet één\n" +
                "Die zooals ik haar woestenijen kent --\n" +
                "Zij is mijn kluis,\n" +
                "Mijn vaderhuis,\n" +
                "Mijn stad, mijn hemeltent.\n" +
                "Haar knieëeen had ze hoog getrokken, daar\n" +
                "Steunden haar armen op, het blonde haar\n" +
                "Omhulde ze, haar handen dekten toe\n" +
                "Haar wange' en oogen die ook zelf dicht toe\n" +
                "Gesloten waren; 't leek ze was alleen\n" +
                "Heel hoog op in den hemel en diep heen\n" +
                "Was heel de wereld weggezonken en\n" +
                "Al de herinn'ring van een Meileven.\n" +
                "Hoe dicht was alles en hoe tintelde\n" +
                "Het licht; was 't stil, was 't niet? ze wist het niet,\n" +
                "Haar hart en polsen sloegen nog het lied\n" +
                "En alle luchtvonken zongen 't rondom.\n" +
                "Toen zag ze in haar hande' een beeldedrom\n" +
                "Heenflikkeren, alsof in slaapgewaden\n" +
                "Witte gedaanten door lichtvloeden waadden.\n" +
                "Sommige droegen instrumenten, snareeen\n" +
                "Fonkelden tusschen rozevingers, bare\n" +
                "Bazuinen wijdgemond in mannenmond.\n" +
                "Dat was haar vroolijkheid en ze verslond\n" +
                "Haar tranen al, toen haastig voor den winfd\n" +
                "Van haar gedachten, in zijn rozetint\n" +
                "De zanger zelf verscheen en in zijn licht\n" +
                "Allen vervloden van haar aangezicht.\n" +
                "Eerst zong hij en zijn mond leek wel het hol\n" +
                "VAn den winternachthemel, als die vol\n" +
                "Van kostbre starren staat, zijn zangen waren\n" +
                "Als losgelaten starreregen, scharen\n" +
                "Van blanke klanken sprankelde hij uit.\n" +
                "Maar 't werd stiller en 't geluid\n" +
                "Hield op. Toen stond hij rechtop stil voor haar,\n" +
                "Den mond en d'oogen dicht, zonder gebaar.\n" +
                "En haar gedachten bleven eerst als schuwe\n" +
                "Vogelen om hem heen, die in de luwe\n" +
                "Verlichting van zijn lijf niet durfden vliegen.\n" +
                "Maar dapperder begonnen ze te wiegen\n" +
                "Al nader, en haar oogen gingen aan\n" +
                "En af over zijn borst die in een baan\n" +
                "Afliep. Als een kerkbeeld van goud, zoo puur\n" +
                "Vlamde hij in het duister, dat een muur\n" +
                "geleek van zwart gesteente. Zij vergat\n" +
                "Of het wel duister was, zoo bloeide dat\n" +
                "Standbeeld van vlammen, en toch leek het wel\n" +
                "Meer bloeme- dan wreed vuur, alsof zijn vel\n" +
                "Als dichtgeschulpte rozebladen dekte\n" +
                "Een roode vonk, waarvan het schijnsel lekte\n" +
                "De binnenkant der blaren. En ze strekte\n" +
                "De handepalmen voor zich uit, als meeren\n" +
                "Blonken haar oogen en een zacht begeeren\n" +
                "Vulde haar lippen en met teer gestreel\n" +
                "Scheen ze hem aan te raken. -- Het gespeel\n" +
                "Had uit: hij was er niet. Hoog in het geel\n" +
                "Brandde de zon, ze deed de oogen dicht\n" +
                "En vuld' haar handen met haar zacht gezicht. \n" +
                "De zon zonk en de dalen werden donker,\n" +
                "De groote avond waarde om, geflonker\n" +
                "Begon in hemelsteden en de kruinen\n" +
                "Der laat verlichte bergen namen schuine\n" +
                "Zonstralen aan. Zoo zijn 's avonds de straten\n" +
                "Der steden halfdonker in onze straten\n" +
                "Van Holland, maar aan d'Oosterkant\n" +
                "Roomgeel en muurrood en de rame' in brand. \n" +
                "'t Werd nacht. Terwijl de zware aarde zweeg\n" +
                "Mijm'rend, het kind gebogen hoog zat, steeg\n" +
                "Een mollige donzige nevel dommelend\n" +
                "Bleek op als anemonen, schommelend\n" +
                "Staan die ook in diep zeewater. En zij\n" +
                "Werd nat en dampg koud toen die kleedij\n" +
                "Haar overhuifde, en een vochte kap\n" +
                "Van vlokken nevvel 't hoofd verdronk, de lap\n" +
                "Van haar geweven kleed hing langs den steen.\n" +
                "De neveldruppen lagen daar, geween\n" +
                "Der lucht, blankzwart als Kaapsche diamant.\n" +
                "Zij beefd' en weende niet, maar zat aan 't strand\n" +
                "Van eigen leed en zag de golven klimmen.\n" +
                "haar moeder wist het en zat op de kimmen,\n" +
                "Wachtende bij haar wachtvuur, pas ontwaakt,\n" +
                "Voor haar donkerblauw bed en moedernaakt.\n" +
                "Zij stond en zag haar kind, en uit haar oogen\n" +
                "Gingen smeltende stralen en bewogen\n" +
                "Dampen, ze schudd' het blonde geele haar.\n" +
                "De lucht werd nevelig: een witte baar\n" +
                "Van licht verdronk de sterren en uit groen\n" +
                "Van dampen blonk het maankindeke toen.\n" +
                "Zij plaatste hare voeten weinig maal\n" +
                "Zonder geplas diep in den dap. Een schaal\n" +
                "Van zilver schepte ze vol vuur, dat scheen\n" +
                "Haar in 't gelaat, het lichaam was beneêeen\n" +
                "Donker. Zoo kwam ze naar haar kind, heel hoog\n" +
                "Gloeide haar helle aanschijn voor den boog\n" +
                "Des breeden hemels. Als een tijgerin,\n" +
                "Zoo kwam ze daar, die naar een welp zoekt in\n" +
                "Een klippige woestijn. En toen ze vond\n" +
                "Haar zitten, knie en arm gevouwen, stond\n" +
                "Ze naast haar, kolossaal. Maar geen van twee\n" +
                "Zeide nog iets, noch boven noch benee.\n" +
                "Ze dachten aan hetzelfde, als een moeder\n" +
                "Die 't kinderleven leeft en die te goeder\n" +
                "Ure een hulp haar kind'ren is. Zij beide\n" +
                "Dachten dat vreugd nu op was en dat lijden\n" +
                "Nu klaar gemaakt werd. Maar het jonge kind\n" +
                "Genoot toch hiervan ook, jeugd overwint\n" +
                "Legers van pijn en neemt de sterke stad\n" +
                "Der toekomst hopend in. Verwonderd mat\n" +
                "Ze nog de diepte van haar eenzaamheid,\n" +
                "Vond in verwond'ring troost, hoe eind'loos breidd'\n" +
                "Eenzaamheid zich, nu hij niet meer den dag\n" +
                "Vulde..., waar zou hij zijn?...en weder zag\n" +
                "Z'hem voor zich rijzen als van goud zoo zuiver. \n" +
                "Anders haar moeder. Want een zacht gehuiver\n" +
                "Woei over hare leden. Als een plas\n" +
                "Die in de donkre venen rimpelt, was\n" +
                "Haar huid somber en trilde en haar hoofd\n" +
                "Schokte haar lokkenvracht. Leeuwin beroofd\n" +
                "Van haar liefste jong, maakt wanhoop eerst roerloos,\n" +
                "Dan brulde ze 't uit. Zoo stond ze ook een poss\n" +
                "Voor zich te zien, toen kreunde z'. Een onweêr\n" +
                "Dat ver gehoord werd. Als een zwaneveer\n" +
                "Voor een windstoot, zoo stoof Mei op en voor\n" +
                "Zich zag ze donk're voeten, den romp door\n" +
                "De lucht heendonkeren en hemelhoog\n" +
                "'t Felle gezicht, dat nu voorover boog.\n" +
                "Het kwam omlaag en in de schittering\n" +
                "Der moeder blonk het kind. Het licht beving\n" +
                "Haar borst en armen die ze open had.\n" +
                "En moeder zette bukkend het vuurbad\n" +
                "Op een berghelling en het rozeblad,\n" +
                "Haar kind, nam ze toen tot zich, ééeen arm om\n" +
                "Haar ronde knieëeen, ééeen om de kolom,\n" +
                "Den fijnen halszuil, en ze zette zich.\n" +
                "Vurig lichtte de luchter, weelderig\n" +
                "Drukte het kind de lippen in haar borst.\n" +
                "Het leek een zuigeling die niets dan dorst\n" +
                "Heeft en met dichte ooge' uit moeder drinkt.\n" +
                "Zij deed ze ope' em vroeg: ''Moeder, wat blinkt\n" +
                "Daar zoo en doet den nevelschemer zijn\n" +
                "Als rook van brand? O blusch nu al dien schijn\n" +
                "Van licht en laat me u in 't duister kussen.''\n" +
                "Haar moeder blies het vuur uit en van tusschen\n" +
                "De bergen golfde weêr de nevel aan.\n" +
                "Het lekenruiters die op 't slagveld staan\n" +
                "Te wachten op 't commando. Als het komt\n" +
                "Rijden ze voort, hoefslaande, rug gekromd. \n" +
                "En toen ze lang gezwegen hadden in\n" +
                "Geheime kamer van de neveling --\n" +
                "De maan waakte daarin, een regentes\n" +
                "Van Scandinavisch rijk gelijk, prinses\n" +
                "Mei deed haar oogen slapen vol en rijk\n" +
                "Aan zinnebeelden maar te glans en prijk\n" +
                "Stonden de moederoogen -- toen ving aan\n" +
                "De Maan zooals een maanstroom door woudlaan:\n" +
                "''Kindje, wat denkt ge, wat brandt in uw oogen?''\n" +
                "Zij wenteld' in haar armen en dronk togen\n" +
                "Oogenlicht in en school nog dichter aan,\n" +
                "En sprak: ''Ik zie uw hoofd voor starren staan\n" +
                "Moeder en in uw hoofd twee oogen, maar\n" +
                "Sluierende nevel zweeft om, 'k weet niet waar\n" +
                "Ze eigenlijk staan, o het is als een kolk\n" +
                "Vol lauw badwater, zoo als melk die 'k molk\n" +
                "Op vroege morgens, smaakt het in mijn mond.\n" +
                "Toch dost mij, moeder, en de morgenstond,\n" +
                "Geloof ik, is nog ver, van klare stilte,\n" +
                "Baar licht en zuivre zon als zeezilte.\n" +
                "Moeder, doe mind' ik zoo, zou nu voor goed\n" +
                "Mijn hoofd zoo warm en dof zijn en mijn bloed\n" +
                "Zoo dronken omgonzen. O ik ben vol\n" +
                "Van bloed donker als wijnmoer, waar verschool\n" +
                "Zich toch mijn oude zelf, de blanke Mei?\n" +
                "Ik ruik zoo zware geuren en voorbij\n" +
                "Mijn oogen valt een zwaar zwartrood gordijn.\n" +
                "O moeder help mij toch, wat kan dit zijn?''\n" +
                "Zij antwoordd' en het was zooals de wind,\n" +
                "Die 't waaien aanvangt na zonmiddag: ''vind\n" +
                "Ik u zoo weer, mijn blonde dochter, hoe\n" +
                "Gulden en blond waart ge, nu zijt ge moe\n" +
                "En al te warm en rood. Maar wacht, ik zal\n" +
                "U weer versneeuwen en uw lijf een hal\n" +
                "Maken van jeugd en kracht en kalme koelte.''\n" +
                "En bukkend gaf zij haar de borst. 't Gestoelte\n" +
                "Der rots droeg stom dat zware godenpaar,\n" +
                "De Maan en Mei wier overvloedig haar\n" +
                "De moederbuik bewolkte. In den nevel\n" +
                "Zoog zij haast sluimerend; als door een hevel\n" +
                "Uit een vat in een ander, stroomde melk\n" +
                "Uit moeders tepel in de mondekelk.\n" +
                "Zoo vond ze kalmte in verzadiging.\n" +
                "Lang bleef ze liggen wijl de nevel hing\n" +
                "Over den afgrond, en slechts nu en dan\n" +
                "De moeder een zucht uitblies, als een man\n" +
                "Met peinzen bezig. Eindlijk sprak ze zoo:\n" +
                "''Moeder, ik heb u lief, ik wilde o\n" +
                "Zoo gaarne u nu volgen en altijd\n" +
                "Bij u zijn. -- Maar er is nu iets dat scheidt\n" +
                "Ons, u en mij. Ik zou niet altijd naar uw\n" +
                "Roep willen luistren en wanneer de schaduw\n" +
                "Uw rijk belommerde, zou ik daar niet\n" +
                "Meer blijven kunnen. Waar het ver verschiet\n" +
                "Des hemels rood zag, zou ik de eenzaamheid\n" +
                "En licht gaan zoeken. Moeder, hoe verblijd\n" +
                "Maakt het me dat ik weet wat zijn genot\n" +
                "Is, zal ik hem nu daar niet zoeken tot\n" +
                "Ik voor zijn huis sta? op den drempel zal\n" +
                "Ik zijn voetafdruk kussen en den schal\n" +
                "Van zijn stem zal ik ook misschien wel hooren.\n" +
                "Moeder, zijn liedren zijn als zuilen, schoren\n" +
                "Ze niet marmerpaleizen, blindend wit?\n" +
                "Daarin zijn rood verlichte kamers, zit\n" +
                "Hij daar niet aan het eind' en wacht en wacht?\n" +
                "Zie, ik sta op den drempel, zie, hij lacht\n" +
                "En wenkt me, ja wel wordt hij nu mijn koning.\n" +
                "Hier ben ik, hier ben ik, zal dit mijn woning\n" +
                "Nu voor goed zijn? o, 'k zal haar maken mooi.\n" +
                "Zij is al mooi, zie ze hangt vol van tooi,\n" +
                "Zomers gebloemte hangt, winters kristal,\n" +
                "Met ijs behangen en met rood koraal\n" +
                "De wanden, o ik zelf begraaf me in rozen.''\n" +
                "Zij hield verschrikt in en bij tusschenpoozen\n" +
                "Lachte ze nog wat na, haar moeder niet.\n" +
                "Die sprak en 't was als wind door rusch en riet:\n" +
                "''De watervallen en de zilvren stroomen\n" +
                "Verlaten ook de bergen, en de boomen\n" +
                "Verliezen ieder jaar hun lieve loof.\n" +
                "Mijn kindren waren eens me als een schoof\n" +
                "Van aren, nu zijn er al zooveel heen.\n" +
                "Waar zijn ze? ik weet het niet, hun gladde leêeen\n" +
                "Dansen al lang niet meer op mijne aarde.\n" +
                "Die heeft u ook zoo gaarne en bewaarde\n" +
                "U schatten, veelkleurig, duizenderlei.\n" +
                "Gij wilt ze niet? nu, ga dan ver van mij.'' \n" +
                "Zoo als een schip in zee, zoo stak ze af,\n" +
                "En als een luchtbal daalde ze, ze gaf\n" +
                "Geen schijnsel meer, liep over d'aard in schauw.\n" +
                "Tot dat ze bij een meer kwam dat heel flauw\n" +
                "Lag op te golven in de duisternis.\n" +
                "Daar stond ze en weende uitkijkend, een nis\n" +
                "Zoo leek dezwarte lucht boven het water.\n" +
                "Een populier stond naast haar, klein, een hater\n" +
                "Van stilte, die nu ook zacht ratelde.\n" +
                "Haar tranen ruischten, blade zwatelden. \n" +
                "En ze leek dood. Toen trad Mei zachtkens na\n" +
                "Op meisjesvoeten, 't was als zoete vla\n" +
                "Zoo vleiend wat ze zei: ''O wees niet boos\n" +
                "Moeder, ik bid u, want al wat ik koos\n" +
                "Uit wat gij geven wilt, het zou mij zoo,\n" +
                "Zoo ongelukkig maken sinds een boo\n" +
                "Van zoo veel pracht en teêrheid tot mij sprak.\n" +
                "Gij weet en hoorde 't niet, ik zou als slak\n" +
                "Op ééeen boom kruipen, nu 'k op vleugelen\n" +
                "Een wereld daags kan zien en in en ren\n" +
                "Den top bereik der gouden pyramide,\n" +
                "Der groote wereld, waar de dampen zieden\n" +
                "Van 't heetste kokende geluk, waar ik\n" +
                "Hem weerzien zal, al was 't een oogenblik.\n" +
                "Ook gij zocht blauwe grotten met uw licht,\n" +
                "Bracht één er heen en hield uw straal gericht\n" +
                "Zóó dat hij sluimren kon, door 't bladerscherm\n" +
                "Zaagt gij toch schemeren zijn hals en arm.\n" +
                "Moeder, denk aan uw jeugd, toen voor de zon\n" +
                "Ge u zelve schuil hield en Endymion.''\n" +
                "Zij bukte en hief haar kind langzaam omhoog\n" +
                "En zag haar aan, haar kussend, en bewoog\n" +
                "Langen tijd niets, toen zette ze haar neer,\n" +
                "En Mei liep heen, een kind, dicht aan het meer\n" +
                "Stond nog de Moeder en bleef staan, een boom.\n" +
                "Nevel en wind vloot om haar en de zoom\n" +
                "Van 't donker land ontving soms overstroom\n" +
                "Van troebel water, als een man een droom. \n" +
                "Niemand zag mollige Mei nu meer dien nacht,\n" +
                "Luimige sater niet noch het geslacht\n" +
                "Der Faunen die op de heuv'len spelen gaan.\n" +
                "Ook niet de elven die in hun lange gewaan\n" +
                "Achter elkander als een karavaan\n" +
                "Wandelen door de msit om te beraan\n" +
                "In groote vergadering, wat er is te doen\n" +
                "Den volgenden morgen tot den heeten noen,\n" +
                "Als elvekindren alle te slapen gaan\n" +
                "In de lelieëbladen op de waterbaan.\n" +
                "De blinkende sterren keken wel nieuwsgierig,\n" +
                "En heuchelijk door 't bosch, maar dat was al.\n" +
                "Niemand wist waar ze was, geen berg, geen dal. \n" +
                "Maar toen de zon ontbloeide, d'uchtendwinden\n" +
                "De bladerwouden zaligden -- een hinde\n" +
                "Gelijkend draafde ze uit een koel woud.\n" +
                "naakt, met schuimdroppen van een val; badkoud\n" +
                "Daverde achter haar een cataract.\n" +
                "Daar hield ze stand, waar 't boombosch in de vlakt'\n" +
                "Als stadsmuur opstaat rond de rotsen om.\n" +
                "Daar stond ze en ze stond er als een bloem,\n" +
                "Als bloemegeuren waren hare woorden:\n" +
                "''Vader, uw rijzenis vervult de boorden\n" +
                "Des hemels met uw licht, gij laat wel schijnen\n" +
                "De donkere nachtwolken als rijke mijnen,\n" +
                "Gouden en zilveren, o vader, reine\n" +
                "Welwellust, bronwel, uit wien de fonteinen\n" +
                "Van alle licht vervlieten, geef ook mij.\n" +
                "Ik berg het in mijn oog, dat fonkelt blij\n" +
                "Om uw verborgen licht, mijn blonde haar\n" +
                "Groeit er van op zooals het koren waar\n" +
                "Het gouden zaad viel en de zomerregen.\n" +
                "Geef, geef het mij, nu ik de nieuwe wegen\n" +
                "Berreizen ga -- ook Moeder gaf mij melk.''\n" +
                "Hij hoorde het, licht stroomde, en door elk'\n" +
                "Opening drong het in haar blanke lijf.\n" +
                "Het licht was zuiver goud, maar als een zeef\n" +
                "Haar blanke huid, het was nog zuiverder\n" +
                "In haar, het sloeg naar buite' als lichtschitter:\n" +
                "Een rozeknop zamelt zóó licht, de roos\n" +
                "Brandt er tot aan haar dood van -- toen een poos\n" +
                "Het licht gebrand had en geheel verteerd\n" +
                "Wat zwaar was in haar, voelde ze als geveert,\n" +
                "Gepluim van vogels om zich, en aan een kind\n" +
                "Van morgenkoelte en van nachtewind,\n" +
                "Dat op een hoogen boomtak boven sliep,\n" +
                "Vroeg ze zoet klagend, 't was als vroeg gepiep\n" +
                "Van vogeltje ntwaakt, nog niet bij stem:\n" +
                "''Roep nu uw vader, wilt ge, weet ge hem?''\n" +
                "Die richtt' het hoofdje hooger op en floot,\n" +
                "Een fijn geluid, en uit het rood,\n" +
                "Het Oost, kwam Morgenwind op grooten vleugel,\n" +
                "Een windpaard draafde naast hem aan een teugel.\n" +
                "Ze zei: ''ik wilde waar de wolken zeilen\n" +
                "Willoos voor wilde wind, daar wilde ik wijlen.''\n" +
                "Ze zei dit lachende, -- hij zag haar aan\n" +
                "Hijgende met z'n paard terwijl de blaan\n" +
                "Schitterden en de paardemanen rilden.\n" +
                "Hij zei: ''Ik was waar bloemevaten spilden\n" +
                "Hun geur, de zon zijn licht, o gij zijt meer\n" +
                "Dan bloeme' en zon, 'k verlaat u nimmer meer.\n" +
                "Mag ik u wiegelen en suizelen\n" +
                "Rondom uw oor waar wolken duizelen?\n" +
                "Ik voer u voort, vrees niet, ik doe geen kwaad.''\n" +
                "Hij lacht', hun oogen glommen, als geblaat\n" +
                "Van een jong schaapje zei ze haren dank:\n" +
                "''Ik dank u wel, maar laat mij mijnen gang\n" +
                "Alleen gaan, blijft gij hier, laat uw adem\n" +
                "Mij streelen, dat moogt ge.'' Zij stild' haar stem.\n" +
                "Hij knikte wat droevig. Maar toen hij zag\n" +
                "Haar lachen, spiegelde hij weer haar lach.\n" +
                "Toen ging hij heen en uit een open plats,\n" +
                "Een plein in 't woud, woei uit zijn vol geblaas;\n" +
                "De teere lucht woei vloeiend met een vaart\n" +
                "Omhoog, hinnekend draafde de windhengst rond op aard. \n" +
                "Als op een sofa, maar die was er niet,\n" +
                "Zoo dreef ze eerst voor door het laag gebied\n" +
                "Der vlinderren -- er zat nog een kapel\n" +
                "Hoog in een boom bij bloemwoning, ''vaarwel',\n" +
                "Vaarwel'' lispelden Meilippen heel zacht.\n" +
                "Toen trad naar binnen hare oogenwacht,\n" +
                "Blanke soldaatjes die diep in haar hoofd\n" +
                "Hun wachthuis hadden, en ze keek verdoofd.\n" +
                "Een oogenblik. Toen werde het koeler en\n" +
                "Ze zag de wolken bij zich: ''ik herken,''\n" +
                "Zoo sprak ze teeder, ''mooie paarden u.''\n" +
                "Het was een heele kudde, maar niet schuw\n" +
                "Steigerden ze of schudden hunne koppen.\n" +
                "Langzaam dreven ze voort, zij met hen, open\n" +
                "Hemelen door, gelijkend op de rook\n" +
                "Die niet de schouw ingaat, maar waar ontlook\n" +
                "De houtvlam, daar ook wijlt en hangen blijft,\n" +
                "Minnend de menschekamer. ''O verdrijft\n" +
                "Mij ook nog niet,'' murmelde Mei nauw hoorbaar.\n" +
                "De wind hoordde het en de luchtverstoorder\n" +
                "Staakte zijn adem, alles stond. Toen scheen\n" +
                "De zon met heeter stralen en trok heen\n" +
                "De wolken al hooger en hooger, zoo\n" +
                "Trekken visschers het net en visschezoo\n" +
                "Naar boven, langzaam gaat het door veel visch.\n" +
                "Sommige wolken zag ze als een vlies\n" +
                "Van zeepsopbellen, daar dreven doorheen\n" +
                "Strepen en cirkels kleur, dieper beneen\n" +
                "Zag ze soms zware zwarte als een golf\n" +
                "Voor storm, heel hoog en ver weg hing een kolf\n" +
                "Vol witte stoom, die draaide om zich om.\n" +
                "De zon scheen vuriger; als uit een kom\n" +
                "Die zomers in de hei staat na plasregen --\n" +
                "Somber schouwen de heuvelen, de wegen\n" +
                "Loopend er in staan onder -- daar slaat iot\n" +
                "De lucht het licht en maakt de plas zijn buit,\n" +
                "Rimpelend wit, en drinkt het water op --\n" +
                "Zoo vrat de zon de heele wolkentroep;\n" +
                "Alleen wat ruige damp bleef over, die\n" +
                "Dwarrelde ver weg in 't verschie. \n" +
                "En hooger dreef ze als de roode vogel,\n" +
                "De Nijlflamingo dien de gouden kogel,\n" +
                "De zon, ook aantrekt, zijn gekromde nek,\n" +
                "Ligt in karmijnen vleugels en gelek\n" +
                "Van goud glijdt langs zijn blank' en roode veeren.\n" +
                "Zoo was haar drijven en haat zachte scheren\n" +
                "Langs strandeloos liquide oppervlak.\n" +
                "En altijd stijgende. Het blauwe dak\n" +
                "Leek zwellende omhoog te gaan, de aard\n" +
                "Lag heel laag omlaag en leek een heete haard\n" +
                "Vol bonte vlammen groen en nevelwit.\n" +
                "Hoe blauw was 't om haar, boven haar, haar rit\n" +
                "Zoo zonder schommelen en eindeloos.\n" +
                "Zij waaierde haar vingers soms, de roos\n" +
                "Bibbert zoo soms haar blaan in stillen tuin.\n" +
                "De dag was nachtstil en de zonnekruin\n" +
                "maakte zijn haren als een gouden tent.\n" +
                "Soms rees ze op en stond dan overend\n" +
                "Lachend tegen de stilte als een klok.\n" +
                "Dan lag ze zich weer neer en droomrig trok\n" +
                "Ze hare knieën als een kind op, sliep\n" +
                "Dan in tot dat een droom haar wakker riep.\n" +
                "Ten laatste lag ze ruggelings, niet meer\n" +
                "Bewoog ze, dacht toen in die atmosfeer,\n" +
                "Dacht verluid: ''Nu wild' ik dat hij kwam\n" +
                "Daar boven en mij heel ver met zich nam.\n" +
                "Zoo heb ik ook wel eens een enkel lam\n" +
                "Zien achterblijven van het schapenheer\n" +
                "Des avonds in het duin, dan keer op keer\n" +
                "Terwijl het graasde, keek het blatend op,\n" +
                "Heimweeënd, mar dan boog het weer den kop.\n" +
                "Zoo wil ik ook tevreden wachten, nader\n" +
                "Kom ik hem toch. Ik dank u.'' En haar vader\n" +
                "Knikte ze toe zoo als een avondbloem\n" +
                "Die 't windeke goênacht knikt. En de roem\n" +
                "Des hemels, 't zonlicht, schudde vroolijk 't haar.\n" +
                "Ze lag denkend en sprekend op de baar\n" +
                "Der lucht nog lang: een vrouw denkt vaak haar wensch\n" +
                "En spreekt hem uit, heenlevend langs de grens\n" +
                "Van werkelijkheid en 't scheemerig gebied\n" +
                "Waar Hoop zingt nachts en daags haar tooverlied.\n" +
                "Slapende droomende dreef ze weer: een boot\n" +
                "Eenzaam in zee, die uit den gladden schoot\n" +
                "Van één golf overklint in anderen --\n" +
                "Vroolijk dansen die naast elkanderen.\n" +
                "Zoo lek de lucht ook in haar zaligheid\n" +
                "Van gladde stilte, waar d'oneindigheid\n" +
                "Des ethers nog wel niet begon, maar in\n" +
                "Uiterste fijnheid aandreef wolkekring.\n" +
                "Die zag ze 's avonds. alles lag diep blauw.\n" +
                "De zon was onder, 't leek een stedebouw\n" +
                "Van vroolijke Mooren in een Spaansche streek.\n" +
                "Koepels zwollen omhoog met lichte streek\n" +
                "Als van penseelen en een minaret\n" +
                "Stond asls een slank meisje. In stille pret\n" +
                "Bogen zich de arcaden voort en voort,\n" +
                "In eindelooze gangen: ongestoord\n" +
                "Hing daar een schemer in verzadiging\n" +
                "Van licht en luchtige bevrediging.\n" +
                "Daar dreef ze heen en door de witte gangen\n" +
                "Dobberde ze, zacht ademend verlangen\n" +
                "Ging van haar uit en vulde het poreus\n" +
                "Wolkmarmer met warmte, wijl zonder keus\n" +
                "Ze voortzeilde. Nu steeg ze langs zaalmuren\n" +
                "Naar 't bevende doorzichtige dak, dan turen\n" +
                "Bleef ze naar buiten voor openstaand raam.\n" +
                "Blank was de wereld waar allen te saam\n" +
                "De scharen vaarden van de hemelingen,\n" +
                "De starrenrij, zoo als ze eens ontvingen\n" +
                "Hun plaats en orde van een grooten God.\n" +
                "Dan daalde ze weer en schommelde tot\n" +
                "haar voeten raakten wonderlijkst mozaiek,\n" +
                "daar vleide ze haar rode lijf: muziek\n" +
                "Leek ze te hooren en die blies haar voort\n" +
                "En weer terug en op -- in zomeroord\n" +
                "Speelt zoo de wind met roosblad afgewaaid.\n" +
                "Toen lokte haar een open zaal, daar laaid'\n" +
                "Langs gladde wand een klaar hemelsblauw vuur,\n" +
                "De vloer weerkaatst' 't, als in morgenuur\n" +
                "Het meervlak den ontwaakten ochtendhemel.\n" +
                "Daarbij zat luchtig op een broozen schemel --\n" +
                "Alles leek damp en schemer -- lichte maagd,\n" +
                "Gemaakt van blozen en lachen, als het daagt\n" +
                "Waar zoo wel eens een wolk voorbij de zon.\n" +
                "Vóór haar een spinnewiel, waarvan ze spon\n" +
                "Honderde draden die als stralen waren\n" +
                "Van water, zooals wat in zilveraren\n" +
                "Springt van de zwarte rots in waterval.\n" +
                "Dat sroomde heen en spartelde uit de hal\n" +
                "De gangen in als honderdmond'ge beek.\n" +
                "En Mei trad in, bleef in de deur, toen keek\n" +
                "De spinster vragend lachend op, haar aan:\n" +
                "Mei vroeg: ''wat spintge en wat zijn die draan?''\n" +
                "Murmelend gaf het meisje haar de woorden:\n" +
                "''Ik ben de wolkespinster uit het Noorden,\n" +
                "Ik spin de fijnste wolken die het hoogst\n" +
                "Drijven en draven, bloesems uit den oogst\n" +
                "Die 't zonlicht over dag maait van de zee.\n" +
                "Het fijnste komt 't hoogste, dat verzamel\n" +
                "Ik in een kluwen, zie hoe den belhamel\n" +
                "Een kudde al gevolgd is uit mijn zaal.\n" +
                "Gij ziet ze ov'ral weiden zonder tal.''\n" +
                "En mèhet woie zich een nevelvenster open\n" +
                "En beiden keken en ze zagen loopen\n" +
                "En klimmen schapewolkjes, wit gevacht,\n" +
                "Zooals in zee de golven schuimgevacht.\n" +
                "sommigen doolden af, leken alleen\n" +
                "Te loopen droomen, kijkend voor zich heen.\n" +
                "De meesten gingen samen in ééeen pAs,\n" +
                "Alsof 't een leger van soldaten was.\n" +
                "En zij sprak van het brandend blauwe vuur:\n" +
                "''Wilt ge hier wachten tot het morgenuur?\n" +
                "Kom dan, en zit hier bij mij en vertel\n" +
                "Op uwe beurt, ik spin, maar hoor toch wel.''\n" +
                "En Mei kwam nader, legde zich languit\n" +
                "Bij 't voetje van de spinster en 't geluid\n" +
                "Begon toen heen te stroomen met 't geruisch\n" +
                "Der neveldraden door die deuresluis:\n" +
                "''Ik heb een zoeten naam, mijn naam is Mei,\n" +
                "Ge kent me wel, denk ik, want niemand bij\n" +
                "Alle de elven en de veldegoden\n" +
                "En waternimfen en de witt' en roode\n" +
                "Winden en al de luchtverhevelingen\n" +
                "Was er of kende Mei wel, alle dingen\n" +
                "Boden ze mij wel aan voor éénen kus.\n" +
                "Maar 't kussen gaf mij hartepijn en dus\n" +
                "Vluchtte ik vaak, maar niemand was dan boos.\n" +
                "Ik dee en elk dee wat ik verkoos.\n" +
                "Nu heb ik maar één een wensch en die zal ook\n" +
                "Wel weldra, denk ik, vrucht dragen, ontlook\n" +
                "Maar ooit wenschbloesem in mij, dadelijk\n" +
                "Hing ook de rijpe vrucht daar rijkelijk.'' \n" +
                "Toen zweeg ze een pooze stil, begon toen weer:\n" +
                "''Er is iemand, ik weet niet waar, 'k begeer\n" +
                "Heftig te weten waar hij is, gij weet\n" +
                "Het wellicht wel.'' De ander zei: ''hoe heet\n" +
                "Hij, is het iemand van de lage aarde?\n" +
                "daar kom ik nooit. Maar is het dat hij waarde\n" +
                "Hier rond, vroeger of later zag ik hem.''\n" +
                "Mei sprak: ''Den morgen en de vogelstem\n" +
                "Ge kent die niet, boven de blanke weide?\n" +
                "'s Avonds in 't eenzaam boschje langs de heide\n" +
                "Den nachtegaal en dan den ganschen dag\n" +
                "Het ratelen der bladen en den lach\n" +
                "Van alle glanzende aardsche wateren?\n" +
                "Ge kent die niet, hoor dan zijn naam en ken\n" +
                "Lente en lachen, mij en mijn Mei-jeugd.\n" +
                "Balder, zoo heet hij, Balder.'' En van vreugd\n" +
                "Schreide ze uit, terwijl zijn naamgeschal\n" +
                "Klaarde den nevel van de hemelhal. \n" +
                "Toen d'andre dit gehoord had, schreide ze.\n" +
                "En toen ze uitgeschreid had, antwoordde\n" +
                "Zij zoo, terwijl hun beider oogen glommen\n" +
                "Van tranen, om hen blauwe vlammen klommen:\n" +
                "''Balder, zijn naam is balsem en als dauw.\n" +
                "De open ooren van een jonge vrouw\n" +
                "Drinken hem in en vullen 't diep lichaam\n" +
                "Met weeld' en 't klanken van zijn rijken naam.\n" +
                "OMdat ze dan het hoofd boordevol heeft\n" +
                "Van dat geluid en in haar oogen beeft,\n" +
                "Achter haar oogen, zijn wild flikk'rend beeld,\n" +
                "Zoekt ze hem ook, ik weet het en verbeeldt\n" +
                "Zich 't vinden al vooruit, o 'k weet het wel.''\n" +
                "En toen schreide ze weer, zooals een wel\n" +
                "Die overloopt en den grond drassig maakt.\n" +
                "'t Getouw stond stil en 't laatste weefsel raakt'\n" +
                "Al uit de deur. Zoo zaten ze heel lang,\n" +
                "Beide droomend, zoo als één gezang\n" +
                "Aan de eene hoop, herinnering aan de aêr\n" +
                "Geeft bij het hooren, wonder-wonderbaar. \n" +
                "Nevel werd rozerood, het blauw verbleekte,\n" +
                "De zon verscheen en gouden stralen weekten\n" +
                "De witte dampen: beide stonden op.\n" +
                "Twee lammeren gelijkend, op een heuveltop\n" +
                "Opstaande na den slaap en traag ontwaken.\n" +
                "Mei aan de hand der ander, door het blaken\n" +
                "Van 't rijke licht langs een smal wandelpad,\n" +
                "Een wolkenzoom, een kustestrand als wat\n" +
                "Langs Holland en de zee ligt, zandig wit.\n" +
                "Totdat ze samen stilstonden en met\n" +
                "De oogen beide naar één zij gekeerd,\n" +
                "De eene sprak ''ziet ge waar het geveert\n" +
                "Van deze wolk in eindelooze zee\n" +
                "Uitsteekt als havenhoofd? Dat is de ree\n" +
                "Van waar ge gaan moet. 'k Laat u nu alleen.''\n" +
                "Toen keerden ze zich tot elkander heen\n" +
                "En kuste de een de ander op den mond.\n" +
                "Toen wendden ze zich van elkander rond,\n" +
                "Wandelden uit elkaar, de eene kon\n" +
                "Haar voeten haast niet houden, d'ander spon. \n" +
                "Daar lag de luchtzee stil te wemelen,\n" +
                "Een zee van atmosfeer, de hemelen\n" +
                "Van ether bleek daarboven, daar stond zij,\n" +
                "Flikkerend ruischte een zeemelodij.\n" +
                "En zittend bleef ze daar een heelen dag\n" +
                "En nacht, terwijl dat ééne beeld gezag\n" +
                "Voerde in haar met vochte' en warmen adem.\n" +
                "Ze was zoo vol van hem zoo als met wadem\n" +
                "Van nevel is een bosch op herrefstdag.\n" +
                "Anders beweegt er niet in en de dag\n" +
                "Kent niet dan mistbeweging, mistgeluid.\n" +
                "Soms weende ze eens even en vlood uit\n" +
                "Haar mond een murmeling, men kan een hoen\n" +
                "Zoo in de struikenschaduw hooren doen.\n" +
                "Ze had niet één gedachte en geen woord\n" +
                "Kan daarom zeggen wat ze dacht, gehoord\n" +
                "Kan niet het teerste worden van een ziel.\n" +
                "Zooals de aarde als er regen viel,\n" +
                "Zomerregen, druppelend met geruisch,\n" +
                "Uren aan uren dat een warm gebruisch\n" +
                "Het heele woud vult onder hooge kroonen\n" +
                "Van zwaar gestamde boomen en de schoone\n" +
                "Bloemen in 't gras vol worden van dien dauw --\n" +
                "Zoo was het innigste dier jonge vrouw\n" +
                "Eindeloos groot en boordevol gevuld\n" +
                "Met schemering van hoop, dat ongeduld\n" +
                "Geen plaats vond waar er volop was bereid\n" +
                "Van weelde ieen die tegenwoordigheid. \n" +
                "Ze wist niet dat ze ergens was, wel waren\n" +
                "Haar oogen open en bewogen baren\n" +
                "Van lichte nevel voor haar, maar ze zag\n" +
                "Ze niet, noch hoe de luistre nacht den dag\n" +
                "Verving, de dag den flikkerenden nacht.\n" +
                "Zij was geheel alleen en hield de wacht\n" +
                "Alleen bij eigen ziel, wat of er ging\n" +
                "Binnen en om en uit dien tooverkring.\n" +
                "Wijl ze zoo mijm'rend bij zichzelve waakte,\n" +
                "Twee jonge goden over zee genaakten\n" +
                "Wedijverend, met flikkerende voeten.\n" +
                "Mei kon ze hooren lachen, 't was als toeten\n" +
                "En stooten op jachthorens teon ze voor\n" +
                "Haar langs gingen omzwierend en een spoor\n" +
                "Van trilling maakten in de zonnestralen.\n" +
                "Zooals twee wielrijders: die doen hun stalen\n" +
                "Raderen wieleren dt licht rondspat,\n" +
                "De cirkels draaien en het witte pad\n" +
                "Glijdt weg: ze loeren op elkanders wielen\n" +
                "En trappen vastberaden, in hun zielen\n" +
                "In nijd en haat, voor 't doel de ééne wint,\n" +
                "Maar de ander haalt weer in en rijdt verblind\n" +
                "Van wanhoop hem voorbij. De laatste trap\n" +
                "Slaakt los menschengeluich en handgeklap --\n" +
                "Zoo snelden ze verder en het zonnelicht\n" +
                "Bedaarde weder. Mei stond opgericht\n" +
                "En keek nieuwsgierig, ademend diep in\n" +
                "Als een ontwaakte en een nieuwen zin\n" +
                "Voelde ze in zich als een zeebries waaien.\n" +
                "Toen vloeg ze op van af de wolkenkade\n" +
                "De ruimte in dwars door het zonnelicht,\n" +
                "Want anders was daar niet, ze hield gericht\n" +
                "Gerep der voeten naar den loop der goden.\n" +
                "Wel gingen die veel sneller, 't waren boden\n" +
                "En loopers in het godenland, maar toch\n" +
                "Zag zij ze lang, verdwenen rook ze nog\n" +
                "Olieëngeur die van hun schouders leekte\n" +
                "En in de zon versmolt in damp en weekte\n" +
                "Zich wijder uit, dat was een geur'ge gang.\n" +
                "En Mei geleek nu eens de waterslang\n" +
                "Die door de sloot zwemt, 't lijf gelijk een staart\n" +
                "Al slingerend, dan nmakreel, met vaart\n" +
                "Doorschiet die 't water in blauw schubbejak.\n" +
                "Dan weer een ekster onder 't balderdak\n" +
                "Van helder woud, zijn vlucht daalt en verrijst,\n" +
                "Hij vliegt in 't blauw en wit en vliegend krijscht. \n" +
                "Totdat ze kwam waar slagorden van vlammen\n" +
                "Branden als in bataille, oranje dammen\n" +
                "Van vuur, als eeuwenoude wouden hoog.\n" +
                "Daar knetterde niets, maar stillekens ontvloog\n" +
                "Telkens een nieuwe vlamvlaag uit de oude:\n" +
                "Vlammen als palmebladen en als gouden\n" +
                "Waaieren in een balzaal langs den wand.\n" +
                "Rijen van vlammen als wanneer in 't land\n" +
                "Een leger vijanden valt en in den nacht\n" +
                "De stille zwarte bergen onverwacht\n" +
                "Bersten van vuren van het groot bivouac.\n" +
                "Zij vloog in 't vuur, dat wijdde als een wak\n" +
                "Zich uit in 't ijs, waar Oostewind op blaast.\n" +
                "Een poos ging ze door vuurprieel, verbaasd\n" +
                "Hoorde ze tongen lispelen en ruischen\n" +
                "Van woorden als van bladen, maar de sluizen\n" +
                "Der vlammen lieten haar toen uit, toen juist\n" +
                "Ze blijvend hooren wou wat of er ruischt. \n" +
                "En verder zwom ze als een groote visch\n" +
                "Die ook stil in de diepe wat'ren is.\n" +
                "Haar oog was diep en koud, verwondering\n" +
                "Waakte beneden in haar, zonderling. \n" +
                "Toen kwam ze bij hemelsche voorhangen\n" +
                "Van zij en zon, zooals de doorgangen\n" +
                "Van zalen der Chineezen zijn: figuren\n" +
                "Er in gesponnen waren vreemde dieren,\n" +
                "Griffioenen, vampyrs, en bloedroode draken\n" +
                "Met kronkeltongen in getande kaken.\n" +
                "Ze zag de pooten bij het openwaaien\n" +
                "Zich traag bewegen, en de zijden baaien\n" +
                "Der sleepgordijnen haar langzame staatsie\n" +
                "Uitzetten en opgolven, en de natie\n" +
                "Der beesten woei mee op, heel eindeloos:\n" +
                "Beweging heel ver weg, geluideloos.\n" +
                "In kleur groen, violet en rozerood\n" +
                "Afwiss'lend zwol het zeil, het leek een vloot\n" +
                "Van stevenende schepen onder zeil. \n" +
                "Die snelde ze voorbij, en tone, terwijl\n" +
                "Ze niets zeer duidelijk zag, want inspanning\n" +
                "Maakte haar oogen blind, het hoofd vol, ving\n" +
                "Rondom haar een muziek aan, minnelijk.\n" +
                "Ze wendd' het hoofd dan hier, dan daar, van schrik\n" +
                "Verblijd, maar zag niet veel, een enk'le bloem,\n" +
                "Een eg'lantier, en soms het opgedoem\n" +
                "Van donk're rozen uit een rozebosch.\n" +
                "'t Werd bloemvoller om haar, maar alles los,\n" +
                "Het week al uit en niets was zeer nabij;\n" +
                "Boven en om haar hing in geur een rij\n" +
                "Lichtende mzuikale bloemen, schal\n" +
                "Van zware wat'ren ver af, overal\n" +
                "Een enkel vogeltje, zingend' heel schel.\n" +
                "Ze streefde moei'lijk voort en voelde knel\n" +
                "En dwang om armen, eensklaps vogelvrij,\n" +
                "Voor haar een beekdooraderde bloemewei.\n" +
                "Een bron stond als een koelvat op te schuimen,\n" +
                "Een beek sprong uit dat bed en door de ruime\n" +
                "Weide dwalende weidde hij zijn golfjes.\n" +
                "Muziek makend zaten er engelenelfjes,\n" +
                "De beenen in het water, aan den oever --\n" +
                "Triangels klankten, snaren gonsden doffer. \n" +
                "Voorbij, voorbij, de wei werd als een hei,\n" +
                "Donkerder grond, en zonlicht's melodij\n" +
                "Onhoorbaarder aldoor, een groote avond\n" +
                "Dommelend opdoemend, met duister lavend\n" +
                "Oogen van Mei die nu een vleermuis leek,\n" +
                "Rondzwermend nachtziek in een schaduwstreek.\n" +
                "Heel langzaam roeide zij nu naar het duister\n" +
                "Dat voor haar lag, het lokte met gefluister\n" +
                "En nam haar in zijn vouwe' en plooien op.\n" +
                "Nieuwe wond'ren, want een geestentroep\n" +
                "Schoof daarin voort, reusachtig, en een kudde\n" +
                "Mammouthen drijvend, dat het duister schudde\n" +
                "Zooals de bergen, als de aarde schokt.\n" +
                "Ze waren zwaar gearmd en zwaar gelokt,\n" +
                "Ademden nevels, zelve nevelig.\n" +
                "Ze trokken rond, niet haastig, drongen zich\n" +
                "Zelve en anderen voort met zwaar gesteun\n" +
                "En soms een roep, terwijl een bosch gedreun\n" +
                "Geleek te geven van vallende eikenboomen.\n" +
                "Een leege, stilte. Toen zag zij aandoomen\n" +
                "Woester wolkende damp, te voorschijn reden\n" +
                "Ruiterscharen vechtende, met de kleeden\n" +
                "Zwaar hangend om de zwarte paardenruggen.\n" +
                "Knodsen vielen, menschen vielen -- en stugge\n" +
                "Krete, en wraakgerochel klom. -- Walkuren\n" +
                "Dreven vechtenden voort en breede gieren\n" +
                "Wolkten nog na. -- Toen werd weêr alles stil\n" +
                "En groeid' een woud op met dof bladgeril. \n" +
                "En door die godendroomen, droomeheg,\n" +
                "Terwijl het lichter werd, zocht ze haar weg;\n" +
                "Ze zag nog in de verte wezens nad'ren\n" +
                "Tusschen de boomen: groote grijze vad'ren\n" +
                "En blonde vrouwen door den witten damp.\n" +
                "Die vluchtte ze en zocht het open kamp,\n" +
                "Dat zag ze door lichtgroene bladeren.\n" +
                "En 't bosch verdween zoo als op raderen\n" +
                "Een trein van wagens op een lange brug;\n" +
                "Daar leek wel alles teokomst en terug\n" +
                "Zag niemand ooit: een nieuwe heerlijkheid\n" +
                "Opende de poorten: had ze haar verbeid? \n" +
                "Een blanke straat daar voor haar, watervlak\n" +
                "Tusschen twee vastelanden, daaruit stak\n" +
                "Aan d'overkant omhoog sneeuwwitte toren,\n" +
                "Gebouwd uit blokken ijs, van uit de voren\n" +
                "Der blokken lekte het ijswater geel.\n" +
                "In elk blok scheen de zon, en van geheel\n" +
                "Den toren daald' en stroomde watergoud;\n" +
                "De toren was hemelhoog opgebouwd\n" +
                "Tot diep in 't blauw, maar lager op kanteelen\n" +
                "Zaten er groote duiven zich te streelen\n" +
                "Met gladde bekken in het glad geveert.\n" +
                "En naakte mannen zaten ongedeerd\n" +
                "Door duizeling, op de klaroen te blazen.\n" +
                "Zoo stond een toren daar water te wazen\n" +
                "En blanke manne- en duivekleur, terwijl\n" +
                "Mei zacht aanvloog, zoo als een sloep met zeil.\n" +
                "Voor die sublime poort van ijzig marmer\n" +
                "Woelwater brak op marmertrappen, warmer\n" +
                "Leek dat te worden van gebruis en licht,\n" +
                "En beider schuim doorzichtig als gedicht\n" +
                "Uit licht en water, tot een fraai geheel\n" +
                "Van lichtgeflikker en watergespeel. \n" +
                "En door dien toren liep een doorgang door,\n" +
                "Daar liep ze door, terwijl hoog van een koor\n" +
                "Bij de gewelven jonge stemmen zongen,\n" +
                "Blanke en roode gezichten zich verdrongen\n" +
                "En overkeken naar den gang van Mei.\n" +
                "Zij lachte wel omhoog maar trad voorbij,\n" +
                "Ze hoorde ze nog fluistren en verhalen;\n" +
                "En toen door lange gang, een gang van zalen,\n" +
                "Vol zalig licht; heel eindeloos omhoog\n" +
                "Gingen de vlakke wanden: regenboog\n" +
                "Van kleuren zeefde het doorzichtig dak.\n" +
                "De vloer lag vol van kleurenlicht, dat brak\n" +
                "Door glaze' en ijzen koepels, eindloos hoog.\n" +
                "En door de muren zag ze, en haar oog\n" +
                "Toog telkens nieuwe zalen in, ze stond\n" +
                "Soms even stil, hoorde zij niet den mond\n" +
                "Van Balder zingen in een verre hal:\n" +
                "Was 't schateren van den lichtwaterval?\n" +
                "Waren de wanden water, licht of ijs?\n" +
                "Hadden de kleuren daar eigen paleis\n" +
                "Gebouwd alleen, of waren het de zangen\n" +
                "Muziek van Balder die in rij en rangen\n" +
                "Hun hallen daar hadden, waar binnen zij\n" +
                "Aten en dronken eigen melodij?\n" +
                "Soms zag ze heel ver in een corridor,\n" +
                "Een wit gewaad verdwijnen, en te loor\n" +
                "Ging dan haar vragend roepen van zijn naam.\n" +
                "Balder, Balder, ruischte langs wand en raam,\n" +
                "En trillend gonsden golven licht het voort.\n" +
                "Eens was een zaal verlicht, zooals het Noord\n" +
                "Is 's winters van het blauwe Noorderlicht;\n" +
                "Daar stond een enkel manbeeld opgericht,\n" +
                "De oogen open, vinger op den mond.\n" +
                "Daar was het heel stil, alleen een vlaag woei rond\n" +
                "Van kouden wind, met pijnboomengejammer.\n" +
                "Aan de overzij zag ze een lichte kamer,\n" +
                "Daar stond een jonger vrouwbeeld opgericht,\n" +
                "Daar was het licht van zuiderzon, 't gezicht\n" +
                "Bloeide van bloed, de voeten stonde' in bloemen.\n" +
                "Een vinger op den mond en winde' als droomen\n" +
                "Vloeiende om haar, zacht vloog 't blonde haar\n" +
                "Omhoog, viel over de ooge' als froomeschaar.\n" +
                "Verder, verder, het voetgetree liep heen\n" +
                "Over de kleuren, 't waren ijs of steen,\n" +
                "Het leken jaspis, parelmoer, saffier,\n" +
                "Moorsch rood graniet, en spiegelend porfier;\n" +
                "Alles was spiegelend, het leek alsof\n" +
                "Daarin gedaanten schemerden, als loof\n" +
                "Van boomen in rivier die langzaam trekt --\n" +
                "Want elk beeld bleef daar leven, eens gewekt.\n" +
                "Het was daar stil, maar door de stilte drong,\n" +
                "Begon te gonzen een geluid, een gong\n" +
                "Wordt zoo gehoord in zwart Indischen nacht.\n" +
                "'t Was zwaar en bang alsof een heel volk lacht.\n" +
                "Het licht verschrikt' er van, verdonkrend even,\n" +
                "Maar lichtte toen weer, en het kleurenzweven\n" +
                "Ging ongestoord van boven naar benee\n" +
                "Weer door en weer naar boven, en ze glee\n" +
                "Ook door die kleuren naar dat gonzen heen.\n" +
                "'t Werd zwaarder, maar er flikkerde doorheen\n" +
                "Als stralen bliksem soms een schaterlachen,\n" +
                "Als geele bliksems wen den donderwagen\n" +
                "Thor trekt met onweersvrachten; maar allengs\n" +
                "Hoorde ze helle klanken of een mensch\n" +
                "Spreekt tot een volk, of boven het gelui\n" +
                "Van 't heele carillon, de zware bui\n" +
                "Van klepelslagen: damiaatjes hoog.\n" +
                "En eindlijk ziet ze waar in koepelboog\n" +
                "Een span van poorten staat met goud getuigd,\n" +
                "Die ziet ze niet maar loop snel aan en buigt\n" +
                "Het hoofd eerst even, hoort en wil heenloopen,\n" +
                "Maar blijft en bevend doet de deuren open. \n" +
                "Stilte. Ook Mei stond stil. Dat was een hal\n" +
                "Schel schaduwloos licht, 't kwam van overal.\n" +
                "Een rij van mannen en een schittering\n" +
                "Van glas en zilver, in een breeden ring\n" +
                "Om lang gestrekte tafel. Dak of wanden\n" +
                "Waren niet zichtbar, bloemen in guirlanden\n" +
                "Omhoog, terzijde, en gesponnen loover\n" +
                "Boven, terzij, met boomenlichtgetoover. \n" +
                "Diep heel ver achter in zat op een rots,\n" +
                "Klein leek die in de verte als een schots\n" +
                "Van ijs in zee, een oud gebaarde man, die\n" +
                "Stond op, bokaal ter hand, en uit verschie\n" +
                "Ziende naar Mei galmde hij deze woorden --\n" +
                "Allen verrezen, stonden langs de boorden\n" +
                "Van het banket, zooals de rijen riet\n" +
                "Golvend en buigend waar de stroom vervliet.\n" +
                "Hij sprak: ''Ik zie een duifje in dit nest\n" +
                "Van doffers, wenscht gij iets, dan waar het best\n" +
                "Gij zocht den oudsten, zwaksten, wijsten, mij.\n" +
                "Wie zijt ge?'' En nadat de mannenrij\n" +
                "Schatering en bokaalklank stil had, zei\n" +
                "En zong ze dit led uit -- het was zooals\n" +
                "Een vrouw zingt in een zaal, uit haren hals\n" +
                "Springen de klanken in de stille lucht,\n" +
                "Benee drinken de hoorders het, geducht\n" +
                "Schallen de wanden. -- Zoo schalde haar sporaan:\n" +
                "''Luistert, luistert mannen, ziet mij aan,\n" +
                "Luister o koning van het eind der zaal.\n" +
                "Klaar is de maan, klaar is de manestraal,\n" +
                "Klaar is het starrehaar, klar is de nacht,\n" +
                "Koud is het manevuur, koude is de winternacht,\n" +
                "Klaar is het manekind, koud als de nacht?''\n" +
                "Sommigen rilden, één zett' aan den mond\n" +
                "Den warmen wijn, mar stilte was in 't rond\"\n" +
                "''Luistert, luistert mannen van dit huis,\n" +
                "Luister, o koning, naar dit woordgebruisch.\n" +
                "Goud is de zon, goud is de zonnepijl,\n" +
                "Goud is het zonschip, goud is het zonnezeil,\n" +
                "Gulden de avond, dulden de havondmond\n" +
                "Waaruit de zon zeilt, vroeg in den morgenstond;\n" +
                "Hel is het zonlicht, helend het zonneheil,\n" +
                "Goud is het zonnekind, hel die de zonne zond.\n" +
                "Ziet ge het zonnekind, gij die hier woont? \n" +
                "Koel is de maan, heet is de zonnestraal,\n" +
                "Samen wonen ze binnen één hemelzaal.\n" +
                "Ik ben het manekind, zooals de mane koud,\n" +
                "Ik ben het zonnekind, heet als het zonnegoud.'' \n" +
                "Toen sloegen sommigen hun bokaal tot gruis,\n" +
                "Allen schreeuwden en het heele huis\n" +
                "Wankelde daverend, -- terwijl Mei ging\n" +
                "Dalend en rijzend buiten om den kring.\n" +
                "En allen keken waar ze lang kwam om,\n" +
                "Sprekende als ze aankwam, vóór haar stom;\n" +
                "Was ze voorbij, dan spraken wel de oude\n" +
                "Goden bewonderend, maar wie de gouden\n" +
                "Haren nog hadden, keken haar na, dan\n" +
                "Keerden ze zwijgend weer tot spijs en kna.\n" +
                "Ze zagen haar de steenen van de rots\n" +
                "Beklimmen waar, hoog in zijn koningstrots\n" +
                "Wodan ter neer zat en zijn baard neerhing.\n" +
                "Hij had alleen een tafel en de ring\n" +
                "Der goden brachten hem om beurt de spijzen.\n" +
                "Men zag Mei nadren, en Wodan oprijzen,\n" +
                "Toen zaten ze te samen: als een duif\n" +
                "Zit bij een paardekop in paarderuif. \n" +
                "En aan het maal zaten de goden aan,\n" +
                "Jonge en oude goden. Mei zag z'aan,\n" +
                "En zocht naar Balder, maar hij was er niet.\n" +
                "De tafel leek de hemel als men ziet\n" +
                "Den melkweg; als dat schittren was het bonzen\n" +
                "Van een nieuw wijnvat in de zaal gerold.\n" +
                "Hier brak er een gelach los en dat hold'\n" +
                "Uitgelaten de tafel rond, dan schudden\n" +
                "De hoofde, dan weer stiller -- als een kudde\n" +
                "Van schapen graast, wordt dat geluid gehoord.\n" +
                "De schittering van 't gebekerte omboord\n" +
                "Met wijn, de bekers in de blanke handen,\n" +
                "Als fijngestreelde bloemen, rijen tanden\n" +
                "Tusschen volle lachende lippen, met\n" +
                "Haar, wange' en oogen met een glans gebet.\n" +
                "Het maal ging voort, de herten en wijnvaten\n" +
                "Werden geopend, wijn en bloed gelaten\n" +
                "In glas en schotels, tafels stroomde' er van.\n" +
                "Wijn gorgeld' in de roe,mers en één kan\n" +
                "Brak en de wijn brak ut als uit een bom.\n" +
                "Allen schreeuwden stampend er rondom.\n" +
                "En langzaam aan begon 't gezwaai van rompen\n" +
                "En 't wankelen der hoofden, schepen dompen\n" +
                "Zoo in de golven als de storm begint,\n" +
                "En morrend brommen als wanneer de wind\n" +
                "Door 't leege touwwerk raast der visschersvloot,\n" +
                "Die op de ankers rijdt in watersnood.\n" +
                "En zoo terwijl rondom een fel licht scheen,\n" +
                "Glorie van licht, waarin het maal beneen\n" +
                "Een zee geleek in 't woelen, waar de zon\n" +
                "Op brandt en flikkert, water gromt, begon\n" +
                "Mei en ze boog zich tot den ouden man,\n" +
                "Die luisterde, stil voor zich zined: ''Wodan,\n" +
                "Waar is de schoonste god, o waar is Balder?'' \n" +
                "Zoo valt een boom om, zoo als van zijn schouder\n" +
                "Zijn hoofd voorover viel, zijn oog werd dof\n" +
                "Terwijl dat viel, zijn handen met een plof\n" +
                "Vervielen van de tafel op zijn knieëeen.\n" +
                "Hij werd veel ouder en zij zag bezijen\n" +
                "Zijn hoofdd vergrijzen en zijn huid werd geel.\n" +
                "Ademloos en grootoogig zag ze, heel\n" +
                "Zijn oude lijf rillen en beven, wolken\n" +
                "Over hem gaan; gekreun zoals het bulken,\n" +
                "Runderebulken, hoorde ze in hem.\n" +
                "Boven en rondom ving orkanestem\n" +
                "Het klagen aan, de lucht werd zwart, en hagel\n" +
                "Begon op tafel kletering, gewaggel\n" +
                "Greep tonnen en okshoofden aan, de zaal\n" +
                "Werd lag door dampen en door wolkgedaal.\n" +
                "Stommer werden de goden, een voor een,\n" +
                "En stijf van schrik, ze bleven nog bijeen\n" +
                "Zitten zooals ze waren, wijl rondom\n" +
                "Als wolvehuilen windeloeien klom.\n" +
                "En midden in dat stommelen rees toen Wodan,\n" +
                "Een oud man met een grijs gebeente: ''goden,\n" +
                "Zoo sprak hij, heden is al vreugd vervloekt,\n" +
                "Het is mijn zoon, 't is Balder, dien zij zoekt.''\n" +
                "En alle goden bogen zich ter neer,\n" +
                "Steunden de hooden op de armen, meer\n" +
                "Hoorde niemand dan doffer rouwgeklaag.\n" +
                "En als een herder stond Wodan, en laag\n" +
                "Was ook zijn hoofd gebogen, 't was als zong\n" +
                "Hij vóór: een treurlied -- 't gonsde op zijn tong\n" +
                "En de godessen hoorden in 't verblijf,\n" +
                "Spelend en spinnend, en ze zaten stijf\n" +
                "Luistrend als zomerbloemengroepen eerst:\n" +
                "Hieven zich langzaam op en vingen teerst\n" +
                "Gefluister aan, staande dicht bij elkander,\n" +
                "En namen haar gewaden en toen zonder\n" +
                "Geraas of lachen, in een blanke rij\n" +
                "Als reizende zwanen gingen ze voorbij\n" +
                "Haar hooge deuren en door de portalen.\n" +
                "Ruischende als de sneeuw kwamen ze dalen\n" +
                "De drempels af, de hooge ramen in\n" +
                "En hoorden Balders naam, en leed en min\n" +
                "Deden ze weenen waar haar groepen stonden\n" +
                "Onder donkeren boomen, waar ze vonden\n" +
                "Opene vloerren, knielden ze wel neer.\n" +
                "En 't vrouwejamm'ren ruischte er zacht en teer\n" +
                "In 't mannemomplen, zoo als waterwel\n" +
                "Ruischt in de herfstbosschen, droevig en schel. \n" +
                "Een was er droef en stil en dat was Mei,\n" +
                "Zij kon niet weenen, in zich voelde zij\n" +
                "Leegte en eenzaamheid -- wnt heen was hoop\n" +
                "Die daar had zitten spelen -- en 't was verloop\n" +
                "Van koud bloed maakte nu haar lichaam kil.\n" +
                "En zij zat stil en voelde alleen geril\n" +
                "Over haar rug, toen de Asinnevlucht\n" +
                "Vloog in de zaal met duivekengerucht.\n" +
                "Herinn'ring kwam haar aan Idoena's naam\n" +
                "En zoekend keek ze rond waar ze te saam\n" +
                "Hurkten als duiven op den duiveslag.\n" +
                "Er zou wel iets van zijnen zonnedag\n" +
                "Glanzen nog in heur haar en van zijn kussen\n" +
                "haar bloed nog blaken. Maar ze was niet tusschen\n" +
                "De anderen, omdat ze bleef te bed\n" +
                "Waar jonge Balder vroeger kwam en met\n" +
                "Haar sliep, en droome' als opgebloei van rozen\n" +
                "Sproten en stilden haar liefs minnekozen.\n" +
                "En roen terwijl rondom de bodem dreunde\n" +
                "En buiten onweer, en de goden kreunden\n" +
                "En mompelden, ontbloeide dit gesprek:\n" +
                "Mei's woorden wat den lentevogelbek\n" +
                "Ontwelt; maar Wodan's, wie terwijl de boomen\n" +
                "En blaan doen sidderen, de windestroomen.\n" +
                "En telkens bij zijn naam dan werd geslagen\n" +
                "De lucht van schrik en konden zich niet schragen\n" +
                "Noch zuil, noch god, noch rots, noch boomehagen.\n" +
                "''Balder, Balder, waar is hij, wie bergt hem?''\n" +
                "''Van hier verdwenen,'' gromde Alvader's stem.\n" +
                "''Weet niemand waar hij is, komt hij niet weer?''\n" +
                "''Niemand weet dat, hij komt hier nimmermeer.''\n" +
                "''Was hij hier jong en blijde en danste en zong?''\n" +
                "''Zijn stem klinkt, schaduw danst nog waar hij sprong.''\n" +
                "''Was 't heele huis niet licht als Balder kwam?''\n" +
                "''Wee mij, wee mij, wien hij het licht meenam.''\n" +
                "''Lachten de goden dan, bloosden godinnen?''\n" +
                "''Met hem trad zaligheid de zalen binnen.''\n" +
                "''Was hij de blankste en de blinkendste?''\n" +
                "''Zijn oog het lichtst, zijn stem het klinkendste.''\n" +
                "''Balder, een hemelster, een dagebloem.''\n" +
                "''Balder, een woudvogel, Walhalla's roem.''\n" +
                "''Balder, van springfontein, een waterval.''\n" +
                "''Balder, een zonneberg, een bloemedal.''\n" +
                "''Balder, Balder, waar is hij, wie weet hem?''\n" +
                "''Noemand meer weer hem,'' gromde Alvaders stem.\n" +
                "''Idoena, minde zij dan Balder niet?''\n" +
                "''En nog, terwijl zij ook dit wee geniet.''\n" +
                "''Hoe wachtte zij hem, wer de avond geel?''\n" +
                "''Op rozebed, onder vioolprieel.''\n" +
                "''Hoe kwam hij dan in haren arm, vermoeid?''\n" +
                "''Zóó niet, maar straalgekroond en lichtgeschoeid.''\n" +
                "''Hij had om zich glorie en geuredamp.''\n" +
                "''Elk zijner handen was een lichte lamp.''\n" +
                "''Balder, zijn leliehuid had oliegeur.''\n" +
                "''Balder, zijn prachtig bloed had purperkleur.''\n" +
                "''Balder, zijn lijf zoo als een koningstroon.''\n" +
                "''Balder, een koningskind, een Wodanszoon.''\n" +
                "''Balder, Balder, waar is hij, wie weet hem?''\n" +
                "''Wij weten niet,'' gromde der goden stem. \n" +
                "En aldoor was de zaal vol gewoest gewuif\n" +
                "Van windbewogen nevels en gestuif\n" +
                "Van bladeren. Het water buiten botste\n" +
                "Tegen de fondamenten, en er klotsten\n" +
                "Brokken van golven voor de ramen op.\n" +
                "Zoo loeit de stoomketel na nieuwen schop\n" +
                "Van steenkool en zijn vlam en water razen,\n" +
                "Zooals de wond daar rondging en de wazen\n" +
                "Van dampen voortdreef, nieuwe achter hem.\n" +
                "En Wodan stond daarin en hield zijn stem\n" +
                "Van nu af stil, en ook de goden zwegen\n" +
                "Als mannen om hun koning neergenegen. \n" +
                "En toen zei zij: ''nu mannen luistert nu,\n" +
                "Ik zelve zag hem: breng een tijding u.''\n" +
                "Die zon kwam schijnen in den droeven tuin:\n" +
                "In stilte klom de nevel in de kruin\n" +
                "Der boomen, onder werd het klaar en klaarder.\n" +
                "'s Avonds na stortregens wordt zoo de gaard' er\n" +
                "Lichter en lichtst van en vol diamanten\n" +
                "Van zonschijn en van regendroppels, kanten\n" +
                "Van spinneweb, bedruppeld en bekleurd\n" +
                "Weven de stuiken, elke bloesem geurt.\n" +
                "En nogmaals zei ze: ''mannen, luistert nu,\n" +
                "Ik zelve zag hem, breng een tijding u.''\n" +
                "En weder klonk dat helder uit en stilde\n" +
                "Als milde olie golvemomp'len, rilde\n" +
                "Nog voort en uit en om en vloog toen ook\n" +
                "Idoena's kamer in, en toen zij rook\n" +
                "En proefde stille effenende troost,\n" +
                "Verrees z' en dronk hem in en even poosd'\n" +
                "In voorgevoelen, wat dat voelen meen' --\n" +
                "En murmelde en liep zoo murm'lend heen.\n" +
                "En binnen kwam ze en ze zag ze staan,\n" +
                "De goden en godinnen, wijl Wodan\n" +
                "Alleen stond ernstig -- door elkander stonden\n" +
                "Ze daar en blonken en hun open monden\n" +
                "Spraken, dat zag ze en blozende hoofden\n" +
                "Geleken bloemen en oogen beloofden\n" +
                "Vreugde door schittering, en groote handen\n" +
                "Gingen de lucht door, vroolijk, en de randen\n" +
                "Satijn en zij streelden de vloer in slepen.\n" +
                "Zij zagen haar en gingen als de schepen\n" +
                "Ter zij, bij vlootrevue, maar één bleef staan\n" +
                "Heel diep en aan het eind der lichte laan.\n" +
                "En zij, Idoena, wankelde door het midden\n" +
                "Naar Mei en trad dicht aan, en om haar midden\n" +
                "Naar Mei en trad dicht aan, en om haar midden\n" +
                "Legde ze zacht een arm en vleide het hoofd\n" +
                "Aan schouder en langs boezem: vol geschoofd\n" +
                "Staan zoo twee bundels aren op den akker.\n" +
                "En uit haar oogen waakte een geflakker\n" +
                "Van blikken en haar hand begon te streelen\n" +
                "De haren achter Mei en zacht te kweelen\n" +
                "Leken ze iets, verstaan kon niemand dat.\n" +
                "En de andre hand had als een grooten schat\n" +
                "De hand van Mei in zich en greep en knelde\n" +
                "En kuste ze optillend en ze telde\n" +
                "De vingers een voor een met haren mond.\n" +
                "Balder, Balder, ruischte het en ze wond\n" +
                "De armen om haar, of ze Balder was.\n" +
                "En zoo beweegt in wind het lange gras,\n" +
                "Zoo als wind de takken aangrijpt, schald' er\n" +
                "Hooger en hooger rondom uit den drom,\n" +
                "Balder, Balder, en armen sloegen om.\n" +
                "''Hij leeft, zei ze, hij leeft, want ik zag hem.\n" +
                "Hij leeft en zingt, ik hoorde zijne stem.\n" +
                "O goden, hij zong mij een droomelied,\n" +
                "Een godendroomenlied, ik voelde niet\n" +
                "Mij zelve meer, hem, hem, een tweede hem.\n" +
                "Ik snelde mee en week mee met zijn stem\n" +
                "In blinkende oneindigheid, als in\n" +
                "Koelende meeren, ik was zonder zin,\n" +
                "Muziek alleen, niets van mijn dierbaar zijn\n" +
                "Voelde ik meer, verloren, maar gekwijn,\n" +
                "Gesmelt in tonen, 'k zelf een lang accoord.\n" +
                "Ik hoor hem zoo altijd en heb behoord\n" +
                "Hem na dien tijd en nu altijd, voor goed.\n" +
                "Hij zweeg en is verwenen en mijn bloed\n" +
                "Stroomt ook weer langzamer, maar diep daarin\n" +
                "Vaart altijd nog het schip herinnering.\n" +
                "Hij zong van u Idoena, 'k heb gezocht\n" +
                "Uw huis, of hij daarin verwijlen mocht.'' \n" +
                "En rondom hingen blijde aangezichten\n" +
                "Als appels en de godenoogen lichtten\n" +
                "En glansden, zijl ze allen naar Mei zagen.\n" +
                "Idoena lachte en lachend liet zich dragen\n" +
                "Door even groote Mei die haar omving.\n" +
                "Ze kuste haar en nogmaals en ze hing\n" +
                "Om haar zooals de blauwe bloemerank,\n" +
                "Clematisbloem haar kelk hangt aan de slanke\n" +
                "Aanzwelling van een vas. Daar was heel lang\n" +
                "Alles heel stil terwijl een ieder drang\n" +
                "Van vreugde in zich voelde en begeerde\n" +
                "Luide klanken en lied'ren: onbeheerde\n" +
                "Zuchten soms vloden uit benauwde keel.\n" +
                "Eindelijk hoorden zij een zacht gestreel\n" +
                "Van vingers langs harpsnaren, want één god\n" +
                "Was stillekens heengegaan en had het slot\n" +
                "Van Balders zale opgebroken en\n" +
                "Zijn cither zich gehaald: te murmelen\n" +
                "Begon dat achter de vergadering --\n" +
                "En allen schemerden van glimlaching.\n" +
                "Hij speelde een lied uit: niemand zag om,\n" +
                "Maar allen voor zich neer, en hielden krom\n" +
                "Het hoofd gebogen, tinteling van klank\n" +
                "Sprenkelde op hen neer, als drupjes drank.\n" +
                "Maar Wodan stond recht op, bewoog het haar\n" +
                "Heene en weer boven de godenschaar.\n" +
                "Toen dat lied uit was spraken allen samen\n" +
                "Zich naar elkander buigend, zoo beramen\n" +
                "De vogels in den herfst hun langen tocht.\n" +
                "En allen lachten en Idoena zocht\n" +
                "Met stil verlangen al de hooge deur,\n" +
                "Of ze noet open ging en haren heer\n" +
                "Doorliet, zoo blank weerkeerrend van de reis.\n" +
                "Nu leefde hij, kwam weer, zoo zong een wijs\n" +
                "Haar minziek zingend hart, en zij zag rood\n" +
                "Boven haar hals en kwijnend droomend bood\n" +
                "Ze hare lippen al in leege lucht.\n" +
                "En om haar fladderde de witte vlucht\n" +
                "Asinnen al met Mei en vroeg haar hoe\n" +
                "Het lied van Balder was, maar zij hield toe\n" +
                "Haar mond en sprak niet veel, maar keek zltijd\n" +
                "Idoena aan met liefde en met nijd. \n" +
                "Een dans. De heele meigt' danste voort\n" +
                "Van 't eind der zaal. Rondom werden verstoord\n" +
                "Van uit verblijven blond gelokte vrouwen.\n";

        tekst3 = "Lachende kwamen ze, wèl opgevouwen\n" +
                "In haar gewaden, zoo zijn edelsteenen\n" +
                "Flikkerend in satijn, zooals zij schenen\n" +
                "Met voet en beozem uit heur waden uit.\n" +
                "Vooraan den stoet Idoena, Balder's bruid,\n" +
                "Zij tripte het marmer met haar warme voeten.\n" +
                "Dan dansten allen: en de heele stoeten\n" +
                "Kwamen vooruit, gehande armen dreven\n" +
                "Naar voren en de golven lokken bleven\n" +
                "Meegaan van achter op de lucht. Een enk'le\n" +
                "Wendde het hoofd en lachtem en het tink'len\n" +
                "Klonk als een Roomsche altaarschel. Daarna\n" +
                "Kwamen de rijen goden, een hoera\n" +
                "Weerklonk dreunend: dat schreeuwde groote Thor;\n" +
                "Daarachter and're goden grijs en schor. \n" +
                "Wodan bleef eenzaam, droef en hopeloos.\n" +
                "Toen hij alleen was, stond hij nog een poos\n" +
                "En zette zich toen neer, zeer zwaar en droef.\n" +
                "En stilte en peinzen maakten toen een groef\n" +
                "Rondom hem donker, waarin hij neerzat.\n" +
                "De zaal werd donker en de gansche schat\n" +
                "Van 't maal werd donker, donker werd het brein\n" +
                "Van Wodan, daar blonk nog zijn oogenschijn.\n" +
                "Hij zonk in peinzen en twee zwarte raven,\n" +
                "Als doodgravers die 't koude lijk begraven,\n" +
                "Vlogen zacht aan en zetten zich voor hem --\n" +
                "Lang nog luisterde hij naar raad en stem. \n" +
                "Mei was daar nog en zat een einde ver\n" +
                "In 't duister en ze blonk er als een ster,\n" +
                "Aandachtig kijkend naar den ouden god.\n" +
                "Buiten danste de menigte en tot\n" +
                "Haar kwam gelach en voetgeschuif en drok\n" +
                "Gepraat flauw hoorbaar, en hoog in den nok\n" +
                "Der zaal hing nevel, gonsde nog wat wind.\n" +
                "\"En bang en banger werd ze als een kind\\n\" +\n" +
                "\"Dat voor een oud man wordt, met haar alleen.\\n\" +\n" +
                "\"En uit haar angst stond ze toen op en heen\\n\" +\n" +
                "\"Vluchtte ze zonder omzien en ging ver,\\n\" +\n" +
                "\"Dwalend door 't donker als een lichte ster. \\n\" +\n" +
                "\"En ze werd eenzaam en ze vluchtte verder,\\n\" +\n" +
                "\"Een schaap gelijkend dat den boozen herder\\n\" +\n" +
                "\"Ontkomt en nu alleen graast en weer kan\\n\" +\n" +
                "\"Een kant opgaan naar eigen wil. Moe vna\\n\" +\n" +
                "\"Anderer blijdschap was ze en eigen leed.\\n\" +\n" +
                "\"En langzaam liep ze, zag niet, en ze beet\\n\" +\n" +
                "\"De tanden op elkaar, want er is nijd\\n\" +\n" +
                "\"In ieders droevig hart bij vroolijkheid.\\n\" +\n" +
                "\"Ook stond ze nog eens stil, daar achter was\\n\" +\n" +
                "\"Het blank paleis, het glinsterde van glas\\n\" +\n" +
                "\"In koepels en in torens, daar was nu\\n\" +\n" +
                "\"Weer binnen 't licht van vreugde aan, schaduw\\n\" +\n" +
                "\"Alleen had zij: ''O Balder, ìk min meest\\n\" +\n" +
                "\"Uw jonge rijke jeugd'', dat was haar geest\\n\" +\n" +
                "\"Een troost, en plots'ling sloeg hoog op in haar\\n\" +\n" +
                "\"Een golf van trots, ze schudd' het volle haar,\\n\" +\n" +
                "\"Zooals een vroolijk paard de staart, en liep\\n\" +\n" +
                "\"Sneller en sneller als een paard. -- Daar diep\\n\" +\n" +
                "\"En breed en hoog was weer de blauwe rijkheid\\n\" +\n" +
                "\"Van zon- en etherbrand, die zijn gelijkheid\\n\" +\n" +
                "\"Niet heeft, maar zelf zich brandt en nooit verslindt.\\n\" +\n" +
                "\"Het vuur vecht daar met vuur, géén overwint. \\n\" +\n" +
                "\"En toen ze ver was in die vlakte, stond ze\\n\" +\n" +
                "\"Een lange wijl weer en nadenkend vond ze\\n\" +\n" +
                "\"Een groote blijdschap in zich, want ze dacht\\n\" +\n" +
                "\"Nu zekerder dat hare lange wacht\\n\" +\n" +
                "\"Niet lang meer duren kon -- zij zou nu komen\\n\" +\n" +
                "\"Dicht bij zijn woning, zouden dan haar loome\\n\" +\n" +
                "\"Lippen om liefde vragen, o één kus.\\n\" +\n" +
                "\"Ze drong dicht bij hem, voelde droomgesus\\n\" +\n" +
                "\"Als wiegde hij haar heene en weer weder.\\n\" +\n" +
                "\"Ze liep ook heen en weer zooals een veder\\n\" +\n" +
                "\"Verloren op een vijver door een zwaan,\\n\" +\n" +
                "\"En bijna kwijnde ze en bleef weer staan.\\n\" +\n" +
                "\"En hij werd in haar tegenwoordigheid\\n\" +\n" +
                "\"Zoo duidelijk dat haar neusgaten wijd\\n\" +\n" +
                "\"Zich openden, alsof z'hem voor zich rook.\\n\" +\n" +
                "\"Toen dacht ze aan de aarde en er dook\\n\" +\n" +
                "\"Voor hare ooge' een bloemschepping op,\\n\" +\n" +
                "\"Van violette' en primula's, gedrop\\n\" +\n" +
                "\"Viel neer van geurdoortrokken avonddauw --\\n\" +\n" +
                "\"Zoo rook ze hem en kwijde en viel daar flauw. \\n\" +\n" +
                "\"En langzaam werd ze toen henengetrokken,\\n\" +\n" +
                "\"Te droomen liggend, zoo als met al vlokken\\n\" +\n" +
                "\"Sneeuwbui de lucht doortrekt. En om haar henen\\n\" +\n" +
                "\"Vloten de murmelwinden, en de beenen\\n\" +\n" +
                "\"En armen waren diep in geur verhulde.\\n\" +\n" +
                "\"En heure haren over haar, ze vulden\\n\" +\n" +
                "\"De blanke vlakte van haar borst, bewogen\\n\" +\n" +
                "\"Even op wind omwarend in dien hooge.\\n\" +\n" +
                "\"Toen was ze werk'lijk schoon want hare ziel\\n\" +\n" +
                "\"Was ganschlijk in haar, geen begeerte viel\\n\" +\n" +
                "\"Nu meer naar buiten, o een echte bloem.\\n\" +\n" +
                "\"Waar drijft gij nù heen, gij Mei, die ik noem\\n\" +\n" +
                "\"Mijn eigendom, gij die mijn duiventil\\n\" +\n" +
                "\"Al lang zijt, in wie alle duiven stil\\n\" +\n" +
                "\"Neerzitten, mijn gedachten, of ook vliegen\\n\" +\n" +
                "\"Naar binne' en buiten en zich mogen wiegen\\n\" +\n" +
                "\"Over u en om u, Mei, mijn lieveling.\\n\" +\n" +
                "\"Zij zullen u wel volgen, hun gezwing\\n\" +\n" +
                "\"Wordt nog niet moe, maar gaat gij niette ver?\\n\" +\n" +
                "\"Ik zie u haast niet meer, gij zijt een ster\\n\" +\n" +
                "\"Zoo hoog, het is alleen mijn zwakke oog\\n\" +\n" +
                "\"Dat u nog volgt, mijn lippen worden droog.\\n\" +\n" +
                "\"Waar drijft gij nu toch heen, mijn lieveling? \\n\" +\n" +
                "\"Toen ze zoo lang gedreven had, toen ging\\n\" +\n" +
                "\"Ze overeind weer, zóó, zooals een duiker\\n\" +\n" +
                "\"Te water, in haar handen vond ze een ruiker\\n\" +\n" +
                "\"Van violette' en primula's en lachte,\\n\" +\n" +
                "\"Nu wist ze zeker dat ze Balder wachtte.\\n\" +\n" +
                "\"Ze fladderde ook voort maar droomend traag,\\n\" +\n" +
                "\"En dacht aan hem en aan de eerste vraag\\n\" +\n" +
                "\"Die ze hem doen zou, o maar éénen kus.\\n\" +\n" +
                "\"Toen voelde ze zijn lippen en 't geblusch\\n\" +\n" +
                "\"Zacht sissen op haar mond, en in haar vingers\\n\" +\n" +
                "\"Zijn vingertrillingen, in blonde slingers\\n\" +\n" +
                "\"Der lokken zijnen aêm, en o zijn wang\\n\" +\n" +
                "\"Nu tegen haren en ze ging haar gang\\n\" +\n" +
                "\"Weer zls zoo even omgevallen verder.\\n\" +\n" +
                "\"Zij was zich geen gevoel bewust, toch werd er\\n\" +\n" +
                "\"Aldoor in haar gespeeld door veel gedachten,\\n\" +\n" +
                "\"Als muzikanten die hun hoorders wachten\\n\" +\n" +
                "\"En vast probeeren snaren van viool.\\n\" +\n" +
                "\"Zoo klonk het in haar, die niet hoorde -- school\\n\" +\n" +
                "\"Haar zelf dan weg en wilde niet genieten\\n\" +\n" +
                "\"EN hooren en de toonen zacht zien schieten\\n\" +\n" +
                "\"Dooreen als strengels struik met bloem begroeid?\\n\" +\n" +
                "\"MAar toch, terwijl gevoel met geuren stoeit\\n\" +\n" +
                "\"In haar, vingers van Balder, Balders geur,\\n\" +\n" +
                "\"Vaart ze vooruit, de voeten voor, en kleur\\n\" +\n" +
                "\"Waait over haar en maakt haar telkens rooder\\n\" +\n" +
                "\"En witter van de voeten tot haar schouder.\\n\" +\n" +
                "\"Zie, nu ontwaakt ze weer en gaat ze loopen\\n\" +\n" +
                "\"Sneller en sneller, laat de voeten doopen\\n\" +\n" +
                "\"In schemervuur en rook, zoo is dat blauw.\\n\" +\n" +
                "\"Ze is nu vroolijk, zie hoe luw en lauw\\n\" +\n" +
                "\"Ze uit haar oogen lacht, ze ziet hen beide,\\n\" +\n" +
                "\"Zich zelv' en hem, o nu niet meer te scheiden,\\n\" +\n" +
                "\"Ze heeft haar beide armen om hem heen.\\n\" +\n" +
                "\"Een gouden woning ziet ze en zijn schreen\\n\" +\n" +
                "\"Komen den drempel over, en zij ligt\\n\" +\n" +
                "\"Over een leger heen en voelt het licht\\n\" +\n" +
                "\"Alsof de roode zon komt in de kamer.\\n\" +\n" +
                "\"Zie nu hoe rood haar wangen, hoe de schaam er\\n\" +\n" +
                "\"Binnen zijn vuur stookt. Zij verdraagt het niet\\n\" +\n" +
                "\"En droomt weer in. -- En daar begint een lied\\n\" +\n" +
                "\"Weer in haar, dat ze toch niet hoort, hoewel\\n\" +\n" +
                "\"Ze zelf het zingt -- zoo als uit diepen del,\\n\" +\n" +
                "\"Door loover, oever en door zon bekoord,\\n\" +\n" +
                "\"Een bronwel springt maar 't springen zelf niet hoort. \\n\" +\n" +
                "\"Zoo bleef ze varen vele aardsche dagen,\\n\" +\n" +
                "\"En zij noch ik weet, hoe noch waar, of vlagen\\n\" +\n" +
                "\"Van eigen willen haar voortdreven, dan\\n\" +\n" +
                "\"'t Begeerrend trekken van een godd'lijk man.\\n\" +\n" +
                "\"Ik weet het niet, want al dien tijd was ik\\n\" +\n" +
                "\"Diep in u, Mei, u zelf, geen oogenblik\\n\" +\n" +
                "\"Keken wij rond, maar voelden diep in ons\\n\" +\n" +
                "\"Een warmte en zachtheid als vogeldons. \\n\" +\n" +
                "\"En toen zij ontwaakte -- is 't niet, Mei? --\\n\" +\n" +
                "\"Toen was het door een koelte: mijmerij\\n\" +\n" +
                "\"Van nevelen was daar en het was donker\\n\" +\n" +
                "\"Van donzig vochte nevel, en het wonk er\\n\" +\n" +
                "\"Als met heel groote oogen. En 't was warm\\n\" +\n" +
                "\"Als was een vuur niet ver, er hing geen scherm\\n\" +\n" +
                "\"Boven haar oogen die de starren zagen --\\n\" +\n" +
                "\"Maar rondom waren wolken zooals hagen\\n\" +\n" +
                "\"Van zachte coniferen en beneden\\n\" +\n" +
                "\"Als kussens mos waarop de voeten treden\\n\" +\n" +
                "\"In 't bosch als 't lente is, dan zijn ze zachtst.\\n\" +\n" +
                "\"''Nog niet? was hij er nog niet?'' Zoet gelachs\\n\" +\n" +
                "\"Kwam flauw op haren wang, het was onnoodig\\n\" +\n" +
                "\"Om nu nog bang te zijn, want werd niet roodig\\n\" +\n" +
                "\"De scheem'ring daar? O dat zou hij wel zijn.\\n\" +\n" +
                "\"Zij zweefde er henen, maar die roode schijn\\n\" +\n" +
                "\"Zweefde ook voort. Ook dat was groote vrede\\n\" +\n" +
                "\"Voor haar: zij gingen samen. En beneden\\n\" +\n" +
                "\"Veerden de nevelkussens, en van boven\\n\" +\n" +
                "\"Werd het ook lichter, 't werd een donk're oven\\n\" +\n" +
                "\"Die langzaam aangloeit. Toen de waarden gedaanten\\n\" +\n" +
                "\"Van hooge taille en licht wit getinte\\n\" +\n" +
                "\"Heel, heel veel hooger, en die strooiden bladen,\\n\" +\n" +
                "\"Rozen ontbalderend, het waren zaden\\n\" +\n" +
                "\"Van licht, want waar ze daalden schoot een oogst\\n\" +\n" +
                "\"Van koren licht den nevel door, op 't hoogst\\n\" +\n" +
                "\"Rondom Mei's schouderen; zij was heel blij\\n\" +\n" +
                "\"Dat zoo ontvangen werden zij en hij. \\n\" +\n" +
                "\"En langzaam weken alle nevelingen\\n\" +\n" +
                "\"Van nevellommer, schaduwnevelingen.\\n\" +\n" +
                "\"Die sloegen alle op de vlucht, rondom\\n\" +\n" +
                "\"Zag ze vervlieten lichte neveldrom. \\n\" +\n" +
                "\"En langzaam op begon muziek te tink'len\\n\" +\n" +
                "\"Bloempjes muziek, klokjes muziek, te kling'len\\n\" +\n" +
                "\"Klepeltje in klokmantel's glazig huis.\\n\" +\n" +
                "\"En elke klank splinterde dan tot gruis\\n\" +\n" +
                "\"En klok en klepeltje, want voor één klank\\n\" +\n" +
                "\"Waren ze maar geboren, dood tot dank. \\n\" +\n" +
                "\"Toen gingen henen muziekwolken drijven,\\n\" +\n" +
                "\"Ze zag ze niet, maar zag ze wèl, beschrijven\\n\" +\n" +
                "\"Strepen en kringen en zich kalm verheffen\\n\" +\n" +
                "\"In lichte verte, en ze kon beseffen\\n\" +\n" +
                "\"Hun klankenrijkdom in hun volle kleur.\\n\" +\n" +
                "\"Teer rose waren ze en zonder scheur\\n\" +\n" +
                "\"Noch berst, maar hoog daar barstten ze in regen,\\n\" +\n" +
                "\"Wolkbreuk van klank, zoo klankloos opgestegen.\\n\" +\n" +
                "\"En regenden dan neder in gordijnen,\\n\" +\n" +
                "\"Loodrechte stralen, druppels die doorschijnen,\\n\" +\n" +
                "\"Als kralen aangerege' aan Indisch riet --\\n\" +\n" +
                "\"VOor 't oor voorbij, voor oogen ver verschiet.\\n\" +\n" +
                "\"Henen vloden zware en lichte klanken.\\n\" +\n" +
                "\"Ze voelde in zich heen en weder wanken,\\n\" +\n" +
                "\"Als heel jong kind dat nog niet loopen kan,\\n\" +\n" +
                "\"Haar lang verlangen, en als krachtig man\\n\" +\n" +
                "\"Verdreef dat and're zielsverbeeldingen.\\n\" +\n" +
                "\"Was hij er nog niet, dacht ze, Balder, en\\n\" +\n" +
                "\"Toen kon ze rondzien zonder meer te hooren.\\n\" +\n" +
                "\"Het leek de aarde, want er stonden koren\\n\" +\n" +
                "\"Van boomen rondom: lichte populieren\\n\" +\n" +
                "\"Zonlicht niet weigerend, maar met hun slieren\\n\" +\n" +
                "\"Het schuddende en trillend. En er gingen\\n\" +\n" +
                "\"Lichte heuvelen hoog en daarvan hingen\\n\" +\n" +
                "\"Bloemen in menigt' af. En verder hooge\\n\" +\n" +
                "\"Wanden van hoogvlakten en daarvan bogen\\n\" +\n" +
                "\"Zich watervallen tot een duizelsprong.\\n\" +\n" +
                "\"En haar verlangen werd zóó groot, ze kon\\n\" +\n" +
                "\"Al deze aardsche dingen niet meer aanzien\\n\" +\n" +
                "\"Van tranen en van liefde, en in waanzin\\n\" +\n" +
                "\"Voelde ze hem in ieder ding: ze snelde\\n\" +\n" +
                "\"Op een boom aan, hem denkend, en ze stelde\\n\" +\n" +
                "\"Zich voor dien, armen open, en ze viel\\n\" +\n" +
                "\"Tegen dien aan en kuste en een ziel\\n\" +\n" +
                "\"Voelde ze in hem; in een sloot die open\\n\" +\n" +
                "\"Langs boomen lag, stortte ze zich, het loopen\\n\" +\n" +
                "\"Verrukte haar, diep in zijn worst'lend nat.\\n\" +\n" +
                "\"Toen werd ze op de lucht verliefd en mat\\n\" +\n" +
                "\"Dien met heel groote stappen en ze dronk\\n\" +\n" +
                "\"Hem in en at en streelde hem, gelonk\\n\" +\n" +
                "\"Gaf ze'm met hare oogen en ze liep\\n\" +\n" +
                "\"Heel hard door hem, dan volde ze hem diep.\\n\" +\n" +
                "\"Ze liep door weiden en op heuvelen,\\n\" +\n" +
                "\"Ze liep op bergen en door wateren,\\n\" +\n" +
                "\"Ze liep een wereld af door Balders rijk,\\n\" +\n" +
                "\"Overal was ze en zag zijn gelijk\\n\" +\n" +
                "\"In alles, maar hem niet -- tot dat ze kwam\\n\" +\n" +
                "\"In één vallei en daar hem zelf innam. \\n\" +\n" +
                "\"Ze nam en zwolg hem in, ìn hare oogen,\\n\" +\n" +
                "\"En sprong vooruit en greep hem en gedoogen\\n\" +\n" +
                "\"wou ze niet dat hij sprak, ze drukte hem\\n\" +\n" +
                "\"De lippen met de hare toe, hun stem\\n\" +\n" +
                "\"Werd niet gehoord, heel lang, ze zat dichtbij\\n\" +\n" +
                "\"Tegen hem aan en boog zich, en voorbij\\n\" +\n" +
                "\"Zijn borst, haar hals omhoog, stilde ze zoo\\n\" +\n" +
                "\"haar dorst, soms snikkend en ter nauwernoo\\n\" +\n" +
                "\"Ademend. Eind'lijk viel haar hoofd terzij,\\n\" +\n" +
                "\"En op zijn schouder brak ze in geschrei. \\n\" +\n" +
                "\"Hij was een man aan wonderen gewoon,\\n\" +\n" +
                "\"Wonderen van gevoel, en daarom kon\\n\" +\n" +
                "\"Hij zoo gerust blijven zooals hij zat,\\n\" +\n" +
                "\"Terwijl zij uitschreide. En in zich had\\n\" +\n" +
                "\"Hij weldra ook haar beeld, zooals ze schreide,\\n\" +\n" +
                "\"En werd zelf warmer en de handen beide\\n\" +\n" +
                "\"Sloeg hij tone om haar en hield zoo haar vast,\\n\" +\n" +
                "\"Dicht bij zich, weenen weinig zelf, als was 't\\n\" +\n" +
                "\"Zijn zusterke, wier weedom bij hem weende.\\n\" +\n" +
                "\"Toen voelde zij zijn natte tranen, leende\\n\" +\n" +
                "\"Het hoofd nog meer ter zij en zag weer licht\\n\" +\n" +
                "\"Door hare trane' en droogde haar gezicht. \\n\" +\n" +
                "\"Toen zag zij zijne lippen weer, te kussen\\n\" +\n" +
                "\"Boog zij zich over en hij voelde tusschen\\n\" +\n" +
                "\"De zijne haren liefelijken adem,\\n\" +\n" +
                "\"Een lenteadem, en toen kwamen naar hem\\n\" +\n" +
                "\"Herinneringe' en lichte lentebeelden:\\n\" +\n" +
                "\"Hij zelf werd als een lente en er kweelden\\n\" +\n" +
                "\"Vogeltjes in hem als in jongen boom.\\n\" +\n" +
                "\"Toen week ze weer van hem en zat in schroom\\n\" +\n" +
                "\"Naast hem, bedremmeld, met geloken oogen,\\n\" +\n" +
                "\"En toen haar handen hem verlieten, togen\\n\" +\n" +
                "\"Bij hem weer ìn gedachten, zooals kind'ren\\n\" +\n" +
                "\"In eenen boomgaard komen, ze vermind'ren\\n\" +\n" +
                "\"De hangend' appels, maar er vallen veel\\n\" +\n" +
                "\"Meerd're beneê, het gras ziet rood en geel. \\n\" +\n" +
                "\"En toen ze daar in stilte eind'lijk goot\\n\" +\n" +
                "\"KLeurige woorden, zelf zag ze schaamrood,\\n\" +\n" +
                "\"Toen was het hem alsof de zon op ééns\\n\" +\n" +
                "\"Na 't zwijgen van den nacht en het geveins\\n\" +\n" +
                "\"Der bleeke schmeing, uit wolkmoeras\\n\" +\n" +
                "\"Zich oplaat, blazend, en met zijn geblaas\\n\" +\n" +
                "\"Kleuren heenspreidt over de lucht, de velden,\\n\" +\n" +
                "\"'t Water, ja, alle dingen ongetelde. \\n\" +\n" +
                "\"''Ik ben maar Mei, ik woon maar op de aarde\\n\" +\n" +
                "\"Het waren Zon en Maan, die mij klein baarden,\\n\" +\n" +
                "\"Nu ben ik groot want nu zit ik naast u.\\n\" +\n" +
                "\"O maak mij grooter, nòg ben 'k klein en schuw.\\n\" +\n" +
                "\"O laat mij hooren hier naar uwe woorden,\\n\" +\n" +
                "\"Alles vergeten wat mij vroeger hoorde\\n\" +\n" +
                "\"Van jeugd en schoon, maar alles zien wat u\\n\" +\n" +
                "\"Behoort, o u een boom, in uw schaduw.\\n\" +\n" +
                "\"O sta nu boven mij zooals een boom\\n\" +\n" +
                "\"En laat mij liggen onder u, een droom\\n\" +\n" +
                "\"Verritselen zal ik uw bladen hooren.\\n\" +\n" +
                "\"O laat mij niets zijn dan ééne bekooring,\\n\" +\n" +
                "\"Een droom van u, o maak mij altijd vol\\n\" +\n" +
                "\"Van u, een vrucht die 't zonlicht levend zwol.\\n\" +\n" +
                "\"Zie, 'k wil u geven alles wat ik heb,\\n\" +\n" +
                "\"Ik deed het altijd, 'k doe het nog, ik schep\\n\" +\n" +
                "\"Honderde dingen uit mij, àl voor u,\\n\" +\n" +
                "\"Ik ben zooalas een mijn, uit mijn schaduw\\n\" +\n" +
                "\"Werp ik te voorschijn groote edelsteenen\\n\" +\n" +
                "\"En maak er bergen van, de zon kan weenen\\n\" +\n" +
                "\"Als hij ze ziet, zoo glinstert dat, zoo breek\\n\" +\n" +
                "\"Ik mij al heel lang, Balder, voor u open.\\n\" +\n" +
                "\"Balder, Balder, hebt gij mij zien loopen\\n\" +\n" +
                "\"Over de aarde nooit, hebt gij gezien\\n\" +\n" +
                "\"Hoe alle aardsche goden kwamen biên\\n\" +\n" +
                "\"Aan mij al wat ze hadden, en mijn vreugd\\n\" +\n" +
                "\"Om 't al te nemen, mij er mee verheugd\\n\" +\n" +
                "\"En lachend, te weerspiegelen in een plas,\\n\" +\n" +
                "\"Wanneer de maan scheen en het in het gras\\n\" +\n" +
                "\"Rondom mij neer te leggen in een keten\\n\" +\n" +
                "\"Van schittering en straalgebreek -- o weten\\n\" +\n" +
                "\"Wil ik dat nu niet meer, ik heb u.\\n\" +\n" +
                "\"MAg ik nu ook uw kussen drinken, nu\\n\" +\n" +
                "\"Gij hier zoo naast mij zit, een groote bron\\n\" +\n" +
                "\"Van kussen en van spel voor mij, ik kon\\n\" +\n" +
                "\"Zoo erg verlangen naar u in een nacht\\n\" +\n" +
                "\"Op aard en in den hemel'' -- en zeer zacht\\n\" +\n" +
                "\"Als wilde ze in iedre kus fijn proeven\\n\" +\n" +
                "\"Al haar verbeeldingen, zoo lang begroeven\\n\" +\n" +
                "\"Zich hare lippen in de zijne, en\\n\" +\n" +
                "\"Ze weende weer en kon niet ophouden.\\n\" +\n" +
                "\"En in haar stem liet hij zich henewiegen,\\n\" +\n" +
                "\"Zooals een vogel in de zon, niet vliegen\\n\" +\n" +
                "\"Doet die ook meer, maar drijft zoo doelloos rond\\n\" +\n" +
                "\"En voelt de zonneschijn -- en zijne mond\\n\" +\n" +
                "\"Kuste gemakkelijk omdat haar roode\\n\" +\n" +
                "\"Zangerige lippen het aldus geboden. \\n\" +\n" +
                "\"En toen ze daar zoo zaten als een bloem\\n\" +\n" +
                "\"EN nog een andre, die saam aan den zoom\\n\" +\n" +
                "\"van 't bosch gegroeid zijn, zóódat ze soms raken\\n\" +\n" +
                "\"Elkaar wanneer de wind waait, en het blaken\\n\" +\n" +
                "\"Van d'een de ander voelt, de stengels streelen\\n\" +\n" +
                "\"En wrijven langs elkander en de geele\\n\" +\n" +
                "\"Bloemhoningharten zien elkaar in de oogen --\\n\" +\n" +
                "\"Zoo zaten ze en toen terwijl bewogen\\n\" +\n" +
                "\"Voor hen veel wondere verschijningen\\n\" +\n" +
                "\"Op maat en melodie en deiningen.\\n\" +\n" +
                "\"Zoo was dat land waar al dat Balder dacht,\\n\" +\n" +
                "\"Hij landsheer en landsgod, zich zelve bracht\\n\" +\n" +
                "\"Te voorschijn en ter wereld en bleef leven\\n\" +\n" +
                "\"Tot nieuwe onderdanen het verdreven.\\n\" +\n" +
                "\"Want al die dingen die Mei voor zich zag\\n\" +\n" +
                "\"Waren zìjn onderdanen, zìjn gezag,\\n\" +\n" +
                "\"'t Waren de beelden zijns lieds geruisch op zijn rhythmiek,\\n\" +\n" +
                "\"Maar buiten hem de levendlichte schemer,\\n\" +\n" +
                "\"Schimmenafbeeldsels in een spingewemel. \\n\" +\n" +
                "\"Zoo zaten ze, hij stil muziek te maken,\\n\" +\n" +
                "\"Zij, zonder hooren, zag ze wel genaken. \\n\" +\n" +
                "\"Een schaar van kindren springende en blond,\\n\" +\n" +
                "\"Met teere witterozeschijn en rond\\n\" +\n" +
                "\"Van arm en beenen, oogen als op kronen\\n\" +\n" +
                "\"'s Avonds kaarsvlammen zijn en op de konen\\n\" +\n" +
                "\"Roode vlammetjes als op vruchtevellen.\\n\" +\n" +
                "\"Ze breiden zich in rijen en ze stellen\\n\" +\n" +
                "\"Zich naast elkaar: 't zijn jongetjes en meisjes.\\n\" +\n" +
                "\"En elk zoekt toen de zijne, met zijn beidjes\\n\" +\n" +
                "\"Dansen ze toen: zoo zijn de duizendschoonen\\n\" +\n" +
                "\"Binnen het woud, waar zon schijnt, anemonen\\n\" +\n" +
                "\"Groeien zoo twee aan twee op zeeëgrond.\\n\" +\n" +
                "\"Een fee verschijnt, ze springen om haar rond\\n\" +\n" +
                "\"Opkijkend en ze leunen aan haar beenen,\\n\" +\n" +
                "\"Grijpen haar handen hoog, gaan met haar henen. \\n\" +\n" +
                "\"Toen wordt het schemering en avondgroen,\\n\" +\n" +
                "\"Doorzichtig watergroen beneê, er doen\\n\" +\n" +
                "\"ZIch dons en dunne dauw op. Donkerder\\n\" +\n" +
                "\"Wordt alles en er is geen grond meer, ver\\n\" +\n" +
                "\"En hooger wordt de nachtehemel zichtber.\\n\" +\n" +
                "\"De maan komt op, de nevel wemelt, licht er\\n\" +\n" +
                "\"Phosphorisch mos en paddestoel, weerlicht\\n\" +\n" +
                "\"Het heen en weer van zomerbliksems, vliegt\\n\" +\n" +
                "\"Het van dwallichtjes in de lucht, de zicht\\n\" +\n" +
                "\"Der maan slaat ze verblinen af het graan,\\n\" +\n" +
                "\"Het starkgekroonde graan, van hare baan?\\n\" +\n" +
                "\"De lucht is vol van leuge' en twijfeling,\\n\" +\n" +
                "\"Maar langzaam donkert het, zijn halven ring\\n\" +\n" +
                "\"Verbergt de maan en haar twee scherpe dolken,\\n\" +\n" +
                "\"Donder gaat om, aandobberen de wolken.\\n\" +\n" +
                "\"Stil is het en de lucht is vol van zwart,\\n\" +\n" +
                "\"Het is vol zwoelte, leeg van licht, het hart\\n\" +\n" +
                "\"Van de nacht zelve klopt niet meer, is dood,\\n\" +\n" +
                "\"Het nacht-lijk is nog warm, het zwart is rood.\\n\" +\n" +
                "\"Violen bloeien uit dat zwarte op, \\n\" +\n" +
                "\"Twee blauwe bloemviolen, licht valt op\\n\" +\n" +
                "\"Hen niet, vanwaar? maar zelve hebben ze\\n\" +\n" +
                "\"Blauw licht in zich, en daarvan lichten ze.\\n\" +\n" +
                "\"Ze spinnen en vlechten zoo een groot prieel,\\n\" +\n" +
                "\"Een wieg van blauw gebloemte, evenveel\\n\" +\n" +
                "\"Aan wederzijde -- en toen was het klaar\\n\" +\n" +
                "\"EN wachtten ze en keken naar elkaar.\\n\" +\n" +
                "\"Twee bleke wezens traden toen te voor,\\n\" +\n" +
                "\"Dicht aan elkaar gedrongen, onderdoor\\n\" +\n" +
                "\"De armen hadden ze elkanders armen.\\n\" +\n" +
                "\"De hoofden naar elkander, zoo verwarmen\\n\" +\n" +
                "\"Z'elkander met hun oogen, om hen heen\\n\" +\n" +
                "\"Is niets -- zij tweeën zijn geheel alleen.\\n\" +\n" +
                "\"En d'eene spreekt en dit zijn hare woorden:\\n\" +\n" +
                "\"''Gij zijt geheel in mij en ik behoorde\\n\" +\n" +
                "\"U al zoo lang, ik weet niet meer wat is\\n\" +\n" +
                "\"Uw of mijn leven, uw gelijkenis\\n\" +\n" +
                "\"Ben ik, gij mijn -- wordt nu een kind geboren\\n\" +\n" +
                "\"Uit u en mij, dat zal ons toebehooren\\n\" +\n" +
                "\"Gelijkelijk, omdat wij beide zijn\\n\"\"Elkanders liefde waard, ik uw gij mijn.''\\n\" +\n" +
                "\"Zoo zeggende verdwenen ze meteen,\\n\" +\n" +
                "\"En 't donker ging en de violen heen. \\n\" +\n" +
                "\"En donker bleef het ook om Balder heen\\n\" +\n" +
                "\"En Mei, in hem een zwaar gegons, er scheen\\n\" +\n" +
                "\"Voor haar een flikkering van d'achtergrond\\n\" +\n" +
                "\"Van zijn gedachten en zij waarden rond\\n\" +\n" +
                "\"Zelve er voor, gewikkeld in het duister.\\n\" +\n" +
                "\"En zich opheffend hulde z'in gefluister\\n\" +\n" +
                "\"Koel, maar haar lippen brandden, ook die woorden:\\n\" +\n" +
                "\"''Gij zijt geheel in mij en ik behoorde\\n\" +\n" +
                "\"Uw of mijn leven, uw gelijkenis\\n\" +\n" +
                "\"Ben ik, gij mijn -- wordt nu een kind geboren\\n\" +\n" +
                "\"Uit u en mij, dat zal ons toebehooren\\n\" +\n" +
                "\"Gelijkelijk, omdat wij beide zijn\\n\" +\n" +
                "\"Elkanders liefde waard, ik uw gij mijn.'' \\n\" +\n" +
                "\"Donder knalde en rommelde, groote spoken\\n\" +\n" +
                "\"Vlogen een oogenblik rond en neergedoken\\n\" +\n" +
                "\"Zaten ze saam, toen schrikten ze weer heen\\n\" +\n" +
                "\"En vloden hande' omhoog, huilend uiteen.\\n\" +\n" +
                "\"Balder stond hoog, hij leek een rots, diep blauw\\n\" +\n" +
                "\"Was heel zijn lijf, zijn haren zwart, en grauw\\n\" +\n" +
                "\"Handen en voeten. En hij zeide hard\\n\" +\n" +
                "\"Als steenen, woroden: ''Nooit, nooit, nooit'' en zwart\\n\" +\n" +
                "\"Trilde hij zoo als een verbrande boom.\\n\" +\n" +
                "\"Hij zei het nog eens: nooit, en als een doem\\n\" +\n" +
                "\"Viel dat van boven op de kleine Mei\\n\" +\n" +
                "\"Die hande' en voeten uitgestoken, bij\\n\" +\n" +
                "\"Zijn voeten zat. En hij ging een eind weegs\\n\" +\n" +
                "\"Van haar en stond. En om zich kouds en leegs\\n\" +\n" +
                "\"Voelde ze, en was blind en wist niets meer,\\n\" +\n" +
                "\"Zooals één, doodgevroren in een sneeuwmeer. \\n\" +\n" +
                "\"Hij stond en voelde eerst een diepe kou\\n\" +\n" +
                "\"Of hij bevroor en ijs werd, en blauwgrauw\\n\" +\n" +
                "\"Waren zijn voete', en handen, en een hol\\n\" +\n" +
                "\"Van ijs in hem, zooals een berg, een schol\\n\" +\n" +
                "\"Van ijs die uit de poolzee losgeraakt\\n\" +\n" +
                "\"Is en 's nachts ronddrijft, en de zee bewaakt\\n\" +\n" +
                "\"In stilte van de blauwe manestralen.\\n\" +\n" +
                "\"Hij rilde van zijn grootheid en deed dalen\\n\" +\n" +
                "\"Zijn trillingen als van een hooge trap,\\n\" +\n" +
                "\"Zijn lijf, zijn tanden beefden met geklap\\n\" +\n" +
                "\"Tegen elkaar, hij lachte als het water\\n\" +\n" +
                "\"Dat 's winters nog op bergen valt, het baadt er\\n\" +\n" +
                "\"Door ijsbrokken en korsten grimmig. Hij\\n\" +\n" +
                "\"lachte met klatering, maar was niet blij. \\n\" +\n" +
                "\"Maar stiller werd hij, want hij hoorde koren,\\n\" +\n" +
                "\"Koren van zegelied'ren en verloren\\n\" +\n" +
                "\"Klanken van solo's, helle heldenzangen,\\n\" +\n" +
                "\"Hel en veruukkelijk, en op zijn wangen\\n\" +\n" +
                "\"Omhoog verscheen een helder rooder gloeien.\\n\" +\n" +
                "\"Beweegloos luistrend stond hij naar 't omroeien,\\n\" +\n" +
                "\"Vleugel en riemeslagen van muziek,\\n\" +\n" +
                "\"Breede slagen, zooals van den wiek\\n\" +\n" +
                "\"Van adelaren of als ademtochten\\n\" +\n" +
                "\"Van mannen breedgeschouderd, en er zochten\\n\" +\n" +
                "\"Ook uit zijn borst de ruimte koele zuchten:\\n\" +\n" +
                "\"Als loeien van een stier, groote geduchte\\n\" +\n" +
                "\"Geluiden en uitblazingen en woorden.\\n\" +\n" +
                "\"Om Mei dacht hij niet meer, maar stapte door de\\n\" +\n" +
                "\"Hemelen, schrijdend heen en weer, gekleed\\n\" +\n" +
                "\"In een sleepmantel van geluid, die breed\\n\" +\n" +
                "\"Achter zijn voeten aangolfde: een koning\\n\" +\n" +
                "\"Omschrijdend door de hallen van zijn woning. \\n\" +\n" +
                "\"En ook die tred werd langzamer, hij kwam\\n\" +\n" +
                "\"Weer waar Mei zat, en die gedachte nam\\n\" +\n" +
                "\"Hem 't kleed geluid af, dat geruischloos viel\\n\" +\n" +
                "\"Om zijne voeten. Over zijne ziel\\n\" +\n" +
                "\"Spreidden zich toen zeer zachte vleugelen.\\n\" +\n" +
                "\"En een gedachte kwam daar als een hen\\n\" +\n" +
                "\"Over een kuiken, op zijn hart en veilig\\n\" +\n" +
                "\"Voelde zich dat in rust, zooals in 't heilig\\n\" +\n" +
                "\"Der heiligen een ark staat zwaar en stil.\\n\" +\n" +
                "\"Daar traden binnen, dat de vloer geril\\n\" +\n" +
                "\"Van voetjes kreeg, blootvoet'ge priesteressen\\n\" +\n" +
                "\"Met lange fluiten, op een rij en tressen\\n\" +\n" +
                "\"Doorbloemde blonde welriekende lokken.\\n\" +\n" +
                "\"Dat was het medelij met Mei, ze trokken\\n\" +\n" +
                "\"Gordijnen weg en toen zag hij haar beeld\\n\" +\n" +
                "\"Zittende. Waar hij haar wist zitten knield'\\n\" +\n" +
                "\"Hij neer en werd weer als de jonge man\\n\" +\n" +
                "\"Als zij hem kende. Uit albasten kan,\\n\" +\n" +
                "\"Zijn mond, goot hij als balsem deze woorden:\\n\" +\n" +
                "\"''Nooit kan dit zijn, Mei, dat 'k een ander hoore,\\n\" +\n" +
                "\"Ik Balder, aan een ander, zie, 'k ben blind,\\n\" +\n" +
                "\"'k Zie nooit iets dan mijzelf, niet u, mijn kind.''\\n\" +\n" +
                "\"Dit zei hij en hij legde ook zijn handen\\n\" +\n" +
                "\"Op hare schouders; zooals in warande\\n\" +\n" +
                "\"Een bloem al vroeg in 't jaar de zon ontdooit,\\n\" +\n" +
                "\"Ontbloeide zij, de koude smart ontdooid'\\n\" +\n" +
                "\"Ook in de tranen die haar ooge' onvloeiden;\\n\" +\n" +
                "\"En zij sprak zijna woorden na, die boeiden\\n\" +\n" +
                "\"Met nieuwen pijnen haar: ''zie ik ben blind,\\n\" +\n" +
                "\"'k Zie nooit iets dan mij zelf, niet u, mijn kind.''\\n\" +\n" +
                "\"En toen sprak Balder deze woorden of\\n\" +\n" +
                "\"In leegen dom een orgel speelt en dof\\n\" +\n" +
                "\"Mompelt langs wanden en door de gewelven --\\n\" +\n" +
                "\"Maar 't spreken klimt tot klaatren, klanken delven\\n\" +\n" +
                "\"De stilte open en geheimenissen\\n\" +\n" +
                "\"Uit alle hoeken en de heil'gennissen.\\n\" +\n" +
                "\"Zoo sprak hij: '' 'k ben als gij geweest, ik ben\\n\" +\n" +
                "\"Nu zoo niet meer, als niemand meer, ik ken\\n\" +\n" +
                "\"Nog wel mijn oude zelf, die gaat nu dood.\\n\" +\n" +
                "\"Te zien, te zien, dat was mijn vroeger brood\\n\" +\n" +
                "\"En drinken, en te hooren en te voelen\\n\" +\n" +
                "\"Wat rondom is, de hitte en de koele\\n\" +\n" +
                "\"Kleuren en ademhaling, die er gaat\\n\" +\n" +
                "\"Door heel de wereld en elk wezen laat\\n\" +\n" +
                "\"Baden door zich en van zijn binnenst maakt\\n\" +\n" +
                "\"En brandt een oven waar het helvuur blaakt.\\n\" +\n" +
                "\"Die verlangt naar voedsel, dat is 't wreed begeeren,\\n\" +\n" +
                "\"De opgesperde kaak, de hand die meer en\\n\" +\n" +
                "\"Meer grijpt en vingers haakt en grijpend kromt.\\n\" +\n" +
                "\"Die 't al verandert en verderft wat komt\\n\" +\n" +
                "\"In zijn bereik, die altijd anders wil\\n\" +\n" +
                "\"Wat is, die alles hat wat blank en stil\\n\" +\n" +
                "\"Eeuwiglijk is, die schapt en baart omdat\\n\" +\n" +
                "\"Hij ook zichzelven haat, niet duldend dat\\n\" +\n" +
                "\"Hij zelf blijft leven, maar den dood begeerend.\\n\" +\n" +
                "\"Zoo zijn èn God èn menschen, die verweerend\\n\" +\n" +
                "\"In 't leven staan, en gruizend, en tot stof\\n\" +\n" +
                "\"Vallen de een na d'ander, een kerkhof\\n\" +\n" +
                "\"Van dood verlangen en verdord gebeente.\\n\" +\n" +
                "\"Zij maken nieuw geslacht, verlangend heen te\\n\" +\n" +
                "\"ZIjn zelf, hatende zich, hatend wat is,\\n\" +\n" +
                "\"Willend wat wordt, in woede en droefenis. \\n\" +\n" +
                "\"Zoo zijn ze ook niet blij met hun gevoelen\\n\" +\n" +
                "\"Alleen te hebben ìn zich, maar ze koelen\\n\" +\n" +
                "\"Hun willenswoede en zichzelve af\\n\" +\n" +
                "\"Door scheppingen en bouwen zoo een graf\\n\" +\n" +
                "\"Voor 't kostbaarste wat ze een oogwenk zijn,\\n\" +\n" +
                "\"En uiten zich. Zoo gaf eens Wodan schijn\\n\" +\n" +
                "\"Aan wat hij wist en voelde, hij de weter\\n\" +\n" +
                "\"En voeler, d'allergrootste, en nu heet er\\n\" +\n" +
                "\"Een wereld naar hem, hìj is arm, en dood\\n\" +\n" +
                "\"Zal hij eens moeten met hen zijn wereld, nood\\n\" +\n" +
                "\"Voelt hij al voor hen beiden, kan niet vinden\\n\" +\n" +
                "\"Geluk, een doodswolf zal hen beî verslinden. \\n\" +\n" +
                "\"Soms komen bleeke oude herinneringen\\n\" +\n" +
                "\"Nog in mij op en zie ik van de tinnen\\n\" +\n" +
                "\"Van mijn paleis de oude godenwereld\\n\" +\n" +
                "\"Zoo als ze was weleer, de vlakte dwarrelt\\n\" +\n" +
                "\"Van godendans, ik zie hun groote beelden\\n\" +\n" +
                "\"Op maat van muziek, en in verhulde\\n\" +\n" +
                "\"Figuren ken ik nog godengedaanten.\\n\" +\n" +
                "\"Soms bloeien struiken om mij en ik waan te\\n\" +\n" +
                "\"Slapen op aarde en ik zie de vlakte\\n\" +\n" +
                "\"Der zee, de wolken en het licht dat brak te\\n\" +\n" +
                "\"Gruizen eens aan den hemel, waar nu starren\\n\" +\n" +
                "\"Gesponnen zijn, blinkend in 't blauwe garen. \\n\" +\n" +
                "\"Soms denk ik aan een vrouw als toen gij kwaamt\\n\" +\n" +
                "\"Zoo even en mij in uw armen naamt,\\n\" +\n" +
                "\"Kussend en willend en de smart niet dragend\\n\" +\n" +
                "\"Van eigen voelen, uwe liefde, vragend\\n\" +\n" +
                "\"Verandering en blusschen van die vlam\\n\" +\n" +
                "\"Die gij genoten hadt en die toch nam\\n\" +\n" +
                "\"De allerschoonste kleuren in uw oog.\\n\" +\n" +
                "\"Soms voel ik nog als gij en ik bedroog\\n\" +\n" +
                "\"U zóó zooeven, nu ben ik weer stil\\n\" +\n" +
                "\"En waar in mij, en voel wat 'k altijd wil. \\n\" +\n" +
                "\"Hoor mij nu, Mei: er dwaalt in ieder leven,\\n\" +\n" +
                "\"In ieder lijf, een vlam, elk voelt haar beven\\n\" +\n" +
                "\"Wel eens of tweemaal, maar niet vele malen.\\n\" +\n" +
                "\"De menschen noemen ziel haar, ze verhalen\\n\" +\n" +
                "\"Er lange wondere verhalen van,\\n\" +\n" +
                "\"Weten niet veel, voeden haar niet en dan\\n\" +\n" +
                "\"Sterft ze vergeten en alleen gelaten.\\n\" +\n" +
                "\"Kinderen voelen haar wanneer ze na te\\n\" +\n" +
                "\"Slapen gegaan te zijn, nog lang òpwaken\\n\" +\n" +
                "\"Gedacht'loos srarend voor zich, want genaken\\n\" +\n" +
                "\"Voelen ze niets, geen beeld, en ook in hen\\n\" +\n" +
                "\"Schijnt niets te leven of te mijmeren.\\n\" +\n" +
                "\"Dan voelen ze oprijzen en neerdalen\\n\" +\n" +
                "\"Hun leven, ademen gaan door de zalen\\n\" +\n" +
                "\"Huns harts en onder een hoog oppervlak\\n\" +\n" +
                "\"Leeft een nieuw wezen nu het oude brak. \\n\" +\n" +
                "\"Zoo zijn de jonkvrouwen, wanneer haar jaren\\n\" +\n" +
                "\"Vollere zijn en zij de lange scharen\\n\" +\n" +
                "\"Mannengedaanten 's avonds buitensluit.\\n\" +\n" +
                "\"Dan zit ze op een stoel, aan hare ruit,\\n\" +\n" +
                "\"Maar ziet niet uit, haar oogen zijn gesloten.\\n\" +\n" +
                "\"Zij denkt niet, levensboom is dood, maar loten\\n\" +\n" +
                "\"Schiet daar het dieper leven en ze voelt\\n\" +\n" +
                "\"Dat wuiven op windadem en windkoelt,\\n\" +\n" +
                "\"En huivert, draagt het niet, breekt in geschrei\\n\" +\n" +
                "\"Haar oogen open, dan is 't weer voorbij. \\n\" +\n" +
                "\"Mannen zijn zoo die men de dichters heet,\\n\" +\n" +
                "\"Een jong man zoo, die 't slaafsch leven vergeet\\n\" +\n" +
                "\"Een uur, een dag lang, en zich zelven hoort\\n\" +\n" +
                "\"En naar zich luistert, wat geboren wordt\\n\" +\n" +
                "\"Aan leven in zich en de wondre daden\\n\" +\n" +
                "\"Die 't dieper zelf bedrijft, en naar beladen\\n\" +\n" +
                "\"Winden met klanke' en woorden ongehoord.\\n\" +\n" +
                "\"Zoo zit hij wel een uur, daardoor bekoord. \\n\" +\n" +
                "\"Dat leven heeft een beeld, hoor mijn geluk,\\n\" +\n" +
                "\"ZIe toe hoe ik den slagboom openruk,\\n\" +\n" +
                "En hoe er doordringt nu een bonte trein,\n" +
                "Paarden met belle' en ruiters: schoone schijn.\n" +
                "Dat beeld dat is muziek, want wie kan hooren\n" +
                "DIen wond'ren schijn weerklinken of te voren\n" +
                "Breekt uìt die diepste ziel, en slaat te stuk\n" +
                "Een vroeger leven en zet met een ruk\n" +
                "Een nieuw tooneel op van het nieuwe leven:\n" +
                "O zonder beelden, onbegrepen, neven\n" +
                "Zich zonder schauw of schijn, alléén gewelde\n" +
                "Bobbels van lucht, zeepbellen onverzelde.\n" +
                "Dat is muziek, die heeft met alle dingen\n" +
                "Niets meer gemeen, en alle vreemde zinnen\n" +
                "Zijn blind voor haar, geen vormen en geen kleur\n" +
                "Heeft zij, zij is de lucht gelijk in heur\n" +
                "Afwezigheid voor 't oog en schijnarmoede.\n" +
                "Zij is de liefste, allerliefste, moeden\n" +
                "Die zich moe leefden aan het zien en smaken\n" +
                "Der volle wereld, drinken haar en raken\n" +
                "Haar soms met lippen, willen haar altijd --\n" +
                "Zij geeft van alles hun vergetelheid. \n" +
                "Zielsleven is muziek; dat zijn de volle\n" +
                "Aanzwellingen gevoel, de eeuwig gulle\n" +
                "Uitstroomingen van klank, de volle baden\n" +
                "Kokend in wentelende damp, goudzaden\n" +
                "Van klank, volmaakt, gerond, ronde gewelven,\n" +
                "Bommen van klank, en ook de zoete schelven\n" +
                "Waaiig van licht geluid als stapels hooi.\n" +
                "Sneeuwballen van muziek en uitgedooi\n" +
                "Van klompen ijs smeltend in eigen water,\n" +
                "Vogeltjes van muziek en uitgeschater\n" +
                "Van lachende mannen: elk een heel geheel --\n" +
                "Een volk van klanken waar elk heeft gekweel\n" +
                "Eigen aan zich, een scheepsvloot vn muziek,\n" +
                "elk schip heenvarend op zìjn zeilewiek,\n" +
                "Regen van klank verlatende de lucht,\n" +
                "Een zinged' aarde met één groot gerucht.\n" +
                "Is zij muziek, is wel mijn eigen ziel\n" +
                "Iets wat ooit buiten mij, mijzelven, viel? \n" +
                "Dat alles is het niet, 't zijn woorden niet,\n" +
                "'t Zijn dingen niet, 't zijn klanken niet, geen lied\n" +
                "Verbeeldt de zielsbewegingen genoeg.\n" +
                "Alles is beeld, is beeld van haar, en vroeg\n" +
                "Of laat valt het ineen in stof, zìj blijft,\n" +
                "Wat er ook om haar valt en hene drijft.\n" +
                "Wie dùs mijn ziel is, is zichzelf een God.\n" +
                "Ik ben mijn ziel, ik ben de een'ge God.\n" +
                "Er is nu niets meer dat mijn blindheid heelt,\n" +
                "Mijn God, mijn ziel, naast haar bestaat geen beeld.\n" +
                "'k Word stil en niets bestaat meer dan mijn ziel,\n" +
                "Geen ding, geen woord, en niets dat mij ontviel.\n" +
                "Haar wil ik hebben, heb ik, en niemand\n" +
                "Dan zij, mag met mij wonen in dit land.\n" +
                "Ik wil geen toekomst, geen geheugen hebben,\n" +
                "Zij is altijd gelijk, zìj kent geen ebben\n" +
                "En vloed, zij is eeuwig, alleen, zij is,\n" +
                "Zij leeft door eigene ontvangenis.\n" +
                "Toen stond hij op en Mei zag een blauw waas\n" +
                "Boven zijn hoofd, zijn anschijn blnk, als dwaas\n" +
                "Stond hij, de armen uit, en scheen te drinken.\n" +
                "Zij wist dat hij voor haar niet was en zinken\n" +
                "Begon ze lnagzaam, sneller, en zijn stem\n" +
                "Bleef in haar ooren, dat was al van hem.\n" +
                "Het was de nacht\n" +
                "Toen alle wolken te begraven gingen.\n" +
                "Ik zat waar een rivier ging en er hingen\n" +
                "Treurwilgen over mij, waardoor de wind\n" +
                "Zoet en zoel weende tranen als een kind.\n" +
                "Het was zóó een rivier tusschen twee dijken\n" +
                "Als uit de bergen springt en door de rijken \n" +
                "Van Duitschland en van Holland naar zee gaat.\n" +
                "Het water gonsde, als een overlaat\n" +
                "'s Winters des nachts van water, en een tjalk\n" +
                "Kwam soms den stroom af als een donk're valk\n" +
                "Op 't tweetal vlerken, met karmijnrood licht\n" +
                "Voor op den boeg; die leek een zwart gezicht.\n" +
                "Menschestemmen hoorde ik uit het luik,\n" +
                "Terwijl het schip voortdreef, schuim om den buik.\n" +
                "Ik voelde mij zeer droevig, want ik wist\n" +
                "het droevig lot van Mei en in een mist\n" +
                "Zag ik nog de vergeefsche lange tocht.\n" +
                "En in de lucht klaagde het om me, ik zocht\n" +
                "Naar hare stem maar hoorde die nog niet.\n" +
                "Wel 't vochtig blazen door het jonge riet\n" +
                "En kleine wilge' en berken van den wind,\n" +
                "En 't zoele en zoete weenen, of een kind\n" +
                "Door 't duister liep en zonder klagen schreide.\n" +
                "De takken plaste' in 't water, tusschenbeide\n" +
                "Slokte het water gorgelend, een visch\n" +
                "Gelijkend, zwemmend in de duisternis. \n" +
                "En toen ik toen de oogen opwaarts sloeg,\n" +
                "Denkend, waar zou ze zijn? en ondervroeg\n" +
                "Elk van de wolken voor de hemelen,\n" +
                "--Ze leken op de groote kemelen\n" +
                "Zooals ze door Sahara dravend gaan --\n" +
                "Toen zag ik haar opeens tusschen hen gaan.\n" +
                "Eerst als een starre met een schemerschijn\n" +
                "Mind'rend rondom en toen een uit het klein\n" +
                "Fladdergewiekte volk der vlinderen\n" +
                "En toen als eene uit de kinderen\n" +
                "Die vogels nadoen, hoenders en kalkoenen,\n" +
                "Met de armen vliegende vergeefs, en toen 'n\n" +
                "Lelieëbleeke, weenend, mijne Mei. \n" +
                "Haar bleek voeten trillende tot mij\n" +
                "Kwam ze en zat met mij te zamen aan\n" +
                "Den stroom, terwijl de boomen loofbelaan\n" +
                "Ruischten en rilden als onz' eigen harten.\n" +
                "Het mijne kookte bloed, maar hare smarten\n" +
                "Bevroren haar van binne, en ze zei\n" +
                "Geheel en al niets en zat stil naast mij.\n" +
                "In vochte regen aan dien breeden stroom\n" +
                "En midden in dier droeve boomen droom. \n" +
                "En bij het komen van den rooden morgen,\n" +
                "Toen van het water, uit het loof, de zorgen\n" +
                "Heenvloden en het zonnelicht kwam huizen\n" +
                "Met vogels in de takken en het bruischen\n" +
                "Van golven vroolijk werd, toen zei ze mij\n" +
                "Wat ik al wist, en zei ook rij aan rij\n" +
                "De Balderswoorden, godd'lijk, wonderbaar.\n" +
                "Ik werd een tijd zeer stil en dacht veel, maar\n" +
                "Begreep het niet, want mijne ziel kon niet\n" +
                "Denken wat ze zou zijn, wanneer ze niet\n" +
                "Behoefte had aan oore' en ooge' en wensch\n" +
                "naar anders en naar meer: dat kan geen mensch. \n" +
                "En warmer werd het en de schaduw kwam\n" +
                "Onder de boomen waar wij waren, 'k nam\n" +
                "Haar hand. -- Wij gingen langs de dikke dijken\n" +
                "Waar 't gras langs wuift en soms bleven we kijken\n" +
                "Wanneer een stoomboot ver den stroom opkwam,\n" +
                "Met een sleep schepen, zooals men een ram\n" +
                "Vooraan ziet gaan voor al de tamme schapen.\n" +
                "Ook werd in haar weer wakker wat te slapen\n" +
                "Gegaan was en ze sprong wel naar beneê\n" +
                "En plukte een bloem en stond er droef tevree\n" +
                "Boven te zien en hield ze aan haar borst.\n" +
                "En alle bloemen wilden haren dorst\n" +
                "Toen stillen, en ze trippelden, en kleurig\n" +
                "Vonkte het daar en in de luchten geurig\n" +
                "Ademden ze, wij gingen aldoor voort.\n" +
                "En ook ter zijde af en van den boord\n" +
                "Die weerzijds sluit het breed rivierig water,\n" +
                "En groote velden in en wei, daar staat er\n" +
                "Een hooge boom, een zilverpopulier.\n" +
                "Wij zaten er en hoorden het plezier\n" +
                "Der bladeren -- terwijl de zon hoog klom\n" +
                "En boven onze hoofde' het loover glom. \n" +
                "En koeien loeiden en de boeren kwamen\n" +
                "Te melken en te maaien en de ramen\n" +
                "En deuren kenrsten van een boerderij\n" +
                "En wolken komend vulden met geglij\n" +
                "Van schaduw al de velden en van licht --\n" +
                "De schaduw kwam wanneer het leven zwichtt'. \n" +
                "Arbeiders kwamen ook in de bouwlanden,\n" +
                "En naast elkander zamelden ze de manden\n" +
                "Vol van de donkre aardvrucht en de rij\n" +
                "Gekromde mannen kropen zij aan zij.\n" +
                "Dat alles zagen wij heel ver gebeuren\n" +
                "Terwijl de zon klom en de natte kleuren\n" +
                "Des ochtends drooger werden en opgloorden\n" +
                "Eindlijk van goud en ook de klare woorden\n" +
                "Der bladen boven wij niet meer verstonden. \n" +
                "De stille morgen: òpblaften wachthonden\n" +
                "Toen boeren uit het veld kwamen te schaften.\n" +
                "Ze sprongen aan hun kettingen en blaften.\n" +
                "En maaiers legden zich diep in het gras,\n" +
                "Witte en blauwe hemden in het gras.\n" +
                "De wolken zwierven henen van den hemel,\n" +
                "Boven de aarde was er heet gewemel.\n" +
                "De zon stond roerloos boven uit te schijnen,\n" +
                "De aarde was een warme zee aan 't deinen.\n" +
                "Ik stond toen op en liep in 't weiland rond\n" +
                "Nu voor, dan achter haar, zooals een hond\n" +
                "Nu eens ter zijde en dan voor de kudde.\n" +
                "En telkens keek ik -- en de bladen schudden\n" +
                "Het zonlicht boven haar, zij klein en rood\n" +
                "Zat stil en zag mij niet, haar oogen bloot\n" +
                "Flikkerden door haar tranen kleine stralen.\n" +
                "Ik liep dan voort en waar het eiland dalen\n" +
                "Ging naar een sloot, sleepte ik mijne voeten.\n" +
                "Er stonden bloemen die door het ontmoeten\n" +
                "Met mijne voeten schommelden, ik ging\n" +
                "Boven ze langzaam en mijn zwaar hoofd hing.\n" +
                "Er stond een vrouw tusschen de voorste struiken\n" +
                "Van een licht kreupelboschje, en de sluike\n" +
                "Willegetakken stonden om haar toe.\n" +
                "Ik kende haar wel, en zij mij, en toe\n" +
                "Lachten we flauw elkaâr, het was die vrouw\n" +
                "Die vroeger Mei ontmoet had en geen rouw\n" +
                "Had willen brengen om haar blijde oogen.\n" +
                "Zij hief den arm op en hield zoo lang haar hooge\n" +
                "Houding, ze wees naar Mei en zeide toen:\n" +
                "''Weent zìj nu ook, in deze zonnenoen?''\n" +
                "En dichter kwam ik bij haar, en zei haar\n" +
                "Het lot van Mei, zij hield haar arm op waar\n" +
                "Ze haar gewezen had -- zoo'n pijn had ze.\n" +
                "Hoorde en ademde en mompelde\n" +
                "Zelf zìjnen naam toen ik gesproken had.\n" +
                "En zwijgend stonden we bijeen, ze had\n" +
                "Aldoor haar arm nog uit -- hoog boven mij.\n" +
                "Wij beiden zagen haar, ver, van ter zij,\n" +
                "Onder den boom en eindlijk zeide zij:\n" +
                "''Balder en Mei, dat was een schoone droom.\n" +
                "Als dat geworden was, dan konden loom\n" +
                "Wij allen nederzitten en wel sterven\n" +
                "Alle demonen; en wie dan beërven \n" +
                "De aarde zou...maar dit is niet geweest.\n" +
                "Zij zit daar weer alleen -- even verweesd\n" +
                "Als alle vrouwen zaten op de aarde,\n" +
                "Die hem eens hoorden en in 't oor bewaarden\n" +
                "Zijn stem -- ik hoorde hem, ook ik ben bleek,\n" +
                "Als water is, beneê den mist, der beek.''\n" +
                "Ik rilde van een kouden lentewind,\n" +
                "We stonden nog en keken naar het kind.\n" +
                "Zij ging toen heen, de wilgetakken bogen\n" +
                "Zich om haar, 't hoofd ging boven het bewogen.\n" +
                "Haàr oogen gloeiden toen ik tot haar keerde\n" +
                "Mijn oogen en ik zag dat zij begeerde\n" +
                "Kussen en teere vingeren, zij brandde\n" +
                "Den hemel met haar oogen en de landen.\n" +
                "Gloeiende tranen vulden toen haar oogen\n" +
                "En zij bewoog zich niet ze af te drogen. \n" +
                "Later werd het en ook koeler toen,\n" +
                "De wei met schaduwen en zich opdoen\n" +
                "Van lichte nevel. En wij gingen heen,\n" +
                "Al stil rondom wijl de zon lager scheen.\n" +
                "Wij zagen toen den stroom ook weer terug,\n" +
                "Waar 't water schitterde, waarover vlug\n" +
                "De vogels trokken twee aan twee naar huis,\n" +
                "Zij liep met mij, niet ver was meer de stad,\n" +
                "Langzaam donkerder werd het om ons pad.\n" +
                "Der boomen stammen eerst en toen het loover,\n" +
                "Langer gekleurd en rood, maar ook daarover\n" +
                "Sloegen de golven duister en de lucht\n" +
                "Alleen bleef ademen een purpren zucht,\n" +
                "En geele glorie wellen in een glans\n" +
                "Den halven hemel groot, een schellepkrans,\n" +
                "Daartegenover dansten als fantomen\n" +
                "Roode verschijningen op hemelzoomen. \n" +
                "Toen zagen wij voor ons de poort der stad\n" +
                "En toren en daklijnen voor de mat-\n" +
                "Goude verlichting van de breede zee\n" +
                "Des hemels. Muren waren aan de twee \n" +
                "Zijden der poort, waarbinnen wij nu gingen.\n" +
                "En echo's vingen daar wel aan te zingen\n" +
                "Van mijner voeten klank, van hare niet.\n" +
                "De avond was daarbinnen, in 't verschiet\n" +
                "Van straat en gracht hing om het blauwe duister\n" +
                "De schemering en in de huizen huist er \n" +
                "De nacht al of de lampen nog niet brandden.\n" +
                "De straten waren stil, maar aan haar wanden\n" +
                "Waar glazen waren, zat een enkle vrouw,\n" +
                "Een oude hier, een jonge daar, in schauw\n" +
                "Der kamer naar de lichtre straat te zien.\n" +
                "Eens hoorden ik en zij het melodieën\n" +
                "Achter uit huis van snaren van een veel,\n" +
                "Eens uit een tuin het heldere gekweel\n" +
                "Van lijstervink, die zat gekooid gevangen.\n" +
                "En zwarte menschen liepen met verlangen\n" +
                "Naar huis als moede beesten en de linden\n" +
                "Stonden aan grachten droomerig, gezwinde\n" +
                "Rillingen voeren soms door boomkruinen,\n" +
                "Wanneer een lichte wind kwam tuimelen. \n" +
                "Mijn huis was op den stadsmuur opgebouwd,\n" +
                "Ik deed het open en wat binnen rouwde,\n" +
                "De duisternis, werd licht toen zij intrad.\n" +
                "Het was zooals juweel uit een kroonschat\n" +
                "Die uitbeleend wordt in een donkre wijk\n" +
                "En in het huis ligt van een Jood en rijk\n" +
                "Dat duister maakt met gloed en flikkering.\n" +
                "Zoo was zij daar, de kamerzoldering\n" +
                "Schemerde en de donkre hoeken grijnsden.\n" +
                "Hoog was die kamer in het huis, er deinsden\n" +
                "Boomen beneden aan de lage straat.\n" +
                "Het raam was open en zij had 't gelaat\n" +
                "Naar buiten waar de zwarte daken waren\n" +
                "Als doodskisten gezet op hooge baren\n" +
                "Voor de begrafenis in zwarten grond.\n" +
                "Een enkel lichtje brandde in het rond\n" +
                "En schimmen sprongen langs verlichte ramen.\n" +
                "Een toren stond niet ver af met de namen\n" +
                "Der twalef uren op de wijzerplaat\n" +
                "Flauw zichtbaar, en beneden in de straat\n" +
                "Hoorde ze mannen spreken met elkander.\n" +
                "Een flauwe reukbeladen wind, als brandd' er \n" +
                "Heel ver af wierook ergens in een schaal,\n" +
                "Gestold uit bloemenat en dauw, woei vaal\n" +
                "Voorbij en bij ons in, en de rivier\n" +
                "Gonsde en ronkte niet ver als een dier.\n" +
                "Ik hoord' en zag het ook wel, duizelde\n" +
                "Mijn hart niet zoo in mij en suizelden\n" +
                "Mijn ooren niet en sloten mijne oogen\n" +
                "Niet bijna toe. Ik dacht niet, er bewogen\n" +
                "Nieuwe zinnen in mij, terwijl ik zat\n" +
                "Ver in het duister en mijn handen nat\n" +
                "Waren van angst om haar gestalte, daar\n" +
                "Ze stond zooals ik voor het eerst zag waar\n" +
                "De wilgen blauw waren voorbij den stroom. --\n" +
                "Toen zagen wij te zamen uit, een droom\n" +
                "Leek 't zwarte stadje daar voor ons te droomen\n" +
                "Met al zijn lichten uit, een man wien loome\n" +
                "leden geleiden naar zijn leger, dan\n" +
                "Droomen bezoeken, een dof droomend man.\n" +
                "En ook ik legde mij toen neer te slapen\n" +
                "Maar sliep niet, en zag haar, en dikke schapen\n" +
                "Van wolken langs den hemel door het raam,\n" +
                "--En haar zag ik -- en zij liepen te zaam\n" +
                "Omhoog, ik zag ze een voor een verdwijnen.\n" +
                "De maan scheen, maar ik zag haar niet, wel 't schijnen\n" +
                "Der sterren en toen ook hun tragen gang\n" +
                "Over het huis heen, moeielijk -- en bang\n" +
                "Bleef ik van hart, zij doodstil aan het venster.\n" +
                "Alles was donker en de stilte wenscht' er\n" +
                "Klanken en woordgeraas, en aamde zwaar\n" +
                "Van haar naar mij, van mij tot haar, een schaar\n" +
                "Van lange zuchte' in hangende gewaden.\n" +
                "terwijl de stilte peinsde om te raden\n" +
                "Geluid dat komen zou, terwijl ze ried\n" +
                "En peinsde nog en luisterde, een lied\n" +
                "Speelde daar al en floot een nachtegaal.\n" +
                "Het werd geboren uit de stilte, taal\n" +
                "Van stilte zelf, alsof het zwijgen sprak,\n" +
                "Onmerkbaar overgaand in spraak die brak. \n" +
                "Haar bracht te zwijgen ander klokkespel,\n" +
                "gezongen van den toren, door één schel\n" +
                "En toen nog vele andre van metaal.\n" +
                "Een boom van klokken en een kort verhaal\n" +
                "Van de oude toren, met zijn jonge stem.\n" +
                "En Mei keek naar hem op en hoorde hem.\n" +
                "Toen kwam ze binnen en sloot toe het raam\n" +
                "En lichtte door de kamer, handen saam\n" +
                "Hield ze, en liep een tijd lang heen en weder.\n" +
                "En stond toen stil en zat en legde neder\n" +
                "Zichzelve naast me, naar me toe gewend.\n" +
                "En haar nabijzijn maakte als een tent\n" +
                "Over mij heen van veiligheid en schemer.\n" +
                "Voor mij zag ik twee vlammen en gewemer\n" +
                "Voelde ik om mij van dier vlammen licht.\n" +
                "haar oogen blonken, van haar aangezicht\n" +
                "Woeien naar mij, op mij, haar ademen\n" +
                "Met breede armen en omvademen\n" +
                "Kwamen zij mij mijn wangen en mijn hoofd.\n" +
                "En voller kwamen ze en loeide' en loofde'\n" +
                "Hun koelte en laafden mij, en een diep water\n" +
                "Maakten ze dompelend, als stroomen water,\n" +
                "Gesmolten en gezwollen door een lent',\n" +
                "Die hare winden naar de bergen zendt.\n" +
                "Daarin verzonk ik en mijn lijf verdronk\n" +
                "In ademen van slaap en ooggelonk.\n" +
                "En zij lag heel stil, als soldaat op wacht,\n" +
                "De voorste voorpost, luis'rend in den nacht\n" +
                "Of hij den vijand hoort, hij denkt aan huis,\n" +
                "Aan veel wat ver is, hoort toch elk gedruisch\n" +
                "Met erg en argwaan breken door den nacht.\n" +
                "Eerst vlogen wel langs 't raam op veereschacht,\n" +
                "Eén veer droeg hen gemakkelijk, lichtelven,\n" +
                "En stonden toen er voor en in zich zelve\n" +
                "Peinsden ze lang en praatten niets, één zei\n" +
                "Toen eind'lijk iets, ze lachten toen voorbij. \n" +
                "Wel kwam een jonkvrouw aan: dat was haar zuster,\n" +
                "En keek op haar, bij 't raam staand' en ze kust'er\n" +
                "aar vingers voor, hoewel ze d'oogen wischte --\n" +
                "Juni, een lichter licht rondom haar mistte. -- \n" +
                "Maar onderwijl sloeg binnen haar een trom\n" +
                "Een doodsroffel -- zoo gaan soldaten om\n" +
                "Voor 't laatst met dooden makker eer hij ligt\n" +
                "Onder de aard', verborgen voor het licht.\n" +
                "Ze voelde het begin van kouden dood\n" +
                "In zich en 't was of stierven in haar schoot\n" +
                "De kinderen van wenschen en verlangen.\n" +
                "Ze lag naar boven en ze liet de lange\n" +
                "Lokken ter neer vallen ter legersteê.\n" +
                "Haar boezem ging met adem, adem, mee,\n" +
                "Haar bloote, bleeke voeten blonken in\n" +
                "De schaduw heel ver weg en om haar kin\n" +
                "Lichtte een blauwe ademing van vlam,\n" +
                "Haar handen lagen naast elkander, klam\n" +
                "En fijn gevingerd op 't geweven kleed.\n" +
                "En aldoor was 't of binnen haar omschreed,\n" +
                "Zooals een wind die omgaat 's avonds laat,\n" +
                "Zooals een kind dat 't oude huis rondgaat\n" +
                "Voor hij 't verlaat en nog wat speelgoed ziet,\n" +
                "En er mee staan blijft: 't is zoo groot verdriet. \n" +
                "En 't werd in haar zooals een woud in winter\n" +
                "In vreeselijken winter, als de wind er\n" +
                "Vergeefs blaast en de stijve stamme' en takken\n" +
                "Zich harden ruw en op de open vakken\n" +
                "Bevroren gras, als steen staan en de maan\n" +
                "Zijn straal als ijs stort in de boomenpaan. \n" +
                "Zij huiverde en deed mij zoo ontwaken:\n" +
                "Zij leek een bloem, die onder het sneeuwlaken\n" +
                "Kou lijdt, niet slapen kan van kou en sneeuw.\n" +
                "Of als een vogel, sneeuwwitte zeemeeuw\n" +
                "Met roode pooten -- 'k leunde op mijn arm\n" +
                "En ademde op haar en weder warm\n" +
                "Werd ze als immer, zij een bloedebloem --\n" +
                "En toen maakte ik mijn adem tot den roem\n" +
                "Van adem, golfjes klank, veeren van klank,\n" +
                "En zong een liedj' en zweeg, ze zei haar dank\n" +
                "Nog niet, want òp zat ze en zag mij aan\n" +
                "En zei als wou ze in haar stem vergaan:\n" +
                "''Gij zijt als hij, als hij, in uwe stem.''\n" +
                "En toen kuste ze mij, maar kuste hem\n" +
                "Op mìjnen mond, en toen op mijne oogen,\n" +
                "Maar hare oogen waarden in den hooge. \n" +
                "Toen werd het weder morgen en het pruilen\n" +
                "Der schemering begoon en toen het huieln\n" +
                "Van grijze tranen licht, en ongedegen\n" +
                "Zilveren druppe', een parelmoeren regen.\n" +
                "En eindelijk daar waren àl de stralen\n" +
                "Der zon, die 's morgens wonderen verhalen,\n" +
                "Splinternieuwe en van fijn goud zijn.\n" +
                "En wij herlefden in der kleuren schijn\n" +
                "En stonden en wij zagen weer elkaar,\n" +
                "Zij mij, ik haar in 't goud van 't hangend haar. \n" +
                "Toen zei ze vele zoete woordekens,\n" +
                "Een vogel 's morgens, 'k had maar &eaute;énen wensch,\n" +
                "Dat zij daar blijven kon met haren mond\n" +
                "Waarom zich 't ranken van bloemwoorden wond.\n" +
                "En onderwijl stonden wij uit te zien\n" +
                "Naar 't gouden blauw en naar het vlugge vliên\n" +
                "Der stralen op en over blauwe daken.\n" +
                "De lucht werd door het licht verguld, te blaken\n" +
                "Stond op den kerktoren de gulde haan,\n" +
                "En hier en daar fladderde een windvaan\n" +
                "Nog wispelturig op onstagen wind.\n" +
                "Heel ver weg vloog en blonk het stroomelint\n" +
                "Wimpelend door de weiden, waar de ossen\n" +
                "Rustig in stonden en de wilgen losse\n" +
                "Takken bewogen en de blaân als vlaggen.\n" +
                "Klare meerplassen lagen er te lachen\n" +
                "En schaterden van zon, de overstrooming\n" +
                "Had ze daar nagelaten en de koning\n" +
                "Der zomerzon ze nog niet opgedroogd.\n" +
                "Het stadje lag met wallen opgehoogd,\n" +
                "Daar vlogen onze blikken in als duiven\n" +
                "Na het omvliegen in hun til, en wuiven,\n" +
                "Wuivelen zagen wij de buitenblaân\n" +
                "Der boomen, binnen groen licht, onderaan\n" +
                "Een enk'le stam de grijz' en geele steenen,\n" +
                "En in de gracht een trekschuit schuivend henen,\n" +
                "Toen vroeg ze mij te zien der menschen stad,\n" +
                "Wat die voor werke' en wezens in zich had. \n" +
                "Daar was een klein plein aan de watergracht\n" +
                "En boombeplant, vol schaduw en aandacht\n" +
                "Van dunne gouden zonnestralen, die\n" +
                "Door olmebladen kwamen met gespie\n" +
                "Nieuwsgierig, waar de hoenderen in blonken\n" +
                "Goudbruin op zwarte aard, de haan te pronken\n" +
                "Zijn dos opschudde en zijn rooden kam.\n" +
                "Een geele wipbrug lag daar en er kwam\n" +
                "Een trekschuit doorglijden vuurrood van kiel.\n" +
                "Het water rimpelde, de vuurkleur viel\n" +
                "Bibb'rend tot aan den oever in 't gekabbel:\n" +
                "Tegen de schoeiing klonk het nat gebabbel.\n" +
                "Nog was het stil, wij zaten toe te zien\n" +
                "Bij een straathoek: er kwamen meerdre liên,\n" +
                "Een vrouw naar buiten, strooiende geel graan,\n" +
                "De hoenders kakelden en vlogen aan\n" +
                "En aten gulzig -- en toen ging er open\n" +
                "Een deur en kwam een jongen uitgeloopen.\n" +
                "Stil werd het toen een poos, het zonlicht klom,\n" +
                "Over de gevels schijnend hel en stom. \n" +
                "Een werkplaats lag er aan dat kleine plein,\n" +
                "De dag was aangegroeid in zonneschijn --\n" +
                "Die was vol koelte en van donker hout\n" +
                "Bevloerd en ook gezolderd en zeer oud\n" +
                "Leken de ramen, waar looflicht door scheen\n" +
                "Door de olmen buiten, en daar kwamen heen\n" +
                "Oude en grijze mannen om te werken.\n" +
                "Er lagen houtstapels: de eikesterken\n" +
                "En 't spleet'ge vurenhout van uit het noorden.\n" +
                "De werklui namen het en zonder woorden\n" +
                "Schaafden en klopten ze met timmering,\n" +
                "Bedrijving in de groene schemering. \n" +
                "En nog een andre was er aan dien kant,\n" +
                "Ook donker: en er voor lag het vol want\n" +
                "En touwwerk en scheepstuig, de houten blokken\n" +
                "En ankerkettingen en rondgetrokken\n" +
                "GEstapeld henneptouw, er binnen zaten\n" +
                "De oude zeilmakers, hun gelaten\n" +
                "Dicht op de naald, in 't wit, voor hen het zeil.\n" +
                "Wij stonden er en keken toe een wijl. \n" +
                "Wij gingen verder terwijl heel de stad\n" +
                "Onder de zon kwam en er als een bad\n" +
                "Zonlicht in omviel, dat de trappengevels\n" +
                "Van rooded steenen droogden en de nevels\n" +
                "Van glans die 's morgens vroeg overal is\n" +
                "Dampten: het overschot nachtdroefenis. \n" +
                "En door de straten zagen wij naar buiten\n" +
                "En door de poorten, die zooals de ruiten\n" +
                "Zijn in het huis: daar vloog de buitenwind,\n" +
                "Laaide het vlammend licht en staarden blind\n" +
                "De plassen zich, de sloten, de rivier.\n" +
                "Daar kwam een groote wagen: het trekdier\n" +
                "Stapte en trok, verstoppende de poort.\n" +
                "Hier een troep schapen, en ze liepen voort\n" +
                "Dat vachten wolzij schommelden, een ruiter,\n" +
                "Een boer te paard kwam aandraven, het tuitt' er\n" +
                "Van flikkering en jongens schreeuwden dol\n" +
                "En vochten op hun klompe', een kroeg liep vol. \n" +
                "De buurten in die aan den stadswal zijn,\n" +
                "De daken waren laag, de deuren klein,\n" +
                "Gras in de straten, mannen niet tehuis.\n" +
                "Alleen de vrouwen, luist'rend naar 't geruisch\n" +
                "In 't huis van vliegevleugels, naar 't gestap\n" +
                "Van voeten op de straat, en naar 't geklap\n" +
                "Der buredeuren. 't Sling'ren van een pomp\n" +
                "Hoorden wij wel en zagen soms den romp\n" +
                "Van een oud vrouwtje, die het natte linnen\n" +
                "Te droogen legde op de heg, en binnen\n" +
                "In huis schreide soms een zuigeling. --\n" +
                "Lang zaten wij daar op den breeden ring,\n" +
                "Den stadsmuur, waar de kamperfoelie klom\n" +
                "Omhoog met wingerden, klawieren krom\n" +
                "Kropen de muur over, de gracht benee\n" +
                "Was als een schor nat, van de Zeeuwsche zee. \n" +
                "En daar ook deed ze mij verscheide vragen,\n" +
                "Vragen hoog klimmende in fijne wagen\n" +
                "Van hare stem als tegen heuvels op:\n" +
                "We spraken lang, terwijl we van den top\n" +
                "Der kerketoren telkens de uren hoorden.\n" +
                "Nooit waren tonen zoet als die ik hoorde\n" +
                "Suizelen van haar mond, de lucht inklimmen:\n" +
                "Voor mìj omneveling van alle kimmen\n" +
                "Met tranendampen, en een wereldgroot\n" +
                "Gevoel in mij. Ze sprak me van haar dood. \n" +
                "Wij keerden ook weer in de stad terug --\n" +
                "De zon week uit de straten al terug\n" +
                "En was veel lager aan de Westerkant.\n" +
                "De straten waren stil en aan den band\n" +
                "Der effen grachten lagen stil de schuiten.\n" +
                "De steenen werden paarser om de ruiten\n" +
                "Die zelf ook blauw besloegen, het gordijn\n" +
                "Ging hooger in de ramen van 't kozijn.\n" +
                "Toen werd het zonlicht west'lijk weggedragen\n" +
                "Zooals een Oostersch heer, die op zijn wagen\n" +
                "Lang omgereden heeft door zijne stad,\n" +
                "En nu 't paleis genaakt. 't Gelaat is mat\n" +
                "En lichtgeel en lichtgoud onder den waaier.\n" +
                "Zoo ging de groote zon heen met gelaaier\n" +
                "Van licht rondom zich, in een palankijn\n" +
                "Van gloed karmijn, fluweel zoo rood als wijn. \n" +
                "En groepen vrouwen kwamen op de straat\n" +
                "Bijeen, die troosten 't leven met gepraat,\n" +
                "Haar moeilijk leve', en grijsaards die het laat\n" +
                "Leven het meest genoten zaten stil\n" +
                "Dicht onder huis op stoep, door hunnen bril\n" +
                "Rustig de mensche' en dingen aan te zien.\n" +
                "Een steiger stond nog voor een huis, van dien\n" +
                "Kwamen de mets'laars klimmen in een rij.\n" +
                "Een jong man met blond haar was ook daarbij,\n" +
                "Die bleef nog staan heel boven op den steiger,\n" +
                "Zooals men ziet in 't woud den blauwen reiger\n" +
                "In 't topje van den boom staan -- hij keek rond\n" +
                "Naar den roodgeeln en zwarten dagavond\n" +
                "En lachte in den avond, en een lied\n" +
                "Neuriënd dalend, wist hij 't zelve niet. \n" +
                "De nacht kwam weer, schoon lampen nog niet brandden.\n" +
                "De straten werden stil, maar aan de wanden\n" +
                "Waar glazen waren, bleef een enkle vrouw --\n" +
                "Een oude hier, een jonge daar, in schauw\n" +
                "Der donkre kamer naar de straat te zien.\n" +
                "Eens hoorden ik en zij het melodieën \n" +
                "Achter het huis van snaren van een veel,\n" +
                "Eens uit een gang het heldere gekweel\n" +
                "Van lijstervink, die zat gekooid gevangen.\n" +
                "En zwarte mannen kwamen met verlangen\n" +
                "Naar huis als moede beesten en de linden\n" +
                "Stonden aan grachten zwaar van slaap, gezwinde\n" +
                "Rillingen voeren over het grachtwater,\n" +
                "Wanneer de wind zich neerlag op het water. \n" +
                "Toen dan de nacht er was, de zwartgehande,\n" +
                "De zwartgeborene die tot een schande\n" +
                "Der aarde is, beklommen wij het huis.\n" +
                "En in dien nacht zaten wij samen thuis\n" +
                "En sliepen niet en droomden niet, de zangen\n" +
                "Van slaap en dood die zongen we, die wangen\n" +
                "Verbleeken en benauwen in de keel.\n" +
                "hartstochtelijke stem. Voor mij, bleekgeel\n" +
                "Zat Mei weer en haar mond stond altijd open\n" +
                "En liet de klanken door, die als bij hoopen\n" +
                "Mannen en vrouwen bij begrafenis\n" +
                "Uitliepen, op een dag van droefenis.\n" +
                "Zoo zong ze soms alleen en soms wij samen\n" +
                "Als sombere bedroefde koren, namen\n" +
                "Van vele dingen die ze had aanschouwd.\n" +
                "beefden nu weer van hare tong, berouwd\n" +
                "Door klaaglijk lied, eentonig lang getreur,\n" +
                "Heel soms een blijde noot, wanneer ze heur\n" +
                "Oogen deed lichten, en haar hoofd een baken\n" +
                "Gelijk werd, en haar armen vooruit staken.\n" +
                "Maar dan zonk ze terug in droefenis,\n" +
                "Met hare armen en de duisternis\n" +
                "Die trilt voor de oogen en als blindheid is.\n" +
                "Wij hoorden buiten niets, zooals een graf\n" +
                "Was mijne kamer, dat ligt heel ver af\n" +
                "Van aller menschen schreden in den schoot\n" +
                "Der warme woestenij, en 's avonds rood\n" +
                "En 's morgens rood schouwen er over heen --\n" +
                "Zoo schouwden ook de oogen van ons tweeën.\n" +
                "En zoo kwam eindelijk de laatste dag,\n" +
                "Brandstapel van een dag, het fel gelach\n" +
                "Der vlammen om het arme brandend hout.\n" +
                "Toen het nog schemerde en 't om ons koud\n" +
                "Van morgenlicht werd, kwam ze dichter bij me,\n" +
                "En knielde aan mijn knieën en ze lei me\n" +
                "Het hoofd zoo zwaar van haar daar neer en toen,\n" +
                "Terwijl mijn hand op hare lokken was, een zoen\n" +
                "Kuste ik op het blonde haar, bleef zij\n" +
                "Zwijgen aldoor en eerst zonder geschrei,\n" +
                "Zooals een kind, maar 'k voelde adem schokken\n" +
                "En branden uit haar mond. En toen als vlokken\n" +
                "Van sneeuw zoo langzaam, dreven groote tranen\n" +
                "Haar wangen af, -- En zooals 's avonds 't tanen\n" +
                "Van 't zonlicht is, zoo zag ik nu uit haar\n" +
                "Veel licht verscheiden -- zij, als een altaar\n" +
                "Waar 't vuur maar flauw brandt in den donkren nacht,\n" +
                "Bleef over, maar waar één vonk gloeit en wacht. \n" +
                "En toen zij opstond, stond ik ook naast haar --\n" +
                "Nog fonkelde zij voor mij van heur haar\n" +
                "En van haar oogen -- lei ze nog haar hoofd\n" +
                "Dicht aan het mijne en ik zag gedoofd\n" +
                "Worden haar oogen weder door haar tranen,\n" +
                "En de armen om mij, zooals van de mane\n" +
                "De armen zijn, zoo fijn en ook zoo licht.\n" +
                "Zoo bracht ze ook haar droeve aangezicht\n" +
                "Dicht aan het mijne en bleef heel lang staan,\n" +
                "D'oogen in mijne, mijn hart ging vergaan.\n" +
                "Toen ging ze heen, terwijl haar mond niet sprak,\n" +
                "Achterwaarts heen, ik zag haar in het vak\n" +
                "Der deur staan, met de ooge' aldoor op mij.\n" +
                "Toen ging ze heen en was ik zonder Mei. \n" +
                "En toen ze kwam in 't licht en dronken buiten,\n" +
                "Bedronken door den nacht, en dat te muiten\n" +
                "Des morgens slaat uit duister en zich kiest\n" +
                "Een opperhoofd: de zon, en zich verliest\n" +
                "Voor hem en voor zijn glans, waarin het valt\n" +
                "En sterft en opgaat na den doodstweespalt\n" +
                "Met duisternis, die òòk sneeft: Daar bleef hij\n" +
                "Met al zijn schijn alleen en trotsch en blij. \n" +
                "En droevig eenzaam kwam zij in dien dag.\n" +
                "De boomen maakten in hun loof gewag\n" +
                "Van morgenwinden en de jonge vogels\n" +
                "Zaten er op de wallen of als kogels\n" +
                "Vlogen ze van een tak boven den muur.\n" +
                "De klokken sloegen een vroeg morgenuur,\n" +
                "En droomerig en droevig gleed ze voort,\n" +
                "De poorte uit, een dijk langs en het boord\n" +
                "Des grooten strooms die met zijn water vocht.\n" +
                "Ze dacht aan mij en hoe ik wezen mocht\n" +
                "Nu zonder haar en of ik eene lief\n" +
                "Spoedig zou vinden, die ik even lief\n" +
                "Zou hebben als ik haar wel had gehad.\n" +
                "Toen dacht ze aan den dood en keek naar wat\n" +
                "Dood in het gras kon zijn, maar dat was niet\n" +
                "De dood noch droefheid. Want het leven schiet\n" +
                "In lente ied're bloem en ieder kruid\n" +
                "Vol krach en glans, en recht de aarde uit. --\n" +
                "En zoo werd droevig hare laatste dag. \n" +
                "Maar zon, haar vader, ving toen met een lach\n" +
                "Een nieuwer glanzen aan en toen terstond\n" +
                "Wikkelde hij het louterst licht daar rond,\n" +
                "Dat zamelend wat anders van zijn kussen\n" +
                "Het beste van de aarde ten deel valt, tusschen\n" +
                "De bergen reinen meren, berg van sneeuw\n" +
                "Ons onbereikbaar, en in ééne eeuw\n" +
                "Misschien het aanzicht van een enkel mensch.\n" +
                "Dat zag ze, en ze voelde in zich wensch\n" +
                "En toen ook werk'lijkheid van zoo te zijn,\n" +
                "Zoo koel als 't goud, zoo koel als 't kind dat klein\n" +
                "Nog is en tusschen vreugd en droefheid leeft.\n" +
                "Zoo werd ze en de rijke zon omweefd'\n" +
                "Eén sluier na de andre om haar oogen.\n" +
                "Eén horizon verdween na de ander, hooge\n" +
                "Blauwende hemel en van zeer nabij\n" +
                "Had boom en loover een verguld kleedij.\n" +
                "Alles was ééne kleur, alles gelijk,\n" +
                "Zij zelve voelde in zich even rijk\n" +
                "Als wie voor goed alleen is en niets kan\n" +
                "Nu meer verliezen of verkwisten dan\n" +
                "Alleen zìjn leven en zijn eigen zelf.\n" +
                "En in dat godsgeschenk, dat goudgewelf\n" +
                "Liep ze al voort en voort, het schoof met haar,\n" +
                "Zij zelf het goudst daarin, het gouden haar\n" +
                "Een korenschoof rondom haar waar de aren\n" +
                "Uit neerhangen en zich de schoof omscharen.\n" +
                "Toen kwam ze -- o ik weet wel waar het was,\n" +
                "Het was in 't jongste ongereptste gras\n" +
                "Tusschen vier eiken die hun roode blaan,\n" +
                "Nog rood hadden van 't lentebloed, te schaân\n" +
                "Door niets, maar wel door 't morgenlicht te kussen,\n" +
                "En dan aan 't trillen en elkaar te sussen.\n" +
                "En vol van haren gloed werd die kapel,\n" +
                "De onderzij der bladen glommen schel,\n" +
                "Blauw was de hemel tusschen 't groene loof,\n" +
                "Het roerloos loof, de wind was stil en doof. \n" +
                "Dat was der aarde heiligst heiligdom,\n" +
                "Zij stond er: alles recht en niets meer krom,\n" +
                "haar hals niet en haar knie niet, zonder zorgen.\n" +
                "Zoo stond zij op dien laatsten dag, dien morgen\n" +
                "Het schoonst, het guldenst wat op aarde is.\n" +
                "Zij dacht no veel, maar tot bekentenis\n" +
                "Kwam niets meer in haar kalmte: één gevoel\n" +
                "Hield 't roode bloed en 't blanke lichaam koel. \n" +
                "Zóó als op zomermorgen binnenzeilen\n" +
                "De groote zee een schip komt, zwaar met zeilen,\n" +
                "Maar licht zich heffend op der golven vloed,\n" +
                "Het hoofd in 't reine, in het schuim de voet,\n" +
                "Zooals de bark die zomermorgens komt,\n" +
                "Zichtbaar uit duisternis, van nacht ontmomd,\n" +
                "Zichzelve sieren met de gouden wimpels,\n" +
                "De zonnestralen aan den mast en rimpels\n" +
                "Ook wimpelend van goud voor om den boeg -- \n" +
                "Zóó als een bloem van zomerrood, papaver,\n" +
                "Rustig vol staat, midden in gedaver\n" +
                "Van zonnevuur dat valt den grond in stuk\n" +
                "En smoort en schroeit het gras: maar zijn geluk\n" +
                "Blijft even groot: hij laat zijn roode vaan\n" +
                "Wapp'ren op wind of in de zon stilstaan --\n" +
                "Zóó stond ze in het grootst en stilst genot,\n" +
                "Het onbegrepen', in den gloed van God\n" +
                "Den Vader, en hield recht het hoofd omhoog,\n" +
                "Haar armen stil, terwijl niets òverwoog.\n" +
                "En teer begon het hoofd over te neigen\n" +
                "Toen 't volste uur gevuld was, en te zijgen\n" +
                "De wimpers droom'rig neer, heel langzaam aan.\n" +
                "En teeder bleeker werd ze, af en aan\n" +
                "Voer bleek en rood op hare moede handen.\n" +
                "Nevel van goud week uit, uitzettend wanden\n" +
                "En walleschansen licht en medenemend\n" +
                "Al wat niet gansch'lijk rein was en heenzwemend\n" +
                "Met levend' elven dat het heiligdom\n" +
                "Alleen voor haar zou blijven, als een kom,\n" +
                "Een klare vijver waar heel niets in drijve\n" +
                "Dan ééne zwaan en die nog roerloos blijve. \n" +
                "En rondom werd het schaduwlooze gras\n" +
                "Besprenkt met vonken als een waterplas,\n" +
                "Zooals de groote meeren van de zee\n" +
                "Wanneer de zon staat in de middagstee. \n" +
                "Zóó als een zonverlichte groote toren\n" +
                "Dien blok op blokken metselsteenen schoren,\n" +
                "Omhoog is 't fijn graniet en schijnt de zon,\n" +
                "De avond komt en van den horizon\n" +
                "Komen de stralen, hij wordt donker ouder\n" +
                "En van zijn voeten tot den hoogen schouder\n" +
                "Is hij vol schaduwen en ouderdom -- \n" +
                "Zóó als een eik die op de bergen krom\n" +
                "Boog van de vlammen waar hij zich verbrandt,\n" +
                "Bliksemgetroffen, 't kleinste takje brandt:\n" +
                "Een huis van vuur geleek hij op de hoogte.\n" +
                "Een donkre regen viel en doofde, boog te\n" +
                "Vallen den zwartenden verkoolden stam,\n" +
                "Op enk'le rakken danst nog weinig vlam -- \n" +
                "Zóó als die bloem van zomerrood, papaver,\n" +
                "Rimpelt zijn rood, verwelkend, en zijn staaf er\n" +
                "Zijn teeren stengel langzaam buigt omlaag --\n" +
                "Zoo boog ook Mei langzaam haar hoofd omlaag\n" +
                "En bleek en bleeker werden hare wangen,\n" +
                "En flauw en flauwere werd ook het verlangen\n" +
                "Dat in de oogen brandt der sterveling.\n" +
                "Al verder en al verder week de kring,\n" +
                "De wollige band van vuur, zooals de ruiters\n" +
                "Die uitrijden uiteen en op de muiters\n" +
                "Een aanval doen: ze maken 't heel ver stil.\n" +
                "En in zich voelde zij het laatste: wil\n" +
                "Den allerlaatsten wil der stervenden,\n" +
                "Den wil tot doodzijn die het zwervende\n" +
                "Menschengeslacht doet stilstaan en hen drijft\n" +
                "Van zelve naar den grond waar 't lichaam blijft.\n" +
                "Ze duizelde en in die duizeling\n" +
                "Werd ze zoo licht, een veer die uit den zwing\n" +
                "Der duive valt: ze daalde en viel niet:\n" +
                "Zoo valt een riethalm over in den vliet. \n" +
                "Zóó als een kind dat in het leven was,\n" +
                "Zóó a;s een bloem van zomerrood in 't gras,\n" +
                "Roode papaver die nu neder ligt,\n" +
                "Zoo lag ze en der zonne laatste licht\n" +
                "Scheen op haar, maakte haar een weinig rood\n" +
                "En goud voor 't laatst -- en ging toen met haar dood. \n" +
                "De maan kwam toen ze daar gestorven was\n" +
                "En kwam over de aarde, uit het gras\n" +
                "Nam ze en beurde het doodkoel lichaam.\n" +
                "Wat was er over van haar warmen naam?\n" +
                "En zoo met blauw licht om zich, en gelaat\n" +
                "Van dreofheid grauw en met een grauw gewaad\n" +
                "Van rouw en droefheid achter zich, ging zij\n" +
                "Hoog over de velden en kwam zoo tot mij.\n" +
                "Ik zag haar toen ze stond buiten de stad,\n" +
                "Het kind in hare armen, en ik zat\n" +
                "Niet meer, maar ging tot haar, en ging mee, neven\n" +
                "Haar, zóó hoog dat ik 't kind zag, opgeheven.\n" +
                "En toen wij kwamen bij den grooten stroom\n" +
                "Daalde ik weer, zij legde aan den zoom\n" +
                "Het bleeke kind en wijl ik weende, weende\n" +
                "Mijn oogen en mijn hoofd stuk, ging ze en scheen de\n" +
                "Wereld vol van licht van uit den hemel neer.\n" +
                "Ik wist wat ik zou doen en haar begeer,\n" +
                "En in een boot ging ik den stroom toen af,\n" +
                "In gonzend water door laag land -- daar gaf\n" +
                "Hij 't water in de zee, daar steeg ik uit.\n" +
                "En langs het strand ging ik met haar, geluid\n" +
                "Maakten wij niet, maar werden toch gehoord.\n" +
                "Want uit het land kwamen de elven voort\n" +
                "En uit de lucht de hemelnevelingen,\n" +
                "En uit de zee tritonen en te zingen\n" +
                "Begonnen zij dicht achter mij gezang.\n" +
                "En toen de twalef uren die al lang\n" +
                "Wachtten op haar en op hun droeven plicht:\n" +
                "Ze hadden eene baar en het gezicht\n" +
                "Omhoog, droegen ze haar al ver en verder.\n" +
                "En ik vooraan, ik, die haar goede herder\n" +
                "Geweest was en er achter altijd meer:\n" +
                "Ze kwamen uit de duinen keer op keer\n" +
                "Glijden en dalen en uit alle golven\n" +
                "Staken er Tritons en het lijf bedolven\n" +
                "Zongen en zongen ze het lijkmisbaar.\n" +
                "Totdat we kwamen aan de zeezoom, waar\n" +
                "Zij 't eerst geland was, daar hielden wij stil.\n" +
                "De duinen werden vol en het geril\n" +
                "Van 't eeuwig brandend water stond vol ook,\n" +
                "Lichte gestalten, als verlichte rook\n" +
                "Zweefden er boven ons ook vele om.\n" +
                "Toen speelden eerst de gnomen op hun trom\n" +
                "En toen de elven op hunne cymbalen,\n" +
                "Toen Tritons, toen wij alle saam, verhalen,\n" +
                "Lange verhalen zang en droefenis.\n" +
                "Toen werden de uren van hun taak gewis\n" +
                "En zetten haar daar neer en lieten mij\n" +
                "Met haar alleen en gingen in een rij,\n" +
                "En zagen met de andren samen toe.\n" +
                "Ik groef een graf waar golven komen toe-\n" +
                "Dekken het zand en legde haar daar neer,\n" +
                "Daarover zand: de golven komen weer\n" +
                "En dalen weer met lachen of geschrei --\n" +
                "Daar ligt bedolven mijne kleine Mei. ";
    }
}
