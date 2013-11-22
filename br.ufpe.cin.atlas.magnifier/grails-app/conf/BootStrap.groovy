import br.ufpe.cin.atlas.magnifier.Mechanism
import br.ufpe.cin.atlas.magnifier.PrimaryStudy
import excel.PrimaryStudyExcelImporter

class BootStrap {

    def init = { servletContext ->
		//def filePath = new File('.').absolutePath + "/data/PlanilhaFinal_Atlas_V5.xlsx"

		//ExcelParser parser = new ExcelParser()
		//parser.parsePrimaryStudies(filePath)
    }
    def destroy = {
    }
}
