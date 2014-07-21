package br.ufpe.cin.atlas.magnifier

class AnalysesController {

	def generalInfo() {
		def studyTypeMap = [:]
		def avalableStudies
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		
		def yearMap = [:]
		avalableStudies.each {
			if (yearMap.keySet().contains(it.getYear()))
				yearMap.get(it.getYear()).add(it)
			else
				yearMap.put(it.getYear(), [it])
		}
		yearMap= yearMap.sort { it.key}
		[ studyCounter:avalableStudies.size(), yearMap:yearMap, conference:params.conference ]
	}
	
	def badMechanism() {
		def studyTypeMap = [:]
		def avalableStudies
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}

		avalableStudies.each {
			if (!studyTypeMap.containsKey(it.getStudyType())){
				studyTypeMap.put(it.getStudyType(), [it])
			} else {
				studyTypeMap.get(it.getStudyType()).add(it)
			}
		}

		//ef relevantTypes = avalableStudies.findAll { !(it.value.size() >4) }

		def relevantTypes = []
		studyTypeMap.each {
			if (it.value.size() > 4){
				relevantTypes.add(it.key)
			}
		}
		
		relevantTypes.add("All")
		
		[ list:relevantTypes , conference:params.conference ]
	}
	
	def analysesStudyType () {
		def avalableStudies
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		def specificStudies
		
		if (params.studyType == "All")
			specificStudies = avalableStudies
		else
			specificStudies = avalableStudies.findAll  { (it.getStudyTypes().contains(params.studyType)) }
		def withMechism = specificStudies.findAll  { !(it.getMechanisms().isEmpty()) }
		println "size="+withMechism.size()
		def withGuideline = withMechism.findAll  {it.getMechanisms().find {
			it.getMechanismType().toLowerCase() == "guideline"}
		}

		[ studyType:params.studyType, allStudies:specificStudies, withMechism:withMechism, withGuideline:withGuideline, conference:params.conference ]
	}
	
	def predefinedAnalysesStudyType () {
		def relevantTypes = ['experiment', 'survey', 'ethnography', 'case study',
								 'action research', 'systematic studies','mixed methods',
								 'All']
		
		def avalableStudies
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		def specificStudies
		
		if (params.studyType == null || params.studyType == "All" )
			specificStudies = avalableStudies
		else {
			if (params.studyType == 'systematic studies')
				specificStudies = avalableStudies.findAll  { (it.getStudyType().contains("systematic")) }
			else
				specificStudies = avalableStudies.findAll  { (it.getStudyType().contains(params.studyType)) }
		}
		
		def withMechism = specificStudies.findAll  { !(it.getMechanisms().isEmpty()) }
		//def mechisms = withMechism.collect  { it.getMechanisms()?. collect {it.getMechanism()}.asList() }.asList()
		def mechisms = []
		withMechism.each { it.getMechanisms(). each {
			if (!mechisms.contains(it.getMechanism()))
				mechisms<<it.getMechanism()
			}
		}
		def mechismsCount = [:]
		def counters = [:]
		
		mechisms.each {
			def countedMech = it
			def counter = 0
			//mechismsCount.put(it, withMechism.sum { it.getMechanisms()?.count {it.getMechanism() == countedMech}})
			withMechism.each {
				def innerMech = []
				it.getMechanisms().each {
					if (!innerMech.contains(it.getMechanism()))
						innerMech<<it.getMechanism()
				}
				if (innerMech.contains(countedMech))
					++counter
			}
			println "counter = "+ counter
			//counters.put(it, counter)
			mechismsCount.put(it, counter)
		}
		
		//println "counters = "+counters
		
		def poorMech = mechismsCount.count {
			it.value == 1
		}
		mechismsCount= mechismsCount.sort { it.value }
		//println "mechismsCount = "+mechismsCount
		
		mechismsCount = mechismsCount.findAll {
			it.value > 1
		}
		
		println "mechanism more them once = "+ mechismsCount.values().sum()
		println "mechisms = "+ mechisms.size()
		println "Mechanism jist cited once = "+ poorMech
		println "allStudies = "+ specificStudies.size()
		println "witout Mech = "+ (specificStudies.size() - withMechism.size())
		println "withMechism = "+ withMechism.size()
		
		[ studyType:params.studyType, allStudies:specificStudies, withMechism:withMechism, mechanisms:mechismsCount, poorMech:poorMech, conference:params.conference, relevantTypes:relevantTypes ]
	}
	
	def analysesByYear(){
		def mapStudyType2Study = [:]
		def studiesMapByYear = [:]
		def avalableStudies
		
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		
		avalableStudies.each {
			if (!mapStudyType2Study.containsKey(it.getStudyType())){
				mapStudyType2Study.put(it.getStudyType(), [it])
			} else {
				mapStudyType2Study.get(it.getStudyType()).add(it)
			}
		}
		mapStudyType2Study.each { studyType, studies ->
			def mapYear2Study = [:]
			studies.each {
				if (!mapYear2Study.containsKey(it.getYear())){
					mapYear2Study.put(it.getYear(), [it])
				} else {
					mapYear2Study.get(it.getYear()).add(it)
				}
			}
			mapYear2Study= mapYear2Study.sort { it.key}
			studiesMapByYear.put(studyType, mapYear2Study)
		}
		[ list:studiesMapByYear, conference:params.conference ]
	}
	
	def predefinedAnalysesByYear(){
		def mapStudyType2Study = [:]
		def studiesMapByYear = [:]
		def avalableStudies
		
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		
		avalableStudies.each {
			if (!mapStudyType2Study.containsKey(it.getStudyType())){
				mapStudyType2Study.put(it.getStudyType(), [it])
			} else {
				mapStudyType2Study.get(it.getStudyType()).add(it)
			}
		}
		
		def experimentMap = [:]
		def surveyMap = [:]
		def ethnograpMap = [:]
		def caseStudyMap = [:]
		def systematicMap = [:]
		def arMap = [:]
		def mixedMethodMap = [:]
		def notIdentifiedMap = [:]
		def othersMap = [:]
		
		def yearList = []
		
		mapStudyType2Study.each { studyType, studies ->
			def mapYear2Study = [:]
			studies.each {
				if (!mapYear2Study.containsKey(it.getYear())){
					mapYear2Study.put(it.getYear(), [it])
				} else {
					mapYear2Study.get(it.getYear()).add(it)
				}
				
				if (!yearList.contains(it.getYear()))
					yearList.add(it.getYear())
			}
			def mergeYears = {mapStudyType, newelements->
				newelements.each { key, value ->  
					if (!mapStudyType.containsKey(key)){
						mapStudyType.put(key, value)
					} else {
						mapStudyType.get(key).addAll(value)
					}
				}
			}
			if (studyType.contains("experiment")){
				mergeYears(experimentMap,mapYear2Study)
			} else if (studyType == "survey") {
				mergeYears(surveyMap,mapYear2Study)
			} else if (studyType == "ethnography") {
				mergeYears(ethnograpMap,mapYear2Study)
			}else if (studyType == "case study") {
				mergeYears(caseStudyMap,mapYear2Study)
			} else if (studyType == "action research") {
				mergeYears(arMap,mapYear2Study)
			} else if (studyType.contains("systematic") ) {
				mergeYears(systematicMap,mapYear2Study)
			} else if (studyType == "mixed methods" ) {
				mergeYears(mixedMethodMap,mapYear2Study)
			} else if (studyType =="not identified" ){
				mergeYears(notIdentifiedMap,mapYear2Study)
			} else {
				mergeYears(othersMap,mapYear2Study)
			}
		}
		yearList = yearList.sort()
		[ years:yearList, experiment:experimentMap, surveys:surveyMap, 
			ethnographes:ethnograpMap, caseStudies:caseStudyMap, ssStudies:systematicMap,
			ar:arMap, mixedMethods:mixedMethodMap, notIdentified:notIdentifiedMap, others: othersMap,
			conference:params.conference ]
	}
	
	def empiricalStudies() {
		def studiesMap = [:]
		def avalableStudies
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		
		avalableStudies.each {
			if (!studiesMap.containsKey(it.getStudyType())){
				studiesMap.put(it.getStudyType(), [it])
			} else {
				studiesMap.get(it.getStudyType()).add(it)
			}
		}
		[ list:studiesMap , conference:params.conference ]
	}
	
	def predefinedEmpiricalStudies() {
		def studiesMap = [:]
		def avalableStudies
		if (params.conference != null && params.conference != "All") {
			avalableStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalableStudies = PrimaryStudy.all
		}
		
		avalableStudies.each {
			if (!studiesMap.containsKey(it.getStudyType())){
				studiesMap.put(it.getStudyType(), [it])
			} else {
				studiesMap.get(it.getStudyType()).add(it)
			}
		}
		
		def definedStudiesMapGreyscale = ['experiment':'#202020', 'survey':'#303030', 'ethnography':'#505050', 'case study':'#707070',
			'action research': '#909090', 'EBSE': '#B0B0B0','multi-methods': '#C0C0C0',
			'not identified': '#D0D0D0', 'others': '#E0E0E0']
		
		
		def definedStudiesMap = ['experiment':[], 'survey':[], 'ethnography':[], 'case study':[],
								 'action research': [], 'EBSE': [],'meta-analyses': [],
								 'multi-methods': [], 'not identified': [], 'others': []]
		
		studiesMap.each { key, value ->
			if (key.toLowerCase().contains("experiment")){
				println "experiment, for "+ key + " with the amont = "+ value.size()
				definedStudiesMap['experiment'].addAll(value)
			} else if (key == "survey")
				definedStudiesMap.get('survey').addAll(value)
			else if (key.contains("ethnography")){
				definedStudiesMap.get('ethnography').addAll(value)
				println "ethnography, for "+ key + " with the amont = "+ value.size()
			} else if (key.contains("meta-ana")) {
				println "meta-analyses, for "+ key + " with the amont = "+ value.size()
				definedStudiesMap.get('meta-analyses').addAll(value)
			}
			else if (key == "case study")
				definedStudiesMap.get('case study').addAll(value)
			else if (key == "action research")
				definedStudiesMap.get('action research').addAll(value)
			else if (key.contains("systematic") || key.contains("review") || key.contains("tertiary")) {
				println "systematic, for "+ key + " with the amont = "+ value.size()
				definedStudiesMap.get('EBSE').addAll(value)
			} else if (key == "mixed methods" )
				definedStudiesMap.get('multi-methods').addAll(value)
			else if (key =="not identified" )
				definedStudiesMap.get('not identified').addAll(value)
			else {
				definedStudiesMap.get('others').addAll(value)
				println "others, for "+ key + " with the amont = "+ value.size()
			}
		}
		
		[ list:definedStudiesMap, scale: definedStudiesMapGreyscale , conference:params.conference ]
	}
	
	def mechanismUsage() {
		def avalablePrimaryStudy
		if (params.conference != null && params.conference != "All") {
			avalablePrimaryStudy = PrimaryStudy.findAllByConferenceSource(params.conference)
			//.collect {
			//	it.mechanisms.mechanism
			//}.unique()
		} else {
			avalablePrimaryStudy = PrimaryStudy.all
		}
		def mechCount = [:]
		avalablePrimaryStudy.each {
			it.mechanisms.each {
				if (mechCount.containsKey(it.getMechanism()))
					mechCount.put(it.getMechanism(), mechCount.get(it.getMechanism())+1)
				else
					mechCount.put(it.getMechanism(), 1)
			}
		}
		
		println "all mechanisms account = "+ mechCount.keySet().size()
		def min = params.minCounter? params.minCounter.toInteger() : 2 
		def relevantMech = mechCount.findAll { it.value >= min }
		relevantMech= relevantMech.sort { it.value }
		[ list:mechCount, relevant:relevantMech,  conference:params.conference, minCounter:min ]
	}
	
	def authorProductivity() {
		def avalablePrimaryStudy
		if (params.conference != null && params.conference != "All") {
			avalablePrimaryStudy = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalablePrimaryStudy = PrimaryStudy.all
		}
		def allAuthors = [:]
		avalablePrimaryStudy.each {
			def aPrimaryStudy = it
			it.authors.each {
				if (allAuthors.containsKey(it))
					allAuthors.get(it).add(aPrimaryStudy)
				else
					allAuthors.put(it, [aPrimaryStudy])
			}
		}
		def min = params.minCounter? params.minCounter.toInteger() : 2
		def relevantAuthors = allAuthors.findAll { it.value.size() >= min }
		def twoStudyAuthors = allAuthors.findAll { it.value.size() == 1 }
		relevantAuthors= relevantAuthors.sort { it.value.size() }
		println relevantAuthors.keySet()
		println "allAuthors amount  ="+ allAuthors.keySet().size()
		println "authors with 2 or less studies  ="+ twoStudyAuthors.keySet().size()
		[ list:allAuthors, relevant:relevantAuthors,  conference:params.conference, minCounter:params.minCounter ]
	}
	
	def countryProductivity() {
		def avalablePrimaryStudy
		if (params.conference != null && params.conference != "All") {
			avalablePrimaryStudy = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalablePrimaryStudy = PrimaryStudy.all
		}
		def allCountries = [:]
		avalablePrimaryStudy.each {
			def aPrimaryStudy = it
			it.countries.each {
				if (allCountries.containsKey(it))
					allCountries.get(it).add(aPrimaryStudy)
				else
					allCountries.put(it, [aPrimaryStudy])
			}
		}
		def min = params.minCounter? params.minCounter.toInteger() : 2
		def relevantCountries = allCountries.findAll { it.value.size() >= min }
		def twoStudyCountries = allCountries.findAll { it.value.size() == 1 }
		relevantCountries= relevantCountries.sort { it.value.size() }
		println relevantCountries.keySet()
		println "allCountries amount  ="+ allCountries.keySet().size()
		println "Countries with 2 or less studies  ="+ twoStudyCountries.keySet().size()
		[ list:allCountries, relevant:relevantCountries,  conference:params.conference, minCounter:params.minCounter ]
	}
	
	def institutionProductivity() {
		def avalablePrimaryStudy
		if (params.conference != null && params.conference != "All") {
			avalablePrimaryStudy = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalablePrimaryStudy = PrimaryStudy.all
		}
		def allInstitutions = [:]
		avalablePrimaryStudy.each {
			def aPrimaryStudy = it
			it.institutions.each {
				if (allInstitutions.containsKey(it))
					allInstitutions.get(it).add(aPrimaryStudy)
				else
					allInstitutions.put(it, [aPrimaryStudy])
			}
		}
		def min = params.minCounter? params.minCounter.toInteger() : 2
		def relevantInstitutions = allInstitutions.findAll { it.value.size() >= min }
		def twoStudyInstitutions = allInstitutions.findAll { it.value.size() == 1 }
		relevantInstitutions= relevantInstitutions.sort { it.value.size() }
		println relevantInstitutions.keySet()
		println "All institutions amount  ="+ allInstitutions.keySet().size()
		println "institutions with 2 or less studies  ="+ twoStudyInstitutions.keySet().size()
		[ list:allInstitutions, relevant:relevantInstitutions,  conference:params.conference, minCounter:params.minCounter ]
	}
	
	def mechanismByYear() {
		def studyByYear = [:]
		def avalableMechanism = []
		def primaryStudies = []
		if (params.conference != null && params.conference != "All") {
				primaryStudies = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
				primaryStudies = PrimaryStudy.all
		}

		primaryStudies.each {
				def studyYear = it.getYear()
				def studyList;
				if (!studyByYear.containsKey(studyYear)){
						studyList = []
						studyByYear.put(studyYear, studyList)
				} else {
						studyList = studyByYear.get(studyYear)
				}
				if (it.getMechanisms()) {
						studyList.add(it)
				}
		}
		studyByYear= studyByYear.sort { it.key}
		def finalListStudies = []
		studyByYear.each {
				def year = it.key
				def studiesByYear = []
				primaryStudies.each {
						if (it.year == year)
								studiesByYear.add(it)
				}
				finalListStudies.add([year:it.key, mech:it.value.size(), total:studiesByYear.size()])
		}
		[ list:studyByYear, newList : finalListStudies ]
	}
	
	def multMethodDetails() {
		def avalablePrimaryStudy
		if (params.conference != null && params.conference != "All") {
			avalablePrimaryStudy = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalablePrimaryStudy = PrimaryStudy.all
		}
		def multiStudies = avalablePrimaryStudy.findAll { it.studyTypes.size() != 1 }
		
		def multiMethodCount = [:]
		
		multiStudies.each {
			def multSet = it.studyTypes
			multSet = multSet.collect{ if (it.contains("experiment"))
											"experiment"
										else if(it.contains("mapping"))
											"systematic mapping"
										else
											it
			}
			
			if (!multiMethodCount.keySet().contains(multSet)){
				multiMethodCount.put(multSet, 1)
			} else {
				multiMethodCount.put(multSet, multiMethodCount.get(multSet)+1)
			}
		}
		
		println "mult group = "+ multiMethodCount
		
		[ list:multiMethodCount,  conference:params.conference]
	}
}
