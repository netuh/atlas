package br.ufpe.cin.atlas.magnifier

class PrimaryStudy {
	String studyId
	String title
	String conferenceSource
	int year
	//String studyType
	String observation
	
	//static searchable = true

	//intituitions : Institution,
	static hasMany = [studyTypes: String, authors: String,
					  mechanisms: AssociationMechanism,
					  institutions: String, countries: String]
		
	static constraints = {
		observation  nullable: true
		mechanisms lazy:false
	}
	
	def getStudyType() {
		if (studyTypes.size() == 1)
			studyTypes.first()
		else
			"mixed methods"
	}
}
