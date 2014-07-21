package br.ufpe.cin.atlas.magnifier.tools

import br.ufpe.cin.atlas.magnifier.AssociationMechanism
import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import br.ufpe.cin.atlas.magnifier.UsedMechanism
import excel.MechanismExcelImporter
import excel.PrimaryStudyExcelImporter

class ExcelParser {
	
	def parsePrimaryStudies2 (String filePath){
		
		def importer = new PrimaryStudyExcelImporter (filePath)
		
		importer.getBooks().findAll  { it["include"] == 'yes' }.each {
			def key = it["id"]
			//Missing country and institution
			def currentPrimaryStudy = PrimaryStudy.findByStudyId(key)
			if (!currentPrimaryStudy)
				currentPrimaryStudy = new PrimaryStudy()
			if (it["id"])
				currentPrimaryStudy.setStudyId(it["id"])
			if (it["title"])
				currentPrimaryStudy.setTitle(it["title"])
				
			if (it["country"]){
				currentPrimaryStudy?.authors?.clear()
				it["country"].split(";").each { authorName ->
					currentPrimaryStudy.addToCountries(authorName.replaceAll( /[^0-9a-zA-Z\\,\\. ]/, '' ).toLowerCase().trim())
				}
			}
			
			if (it["institution"]){
				currentPrimaryStudy?.authors?.clear()
				it["institution"].split(";").each { authorName ->
					currentPrimaryStudy.addToInstitutions(authorName.replaceAll( /[^0-9a-zA-Z\\,\\. ]/, '' ).toLowerCase().trim())
				}
			}
			
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
					newMechanism.setMechanismId(mechRef)
					newMechanism.save(failOnError: true)
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
		println "here3"
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
			//if (it["year"])
			//	currentMechanism.setYear(it["year"].toInteger())

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
