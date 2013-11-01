package br.ufpe.cin.atlas.magnifier

class PrimaryStudy {
	String studyId
	String title
	int year
	String studyType
	String observation

	static hasMany = [authors: String, intituitions : Institution, mechanisms : Mechanism]
		
	static constraints = {
		observation  nullable: true
	}
}
