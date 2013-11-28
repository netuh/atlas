package br.ufpe.cin.atlas.magnifier

class UsedMechanism {

	String mechanismId
	String title
	int year
	String conferenceSource
	String additionalInformation

	static hasMany = [authors: String]
		
	static constraints = {
		mechanismId size: 1..5000
		title  nullable: true
		year  nullable: true
		conferenceSource  nullable: true
		additionalInformation  nullable: true
	}
}
