package br.ufpe.cin.atlas.magnifier

class AnalysesController {

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
		def min = params.minCounter? params.minCounter.toInteger() : 2 
		def relevantMech = mechCount.findAll { it.value >= min }
		relevantMech= relevantMech.sort { it.value }
		[ list:mechCount, relevant:relevantMech,  conference:params.conference, minCounter:params.minCounter ]
	}
	
	def authorProductivity() {
		def avalablePrimaryStudy
		if (params.conference != null && params.conference != "All") {
			avalablePrimaryStudy = PrimaryStudy.findAllByConferenceSource(params.conference)
		} else {
			avalablePrimaryStudy = PrimaryStudy.all
		}
		def authorCount = [:]
		avalablePrimaryStudy.each {
			def aPrimaryStudy = it
			it.authors.each {
				if (authorCount.containsKey(it))
					authorCount.get(it).add(aPrimaryStudy)
				else
					authorCount.put(it, [aPrimaryStudy])
			}
		}
		def min = params.minCounter? params.minCounter.toInteger() : 2
		def relevantMech = authorCount.findAll { it.value.size() >= min }
		relevantMech= relevantMech.sort { it.value.size() }
		println relevantMech.keySet()
		[ list:authorCount, relevant:relevantMech,  conference:params.conference, minCounter:params.minCounter ]
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
}
