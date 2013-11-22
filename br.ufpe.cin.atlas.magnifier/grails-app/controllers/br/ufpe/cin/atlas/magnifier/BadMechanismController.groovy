package br.ufpe.cin.atlas.magnifier

class BadMechanismController {

	def index() {
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

}
