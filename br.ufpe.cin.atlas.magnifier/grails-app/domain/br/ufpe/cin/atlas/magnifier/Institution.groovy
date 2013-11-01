package br.ufpe.cin.atlas.magnifier

class Institution {
	
	String name
	String country
	
	static constraints = {
		country  nullable: true
	}
}
