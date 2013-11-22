package br.ufpe.cin.atlas.magnifier

class Mechanism {
	String mechanismId
	String title
	String venue
	int year	
	String observation
	
	static constraints = {
		mechanismId size: 1..5000
		title  nullable: true
		venue  nullable: true
		year  nullable: true
		observation  nullable: true
	}
}
