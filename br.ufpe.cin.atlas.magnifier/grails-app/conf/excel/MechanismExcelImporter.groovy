package excel

import java.util.List
import java.util.Map

import org.grails.plugins.excelimport.*

class MechanismExcelImporter extends AbstractExcelImporter {

  static Map CONFIG_BOOK_COLUMN_MAP = [
          sheet:'Plan1', 
			 startRow: 1,
          columnMap:  [
                  'A':'id',
                  'B':'title',
                  'C':'year',
				  'D':'authors',
				  'E':'source',
				  'F':'information',
				  'G':'old'
          ]
  ]

    //can also configure injection in resources.groovy
	def getExcelImportService() {
		ExcelImportService.getService()
	}

  public MechanismExcelImporter(fileName) {
    super(fileName)
  }

  List<Map> getBooks() {
    List bookList = excelImportService.columns(workbook, CONFIG_BOOK_COLUMN_MAP)
  }

}