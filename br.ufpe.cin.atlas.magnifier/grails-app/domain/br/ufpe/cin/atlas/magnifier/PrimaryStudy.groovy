package br.ufpe.cin.atlas.magnifier

class PrimaryStudy {
	String studyId
	String title
	String conferenceSource
	int year
	//String studyType
	String observation
	
	//static searchable = true

	static hasMany = [studyTypes: String, authors: String, intituitions : Institution, mechanisms : AssociationMechanism]
		
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
