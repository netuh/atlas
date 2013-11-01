import br.ufpe.cin.atlas.magnifier.Mechanism
import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import excel.PrimaryStudyExcelImporter

class BootStrap {

    def init = { servletContext ->
		def filePath = new File('.').absolutePath + "/data/Atlas_V4.xlsx"
		
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
					currentPrimaryStudy.setYear(it["year"].toInteger())
					currentPrimaryStudy.setStudyType(it["empiricalStudy"].toLowerCase().replaceAll(";", ""))
					currentPrimaryStudy.setObservation(it["obs"])
					it["authors"].split(";").each { authorName ->
						currentPrimaryStudy.addToAuthors(authorName)
					}
					//it["institution"].split(";").each { institutionNames ->
					//	def newInstitution = new Institution()
					//	newInstitution.setName(institutionNames)
					//	currentPrimaryStudy.addToIntituitions(newInstitution)
					//}
					primaryStudies.put(key,currentPrimaryStudy)
				}
				if (it["mechRef"] != null) {
					def newMechanism = new Mechanism()
					newMechanism.setContent(it["mechRef"])
					newMechanism.setMechanismType(it["mechType"])
					newMechanism.setDefinedByAuthor(it["authorDef"] == "yes")
					newMechanism.setDomain(it["domain"])
				}
				
			}
			//println " ${it}"
		}
		println primaryStudies.size()
		primaryStudies.each() { key, value ->
			println "key="+key
			println "value="+value
			value.save(failOnError: true)
		}
    }
    def destroy = {
    }
}
