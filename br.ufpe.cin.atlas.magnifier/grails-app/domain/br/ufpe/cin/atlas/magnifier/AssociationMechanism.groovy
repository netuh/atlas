package br.ufpe.cin.atlas.magnifier

class AssociationMechanism {
	
	String mechanismType
	Boolean definedByAuthor
	String domain
	
	Mechanism mechanism
	
	PrimaryStudy owner
	
	static constraints = {
		//mechanismId size: 1..5000
	}
}
