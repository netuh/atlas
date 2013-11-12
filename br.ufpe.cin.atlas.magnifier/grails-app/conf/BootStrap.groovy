import br.ufpe.cin.atlas.magnifier.Mechanism
import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import excel.PrimaryStudyExcelImporter

class BootStrap {

    def init = { servletContext ->
		def filePath = new File('.').absolutePath + "/data/PlanilhaFinal_Atlas_V5.xlsx"

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
					currentPrimaryStudy.setYear(it["year"] == null ? 0 : it["year"].toInteger())
					currentPrimaryStudy.setStudyType(it["empiricalStudy"].toLowerCase().replaceAll(";", ""))
					currentPrimaryStudy.setObservation(it["obs"])
					it["authors"].split(";").each { authorName ->
						//currentPrimaryStudy.addToAuthors(authorName)
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
				//*
				if (it["mechRef"] != null && it["mechRef"] != "No mechanisms;" && it["mechRef"] != "No mechanism;") {
					def newMechanism = new Mechanism()
					
					//newMechanism.setContent(it["mechRef"])
					newMechanism.setContent(it["mechRef"].replaceAll( /[^0-9a-zA-Z\\,\\.\\(\\):-\\'\\" ]/, '' ))
					//newMechanism.setMechanismType(it["mechType"])
					newMechanism.setMechanismType(it["mechType"] == null ? "No Mechanism Type" : it["mechType"])
					newMechanism.setDefinedByAuthor(it["authorDef"] == "yes")
					//newMechanism.setDomain(it["domain"])
					newMechanism.setDomain(it["domain"] == null ? "No Domain" : it["domain"])
					newMechanism.setOwner(currentPrimaryStudy)
					println "mechRef="+it["mechRef"]
					currentPrimaryStudy.addToMechanisms(newMechanism)
					currentPrimaryStudy.save(flush:true)
					//newMechanism.save(failOnError: true)
				}
				//*/
				
			}
			//println " ${it}"
		}
		println primaryStudies.size()
		//primaryStudies.each() { key, value ->
			//value.save(failOnError: true)
		//	println "key="+key
		//}
    }
    def destroy = {
    }
}
