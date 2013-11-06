package br.ufpe.cin.atlas.magnifier



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PrimaryStudyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PrimaryStudy.list(params), model:[primaryStudyInstanceCount: PrimaryStudy.count()]
    }

    def show(PrimaryStudy primaryStudyInstance) {
        respond primaryStudyInstance
    }

    def create() {
        respond new PrimaryStudy(params)
    }
	
	def analysesByYear(){
		def studiesMap = [:]
		def studiesMapByYear = [:]
		PrimaryStudy.all.each {
			if (!studiesMap.containsKey(it.getStudyType())){
				studiesMap.put(it.getStudyType(), [it])
			} else {
				studiesMap.get(it.getStudyType()).add(it)
			}
		}
		studiesMap.each() { key, value ->
			def studyByYear = [:]
			value.each {
				if (!studyByYear.containsKey(it.getYear())){
					studyByYear.put(it.getYear(), [it])
				} else {
					studyByYear.get(it.getYear()).add(it)
				}
			}
			studiesMapByYear.put(key, studyByYear)
		}
		[ list:studiesMapByYear ]
	}
	
	def empiricalStudies() {
		def studiesMap = [:]
		PrimaryStudy.all.each {
			if (!studiesMap.containsKey(it.getStudyType())){
				studiesMap.put(it.getStudyType(), [it])
			} else {
				studiesMap.get(it.getStudyType()).add(it)
			}
		}
        [ list:studiesMap ]
	}

    @Transactional
    def save(PrimaryStudy primaryStudyInstance) {
        if (primaryStudyInstance == null) {
            notFound()
            return
        }

        if (primaryStudyInstance.hasErrors()) {
            respond primaryStudyInstance.errors, view:'create'
            return
        }

        primaryStudyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'primaryStudyInstance.label', default: 'PrimaryStudy'), primaryStudyInstance.id])
                redirect primaryStudyInstance
            }
            '*' { respond primaryStudyInstance, [status: CREATED] }
        }
    }

    def edit(PrimaryStudy primaryStudyInstance) {
        respond primaryStudyInstance
    }

    @Transactional
    def update(PrimaryStudy primaryStudyInstance) {
        if (primaryStudyInstance == null) {
            notFound()
            return
        }

        if (primaryStudyInstance.hasErrors()) {
            respond primaryStudyInstance.errors, view:'edit'
            return
        }

        primaryStudyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PrimaryStudy.label', default: 'PrimaryStudy'), primaryStudyInstance.id])
                redirect primaryStudyInstance
            }
            '*'{ respond primaryStudyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PrimaryStudy primaryStudyInstance) {

        if (primaryStudyInstance == null) {
            notFound()
            return
        }

        primaryStudyInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PrimaryStudy.label', default: 'PrimaryStudy'), primaryStudyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'primaryStudyInstance.label', default: 'PrimaryStudy'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
