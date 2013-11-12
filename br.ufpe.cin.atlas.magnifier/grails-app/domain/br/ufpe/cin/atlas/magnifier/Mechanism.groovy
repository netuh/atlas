package br.ufpe.cin.atlas.magnifier

class Mechanism {
	String content
	String mechanismType
	Boolean definedByAuthor
	String domain
	
	PrimaryStudy owner
	
	static constraints = {
		content size: 1..5000
	}
}
