package br.ufpe.cin.atlas.magnifier

import br.ufpe.cin.atlas.magnifier.tools.ExcelParser

class UploaderController {

	def index() {
		println "test"
	}
	
	def uploadPrimaryStudy() {
		println "test2"
		def f = request.getFile('myFile')
	    if (f.empty) {
	        flash.message = 'file cannot be empty'
	        render(view: 'uploadForm')
	        return
	    }
		def newfile = File.createTempFile("PlanilhaFinal",".xlsx")
		newfile.deleteOnExit()
	    f.transferTo(newfile)
		ExcelParser parser = new ExcelParser()
		parser.parsePrimaryStudies2(newfile.absolutePath)
	    [messageFinal: "Done"]
	}
	
	def uploadMechanism() {
		println "test3"
		def f = request.getFile('myFile')
		if (f.empty) {
			flash.message = 'file cannot be empty'
			render(view: 'uploadForm')
			return
		}
		def newfile = File.createTempFile("PlanilhaFinal-Mech",".xlsx")
		newfile.deleteOnExit()
		f.transferTo(newfile)
		ExcelParser parser = new ExcelParser()
		parser.parseMechanisms(newfile.absolutePath)
		[messageFinal: "Done"]
	}
}
