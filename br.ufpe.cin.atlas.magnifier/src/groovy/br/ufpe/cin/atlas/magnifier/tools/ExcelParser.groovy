package br.ufpe.cin.atlas.magnifier.tools

import br.ufpe.cin.atlas.magnifier.AssociationMechanism
import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import br.ufpe.cin.atlas.magnifier.UsedMechanism
import excel.MechanismExcelImporter
import excel.PrimaryStudyExcelImporter

class ExcelParser {
	
	/*
	def parsePrimaryStudies (String filePath){
		def importer = new PrimaryStudyExcelImporter (filePath)
		
		def primaryStudies = [:]
		importer.getBooks().each() {
			if (it["include"] == 'yes') {
				def key = it["id"]
				def currentPrimaryStudy = primaryStudies[key]
				if (currentPrimaryStudy == null) {
					currentPrimaryStudy = new PrimaryStudy()
					currentPrimaryStudy.setStudyId(it["id"])
					currentPrimaryStudy.setTitle(it["title"])
					currentPrimaryStudy.setConferenceSource(it["source"])
					println "Id="+ it["id"]
					println "source="+ it["source"]
					currentPrimaryStudy.setYear(it["year"] == null ? 0 : it["year"].toInteger())
					
					it["empiricalStudy"].split(";").each {
						if (it)
							currentPrimaryStudy.addToStudyTypes(it.toLowerCase())
					}
					//currentPrimaryStudy.setStudyType(it["empiricalStudy"].toLowerCase().replaceAll(";", ""))
					currentPrimaryStudy.setObservation(it["obs"])
					it["authors"].split(";").each { authorName ->
						currentPrimaryStudy.addToAuthors(authorName.replaceAll( /[^0-9a-zA-Z\\,\\. ]/, '' ))
					}
					currentPrimaryStudy.save(failOnError: true)
					//it["institution"].split(";").each { institutionNames ->
					//	def newInstitution = new Institution()
					//	newInstitution.setName(institutionNames)
					//	currentPrimaryStudy.addToIntituitions(newInstitution)
					//}
					primaryStudies.put(key,currentPrimaryStudy)
				}
				if (it["mechRef"] != null && it["mechRef"] != "No mechanisms;" && it["mechRef"] != "No mechanism;") {
					def newMechanism = new Mechanism()
					newMechanism.setContent(it["mechRef"].replaceAll( /[^0-9a-zA-Z\\,\\.\\(\\):-\\'\\" ]/, '' ))
					newMechanism.setMechanismType(it["mechType"] == null ? "No Mechanism Type" : it["mechType"])
					newMechanism.setDefinedByAuthor(it["authorDef"] == "yes")
					newMechanism.setDomain(it["domain"] == null ? "No Domain" : it["domain"])
					newMechanism.setOwner(currentPrimaryStudy)
					currentPrimaryStudy.addToMechanisms(newMechanism)
					currentPrimaryStudy.save(flush:true)
				}
				
			}
		}
	}
	//*/

	
	def parsePrimaryStudies2 (String filePath){
		def importer = new PrimaryStudyExcelImporter (filePath)
		
		importer.getBooks().findAll  { it["include"] == 'yes' }.each {
			def key = it["id"]
			def currentPrimaryStudy = PrimaryStudy.findByStudyId(key)
			if (!currentPrimaryStudy)
				currentPrimaryStudy = new PrimaryStudy()
			if (it["id"])
				currentPrimaryStudy.setStudyId(it["id"])
			if (it["title"])
				currentPrimaryStudy.setTitle(it["title"])
			if (it["source"])
				currentPrimaryStudy.setConferenceSource(it["source"])
			if (it["year"])
				currentPrimaryStudy.setYear(it["year"].toInteger())
			
			if (it["empiricalStudy"]) {
				currentPrimaryStudy?.studyTypes?.clear()
				it["empiricalStudy"].split(";").each {
					if (it)
						currentPrimaryStudy.addToStudyTypes(it.toLowerCase().trim())
				}
			}
			
			if (it["obs"])
				currentPrimaryStudy.setObservation(it["obs"])
			if (it["authors"]) {
				currentPrimaryStudy?.authors?.clear()
				it["authors"].split(";").each { authorName ->
					currentPrimaryStudy.addToAuthors(authorName.replaceAll( /[^0-9a-zA-Z\\,\\. ]/, '' ).toLowerCase().trim())
				}
			}
			currentPrimaryStudy.save(flush:true)
			if (it["mechRef"] != null && it["mechRef"] != "No mechanisms;" && it["mechRef"] != "No mechanism;") {
				def mechRef = it["mechRef"].replaceAll( /[^0-9a-zA-Z\\,\\.\\(\\):-\\'\\" ]/, '' )
				def newMechanism = UsedMechanism.findByMechanismId(mechRef)
				if (!newMechanism){
					newMechanism = new UsedMechanism()
					println "mechRef="+mechRef
					newMechanism.setMechanismId(mechRef)
					newMechanism.save(failOnError: true)
					println "after"
				}
				
				def mechanismAss = currentPrimaryStudy.getMechanisms().find {it.mechanism == newMechanism}
				if (!mechanismAss){
					mechanismAss = new AssociationMechanism()
					mechanismAss.setMechanism(newMechanism)
				} else {
					currentPrimaryStudy.removeFromMechanisms(mechanismAss)
				}
				mechanismAss.setMechanismType(it["mechType"] == null ? "No Mechanism Type" : it["mechType"])
				mechanismAss.setDefinedByAuthor(it["authorDef"] == "yes")
				mechanismAss.setDomain(it["domain"] == null ? "No Domain" : it["domain"])
				mechanismAss.setOwner(currentPrimaryStudy)
				currentPrimaryStudy.addToMechanisms(mechanismAss)
			}
		}
	}

	def parseMechanisms (String filePath){
		def importer = new MechanismExcelImporter (filePath)
		
		importer.getBooks().each {
			def key = it["id"]
			def currentMechanism = UsedMechanism.findByMechanismId(key)
			if (!currentMechanism)
				currentMechanism = new UsedMechanism()
			if (it["id"])
				currentMechanism.setMechanismId(it["id"])
			if (it["title"])
				currentMechanism.setTitle(it["title"])
			if (it["year"])
				currentMechanism.setYear(it["year"].toInteger())

			if (it["authors"]) {
				currentMechanism?.authors?.clear()
				it["authors"].split(";").each { authorName ->
					currentMechanism.addToAuthors(authorName.replaceAll( /[^0-9a-zA-Z\\,\\. ]/, '' ))
				}
			}
			if (it["source"])
				currentMechanism.setConferenceSource(it["source"])
			if (it["information"])
				currentMechanism.setAdditionalInformation(it["information"])
		
			currentMechanism.save(flush:true)
		}
	}
	//*/
}
