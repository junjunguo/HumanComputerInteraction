GUI components
==

###GUI-komponenter
-  Brukergrensesnittet bygges gjennom å kombinere ulike typer GUI-komponenter.
	- TeksVelter, avkrysningsbokser, menyer, knapper, sliders, paneler, etc.

-  Gir brukeren mulighet til å interagere med applikasjonen.

###GUI toolkits
-  Brukergrensesnittet bygges gjerne gjennom å kombinere ulike typer GUI-komponenter som tilbys gjennom toolkits.
-  Brukergrensesnittet konstrueres gjerne interaktivt og visuelt ved å dra et ønsket komponent til en ønsket posisjon i grensesnittet.

##Labels
-  Labels brukes for å vise statisk tekst.
-  Bruk Text Box-kontroller dersom applikasjonen din skal vise data (resultat av kalkulasjoner, databaseinnhold, etc.)

##Action buttons
-  Tydeliggjør for brukeren hvilken aksjon en action button leder til.
-  Aksjonen knyttet til en knapp bør ikke endres.
-  Inkonsistent merking av knapper skaper brukbarhetsproblemer.

#####Forslag :
-  OK. Lukker og lagrer data.
-  Cancel. Lukker uten lagring av data.
-  Close. Kun tilgjengelig (enabled) dersom ingen data er blitt fylt inn.
-  Apply: Lagrer data uten å lukke.

#####action buttons:
-  Vis brukeren hvilke action buttons som er tilgjengelige til en hver tid.
-  Bruk ”disable” (“grå ut”) i stedet for å ta bort en knapp fra brukergrensesnittet.
-  Eksempel: Start-knappen blir ikke tilgjenglig igjen før brukeren trykker på stopp-knappen.


##Checkboxes
-  Checkboxes brukes i tillfeller hvor det eksisterer flere alternatilver og brukeren kan velge flere eller ingen (0..N).
-  Hver checkbox er uavhengig av andre checkbokser i den samme listen.

#####Checkboxes vs. radio buttons vs. Drop-down menus
-  Enkeltstående Checkboxes brukes når det kun er ett valg brukeren skal gjøre.


##Radio buttons
- Radio buttons brukes i tillfeller hvor det eksisterer to eller flere valgmuligheter, som gjensidig utelukker hverandre, og hvor brukeren bare kan velge én.

- I en gruppe med radio buttons skal alltid ett av alternativene være forhåndsvalgt (konvensjon).

- Bruk gjerne alternativet som brukeren er mest trolig vil velge Hvis en på forhånd vet at brukere vil velge ”gris”, setter en ”gris” som forhåndsvalgt.
- Øker effektivitet i bruk.
- Kan brukes til å lede brukere som er uerfarne med applikasjonen til å gjøre trygge valg.

- Siden en bruker bare kan velge en radio button er det viktig at alternativene er klart adskilte, og at de dekker hele ”mulighetsrommet”
- Bruk ”andre” som et svaralternativ dersom mulighetsrommet er stort.

#####Checkboxes og radio buttons
-  Presenter valgmuligheter som hører sammen som en gruppe.
-  Lag tydelig skille mellom ulike grupper som vises i samme brukergrensesnitt.


-  Bruk fortrinnsvis visuelle representasjoner som er standardiserte.
	-  Checkboxes er små, kvadratiske og benytter avsjekkingssymbol.
	-  Radio buttons er små, runde og med en tydelig marker runding inni
når de er valgt.
-  Dette anbefales også i mht andre komponenter.

- Presenter alternativer vertikalt med merkelapp (label) siden av.
-  Spesielt når det ikke er en sammen heng naturlig rekkefølge i valg mulighetene (eksempel på unntak: Likert-skala).
-  Et alternativper linje.
-  Hvis du ”må” presentere dem horisontalt;tydelig gjør hvilken merkelapp (label) som tilhører hvilken radiobutton eller checkbox


-  Checkeboxes og radio buttons brukes kun for å gjøre innstillinger.
-  Bør aldri brukes som erstatning for Action buttons.
-  Endringer i innstillinger bør ikke ha effekt før brukeren bekreoer det gjennom å trykke på en aksjonsknapp (f.eks. OK, neste eller lagre)
-  Ved å klikker tilbake (eller kanseller) bør evt. endringer gjort i innstillinger oversees og originalinnspillingene gjenopprettes.
-  Hvis brukeren trykker klikker tilbake og så frem bør dette tolkes om ”angre-gjennopprett”.


##drop-down menus

-  Sparer plass
-  Tydeliggjør hva som er valgt.
-  Begrens antall alternativer i en og samme drop-down menu.
-  Hurtigtaster kan være hensiktsmessig.

##### radio buttons vs drop-down menus
Bruk radio buttons fremfor drop-down menyer hvis det er få alternativer å velge mellom.
-  Alle alternativer er synlige hele tiden.
-  Lett for brukeren å sammenligne alternativene
-  Krever mindre finmotorikk å bruke (sørg for at avkryssing av en checkbox skjer også dersom brukeren klikker på merkelappen).


##Toggle buttons

-  Benyttes for å velge tilstander.
-  Eksempel: TeksFormatering
-  Innenfor en gruppe av Toggle-butuons kan noen kombinasjoner settes til å være gjensidig utelukkende (f.eks superscript og subscript)


#####Toggle buttons vs. Radio-buttons
-  Eksempel: Knapper for stilling av tekst i MS word.
-  Her er alle alternativene gjensidig utelukkende (kun én knapp
i gangen kan være inntrykt).


Hvorfor er toggle buttons mer hensiktsmessig enn radio buttons i dette tilfellet?
-  Svar: For toggle-button er konvensjonen at tilstandsendringen skjer umiddelbart; for radio buttons skjer tilstandsendringen nå brukeren bekreoer det (ved f.eks å klikke OK eller apply).


##Checklist box vs. Listbox
-  Bruk checklist box i stedet for listbox hvis det er mange elementer å velge mellom


##Tab control
-  Kan benyttes for å spare plass i brukergrensesnittet.
-  Hensiktsmessig dersom det er viktig at brukeren må se
annen viktig informasjon i brukergrensesnittet.
-  Viktig at det informasjonen og aksjonene som det er mulig å gjøre på én tab logisk hører sammen.
-  Begrens antallet tabs.

##Dialog boxes
-  Brukes for å gi brukeren viktige tilbakemeldinger han/hun må ta stilling til.
-  Bør tydeligjøre hva som har skjedd eller vil skje, hvorfor, og hva brukeren evt. kan gjøre.


##Overordnede retningslinjer
-  Forhold deg til konvensjonene for bruk av GUI komponenter.
-  Vær konsistent.
-  Less is more!

God design gjør brukermanualer overflødige!
