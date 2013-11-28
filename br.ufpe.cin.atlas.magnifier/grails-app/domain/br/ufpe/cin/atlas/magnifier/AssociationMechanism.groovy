package br.ufpe.cin.atlas.magnifier

class AssociationMechanism {
	
	String mechanismType
	Boolean definedByAuthor
	String domain
	
	UsedMechanism mechanism
	
	PrimaryStudy owner
	
	static constraints = {
		//mechanismId size: 1..5000
		//mechanism lazy:false
	}
}
