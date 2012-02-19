package bz.voter.management

import org.grails.plugins.excelimport.ExcelImportService
import org.grails.plugins.excelimport.*

/**
 *
 * @author BOLGU
 */
class VoterExcelImporter extends AbstractExcelImporter {

    ExcelImportService excelImportService = new ExcelImportService()
    
    static Map CONFIG_VOTER_COLUMN_MAP = [
        sheet: 'Sheet1',
                        startRow: 1,
              columnMap: [
                'A':'registrationNumber',
                'B':'registrationDate',
                'D':'lastName',
                'E':'firstName',
                'K':'birthDate',
                'R':'homePhone',
                'S':'comments',
                'F':'sex',
			    'I': 'pollStation',
                'T':'affiliation',
			    'U':'pledge',
                'Q':'identificationType',
                'G':'houseNumber',
                'H':'street',
                'Y':'municipality'
                 ]
                        
    ]
    
    static Map propertyConfigurationMap = [
         registrationDate: ([expectedType: ExpectedPropertyType.DateJavaType, defaultValue:'']),
         registrationNumber: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'']),
         identificationType: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'']),
         affiliation: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'']),
		 firstName: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'']),
		 lastName: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'']),
         homePhone: ([expectedType: ExpectedPropertyType.StringType, defaultValue:null]),
         comments: ([expectedType: ExpectedPropertyType.StringType, defaultValue:null]),
         sex: ([expectedType: ExpectedPropertyType.StringType, defaultValue: '']),
         birthDate: ([expectedType: ExpectedPropertyType.DateJavaType, defaultValue:null]),
         houseNumber: ([expectedType: ExpectedPropertyType.StringType, defaultValue:null] ),
         street: ([expectedType: ExpectedPropertyType.StringType, defaultValue:null]),
         municipality: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'Unknown']),
		 pledge: ([expectedType: ExpectedPropertyType.StringType, defaultValue:'Unknown']),
		 pollStation: ([expectedType: ExpectedPropertyType.StringType, defaultValue: 'N/A'])
    ]
    

    public VoterExcelImporter(fileName3) {
        super(fileName3)
	 	  println "Importing file ${fileName3}"
    }
    
    List<Map> getVoters() {
        List VoterList = excelImportService.convertColumnMapConfigManyRows(workbook, CONFIG_VOTER_COLUMN_MAP, null, null, propertyConfigurationMap)
   // List bookList = ExcelImportUtils.convertColumnMapConfigManyRows(workbook, CONFIG_BOOK_COLUMN_MAP)
        return VoterList
    }
}