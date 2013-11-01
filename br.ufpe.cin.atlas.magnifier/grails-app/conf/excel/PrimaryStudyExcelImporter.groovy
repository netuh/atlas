package excel

import java.util.List
import java.util.Map

import org.grails.plugins.excelimport.*

class PrimaryStudyExcelImporter extends AbstractExcelImporter {

  static Map CONFIG_BOOK_COLUMN_MAP = [
          sheet:'Plan1', 
			 startRow: 1,
          columnMap:  [
                  'A':'id',
                  'B':'title',
                  'C':'year',
				  'D':'authors',
				  'E':'institution',
				  'F':'empiricalStudy',
				  'G':'mechRef',
				  'H':'mechType',
				  'I':'authorDef',
				  'J':'domain',
				  'K':'obs',
				  'L':'include'
          ]
  ]

    //can also configure injection in resources.groovy
	def getExcelImportService() {
		ExcelImportService.getService()
	}

  public PrimaryStudyExcelImporter(fileName) {
    super(fileName)
  }

  List<Map> getBooks() {
    List bookList = excelImportService.columns(workbook, CONFIG_BOOK_COLUMN_MAP)
  }

}