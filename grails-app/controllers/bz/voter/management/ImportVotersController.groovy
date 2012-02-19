package bz.voter.management

import grails.converters.JSON

class ImportVotersController {

    def index() { }

    def votersExcel() {
    	def fileName = "/usr/local/files/" + params.file
    	VoterExcelImporter excelImporter = new VoterExcelImporter(fileName)
        def votersMapList = excelImporter.getVoters()
        log.info "Voters from file: ${votersMapList}"
        render votersMapList as JSON
    }
}
